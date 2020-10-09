package com.cmcc.paymentclean.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Spring工具类
 *
 * @author
 * @date 2015-4-10
 */
@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class SpringUtils
    implements ApplicationContextInitializer,
        ApplicationContextAware,
        InitializingBean,
        ApplicationListener<ContextRefreshedEvent> {

  private static ApplicationContext applicationContext;

  /** applicationContext未初始化完成时需要等待校验的次数 */
  private static final int CHECK_TIMES = 30;

  /** applicationContext未初始化完成时每次等待的毫秒数 */
  private static final long SLEEP_TIME = 1000;

  /**
   * 设置上下文
   *
   * @param applicationContext
   * @throws BeansException
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringUtils.applicationContext = applicationContext;
  }

  /**
   * 返回上下文
   *
   * @param <T>
   * @return
   */
  @SuppressWarnings("unchecked")
  public static <T extends ApplicationContext> T getApplicationContext() {
    checkApplicationContext();

    return (T) applicationContext;
  }

  /** 校验applicationContext是否已经初始化完成，如果未初始化完成将等待30次，每次等1秒 */
  private static void checkApplicationContext() {
    if (Objects.nonNull(applicationContext)) {
      return;
    }

    for (int i = 0; i < CHECK_TIMES; i++) {
      log.warn("applicationContext not init, foreach wait >> " + i);
      try {
        Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) {
        log.error("checkApplicationContext", e);
      }

      if (Objects.nonNull(applicationContext)) {
        return;
      }
    }

    throw new IllegalStateException("applicaitonContext未注入,初始化失败");
  }

  /**
   * 根据bean的name返回bean实例
   *
   * @param <T>
   * @param name
   * @return
   * @throws BeansException
   */
  @SuppressWarnings("unchecked")
  public static <T> T getBean(String name) throws BeansException {
    return (T) getApplicationContext().getBean(name);
  }

  /**
   * 根据bean的name返回bean实例
   *
   * @param <T>
   * @return
   * @throws BeansException
   * @throws ClassNotFoundException
   */
  @SuppressWarnings("unchecked")
  public static <T> T getBeanByClazzPath(String clazzPath)
      throws BeansException, ClassNotFoundException {
    return (T) getApplicationContext().getBean(Class.forName(clazzPath));
  }

  /**
   * 根据bean的name和class类型返回bean实例
   *
   * @param <T>
   * @param name
   * @param requiredType
   * @return
   * @throws BeansException
   */
  public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    return getApplicationContext().getBean(name, requiredType);
  }

  /**
   * 根据class类型返回bean实例
   *
   * @param <T>
   * @param requiredType
   * @return
   * @throws BeansException
   */
  public static <T> T getBean(Class<T> requiredType) throws BeansException {
    return getApplicationContext().getBean(requiredType);
  }

  /**
   * BeanFactory是否包含此name的实例
   *
   * @param name
   * @return
   */
  public static boolean containsBean(String name) {
    return getApplicationContext().containsBean(name);
  }

  /**
   * 根据bean的name判断该bean是否单例
   *
   * @param name
   * @return
   * @throws NoSuchBeanDefinitionException
   */
  public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
    return getApplicationContext().isSingleton(name);
  }

  /**
   * 根据bean的name判断该bean是否多例
   *
   * @param name
   * @return
   * @throws NoSuchBeanDefinitionException
   */
  public static boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
    return getApplicationContext().isPrototype(name);
  }

  /**
   * 根据bean的name判断该bean是否实现了class类型接口
   *
   * @param name
   * @param targetType
   * @return
   * @throws NoSuchBeanDefinitionException
   */
  public static boolean isTypeMatch(String name, Class<?> targetType)
      throws NoSuchBeanDefinitionException {
    return getApplicationContext().isTypeMatch(name, targetType);
  }

  /**
   * 根据bean的name返回该bean的class类型
   *
   * @param name
   * @return
   * @throws NoSuchBeanDefinitionException
   */
  public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
    return getApplicationContext().getType(name);
  }

  /**
   * 根据bean的name返回该bean的别名
   *
   * @param name
   * @return
   */
  public static String[] getAliases(String name) {
    return getApplicationContext().getAliases(name);
  }

  /**
   * 从spring中取bean，没有就注册一个
   *
   * @param <T>
   * @param name
   * @param requiredType
   * @return
   */
  public static <T> T getOrRegisterBean(String name, Class<T> requiredType) {
    if (requiredType == null) {
      return null;
    }

    ConfigurableApplicationContext appContext = getApplicationContext();
    T bean = null;
    try {
      bean = appContext.getBean(name, requiredType);
    } catch (NoSuchBeanDefinitionException e) {

    }

    if (bean == null) {
      DefaultListableBeanFactory beanFactory =
          (DefaultListableBeanFactory) appContext.getBeanFactory();
      BeanDefinitionBuilder beanDefinitionBuilder =
          BeanDefinitionBuilder.genericBeanDefinition(requiredType);
      beanFactory.registerBeanDefinition(name, beanDefinitionBuilder.getRawBeanDefinition());

      bean = appContext.getBean(name, requiredType);
    }

    return bean;
  }

  /**
   * 从spring中取bean，没有就注册一个，bean的name是类名(首字母小写)
   *
   * @param <T>
   * @param requiredType
   * @return
   */
  public static <T> T getOrRegisterBean(Class<T> requiredType) {
    if (requiredType == null) {
      return null;
    }

    String name = StringUtils.uncapitalize(requiredType.getSimpleName()); // 首字母小写
    return getOrRegisterBean(name, requiredType);
  }

  private static boolean bAfterInit = false; // 是否已经初始化完成了

  /**
   * {@inheritDoc}
   *
   * @author 2014-4-28
   * @see ApplicationListener#onApplicationEvent(ApplicationEvent)
   */
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    bAfterInit = true;
  }

  public static boolean isInitComplete() {
    return bAfterInit;
  }

  @Override
  public void afterPropertiesSet() throws Exception {}

  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    log.info("initialize has been inited");
    SpringUtils.applicationContext = applicationContext;
  }
}

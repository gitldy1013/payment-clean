package com.cmcc.paymentclean.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * 代码生成器
 */
@Data
public class CodeGenerator {

    /**
     * 配置文件名
     */
    private static final String APP_PROPERTY = "database.properties";
    /**
     * 项目根路径
     */
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    /**
     * 公共包路径
     */
    private static final String PARENT_PACKAGE = "com.cmcc";
    /**
     * 模块名
     */
    private static final String MODULE = "paymentclean";
    /**
     * 生成java根路径
     */
    private static final String BASE_SRC_ROOT = "/src/main/java/";
    /**
     * 生成xml根路径
     */
    private static final String BASE_MAPPER_ROOT = "/src/main/resources/";
    /**
     * 模板类型
     */
    private static final int TEMPLATE_TYPE = 1;

    /**
     * 数据源配置
     *
     * @return 数据源配置信息
     */
    private static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();

        String resourcePath = PROJECT_PATH + BASE_MAPPER_ROOT + APP_PROPERTY;
        try {
            InputStream inStream = new FileInputStream(new File(resourcePath));
            Properties prop = new Properties();
            prop.load(inStream);

            dsc.setUrl(prop.getProperty("spring.datasource.url"));
            dsc.setDriverName(prop.getProperty("spring.datasource.driver-class-name"));
            dsc.setUsername(prop.getProperty("spring.datasource.username"));
            dsc.setPassword(prop.getProperty("spring.datasource.password"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dsc;
    }

    /**
     * 自定义模板位置
     */
    private String templatePath = "templates/mp/";
    private String controllerTemplate = templatePath + "controller.java";
    private String serviceTemplate = templatePath + "service.java";
    private String serviceImplTemplate = templatePath + "serviceImpl.java";
    private String mapperTemplate = templatePath + "mapper.java";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (ipt != null && !ipt.trim().isEmpty()) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    public void codeGenerate() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + BASE_SRC_ROOT);
        gc.setAuthor(scanner("制作者"));
        gc.setOpen(false);
        gc.setActiveRecord(true);
        gc.setIdType(IdType.AUTO);
        gc.setServiceName("%sService");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        mpg.setDataSource(dataSourceConfig());
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PARENT_PACKAGE);
        pc.setModuleName(MODULE);
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("cmcc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                "/templates/mapper.xml" + ((1 == TEMPLATE_TYPE) ? ".ftl" : ".vm")) {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return PROJECT_PATH + BASE_MAPPER_ROOT + "mapper/" + tableInfo.getEntityName() + ".xml";
            }
        }));
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setXml(null);
        templateConfig.setService(serviceTemplate);
        templateConfig.setServiceImpl(serviceImplTemplate);
        templateConfig.setMapper(mapperTemplate);
        templateConfig.setController(controllerTemplate);
        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    public static void main(String[] args) {
        new CodeGenerator().codeGenerate();
    }
}

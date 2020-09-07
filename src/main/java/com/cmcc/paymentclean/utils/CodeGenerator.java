package com.cmcc.paymentclean.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Data
public class CodeGenerator {

    /**
     * 配置文件名
     */
    private final static String APP_PROPERTY = "database.properties";
    private static String projectPath = System.getProperty("user.dir");
    /**
     * 公共包路径
     */
    private static String parentPackage = "com.cmcc";
    /**
     * 模块名
     */
    private static String module = "paymentclean";

    /**
     * 自定义模板位置
     */
    private String templatePath = "templates/mp/";
    private String xmlTemplate = templatePath + "mapper.xml.ftl";
    private String controllerTemplate = templatePath + "controller.java";
    private String serviceTemplate = templatePath + "service.java";
    private String serviceImplTemplate = templatePath + "serviceImpl.java";
    private String mapperTemplate = templatePath + "mapper.java";


    private static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();

        String resourcePath = System.getProperty("user.dir") + "/src/main/resources/" + APP_PROPERTY;
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
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static int scanner() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("==代码生成, 输入 0 表示使用 Velocity 引擎==");
        help.append("\n对照表：");
        help.append("\n0 = Velocity 引擎");
        help.append("\n1 = Freemarker 引擎");
        help.append("\n请输入：");
        System.out.println(help.toString());
        int slt = 0;
        // 现在有输入数据
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if ("1".equals(ipt)) {
                slt = 1;
            }
        }
        return slt;
    }

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        int result = scanner();
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(projectPath + "/src/main/java")//输出目录
                        .setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        //.setKotlin(true) 是否生成 kotlin 代码
                        .setAuthor("ldy")
                        .setSwagger2(true)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                // .setEntityName("%sEntity");
                // .setMapperName("%sDao")
                // .setXmlName("%sDao")
                // .setServiceName("MP%sService")
                // .setServiceImplName("%sServiceDiy")
                // .setControllerName("%sAction")
        ).setDataSource(dataSourceConfig()).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        // .setDbColumnUnderline(true)//全局下划线命名
                        .setTablePrefix(new String[]{"pcac"})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        // .setInclude(new String[] { "user" }) // 需要生成的表
                        // .setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体父类
                        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                        // 自定义实体，公共字段
                        .setSuperEntityColumns(new String[]{"id"})
                        .setTableFillList(tableFillList)
                // 自定义 mapper 父类
                // .setSuperMapperClass("com.baomidou.demo.TestMapper")
                // 自定义 service 父类
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                // 自定义 service 实现类父类
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                // 自定义 controller 父类
                // .setSuperControllerClass("com.baomidou.demo.TestController")
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                // .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        .setModuleName(module)
                        .setParent(parentPackage)// 自定义包路径
                        .setController("controller")// 这里是控制器包名，默认 web
        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("cmcc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                        "/templates/mapper.xml" + ((1 == result) ? ".ftl" : ".vm")) {
                    // 自定义输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return "D:/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
                    }
                }))
        ).setTemplate(
                // 关闭默认xml生成，调整生成至根目录
                new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                // .setController("...");
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
        );
        // 执行生成
        if (1 == result) {
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        }
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("cmcc"));
    }

}
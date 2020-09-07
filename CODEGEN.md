# 基于mybatis-plus的springboot代码生成器
[![release](https://img.shields.io/badge/release-1.0.0-green)](https://github.com/misterchaos/springboot-mybatis-plus-generator)
[![release](https://img.shields.io/badge/version-beta-orange)](https://github.com/misterchaos/springboot-mybatis-plus-generator/releases)
[![release](https://img.shields.io/badge/build-passing-green)](https://github.com/misterchaos/springboot-mybatis-plus-generator/releases)
![](https://img.shields.io/badge/license-Apache-blue)

## :droplet:Overview

这是一个基于mybatis-plus官方的AutoGenerator代码生成器+定制代码模板的[springboot代码生成器](https://github.com/misterchaos/springboot-mybatis-plus-generator)。

**使用这个生成器你可以在1分钟之内生成数据库表对应的实体类，以及Mapper，Service，Controller层的基本CURD代码，并可以立即运行测试接口。**

如果你不了解什么是mybatis-plus，请参考[官方文档](https://mp.baomidou.com/)

本代码生成器具有以下优点：

- 只需三步，即可开始测试CURD接口
- 生成的代码风格良好，注释详细（遵循阿里巴巴开发规范）
- 带有程序执行日志打印和错误日志打印

## :star:Features

- 实现controller restful风格CURD接口
- service层CURD对IService的方法再次封装，方便添加业务逻辑
- serviceImpl中方法实现执行日志打印
- mapper模板在官方模板基础上加入@mapper注解
- 各模板方法添加Javadoc注释
- 实现分页查询，关键词模糊查询（需自定义字段）
## :point_right:Quick Start

**使用步骤：**

- 修改application.properties配置文件，设置数据库信息
```
#DataSource Config
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/flower?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT
spring.datasource.username=root
spring.datasource.password=
```
- 运行CodeGenerator类，输入Author，输入数据库表名
- 运行SpringbootMybatisPlusGeneratorApplication,测试接口

> 注意：数据库表必须符合以下规范<br>
> 每张表的主键命名为 表名_id 如: user_id
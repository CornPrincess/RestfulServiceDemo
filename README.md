# RestfulServiceDemo

 本项目利用springboot+springmvc实现restful风格的服务，主要实现以下的API。

||RestfulCRUD|Method|
|:---|:---|:---|
|查询|/emp|GET|
|添加|/emp|POST|
|修改|/emp/{id}|PUT|
|删除|/emp/{id}|DELETE|

员工资源对应的API

| 实验功能                             | 请求URI | 请求方式 |
| :------------------------------------ | :------- | :-------- |
| 查询所有员工                         | emps    | GET      |
| 查询某个员工(来到修改页面)           | emp/1   | GET      |
| 来到添加页面                         | emp     | GET      |
| 添加员工                             | emp     | POST     |
| 来到修改页面（查出员工进行信息回显） | emp/1   | GET      |
| 修改员工                             | emp     | PUT      |
| 删除员工                             | emp/1   | DELETE   |

# 环境约束
- JDK: java version "1.8.0_151"
- Maven: Apache Maven 3.5.2
- IDEA: IntelliJ IDEA 2017.3.4 x64
- SpringBoot: 1.5.16 GA 


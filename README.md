# 1. 部署包
[ueap_1.3.0_20160119.tar.gz](http://pan.baidu.com/s/1skaD7NR) 密码：y67l

# 2. 数据导入
导入 uapweb、secu、ishare 3个用户下的数据。
* uapweb 是采集用户，保存所有采集相关的配置、日志等数据；
* secu 是配置服务器用户，Superdiamond 的配置数据保存在此用户；
* ishare 是基础框架用户，保存用户、角色、机构等通用表。

### Oracle
* 创建ishare，secu，uapweb用户，并赋予权限。
```
create user ishare identified by ishare;
create user secu identified by secu;
create user uapweb identified by uapweb;
grant create session,resource,dba to ishare;
grant create session,resource,dba to secu;
grant create session,resource,dba to uapweb;
```
* 创建表空间TBS_OIP
* 导入数据
用对应账户登录 PL/SQL 导入 PDE文件（ishare.pde,secu.pde,uapweb.pde），打开 Tools > Import tables > PL/SQL Developer，导入前选择 Truncate tables.

### MySQL
* 创建待导入的数据库uapweb、ishare、secu，创建时字符集选择utf-8
* 切换数据库use database(database是你想导入的数据库)
* 执行数据库脚本中的 SQL

# 3. 应用部署
上传压缩包到服务器上解压文件，然后进入 ueap 目录下，以下操作必须在 ueap 目录下进行！

1. 启动 Zookeeper
`./01.start-zookeeper.sh`
2. 启动 Redis
`./02.start-redis.sh`
3. 配置 Superdiamond 数据库连接： super-diamond/conf/META-INF/res/config-production.properties
4. 启动 Superdiamond
`./03.start-superdiamond.sh`
5. 登录 Superdiamond 配置 jdbc、Zookeeper、Redis 等参数
6. 配置 改前台应用、master、worker 的 Superdiamond 地址
> 前台应用：tomcat-ueap/bin/catalina.sh
master：ueap-collect/ueap-collect-master/bin/env.sh
worker：ueap-collect/ueap-collect-worker/bin/env.sh & ueap-collect/ueap-collect-worker2/bin/env.sh
6. 启动 master
`./05.start-collectmaster.sh`
7. 启动 worker
`./06.start-collectworker.sh`

# 4. MySQL 部署配置
如果数据库是 MySQL，除了上面的步骤需要做如下调整：

1. 修改 Superdiamond Hibernate 方言
> 路径：super-diamond/conf/META-INF/res/config-production.properties
参数：hibernate.dialect
值：org.hibernate.dialect.MySQLDialect

2. 登录 Superdiamond 修改 ueap - production 对应的 Hibernate 方言
> 参数：hibernate：hibernate.dialect
值：org.hibernate.dialect.MySQLDialect

3. 修改 Master Quartz 配置
> 路径：ueap-collect/ueap-collect-master/conf/quartz.properties
参数：org.quartz.jobStore.driverDelegateClass
值：org.quartz.impl.jdbcjobstore.StdJDBCDelegate

4. 修改 tomcat-ueap 分页构造器
> 路径：tomcat-ueap/webapps/ROOT/WEB-INF/classes/META-INF/spring/ueap-context.xml
参数：sqlBuilder
值：com.starit.common.dao.jdbc.support.MysqlSqlBuilder

#5. 常见问题
1. 端口冲突
各模块端口修改配置文件
>Zookeeper：conf/zoo.cfg
Redis：redis.conf
Superdiamond：conf/META-INF/res/config-production.properties &conf/tomcat.properties
tomcat-ueap：bin/catalina.sh
masetr & worker：bin/env.sh
2. tomcat 启动失败，提示Superdiamond问题
确认防火墙是否关闭

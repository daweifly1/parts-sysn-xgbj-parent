# 配件商城后台 parts-rm-back-parent 

# 工程结构说明

开发环境修改配置刷新：curl -X POST http://admin:123456@10.90.1.150:8550/actuator/bus-refresh

curl -X POST http://admin:123456@10.90.1.251:8550/actuator/bus-refresh

包含模块
**parts-rm-back-api** 对外的接口和vo对象（feigin）
**parts-rm-back**  业务逻辑实现工程

业务逻辑在包cn.com.xgit.parts.rm.module下根据业务紧密程度划分
如
cn.com.xgit.parts.rm.module.user 用户相关信息
cn.com.xgit.parts.rm.module.goods 商品相关信息
...

cn.com.xgit.parts.rm.common 包下包含本业务会用到的公共方法，一些方法若底层提供可以替换掉。

cn.com.xgit.parts.rm.config.cache.RedisConfigure 覆盖基础start包中的序列化设置。参考测试cn.com.xgit.parts.rm.module.user.controller.AccountExtControllerTest.redisSerializerTest

cn.com.xgit.parts.rm.listener.ApplicationStartupListener 目前无逻辑。

## 以java方式启动工程

1. 查看[bootstrap](parts-rm-back/src/main/resources/bootstrap.yml) 确保eureka、${RABBITMQ:rabbitmq},${SWAGGER:swagger},${SERVICE_CONFIG:${spring.application.name}}
这些服务正常。

2. 编译打包，在工程 parts-rm-back-parent 执行 mvn  clean package 即可。
   以[SpringBoot启动main入口](parts-rm-back/src/main/java/cn/com/xgit/parts/rm/PartsBackApplication.java)
   
   常见编译错误排除：
   工程引入checkstyle目的为了风格尽可能一致，若遇到编译错误可以根据提示检查应的格式是否符合。
   
   ***提交代码前请务必编译通过***
   
## 单元测试
推荐写单元测试


## 注意事项
1.新启异步线程请参考  cn.com.xgit.parts.rm.common.thread.ThreadPool.exec


## 其他注意事项
1. ID生成，目前推荐根据业务判断，数据量较少（10w内）使用数据库自增长策略。
   工程提供[雪花算法实现](parts-rm-back/src/main/java/cn/com/xgit/parts/rm/common/mysql/MybatisKeyGenerator.java)为暂定，
   此待抽出使用公共服务。
 
2. 关于逻辑删除，不推荐使用逻辑删除，请记录操作日志。
   原因：
       1.许多存在唯一生效的数据建议添加数据唯一索引，不用被逻辑删除的逻辑影响
       2.不确定用户群体删除的使用频率，往往某些用户删除的数据比实际生效的数据还多。
       3.逻辑删除原则上也不会在被恢复的，记录操作日志可以解决追溯误删问题。  
  
3. 开发中有相关通用功能请在该文档中备注，团队可以考虑是否将其作公共服务。




模板文件：
 http://10.100.2.109:8084/客户导入.xlsx
 http://10.100.2.109:8084/商品导入.xlsx

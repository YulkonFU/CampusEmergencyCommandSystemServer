### 如何使用线上NACOS配置中心

> 各服务端口:
>
> gateway: 80
>
> auth: 8003
>
> admin: 8002
>
> event: 8001
> 
> watchkeeper: 8004
>
> panel: 8005
> 
> supply: 8006
> 
> plan: 8007
> 


1. 引入如下依赖

   ```xml
   <!-- 配置中心 -->
   <dependency>
       <groupId>com.alibaba.cloud</groupId>
       <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
   </dependency>
   ```

   

2. 在resources文件夹下新建`bootstrap.yml` 文件,在其中写入如下配置:

```yaml
server:
  port: 8000

spring:
  application:
    name: cecs-gateway
  cloud:
    nacos:
      discovery:
        server-addr: http://nat.ckxgzxa.top:33300
        username: rst
        password: rst
      config:
        server-addr: http://nat.ckxgzxa.top:33300
        file-extension: yaml
        group: DEFAULT_GROUP
        prefix: ${spring.application.name}

```

并更改端口号和应用名即可完成本地配置

3. 进入<http://nat.ckxgzxa.top:33300/nacos>页面,登录之后点击配置管理

![](https://zxastaticpages.oss-cn-beijing.aliyuncs.com/blogpictures/202207020242752.png)

随后点击加号新增配置,

4. 将DATA-ID命名为应用名+`.yaml`,并在配置内容中复制粘贴原本地配置即可

![](https://zxastaticpages.oss-cn-beijing.aliyuncs.com/blogpictures/202207020245815.png)



### 如何启动

按照`cecs-gateway`, `cecs-admin`, `cecs-auth` 顺序启动各主类即可
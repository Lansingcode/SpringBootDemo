# SpringBootDemo

一套 Spring Boot 学习练习。仓库由 10 个独立的 Maven 模块组成，每个模块演示一个知识点，可以按需单独运行。

## 使用场景

- **系统学习 Spring Boot：** 按下方的学习路线，从项目搭建逐步学到自动配置原理。
- **理解底层机制：** 通过可运行的小例子观察条件装配、`@Enable*`、IoC 容器和依赖注入。
- **查阅写法：** 需要读取配置、切换环境、整合 Redis 或 MyBatis 时，可以直接参考对应模块。
- **动手实验：** 模块之间基本互不影响，适合修改代码后观察结果。

本项目不是业务系统或生产脚手架。示例中的账号、密码和业务逻辑都只用于练习，不要直接用于生产环境。

## 模块说明

| 模块 | 知识点 | 适合什么时候看 |
|---|---|---|
| `springboot-init` | Web 接口；用 `@Value`、`Environment`、`@ConfigurationProperties` 读取配置 | 刚开始学，或想了解读取配置的几种方式 |
| `springboot-config` | 在配置文件中修改端口 | 了解配置文件的基本用法 |
| `springboot-profiles` | 用 `dev`、`prod` 区分环境配置 | 不同环境需要不同配置 |
| `springboot-test` | 用 `@SpringBootTest` 测试 Service | 编写集成测试 |
| `springboot-redis` | 用 `RedisTemplate` 读写数据 | 整合 Redis |
| `springboot-mybatis` | MyBatis 的注解和 XML 两种查询方式 | 整合 MySQL 和 MyBatis |
| `springboot-condition` | `@Conditional`、自定义条件注解、`@ConditionalOnProperty` | 了解 Bean 如何按条件创建 |
| `springboot-enable-other` | `@EnableUser`，内部使用 `@Import` | 与 `springboot-enable` 配合阅读 |
| `springboot-enable` | 通过 `@EnableUser` 加载另一个模块的配置 | 了解 `@Enable*` 的原理 |
| `spring-ioc-appcontext` | 用 `beans.xml` 声明 Bean 并注入依赖 | 了解不依赖注解扫描的 IoC 容器用法 |

## 学习路线

1. **基础用法：** `springboot-init` → `springboot-config` → `springboot-profiles` → `springboot-test`
2. **整合组件：** `springboot-redis` → `springboot-mybatis`
3. **自动配置原理：** `springboot-condition` → `springboot-enable-other` → `springboot-enable`
4. **容器基础：** `spring-ioc-appcontext`

## 环境要求

- JDK 17 或更高版本
- Maven 3.6.3 或更高版本
- Redis：运行 `springboot-redis` 的测试时需要，地址为 `127.0.0.1:6379`
- MySQL：运行 `springboot-mybatis` 时需要，要有 `springboot` 库和 `t_user` 表（字段为 `id`、`username`、`password`），连接信息在该模块的 `application.yml` 中

## 运行方式

根目录没有父 `pom.xml`，需要进入具体模块后再运行：

```bash
cd springboot-init
mvn spring-boot:run
```

启动后可以访问接口：

```bash
curl http://127.0.0.1:8081/hello
```

以下模块的运行方式有所不同：

**`springboot-profiles`：指定环境启动**

```bash
cd springboot-profiles
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

`dev` 使用 8088 端口，`prod` 使用 8082 端口。

**`springboot-redis`、`springboot-mybatis`、`springboot-test`：通过测试运行示例**

```bash
cd springboot-mybatis
mvn test
```

**`springboot-enable`：先安装依赖的模块**

```bash
cd springboot-enable-other
mvn install -DskipTests -Dspring-boot.repackage.skip=true

cd ../springboot-enable
mvn spring-boot:run
```

这里需要 `-Dspring-boot.repackage.skip=true`，因为重新打包后的 Spring Boot 可执行 jar 不能作为普通依赖使用。

**`spring-ioc-appcontext`：控制台程序**

```bash
cd spring-ioc-appcontext
mvn spring-boot:run
```

程序加载 `beans.xml`，模拟一次用户登录，打印结果后退出。`beans.xml` 中声明了 `dataSource`，但当前代码不会用它连接数据库，因此不需要启动 MySQL。

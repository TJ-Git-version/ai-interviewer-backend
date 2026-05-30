# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

AI面试官后端服务，基于 Spring Boot 3.2.12 + Java 21 构建的多模块 Maven 项目。

## Build Commands

```bash
# 构建所有模块
mvn clean package

# 构建跳过测试
mvn clean package -DskipTests

# 构建单个模块 (在项目根目录)
mvn clean package -pl api -am

# 运行主应用
cd api && mvn spring-boot:run
```

## Architecture

```
api          # 启动模块，Controller 层，端口 9100，不能写具体业务
service      # 业务逻辑层，Service 接口和实现
mapper       # 数据访问层，MyBatis Mapper 接口
model        # 实体层，包含 Entity、DTO、VO、Common、Enums
common       # 公共模块，配置类、工具类
```

依赖关系：`api` -> `service` -> `mapper` -> `model`，`common` 被所有模块依赖

## Model 模块包结构

```
model/src/main/java/com/itfelix/model/
├── entity/          # 实体类（对应数据库表）
├── dto/             # 数据传输对象（接收前端请求）
├── vo/              # 视图对象（返回给前端）
├── common/          # 通用响应封装（Result、PageResult）
└── enums/           # 枚举类（如状态枚举）
```

**注意**：禁止在 api 模块下直接创建 dto/vo/common/enums，必须放在 model 模块下

## Database

- **ORM**: MyBatis-Plus 3.5.15
- **连接池**: HikariCP (配置见 `api/src/main/resources/application.yml`)
- **迁移工具**: Flyway (SQL 脚本放在 `api/src/main/resources/db/migration/`)
- **命名规范**: SQL 文件命名 `V<版本号>__<描述>.sql`

## API Documentation

- Knife4j 文档: http://localhost:9100/doc.html
- Basic 认证: admin/admin

## Configuration

- 主配置: `api/src/main/resources/application.yml`
- 支持多环境: `application-dev.yml`, `application-prod.yml`, `application-test.yml`
- Jackson 日期格式: `yyyy-MM-dd HH:mm:ss`，时区 GMT+8

## 请求与响应规范
- 前端传参使用dto，参数校验时要使用Validator中的@NotNull、@Size等注解，并添加异常内容
- 后端返回给前端使用vo
- 后端业务处理对象使用bo，如果dto能解决就可以不用
- 业务逻辑中不要出现大量的普通方法，如果能使用DDD充血模型尽量采用这个思想

## API 设计规范
- **Knife4j 注解**：所有 DTO/VO/Controller 必须添加 `@Schema`、`@Tag`、`@Operation` 等注解，方便前端调试
- **查询参数封装**：列表查询参数必须抽取为独立的 QueryDTO，不能直接在 Controller 方法参数列表中传递多个查询条件
- **状态码枚举**：所有状态字段（如启用/禁用）必须使用枚举类，禁止硬编码 `0`/`1`
- **分页响应封装**：分页接口必须使用专门的 PageResult 封装类，禁止使用 `Map<String, Object>` 作为返回类型
- **分页方式**：必须使用 PageHelper 插件，禁止使用 MyBatis-Plus 的 `Page<>` 手动分页
- **链表查询**：需要关联查询的必须编写 XML SQL 实现，禁止在 Java 代码中循环查询
- **日期格式**：LocalDateTime 类型字段在 VO 中必须添加 `@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")` 注解，确保响应格式统一

### 通用响应结构
```java
// 统一响应封装（放在 model/common/ 目录下）
@Data
@Schema(description = "统一响应封装")
public class Result<T> {
    private int code;
    private String message;
    private T data;
}

// 分页响应封装
@Data
@Schema(description = "分页响应封装")
public class PageResult<T> {
    private List<T> records;
    private Long total;
    private Long page;
    private Long pageSize;
}

// 状态枚举（放在 model/enums/ 目录下，code 使用 Integer 类型）
public enum StatusEnum {
    DISABLED(0, "禁用"),
    ENABLED(1, "启用");
    private final Integer code;
    private final String description;
}
```

### 分页查询示例
```java
// Service 实现
public PageResult<InterviewQuestionVO> list(InterviewQuestionQueryDTO queryDTO) {
    PageInfo<InterviewQuestionVO> pageInfo = PageHelper.startPage(queryDTO.getPage(), queryDTO.getPageSize())
            .doSelectPageInfo(() -> baseMapper.selectQuestionPage(queryDTO));

    return PageResult.ok(pageInfo.getList(), pageInfo.getTotal(),
            (long) pageInfo.getPageNum(), (long) pageInfo.getPageSize());
}
```

### 包路径规范
- Entity: `com.itfelix.model.InterviewQuestion`
- DTO: `com.itfelix.model.dto.InterviewQuestionCreateDTO`
- VO: `com.itfelix.model.vo.InterviewQuestionVO`
- Common: `com.itfelix.model.common.Result`
- Enums: `com.itfelix.model.enums.StatusEnum`
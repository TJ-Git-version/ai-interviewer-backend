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
api          # 启动模块，Controller 层，端口 9100
service      # 业务逻辑层，Service 接口和实现
mapper       # 数据访问层，MyBatis Mapper 接口
model        # 实体层，Entity 类
common       # 公共模块，配置类、工具类
```

依赖关系：`api` -> `service` -> `mapper` -> `model`，`common` 被所有模块依赖

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
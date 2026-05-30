drop table if exists interviewer;
create table interviewer
(
    id          bigint       not null auto_increment comment '面试官ID',
    name        varchar(64)  not null comment '面试官名称',
    image       varchar(255) not null comment '面试官形象图',
    create_time timestamp    not null default current_timestamp comment '创建时间',
    update_time timestamp    not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    unique key uk_name (name)
) comment ='数字人面试官表';

drop table if exists job;
create table job
(
    id             bigint       not null auto_increment comment '职位ID',
    interviewer_id int(11)      not null comment '面试官ID',
    name           varchar(64)  not null comment '职位名称',
    status         tinyint      not null comment '职位状态：0-关闭，1-开启',
    description    varchar(255) not null comment '职位描述',
    prompt         varchar(512) not null comment '提示词前缀',
    create_time    timestamp    not null default current_timestamp comment '创建时间',
    update_time    timestamp    not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    unique key uk_name (name),
    index idx_interviewer_id (interviewer_id)
) comment ='职位表';

drop table if exists candidate;
create table candidate
(
    id          bigint      not null auto_increment comment '候选人ID',
    job_id      bigint      not null comment '职位ID',
    name        varchar(64) not null comment '候选人名称',
    id_card     varchar(18) not null comment '身份证',
    gender      tinyint     not null comment '性别：0-女，1-男，2-未知',
    phone       varchar(11) not null comment '手机号',
    email       varchar(64) not null comment '邮箱',
    birth_date  date                 default null comment '出生日期',
    create_time timestamp   not null default current_timestamp comment '创建时间',
    update_time timestamp   not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    unique key uk_name (name),
    index idx_job_id (job_id)
) comment ='候选人表';

drop table if exists interview_record;
create table interview_record
(
    id             bigint    not null auto_increment comment '面试记录ID',
    candidate_id   bigint    not null comment '候选人ID',
    interviewer_id bigint    not null comment '面试官ID',
    total_time     int       not null comment '总耗时',
    interview_time timestamp not null default current_timestamp comment '面试时间',
    create_time    timestamp not null default current_timestamp comment '创建时间',
    update_time    timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    index idx_candidate_id (candidate_id),
    index idx_interviewer_id (interviewer_id),
    index idx_interview_time (interview_time)
) comment ='面试记录表';

drop table if exists interview_record_question;
create table interview_record_question
(
    id                       bigint        not null auto_increment comment '面试记录问题ID',
    interview_record_id      bigint        not null comment '面试记录ID',
    interview_question_id    bigint        not null comment '面试题ID',
    question                 varchar(255)  not null comment '面试题',
    reference_answer         varchar(2000) not null comment '参考答案',
    ai_interviewer_video_url varchar(255)  not null comment '数字人视频地址',
    create_time              timestamp     not null default current_timestamp comment '创建时间',
    update_time              timestamp     not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    index idx_interview_record_id (interview_record_id),
    index idx_interview_question_id (interview_question_id)
) comment ='面试记录问题表';

drop table if exists interview_question;
create table interview_question
(
    id                       bigint        not null auto_increment comment '面试题ID',
    interviewer_id           bigint        not null comment '面试官ID',
    question                 varchar(255)  not null comment '面试题',
    reference_answer         varchar(2000) not null comment '参考答案',
    ai_interviewer_video_url varchar(255)  not null comment '数字人视频地址',
    status                   tinyint       not null comment '状态：0-禁用，1-启用',
    create_time              timestamp     not null default current_timestamp comment '创建时间',
    update_time              timestamp     not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    index idx_interviewer_id (interviewer_id)
) comment ='面试题库表';



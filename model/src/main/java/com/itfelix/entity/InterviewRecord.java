package com.itfelix.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 面试记录表
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Getter
@Setter
@ToString
@TableName("interview_record")
public class InterviewRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 面试记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 应聘者ID
     */
    @TableField("candidate_id")
    private Long candidateId;

    /**
     * 面试官ID
     */
    @TableField("interviewer_id")
    private Long interviewerId;

    /**
     * 面试总耗时，单位：秒
     */
    @TableField("take_time")
    private Integer takeTime;

    /**
     * 应聘者回答内容内容
     */
    @TableField("content")
    private String content;

    /**
     * Ai-面试结果详情
     */
    @TableField("result")
    private String result;

    /**
     * 面试时间
     */
    @TableField("interview_time")
    private LocalDateTime interviewTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
}

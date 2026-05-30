package com.itfelix.model.entity;

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
 * 面试题库表
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Getter
@Setter
@ToString
@TableName("interview_question")
public class InterviewQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 面试题ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 面试官ID
     */
    @TableField("interviewer_id")
    private Long interviewerId;

    /**
     * 面试题
     */
    @TableField("question")
    private String question;

    /**
     * 参考答案
     */
    @TableField("reference_answer")
    private String referenceAnswer;

    /**
     * 数字人视频地址
     */
    @TableField("ai_interviewer_video_url")
    private String aiInterviewerVideoUrl;

    /**
     * 状态：0-禁用，1-启用
     */
    @TableField("status")
    private Byte status;

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

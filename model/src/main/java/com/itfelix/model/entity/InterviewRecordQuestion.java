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
 * 面试记录问题表
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Getter
@Setter
@ToString
@TableName("interview_record_question")
public class InterviewRecordQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 面试记录问题ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 面试记录ID
     */
    @TableField("interview_record_id")
    private Long interviewRecordId;

    /**
     * 面试题ID
     */
    @TableField("interview_question_id")
    private Long interviewQuestionId;

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

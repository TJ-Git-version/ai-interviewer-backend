package com.itfelix.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "面试题VO")
public class InterviewQuestionVO {
    @Schema(description = "面试题ID")
    private Long id;

    @Schema(description = "面试官ID")
    private Long interviewerId;

    @Schema(description = "面试官名称")
    private String interviewerName;

    @Schema(description = "面试题")
    private String question;

    @Schema(description = "参考答案")
    private String referenceAnswer;

    @Schema(description = "数字人视频地址")
    private String aiInterviewerVideoUrl;

    @Schema(description = "状态：0-禁用，1-启用")
    private Integer status;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
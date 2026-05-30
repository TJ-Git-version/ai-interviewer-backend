package com.itfelix.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "面试题创建/更新DTO")
public class InterviewQuestionCreateDTO {
    @Schema(description = "面试题ID，null表示新增，否则表示更新")
    private Long id;

    @Schema(description = "面试官ID")
    @NotNull(message = "面试官ID不能为空")
    private Long interviewerId;

    @Schema(description = "面试题")
    @NotBlank(message = "面试题不能为空")
    private String question;

    @Schema(description = "参考答案")
    @NotBlank(message = "参考答案不能为空")
    private String referenceAnswer;

    @Schema(description = "数字人视频地址")
    @NotBlank(message = "数字人视频地址不能为空")
    private String aiInterviewerVideoUrl;
}
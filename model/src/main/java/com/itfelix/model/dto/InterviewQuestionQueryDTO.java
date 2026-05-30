package com.itfelix.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "面试题列表查询DTO")
public class InterviewQuestionQueryDTO {
    @Schema(description = "面试官名称")
    private String interviewerName;

    @Schema(description = "面试题内容")
    private String question;

    @Schema(description = "页码", defaultValue = "1")
    private Integer page = 1;

    @Schema(description = "每页条数", defaultValue = "10")
    private Integer pageSize = 10;
}
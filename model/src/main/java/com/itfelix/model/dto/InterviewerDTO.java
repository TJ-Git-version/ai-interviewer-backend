package com.itfelix.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "面试官DTO")
public class InterviewerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "面试官ID（更新时必填）")
    private Long id;

    @Schema(description = "面试官名称")
    @Size(max = 50, message = "面试官名称不能超过50个字符")
    private String name;

    @Schema(description = "面试官形象图URL")
    private String image;
}
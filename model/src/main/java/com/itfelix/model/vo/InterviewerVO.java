package com.itfelix.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "面试官VO")
public class InterviewerVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "面试官ID")
    private Long id;

    @Schema(description = "面试官名称")
    private String name;

    @Schema(description = "面试官形象图URL")
    private String image;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
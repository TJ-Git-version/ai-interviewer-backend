package com.itfelix.common.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "业务异常")
public class BizException extends RuntimeException {

    @Schema(description = "错误码")
    private int code;

    @Schema(description = "错误消息")
    private String message;

    public BizException(String message) {
        super(message);
        this.code = 500;
        this.message = message;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
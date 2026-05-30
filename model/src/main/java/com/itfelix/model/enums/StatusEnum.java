package com.itfelix.model.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    DISABLED(0, "禁用"),
    ENABLED(1, "启用");

    private final Integer code;
    private final String description;

    StatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static StatusEnum fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (StatusEnum status : values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        return null;
    }
}
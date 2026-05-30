package com.itfelix.model.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "分页响应封装")
public class PageResult<T> {
    @Schema(description = "数据列表")
    private List<T> records;

    @Schema(description = "总条数")
    private Long total;

    @Schema(description = "当前页")
    private Long page;

    @Schema(description = "每页条数")
    private Long pageSize;

    public static <T> PageResult<T> ok(List<T> records, Long total, Long page, Long pageSize) {
        PageResult<T> result = new PageResult<>();
        result.setRecords(records);
        result.setTotal(total);
        result.setPage(page);
        result.setPageSize(pageSize);
        return result;
    }
}
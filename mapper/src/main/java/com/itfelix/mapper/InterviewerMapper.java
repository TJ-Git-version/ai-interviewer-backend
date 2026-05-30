package com.itfelix.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itfelix.model.entity.Interviewer;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 数字人面试官表 Mapper 接口
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
public interface InterviewerMapper extends BaseMapper<Interviewer> {

    /**
     * 根据名称查询面试官（用于唯一性校验）
     */
    Interviewer selectByName(@Param("name") String name);
}

package com.itfelix.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itfelix.model.dto.InterviewQuestionQueryDTO;
import com.itfelix.model.entity.InterviewQuestion;
import com.itfelix.model.vo.InterviewQuestionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterviewQuestionMapper extends BaseMapper<InterviewQuestion> {

    /**
     * 分页查询面试题列表（链表查询面试官名称）
     */
    List<InterviewQuestionVO> selectQuestionPage(@Param("query") InterviewQuestionQueryDTO queryDTO);
}
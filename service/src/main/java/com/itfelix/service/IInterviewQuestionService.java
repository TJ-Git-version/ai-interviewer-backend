package com.itfelix.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itfelix.model.common.PageResult;
import com.itfelix.model.dto.InterviewQuestionCreateDTO;
import com.itfelix.model.dto.InterviewQuestionQueryDTO;
import com.itfelix.model.entity.InterviewQuestion;
import com.itfelix.model.vo.InterviewQuestionVO;

public interface IInterviewQuestionService extends IService<InterviewQuestion> {

    /**
     * 创建或更新面试题
     */
    InterviewQuestion createOrUpdate(InterviewQuestionCreateDTO dto);

    /**
     * 删除面试题
     */
    void delete(Long id);

    /**
     * 分页查询面试题
     */
    PageResult<InterviewQuestionVO> list(InterviewQuestionQueryDTO queryDTO);

    /**
     * 启用面试题
     */
    void show(Long id);

    /**
     * 禁用面试题
     */
    void hide(Long id);
}
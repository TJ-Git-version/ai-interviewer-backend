package com.itfelix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itfelix.entity.InterviewQuestion;
import com.itfelix.mapper.InterviewQuestionMapper;
import com.itfelix.service.IInterviewQuestionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 面试题库表 服务实现类
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Service
public class InterviewQuestionServiceImpl extends ServiceImpl<InterviewQuestionMapper, InterviewQuestion> implements IInterviewQuestionService {

}

package com.itfelix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itfelix.entity.Interviewer;
import com.itfelix.mapper.InterviewerMapper;
import com.itfelix.service.IInterviewerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数字人面试官表 服务实现类
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Service
public class InterviewerServiceImpl extends ServiceImpl<InterviewerMapper, Interviewer> implements IInterviewerService {

}

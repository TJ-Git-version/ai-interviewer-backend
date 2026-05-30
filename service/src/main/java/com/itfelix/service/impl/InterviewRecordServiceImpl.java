package com.itfelix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itfelix.entity.InterviewRecord;
import com.itfelix.mapper.InterviewRecordMapper;
import com.itfelix.service.IInterviewRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 面试记录表 服务实现类
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Service
public class InterviewRecordServiceImpl extends ServiceImpl<InterviewRecordMapper, InterviewRecord> implements IInterviewRecordService {

}

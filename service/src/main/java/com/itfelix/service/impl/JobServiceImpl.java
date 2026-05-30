package com.itfelix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itfelix.entity.Job;
import com.itfelix.mapper.JobMapper;
import com.itfelix.service.IJobService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 职位信息表 服务实现类
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements IJobService {

}

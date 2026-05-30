package com.itfelix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itfelix.entity.Candidate;
import com.itfelix.mapper.CandidateMapper;
import com.itfelix.service.ICandidateService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 应聘者表 服务实现类
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Service
public class CandidateServiceImpl extends ServiceImpl<CandidateMapper, Candidate> implements ICandidateService {

}

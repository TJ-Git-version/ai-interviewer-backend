package com.itfelix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itfelix.mapper.InterviewerMapper;
import com.itfelix.model.dto.InterviewerDTO;
import com.itfelix.model.entity.Interviewer;
import com.itfelix.model.vo.InterviewerVO;
import com.itfelix.service.IInterviewerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Long createOrUpdate(InterviewerDTO dto) {
        Interviewer interviewer = new Interviewer();
        interviewer.setName(dto.getName());
        interviewer.setImage(dto.getImage());

        if (dto.getId() != null) {
            // 更新
            interviewer.setId(dto.getId());
            interviewer.setUpdateTime(LocalDateTime.now());
            this.updateById(interviewer);
            return dto.getId();
        } else {
            // 创建
            interviewer.setCreateTime(LocalDateTime.now());
            interviewer.setUpdateTime(LocalDateTime.now());
            this.save(interviewer);
            return interviewer.getId();
        }
    }

    @Override
    public void delete(Long id) {
        this.removeById(id);
    }

    @Override
    public List<InterviewerVO> listAll() {
        return this.list().stream().map(interviewer -> {
            InterviewerVO vo = new InterviewerVO();
            vo.setId(interviewer.getId());
            vo.setName(interviewer.getName());
            vo.setImage(interviewer.getImage());
            vo.setCreateTime(interviewer.getCreateTime());
            vo.setUpdateTime(interviewer.getUpdateTime());
            return vo;
        }).collect(Collectors.toList());
    }
}

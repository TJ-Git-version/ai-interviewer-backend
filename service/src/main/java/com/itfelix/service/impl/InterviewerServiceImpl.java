package com.itfelix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itfelix.common.exception.BizException;
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
        // 检查名称唯一性
        Interviewer existingByName = this.baseMapper.selectByName(dto.getName());
        if (existingByName != null && !existingByName.getId().equals(dto.getId())) {
            throw new BizException("面试官名称已存在");
        }

        if (dto.getId() != null) {
            // 更新时检查是否存在
            Interviewer existing = this.getById(dto.getId());
            if (existing == null) {
                throw new BizException("面试官不存在");
            }
        }

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
        Interviewer interviewer = this.getById(id);
        if (interviewer == null) {
            throw new BizException("面试官不存在");
        }
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

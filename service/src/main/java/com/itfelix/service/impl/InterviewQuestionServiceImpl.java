package com.itfelix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itfelix.common.exception.BizException;
import com.itfelix.mapper.InterviewQuestionMapper;
import com.itfelix.mapper.InterviewerMapper;
import com.itfelix.model.common.PageResult;
import com.itfelix.model.dto.InterviewQuestionCreateDTO;
import com.itfelix.model.dto.InterviewQuestionQueryDTO;
import com.itfelix.model.entity.InterviewQuestion;
import com.itfelix.model.entity.Interviewer;
import com.itfelix.model.enums.StatusEnum;
import com.itfelix.model.vo.InterviewQuestionVO;
import com.itfelix.service.IInterviewQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InterviewQuestionServiceImpl extends ServiceImpl<InterviewQuestionMapper, InterviewQuestion> implements IInterviewQuestionService {

    private final InterviewerMapper interviewerMapper;

    public InterviewQuestionServiceImpl(InterviewerMapper interviewerMapper) {
        this.interviewerMapper = interviewerMapper;
    }

    @Override
    public InterviewQuestion createOrUpdate(InterviewQuestionCreateDTO dto) {
        // 校验面试官是否存在
        Interviewer interviewer = interviewerMapper.selectById(dto.getInterviewerId());
        if (interviewer == null) {
            throw new BizException("面试官不存在");
        }

        InterviewQuestion entity = new InterviewQuestion();
        BeanUtils.copyProperties(dto, entity);

        if (dto.getId() != null) {
            // 校验更新记录是否存在
            InterviewQuestion existing = this.getById(dto.getId());
            if (existing == null) {
                throw new BizException("面试题不存在");
            }
            entity.setUpdateTime(LocalDateTime.now());
            this.updateById(entity);
        } else {
            entity.setStatus(StatusEnum.ENABLED.getCode());
            entity.setCreateTime(LocalDateTime.now());
            entity.setUpdateTime(LocalDateTime.now());
            this.save(entity);
        }
        return entity;
    }

    @Override
    public void delete(Long id) {
        InterviewQuestion existing = this.getById(id);
        if (existing == null) {
            throw new BizException("面试题不存在");
        }
        this.removeById(id);
    }

    @Override
    public PageResult<InterviewQuestionVO> list(InterviewQuestionQueryDTO queryDTO) {
        PageInfo<InterviewQuestionVO> pageInfo = PageHelper.startPage(queryDTO.getPage(), queryDTO.getPageSize())
                .doSelectPageInfo(() -> baseMapper.selectQuestionPage(queryDTO));

        return PageResult.ok(
                pageInfo.getList(),
                pageInfo.getTotal(),
                (long) pageInfo.getPageNum(),
                (long) pageInfo.getPageSize()
        );
    }

    @Override
    public void show(Long id) {
        InterviewQuestion existing = this.getById(id);
        if (existing == null) {
            throw new BizException("面试题不存在");
        }
        existing.setStatus(StatusEnum.ENABLED.getCode());
        existing.setUpdateTime(LocalDateTime.now());
        this.updateById(existing);
    }

    @Override
    public void hide(Long id) {
        InterviewQuestion existing = this.getById(id);
        if (existing == null) {
            throw new BizException("面试题不存在");
        }
        existing.setStatus(StatusEnum.DISABLED.getCode());
        existing.setUpdateTime(LocalDateTime.now());
        this.updateById(existing);
    }
}
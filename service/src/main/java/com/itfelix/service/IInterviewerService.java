package com.itfelix.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itfelix.model.dto.InterviewerDTO;
import com.itfelix.model.entity.Interviewer;
import com.itfelix.model.vo.InterviewerVO;

import java.util.List;

/**
 * <p>
 * 数字人面试官表 服务类
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
public interface IInterviewerService extends IService<Interviewer> {

    /**
     * 创建或更新面试官
     * @param dto 面试官DTO，id为空则创建，非空则更新
     * @return 面试官ID
     */
    Long createOrUpdate(InterviewerDTO dto);

    /**
     * 删除面试官
     */
    void delete(Long id);

    /**
     * 查询所有面试官
     */
    List<InterviewerVO> listAll();
}

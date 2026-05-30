package com.itfelix.controller;

import com.itfelix.model.common.Result;
import com.itfelix.model.dto.InterviewerDTO;
import com.itfelix.model.vo.InterviewerVO;
import com.itfelix.service.IInterviewerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 数字人面试官表 前端控制器
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Tag(name = "面试官管理", description = "数字人面试官相关接口")
@RestController
@RequestMapping("/interviewer")
public class InterviewerController {

    @Autowired
    private IInterviewerService interviewerService;

    @Operation(summary = "创建或更新面试官", description = "根据ID判断是新增还是更新，ID为空则新增，非空则更新")
    @PostMapping("/createOrUpdate")
    public Result<Long> createOrUpdate(@Valid @RequestBody InterviewerDTO dto) {
        Long id = interviewerService.createOrUpdate(dto);
        return Result.ok(id);
    }

    @Operation(summary = "删除面试官")
    @DeleteMapping("/delete")
    public Result<Void> delete(@Parameter(description = "面试官ID") @RequestParam Long id) {
        interviewerService.delete(id);
        return Result.ok();
    }

    @Operation(summary = "查询所有面试官")
    @GetMapping("/list")
    public Result<List<InterviewerVO>> list() {
        List<InterviewerVO> list = interviewerService.listAll();
        return Result.ok(list);
    }
}

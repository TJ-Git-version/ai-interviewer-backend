package com.itfelix.controller;

import com.itfelix.model.common.PageResult;
import com.itfelix.model.common.Result;
import com.itfelix.model.dto.InterviewQuestionCreateDTO;
import com.itfelix.model.dto.InterviewQuestionQueryDTO;
import com.itfelix.model.vo.InterviewQuestionVO;
import com.itfelix.service.IInterviewQuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "面试题库管理", description = "面试题 CRUD 接口")
public class InterviewQuestionController {

    private final IInterviewQuestionService interviewQuestionService;

    public InterviewQuestionController(IInterviewQuestionService interviewQuestionService) {
        this.interviewQuestionService = interviewQuestionService;
    }

    /**
     * 创建或更新面试题
     * POST /questionLib/createOrUpdate
     */
    @Operation(summary = "创建或更新面试题", description = "传入InterviewQuestionCreateDTO对象")
    @PostMapping("/interview-question/createOrUpdate")
    public Result<Void> createOrUpdate(@Valid @RequestBody InterviewQuestionCreateDTO dto) {
        interviewQuestionService.createOrUpdate(dto);
        return Result.ok();
    }

    /**
     * 删除面试题
     * DELETE /interview-question/delete
     */
    @Operation(summary = "删除面试题", description = "根据ID删除面试题")
    @DeleteMapping("/interview-question/delete")
    public Result<Void> delete(@RequestParam Long id) {
        interviewQuestionService.delete(id);
        return Result.ok();
    }

    /**
     * 查询面试题列表
     * GET /interview-question/list
     */
    @Operation(summary = "查询面试题列表", description = "分页+条件查询面试题")
    @GetMapping("/interview-question/list")
    public Result<PageResult<InterviewQuestionVO>> list(@ModelAttribute InterviewQuestionQueryDTO queryDTO) {
        PageResult<InterviewQuestionVO> result = interviewQuestionService.list(queryDTO);
        return Result.ok(result);
    }

    /**
     * 启用面试题
     * POST /interview-question/show
     */
    @Operation(summary = "启用面试题", description = "将面试题状态设为启用")
    @PostMapping("/interview-question/show")
    public Result<Void> show(@RequestParam Long id) {
        interviewQuestionService.show(id);
        return Result.ok();
    }

    /**
     * 禁用面试题
     * POST /interview-question/hide
     */
    @Operation(summary = "禁用面试题", description = "将面试题状态设为禁用")
    @PostMapping("/interview-question/hide")
    public Result<Void> hide(@RequestParam Long id) {
        interviewQuestionService.hide(id);
        return Result.ok();
    }
}
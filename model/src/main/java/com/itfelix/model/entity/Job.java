package com.itfelix.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 职位信息表
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Getter
@Setter
@ToString
@TableName("job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职位ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 面试官ID
     */
    @TableField("interviewer_id")
    private Integer interviewerId;

    /**
     * 职位名称
     */
    @TableField("name")
    private String name;

    /**
     * 职位状态：0-关闭，1-开启
     */
    @TableField("status")
    private Byte status;

    /**
     * 职位描述
     */
    @TableField("description")
    private String description;

    /**
     * 提示词前缀
     */
    @TableField("prompt")
    private String prompt;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
}

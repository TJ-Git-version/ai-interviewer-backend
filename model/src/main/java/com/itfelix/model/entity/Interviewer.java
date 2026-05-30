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
 * 数字人面试官表
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Getter
@Setter
@ToString
@TableName("interviewer")
public class Interviewer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 面试官ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 面试官名称
     */
    @TableField("name")
    private String name;

    /**
     * 面试官形象图
     */
    @TableField("image")
    private String image;

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

package com.itfelix.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 应聘者表
 * </p>
 *
 * @author itfelix
 * @since 2026-05-30
 */
@Getter
@Setter
@ToString
@TableName("candidate")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 候选人ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 职位ID
     */
    @TableField("job_id")
    private Long jobId;

    /**
     * 候选人名称
     */
    @TableField("name")
    private String name;

    /**
     * 身份证
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 性别：0-女，1-男，2-未知
     */
    @TableField("gender")
    private Byte gender;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 出生日期
     */
    @TableField("birth_date")
    private LocalDate birthDate;

    /**
     * 头像
     */
    @TableField("face")
    private String face;

    /**
     * 国家
     */
    @TableField("country")
    private String country;

    /**
     * 省份
     */
    @TableField("province")
    private String province;

    /**
     * 区县
     */
    @TableField("city")
    private String city;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

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

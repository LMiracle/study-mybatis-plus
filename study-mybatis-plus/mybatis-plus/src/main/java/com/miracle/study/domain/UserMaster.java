package com.miracle.study.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Miracle
 * @date 2020/4/21 11:41
 */
@Data
@TableName("user_mtr")
public class UserMaster {

    @TableId(type = IdType.AUTO)
    @TableField
    private Integer userId;

    @TableField
    private String userName;

    @TableField
    private String pwd;

    @TableField
    private Integer age;

    @TableField
    private LocalDateTime createTime;

    @TableField
    private LocalDateTime updateTime;
}

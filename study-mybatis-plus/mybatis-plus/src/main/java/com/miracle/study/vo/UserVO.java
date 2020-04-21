package com.miracle.study.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Miracle
 * @date 2020/4/21 14:05
 */
@Data
public class UserVO {

    private Integer userId;

    private String userName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}

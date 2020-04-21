package com.miracle.study.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.study.domain.UserMaster;
import com.miracle.study.vo.UserVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Miracle
 * @date 2020/4/21 12:08
 */
@Repository
public interface UserDao extends BaseMapper<UserMaster> {

    @Select("SELECT * FROM user_mtr")
    Page<UserVO> getUserVO(Page<UserVO> page);
}

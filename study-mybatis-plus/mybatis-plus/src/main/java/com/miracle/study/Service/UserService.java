package com.miracle.study.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.study.domain.UserMaster;

import java.util.List;

/**
 * @author Miracle
 * @date 2020/4/21 12:46
 */
public interface UserService  {

    List<UserMaster> getUserMasterList();


}

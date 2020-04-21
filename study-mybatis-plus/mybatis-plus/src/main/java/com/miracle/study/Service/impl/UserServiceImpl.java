package com.miracle.study.Service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miracle.study.Service.UserService;
import com.miracle.study.dao.UserDao;
import com.miracle.study.domain.UserMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miracle
 * @date 2020/4/21 12:49
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserMaster> getUserMasterList() {

        return null;
    }
}

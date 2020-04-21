package com.miracle.study;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miracle.study.dao.UserDao;
import com.miracle.study.domain.UserMaster;
import com.miracle.study.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
//        Page<UserVO> userVO = userDao.getUserVO(new Page<>(1, 4));
//        log.info(userVO.getRecords().toString());

//        UserMaster userMaster = new UserMaster();
//        userMaster.setUserName("miracle");
//        userMaster.setUserId(1);
//        userMaster.setUpdateTime(LocalDateTime.now());
//        userDao.updateById(userMaster);
        userDao.deleteById(1);
    }



}

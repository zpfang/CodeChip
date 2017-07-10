package cc.zpfang.controller;

import cc.zpfang.model.User;
import cc.zpfang.persistent.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 * Created by zpfang on 2017/7/9.
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<User> fetchUser(){
        return null;
    }
}

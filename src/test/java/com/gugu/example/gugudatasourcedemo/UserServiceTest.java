package com.gugu.example.gugudatasourcedemo;

import com.gugu.example.gugudatasourcedemo.model.User;
import com.gugu.example.gugudatasourcedemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author gugu
 * @Classname UserServiceTest
 * @Description TODO
 * @Date 2022/7/16 21:10
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testWrite(){
        User user = new User();
        user.setName("gugu");
        user.setAge(22);
        user.setEmail("123456@qq.com");

        int result = userService.insert(user); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 看到id会自动填充
    }

    @Test
    public void testRead() {
        for (int i = 0; i < 4; i++) {
            List<User> users = userService.selectAll();
            System.out.println(users);
        }
    }

    @Test
    public void testSave() {
        User userDO = new User();
        userDO.setName("wangwu");
        userService.save(userDO);
    }

    @Test
    public void testReadFromMaster() {
        System.out.println(userService.getToken("1"));
    }

}

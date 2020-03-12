package cn.buptmail.test.function;

import cn.buptmail.domain.User;
import cn.buptmail.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 02:37
 * @Notes NULL
 */
public class UserServiceTest {
    @Test
    public void findAllTest(){
        List<User> users = new UserServiceImpl().findAll();
        System.out.println(users.size());
    }
}

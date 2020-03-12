package cn.buptmail.test.function;

import cn.buptmail.dao.impl.UserDAOImpl;
import cn.buptmail.domain.User;
import cn.buptmail.service.UserService;
import cn.buptmail.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 02:27
 * @Notes the test of class UserDAOTest in package cn.buptmail.dao   pass 1.0
 */

public class UserDAOTest {
    @Test
    public void findAllTest(){
        List<User> users = new UserDAOImpl().findAll();
        System.out.println(users.get(1).getName());
    }

    @Test
    public void updateTest(){
        User user = new User();
        user.setId(12);
        user.setPassword("041916");
        user.setEmail("111");
        user.setTel("6816");
        user.setName("cjq6asfadsf66");
        UserService service = new UserServiceImpl();
        service.updateUser(user);
    }
}

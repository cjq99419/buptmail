package cn.buptmail.Test;

import cn.buptmail.dao.impl.UserDAOImpl;
import cn.buptmail.domain.User;
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
}

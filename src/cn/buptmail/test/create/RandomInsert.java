package cn.buptmail.test.create;

import cn.buptmail.dao.OrdersDAO;
import cn.buptmail.dao.StaffDAO;
import cn.buptmail.dao.UserDAO;
import cn.buptmail.dao.impl.OrdersDAOImpl;
import cn.buptmail.dao.impl.StaffDAOImpl;
import cn.buptmail.dao.impl.UserDAOImpl;
import cn.buptmail.domain.Orders;
import cn.buptmail.domain.Staff;
import cn.buptmail.domain.User;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Date;
import java.util.Random;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/12 0012 上午 10:44
 * @Notes NULL
 */
public class RandomInsert {

    public static UserDAO daoUser = new UserDAOImpl();
    public static StaffDAO daoStaff = new StaffDAOImpl();
    public static OrdersDAO daoOrder = new OrdersDAOImpl();


    public static void main(String[] args) {
        randomInsertOrder(50);
        randomInsertStaff(50);
        randomInsertUser(50);
    }

    public static void randomInsertUser(int num){
        for(int i = 0; i < num; i++){
            daoUser.add(RandomInsert.getRandomUser());
        }
    }

    public static void randomInsertStaff(int num){
        for(int i = 0; i < num; i++){
            daoStaff.add(RandomInsert.getRandomStaff());
        }
    }

    public static void randomInsertOrder(int num){
        for(int i = 0; i < num; i++){
            daoOrder.add(RandomInsert.getRandomOrder());
        }
    }

    public static User getRandomUser(){
        User user = new User();
        user.setName(CreateUtils.getName());
        user.setEmail(CreateUtils.getEmail(5,  8));
        String tel = CreateUtils.getTel();
        user.setTel(tel);
        user.setPassword(tel.substring(tel.length()-6));
        return user;
    }

    public static Staff getRandomStaff(){
        Staff staff = new Staff();
        staff.setStaff_name(CreateUtils.getName());
        String tel = CreateUtils.getTel();
        staff.setTel(tel);
        staff.setPassword(tel.substring(tel.length()-6));
        staff.setEmail(CreateUtils.getEmail(5, 8));
        staff.setAddress_region(CreateUtils.getRoad());
        Random random = new Random();
        if(random.nextInt(6) < 4){
            staff.setPosition("staff");
            staff.setSalary(10000);
        }else{
            staff.setPosition("manager");
            staff.setSalary(15000);
        }
        return staff;
    }

    private static Orders getRandomOrder() {
        Orders order = new Orders();
        order.setSender_name(CreateUtils.getName());
        order.setSender_tel(CreateUtils.getTel());
        order.setSender_address(CreateUtils.getRoad());
        order.setRecipient_name(CreateUtils.getName());
        order.setRecipient_tel(CreateUtils.getTel());
        order.setRecipient_address(CreateUtils.getRoad());
        switch(new Random().nextInt(3)){
            case 0: order.setType("toy");
            case 1: order.setType("book");
            case 2: order.setType("other");
        }
        order.setWeight(new Random().nextInt(20));
        order.setPrice(3 * order.getWeight());
        if(new Random().nextInt(2) == 0) order.setMode_payment("on line");
        else order.setMode_payment("cash");
        order.setStatus(new Integer(new Random().nextInt(4)).toString());
        Date date = new Date();
        order.setDate(date);
        order.setLocation(CreateUtils.getRoad());
        return order;
    }

}

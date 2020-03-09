package cn.buptmail.dao;

import cn.buptmail.domain.Staff;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 04:33
 * @Notes NULL
 */
public interface StaffDAO {
    public List<Staff> findAll();
}

package cn.buptmail.dao;

import cn.buptmail.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 04:33
 * @Notes NULL
 */
public interface StaffDAO {
    List<Staff> findAll();

    void add(Staff staff);

    void delete(int id);

    Staff findStaffById(int id);

    void update(Staff staff);

    int findTotalCount(Map<String, String[]> condition);

    List<Staff> findStaffByPage(int start, int rows, Map<String, String[]> condition);
}

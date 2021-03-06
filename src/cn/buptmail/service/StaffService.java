package cn.buptmail.service;

import cn.buptmail.domain.Page;
import cn.buptmail.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 04:40
 * @Notes NULL
 */
public interface StaffService {
    public List<Staff> findAll();

    void addStaff(Staff staff);

    void deleteStaff(String id);

    void updateStaff(Staff staff);

    Staff findStaffById(String id);

    void deleteSelectedStaff(String[] ids);

    Page<Staff> findStaffByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}

package cn.buptmail.service.impl;

import cn.buptmail.dao.StaffDAO;
import cn.buptmail.dao.impl.StaffDAOImpl;
import cn.buptmail.domain.Page;
import cn.buptmail.domain.Staff;
import cn.buptmail.service.StaffService;

import java.util.List;
import java.util.Map;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 04:40
 * @Notes NULL
 */
public class StaffServiceImpl implements StaffService {
    private StaffDAO dao = new StaffDAOImpl();

    @Override
    public List<Staff> findAll() {
        return dao.findAll();
    }

    @Override
    public void addStaff(Staff staff) {
        if("manager".equals(staff.getPosition())) staff.setSalary(15000);
        else staff.setSalary(10000);
        dao.add(staff);
    }

    @Override
    public void deleteStaff(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public Staff findStaffById(String id) {
        return dao.findStaffById(Integer.parseInt(id));
    }

    @Override
    public void updateStaff(Staff staff) {
        if("manager".equals(staff.getPosition())) staff.setSalary(15000);
        else staff.setSalary(10000);
        dao.update(staff);
    }

    @Override
    public void deleteSelectedStaff(String[] ids) {
        for(String id : ids){
            deleteStaff(id);
        }
    }

    @Override
    public Page<Staff> findStaffByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        Page<Staff> page = new Page<>();
        page.setCurrentPage(currentPage);
        page.setRows(rows);
        int totalCount = dao.findTotalCount(condition);
        page.setTotalCount(totalCount);
        if(totalCount == 0) return null;
        int start = (currentPage - 1) * rows;
        List<Staff> list = dao.findStaffByPage(start, rows, condition);
        page.setList(list);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        page.setTotalPage(totalPage);
        return page;
    }
}

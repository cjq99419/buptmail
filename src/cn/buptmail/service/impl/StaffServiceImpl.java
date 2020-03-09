package cn.buptmail.service.impl;

import cn.buptmail.dao.StaffDAO;
import cn.buptmail.dao.impl.StaffDAOImpl;
import cn.buptmail.domain.Staff;
import cn.buptmail.service.StaffService;

import java.util.List;

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
}

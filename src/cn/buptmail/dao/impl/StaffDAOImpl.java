package cn.buptmail.dao.impl;

import cn.buptmail.dao.StaffDAO;
import cn.buptmail.domain.Staff;
import cn.buptmail.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/9 0009 下午 04:34
 * @Notes NULL
 */
public class StaffDAOImpl implements StaffDAO {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Staff> findAll(){
        String sql = "select * from staff";
        List<Staff> staffs = template.query(sql, new BeanPropertyRowMapper<Staff>(Staff.class));
        return staffs;
    }

    @Override
    public void add(Staff staff) {
        String sql = "insert into staff values(null, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, staff.getStaff_name(), staff.getPassword(), staff.getTel(), staff.getEmail(),
                staff.getAddress_region(), staff.getSalary(), staff.getPosition());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from staff where id=?";
        template.update(sql, id);
    }

    @Override
    public Staff findStaffById(int id) {
        String sql = "select * from staff where id=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Staff>(Staff.class), id);
    }

    @Override
    public void update(Staff staff) {
        String sql = "update staff set staff_name=?, password=?, tel=?, email=?, address_region= ?, salary=?, position=? where id=?";
        template.update(sql, staff.getStaff_name(), staff.getPassword(), staff.getTel(), staff.getEmail(),
                staff.getAddress_region(), staff.getSalary(), staff.getPosition(), staff.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from staff where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        for(String key : keySet){
            String value = condition.get(key)[0];
            if("currentPage".equals(key) || "rows".equals(key) || "sid".equals(key) || "id".equals(key)) continue;
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ?");
                params.add('%' + value + '%') ;
            }
        }
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<Staff> findStaffByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from staff where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for(String key : keySet){
            String value = condition.get(key)[0];
            if("currentPage".equals(key) || "rows".equals(key) || "sid".equals(key) || "id".equals(key)) continue;
            if(value != null && !"".equals(value)){
                sb.append(" and " + key + " like ?");
                params.add('%' + value + '%') ;
            }
        }

        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(), new BeanPropertyRowMapper<Staff>(Staff.class), params.toArray());
    }

}


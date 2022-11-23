package com.itcast.dao.impl;

import com.itcast.dao.DormitoryAdminDao;
import com.itcast.entity.DormitoryAdmin;
import com.itcast.entity.SystemAdmin;
import com.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Dormitory admin dao.
 */
public class DormitoryAdminDaoImpl implements DormitoryAdminDao {

    @Override
    public List<DormitoryAdmin> list() {
        // 开始连接数据库
        List<DormitoryAdmin> list = new ArrayList<>();
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            sql = "SELECT * FROM dormitory_admin order by id asc ";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(6);
                String name = rs.getString(3);
                String gender = rs.getString(4);
                String telephone = rs.getString(5);
                list.add(new DormitoryAdmin(id, username, password, name, gender, telephone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //记得释放资源
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        // 开始连接数据库
        List<DormitoryAdmin> list = new ArrayList<>();
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            sql = "SELECT * FROM dormitory_admin where " + key + " like '%" + value + "%'";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(6);
                String name = rs.getString(3);
                String gender = rs.getString(4);
                String telephone = rs.getString(5);
                list.add(new DormitoryAdmin(id, username, password, name, gender, telephone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //记得释放资源
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public Integer save(DormitoryAdmin dormitoryAdmin) {
        // 开始连接数据库
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Integer result = null;
        try {
            conn = JDBCUtils.getConnection();
            sql = "insert into dormitory_admin(username,password,name,gender,telephone) values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dormitoryAdmin.getUsername());
            pstmt.setString(2, dormitoryAdmin.getPassword());
            pstmt.setString(3, dormitoryAdmin.getName());
            pstmt.setString(4, dormitoryAdmin.getGender());
            pstmt.setString(5, dormitoryAdmin.getTelephone());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
        return result;
    }

    @Override
    public Integer update(DormitoryAdmin dormitoryAdmin) {
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer result = null;
        try {
            conn = JDBCUtils.getConnection();
            sql = "update dormitory_admin set username=?, password=?, name=?, gender=?, telephone=? where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(6, dormitoryAdmin.getId());
            pstmt.setString(1, dormitoryAdmin.getUsername());
            pstmt.setString(2, dormitoryAdmin.getPassword());
            pstmt.setString(3, dormitoryAdmin.getName());
            pstmt.setString(4, dormitoryAdmin.getGender());
            pstmt.setString(5, dormitoryAdmin.getTelephone());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
        return result;
    }

    @Override
    public Integer deleteById(Integer id) {
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Integer result = null;

        try {
            conn = JDBCUtils.getConnection();
            sql = "DELETE FROM dormitory_admin where id=" +id;
            pstmt = conn.prepareStatement(sql);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null, pstmt, conn);
        }
        return result;
    }
}

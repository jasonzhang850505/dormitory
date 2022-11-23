package com.itcast.dao.impl;

import com.itcast.dao.SystemAdminDao;
import com.itcast.entity.SystemAdmin;
import com.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * The type System admin dao.
 */
public class SystemAdminDaoImpl implements SystemAdminDao {
    @Override
    public SystemAdmin findByUsername(String username) {
        // 开始连接数据库
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            sql = "SELECT * FROM system_admin WHERE username=" + "'" + username + "'";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                username = rs.getString(2);
                String password = rs.getString(3);
                String name = rs.getString(4);
                String gender = rs.getString(5);
                String telephone = rs.getString(6);
                return new SystemAdmin(id, username, password, name, gender,telephone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //记得释放资源
            JDBCUtils.close(rs, pstmt, conn);
        }
        return null;
    }
}

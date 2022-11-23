package com.itcast.dao.impl;

import com.itcast.dao.DormitoryDao;
import com.itcast.entity.Dormitory;
import com.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Dormitory dao.
 */
public class DormitoryDaoImpl implements DormitoryDao {
    @Override
    public List<Dormitory> availableList() {
        // 开始连接数据库
        List<Dormitory> list = new ArrayList<>();
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            sql = "SELECT id,name FROM dormitory where available > 0";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                list.add(new Dormitory(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //记得释放资源
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;
    }
}

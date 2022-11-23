package com.itcast.dao.impl;

import com.itcast.dao.StudentDao;
import com.itcast.entity.Student;
import com.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Student dao.
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> list() {
        // 开始连接数据库
        List<Student> list = new ArrayList<>();
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            sql = "select s.id,s.number,s.name,s.gender,d.id,d.name,s.state,s.create_date from student s,dormitory d where s.dormitory_id = d.id ";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String number = rs.getString(2);
                String name = rs.getString(3);
                String gender = rs.getString(4);
                Integer dormitoryID = rs.getInt(5);
                String dormitoryName = rs.getString(6);
                String state = rs.getString(7);
                String createDate = rs.getString(8);
                list.add(new Student(id, number, name, gender, dormitoryID, dormitoryName, state, createDate));
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
    public List<Student> search(String key, String value) {
        // 开始连接数据库
        List<Student> list = new ArrayList<>();
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            sql = "SELECT s.id,s.number,s.name,s.gender,d.id,d.name,s.state,s.create_date FROM student s,dormitory d where s.dormitory_id = d.id having s." + key + " like '%" + value + "%'";
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String number = rs.getString(2);
                String name = rs.getString(3);
                String gender = rs.getString(4);
                Integer dormitoryID = rs.getInt(5);
                String dormitoryName = rs.getString(6);
                String state = rs.getString(7);
                String createDate = rs.getString(8);
                list.add(new Student(id, number, name, gender, dormitoryID, dormitoryName, state, createDate));
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
    public Integer save(Student student) {
        // 开始连接数据库
        String sql;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Integer result = null;
        try {
            conn = JDBCUtils.getConnection();
            sql = "insert into student(number,name,gender,dormitory_id,state,create_date) values (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(3,student.getNumber());
            pstmt.setString(1,student.getName());
            pstmt.setString(2,student.getGender());
            pstmt.setInt(4,student.getDormitoryID());
            pstmt.setString(5,student.getState());
            pstmt.setString(6,student.getCreate_date());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
        return result;
    }
}

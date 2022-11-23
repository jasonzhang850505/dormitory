package com.itcast.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The type Add student info.
 */
public class AddStudentInfo {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String datetime = dtf.format(date);

        // 获取同学
        String[] names = {"闫克芬", "梁守印", "张青凤", "陈勇", "孙忠银", "郑少红", "王勇", "车正伟", "朱荣荣", "胡梦银", "赵林泽",
                "杨迪", "黄杏", "郑松", "卢林涛", "王先", "郭亚亚", "顾敏", "张青健", "孟俊", "谢江湖", "陈漂", "韩乾", "顾勇", "杨国洪", "易匠壁"};
        String[] gender = {"男", "女"};
        //连接数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        ResultSet rs = null;
        String prefix = "";
        Integer random = null;
        for (int i = 0; i < names.length; i++) {
            prefix = i < 10 ? "00" : "0";
            random = ((int) Math.random() * 10) % 2;
            try {
                conn = JDBCUtils.getConnection();
                sql = "INSERT INTO student(id,number,name,gender,dormitory_id,state,create_date) values(?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, i+1);
                pstmt.setString(2, prefix + (i + 1));
                pstmt.setString(3, names[i]);
                pstmt.setString(4, gender[random]);
                pstmt.setString(5, String.valueOf(i % 4 + 1));
                pstmt.setString(6,"入住");
                pstmt.setString(7,datetime);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(pstmt, conn);
            }
        }
    }
}

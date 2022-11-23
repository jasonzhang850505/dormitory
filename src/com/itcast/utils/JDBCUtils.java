package com.itcast.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * The type Jdbc utils.
 *
 * @author admin  Durid连接池的工具类
 */
public class JDBCUtils {
    /**
     * 1.定义成员变量
     */
    private static DataSource ds;

    static {
        try {
            //加载配置文件
            Properties props = new Properties();
            props.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            // 获取DataSource
            ds = (DruidDataSource)DruidDataSourceFactory.createDataSource(props);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets connection.
     *
     * @return 获取连接 connection
     * @throws SQLException the sql exception
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     *
     * @param rs   the rs
     * @param stmt the stmt
     * @param conn the conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (conn !=null) {
            try {
                conn.close(); // 归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Close.
     *
     * @param stmt the stmt
     * @param conn the conn
     */
    public static void close(Statement stmt, Connection conn) {
        close(null,stmt,conn);
    }

    /**
     * 获取连接池的方法
     *
     * @return data source
     */
    public static DataSource getDataSource() {
        return ds;
    }

}

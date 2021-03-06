package com.flc.jdbc.dao;

import com.flc.bean.User;
import com.flc.jdbc.utils.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/11/18 16:36
 * @desc
 */
@Repository
public class UserDao {

    @Autowired
    private DataSource dataSource;

    public List<User> findAll() {
        String sql = "select id,code,name from user";
        List<User> userList = new ArrayList<User>();
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String code = rs.getString("code");
                    String name = rs.getString("name");
                    userList.add(User.builder().id(id).code(code).name(name).build());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.release(rs, stmt, conn);
            }
        }
        return userList;
    }

    public boolean deleteAll() {
        String sql = "delete from user";
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        if (conn != null) {
            try {
                stmt = conn.createStatement();
                result = stmt.execute(sql);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.release(stmt, conn);
            }
        }
        return result;
    }

    public int insert(User user) {
        int result = 0;
        String sql = "insert into user(id,code,name) values(?,?,?)";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        if (conn != null) {
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, user.getId());
                ps.setString(2, user.getCode());
                ps.setString(3, user.getName());
                result = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.release(ps, conn);
            }
        }
        return result;
    }

    public int update(User user) {
        String sql = "UPDATE USER SET CODE=?, NAME=?  WHERE id=?";
        Connection conn = JDBCUtil.getConnection();
        int result = 0;
        PreparedStatement ps = null;
        if (conn != null) {
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getCode());
                ps.setString(2, user.getName());
                ps.setInt(3, user.getId());
                result = ps.executeUpdate();
//                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.release(ps, conn);
            }
        }
        return result;
    }

    public List<User> selectAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        try {
            //创建connection
            conn = dataSource.getConnection();
            statement = conn.createStatement();
            //执行sql
            rs = statement.executeQuery("select id,code,name from user limit 10");
            //取数据
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String name = rs.getString("name");
                userList.add(User.builder().id(id).code(code).name(name).build());
            }
            if (rs.next()) {
                System.out.println(rs.getString("s"));
            }
            //关闭connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}

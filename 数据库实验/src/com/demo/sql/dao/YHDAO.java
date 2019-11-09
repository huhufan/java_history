package com.demo.sql.dao;

import com.demo.sql.bean.Back;
import com.demo.sql.bean.YH;
import com.demo.sql.common.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YHDAO {

    /**
     * 通过注册添加一个用户
     * @param yh 用户对象
     * @return
     */
    public boolean addYH(YH yh) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into yh(username,password,usersign,sex,emial,logion_time) values(?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, yh.getUsername());
            stmt.setString(2, yh.getPassword());
            stmt.setInt(3, yh.getUsersign());
            stmt.setString(4, yh.getSex());
            stmt.setString(5, yh.getEmial());
            Date date = new Date(System.currentTimeMillis());
            stmt.setDate(6,date);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }
    public List<YH> getYH() {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select * from YH";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<YH> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new YH(rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getInt("usersign"),
                        rs.getString("sex"), rs.getString("emial")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }
    public boolean yh_name_Validate(String username) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select * from yh where username = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<YH> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            rs = stmt.executeQuery();
            while (rs.next()) {
               return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return false;
    }
    public boolean UpdateUser(String id, String username, String password, String sex, String emial) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " update yh set username = ?,password = ?,sex = ?,emial = ? where id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, sex);
            stmt.setString(4, emial);
            stmt.setString(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }
}

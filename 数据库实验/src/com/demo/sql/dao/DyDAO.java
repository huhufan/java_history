package com.demo.sql.dao;

import com.demo.sql.bean.BK;
import com.demo.sql.bean.Back;
import com.demo.sql.common.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DyDAO {
    public Boolean getDY_status(String zz_id,String user_id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select* from dy WHERE yh_id = ? and zb_id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BK> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(user_id));
            stmt.setInt(2, Integer.parseInt(zz_id));
            rs = stmt.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return false;
    }
    public Boolean addDY_status(String zz_id,String user_id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " insert into dy(zb_id,yh_id,dy_time) values (?,?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BK> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(zz_id));
            stmt.setInt(2, Integer.parseInt(user_id));
            Date date = new Date(System.currentTimeMillis());
            stmt.setDate(3,date);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }
    public boolean delDY_status(String zb_id,String user_id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "  delete from dy where zb_id = ? and yh_id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(zb_id));
            stmt.setInt(2, Integer.parseInt(user_id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }
    public boolean saveLW(String zb_id,String user_id,String money) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into lw(zb_id,user_id,money,lw_time) values (?, ?, ?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(zb_id));
            stmt.setInt(2, Integer.parseInt(user_id));
            stmt.setInt(3, Integer.parseInt(money));
            Date date = new Date(System.currentTimeMillis());
            stmt.setDate(4,date);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return true;
    }
    public List<BK> getLW_modle(String zb_id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select yh.username,sum(money) as total_money from lw join yh on lw.user_id = yh.id and lw.zb_id = ? group by lw.user_id;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BK> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, zb_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new BK(String.valueOf(rs.getString("username")), rs.getString("total_money")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }
    public boolean delTJ(String zb_id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "update zb set zb_sign = 0 where id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(zb_id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }
    public boolean addTJ(String zb_id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "update zb set zb_sign = 1 where id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(zb_id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }
    public List<Back> getFK() {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select yh.username,fk.title,fk.content from yh_fk join fk on fk.id = yh_fk.fk_id join yh on yh_fk.yh_id = yh.id";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Back> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new Back(rs.getString("username"),rs.getString("title"),rs.getString("content")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }






}

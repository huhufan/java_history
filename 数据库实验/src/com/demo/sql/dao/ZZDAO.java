package com.demo.sql.dao;

import com.demo.sql.bean.*;
import com.demo.sql.common.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息DAO
 *
 * @version 1.0
 */
public class ZZDAO {




    //得到表中最大id
    public String getMaxzzId() {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select max(id) from ZZ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String maxId = null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                maxId = rs.getString("max(id)");
                System.out.println(maxId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return maxId;
    }

    // 用户登录判断
    public List<YH> getYHBy_pass(String username, String password) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select * from yh WHERE username = ? and password = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<YH> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
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

    public List<YH> getYHBy_id(String id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select * from YH WHERE id =?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<YH> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
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




    //通过id得到主播
    public List<ZZ> getZZbyId(String zz_id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select* from Zb WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ZZ> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, zz_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new ZZ(rs.getString("id"), rs.getString("username"), rs.getString("title"), rs.getString("password"), rs.getString("sex"), rs.getString("emial"), rs.getString("room_url")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }

    public boolean UpdateUser(String id, String username, String password, Integer usersign, String sex, String emial) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " update yh set username = ?,password = ?,usersign = ?,sex = ?,emial = ? where id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, usersign);
            stmt.setString(4, sex);
            stmt.setString(5, emial);
            stmt.setString(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }

    //删除主播
    public boolean deletezz(String id) {
        deleteDY(id);
        Connection conn = ConnectionUtil.getConnection();
        String sql = "  delete from zb where id = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }

    public boolean deleteUser(String id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " delete from YH where id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }

    //删除订阅
    public boolean deleteDY(String id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "delete from DY WHERE zz_id =?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }

    //提交反馈
    public int postBack(Back back) {
        int a = -1;
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into fk(title,content,fk_time) values(?,?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, back.getTitle());
            stmt.setString(2, back.getContent());
            Date date = new Date(System.currentTimeMillis());
            stmt.setDate(3,date);
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                 a = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return a;
    }
    public boolean addYH_FK(String id, int a) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert yh_fk(fk_id,yh_id) values(?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, a);
            stmt.setInt(2, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }


    //成为主播
    public int addZZ(ZZ zz) {
        int a = -1;
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into zb(username,title,password,sex,emial,room_url,logion_time) values(?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, zz.getUsername());
            stmt.setString(2, zz.getTitle());
            stmt.setString(3, zz.getPassword());
            stmt.setString(4, zz.getSex());
            stmt.setString(5, zz.getEmial());
            stmt.setString(6, zz.getRoom_url());
            Date date = new Date(System.currentTimeMillis());
            stmt.setDate(7, date);
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                a = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return a;
    }
    public boolean addzb_zbk(int zb_id,int zbk_id) {
        boolean flag = true;
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into zb_zbk(zb_id,zbk_id) values(?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,zb_id);
            stmt.setInt(2, zbk_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }
    //修改主播信息
    public boolean updatezz(String id,String username,String password,String title,String sex,String emial) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "update zb set username = ?,password = ?,title = ?,sex = ?,emial= ? where id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, title);
            stmt.setString(4, sex);
            stmt.setString(5, emial);
            stmt.setString(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return true;
    }

    public boolean save(ZZ zz) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into message(user_id, username, title, content, create_time) values (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, zz.getId());
            stmt.setString(2, zz.getUsername());
            stmt.setString(3, zz.getTitle());
            stmt.setString(4, zz.getEmial());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return true;
    }

    //关注关系表


    //订阅
    public boolean saveDY(String yh_id, String zz_id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into DY values (?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, yh_id);
            stmt.setString(2, zz_id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return true;
    }
    /*
   得到板块
    */
    public List<BK> getPlate() {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from bk ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BK> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new BK(String.valueOf(rs.getInt("id")), rs.getString("bk_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }

    /*
    得到子版块
     */
    public List<BK> getZiPlate(String bk) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select id,zbk_name from zbk where id in (select zbk_id from bk_zbk where bk_id = ?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<BK> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bk);
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new BK(rs.getString("id"), rs.getString("zbk_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }
    /*
    得到主播列表
     */
    public List<ZZ> getAnchor() {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from zb order by id ";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ZZ> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new ZZ(rs.getString("id"), rs.getString("username"), rs.getString("title"), rs.getString("password"), rs.getString("sex")
                        , rs.getString("emial"), rs.getString("room_url"),rs.getString("zb_sign")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }
    public List<ZZ> getAnchorTJ() {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from zb WHERE zb_sign = 1";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ZZ> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new ZZ(rs.getString("id"), rs.getString("username"), rs.getString("title"), rs.getString("password"), rs.getString("sex")
                        , rs.getString("emial"), rs.getString("room_url"),rs.getString("zb_sign")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }
    public List<ZZ> getAnchorDY(String ID) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * FROM zb where id in(select zb_id from dy where yh_id = ?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ZZ> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,Integer.parseInt(ID));
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new ZZ(rs.getString("id"), rs.getString("username"), rs.getString("title"), rs.getString("password"), rs.getString("sex")
                        , rs.getString("emial"), rs.getString("room_url"),rs.getString("zb_sign")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }
    /*
    根据板块得到主播
     */
    public List<ZZ> getAnchorBybk(String bk) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from zb where id in(select zb_id from zb_zbk where zbk_id in (select zbk_id from bk_zbk where bk_id = ?) )";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ZZ> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(bk));
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new ZZ(rs.getString("id"), rs.getString("username"), rs.getString("title"), rs.getString("password"), rs.getString("sex")
                        , rs.getString("emial"),  rs.getString("room_url"),rs.getString("zb_sign")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;
    }

    /*
    根据子板块得到主播
     */
    public List<ZZ> getAnchorByzbk(String zbk) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = " select * from zb WHERE id in (select zb_id from zb_zbk where zbk_id = ?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ZZ> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(zbk));
            rs = stmt.executeQuery();
            while (rs.next()) {
                member.add(new ZZ(rs.getString("id"), rs.getString("username"), rs.getString("title"), rs.getString("password"), rs.getString("sex")
                        , rs.getString("emial"), rs.getString("room_url")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return member;

    }




}
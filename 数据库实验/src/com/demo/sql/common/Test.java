package com.demo.sql.common;

import com.demo.sql.bean.ZZ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        try {
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/dy?useUnicode=true&characterEncoding=utf-8", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ZZ> getzb() {
        Connection conn = Test.getCon();
        String sql = "select * FROM zb where id = ?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ZZ> member = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,2);
            rs = stmt.executeQuery();
            //执行查询
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

}

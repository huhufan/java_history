import java.sql.*;

import static java.sql.DriverManager.getConnection;


public class MySQLConnection {
    public static void main(String[] args) {


        // 1.导入mysql-connector-java-version.jar  官方下载地址 https://dev.mysql.com/downloads/connector/j/*********************************

        // 2.加载驱动类com.mysql.jdbc.Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 3.获得连接********************************************************************************************************************
            connection = getConnection("jdbc:mysql://127.0.0.1:3306/iot", "root", "root");

            //执行查询
           // statement = connection.prepareStatement("select * from test where id = ?");
            statement = connection.prepareStatement("insert into test (name) values (?);");
            statement.setString(1,"kk");
            //statement.setInt(1, 1);
            int i = statement.executeUpdate();
            System.out.println(i);
            //resultSet = statement.executeQuery();
            // 4.从结果集中取出数据***********************************************************************************************************

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 5. 释放资源***********************************************************************************************************************
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

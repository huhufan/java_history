import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0Test {
    public static void main(String[] args) {
        //导入c3po-0.9.5.2.jar 和 mchange-commons-java-0.2.11.jar   下载地址：https://sourceforge.net/projects/c3p0/
        Connection connection = null;
        try {
            /**
             * c3p0的配置方式分为三种，分别是
             * 1.setters一个个地设置各个配置项(不推荐)
             * 2.类路径下提供一个c3p0.properties文件
             * 3.类路径下提供一个c3p0-config.xml文件
             */
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/iot");
            dataSource.setUser("root");
            dataSource.setPassword("root");

            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from test");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

    }
}


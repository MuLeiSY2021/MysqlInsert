import java.sql.*;

public class FirstExample {

    public static void main(String[] args) {
        try {
        String url = "jdbc:mysql://localhost:3306/test_db";
        String username = "root";
        String password = "030704";
        String table_create = "CREATE TABLE IF NOT EXISTS `test_table`(\n" +
                "`id` INT UNSIGNED AUTO_INCREMENT,\n" +
                "`name` VARCHAR(100) NOT NULL,\n" +
                "`email` VARCHAR(100) NOT NULL,\n" +
                "PRIMARY KEY ( `id` )\n" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        String insert = "INSERT into test_table\n" +
                "(name,email)\n" +
                "VALUES\n" +
                "('mulei','mulei@qq.com');";
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = con.prepareStatement(table_create);
            pst.executeUpdate();
            pst = con.prepareStatement(insert);
            pst.executeUpdate();
            Statement statement = con.createStatement();
            String sql3 = "select * from test_table";

            ResultSet rs = statement.executeQuery(sql3);

            System.out.println("编 号"+"\t"+"姓 名"+"\t"+"邮 箱");
            while (rs.next()) {
                System.out.print(rs.getInt(1)+"   \t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.println();
            }

            rs.close();
            statement.close();
        } catch (SQLException se) {
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }
    }
}
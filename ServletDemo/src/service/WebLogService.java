package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WebLogService {
    public void queryWeblogs() {
        Connection conn = null;
        PreparedStatement pst= null;
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "123123";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("url", username, password);
            String query_sql = "select * from test";
            pst = conn.prepareStatement(query_sql);
            ResultSet res = pst.executeQuery();

            while(res.next()){
                String titleName = res.getString("title_name");
                String titleCount = res.getString("count");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

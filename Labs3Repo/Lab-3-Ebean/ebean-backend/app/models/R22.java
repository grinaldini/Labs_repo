package models;

import com.avaje.ebean.SqlRow;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singleton;

public class R22 {

    public static List<SqlRow> outputList22(String researcher) {

        List<String> coauthors = new ArrayList<>();
        List coauthorOut = null;

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ebeantest", "root", "201269")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String sql= " select author from ebeantest.lab2tbl"
                        + " where author like \"%"+researcher+"%\" ";
                //Use sql find required data.

                List<String> list22 = new ArrayList<>();

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()){
                    list22.add(rs.getString("author"));
                }

                System.out.println(list22);

                String buffer;

                for(int a = 0;a < list22.size();a++){
                    buffer = list22.get(a);
                    coauthors.addAll(Arrays.asList(buffer.split("\\|")));
                }
                coauthors.removeAll(singleton(researcher));
                coauthors.removeAll(singleton(""));
                //System.out.println(coauthors);
                //remove the productive researcher him/herself and empty elements.

                //remove duplicate elements.
                for  ( int  i = 0 ; i < coauthors.size()-1; i ++)  {
                    for  ( int  j = coauthors.size()-1; j > i; j -- )  {
                        if  (coauthors.get(j).equals(coauthors.get(i)))  {
                            coauthors.remove(j);
                        }
                    }
                }
                coauthorOut = coauthors;

                System.out.println(coauthorOut);

                return coauthorOut;

            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coauthorOut;
    }
}

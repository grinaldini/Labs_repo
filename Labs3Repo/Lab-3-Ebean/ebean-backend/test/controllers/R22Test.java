package controllers;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singleton;


public class R22Test {

    @Test
    public void outputList22() {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ebeantest", "root", "201269")) {
            if (conn != null) {
                String sql= " select author from ebeantest.lab2tbl"
                        + " where author REGEXP 'Jia Zhang'";
                //Use sql find required data.

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery(sql);

                List<String> authors= new ArrayList<>();

                while (rs.next()){
                    authors.add(rs.getString("author"));
                }
                System.out.println(authors);

                List<String> coauthors = new ArrayList<>();
                String buffer;

                for(int a = 0;a < authors.size();a++){
                    buffer = authors.get(a);
                    coauthors.addAll(Arrays.asList(buffer.split("\\|")));
                }
                coauthors.removeAll(singleton("Jia Zhang"));
                coauthors.removeAll(singleton(""));
                //remove the productive researcher him/herself and empty elements.

                //remove duplicate elements.
                for  ( int  i = 0 ; i < coauthors.size()-1; i ++)  {
                    for  ( int  j = coauthors.size()-1; j > i; j -- )  {
                        if  (coauthors.get(j).equals(coauthors.get(i)))  {
                            coauthors.remove(j);
                        }
                    }
                }

                System.out.println(coauthors);

            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

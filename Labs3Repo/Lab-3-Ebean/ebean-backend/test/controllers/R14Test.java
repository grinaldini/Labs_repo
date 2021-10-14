package controllers;


import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singleton;


public class R14Test{

    @Test
    public void testOutputList14() {


        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ebeantest", "root", "201269")) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                String sql= " select author from ebeantest.lab2tbl";
                //Use sql find required data.

                //SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
                //sqlQuery.setParameter("minimumNumberOfArticles", minimumNumberOfArticles);

                List<String> testList = new ArrayList<>();

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()){
                    testList.add(rs.getString("author"));
                }

                System.out.println(testList);

                List<String> allAuthor = new ArrayList<>();
                String bufferS;

                for(int i = 0;i<testList.size();i++){
                    if(testList.get(i).contains("||")){
                        bufferS = testList.get(i);
                        allAuthor.addAll(Arrays.asList(bufferS.split("\\|")));
                        //Separate the authors string to single author and store into allAuthor list.
                    }else{
                        allAuthor.add(testList.get(i));
                        allAuthor.removeAll(singleton(""));
                        //if not a long author string, store into allAuthor directly.
                    }
                }
                //System.out.println(allAuthor);

                List<String> productiveAuthor = new ArrayList<>();
                int count = 0;

                for (int a = 0;a<allAuthor.size();a++){
                    for (int b = 0;b<allAuthor.size();b++){
                        if (a!=b && allAuthor.get(a).equals(allAuthor.get(b))){
                            //Compare the element with index 'a' with all the elements in the list.
                            count++;
                            if (count >= 10){
                                productiveAuthor.add(allAuthor.get(a));
                                //store into to productiveAuthor if this author has published enough paper.

                                int c = a;
                                allAuthor.removeIf(obj->obj.equals(allAuthor.get(c)));
                                //after storage, remove this author from allAuthor list to prevent duplicate.
                            }
                        }
                    }
                    count = 0;//Initialize count.
                }
                System.out.println("\n"+productiveAuthor);


            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

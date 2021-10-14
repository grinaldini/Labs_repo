package models;

import com.avaje.ebean.*;

import java.util.List;


public class R1523 extends Model {
    private static final long serialVersionUID = 1L;

    //delete the Entity and id to avoid create a new table.
    //public static Find<Long, R1523> find = new Find<Long, R1523>(){};

    public static List<SqlRow> findConferenceLocations(String booktitle, String year1, String year2) {
        String sql= " select distinct location from ebeantest.lab2tbl"
                + " where booktitle = :booktitle and year >= :year1 and year <= :year2";
       // String sql = "select id, name from customer where name like :name and status_code = :status";

        SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
        sqlQuery.setParameter("booktitle", booktitle);
        sqlQuery.setParameter("year1", year1);
        sqlQuery.setParameter("year2", year2);
        // execute the query returning a List of MapBean objects
        List<SqlRow> list2 = sqlQuery.findList();
/*
        List<SqlRow> list;
        list = Ebean.find(Lab2Tbl.class)
                .setDistinct(true)
                .select("location.") //must include id for select to work
                .where()
                .eq("booktitle", booktitle)
                .ge("year", year1)
                .le("year", year2)
                .findList();

 */
        return list2;
    }
}


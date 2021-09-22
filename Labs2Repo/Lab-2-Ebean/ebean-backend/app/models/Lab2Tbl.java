package models;

import java.util.*;

import com.avaje.ebean.*;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Lab2Tbl extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

//    String inproceedings;
    String author;
    String title;
    String pages;

//    @Constraints.Required
    public String year;
    String crossref;
    String journal;

//    @Constraints.Required
    public String booktitle;
    String journalVolume;
    String journalNumber;
    String ee;
    String url;
    public String location;

    public static Find<Long, Lab2Tbl> find = new Find<Long, Lab2Tbl>(){};

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


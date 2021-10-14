package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import java.util.List;

public class R11 extends Model {
    private static final long serialVersionUID = 1L;

    public static List<SqlRow> outputMetadata(String title) {
        String sql= " select * from lab1.lab1tbl"
                + " where title = :title";
        //Use sql find required data.

        SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
        sqlQuery.setParameter("title", title);

        List<SqlRow> list11 = sqlQuery.findList();

        return list11;
    }
}
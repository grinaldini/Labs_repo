package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import java.util.List;

public class R1321 extends Model {
    private static final long serialVersionUID = 1L;

    public static List<SqlRow> outputList1321(String researcher, String year) {
        String sql= " select * from lab1.lab1tbl"
                + " where author REGEXP :researcher and year = :year";
        //Use sql find required data.

        SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
        sqlQuery.setParameter("researcher", researcher);
        sqlQuery.setParameter("year", year);

        List<SqlRow> list13 = sqlQuery.findList();

        return list13;
    }
}

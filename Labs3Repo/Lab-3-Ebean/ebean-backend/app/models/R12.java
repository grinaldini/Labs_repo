package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import java.util.List;

public class R12 extends Model {
    private static final long serialVersionUID = 1L;

    public static List<SqlRow> outputList12(String journalTitle,String volume,String number) {
        String sql= " select * from lab1.lab1tbl"
                + " where journal = :journalTitle and journalVolume = :volume and journalNumber = :number";
        //Use sql find required data.

        SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
        sqlQuery.setParameter("journalTitle", journalTitle);
        sqlQuery.setParameter("volume", volume);
        sqlQuery.setParameter("number", number);

        List<SqlRow> list12 = sqlQuery.findList();

        return list12;
    }
}

package controllers;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import models.R1523;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;



import java.util.List;


/**
 * @description:
 * @author:
 * @create:
 */

public class ConferenceController extends Controller {

    public Result findConferenceLocations() {

        JsonNode req = request().body().asJson();
        String booktitle = req.get("booktitle").asText();
        String yearFrom = req.get("yearFrom").asText();
        String yearTo = req.get("yearTo").asText();

        try {
            List<SqlRow> rows = R1523.findConferenceLocations(booktitle, yearFrom, yearTo);

            return ok(Json.toJson(rows));
        }
        catch (RuntimeException e) {
            return ok(Json.toJson(e.toString()));
        }

    }
}

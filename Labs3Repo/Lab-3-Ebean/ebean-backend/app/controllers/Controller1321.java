package controllers;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import models.R1321;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Controller1321 extends Controller {
    public Result output1321() {

        JsonNode req = request().body().asJson();
        String researcher = req.get("researcher").asText();
        String year = req.get("year").asText();

        try {
            List<SqlRow> rows = R1321.outputList1321(researcher, year);

            return ok(Json.toJson(rows));
        } catch (RuntimeException e) {
            return ok(Json.toJson(e.toString()));
        }

    }
}

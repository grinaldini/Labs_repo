package controllers;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import models.R12;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Controller12 extends Controller {
    public Result output12() {

        JsonNode req = request().body().asJson();
        String journalTitle = req.get("journalTitle").asText();
        String volume = req.get("journalVolume").asText();
        String number = req.get("journalNumber").asText();

        try {
            List<SqlRow> rows = R12.outputList12(journalTitle, volume, number);

            return ok(Json.toJson(rows));
        } catch (RuntimeException e) {
            return ok(Json.toJson(e.toString()));
        }

    }
}

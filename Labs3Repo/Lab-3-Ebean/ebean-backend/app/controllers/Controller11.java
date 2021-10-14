package controllers;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import models.R11;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Controller11 extends Controller {
    public Result outputMetadata() {

        JsonNode req = request().body().asJson();
        String title = req.get("title").asText();

        try {
            List<SqlRow> rows = R11.outputMetadata(title);

            return ok(Json.toJson(rows));
        }
        catch (RuntimeException e) {
            return ok(Json.toJson(e.toString()));
        }

    }
}

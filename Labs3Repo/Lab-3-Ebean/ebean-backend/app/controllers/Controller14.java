package controllers;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import models.R14;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Controller14 extends Controller {
    public Result output14() {

        JsonNode req = request().body().asJson();
        int minimumNumberOfArticles = req.get("minimumNumberOfArticles").asInt();

        try {
            List<SqlRow> rows = R14.outputList14(minimumNumberOfArticles);

            return ok(Json.toJson(rows));
        } catch (RuntimeException e) {
            return ok(Json.toJson(e.toString()));
        }

    }
}

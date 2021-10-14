package controllers;

import com.avaje.ebean.SqlRow;
import com.fasterxml.jackson.databind.JsonNode;
import models.R22;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Controller22 extends Controller {
    public Result output22() {

        JsonNode req = request().body().asJson();
        String researcher = req.get("researcher").asText();

        try {
            List<SqlRow> rows = R22.outputList22(researcher);

            return ok(Json.toJson(rows));
        } catch (RuntimeException e) {
            return ok(Json.toJson(e.toString()));
        }

    }
}

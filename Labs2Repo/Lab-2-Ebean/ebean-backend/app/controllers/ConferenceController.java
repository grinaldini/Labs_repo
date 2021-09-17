package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Lab2Tbl;
import models.User;
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

        try {
            List <Lab2Tbl>rows = Lab2Tbl.findConferenceLocations("ICWS", "2007", "2010");

            return ok(Json.toJson(rows));
        }
        catch (RuntimeException e) {
            return ok(Json.toJson(e.toString()));
        }

    }
}

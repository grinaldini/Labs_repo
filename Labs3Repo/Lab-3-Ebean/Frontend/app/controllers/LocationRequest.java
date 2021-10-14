package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

public class LocationRequest {
    //input or request attributes
    public String booktitle;
    public String yearFrom;
    public String yearTo;

    //response attributes
    public String location;

    public CompletionStage<WSResponse> findConferenceLocation() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        WSRequest request = ws.url("http://localhost:9005/find-conference-locations");
        ObjectNode res = Json.newObject();
        res.put("booktitle", this.booktitle);
        res.put("yearFrom",this.yearFrom);
        res.put("yearTo",this.yearTo);
        System.out.println("findConferenceLocations request: " + res);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }


}

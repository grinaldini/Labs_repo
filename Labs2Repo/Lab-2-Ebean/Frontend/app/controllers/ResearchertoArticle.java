package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

public class ResearchertoArticle {
    //input two attributes
    public String researcher;
    public String year;

    public CompletionStage<WSResponse> output1321() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        WSRequest request = ws.url("http://localhost:9005/paperofResearcher");
        ObjectNode res = Json.newObject();
        res.put("researcher", this.researcher);
        res.put("year", this.year);
        System.out.println("output researcher article title or metadata request: " + res);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }

}

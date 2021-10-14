package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

public class ProductiveResearcher {
    //Input minimum number of articles.
    public String minimumNumberOfArticles;


    public CompletionStage<WSResponse> outputAuthor() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        WSRequest request = ws.url("http://localhost:9005/productiveResearcher");
        ObjectNode res = Json.newObject();
        res.put("minimumNumberOfArticles", this.minimumNumberOfArticles);
        System.out.println("productive researcher request: " + res);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }

    public CompletionStage<WSResponse> outputCoauthor(String researcher) {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        WSRequest request = ws.url("http://localhost:9005/coautherOfPResearcher");
        ObjectNode res = Json.newObject();
        res.put("researcher", researcher);
        System.out.println("coauthors of this productive researcher request: " + res);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }

}

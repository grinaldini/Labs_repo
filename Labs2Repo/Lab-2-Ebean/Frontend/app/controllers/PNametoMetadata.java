package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class PNametoMetadata {
    //Input paper name.
    public String title;

    //Response metadata.
    public List<String> metadate = new ArrayList();
    //public String metadata;

    public CompletionStage<WSResponse> outputMetadata() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        WSRequest request = ws.url("http://localhost:9005/inPnameOutMetadata");
        ObjectNode res = Json.newObject();
        res.put("title", this.title);
        System.out.println("outputPaperMetadata request: " + res);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }


}

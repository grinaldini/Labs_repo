package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class GetJournalMetadata {
    //input attributes.
    public String journalTitle;
    public String journalVolume;
    public String journalNumber;

    //output list.
    public List<String> jmetadata = new ArrayList<>();

    public CompletionStage<WSResponse> output12() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        WSRequest request = ws.url("http://localhost:9005/journalMetadata");
        ObjectNode res = Json.newObject();
        res.put("journalTitle", this.journalTitle);
        res.put("journalVolume", this.journalVolume);
        res.put("journalNumber", this.journalNumber);
        System.out.println("outputJournalMetadata request: " + res);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }


}

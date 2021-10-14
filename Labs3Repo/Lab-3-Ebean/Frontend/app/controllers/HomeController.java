package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

import static java.util.Collections.singleton;

/**
 * Software Service Market Place
 */
public class HomeController extends Controller {

    @Inject
    HttpExecutionContext ec;

    private FormFactory formFactory;

    @Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    /**
     * Index page
     */
    public Result index() {
        return ok(views.html.login.render(""));
    }

    /**
     * Index page
     */
    public Result signup() {
        return ok(views.html.register.render(null));
    }

    public CompletionStage<Result> loginHandler() {

        Form<User> loginForm = formFactory.form(User.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.login.render(""));  // send parameter like register so that user could know
        }

        return loginForm.get().checkAuthorized()
                .thenApplyAsync((WSResponse r) -> {
                    if (r.getStatus() == 200 && r.asJson() != null && r.asJson().asBoolean()) {
                        System.out.println(r.asJson());
                        // add username to session
                        session("username", loginForm.get().getUsername());   // store username in session for your project
                        // redirect to index page, to display all categories
                        return ok(views.html.index.render("Welcome!!! " + loginForm.get().getUsername()));
                    } else {
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect Username or Password ";
                        return badRequest(views.html.login.render(authorizeMessage));
                    }
                }, ec.current());
    }

    public CompletionStage<Result> signupHandler() {

        Form<User> registrationForm = formFactory.form(User.class).bindFromRequest();
        if (registrationForm.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.register.render(null));
        }
        return registrationForm.get().registerUser()
                .thenApplyAsync((WSResponse r) -> {
                    if (r.getStatus() == 200 && r.asJson() != null) {
                        System.out.println("success");
                        System.out.println(r.asJson());
                        return ok(views.html.index.render(r.toString()));
                    } else {
                        System.out.println("response null");
                        return badRequest(views.html.register.render("Username already exists"));
                    }
                }, ec.current());

    }

    //1.1
    public Result titleBlank() {
        return ok(views.html.title_blank.render());
    }

    public CompletionStage<Result> outputMetadata() {

        Form<PNametoMetadata> titleBlank = formFactory.form(PNametoMetadata.class).bindFromRequest();
        if (titleBlank.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.paper_metadata_list.render(Arrays.asList("Error")));
        }

        return titleBlank.get().outputMetadata()
                .thenApplyAsync((WSResponse r) -> {
                    if (r != null) {
                        System.out.println("outputMetadata response: " + r.asJson());
                        JsonNode node = r.asJson();
                        String str = node.toString();
                        //Tranfrom Json object to String.

                        List<String> metadata = Arrays.asList(str.split(","));
                        //separate the String with comma "," as a separator.
                        //System.out.println(metadata);

                        /*for (JsonNode node: r.asJson()) {
                            System.out.println(node);
                            metadata.add(node.get("metadata").toString());
                        }*/
                        //String[] a = locations.toArray(new String[locations.size()]);

                        return ok(views.html.paper_metadata_list.render(metadata));
                    } else {
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect, error";
                        return badRequest(views.html.login.render(authorizeMessage));
                    }
                }, ec.current());
    }

    //1.2
    public Result journalRequestForm() {
        return ok(views.html.journal_form.render());
    }

    public CompletionStage<Result> outputJournal() {

        Form<GetJournalMetadata> journalForm = formFactory.form(GetJournalMetadata.class).bindFromRequest();
        if (journalForm.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.journal_list.render(Arrays.asList("Error")));
        }

        return journalForm.get().output12()
                .thenApplyAsync((WSResponse r) -> {
                    if (r != null) {
                        System.out.println("journal metadata response: " + r.asJson());

                        List<String> journalMetadata = new ArrayList<>();
                        //Used to store transformed Json object.

                        for (JsonNode node: r.asJson()) {
                            System.out.println(node);
                            journalMetadata.add(node.toString());
                        }

                        return ok(views.html.journal_list.render(journalMetadata));
                    } else {
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect, error";
                        return badRequest(views.html.login.render(authorizeMessage));
                    }
                }, ec.current());
    }

    //Form for 1.3 and 2.1
    public Result researcherYearForm() {
        return ok(views.html.researcher_year_form.render());
    }

    //1.3 output researcher`s article title.
    public CompletionStage<Result> outputTitle() {

        Form<ResearchertoArticle> nameYearForm = formFactory.form(ResearchertoArticle.class).bindFromRequest();
        if (nameYearForm.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.title_list.render(Arrays.asList("Error")));
        }

        return nameYearForm.get().output1321()
                .thenApplyAsync((WSResponse r) -> {
                    if (r != null) {
                        System.out.println("paper title response: " + r.asJson());
                        List<String> title = new ArrayList<>();
                        for (JsonNode node: r.asJson()) {
                            System.out.println(node);
                            title.add(node.get("title").toString());
                        }

                        return ok(views.html.title_list.render(title));
                    } else {
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect, error";
                        return badRequest(views.html.login.render(authorizeMessage));
                    }
                }, ec.current());
    }

    //2.1 output metadata of researcher`s article.
    public Result researcherYearFormMeta() {
        return ok(views.html.researcher_year_form_meta.render());
    }

    public CompletionStage<Result> outputResearcherArticle() {

        Form<ResearchertoArticle> nameYearForm = formFactory.form(ResearchertoArticle.class).bindFromRequest();
        if (nameYearForm.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.researcher_article_list.render(Arrays.asList("Error")));
        }

        return nameYearForm.get().output1321()
                .thenApplyAsync((WSResponse r) -> {
                    if (r != null) {
                        System.out.println("paper articles response: " + r.asJson());
                        List<String> article = new ArrayList<>();
                        for (JsonNode node: r.asJson()) {
                            System.out.println(node);
                            article.add(node.toString());
                        }

                        return ok(views.html.researcher_article_list.render(article));
                    } else {
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect, error";
                        return badRequest(views.html.login.render(authorizeMessage));
                    }
                }, ec.current());
    }

    //1.4
    public Result minimumNumberBlank() {
        return ok(views.html.minimum_number_blank.render());
    }

    public CompletionStage<Result> outputAuthors() {

        Form<ProductiveResearcher> miniNumBlank = formFactory.form(ProductiveResearcher.class).bindFromRequest();
        if (miniNumBlank.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.author_list.render(Arrays.asList("Error")));
        }

        return miniNumBlank.get().outputAuthor()
                .thenApplyAsync((WSResponse r) -> {
                    if (r != null) {
                        System.out.println("output author response: " + r.asJson());
                        List<String> productiveAuthor = new ArrayList<>();

                        //List<String> allCoauthors = new ArrayList<>();
                        //Tranfrom Json object to String.

                        for (JsonNode node: r.asJson()) {
                            System.out.println(node);
                            productiveAuthor.add(node.toString());
                        }

                        //System.out.println(allCoauthors);

                        //List<String> outputAuthors = productiveAuthor;

                        /*for(int i = 0; i < productiveAuthor.size(); i++){
                            String coauthorsOfOneR = outputCoauthors(productiveAuthor.get(i));
                            System.out.println("Single:"+coauthorsOfOneR);
                            allCoauthors.add(coauthorsOfOneR);
                        }*/

                        return ok(views.html.author_list.render(productiveAuthor));
                    } else {
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect, error";
                        return badRequest(views.html.login.render(authorizeMessage));
                    }
                }, ec.current());
    }

    //2.2
    public Result miniNumberBlankForCoauthor() {
        return ok(views.html.minimum_number_blank_coauthor.render());
    }
    public CompletionStage<Result> outputCoauthors() {

        Form<ProductiveResearcher> miniNumBlank = formFactory.form(ProductiveResearcher.class).bindFromRequest();
        if (miniNumBlank.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.coauthor_list.render(Arrays.asList("Error"),Arrays.asList("Error")));
        }

        return miniNumBlank.get().outputAuthor()
                .thenApplyAsync((WSResponse r) -> {
                    if (r != null) {
                        System.out.println("output author response: " + r.asJson());
                        List<String> productiveAuthor = new ArrayList<>();
                        List<String> coauthors = new ArrayList<>();

                        for (JsonNode node: r.asJson()) {
                            //System.out.println(node);
                            productiveAuthor.add(node.asText());
                        }//used to find coauthors.

                        for(int i = 0; i<productiveAuthor.size();i++){
                            coauthors.add(outputAllCoauthors(productiveAuthor.get(i)));
                        }

                        List<String> pauthorsOutput = productiveAuthor;

                        return ok(views.html.coauthor_list.render(pauthorsOutput,coauthors));
                    } else {
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect, error";
                        return badRequest(views.html.login.render(authorizeMessage));
                    }
                }, ec.current());
    }
    public String outputAllCoauthors(String productiveAuthor) {
        List<String> coauthors = new ArrayList<>();
        String coauthorOut = null;

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ebeantest", "root", "201269")) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                String sql= " select author from ebeantest.lab2tbl"
                        + " where author like \"%"+productiveAuthor+"%\" ";
                //Use sql find required data.

                List<String> list22 = new ArrayList<>();

                PreparedStatement stmt = conn.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()){
                    list22.add(rs.getString("author"));
                }

                System.out.println(list22);

                String buffer;

                for(int a = 0;a < list22.size();a++){
                    buffer = list22.get(a);
                    coauthors.addAll(Arrays.asList(buffer.split("\\|")));
                }
                coauthors.removeAll(singleton(productiveAuthor));
                coauthors.removeAll(singleton(""));
                //System.out.println(coauthors);
                //remove the productive researcher him/herself and empty elements.

                //remove duplicate elements.
                for  ( int  i = 0 ; i < coauthors.size()-1; i ++)  {
                    for  ( int  j = coauthors.size()-1; j > i; j -- )  {
                        if  (coauthors.get(j).equals(coauthors.get(i)))  {
                            coauthors.remove(j);
                        }
                    }
                }

                coauthorOut = coauthorOut.join("||",coauthors);

                return coauthorOut;

            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coauthorOut;

    }

    //1.5&2.3
    public Result locationRequestForm() {
        return ok(views.html.conference_locations_form.render());
    }

    public CompletionStage<Result> findConferenceLocations() {

        Form<LocationRequest> locReqForm = formFactory.form(LocationRequest.class).bindFromRequest();
        if (locReqForm.hasErrors()) {
            return (CompletionStage<Result>) badRequest(views.html.conference_locations_list.render(Arrays.asList("Error")));
        }

        return locReqForm.get().findConferenceLocation()
                .thenApplyAsync((WSResponse r) -> {
                    if (r != null) {
                        System.out.println("findConferenceLocations response: " + r.asJson());
                        List<String> locations = new ArrayList<>();
                        for (JsonNode node: r.asJson()) {
                            System.out.println(node);
                            locations.add(node.get("location").toString());
                        }
                        //String[] a = locations.toArray(new String[locations.size()]);

                        return ok(views.html.conference_locations_list.render(locations));
                    } else {
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect, error";
                        return badRequest(views.html.login.render(authorizeMessage));
                    }
                }, ec.current());
    }
}
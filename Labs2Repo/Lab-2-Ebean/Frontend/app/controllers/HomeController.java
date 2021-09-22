package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSResponse;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

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
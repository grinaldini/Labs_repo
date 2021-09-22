
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/gian9898/Documents/sandbox/dev/cs7340_repo/git_labs_repo/Labs_repo/Labs2Repo/Lab-2-Ebean/ebean-backend/conf/routes
// @DATE:Sun Sep 19 11:49:46 CDT 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseConferenceController ConferenceController = new controllers.ReverseConferenceController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseConferenceController ConferenceController = new controllers.javascript.ReverseConferenceController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
  }

}

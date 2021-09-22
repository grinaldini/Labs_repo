// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/gian9898/Documents/sandbox/dev/cs7340_repo/git_labs_repo/Labs_repo/Labs2Repo/Lab-2-Ebean/Frontend/conf/routes
// @DATE:Sun Sep 19 12:05:42 CDT 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}

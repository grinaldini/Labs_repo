
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/gian9898/Documents/sandbox/dev/cs7340_repo/git_labs_repo/Labs_repo/Labs2Repo/Lab-2-Ebean/ebean-backend/conf/routes
// @DATE:Thu Sep 16 20:31:31 CDT 2021

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseConferenceController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def findConferenceLocations: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ConferenceController.findConferenceLocations",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "find-conference-locations"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.authenticate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:14
    def registerNew: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.registerNew",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
        }
      """
    )
  
  }


}

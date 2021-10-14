// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/Frontend/conf/routes
// @DATE:Fri Oct 01 22:47:11 CDT 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def miniNumberBlankForCoauthor: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.miniNumberBlankForCoauthor",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mini-number-blank-coauthor"})
        }
      """
    )
  
    // @LINE:20
    def outputTitle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.outputTitle",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "title-list"})
        }
      """
    )
  
    // @LINE:35
    def locationRequestForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.locationRequestForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "conference-locations-form"})
        }
      """
    )
  
    // @LINE:27
    def researcherYearFormMeta: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.researcherYearFormMeta",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "researcher-year-form-meta"})
        }
      """
    )
  
    // @LINE:28
    def outputResearcherArticle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.outputResearcherArticle",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "researcher-article-list"})
        }
      """
    )
  
    // @LINE:36
    def findConferenceLocations: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.findConferenceLocations",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "conference-locations-list"})
        }
      """
    )
  
    // @LINE:38
    def signup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.signup",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
        }
      """
    )
  
    // @LINE:24
    def outputAuthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.outputAuthors",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authors-list"})
        }
      """
    )
  
    // @LINE:15
    def journalRequestForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.journalRequestForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "journal-form"})
        }
      """
    )
  
    // @LINE:11
    def titleBlank: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.titleBlank",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "title-blank"})
        }
      """
    )
  
    // @LINE:16
    def outputJournal: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.outputJournal",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "journal-metadata-list"})
        }
      """
    )
  
    // @LINE:8
    def loginHandler: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.loginHandler",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:40
    def signupHandler: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.signupHandler",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:19
    def researcherYearForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.researcherYearForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "researcher-year-form"})
        }
      """
    )
  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:32
    def outputCoauthors: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.outputCoauthors",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "coauthor-list"})
        }
      """
    )
  
    // @LINE:12
    def outputMetadata: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.outputMetadata",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "metadata-list"})
        }
      """
    )
  
    // @LINE:23
    def minimumNumberBlank: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.minimumNumberBlank",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "minimum-number-blank"})
        }
      """
    )
  
  }

  // @LINE:43
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}

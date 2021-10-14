// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/Frontend/conf/routes
// @DATE:Fri Oct 01 22:47:11 CDT 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def miniNumberBlankForCoauthor(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "mini-number-blank-coauthor")
    }
  
    // @LINE:20
    def outputTitle(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "title-list")
    }
  
    // @LINE:35
    def locationRequestForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "conference-locations-form")
    }
  
    // @LINE:27
    def researcherYearFormMeta(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "researcher-year-form-meta")
    }
  
    // @LINE:28
    def outputResearcherArticle(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "researcher-article-list")
    }
  
    // @LINE:36
    def findConferenceLocations(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "conference-locations-list")
    }
  
    // @LINE:38
    def signup(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signup")
    }
  
    // @LINE:24
    def outputAuthors(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "authors-list")
    }
  
    // @LINE:15
    def journalRequestForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "journal-form")
    }
  
    // @LINE:11
    def titleBlank(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "title-blank")
    }
  
    // @LINE:16
    def outputJournal(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "journal-metadata-list")
    }
  
    // @LINE:8
    def loginHandler(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:40
    def signupHandler(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:19
    def researcherYearForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "researcher-year-form")
    }
  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:32
    def outputCoauthors(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "coauthor-list")
    }
  
    // @LINE:12
    def outputMetadata(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "metadata-list")
    }
  
    // @LINE:23
    def minimumNumberBlank(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "minimum-number-blank")
    }
  
  }

  // @LINE:43
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}

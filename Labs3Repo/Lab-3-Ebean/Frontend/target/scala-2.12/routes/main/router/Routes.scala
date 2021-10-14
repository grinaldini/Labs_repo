// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/Frontend/conf/routes
// @DATE:Fri Oct 01 22:47:11 CDT 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_1: controllers.HomeController,
  // @LINE:43
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_1: controllers.HomeController,
    // @LINE:43
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.HomeController.loginHandler()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """title-blank""", """controllers.HomeController.titleBlank()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """metadata-list""", """controllers.HomeController.outputMetadata()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """journal-form""", """controllers.HomeController.journalRequestForm()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """journal-metadata-list""", """controllers.HomeController.outputJournal()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """researcher-year-form""", """controllers.HomeController.researcherYearForm()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """title-list""", """controllers.HomeController.outputTitle()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """minimum-number-blank""", """controllers.HomeController.minimumNumberBlank()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authors-list""", """controllers.HomeController.outputAuthors()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """researcher-year-form-meta""", """controllers.HomeController.researcherYearFormMeta()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """researcher-article-list""", """controllers.HomeController.outputResearcherArticle()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mini-number-blank-coauthor""", """controllers.HomeController.miniNumberBlankForCoauthor()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """coauthor-list""", """controllers.HomeController.outputCoauthors()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """conference-locations-form""", """controllers.HomeController.locationRequestForm()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """conference-locations-list""", """controllers.HomeController.findConferenceLocations()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.HomeController.signup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.HomeController.signupHandler()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_loginHandler1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_HomeController_loginHandler1_invoker = createInvoker(
    HomeController_1.loginHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "loginHandler",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_titleBlank2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title-blank")))
  )
  private[this] lazy val controllers_HomeController_titleBlank2_invoker = createInvoker(
    HomeController_1.titleBlank(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "titleBlank",
      Nil,
      "GET",
      this.prefix + """title-blank""",
      """1.1""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_outputMetadata3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("metadata-list")))
  )
  private[this] lazy val controllers_HomeController_outputMetadata3_invoker = createInvoker(
    HomeController_1.outputMetadata(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "outputMetadata",
      Nil,
      "GET",
      this.prefix + """metadata-list""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_journalRequestForm4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("journal-form")))
  )
  private[this] lazy val controllers_HomeController_journalRequestForm4_invoker = createInvoker(
    HomeController_1.journalRequestForm(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "journalRequestForm",
      Nil,
      "GET",
      this.prefix + """journal-form""",
      """1.2""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_HomeController_outputJournal5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("journal-metadata-list")))
  )
  private[this] lazy val controllers_HomeController_outputJournal5_invoker = createInvoker(
    HomeController_1.outputJournal(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "outputJournal",
      Nil,
      "GET",
      this.prefix + """journal-metadata-list""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_HomeController_researcherYearForm6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("researcher-year-form")))
  )
  private[this] lazy val controllers_HomeController_researcherYearForm6_invoker = createInvoker(
    HomeController_1.researcherYearForm(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "researcherYearForm",
      Nil,
      "GET",
      this.prefix + """researcher-year-form""",
      """1.3""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_HomeController_outputTitle7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("title-list")))
  )
  private[this] lazy val controllers_HomeController_outputTitle7_invoker = createInvoker(
    HomeController_1.outputTitle(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "outputTitle",
      Nil,
      "GET",
      this.prefix + """title-list""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_HomeController_minimumNumberBlank8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("minimum-number-blank")))
  )
  private[this] lazy val controllers_HomeController_minimumNumberBlank8_invoker = createInvoker(
    HomeController_1.minimumNumberBlank(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "minimumNumberBlank",
      Nil,
      "GET",
      this.prefix + """minimum-number-blank""",
      """1.4""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HomeController_outputAuthors9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authors-list")))
  )
  private[this] lazy val controllers_HomeController_outputAuthors9_invoker = createInvoker(
    HomeController_1.outputAuthors(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "outputAuthors",
      Nil,
      "GET",
      this.prefix + """authors-list""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HomeController_researcherYearFormMeta10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("researcher-year-form-meta")))
  )
  private[this] lazy val controllers_HomeController_researcherYearFormMeta10_invoker = createInvoker(
    HomeController_1.researcherYearFormMeta(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "researcherYearFormMeta",
      Nil,
      "GET",
      this.prefix + """researcher-year-form-meta""",
      """2.1""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_HomeController_outputResearcherArticle11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("researcher-article-list")))
  )
  private[this] lazy val controllers_HomeController_outputResearcherArticle11_invoker = createInvoker(
    HomeController_1.outputResearcherArticle(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "outputResearcherArticle",
      Nil,
      "GET",
      this.prefix + """researcher-article-list""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_HomeController_miniNumberBlankForCoauthor12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mini-number-blank-coauthor")))
  )
  private[this] lazy val controllers_HomeController_miniNumberBlankForCoauthor12_invoker = createInvoker(
    HomeController_1.miniNumberBlankForCoauthor(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "miniNumberBlankForCoauthor",
      Nil,
      "GET",
      this.prefix + """mini-number-blank-coauthor""",
      """2.2""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_HomeController_outputCoauthors13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("coauthor-list")))
  )
  private[this] lazy val controllers_HomeController_outputCoauthors13_invoker = createInvoker(
    HomeController_1.outputCoauthors(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "outputCoauthors",
      Nil,
      "GET",
      this.prefix + """coauthor-list""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_HomeController_locationRequestForm14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("conference-locations-form")))
  )
  private[this] lazy val controllers_HomeController_locationRequestForm14_invoker = createInvoker(
    HomeController_1.locationRequestForm(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "locationRequestForm",
      Nil,
      "GET",
      this.prefix + """conference-locations-form""",
      """1.5&2.3""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_HomeController_findConferenceLocations15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("conference-locations-list")))
  )
  private[this] lazy val controllers_HomeController_findConferenceLocations15_invoker = createInvoker(
    HomeController_1.findConferenceLocations(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "findConferenceLocations",
      Nil,
      "GET",
      this.prefix + """conference-locations-list""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_HomeController_signup16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_HomeController_signup16_invoker = createInvoker(
    HomeController_1.signup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "signup",
      Nil,
      "GET",
      this.prefix + """signup""",
      """""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_HomeController_signupHandler17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_HomeController_signupHandler17_invoker = createInvoker(
    HomeController_1.signupHandler(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "signupHandler",
      Nil,
      "GET",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_Assets_at18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at18_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index())
      }
  
    // @LINE:8
    case controllers_HomeController_loginHandler1_route(params@_) =>
      call { 
        controllers_HomeController_loginHandler1_invoker.call(HomeController_1.loginHandler())
      }
  
    // @LINE:11
    case controllers_HomeController_titleBlank2_route(params@_) =>
      call { 
        controllers_HomeController_titleBlank2_invoker.call(HomeController_1.titleBlank())
      }
  
    // @LINE:12
    case controllers_HomeController_outputMetadata3_route(params@_) =>
      call { 
        controllers_HomeController_outputMetadata3_invoker.call(HomeController_1.outputMetadata())
      }
  
    // @LINE:15
    case controllers_HomeController_journalRequestForm4_route(params@_) =>
      call { 
        controllers_HomeController_journalRequestForm4_invoker.call(HomeController_1.journalRequestForm())
      }
  
    // @LINE:16
    case controllers_HomeController_outputJournal5_route(params@_) =>
      call { 
        controllers_HomeController_outputJournal5_invoker.call(HomeController_1.outputJournal())
      }
  
    // @LINE:19
    case controllers_HomeController_researcherYearForm6_route(params@_) =>
      call { 
        controllers_HomeController_researcherYearForm6_invoker.call(HomeController_1.researcherYearForm())
      }
  
    // @LINE:20
    case controllers_HomeController_outputTitle7_route(params@_) =>
      call { 
        controllers_HomeController_outputTitle7_invoker.call(HomeController_1.outputTitle())
      }
  
    // @LINE:23
    case controllers_HomeController_minimumNumberBlank8_route(params@_) =>
      call { 
        controllers_HomeController_minimumNumberBlank8_invoker.call(HomeController_1.minimumNumberBlank())
      }
  
    // @LINE:24
    case controllers_HomeController_outputAuthors9_route(params@_) =>
      call { 
        controllers_HomeController_outputAuthors9_invoker.call(HomeController_1.outputAuthors())
      }
  
    // @LINE:27
    case controllers_HomeController_researcherYearFormMeta10_route(params@_) =>
      call { 
        controllers_HomeController_researcherYearFormMeta10_invoker.call(HomeController_1.researcherYearFormMeta())
      }
  
    // @LINE:28
    case controllers_HomeController_outputResearcherArticle11_route(params@_) =>
      call { 
        controllers_HomeController_outputResearcherArticle11_invoker.call(HomeController_1.outputResearcherArticle())
      }
  
    // @LINE:31
    case controllers_HomeController_miniNumberBlankForCoauthor12_route(params@_) =>
      call { 
        controllers_HomeController_miniNumberBlankForCoauthor12_invoker.call(HomeController_1.miniNumberBlankForCoauthor())
      }
  
    // @LINE:32
    case controllers_HomeController_outputCoauthors13_route(params@_) =>
      call { 
        controllers_HomeController_outputCoauthors13_invoker.call(HomeController_1.outputCoauthors())
      }
  
    // @LINE:35
    case controllers_HomeController_locationRequestForm14_route(params@_) =>
      call { 
        controllers_HomeController_locationRequestForm14_invoker.call(HomeController_1.locationRequestForm())
      }
  
    // @LINE:36
    case controllers_HomeController_findConferenceLocations15_route(params@_) =>
      call { 
        controllers_HomeController_findConferenceLocations15_invoker.call(HomeController_1.findConferenceLocations())
      }
  
    // @LINE:38
    case controllers_HomeController_signup16_route(params@_) =>
      call { 
        controllers_HomeController_signup16_invoker.call(HomeController_1.signup())
      }
  
    // @LINE:40
    case controllers_HomeController_signupHandler17_route(params@_) =>
      call { 
        controllers_HomeController_signupHandler17_invoker.call(HomeController_1.signupHandler())
      }
  
    // @LINE:43
    case controllers_Assets_at18_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at18_invoker.call(Assets_0.at(path, file))
      }
  }
}

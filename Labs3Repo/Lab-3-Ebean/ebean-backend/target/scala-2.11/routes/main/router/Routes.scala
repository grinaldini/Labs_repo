
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/ebean-backend/conf/routes
// @DATE:Thu Sep 30 20:17:16 CDT 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  Controller11_3: controllers.Controller11,
  // @LINE:12
  Controller12_5: controllers.Controller12,
  // @LINE:15
  Controller1321_2: controllers.Controller1321,
  // @LINE:18
  Controller14_1: controllers.Controller14,
  // @LINE:21
  Controller22_7: controllers.Controller22,
  // @LINE:24
  ConferenceController_6: controllers.ConferenceController,
  // @LINE:27
  UserController_4: controllers.UserController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    Controller11_3: controllers.Controller11,
    // @LINE:12
    Controller12_5: controllers.Controller12,
    // @LINE:15
    Controller1321_2: controllers.Controller1321,
    // @LINE:18
    Controller14_1: controllers.Controller14,
    // @LINE:21
    Controller22_7: controllers.Controller22,
    // @LINE:24
    ConferenceController_6: controllers.ConferenceController,
    // @LINE:27
    UserController_4: controllers.UserController
  ) = this(errorHandler, HomeController_0, Controller11_3, Controller12_5, Controller1321_2, Controller14_1, Controller22_7, ConferenceController_6, UserController_4, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Controller11_3, Controller12_5, Controller1321_2, Controller14_1, Controller22_7, ConferenceController_6, UserController_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """inPnameOutMetadata""", """controllers.Controller11.outputMetadata()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """journalMetadata""", """controllers.Controller12.output12()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paperofResearcher""", """controllers.Controller1321.output1321()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """productiveResearcher""", """controllers.Controller14.output14()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """coautherOfPResearcher""", """controllers.Controller22.output22()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """find-conference-locations""", """controllers.ConferenceController.findConferenceLocations()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.authenticate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.UserController.registerNew()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Controller11_outputMetadata1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("inPnameOutMetadata")))
  )
  private[this] lazy val controllers_Controller11_outputMetadata1_invoker = createInvoker(
    Controller11_3.outputMetadata(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Controller11",
      "outputMetadata",
      Nil,
      "POST",
      """1.1""",
      this.prefix + """inPnameOutMetadata"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Controller12_output122_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("journalMetadata")))
  )
  private[this] lazy val controllers_Controller12_output122_invoker = createInvoker(
    Controller12_5.output12(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Controller12",
      "output12",
      Nil,
      "POST",
      """1.2""",
      this.prefix + """journalMetadata"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Controller1321_output13213_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paperofResearcher")))
  )
  private[this] lazy val controllers_Controller1321_output13213_invoker = createInvoker(
    Controller1321_2.output1321(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Controller1321",
      "output1321",
      Nil,
      "POST",
      """1.3&2.1""",
      this.prefix + """paperofResearcher"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Controller14_output144_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("productiveResearcher")))
  )
  private[this] lazy val controllers_Controller14_output144_invoker = createInvoker(
    Controller14_1.output14(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Controller14",
      "output14",
      Nil,
      "POST",
      """1.4""",
      this.prefix + """productiveResearcher"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Controller22_output225_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("coautherOfPResearcher")))
  )
  private[this] lazy val controllers_Controller22_output225_invoker = createInvoker(
    Controller22_7.output22(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Controller22",
      "output22",
      Nil,
      "POST",
      """2.2""",
      this.prefix + """coautherOfPResearcher"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_ConferenceController_findConferenceLocations6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("find-conference-locations")))
  )
  private[this] lazy val controllers_ConferenceController_findConferenceLocations6_invoker = createInvoker(
    ConferenceController_6.findConferenceLocations(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ConferenceController",
      "findConferenceLocations",
      Nil,
      "POST",
      """1.5&2.3""",
      this.prefix + """find-conference-locations"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_UserController_authenticate7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserController_authenticate7_invoker = createInvoker(
    UserController_4.authenticate(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "authenticate",
      Nil,
      "POST",
      """Login""",
      this.prefix + """login"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_UserController_registerNew8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_UserController_registerNew8_invoker = createInvoker(
    UserController_4.registerNew(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "registerNew",
      Nil,
      "POST",
      """ Add User  {"name":name, "password":password}""",
      this.prefix + """signup"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_Controller11_outputMetadata1_route(params) =>
      call { 
        controllers_Controller11_outputMetadata1_invoker.call(Controller11_3.outputMetadata())
      }
  
    // @LINE:12
    case controllers_Controller12_output122_route(params) =>
      call { 
        controllers_Controller12_output122_invoker.call(Controller12_5.output12())
      }
  
    // @LINE:15
    case controllers_Controller1321_output13213_route(params) =>
      call { 
        controllers_Controller1321_output13213_invoker.call(Controller1321_2.output1321())
      }
  
    // @LINE:18
    case controllers_Controller14_output144_route(params) =>
      call { 
        controllers_Controller14_output144_invoker.call(Controller14_1.output14())
      }
  
    // @LINE:21
    case controllers_Controller22_output225_route(params) =>
      call { 
        controllers_Controller22_output225_invoker.call(Controller22_7.output22())
      }
  
    // @LINE:24
    case controllers_ConferenceController_findConferenceLocations6_route(params) =>
      call { 
        controllers_ConferenceController_findConferenceLocations6_invoker.call(ConferenceController_6.findConferenceLocations())
      }
  
    // @LINE:27
    case controllers_UserController_authenticate7_route(params) =>
      call { 
        controllers_UserController_authenticate7_invoker.call(UserController_4.authenticate())
      }
  
    // @LINE:31
    case controllers_UserController_registerNew8_route(params) =>
      call { 
        controllers_UserController_registerNew8_invoker.call(UserController_4.registerNew())
      }
  }
}

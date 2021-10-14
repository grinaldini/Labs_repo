
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/ebean-backend/conf/routes
// @DATE:Thu Sep 30 20:17:16 CDT 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}

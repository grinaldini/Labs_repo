
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import play.api.libs.json.Json
/*2.2*/import scala.collection.JavaConverters._

object researcher_article_list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(article: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Play Setup Demo</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />

        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
        crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js" integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
        crossorigin=""></script>

    </head>
    <body>
        <header class="topbar">
            <h1 class="focused" style="font-size: 37px;
                color: #4cc9f0">
                <strong>Researcher`s article</strong>
            </h1>
        </header>
        <!--<p class="focused" style="font-size: 20px;
            color: #3F51B5">"""),_display_(/*32.30*/article),format.raw/*32.37*/("""</p>-->

        <script>
            var articles= """),_display_(/*35.28*/Html(article.toString())),format.raw/*35.52*/(""";

            for(let f = 0; f < articles.length; f++) """),format.raw/*37.54*/("""{"""),format.raw/*37.55*/("""
                """),format.raw/*38.17*/("""document.write(JSON.stringify(articles[f]));
                document.write("<br>")
                document.write("<br>")
            """),format.raw/*41.13*/("""}"""),format.raw/*41.14*/("""

        """),format.raw/*43.9*/("""</script>

    </body>
</html>
"""))
      }
    }
  }

  def render(article:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(article)

  def f:((List[String]) => play.twirl.api.HtmlFormat.Appendable) = (article) => apply(article)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-30T20:41:16.561
                  SOURCE: C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/Frontend/app/views/researcher_article_list.scala.html
                  HASH: 64d447b377e1341f68221be64b4787a6e229798f
                  MATRIX: 651->1|689->33|1058->75|1175->99|2663->1562|2691->1569|2771->1622|2816->1646|2900->1702|2929->1703|2974->1720|3137->1855|3166->1856|3203->1866
                  LINES: 24->1|25->2|30->3|35->4|63->32|63->32|66->35|66->35|68->37|68->37|69->38|72->41|72->41|74->43
                  -- GENERATED --
              */
          
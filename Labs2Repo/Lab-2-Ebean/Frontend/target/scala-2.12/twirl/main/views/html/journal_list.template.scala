
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

object journal_list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(journalMetadata: List[String]):play.twirl.api.HtmlFormat.Appendable = {
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
                <strong>Journal Metadata</strong>
            </h1>
        </header>
        <!--<p class="focused" style="font-size: 20px;
            color: #3F51B5">"""),_display_(/*32.30*/journalMetadata),format.raw/*32.45*/("""</p>-->

        <script>
              var journals= """),_display_(/*35.30*/Html(journalMetadata.toString())),format.raw/*35.62*/(""";

              for(let f = 0; f < journals.length; f++) """),format.raw/*37.56*/("""{"""),format.raw/*37.57*/("""
                  """),format.raw/*38.19*/("""document.write(JSON.stringify(journals[f]));
                  document.write("<br>")
                  document.write("<br>")
              """),format.raw/*41.15*/("""}"""),format.raw/*41.16*/("""

        """),format.raw/*43.9*/("""</script>

    </body>
</html>
"""))
      }
    }
  }

  def render(journalMetadata:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(journalMetadata)

  def f:((List[String]) => play.twirl.api.HtmlFormat.Appendable) = (journalMetadata) => apply(journalMetadata)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-30T20:41:16.548
                  SOURCE: C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/Frontend/app/views/journal_list.scala.html
                  HASH: b271a304c8cb6fd02f0f204bc84ea8999d41b346
                  MATRIX: 651->1|689->33|1047->75|1172->107|2656->1566|2692->1581|2774->1636|2827->1668|2913->1726|2942->1727|2989->1746|3158->1887|3187->1888|3224->1898
                  LINES: 24->1|25->2|30->3|35->4|63->32|63->32|66->35|66->35|68->37|68->37|69->38|72->41|72->41|74->43
                  -- GENERATED --
              */
          
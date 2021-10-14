
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

object paper_metadata_list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(metadata: List[String]):play.twirl.api.HtmlFormat.Appendable = {
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
                <strong>Paper Metadata</strong>
            </h1>
        </header>
        <!--<p class="focused" style="font-size: 20px;
            color: #3F51B5">"""),_display_(/*32.30*/metadata),format.raw/*32.38*/("""</p>-->

        <script>
              var metadata= """),_display_(/*35.30*/Html(metadata.toString())),format.raw/*35.55*/(""";

              for(let f = 0; f < metadata.length; f++) """),format.raw/*37.56*/("""{"""),format.raw/*37.57*/("""
                  """),format.raw/*38.19*/("""document.write(JSON.stringify(metadata[f]));
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

  def render(metadata:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(metadata)

  def f:((List[String]) => play.twirl.api.HtmlFormat.Appendable) = (metadata) => apply(metadata)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-30T20:41:16.555
                  SOURCE: C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/Frontend/app/views/paper_metadata_list.scala.html
                  HASH: f64449f5ba8d375471721485fb9526df8d96ee78
                  MATRIX: 651->1|689->33|1054->75|1172->100|2654->1557|2683->1565|2765->1620|2811->1645|2897->1703|2926->1704|2973->1723|3142->1864|3171->1865|3208->1875
                  LINES: 24->1|25->2|30->3|35->4|63->32|63->32|66->35|66->35|68->37|68->37|69->38|72->41|72->41|74->43
                  -- GENERATED --
              */
          
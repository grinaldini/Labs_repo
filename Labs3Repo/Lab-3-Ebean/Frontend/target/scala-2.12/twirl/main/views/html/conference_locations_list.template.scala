
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

object conference_locations_list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(locations: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Play Setup Demo</title>
        <!--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />
        -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A=="
        crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js" integrity="sha512-XQoYMqMTK8LvdxXYG3nZ448hOEQiglfqkJs1NOQV44cWnUrBc8PkAOcXy20w0vlaXaVUearIOBhiXZ5V3ynxwA=="
        crossorigin=""></script>
        <style>
                #mapid """),format.raw/*23.24*/("""{"""),format.raw/*23.25*/(""" """),format.raw/*23.26*/("""height: 360px; """),format.raw/*23.41*/("""}"""),format.raw/*23.42*/("""
        """),format.raw/*24.9*/("""</style>
    </head>
    <body>
        <header class="topbar">
            <h1 class="focused" style="font-size: 37px;
                color: #4cc9f0">
                <strong>Conference Locations</strong>
            </h1>
        </header>
        <p class="focused" style="font-size: 20px;
            color: #3F51B5">"""),_display_(/*34.30*/locations),format.raw/*34.39*/("""</p>
        <div id="mapid"></div>
        <script>

                var mymap = L.map('mapid').setView([51.505, -0.09], 2);
                console.log("After");
                console.log(mymap);
            L.tileLayer('https://api.mapbox.com/styles/v1/"""),format.raw/*41.59*/("""{"""),format.raw/*41.60*/("""id"""),format.raw/*41.62*/("""}"""),format.raw/*41.63*/("""/tiles/"""),format.raw/*41.70*/("""{"""),format.raw/*41.71*/("""z"""),format.raw/*41.72*/("""}"""),format.raw/*41.73*/("""/"""),format.raw/*41.74*/("""{"""),format.raw/*41.75*/("""x"""),format.raw/*41.76*/("""}"""),format.raw/*41.77*/("""/"""),format.raw/*41.78*/("""{"""),format.raw/*41.79*/("""y"""),format.raw/*41.80*/("""}"""),format.raw/*41.81*/("""?access_token="""),format.raw/*41.95*/("""{"""),format.raw/*41.96*/("""accessToken"""),format.raw/*41.107*/("""}"""),format.raw/*41.108*/("""', """),format.raw/*41.111*/("""{"""),format.raw/*41.112*/("""
                """),format.raw/*42.17*/("""attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                maxZoom: 18,
                id: 'mapbox/streets-v11',
                tileSize: 512,
                zoomOffset: -1,
                accessToken: 'pk.eyJ1IjoiZ2lhbjk4OTgiLCJhIjoiY2t0cmlnNHo5MHVuMzJ3bGF3Mjh4YmRvYSJ9.EZv305bKMKlHKdk6ufMIBg'
            """),format.raw/*48.13*/("""}"""),format.raw/*48.14*/(""").addTo(mymap);

                var locations= """),_display_(/*50.33*/Html(locations.toString())),format.raw/*50.59*/(""";
                console.log(locations[0]);
                //var lon;
                //console.log();
                //for(location of locations)"""),format.raw/*54.45*/("""{"""),format.raw/*54.46*/("""
                """),format.raw/*55.17*/("""//add logic
                //"""),format.raw/*56.19*/("""}"""),format.raw/*56.20*/("""
                """),format.raw/*57.17*/("""for(let f = 0; f < locations.length; f++) """),format.raw/*57.59*/("""{"""),format.raw/*57.60*/("""
                    """),format.raw/*58.21*/("""fetch(location.protocol + '//nominatim.openstreetmap.org/search?format=json&q=' + locations[f])
                            .then(response => response.json())
                            .then(data => """),format.raw/*60.43*/("""{"""),format.raw/*60.44*/("""
                                """),format.raw/*61.33*/("""console.log(data[0].lon);
                                console.log(data[0].lat);
                                var popup = new L.marker([data[0].lat, data[0].lon]).bindPopup(locations[f]).addTo(mymap);
                            """),format.raw/*64.29*/("""}"""),format.raw/*64.30*/(""");
                """),format.raw/*65.17*/("""}"""),format.raw/*65.18*/("""
        """),format.raw/*66.9*/("""</script>

    </body>
</html>
"""))
      }
    }
  }

  def render(locations:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(locations)

  def f:((List[String]) => play.twirl.api.HtmlFormat.Appendable) = (locations) => apply(locations)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-22T13:46:27.567
                  SOURCE: C:/Users/ZDreamer/Documents/GitHub/Lab-2-Ebean/Frontend/app/views/conference_locations_list.scala.html
                  HASH: 3e298493f22b0b857ae261059d6cefe66648d19e
                  MATRIX: 651->1|689->33|1060->75|1179->101|2403->1299|2432->1300|2461->1301|2504->1316|2533->1317|2569->1326|2919->1649|2949->1658|3235->1916|3264->1917|3294->1919|3323->1920|3358->1927|3387->1928|3416->1929|3445->1930|3474->1931|3503->1932|3532->1933|3561->1934|3590->1935|3619->1936|3648->1937|3677->1938|3719->1952|3748->1953|3788->1964|3818->1965|3850->1968|3880->1969|3925->1986|4390->2423|4419->2424|4495->2473|4542->2499|4719->2648|4748->2649|4793->2666|4851->2696|4880->2697|4925->2714|4995->2756|5024->2757|5073->2778|5302->2979|5331->2980|5392->3013|5655->3248|5684->3249|5731->3268|5760->3269|5796->3278
                  LINES: 24->1|25->2|30->3|35->4|54->23|54->23|54->23|54->23|54->23|55->24|65->34|65->34|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|72->41|73->42|79->48|79->48|81->50|81->50|85->54|85->54|86->55|87->56|87->56|88->57|88->57|88->57|89->58|91->60|91->60|92->61|95->64|95->64|96->65|96->65|97->66
                  -- GENERATED --
              */
          
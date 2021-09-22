
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(authorizeMessage: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Lab 2 - SOSE Publication Recommendation Services
        </title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

            <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css" integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ==" crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js" integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og==" crossorigin=""></script>
    </head>
    <body>

        <header class="topbar">
            <h1 class="focused" style="font-size: 37px;
                color: #4cc9f0">
                <strong>Lab 2 - SOSE Publication Recommendation Services</strong>
            </h1>
        </header>


        <div class="row">
            <div class="card col s4 offset-s4 ">
                <div class="card-panel">
                    <form>
                        <button title="1.1 Given a paper name (i.e., title), list its publication metadata."
                        formaction=""""),_display_(/*34.38*/routes/*34.44*/.HomeController.signup()),format.raw/*34.68*/("""" style="display: block;
                            align-items: center;
                            justify-content: space-around;
                            background: #031628;
                            color: #4cc9f0;">1.1</button>
                        <button title="1.2 Given a journal name and a year (volume) and an issue (number), find out the metadata of all the papers published in the book (means the volume+number of the journal)."
                        formaction=""""),_display_(/*40.38*/routes/*40.44*/.HomeController.signup()),format.raw/*40.68*/("""" style="display: block;
                            align-items: center;
                            justify-content: space-around;
                            background: #031628;
                            color: #4cc9f0;">1.2</button>
                        <button title="1.3 Display the titles of the articles published by a researcher in a specific year;"
                        formaction=""""),_display_(/*46.38*/routes/*46.44*/.HomeController.signup()),format.raw/*46.68*/("""" style="display: block;
                            align-items: center;
                            justify-content: space-around;
                            background: #031628;
                            color: #4cc9f0;">1.3</button>
                        <button title="1.4 Display all the authors who have published more than 10 papers in the area of SOSE to date (Hint: Since I manually extracted all SOSE papers to you in this sub-dataset, these papers included mean all the SOSE papers to date)."
                        formaction=""""),_display_(/*52.38*/routes/*52.44*/.HomeController.signup()),format.raw/*52.68*/("""" style="display: block;
                            align-items: center;
                            justify-content: space-around;
                            background: #031628;
                            color: #4cc9f0;">1.4</button>
                        <button title="2.1 Given a researcher's name and a year, list all published articles' metadata;"
                        formaction=""""),_display_(/*58.38*/routes/*58.44*/.HomeController.signup()),format.raw/*58.68*/("""" style="display: block;
                            align-items: center;
                            justify-content: space-around;
                            background: #031628;
                            color: #4cc9f0;">2.1</button>
                        <button title="2.2 For the productive authors (e.g., published more than 10 papers) in the area of SOSE, list all of their co-authors;"
                        formaction=""""),_display_(/*64.38*/routes/*64.44*/.HomeController.signup()),format.raw/*64.68*/("""" style="display: block;
                            align-items: center;
                            justify-content: space-around;
                            background: #031628;
                            color: #4cc9f0;">2.2</button>
                        <button title="Given a conference name, and a range of years (between 2003-2020)(or same year for 1.5), mark the locations of where the conference was held in a map.
                        " formaction=""""),_display_(/*70.40*/routes/*70.46*/.HomeController.locationRequestForm()),format.raw/*70.83*/("""" style="display: block;
                            align-items: center;
                            justify-content: space-around;
                            background: #031628;
                            color: #4cc9f0;"> 1.5 & 2.3 </button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
"""))
      }
    }
  }

  def render(authorizeMessage:String): play.twirl.api.HtmlFormat.Appendable = apply(authorizeMessage)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (authorizeMessage) => apply(authorizeMessage)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-09-21T19:50:20.002
                  SOURCE: /Users/gian9898/Documents/sandbox/dev/cs7340_repo/git_labs_repo/Labs_repo/Labs2Repo/Lab-2-Ebean/Frontend/app/views/login.scala.html
                  HASH: 6fe974681ba44f272ae93f7dcd52106fe613b0bb
                  MATRIX: 948->1|1068->28|2869->1804|2884->1810|2929->1834|3445->2323|3460->2329|3505->2353|3934->2755|3949->2761|3994->2785|4568->3332|4583->3338|4628->3362|5053->3760|5068->3766|5113->3790|5577->4227|5592->4233|5637->4257|6133->4726|6148->4732|6206->4769
                  LINES: 28->1|33->2|65->34|65->34|65->34|71->40|71->40|71->40|77->46|77->46|77->46|83->52|83->52|83->52|89->58|89->58|89->58|95->64|95->64|95->64|101->70|101->70|101->70
                  -- GENERATED --
              */
          
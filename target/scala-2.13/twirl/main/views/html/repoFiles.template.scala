
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
import play.api.mvc._
import play.api.data._
/*1.2*/import models.RepoFilesModel

object repoFiles extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[RepoFilesModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(repoFiles: Seq[RepoFilesModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div>
    """),_display_(/*13.6*/repoFiles/*13.15*/.map/*13.19*/ { repoFileName =>_display_(Seq[Any](format.raw/*13.37*/("""
        """),format.raw/*14.9*/("""<li>"""),_display_(/*14.14*/repoFileName/*14.26*/.name),format.raw/*14.31*/("""</li>""")))}),format.raw/*14.37*/("""
"""),format.raw/*15.1*/("""</div>

</body>
</html>"""))
      }
    }
  }

  def render(repoFiles:Seq[RepoFilesModel]): play.twirl.api.HtmlFormat.Appendable = apply(repoFiles)

  def f:((Seq[RepoFilesModel]) => play.twirl.api.HtmlFormat.Appendable) = (repoFiles) => apply(repoFiles)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-08-05T14:05:18.972620
                  SOURCE: /Users/sarina.salamon/Documents/githubProject/githubProject/app/views/repoFiles.scala.html
                  HASH: 7cd8b6b8b21fbe6e176cb7e0e2f5c5bf0e6ad615
                  MATRIX: 432->1|782->31|908->64|935->65|1080->184|1098->193|1111->197|1167->215|1203->224|1235->229|1256->241|1282->246|1319->252|1347->253
                  LINES: 17->1|22->2|27->3|28->4|37->13|37->13|37->13|37->13|38->14|38->14|38->14|38->14|38->14|39->15
                  -- GENERATED --
              */
          
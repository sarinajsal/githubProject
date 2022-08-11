
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
/*1.2*/import models.RepoModel

object repos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[RepoModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(usersRepos: Seq[RepoModel]):play.twirl.api.HtmlFormat.Appendable = {
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
   """),format.raw/*13.113*/("""
"""),format.raw/*14.1*/("""</div>

</body>
</html>"""))
      }
    }
  }

  def render(usersRepos:Seq[RepoModel]): play.twirl.api.HtmlFormat.Appendable = apply(usersRepos)

  def f:((Seq[RepoModel]) => play.twirl.api.HtmlFormat.Appendable) = (usersRepos) => apply(usersRepos)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-08-09T11:08:03.182101
                  SOURCE: /Users/sarina.salamon/Documents/githubProject/githubProject/app/views/repos.scala.html
                  HASH: 64f44a49361fed0170379eb14ce480baf1e50588
                  MATRIX: 432->1|768->26|890->55|917->56|1062->312|1090->313
                  LINES: 17->1|22->2|27->3|28->4|36->13|37->14
                  -- GENERATED --
              */
          
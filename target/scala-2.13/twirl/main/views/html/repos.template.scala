
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
    """),_display_(/*12.6*/usersRepos/*12.16*/.map/*12.20*/{ repo =>_display_(Seq[Any](format.raw/*12.29*/("""
        """),format.raw/*13.9*/("""<li>"""),_display_(/*13.14*/repo/*13.18*/.full_name),format.raw/*13.28*/("""</li>""")))}),format.raw/*13.34*/("""
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
                  DATE: 2022-08-02T15:38:42.230296
                  SOURCE: /Users/sarina.salamon/Documents/githubProject/githubProject/app/views/repos.scala.html
                  HASH: 52de601edba81332b148f5868805659ec1dbbda6
                  MATRIX: 432->1|768->26|890->55|917->56|1061->174|1080->184|1093->188|1140->197|1176->206|1208->211|1221->215|1252->225|1289->231|1317->232
                  LINES: 17->1|22->2|27->3|28->4|36->12|36->12|36->12|36->12|37->13|37->13|37->13|37->13|37->13|38->14
                  -- GENERATED --
              */
          

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
/*1.2*/import models.UserModel

object user extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[UserModel,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(user: UserModel):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>user</title>
</head>
<body>
    <div>
        <p>"""),_display_(/*12.13*/user/*12.17*/._login),format.raw/*12.24*/(""" """),format.raw/*12.25*/(""":: """),_display_(/*12.29*/user/*12.33*/.following),format.raw/*12.43*/("""</p>
        <a href=""""),_display_(/*13.19*/routes/*13.25*/.GithubController.getRepos(user._login)),format.raw/*13.64*/("""">"""),_display_(/*13.67*/user/*13.71*/._login),format.raw/*13.78*/(""" """),format.raw/*13.79*/("""repositories</a>
    </div>

</body>
</html>"""))
      }
    }
  }

  def render(user:UserModel): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((UserModel) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-08-09T11:36:17.841333
                  SOURCE: /Users/sarina.salamon/Documents/githubProject/githubProject/app/views/user.scala.html
                  HASH: ffe38146052c27ffc043b1a39e717eef9e728550
                  MATRIX: 432->1|762->26|873->44|900->45|1055->173|1068->177|1096->184|1125->185|1156->189|1169->193|1200->203|1250->226|1265->232|1325->271|1355->274|1368->278|1396->285|1425->286
                  LINES: 17->1|22->2|27->3|28->4|36->12|36->12|36->12|36->12|36->12|36->12|36->12|37->13|37->13|37->13|37->13|37->13|37->13|37->13
                  -- GENERATED --
              */
          
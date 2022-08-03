
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
        <p>"""),_display_(/*12.13*/user/*12.17*/.login),format.raw/*12.23*/(""" """),format.raw/*12.24*/(""":: """),_display_(/*12.28*/user/*12.32*/.following),format.raw/*12.42*/("""</p>
        <h3><"""),_display_(/*13.15*/a),format.raw/*13.16*/(""" """),format.raw/*13.17*/("""href="http://localhost:9000/github/user/repos/$user.login">"""),_display_(/*13.77*/user/*13.81*/.login),format.raw/*13.87*/(""" """),format.raw/*13.88*/("""repositories</a></h3>
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
                  DATE: 2022-08-03T11:23:35.788178
                  SOURCE: /Users/sarina.salamon/Documents/githubProject/githubProject/app/views/user.scala.html
                  HASH: 1d1af320e584b84c0c8ccf6d0bb7d2834eb56075
                  MATRIX: 432->1|762->26|873->44|900->45|1055->173|1068->177|1095->183|1124->184|1155->188|1168->192|1199->202|1245->221|1267->222|1296->223|1383->283|1396->287|1423->293|1452->294
                  LINES: 17->1|22->2|27->3|28->4|36->12|36->12|36->12|36->12|36->12|36->12|36->12|37->13|37->13|37->13|37->13|37->13|37->13|37->13
                  -- GENERATED --
              */
          
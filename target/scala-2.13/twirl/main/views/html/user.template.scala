
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
                  DATE: 2022-07-28T15:45:07.937544
                  SOURCE: /Users/sarina.salamon/Documents/githubProject/githubProject/app/views/user.scala.html
                  HASH: 095e0b190545d63042adbac72b01096e9aafa23e
                  MATRIX: 432->1|762->26|873->44|900->45|1055->173|1068->177|1095->183|1124->184|1155->188|1168->192|1199->202
                  LINES: 17->1|22->2|27->3|28->4|36->12|36->12|36->12|36->12|36->12|36->12|36->12
                  -- GENERATED --
              */
          
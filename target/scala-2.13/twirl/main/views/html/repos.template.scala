
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

object repos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RepoModel,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(usersRepos: RepoModel):play.twirl.api.HtmlFormat.Appendable = {
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
    <p>usersRepos.repos</p>
</div>

</body>
</html>"""))
      }
    }
  }

  def render(usersRepos:RepoModel): play.twirl.api.HtmlFormat.Appendable = apply(usersRepos)

  def f:((RepoModel) => play.twirl.api.HtmlFormat.Appendable) = (usersRepos) => apply(usersRepos)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-08-02T11:53:34.635058
                  SOURCE: /Users/sarina.salamon/Documents/githubProject/githubProject/app/views/repos.scala.html
                  HASH: 657301d726785af5a141552e94845c201b49aa67
                  MATRIX: 432->1|763->26|880->50|907->51
                  LINES: 17->1|22->2|27->3|28->4
                  -- GENERATED --
              */
          
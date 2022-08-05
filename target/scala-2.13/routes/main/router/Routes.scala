// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sarina.salamon/Documents/githubProject/githubProject/conf/routes
// @DATE:Fri Aug 05 10:06:56 BST 2022

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  HomeController_2: controllers.HomeController,
  // @LINE:5
  Assets_1: controllers.Assets,
  // @LINE:7
  GithubController_0: controllers.GithubController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    HomeController_2: controllers.HomeController,
    // @LINE:5
    Assets_1: controllers.Assets,
    // @LINE:7
    GithubController_0: controllers.GithubController
  ) = this(errorHandler, HomeController_2, Assets_1, GithubController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, Assets_1, GithubController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """github/user/""" + "$" + """username<[^/]+>""", """controllers.GithubController.getUserInfo(username:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """github/user/repos/""" + "$" + """username<[^/]+>""", """controllers.GithubController.getRepos(username:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """github/repos/""" + "$" + """username<[^/]+>/""" + "$" + """repoName<[^/]+>/contents""", """controllers.GithubController.getRepoFiles(username:String, repoName:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path GET     /github/users/:username""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_GithubController_getUserInfo2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("github/user/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GithubController_getUserInfo2_invoker = createInvoker(
    GithubController_0.getUserInfo(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GithubController",
      "getUserInfo",
      Seq(classOf[String]),
      "GET",
      this.prefix + """github/user/""" + "$" + """username<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_GithubController_getRepos3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("github/user/repos/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_GithubController_getRepos3_invoker = createInvoker(
    GithubController_0.getRepos(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GithubController",
      "getRepos",
      Seq(classOf[String]),
      "GET",
      this.prefix + """github/user/repos/""" + "$" + """username<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_GithubController_getRepoFiles4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("github/repos/"), DynamicPart("username", """[^/]+""",true), StaticPart("/"), DynamicPart("repoName", """[^/]+""",true), StaticPart("/contents")))
  )
  private[this] lazy val controllers_GithubController_getRepoFiles4_invoker = createInvoker(
    GithubController_0.getRepoFiles(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GithubController",
      "getRepoFiles",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """github/repos/""" + "$" + """username<[^/]+>/""" + "$" + """repoName<[^/]+>/contents""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index())
      }
  
    // @LINE:5
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:7
    case controllers_GithubController_getUserInfo2_route(params@_) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_GithubController_getUserInfo2_invoker.call(GithubController_0.getUserInfo(username))
      }
  
    // @LINE:9
    case controllers_GithubController_getRepos3_route(params@_) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_GithubController_getRepos3_invoker.call(GithubController_0.getRepos(username))
      }
  
    // @LINE:13
    case controllers_GithubController_getRepoFiles4_route(params@_) =>
      call(params.fromPath[String]("username", None), params.fromPath[String]("repoName", None)) { (username, repoName) =>
        controllers_GithubController_getRepoFiles4_invoker.call(GithubController_0.getRepoFiles(username, repoName))
      }
  }
}

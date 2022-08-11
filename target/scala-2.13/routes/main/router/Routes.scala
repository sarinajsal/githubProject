// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sarina.salamon/Documents/githubProject/githubProject/conf/routes
// @DATE:Tue Aug 09 11:08:02 BST 2022

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  HomeController_3: controllers.HomeController,
  // @LINE:5
  Assets_2: controllers.Assets,
  // @LINE:7
  GithubController_1: controllers.GithubController,
  // @LINE:15
  DataRepController_0: controllers.DataRepController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    HomeController_3: controllers.HomeController,
    // @LINE:5
    Assets_2: controllers.Assets,
    // @LINE:7
    GithubController_1: controllers.GithubController,
    // @LINE:15
    DataRepController_0: controllers.DataRepController
  ) = this(errorHandler, HomeController_3, Assets_2, GithubController_1, DataRepController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_3, Assets_2, GithubController_1, DataRepController_0, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """github/read/user/""" + "$" + """username<[^/]+>""", """controllers.DataRepController.read(username:String)"""),
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
    HomeController_3.index(),
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
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
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
    GithubController_1.getUserInfo(fakeValue[String]),
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
    GithubController_1.getRepos(fakeValue[String]),
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
    GithubController_1.getRepoFiles(fakeValue[String], fakeValue[String]),
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

  // @LINE:15
  private[this] lazy val controllers_DataRepController_read5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("github/read/user/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_DataRepController_read5_invoker = createInvoker(
    DataRepController_0.read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DataRepController",
      "read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """github/read/user/""" + "$" + """username<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_3.index())
      }
  
    // @LINE:5
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_2.versioned(path, file))
      }
  
    // @LINE:7
    case controllers_GithubController_getUserInfo2_route(params@_) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_GithubController_getUserInfo2_invoker.call(GithubController_1.getUserInfo(username))
      }
  
    // @LINE:9
    case controllers_GithubController_getRepos3_route(params@_) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_GithubController_getRepos3_invoker.call(GithubController_1.getRepos(username))
      }
  
    // @LINE:13
    case controllers_GithubController_getRepoFiles4_route(params@_) =>
      call(params.fromPath[String]("username", None), params.fromPath[String]("repoName", None)) { (username, repoName) =>
        controllers_GithubController_getRepoFiles4_invoker.call(GithubController_1.getRepoFiles(username, repoName))
      }
  
    // @LINE:15
    case controllers_DataRepController_read5_route(params@_) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_DataRepController_read5_invoker.call(DataRepController_0.read(username))
      }
  }
}

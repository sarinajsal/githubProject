// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sarina.salamon/Documents/githubProject/githubProject/conf/routes
// @DATE:Tue Aug 09 11:08:02 BST 2022

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.javascript {

  // @LINE:15
  class ReverseDataRepController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def read: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DataRepController.read",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "github/read/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("username", username0))})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseGithubController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getUserInfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GithubController.getUserInfo",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "github/user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("username", username0))})
        }
      """
    )
  
    // @LINE:9
    def getRepos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GithubController.getRepos",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "github/user/repos/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("username", username0))})
        }
      """
    )
  
    // @LINE:13
    def getRepoFiles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GithubController.getRepoFiles",
      """
        function(username0,repoName1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "github/repos/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("username", username0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("repoName", repoName1)) + "/contents"})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}

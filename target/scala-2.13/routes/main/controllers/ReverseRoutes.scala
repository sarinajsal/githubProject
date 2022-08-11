// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sarina.salamon/Documents/githubProject/githubProject/conf/routes
// @DATE:Tue Aug 09 11:08:02 BST 2022

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:15
  class ReverseDataRepController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def read(username:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "github/read/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("username", username)))
    }
  
  }

  // @LINE:7
  class ReverseGithubController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getUserInfo(username:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "github/user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("username", username)))
    }
  
    // @LINE:9
    def getRepos(username:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "github/user/repos/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("username", username)))
    }
  
    // @LINE:13
    def getRepoFiles(username:String, repoName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "github/repos/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("username", username)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("repoName", repoName)) + "/contents")
    }
  
  }

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:5
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}

// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sarina.salamon/Documents/githubProject/githubProject/conf/routes
// @DATE:Tue Aug 09 11:08:02 BST 2022

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseDataRepController DataRepController = new controllers.ReverseDataRepController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseGithubController GithubController = new controllers.ReverseGithubController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseDataRepController DataRepController = new controllers.javascript.ReverseDataRepController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseGithubController GithubController = new controllers.javascript.ReverseGithubController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}

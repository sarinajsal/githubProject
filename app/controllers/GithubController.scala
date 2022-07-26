package controllers

import models.RepoModel
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import services.GithubService

import scala.concurrent.ExecutionContext
import javax.inject.{Inject, Singleton}
import play.api.mvc._

@Singleton
class GithubController @Inject()(val controllerComponents: ControllerComponents,
                                 val service: GithubService)(implicit val ec: ExecutionContext) extends BaseController {

  def getUserInfo(username: String): Action[AnyContent] = Action.async { implicit request =>
    service.getUserInfo(username).map { //.value needed for eitherT, gets the right or left out of the eithert wrapper(like taking it out a future)
      case Right(user) => Ok(views.html.user(user)) //cant case off of a future
      case Left(error) => BadRequest
    }
  }

  def getRepos(username: String): Action[AnyContent] = Action.async { implicit request =>
    service.getRepos(username).map{
      case Right(usersRepos) => Ok(views.html.repos(usersRepos))
//      val r = usersRepos.map(repo => repo.full_name)
      case Left(error) => BadRequest
    }

  }

  def getRepoFiles(username: String, repoName: String): Action[AnyContent] = Action.async { implicit request =>
    service.getRepoFiles(username, repoName).map{
      case Right(files) => Ok(views.html.repoFiles(files))
      case Left(error) => BadRequest
    }
  }
}



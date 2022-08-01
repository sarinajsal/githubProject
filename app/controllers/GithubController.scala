package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import services.GithubService


import scala.concurrent.ExecutionContext
import javax.inject.{Inject, Singleton}

@Singleton
class GithubController @Inject()(val controllerComponents: ControllerComponents,
                                 val service: GithubService)(implicit val ec: ExecutionContext) extends BaseController {

  def getUserInfo(username: String): Action[AnyContent] = Action.async { implicit request =>
    service.getUserInfo(username).map { //.value needed for eitherT, gets the right or left out of the eithert wrapper(like taking it out a future)
      case Right(user) => Ok(views.html.user(user)) //cant case off of a future
      case Left(error) => BadRequest
    }
  }
}



package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import services.GithubService


import scala.concurrent.ExecutionContext
import javax.inject.{Inject, Singleton}

@Singleton
class GithubController @Inject()(val controllerComponents: ControllerComponents,
                                 val service: GithubService)(implicit val ec: ExecutionContext) extends BaseController {

  def getUserInfo(username: String): Action[AnyContent] = Action.async { implicit request =>
    service.getUserInfo(username).value.map {
      case Right(user) => Ok(views.html.user(user))
      case Left(error) => BadRequest
    }
  }
}



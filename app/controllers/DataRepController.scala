package controllers

import models.{MyError, UserModel}
import play.api.libs.json.JsValue
import play.api.mvc.Results.Status
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import repositories.DataRepository
import services.DataRepService

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class DataRepController @Inject()(val dataRepository: DataRepository,
                                  val dataRepService: DataRepService,
                                  val controllerComponents: ControllerComponents,
                                 )(implicit val executionContext: ExecutionContext) extends BaseController{

  def read(login: String): Action[AnyContent] = Action.async { implicit request =>
    dataRepService.read(login).map {
      case Right(user) => Ok
      case Left(error) => BadRequest
    }
  }

  def create(): Action[JsValue] = Action.async(parse.json) { implicit request =>
    dataRepService.create(request).map{
      case Right("created")=> Ok("created")
      case Left(error) => BadRequest
    }
  }


}

package services

import models.{MyError, UserModel}
import play.api.libs.json.{JsError, JsSuccess, JsValue}
import repositories.DataRepository
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Request, Results}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class DataRepService @Inject() (val dataRepository: DataRepository)(implicit executionContext: ExecutionContext){

  def read(logins: String): Future[Either[MyError, UserModel]] =
    dataRepository.readUser(logins).map{
      case Right(user: UserModel) => Right(user)
      case Left(e: MyError) => Left(MyError.BadError(400, "error"))
    }

  def create(userRequest: Request[JsValue]): Future[Either[MyError, String]] =

    userRequest.body.validate[UserModel] match{
      case JsSuccess(newUser, _) => dataRepository.createUser(newUser)
      case JsError(error) => Future(Left(MyError.BadError(400, "error")))
    }
}

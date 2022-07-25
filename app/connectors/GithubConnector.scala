package connectors

import cats.data.EitherT
import models.{MyError, UserModel}
import play.api.libs.json.OFormat
import play.api.libs.ws.WSClient
import play.api.libs.json.{JsError, JsSuccess, Json, OFormat}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class GithubConnector @Inject()(ws: WSClient){
  def get[Response](url: String)(implicit reads: OFormat[Response], ec: ExecutionContext): EitherT[Future, MyError, UserModel] = {
    val request = ws.url(url)
    val response = request.get()
  EitherT{
    response.map{
      result =>
        result.json.validate[UserModel] match {
          case JsSuccess(validatedUserModel, _) => Right(UserModel(
            validatedUserModel.login,
            validatedUserModel.created_at,
            validatedUserModel.followers,
            validatedUserModel.following))
          case JsError(error) => Left(MyError.BadError(404, "an error occurred"))
        }
    }

  }
}

}

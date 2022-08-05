package connectors

import cats.data.EitherT
import models.{MyError, RepoFilesModel, RepoModel, UserModel}
import play.api.libs.json.OFormat
import play.api.libs.ws.WSClient
import play.api.libs.json.{JsError, JsSuccess, Json, OFormat}

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}


class GithubConnector @Inject()(ws: WSClient){
//  def get[Response](url: String)(implicit reads: OFormat[Response], ec: ExecutionContext): EitherT[Future, MyError, UserModel] = {
//    val request = ws.url(url)
//    val response = request.get()
//  EitherT{
//    response.map{
//      result =>
//        result.json.validate[UserModel] match {
//          case JsSuccess(validatedUserModel, _) => Right(UserModel(
//            validatedUserModel.login,
//            validatedUserModel.created_at,
//            validatedUserModel.followers,
//            validatedUserModel.following))
//          case JsError(error) => Left(MyError.BadError(404, "an error occurred"))
//        }
//    }
//
//  }
//}

  def get[Response](url: String)(implicit readsAndWrites: OFormat[Response], ec: ExecutionContext): Future[Either[MyError, UserModel]] = {
    val request = ws.url(url)
    val response = request.get() //whatever generic type comes back from client, turn it into a Response
      response.map{
        result =>
          result.json.validate[UserModel] match {
            case JsSuccess(validatedUserModel, _) => Right(validatedUserModel)
            case JsError(error) => Left(MyError.BadError(404, "an error occurred"))
          }
    }
  }

  def getRepos[Response](repoUrl: String)(implicit repoReadsAndWrites: OFormat[Response], ec: ExecutionContext): Future[Either[MyError, Seq[RepoModel]]]= {
    val repoRequest = ws.url(repoUrl)
    val response = repoRequest.get()
      response.map{
        result =>
          result.json.validate[Seq[RepoModel]] match {
            case JsSuccess(validatedRepoModel, _) => Right(validatedRepoModel)
            case JsError(error) => Left(MyError.BadError(400, "error"))
          }
      }
  }

  def getRepoFiles[Response](repoFileUrl: String)(implicit repoFilesRdsWrites: OFormat[Response], ec:ExecutionContext): Future[Either[MyError, Seq[RepoFilesModel]]] = {
    val repoFileResponse = ws.url(repoFileUrl).get()
    repoFileResponse.map{
      result =>
        result.json.validate[Seq[RepoFilesModel]] match {
          case JsSuccess(validatedRepoFileModel, _) => Right(validatedRepoFileModel)
          case JsError(error) => Left(MyError.BadError(400, "error"))
        }
    }
  }

}

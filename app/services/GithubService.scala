package services

import cats.data.EitherT
import connectors.GithubConnector
import models.{MyError, UserModel}

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class GithubService @Inject()(connector: GithubConnector)(implicit ec: ExecutionContext){ //inject things w vals?

  def getUserInfo(username: String): Future[Either[MyError, UserModel]] =
    connector.get[UserModel](s"https://api.github.com/users/$username")

}

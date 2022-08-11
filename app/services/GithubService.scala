package services

import cats.data.EitherT
import connectors.GithubConnector
import models.{MyError, RepoFilesModel, RepoModel, UserModel}

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class GithubService @Inject()(connector: GithubConnector)(implicit ec: ExecutionContext){ //inject things w vals?

  def getUserInfo(username: String): Future[Either[MyError, UserModel]] =
    connector.get[UserModel](s"https://api.github.com/users/$username")

  def getRepos(username: String): Future[Either[MyError, Seq[RepoModel]]] =
    connector.getRepos[RepoModel](s"https://api.github.com/users/$username/repos")

  def getRepoFiles(username: String, repoName: String): Future[Either[MyError, Seq[RepoFilesModel]]] =
    connector.getRepoFiles[RepoFilesModel](s"https://api.github.com/repos/$username/$repoName/contents")
}
//https://api.github.com/repos/sarinajsal/cafeAttemptScala/contents
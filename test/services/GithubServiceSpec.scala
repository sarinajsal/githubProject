package services

import baseSpec.BaseSpecWithApplication
import connectors.GithubConnector
import models.{MyError, RepoModel, UserModel}
import org.scalamock.scalatest.MockFactory
import play.api.libs.json.OFormat

import scala.concurrent.{ExecutionContext, Future}

class GithubServiceSpec extends BaseSpecWithApplication with MockFactory {

  val mockConnector: GithubConnector = mock[GithubConnector]

  val testService = new GithubService(mockConnector)
  val user1: UserModel = UserModel("", "", Some("London"), 0, 0)

  val testUser: UserModel = UserModel("", "", Some(""), 0, 0)

  val testRepoModel: Seq[RepoModel] = Seq(RepoModel("name"), RepoModel("name2"))


  "GithubService .getUserInfo" should {

    val testurl: String = "TEST"

    "return a Right(userModel)" in {
      (mockConnector.get[UserModel](_: String)(_: OFormat[UserModel], _: ExecutionContext)) //the wildcards
        .expects(*, *, *).returning(Future(Right(user1)))

      whenReady(testService.getUserInfo("")) { result =>
        result shouldBe Right(UserModel("", "", Some("London"), 0, 0))
      }

    }

    "return a Left(error)" in {
      (mockConnector.get[UserModel](_: String)(_: OFormat[UserModel], _: ExecutionContext))
        .expects(*, *, *).returning(Future(Left(MyError.BadError(400, "error"))))

      whenReady(testService.getUserInfo("anything")) { result =>
        result shouldBe Left(MyError.BadError(400, "error"))

      }
    }
  }

  "GithubService .getRepos" should {
    "return a Right(RepoModel)" in {
      (mockConnector.getRepos(_: String)(_: OFormat[RepoModel], _: ExecutionContext))
        .expects(*, *, *).returning(Future(Right(testRepoModel)))

      whenReady(testService.getRepos("")) { result =>
        result shouldBe Right(Seq(RepoModel("name"), RepoModel("name2")))
      }
    }

    "return a Left(myerror)" in {
      (mockConnector.getRepos(_: String)(_: OFormat[RepoModel], _: ExecutionContext))
        .expects(*, *, *).returning(Future(Left(MyError.BadError(400, "error"))))

      whenReady(testService.getRepos("")) { result =>
        result shouldBe Left(MyError.BadError(400, "error"))
      }
    }
  }
}
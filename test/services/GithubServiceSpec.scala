package services

import baseSpec.BaseSpecWithApplication
import connectors.GithubConnector
import models.UserModel
import org.scalamock.scalatest.MockFactory
import play.api.libs.json.OFormat

import scala.concurrent.{ExecutionContext, Future}

class GithubServiceSpec extends BaseSpecWithApplication with MockFactory {

  val mockConnector: GithubConnector = mock[GithubConnector]

  val testService = new GithubService(mockConnector)
  val user1: UserModel = UserModel("", "", Some("London"), 0, 0)

  val testUser: UserModel = UserModel("", "", Some(""), 0, 0)


  "GithubService .getUserInfo" should {

    val testurl: String = "TEST"

    "return a Right(userModel)" in {
      (mockConnector.get[UserModel](_: String)(_: OFormat[UserModel], _: ExecutionContext)) //the wildcards
        .expects(*, *, *).returning(Future(Right(user1)))

      whenReady(testService.getUserInfo("")) { result =>
        result shouldBe Right(UserModel("", "", Some("London"), 0, 0))
      }

    }
  }
}
package controllers

import baseSpec.BaseSpecWithApplication
import jdk.net.SocketFlow.Status
import org.scalamock.scalatest.MockFactory
import play.api.mvc.{AnyContent, Result}
import play.api.test.FakeRequest
import play.api.test.Helpers.status
import play.api.test.ResultExtractors

import scala.concurrent.Future

class GithubControllerSpec extends BaseSpecWithApplication with MockFactory{

  val testGithubController: GithubController = new GithubController(component, githubService)

  "GithubController .getUserInfo" should {
    "return an Ok action" in {

      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/user/sarinajsal")
      val getResult: Future[Result] = testGithubController.getUserInfo("sarinajsal")(buildGetUserRequest)



    }
  }

}

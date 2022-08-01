package controllers

import baseSpec.BaseSpecWithApplication

import models.UserModel
import org.scalamock.scalatest.MockFactory
import play.api.mvc.{AnyContent, Result}
import play.api.test.FakeRequest
import play.api.test.Helpers.{contentAsJson, contentAsString, contentType, defaultAwaitTimeout, status}
import play.api.http.Status

import scala.concurrent.Future

class GithubControllerSpec extends BaseSpecWithApplication with MockFactory{

  val testGithubController: GithubController = new GithubController(component, githubService)

  val user1: UserModel = UserModel("sarinajsal", "2022-01-18T14:53:16Z", None, 7, 3)

  "GithubController .getUserInfo" should {
    "return an Ok action" in {

      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/user/sarinajsal")
      val getResult: Future[Result] = testGithubController.getUserInfo("sarinajsal")(buildGetUserRequest)

      status(getResult) shouldBe Status.OK
//      contentAsJson(getResult).as[UserModel] shouldBe(user1)
      contentType(getResult) shouldBe Some("text/html") //not what is being displayed, if any html is displayed good
//      contentAsString(getResult) must include ("hello")

    }
  }

//  override def beforeEach(): Unit = repository.deleteAll()
//  override def afterEach(): Unit = repository.deleteAll()


}

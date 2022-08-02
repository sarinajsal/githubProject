package controllers

import baseSpec.BaseSpecWithApplication
import models.{MyError, UserModel}
import org.scalamock.scalatest.MockFactory
import play.api.mvc.{AnyContent, Result}
import play.api.test.{FakeRequest, Injecting}
import play.api.test.Helpers.{contentAsJson, contentAsString, contentType, defaultAwaitTimeout, status}
import play.api.http.Status
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import services.GithubService

import scala.concurrent.Future

class GithubControllerSpec extends BaseSpecWithApplication with MockFactory {
  val mockedService: GithubService = mock[GithubService]
  val integrationTestGithubController: GithubController = new GithubController(component, githubService)
  val unitTestGithubController: GithubController = new GithubController(component, mockedService)


  val user1: UserModel = UserModel("sarinajsal", "2022-01-18T14:53:16Z", None, 7, 3)

  // ---------------------------------INTEGRATION TESTS-----------------------------

  "GithubController .getUserInfo" should {
    "return an Ok action" in {
      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/user/sarinajsal")
      val getResult: Future[Result] = integrationTestGithubController.getUserInfo("sarinajsal")(buildGetUserRequest)

      status(getResult) shouldBe Status.OK
      //      contentAsJson(getResult).as[UserModel] shouldBe(user1)
      contentType(getResult) shouldBe Some("text/html") //not what is being displayed, if any html is displayed good
      contentAsString(getResult) must include("sarinajsal")
      //this is an integration test
    }

    "return a 400 bad request error when inputting wrong/no username" in {
      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/user/sarinajsal")
      val getResult: Future[Result] = integrationTestGithubController.getUserInfo("")(buildGetUserRequest)

      status(getResult) shouldBe Status.BAD_REQUEST
    }
  }

  // ---------------------------------UNIT TESTS-----------------------------

  "gitHubController. getUserInfo" should {

    "return an Ok (unit test)" in {
      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/user/sarinajsal")
      (mockedService.getUserInfo(_: String)).expects(*).returning(Future(Right(user1)))
      val getResult: Future[Result] = unitTestGithubController.getUserInfo("sarinajsal")(buildGetUserRequest)

      status(getResult) shouldBe Status.OK
      contentType(getResult) shouldBe Some("text/html")

    }


  "gitHubController. getUserInfo" should  {
    "return a badrequest action when given no username" in {
      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/user/")
      (mockedService.getUserInfo(_: String)).expects(*).returning(Future(Left(MyError.BadError(400, "error"))))
      val getResult: Future[Result] = unitTestGithubController.getUserInfo("sarinajsal")(buildGetUserRequest)

      status(getResult) shouldBe Status.BAD_REQUEST

    }
  }



}


//  override def beforeEach(): Unit = repository.deleteAll()
//  override def afterEach(): Unit = repository.deleteAll()




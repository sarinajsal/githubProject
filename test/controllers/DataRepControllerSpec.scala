package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import baseSpec.BaseSpecWithApplication
import models.UserModel
import org.scalamock.scalatest.MockFactory
import play.api.mvc.{AnyContent, AnyContentAsEmpty, Result}
import play.api.test.FakeRequest
import play.api.test.Helpers.{defaultAwaitTimeout, status}
import services.DataRepService
import play.api.http.Status
import play.api.libs.json.{JsNull, JsValue, Json}

import scala.concurrent.Future

class DataRepControllerSpec extends BaseSpecWithApplication with MockFactory{

  val mockedService: DataRepService = mock[DataRepService]
  val unitTestDataRepController: DataRepController = new DataRepController(dataRepository,dataRepService,component)

  val testUser: UserModel = UserModel("aUsername","",None,0,0)


  //------------UNIT-----------

  "DataRepController .create" should {
    "produce a string " in{
      beforeEach()
      val buildGetRequest: FakeRequest[JsValue] = buildPost("/github/create/user").withBody[JsValue](Json.toJson(testUser))
      val createResult: Future[Result] = unitTestDataRepController.create()(buildGetRequest)

      status(createResult) shouldBe Status.OK
      afterEach()
    }
  }

  "DataRepController .read" should {
    val login = "login"
    "produce an OK action" in{
      beforeEach()
//      val buildGetRequest: FakeRequest[JsValue] = buildPost("/github/create/user").withBody[JsValue](Json.toJson(testUser))
//      val createResult: Future[Result] = unitTestDataRepController.create()(buildGetRequest)
      val buildReadRequest: FakeRequest[AnyContentAsEmpty.type] = buildGet("/github/read/user/aUsername")
      (mockedService.read(_:String)).expects("aUsername").returning(Future(Right(testUser)))
      val getResult:Future[Result] = unitTestDataRepController.read("aUsername")(buildReadRequest)

      status(getResult)shouldBe Status.OK
      afterEach()
    }
  }

  override def beforeEach(): Unit = repository.deleteAll()
  override def afterEach(): Unit = repository.deleteAll()
}

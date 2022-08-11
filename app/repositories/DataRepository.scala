package repositories

import models.{MyError, UserModel}

import javax.inject.{Inject, Singleton}
import org.mongodb.scala.bson.conversions.Bson
import org.mongodb.scala.model.Filters.empty
import org.mongodb.scala.model._
import org.mongodb.scala.result
import uk.gov.hmrc.mongo.MongoComponent
import uk.gov.hmrc.mongo.play.json.PlayMongoRepository

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}



@Singleton
class DataRepository @Inject()(mongoComponent: MongoComponent)(implicit ec: ExecutionContext) extends PlayMongoRepository [UserModel](
  collectionName = "userModels",
  mongoComponent = mongoComponent,
  domainFormat = UserModel.formats,
  indexes = Seq(IndexModel(Indexes.ascending("login"))),
    replaceIndexes = false){

  def createUser(user: UserModel): Future[Either[MyError,String]]=
    collection.insertOne(user).toFuture().flatMap{
      case userCreated if userCreated.wasAcknowledged().equals(true) => Future(Right("created"))
      case _ => Future(Left(MyError.BadError(400, "error")))
    }

  private def byLogin(login: String): Bson =
    Filters.and(
      Filters.equal("_login", login)
    )

  def readUser(userLogin: String): Future[Either[MyError, UserModel]]=
    collection.find(byLogin(userLogin)).headOption() flatMap{
      case Some(data) => Future(Right(data))
      case _ => Future(Left(MyError.BadError(400, "error")))
    }

  def deleteUser(userlogin: String): Future[result.DeleteResult] =
    collection.deleteOne(
      filter = byLogin(userlogin)
    ).toFuture()

  def deleteAll(): Future[Unit] = collection.deleteMany(empty()).toFuture().map(_ => ())

}

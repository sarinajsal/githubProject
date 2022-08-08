package repositories

import models.UserModel

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
class DataRepository @Inject()(
                              mongoComponent: MongoComponent
                              )(implicit ec: ExecutionContext) extends PlayMongoRepository [UserModel](
  collectionName = "userModels",
  mongoComponent = mongoComponent,
  domainFormat = UserModel.formats,
  indexes = Seq(IndexModel(Indexes.ascending("login"))),
    replaceIndexes = false){

  def createUser(user: UserModel): Future[UserModel] =
    collection.insertOne(user).toFuture().map(_ =>user)




}

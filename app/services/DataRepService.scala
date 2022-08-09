package services

import models.{MyError, UserModel}
import repositories.DataRepository

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class DataRepService @Inject() (dataRepository: DataRepository)(implicit executionContext: ExecutionContext){

  def read(logins: String): Future[Either[MyError, UserModel]] =
    dataRepository.readUser(logins).map{
      case Right(user: UserModel) => Right(user)
      case Left(e: MyError) => Left(MyError.BadError(400, "error"))
    }
}

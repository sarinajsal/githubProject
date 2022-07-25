package models

import play.api.http.Status


sealed abstract class MyError (
                              val httpStatusCode: Int,
                              val reason: String
                              )

object MyError{
  final case class BadError(upstreamStatus: Int, upstreamMessage: String)
  extends MyError(
    Status.INTERNAL_SERVER_ERROR, //a 500 errror
    s"Bad response from upstream; got status: $upstreamStatus, and got reason $upstreamMessage"
  )
}
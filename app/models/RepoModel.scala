package models

import play.api.libs.json.{Json, OFormat}

case class RepoModel (full_name: String){
}

object RepoModel{
  implicit val formats: OFormat[RepoModel] = Json.format[RepoModel]
}
//
//case class Repo(name: String){
//}
//
//object Repo{
//  implicit val formats: OFormat[Repo] = Json.format[Repo]}




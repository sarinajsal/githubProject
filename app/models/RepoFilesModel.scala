package models

import play.api.libs.json.{Json, OFormat}

case class RepoFilesModel (name: String)

object RepoFilesModel{
  implicit val formats: OFormat[RepoFilesModel] = Json.format[RepoFilesModel]
}

package models

import play.api.libs.json.Json

case class Location(depth: Double,
    temperature: Double,
    cast: Long,
    cruise: String,
    latitude: Double,
    longitude: Double) {

}

object Location {
  implicit val locationFormat = Json.format[Location]

}


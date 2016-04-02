package org.evildethow.akkachat.server.route

import akka.http.scaladsl.server.Directives._

/**
  * Created by evildethow on 2/04/2016.
  */
trait PingRoute {
  val pingRoute =
    path("ping") {
      get {
        complete("pong")
      }
    }
}

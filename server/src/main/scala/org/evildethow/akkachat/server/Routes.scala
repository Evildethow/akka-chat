package org.evildethow.akkachat.server

import org.evildethow.akkachat.server.route._

/**
  * Created by evildethow on 2/04/2016.
  */
trait Routes extends PingRoute with EchoRoute {

  import akka.http.scaladsl.server.Directives._

  val routes = pingRoute ~ echoRoute
}

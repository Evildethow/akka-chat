package org.evildethow.akkachat.server

import org.evildethow.akkachat.server.route.PingRoute

/**
  * Created by evildethow on 2/04/2016.
  */
trait Routes extends PingRoute {
  val routes = pingRoute
}

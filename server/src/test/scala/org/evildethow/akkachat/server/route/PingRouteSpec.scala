package org.evildethow.akkachat.server.route

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

/**
  * Created by evildethow on 2/04/2016.
  */
class PingRouteSpec extends WordSpec with Matchers with ScalatestRouteTest with PingRoute {

  "The PingRoute" should {
    "return a 'pong' response for GET requests to /ping" in {
      Get("/ping") ~> pingRoute ~> check {
        responseAs[String] === "pong"
      }
    }
  }
}

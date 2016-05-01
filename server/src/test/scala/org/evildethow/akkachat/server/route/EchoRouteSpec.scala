package org.evildethow.akkachat.server.route

import akka.http.scaladsl.testkit.{ScalatestRouteTest, WSProbe}
import org.scalatest.{Matchers, WordSpec}

/**
  * Created by evildethow on 1/05/16.
  */
class EchoRouteSpec extends WordSpec with Matchers with ScalatestRouteTest with EchoRoute {

  "The EchoRoute" should {
    "echo responses for GET web socket requests in /echo" in {
      val wsClient = WSProbe()

      WS("/echo", wsClient.flow) ~> echoRoute ~> check {
        wsClient.sendMessage("hello")
        wsClient.expectMessage("hello")
      }
    }
  }
}

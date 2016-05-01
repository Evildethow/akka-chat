package org.evildethow.akkachat.server.route

import akka.http.scaladsl.model.ws.{Message, TextMessage}
import akka.http.scaladsl.server.Directives._
import akka.stream.scaladsl.Flow

/**
  * Created by evildethow on 1/05/16.
  */
trait EchoRoute {

  val echoService: Flow[Message, Message, _] = Flow[Message].map {
    case TextMessage.Strict(txt) => TextMessage(txt)
    case _ => TextMessage("Message type unsupported")
  }

  val echoRoute =
    path("echo") {
      get {
        handleWebsocketMessages(echoService)
      }
    }
}

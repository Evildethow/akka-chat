package org.evildethow.akkachat.server

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import scala.concurrent.ExecutionContext

/**
  * Created by evildethow on 2/04/2016.
  */
object Main extends App with Routes with Config {
  private implicit val system = ActorSystem()

  protected implicit val executor: ExecutionContext = system.dispatcher
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()
  protected val log: LoggingAdapter = Logging(system, getClass)

  Http().bindAndHandle(handler = logRequestResult("log")(routes), interface = httpInterface, port = httpPort)
}

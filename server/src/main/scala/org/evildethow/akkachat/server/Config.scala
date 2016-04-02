package org.evildethow.akkachat.server

import com.typesafe.config.ConfigFactory

/**
  * Created by evildethow on 2/04/2016.
  */
trait Config {
  private val config = ConfigFactory.load()

  private val http = config.getConfig("http")

  val httpInterface = http.getString("interface")
  val httpPort = http.getInt("port")
}

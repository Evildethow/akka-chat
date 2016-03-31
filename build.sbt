enablePlugins(JavaAppPackaging)

name := "akka-chat"

version := "0.0.1"

scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaStreamVersion = "2.0.3"
  val akkaVersion = "2.4.2"

  Seq(
    "com.typesafe.akka" %% "akka-actor"                           % akkaVersion,
    "com.typesafe.akka" %% "akka-stream-experimental"             % akkaStreamVersion,
    "com.typesafe.akka" %% "akka-http-experimental"               % akkaStreamVersion,
    "com.typesafe.akka" %% "akka-http-core-experimental"          % akkaStreamVersion,
    "com.typesafe.akka" %% "akka-http-testkit-experimental"       % akkaStreamVersion,
    "org.scalatest"     %% "scalatest"                            % "2.2.6" % "test",
    "com.typesafe.akka" %% "akka-testkit"                         % akkaVersion % "test"
  )
}

lazy val core = project

lazy val server = project

lazy val client = project
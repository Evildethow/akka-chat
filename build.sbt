enablePlugins(JavaAppPackaging)

lazy val commonSettings = Seq(
  organization := "org.evildethow",
  version := "0.0.1",
  scalaVersion := "2.11.8",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")
)

lazy val core = project.
  settings(commonSettings: _*).
  settings(
    name := "akka-chat-core"
  )

lazy val server = project.
  settings(commonSettings: _*).
  settings(
    name := "akka-chat-server",
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
  ).aggregate(core)

lazy val client = project.
  settings(commonSettings: _*).
  settings(
    name := "akka-chat-client"
  ).aggregate(core)
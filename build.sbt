//
// build.sbt
//

name := "helsinki-scala-club"

scalaVersion  := "2.11.7"

scalacOptions ++= Seq( "-unchecked"
                    , "-deprecation"
                    , "-encoding", "utf8"
                  )

scalacOptions ++= Seq( 
    "-feature",
    "-language", "postfixOps"
    )

libraryDependencies ++= Seq(
  // For Enumeratum
  "com.beachape" %% "enumeratum" % "1.3.2",

  // For Akka Streams (4-Feb-2016)
  "com.typesafe.akka" %% "akka-stream-experimental" % "2.0.2",

  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
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
  "com.beachape" %% "enumeratum" % "1.3.2",
  //
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
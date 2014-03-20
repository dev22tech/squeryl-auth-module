import sbt._
import sbt.Keys._

object LiftModuleBuild extends Build {

  import BuildSettings._

  val project = Project("squeryl-auth-module", file("."))
    .settings(basicSettings:_*)
    .settings(publishSettings:_*)
    .settings(libraryDependencies <++= (liftVersion) { liftVersion =>
      Seq(
        "net.liftweb" %% "lift-squeryl-record" % liftVersion % "provided",
        "net.liftweb" %% "lift-webkit" % liftVersion % "provided",
        "ch.qos.logback" % "logback-classic" % "1.0.3" % "provided",
        "org.scalatest" %% "scalatest" % "1.9.1" % "test",
        "org.mindrot" % "jbcrypt" % "0.3m" % "compile",
        "joda-time" % "joda-time" % "2.3" % "provided"
      )
    })
}

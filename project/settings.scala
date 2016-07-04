import sbt._, Keys._
import dependencies._

object settings {

  def basic = Seq(
    shellPrompt := { s => "[" + Project.extract(s).currentProject.id + "] λ " },

    resolvers in ThisBuild := repositories,

    scalacOptions := Seq(
        "-Ywarn-dead-code",
        "-language:existentials",
        "-language:higherKinds",
        "-language:implicitConversions",
        "-unchecked",
        "-Xfatal-warnings",
        "-Xlint",
        "-Yno-adapted-args",
        "-Ywarn-dead-code",
        "-Ywarn-numeric-widen",
        "-Xfuture"
    )
  )
}

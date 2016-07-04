import sbt._, Keys._
import dependencies._

libraryDependencies ++= Seq(
  journal,
  argonaut,
  _test(scalatest)
)

settings.basic

import sbt._, Keys._

organization in Global := "org.gauge"

scalaVersion in Global := "2.11.8"

lazy val root = project.in(file(".")).aggregate(common, model)

lazy val common = project

lazy val model  = project.dependsOn(common % "test->test;compile->compile")

settings.basic

import sbt._, Keys._

object dependencies {

	def _provided (module: ModuleID): ModuleID = module % "provided"
	def _test     (module: ModuleID): ModuleID = module % "test"

	val repositories = Seq(
		Resolver.typesafeRepo("releases"),
		Resolver.bintrayRepo ("oncue", "releases")
	)

	object Versions {
		val scalatest  = "2.2.6"
		val logback    = "1.1.3"
		val argonaut   = "6.1"
		val extensions = "3.1.0"
		val scalaz     = "7.2.4"
		val streams    = "0.8"
	}

	val scalatest = "org.scalatest" 		%% "scalatest"	     % Versions.scalatest
	val logback   = "ch.qos.logback"		 % "logback-classic" % Versions.logback
	val scalaz    = "org.scalaz"				%% "scalaz-core"     % Versions.scalaz
	val streams   = "org.scalaz.stream" %% "scalaz-stream"   % Versions.streams
	val argonaut  = "io.argonaut"       %% "argonaut"        % Versions.argonaut
	val journal   = "oncue.journal" 		%% "core" 					 % "2.2.+"



}

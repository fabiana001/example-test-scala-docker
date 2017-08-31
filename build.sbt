name := "example-test-scala-docker"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.9.1" % "test",
  "com.github.docker-java" % "docker-java" % "3.0.13" % "test"
)
name := "github-issues-exporter"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.kohsuke" % "github-api" % "1.93",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.5"
)
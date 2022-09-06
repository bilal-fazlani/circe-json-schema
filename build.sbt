val circeVersion = "0.15.0-M1"
val everitVersion = "1.14.0"

ThisBuild / scalaVersion := "3.2.0"
ThisBuild / crossScalaVersions := List("3.2.0", "2.13.8")
ThisBuild / organization := "com.bilal-fazlani"
ThisBuild / organizationName := "Bilal Fazlani"
ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/bilal-fazlani/circe-json-schema"),
    "https://github.com/bilal-fazlani/circe-json-schema.git"
  )
)
ThisBuild / developers := List(
  Developer(
    "bilal-fazlani",
    "Bilal Fazlani",
    "bilal.m.fazlani@gmail.com",
    url("https://bilal-fazlani.com")
  )
)
ThisBuild / licenses := List(
  "MIT License" -> url(
    "https://github.com/bilal-fazlani/circe-json-schema/blob/main/LICENSE"
  )
)
ThisBuild / homepage := Some(url("https://github.com/bilal-fazlani/circe-json-schema"))

val root = project
  .in(file("."))
  .aggregate(schema)
  .settings(
    publish / skip := true
  )

lazy val schema = project
  .in(file("schema"))
  .settings(
    moduleName := "circe-json-schema",
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion % Test,
      "com.github.erosb" % "everit-json-schema" % everitVersion,
      "io.circe" %% "circe-jawn" % circeVersion % Test,
      "io.circe" %% "circe-testing" % circeVersion % Test,
      "org.scalatest" %% "scalatest-flatspec" % "3.2.12" % Test,
      "org.scalatestplus" %% "scalacheck-1-15" % "3.2.12.0-RC2" % Test
    )
  )

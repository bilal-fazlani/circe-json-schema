val circeVersion = "0.15.0-M1"
val everitVersion = "1.14.0"
val scala3 = "3.1.2"

val root = project.in(file(".")).aggregate(schema)

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

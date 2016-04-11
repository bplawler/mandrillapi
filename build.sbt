organization := "default"

name := "mandrillapi"

version := "0.1"

scalacOptions in ThisBuild ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= Seq (
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.2"
  , "com.fasterxml.jackson.core" % "jackson-annotations" % "2.2.2"
  , "com.typesafe" % "config" % "1.0.2"
  , "org.apache.httpcomponents" % "httpclient" % "4.3.5"
  , "commons-io" % "commons-io" % "2.4"
  , "com.sendgrid" % "sendgrid-java" % "2.2.2"
)


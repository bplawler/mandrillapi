organization := "default"

name := "mandrillapi"

version := "0.1"

scalacOptions in ThisBuild ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= Seq (
    "org.codehaus.jackson" % "jackson-core-asl" % "1.9.10"
  , "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.10"
  , "com.typesafe" % "config" % "1.0.2"
  , "org.apache.httpcomponents" % "httpclient" % "4.3.5"
)


scalaVersion := "2.8.1"

organization := "com.twitter"

name := "ostrich"

version := "4.9.4-SNAPSHOT"

{
val utilVersion = "1.10.2"
libraryDependencies ++= Seq(
   "com.twitter" % "util-core" % utilVersion
  ,"com.twitter" % "util-eval" % utilVersion
  ,"com.twitter" % "util-logging" % utilVersion
  ,"com.twitter" % "json_2.8.1" % "2.1.6"
  ,"org.scala-tools.testing" % "specs_2.8.1" % "1.6.6" % "test"
  ,"cglib" % "cglib" % "2.1_3" % "test"
  ,"asm" % "asm" % "1.5.3" % "test"
  ,"org.objenesis" % "objenesis" % "1.1" % "test"
  ,"org.hamcrest" % "hamcrest-all" % "1.1" % "test"
  ,"org.jmock" % "jmock" % "2.4.0" % "test"
)
}

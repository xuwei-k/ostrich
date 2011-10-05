import java.io.FileWriter
import java.util.Properties
import sbt._
import com.twitter.sbt._

class OstrichProject(info: ProjectInfo) extends StandardLibraryProject(info)
  with AutoCompilerPlugins
  with DefaultRepos
{
  val utilVersion = "1.10.2"
  val util = "com.twitter" % "util-core" % utilVersion
  val eval = "com.twitter" % "util-eval" % utilVersion
  val logging = "com.twitter" % "util-logging" % utilVersion
  val json = "com.twitter" % "json_2.8.1" % "2.1.6"
  val sxr = compilerPlugin("org.scala-tools.sxr" %% "sxr" % "0.2.7")

  // for tests:
  val specs = "org.scala-tools.testing" % "specs_2.8.1" % "1.6.6" % "test"
  val cglib = "cglib" % "cglib" % "2.1_3" % "test"
  val asm = "asm" % "asm" % "1.5.3" % "test"
  val objenesis = "org.objenesis" % "objenesis" % "1.1" % "test"
  val hamcrest = "org.hamcrest" % "hamcrest-all" % "1.1" % "test"
  val jmock = "org.jmock" % "jmock" % "2.4.0" % "test"

  override def pomExtra =
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
    </licenses>

  def ostrichPropertiesPath = (mainResourcesOutputPath ##) / "ostrich.properties"
  lazy val makeOstrichProperties = task {
    val properties = new Properties
    properties.setProperty("version", version.toString)
    properties.setProperty("asu", (System.nanoTime >> 16 & 0xfff).toString)
    val fileWriter = new FileWriter(ostrichPropertiesPath.asFile)
    properties.store(fileWriter, "")
    fileWriter.close()
    None
  }
  override def copyResourcesAction = super.copyResourcesAction && makeOstrichProperties
  override def packagePaths = super.packagePaths +++ ostrichPropertiesPath

}

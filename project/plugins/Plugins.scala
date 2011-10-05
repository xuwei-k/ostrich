import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  import scala.collection.jcl
  val environment = jcl.Map(System.getenv())

  override def repositories = { 
    super.repositories ++ Set(
      "twitter.com" at "http://maven.twttr.com/",
      "scala-tools" at "http://scala-tools.org/repo-releases/",
      "freemarker" at "http://freemarker.sourceforge.net/maven2/"
    )
  }
  override def ivyRepositories = Seq(Resolver.defaultLocal(None)) ++ repositories

  val standardProject = "com.twitter" % "standard-project" % "0.12.7"
}

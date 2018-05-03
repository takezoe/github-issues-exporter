import java.io.{File, FileOutputStream}

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.kohsuke.github.{GHIssueState, GitHub}

import scala.collection.JavaConverters._

object Main extends App {

  val repository = args(0) // "owner/repository"

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  val file = new File("export.json")
  val out = new FileOutputStream(file)

  val github = GitHub.connect()
  val i = github.getRepository(repository).listIssues(GHIssueState.ALL).iterator()

  while(i.hasNext){
    val issue = i.next()
    val map = Map(
      "title" -> issue.getTitle,
      "body" -> issue.getBody,
      "isPullRequest" -> issue.isPullRequest,
      "labels" -> issue.getLabels.asScala.map(_.getName)
    )
    out.write((mapper.writeValueAsString(map) + "\n").getBytes("UTF-8"))
  }

  out.close()
}

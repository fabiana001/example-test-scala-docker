import java.util.UUID

import org.specs2.mutable.Specification
import org.specs2.specification.BeforeAfterAll

/**
  * Created by fabiana on 30/08/17.
  */
class DockerContainerTest extends Specification with BeforeAfterAll {

  var containerId: String = _

  "DockerContainerTest" should {
    "execute correctly elasticsearch" in {

      println(containerId)

      containerId must not be null
    }
  }


  override def beforeAll(): Unit = {
    containerId = DockerContainer.builder()
      //.withImage("docker.elastic.co/elasticsearch/elasticsearch:5.4.1")
      .withImage("elasticsearch:latest")
      .withPort("9900/tcp", "9200/tcp")
      .withEnv("http.host", "0.0.0.0")
      .withEnv("transport.host", "127.0.0.1")
      .withName("TEST-" + UUID.randomUUID())
      .run()
  }

  override def afterAll(): Unit = {
    DockerContainer.builder().withId(containerId).clean()
  }
}

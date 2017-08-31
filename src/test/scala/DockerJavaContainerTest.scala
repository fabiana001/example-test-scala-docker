import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.core.DockerClientBuilder
import org.specs2.mutable.Specification
import org.specs2.specification.BeforeAfterAll

import scala.collection.JavaConverters._


/**
  * Created by fabiana on 30/08/17.
  */
class DockerJavaContainerTest extends Specification with BeforeAfterAll {

  var dockerClient: DockerClient = _


  "DockerJavaContainerTest" should {
    "correctly print the list of running containers" in {


    val images = dockerClient.listImagesCmd().exec().asScala.toList

    images.foreach(println)

    true == true
  }}

  override def beforeAll(): Unit = {
    dockerClient = DockerClientBuilder.getInstance("unix:///var/run/docker.sock").build()
    // a more complex configuration:

    //  val config = DefaultDockerClientConfig.createDefaultConfigBuilder()
    //    .withDockerHost("unix:///var/run/docker.sock")
    //    //.withDockerTlsVerify(true)
    //    //.withDockerCertPath("/home/user/.docker")
    //    //.withRegistryUsername(registryUser)
    //    //.withRegistryPassword(registryPass)
    //    //.withRegistryEmail(registryMail)
    //    //.withRegistryUrl(registryUrl)
    //    .build()
    //  // using jaxrs/jersey implementation here (netty impl is also available)
    //  val dockerCmdExecFactory = new JerseyDockerCmdExecFactory()
    //    .withReadTimeout(1000)
    //    .withConnectTimeout(1000)
    //    .withMaxTotalConnections(100)
    //    .withMaxPerRouteConnections(10)
    //
    //  val dockerClient = DockerClientBuilder.getInstance(config)
    //    .withDockerCmdExecFactory(dockerCmdExecFactory)
    //    .build()
  }

  override def afterAll(): Unit = {
    dockerClient.close()
  }
}

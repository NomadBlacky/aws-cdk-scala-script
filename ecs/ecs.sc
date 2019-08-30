import $ivy.`software.amazon.awscdk:core:1.6.1.DEVPREVIEW`
import $ivy.`software.amazon.awscdk:ec2:1.6.1.DEVPREVIEW`
import $ivy.`software.amazon.awscdk:ecs:1.6.1.DEVPREVIEW`
import software.amazon.awscdk.core._
import software.amazon.awscdk.services.ec2._

import scala.jdk.CollectionConverters._

class ECSStack(construct: Construct, name: String, props: StackProps)
    extends Stack(construct, name, props) {
  val vpc = {
    val subnetConf = SubnetConfiguration.builder().name("MySubnetConfig").subnetType(SubnetType.PUBLIC).build()
    val props = VpcProps.builder().maxAzs(3).subnetConfiguration(List(subnetConf).asJava).build()
    // FIXME: java.lang.IllegalArgumentException: No enum constant software.amazon.awscdk.services.ec2.SubnetType.undefined
    // https://github.com/aws/aws-cdk/issues/3750
    new Vpc(this, "MyVpc", props)
  }
}

val app = new App()
val props = StackProps.builder().tags(Map("tag_key" -> "tag_value").asJava).build()

new ECSStack(app, "ecs-stack", props)

app.synth()

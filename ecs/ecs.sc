import $ivy.`software.amazon.awscdk:core:1.6.1.DEVPREVIEW`
import $ivy.`software.amazon.awscdk:iam:1.6.1.DEVPREVIEW`
import $ivy.`software.amazon.awscdk:s3:1.6.1.DEVPREVIEW`
import software.amazon.awscdk.core._

import scala.jdk.CollectionConverters._

class ECSStack(construct: Construct, name: String, props: StackProps)
    extends Stack(construct, name, props) {}

val app = new App()
val props = StackProps.builder().tags(Map("tag_key" -> "tag_value").asJava).build()

new ECSStack(app, "ecs-stack", props)

app.synth()

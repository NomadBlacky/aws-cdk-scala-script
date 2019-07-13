import $ivy.`software.amazon.awscdk:core:1.0.0.DEVPREVIEW`
import $ivy.`software.amazon.awscdk:s3:1.0.0.DEVPREVIEW`
import software.amazon.awscdk.core.{App, Construct, Stack, StackProps}
import software.amazon.awscdk.services.s3.{Bucket, BucketProps}

class ExampleStack(parent: Construct, id: String, props: StackProps = null) extends Stack(parent, id, props) {
  new Bucket(this, "aws-cdk-scala-script-example-bucket", BucketProps.builder().build())
}

val app = new App()

new ExampleStack(app, "example-stack")

app.synth()

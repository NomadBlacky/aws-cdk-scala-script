import $ivy.`software.amazon.awscdk:core:1.0.0.DEVPREVIEW`
import $ivy.`software.amazon.awscdk:s3:1.0.0.DEVPREVIEW`
import $ivy.`software.amazon.awscdk:iam:1.0.0.DEVPREVIEW`
import software.amazon.awscdk.core.{App, Construct, Stack, StackProps}
import software.amazon.awscdk.services.iam.User
import software.amazon.awscdk.services.s3.{Bucket, BucketProps}

class ExampleStack(parent: Construct, id: String, props: StackProps = null) extends Stack(parent, id, props) {
  val bucket = new Bucket(this, "aws-cdk-scala-script-example-bucket", BucketProps.builder().build())

  val user = new User(this, "aws-cdk-scala")
  bucket.grantReadWrite(user)
}

val app = new App()

new ExampleStack(app, "example-stack")

app.synth()

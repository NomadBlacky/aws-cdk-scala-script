import $ivy.`software.amazon.awscdk:ecr-assets:1.44.0`

import software.amazon.awscdk.services.ecr.assets.DockerImageAsset
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.services.ecr.assets.DockerImageAssetProps
import software.amazon.awscdk.core.App

class DockerImageAssetStack(scope: Construct, id: String) extends Stack(scope, id) {
    val imageAsset = new DockerImageAsset(this, "ImageAsset", DockerImageAssetProps.builder().directory(".").build())
}

val app = new App()

new DockerImageAssetStack(app, "DockerImageAssetStack")

app.synth()

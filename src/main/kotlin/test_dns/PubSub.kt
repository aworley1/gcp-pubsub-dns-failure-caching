package test_dns

import com.google.cloud.pubsub.v1.stub.GrpcSubscriberStub
import com.google.cloud.pubsub.v1.stub.SubscriberStubSettings
import com.google.pubsub.v1.PullRequest
import com.google.pubsub.v1.ReceivedMessage

const val subscriptionName =
    "projects/GOOGLE_CLOUD_PROJECT/subscriptions/SUBSCRIPTION_NAME"

val pullSubscriber = createSubscriber()

fun pullMessages() {
    performSynchronousPull(10, subscriptionName)
}

private fun createSubscriber(): GrpcSubscriberStub {
    val instantiatingGrpcChannelProvider =
        SubscriberStubSettings.defaultGrpcTransportProviderBuilder().build()

    val subscriberStubSettings = SubscriberStubSettings.newBuilder()
        .setTransportChannelProvider(instantiatingGrpcChannelProvider)
        .build()

    return GrpcSubscriberStub.create(subscriberStubSettings)
}


private fun performSynchronousPull(numberOfMessages: Int, subscriptionName: String): List<ReceivedMessage> {
    val pullRequest = PullRequest.newBuilder()
        .setMaxMessages(numberOfMessages)
        .setSubscription(subscriptionName)
        .build()

    return pullSubscriber.pullCallable()
        .call(pullRequest)
        .receivedMessagesList
}
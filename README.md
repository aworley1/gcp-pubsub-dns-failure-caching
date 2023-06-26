# Google Cloud Pubsub Cached DNS Failure Sample Project

## Steps to run

1. Ensure you have run `gcloud auth application-default login`
2. Set the `subscriptionName` const in `src/main/kotlin/test_dns/PubSub.kt` to a subscription you have access to
3. Run `./gradlew build`
4. Disable your network connection
5. Run `./gradlew run`
6. Wait until an exception with a DNS failure is printed
7. Re-enable your network connection

## Expected Result
After enabling the network connection, the subsequent iterations should print `Success`

(This is observed when using `com.google.cloud:libraries-bom:26.11.0`)

## Actual Result
After enabling the network connection, the subsequent iterations continue to throw exceptions containing the message
`UNAVAILABLE: Unable to resolve host pubsub.googleapis.com` for the next 30 minutes, before continuing to pull
successfully.

(This is observed when using `com.google.cloud:libraries-bom:26.12.0`)
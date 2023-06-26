package test_dns

import java.security.Security
import java.time.Instant

fun main() {
    Security.setProperty("networkaddress.cache.negative.ttl", "0")

    while (true) {
        try {
            println(Instant.now())
            pullMessages()
            println("Success")
        } catch (e: Exception) {
            println("Failed to pull with exception: ${e.message}")
        }

        Thread.sleep(1000)
    }
}
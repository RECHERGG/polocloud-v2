package dev.httpmarco.polocloud.agent.runtime.k8s

import dev.httpmarco.polocloud.agent.logger
import dev.httpmarco.polocloud.agent.runtime.Runtime
import io.fabric8.kubernetes.client.KubernetesClientBuilder

class KubernetesRuntime : Runtime {

    override fun runnable(): Boolean {
        return try {
            val config = ConfigBuilder()
                .withConnectionTimeout(2000)    // 2 Sekunden für Connection
                .withRequestTimeout(3000)       // 3 Sekunden für Request
                .build()

            KubernetesClientBuilder()
                .build()
                .use { client ->
                    return client.kubernetesVersion != null
                }
        } catch (ex: Exception) {
            logger.debug("Failed to connect to Kubernetes API: ${ex.message}")
            false
        }
    }
}
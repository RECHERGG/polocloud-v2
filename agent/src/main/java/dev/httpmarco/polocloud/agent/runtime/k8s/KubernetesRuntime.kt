package dev.httpmarco.polocloud.agent.runtime.k8s

import dev.httpmarco.polocloud.agent.logger
import dev.httpmarco.polocloud.agent.runtime.Runtime
import dev.httpmarco.polocloud.agent.runtime.RuntimeGroupStorage
import dev.httpmarco.polocloud.agent.runtime.RuntimeServiceStorage
import io.fabric8.kubernetes.client.KubernetesClientBuilder
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

class KubernetesRuntime : Runtime {

    override fun runnable(): Boolean {
        return try {
            val future = CompletableFuture.supplyAsync {
                KubernetesClientBuilder()
                    .build()
                    .use { client ->
                        client.kubernetesVersion != null
                    }
            }
            future.get(1, TimeUnit.SECONDS)
        } catch (e: Exception) {
            logger.debug("Failed to connect to Kubernetes API: ${e.javaClass.simpleName} - ${e.message}")
            false
        }
    }

    override fun serviceStorage(): RuntimeServiceStorage {
        TODO("Not yet implemented")
    }

    override fun groupStorage(): RuntimeGroupStorage {
        TODO("Not yet implemented")
    }
}
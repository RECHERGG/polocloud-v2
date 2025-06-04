package dev.httpmarco.polocloud.agent.runtime.local

import dev.httpmarco.polocloud.agent.runtime.Runtime
import dev.httpmarco.polocloud.agent.runtime.RuntimeServiceStorage

class LocalRuntime : Runtime {

    private val runtimeGroupStorage = LocalRuntimeGroupStorage()

    override fun runnable(): Boolean {
        return true // LocalRuntime is always runnable
    }

    override fun serviceStorage(): RuntimeServiceStorage {
        TODO("Not yet implemented")
    }

    override fun groupStorage() = runtimeGroupStorage

}
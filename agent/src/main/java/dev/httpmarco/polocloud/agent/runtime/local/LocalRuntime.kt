package dev.httpmarco.polocloud.agent.runtime.local

import dev.httpmarco.polocloud.agent.runtime.Runtime
import dev.httpmarco.polocloud.agent.runtime.RuntimeGroupStorage
import dev.httpmarco.polocloud.agent.runtime.RuntimeServiceStorage

class LocalRuntime : Runtime {

    override fun runnable(): Boolean {
        return true // LocalRuntime is always runnable
    }

    override fun serviceStorage(): RuntimeServiceStorage {
        TODO("Not yet implemented")
    }

    override fun groupStorage(): RuntimeGroupStorage {
        TODO("Not yet implemented")
    }
}
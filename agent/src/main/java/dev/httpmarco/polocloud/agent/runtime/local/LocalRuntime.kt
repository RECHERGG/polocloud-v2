package dev.httpmarco.polocloud.agent.runtime.local

import dev.httpmarco.polocloud.agent.runtime.Runtime

class LocalRuntime : Runtime {

    override fun runnable(): Boolean {
        return true // LocalRuntime is always runnable
    }
}
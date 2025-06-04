package dev.httpmarco.polocloud.agent.runtime.local

import dev.httpmarco.polocloud.agent.groups.Group
import dev.httpmarco.polocloud.agent.runtime.RuntimeGroupStorage
import kotlin.io.path.Path
import kotlin.io.path.listDirectoryEntries

private val STORAGE_PATH = Path("local/groups")

class LocalRuntimeGroupStorage : RuntimeGroupStorage {

    override fun items(): List<Group> {
        return STORAGE_PATH.listDirectoryEntries("*.json").stream().map {
            return@map Group()
        }.toList()
    }
}
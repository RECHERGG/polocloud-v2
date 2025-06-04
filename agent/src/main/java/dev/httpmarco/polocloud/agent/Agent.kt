package dev.httpmarco.polocloud.agent

import dev.httpmarco.polocloud.agent.logging.Logger
import dev.httpmarco.polocloud.agent.runtime.Runtime

// global terminal instance for the agent
// this is used to print messages to the console
val logger = Logger()

object Agent {

    private val runtime : Runtime

    init {
        // display the default log information
        logger.info("Starting PoloCloud Agent...")

        runtime = Runtime.create()

        logger.info("Using runtime: ${runtime::class.simpleName}")
        logger.info("Load groups: ${runtime.groupStorage().items().size}")

    }
}
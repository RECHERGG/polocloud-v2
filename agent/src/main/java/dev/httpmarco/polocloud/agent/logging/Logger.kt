package dev.httpmarco.polocloud.agent.logging

import com.github.ajalt.mordant.rendering.TextColors.Companion.rgb
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.rendering.TextStyle

class Logger {

    private val terminal = Terminal()

    fun info(message: String) {
        log("INFO", rgb("#ffffff"), message)
    }

    fun warn(message: String) {
        log("WARN", rgb("#FF9900"), message)
    }

    fun error(message: String) {
        log("ERROR", rgb("#FF4136"), message)
    }

    fun debug(message: String) {
        log("DEBUG", rgb("#969696"), message)
    }

    private fun log(level: String, style: TextStyle, message: String) {
        val timestamp = java.time.LocalTime.now().withNano(0)
        terminal.println("${("$timestamp")} | ${style("$level:")} $message")
    }
}
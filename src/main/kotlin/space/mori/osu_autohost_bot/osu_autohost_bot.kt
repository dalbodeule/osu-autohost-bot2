package space.mori.osu_autohost_bot

import lt.ekgame.bancho.api.packets.server.PacketChat
import lt.ekgame.bancho.api.packets.server.PacketReceivingFinished
import lt.ekgame.bancho.client.BanchoClient
import org.apache.logging.log4j.kotlin.logger

fun main() {
    val bancho = BanchoClient("dalbodeule", "**jj246800**", true, false)
    val logger = logger("OSU")

    try {
        bancho.registerHandler {
            if (it is PacketReceivingFinished) {
                logger.info("bancho.isConnected: ${bancho.isConnected}")
            }

            if (it is PacketChat) {
                logger.info("${it.sender} - ${it.message}")
            }
        }

        logger.info("Bancho client start!")
        bancho.connect()

        logger.info("Authanticated! starting...")
        bancho.start()

        logger.info("Started!")
    } catch (error: Exception) {
        logger.error("Error!")
        logger.trace(error)
    }
}


package space.mori.osu_autohost_bot.osu

import lt.ekgame.bancho.api.packets.server.PacketChat
import lt.ekgame.bancho.api.packets.server.PacketReceivingFinished
import lt.ekgame.bancho.client.BanchoClient
import org.apache.logging.log4j.kotlin.logger

import space.mori.osu_autohost_bot.Configure

class Main(private val config: Configure) {
    internal val bancho = BanchoClient(config.osu_username, config.osu_password, true, false)
    internal val logger = logger("OSU")

    internal fun run() {
        try {
            bancho.registerHandler {
                if (it is PacketReceivingFinished) {
                    logger.info("bancho.isConnected: ${bancho.isConnected}")
                    logger.info("connected user: ${bancho.username}")
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

            throw error
        }
    }
}


package space.mori.osu_autohost_bot.discord

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import org.apache.logging.log4j.kotlin.logger

import space.mori.osu_autohost_bot.Configure

class Main(private val config: Configure) {
    internal val bot = JDABuilder.createDefault(config.discord_apikey)
        .setActivity(Activity.playing("osu!")).build()
    internal val guild = bot.getGuildById(config.discord_guildId)
    internal val logger = logger("Discord")

    internal fun run() {
        try {
            logger.info("Discord client start!")
            bot.awaitReady()

            logger.info("Discord login success! ${bot.selfUser.name}#${bot.selfUser.discriminator}")
        } catch (error: Exception) {
            logger.fatal("Discord start Error!")
            logger.trace(error)

            throw error
        }
    }

    internal fun disable() {
        try {
            logger.info("Discord stop!")
            bot.shutdown()

            logger.info("Discord stop success!")
        } catch (error: Exception) {
            logger.fatal("Discord stop Error!")
            logger.trace(error)
        }
    }
}
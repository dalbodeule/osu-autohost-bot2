package space.mori.osu_autohost_bot

import space.mori.osu_autohost_bot.osu.Main as OsuMain
import space.mori.osu_autohost_bot.discord.Main as DiscordMain

fun main() {
    MainClass.run()
}

object MainClass {
    internal val config = Configure()

    internal fun run() {
        try {
            val osuMain = OsuMain(config)
            osuMain.run()

            val discordMain = DiscordMain(config)
            discordMain.run()
        } catch (error: Exception) {
            System.exit(0)
        }
    }
}
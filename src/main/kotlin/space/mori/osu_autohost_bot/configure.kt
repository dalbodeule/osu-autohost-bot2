package space.mori.osu_autohost_bot

import io.github.cdimascio.dotenv.dotenv

val dotenv = dotenv()

data class Configure (
    val osu_apikey: String = dotenv["OSU_APIKEY"],
    val osu_username: String = dotenv["OSU_USERNAME"],
    val osu_password: String = dotenv["OSU_PASSWORD"],

    val discord_apikey: String = dotenv["DISCORD_APIKEY"],
    val discord_guildId: Number = java.lang.Long.valueOf(dotenv["DISCORD_GUILDID"]),
    val discord_commandId: String = dotenv["DISCORD_COMMAND_ID"]
)
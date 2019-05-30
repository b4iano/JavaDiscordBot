package br.com;

import br.com.commands.*;
import br.com.core.DataBase;
import br.com.core.commandHandler;
import br.com.core.messageListener;
import br.com.listeners.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Main {

    static JDA jda;

    public static void main(String[] args) {
        DataBase db = new DataBase();

        String token = "Not gonna raid anymore";

        JDABuilder builder = new JDABuilder(AccountType.BOT)
                .setToken(token)
                .setAutoReconnect(true)
                .setGame(Game.of(Game.GameType.LISTENING, "Your Problems"))
                .setStatus(OnlineStatus.ONLINE);

        builder.addEventListener(new readyListener());
        builder.addEventListener(new messageListener());

        commandHandler.commands.put("help", new cmdHelp());
        commandHandler.commands.put("ping", new cmdPing());
        commandHandler.commands.put("pcinfo", new cmdPCInfo());
        commandHandler.commands.put("set", new cmdSetID());
        commandHandler.commands.put("noob", new cmdEasterEgg01());
        commandHandler.commands.put("status", new cmdCPU());
        commandHandler.commands.put("stetus", new cmdRAM());
        commandHandler.commands.put("stitus", new cmdDisk());
        commandHandler.commands.put("alerta", new cmdAlerts());

        try {
            jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

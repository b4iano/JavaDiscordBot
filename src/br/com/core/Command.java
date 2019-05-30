package br.com.core;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.sql.SQLException;

public interface Command {

    boolean called (String[] args, MessageReceivedEvent event);
    void action(String[] args, MessageReceivedEvent event) throws SQLException;
    void executed(boolean sucess, MessageReceivedEvent event);
    String help();

}

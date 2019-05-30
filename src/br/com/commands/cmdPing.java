package br.com.commands;

import br.com.core.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdPing implements Command {

    @Override
    public boolean called (String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action (String[] args, MessageReceivedEvent event){

        event.getTextChannel().sendMessage(
                ":ping_pong: Pong! " + event.getJDA().getPing() +  "ms"
        ).queue();

    }

    @Override
    public void executed (boolean success, MessageReceivedEvent event){

    }

    @Override
    public String help(){
        return null;
    }
}

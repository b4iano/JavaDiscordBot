package br.com.commands;

import br.com.core.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sun.plugin2.message.Message;

public class cmdEasterEgg01 implements Command {

    @Override
    public boolean called (String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action (String[] args, MessageReceivedEvent event){

        String author = event.getAuthor().getId();
        String author1 = "<@" + author + ">";
        event.getTextChannel().sendMessage(
                "É hora do duelo " + author1 + " \n https://tenor.com/view/yugioh-time-to-duel-card-gif-12403495"
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

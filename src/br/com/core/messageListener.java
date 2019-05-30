package br.com.core;

import br.com.utils.UTILS;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.sql.SQLException;

public class messageListener extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }

        if (event.getChannelType() == ChannelType.PRIVATE){
            event.getAuthor().openPrivateChannel().complete().sendMessage(
                    "**" +  event.getAuthor().getName() + "**, Desculpa mas não aceito mensagens privadas!"
            ).queue();
            return;
        }

        String message = event.getMessage().getContentDisplay();
        if(message.startsWith(UTILS.getPrefix) && event.getAuthor().getId() != event.getJDA().getSelfUser().getId()){
            try {
                commandHandler.handleCommand(commandHandler.parser.parse(message, event));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
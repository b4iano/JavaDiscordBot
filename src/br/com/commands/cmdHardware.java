package br.com.commands;

import br.com.core.Command;
import br.com.core.Database2;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.sql.SQLException;

public class cmdHardware implements Command {

    Database2 db = new Database2();

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws SQLException {

        String UserId = event.getAuthor().getId();
        String selectDados = db.selectIdSoftFromTable(UserId);
        event.getTextChannel().sendMessage(
                selectDados
        ).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}


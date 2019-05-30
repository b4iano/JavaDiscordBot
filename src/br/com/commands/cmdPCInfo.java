package br.com.commands;

import br.com.core.Command;
import br.com.core.DataBase;
import br.com.core.Database2;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.sql.SQLException;

public class cmdPCInfo implements Command {
    DataBase db = new DataBase();
    Database2 db2 = new Database2();


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws SQLException {

        String selectIdSoft;
        String selectDados;
        String author1 = "<@" + event.getAuthor().getId() + ">";
        String nomeMaquina = event.getMessage().getContentDisplay();
        selectIdSoft = db2.selectIdSoftFromTable(nomeMaquina);
        selectDados = db.selectRecordsFromDbUserTable(selectIdSoft);

        if (selectDados.contains("null")) {
            event.getTextChannel().sendMessage(
                    "Essa máquina ai não foi encontrada não " + author1 + " verifica o nome e ai tu tenta dnv!"
            ).queue();

        } else {
            event.getTextChannel().sendMessage(
                    selectDados
            ).queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}

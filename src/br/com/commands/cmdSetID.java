package br.com.commands;

import br.com.core.Command;
import br.com.core.DataBase;
import br.com.core.Database2;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.sql.SQLException;

public class cmdSetID implements Command {
    DataBase db = new DataBase();
    Database2 db2 = new Database2();


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws SQLException {

        String author1 = "<@" + event.getAuthor().getId() + ">";
        String message = event.getMessage().getContentDisplay();
        if (message.equals("-set")) {
            event.getTextChannel().sendMessage(
                    author1 + " Insere seu Id de Usuário junto ao comando meu caro Player Nº1"
            ).queue();
        } else {
            db.codeUser(message);
        }
        //db.codeUser(message);
        String selectDados = (String) db2.selectRecordsFromTable(db.aux);
        //String insertDados = (String) db.insertRecordIntoTable(db.codigoCliente);


        if (selectDados == null) {
            event.getTextChannel().sendMessage(
                    author1 + " nem existe bro!"
            ).queue();
        } else {
            db.insertRecordIntoTable(event.getAuthor().getId());
            event.getTextChannel().sendMessage(
                    author1 + " seu registro foi efetuado com sucesso :call_me:"
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

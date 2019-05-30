package br.com.commands;

import br.com.core.Command;
import br.com.core.DataBase;
import br.com.core.Database2;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.sql.SQLException;

public class cmdDisk implements Command {
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
        selectDados = db.getInfoDisk(selectIdSoft);

        if (selectDados.contains("null")) {
            event.getTextChannel().sendMessage(
                    "Ai " + author1 + " os dados dessa máquina que tu ta me falando eu não to encontrando, verifica" +
                            " o nome dela, ou se você iniciou a monitoração desse componente ai tu tenta denovo dps!"
            ).queue();
        } else {
            event.getTextChannel().sendMessage(
                    "**As leituras atuais dessa máquina são essas** \n" + selectDados
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

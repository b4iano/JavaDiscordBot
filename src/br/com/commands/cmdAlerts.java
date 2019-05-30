package br.com.commands;

import br.com.core.Command;
import br.com.core.DataBase;
import br.com.core.Database2;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class cmdAlerts implements Command {
    Timer timer;
    DataBase db = new DataBase();
    Database2 db2 = new Database2();
    static double temperatura;

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

        Thread alerta = new Thread() {
            public void start() {

                timer = new Timer();

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            temperatura = Double.parseDouble(db.getTemperaturaCpu(selectIdSoft));
                            if (temperatura >=50){
                                //arruma aqui vlw
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, 5, 5000);
            }
        };

        if (alerta.isInterrupted()){
            event.getTextChannel().sendMessage(
                    "ALERTA!"
            ).queue();
        }
        event.getTextChannel().sendMessage(
                "Sistema de Alerta ligado, qualquer novidade nós avisamos!"
        ).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}

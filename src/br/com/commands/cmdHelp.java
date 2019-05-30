package br.com.commands;

import br.com.core.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdHelp implements Command {

    @Override
    public boolean called (String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action (String[] args, MessageReceivedEvent event){

        event.getTextChannel().sendMessage(
                "**COMANDOS**" +
                        "\n `-help` - Mostra todos os comandos que nosso Bot possui." +
                        "\n `-ping` - Mostra a latência da sua internet com o Discord." +
                        "\n `-set`  - Use isso para se cadastrar no nosso Bot. LEMBRE-SE DE COLOCAR SEU TOKEN JUNTO AO COMANDO" +
                        "\n `-pcinfo` - Use este comando para ter as informações de Hardware da sua máquina, só usar" +
                        " o comando junto com o nome da máquina quer você quer ter as informações!"
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

package br.com.listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event){

        String servers  = "\nEste bot está sendo usado nos seguintes servidores:";

        for(Guild g : event.getJDA().getGuilds()){
            servers += "\n" + g.getName() + " (" + g.getId() + ")";
        }

        System.out.println(servers);
    }
}

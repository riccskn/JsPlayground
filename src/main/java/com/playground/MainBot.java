package com.playground;

import com.playground.listener.EventListener;
import com.playground.manager.UserManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class MainBot {

    public static void main(String[] args) {

        try {
            connect();


        } catch (LoginException e) {
            e.printStackTrace();
        }

    }

    private static void connect() throws LoginException {

    JDABuilder.createDefault("YOUR TOKEN")
            .setActivity(Activity.playing("JavaScript"))
            .addEventListeners(new EventListener(new UserManager()))
            .build();

    }

}

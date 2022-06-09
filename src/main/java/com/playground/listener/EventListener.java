package com.playground.listener;

import com.playground.handler.ScriptHandler;
import com.playground.manager.UserManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {

    private UserManager userManager;

    public EventListener(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

       if (event.getMessage().getContentDisplay().equals("!js")) {

         if (!userManager.hasInQueue(event.getAuthor())) {

             userManager.addToQueue(event.getAuthor());
             event.getChannel().sendMessage("✅ You were added on queue,now send you code here")
                     .queue();

         }else {

             event.getChannel().sendMessage("❌ You already are on queue,just send your script")
                    .queue();

         }

       }else {

           if (userManager.hasInQueue(event.getAuthor())) {

               ScriptHandler scriptHandler = new ScriptHandler();

               event.getChannel().sendMessageEmbeds(scriptHandler.handle(event.getMessage().getContentDisplay())).queue();

               userManager.removeFromQueue(event.getAuthor());

           }

       }

    }
}

package com.playground.manager;

import net.dv8tion.jda.api.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserManager {

    private Set<String> queue = new HashSet<>();

    public UserManager() {
    }

    public void addToQueue(User user) {

        queue.add(user.getName());

    }

    public void removeFromQueue(User user) {

        queue.remove(user.getName());

    }

    public boolean hasInQueue(User user) {

        return queue.contains(user.getName());

    }

}

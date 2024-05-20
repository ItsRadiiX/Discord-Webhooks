package com.itsradiix.discordwebhook.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class represents the allowed Mentions Object.
 * Make sure you have read <a href="https://discord.com/developers/docs/resources/channel#allowed-mentions-object">Discord's Documentation of Mentions</a>
 *
 * @author ItsRadiiX
 * @version 2.0
 * @since 2024-05-19
 */

public class Mentions {
    private List<String> parse;
    private List<String> users;

    public Mentions() {}

    public void mentionEveryone(){
        if (parse == null) parse = new ArrayList<>();
        if (parse.contains("everyone")) return;
        parse.add("everyone");
    }

    public void mentionUsers(){
        if (parse == null) parse = new ArrayList<>();
        if (parse.contains("users")) return;
        parse.add("users");
    }

    public void mentionRoles(){
        if (parse == null) parse = new ArrayList<>();
        if (parse.contains("roles")) return;
        parse.add("roles");
    }

    public void addUser(String... users){
        if (this.users == null) this.users = new ArrayList<>();
        for (String user : users){
            if (this.users.contains(user)) continue;
            this.users.add(user);
        }
    }
}

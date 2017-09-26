package com.example.a54hk.chatkit.first;

import com.stfalcon.chatkit.commons.models.IUser;

/**
 * Created by 54hk on 2017/9/26.
 */

public class ChatUserBean implements IUser {

    private String id;
    private String name;
    private String avatar;
    private boolean online;

    public ChatUserBean(String id, String name, String avatar) {
        this(id, name, avatar, true);
    }

    public ChatUserBean(String id, String name, String avatar, boolean online) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.online = online;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAvatar() {
        return avatar;
    }

    public boolean isOnline() {
        return online;
    }
}

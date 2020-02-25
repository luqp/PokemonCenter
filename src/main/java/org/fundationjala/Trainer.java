package org.fundationjala;

import java.util.List;

public class Trainer {
    private String name;
    private String nickname;
    private BackPack backPack;

    public Trainer(String name, String nickname, BackPack backPack) {
        this.name = name;
        this.nickname = nickname;
        this.backPack = backPack;
    }

    public BackPack getBackPack() {
        return backPack;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}

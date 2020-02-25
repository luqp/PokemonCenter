package org.fundationjala;

import java.util.ArrayList;
import java.util.List;

public class PokemonInfo {
    private String name;
    private List<PokemonType> types;
    private int baseHealth;

    public PokemonInfo(String name, PokemonType type, int baseHealth) {
        this.name = name;
        this.types = new ArrayList<>();
        this.types.add(type);
        this.baseHealth = baseHealth;
    }

    public PokemonInfo(String name, List<PokemonType> type, int baseHealth) {
        this.name = name;
        this.types = type;
        this.baseHealth = baseHealth;
    }

    public String getName() {
        return name;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public int getBaseHealth() {
        return baseHealth;
    }
}

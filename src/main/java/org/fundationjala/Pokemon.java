package org.fundationjala;

public class Pokemon {
    private PokemonInfo pokemonInfo;
    private String alias;
    private int currentHealth;
    private Gender gender;

    public Pokemon(PokemonInfo pokemonInfo, String alias, int currentHealth, Gender gender) {
        this.pokemonInfo = pokemonInfo;
        this.alias = alias;
        this.currentHealth = currentHealth;
        this.gender = gender;
    }

    public PokemonInfo getPokemonInfo() {
        return pokemonInfo;
    }

    public String getAlias() {
        return alias;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Gender getGender() {
        return gender;
    }
}

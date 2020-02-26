package org.fundationjala;

import java.util.*;

public class StorageBox {

    private Map<Trainer, List<Pokemon>> register;

    public StorageBox() {
        this.register = new HashMap<>();
    }

    public List<Pokemon> getPokemons(Trainer trainer) {
        return register.getOrDefault(trainer, Collections.emptyList());
    }


    public void add(Trainer trainer, Pokemon pokemon) {
        List<Pokemon> pokemons = register.computeIfAbsent(trainer, key -> new ArrayList<>());
        pokemons.add(pokemon);
        register.put(trainer, pokemons);
    }

    public Pokemon remove(Trainer trainer, int pokemonNumber) {
        return register.get(trainer).remove(pokemonNumber);
    }
}

package org.fundationjala;

import java.util.ArrayList;
import java.util.List;

public class StorageService {

    private StorageBox box;

    public StorageService(StorageBox box, boolean isEnable) {
        this.box = box;
        this.isEnable = isEnable;
    }

    public boolean isEnable;

    public List<Pokemon> getPokemons(Trainer trainer) {
        List<Pokemon> pokemons;
        if (box.getPokemons(trainer) == null) {
            pokemons = new ArrayList<Pokemon>();
        }
        else {
            pokemons = box.getPokemons(trainer);
        }

        return pokemons;
    }

    public void deposit(Trainer trainer, int pokemonNumber) {
        Pokemon pokemon = trainer.getBackPack().remove(pokemonNumber);
        box.add(trainer, pokemon);
    }

    public void withdraw(Trainer trainer, int pokemonNumber) {
        if (box.getPokemons(trainer) == null) {
            throw new IllegalStateException("Cannot possible withdraw of <" + trainer.getName() + "> account.");
        }
        Pokemon pokemon = box.getPokemons(trainer).get(pokemonNumber);
        box.remove(trainer, pokemon);
        trainer.getBackPack().add(pokemon);
    }
}

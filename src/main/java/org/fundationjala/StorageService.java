package org.fundationjala;

import java.util.ArrayList;
import java.util.List;

public class StorageService {

    private StorageBox box;

    public StorageService(StorageBox box) {
        this.box = box;
    }

    public List<Pokemon> getPokemons(Trainer trainer) {
       return box.getPokemons(trainer);
    }

    public void deposit(Trainer trainer, int pokemonNumber) {
        Pokemon pokemon = trainer.getBackPack().remove(pokemonNumber);
        box.add(trainer, pokemon);
    }

    public void withdraw(Trainer trainer, int pokemonNumber) {
        if (box.getPokemons(trainer).isEmpty()) {
            throw new IllegalStateException("The <" + trainer.getName() + "> account doesn't have pokemons.");
        }
        Pokemon pokemon = box.remove(trainer, pokemonNumber);
        trainer.getBackPack().add(pokemon);
    }
}

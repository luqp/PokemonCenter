package org.fundationjala;

import java.util.ArrayList;
import java.util.List;

public class StorageService {

    public StorageService(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public boolean isEnable;

    public String getPokemonsDetails(StorageBox box, Trainer trainer) {
        List<Pokemon> pokemons;
        if (box.getPokemons(trainer) == null) {
            pokemons = new ArrayList<Pokemon>();
        }
        else {
            pokemons = box.getPokemons(trainer);
        }

        return getPokemonsDetails(pokemons);
    }

    public String getPokemonsDetails(List<Pokemon> pokemons) {
        StringBuilder builder = new StringBuilder();
        int position = 0;
        if (pokemons.size() > 0) {
            for (Pokemon pokemon: pokemons) {

                builder.append("\t")
                        .append(position).append(") ")
                        .append(pokemon.getAlias()).append(", ")
                        .append(pokemon.getCurrentHealth()).append(" hp\n");
                position++;
            }
        }
        else {
            builder.append("Without pokemons to show.\n");
        }
        return builder.toString();
    }

    public void deposit(Trainer trainer, int pokemonNumber, StorageBox box) {
        Pokemon pokemon = trainer.getBackPack().remove(pokemonNumber);
        box.add(trainer, pokemon);
    }

    public void withdraw(Trainer trainer, int pokemonNumber, StorageBox box) {
        if (box.getPokemons(trainer) == null) {
            System.out.println("Cannot possible withdraw pokemons. \n");
            return;
        }
        Pokemon pokemon = box.getPokemons(trainer).get(pokemonNumber);
        box.remove(trainer, pokemon);
        trainer.getBackPack().add(pokemon);
    }
}

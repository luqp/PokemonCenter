package org.fundationjala;

import java.lang.reflect.Array;
import java.util.*;

public class StorageBox {
    private Map<Trainer, List<Pokemon>> register;
    private boolean isActive;

    public StorageBox() {
        this.register = new HashMap<>();
        this.isActive = false;
    }



    public void add(Trainer trainer, Pokemon pokemon) {
        if (register.containsKey(trainer)) {
            register.get(trainer).add(pokemon);
        } else {
            register.put(trainer, new ArrayList<>(Collections.singletonList(pokemon)));
        }
    }

    public void remove(Trainer trainer, Pokemon pokemon) {
        register.get(trainer).remove(pokemon);
    }

    public List<Pokemon> getPokemons(Trainer trainer) {
        return register.get(trainer);
    }
}

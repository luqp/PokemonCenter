package org.fundationjala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        StorageBox box = new StorageBox();
        StorageService service = new StorageService(true);
        ConsoleClient client = new ConsoleClient(getTrainersData(), box, service);
        client.run();
    }


    private static List<Trainer> getTrainersData() {
        List<PokemonInfo> pokemonInfos = Arrays.asList(new PokemonInfo("Psyduck", PokemonType.WATER, 100),
                new PokemonInfo("Squirtle", PokemonType.WATER, 100),
                new PokemonInfo("Poliwag", PokemonType.WATER, 100),
                new PokemonInfo("Charmander", PokemonType.FIRE, 100),
                new PokemonInfo("Vulpix", PokemonType.FIRE, 100),
                new PokemonInfo("Magmar", PokemonType.FIRE, 100),
                new PokemonInfo("Caterpie", PokemonType.BUG, 100),
                new PokemonInfo("Paras", Arrays.asList(PokemonType.BUG, PokemonType.GRASS), 100),
                new PokemonInfo("Scyther", Arrays.asList(PokemonType.BUG, PokemonType.FLYING), 100),
                new PokemonInfo("Gastly", Arrays.asList(PokemonType.GHOST, PokemonType.POISON), 100),
                new PokemonInfo("Drifloon", Arrays.asList(PokemonType.GHOST, PokemonType.FLYING), 100),
                new PokemonInfo("Shuppet", PokemonType.GHOST, 100),
                new PokemonInfo("Pidgey", Arrays.asList(PokemonType.NORMAL, PokemonType.FLYING), 100),
                new PokemonInfo("Igglybuff", Arrays.asList(PokemonType.NORMAL, PokemonType.FAIRY), 100),
                new PokemonInfo("Drifloon", PokemonType.NORMAL, 100),
                new PokemonInfo("Magnemite", Arrays.asList(PokemonType.ELECTRIC, PokemonType.STEEL), 100),
                new PokemonInfo("Aron", Arrays.asList(PokemonType.STEEL, PokemonType.ROCK), 100),
                new PokemonInfo("Skarmory", Arrays.asList(PokemonType.STEEL, PokemonType.FLYING), 100));

        List<Trainer> trainers = Arrays.asList(new Trainer("Juan", "Dwits", new BackPack(6)),
                new Trainer("Lucero", "Adaomi", new BackPack(6)),
                new Trainer("Luan", "Dwomi", new BackPack(6)));

        Random random = new Random();

        for (Trainer trainer : trainers) {
            BackPack backPack = trainer.getBackPack();

            for (int i = 1; i <= 3; i++) {
                int index = random.nextInt(pokemonInfos.size());
                PokemonInfo pokeInfo = pokemonInfos.get(index);
                backPack.add(new Pokemon(pokeInfo, pokeInfo.getName(), 25 * i, Gender.FEMALE));
            }
        }

        return trainers;
    }
}

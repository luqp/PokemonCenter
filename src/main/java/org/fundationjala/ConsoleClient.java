package org.fundationjala;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ConsoleClient {

    private Scanner scanner;
    private List<Trainer> trainers;
    private StorageService storageService;

    public ConsoleClient(List<Trainer> trainers, StorageService storageService) {
        this.storageService = storageService;
        this.trainers = trainers;
    }

    public void run() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select Trainer:");
            for (int i = 0; i < trainers.size(); i++) {
                System.out.println(i + ") " + trainers.get(i).getNickname());
            }
            int input = scanner.nextInt();
            if (input == 20) {
                break;
            }

            Trainer activeTrainer = trainers.get(input);

            try {
                selectService(activeTrainer);
            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void selectService(Trainer activeTrainer) {
        boolean inSelection = true;
        while (inSelection) {
            System.out.println("Select Service: \n\t1) Bill PC\n\t2) Heal service\n\t3) Daycare service");
            int serviceNumber = scanner.nextInt();

            switch (serviceNumber) {
                case 1:
                    inSelection = runStorageService(activeTrainer);
                    break;
                case 2:
                    inSelection = false;
                    break;
                case 3:
                    inSelection = false;
                    break;
                default:
                    System.out.println("Not selected service.");
                    break;
            }
        }
    }

    private boolean runStorageService(Trainer trainer) {
        while (true){
            if (!storageService.isEnable) {
                System.out.println("Bill PC is not enable, return later.");
                return true;
            }

            System.out.println("Bill PC is enable to use.");
            System.out.println("Bill PC Select Action:");
            System.out.println("\t1) Show pokemons in the pokebox PC");
            System.out.println("\t2) Show pokemons in your backpack");
            System.out.println("\t3) Put a pokemon into pokebox PC");
            System.out.println("\t4) Take of pokemon of pokebox PC");
            System.out.println("\t5) Close service");
            System.out.println("\t6) Close session");

            int actionNumber = scanner.nextInt();
            int pokemonNumber;
            switch (actionNumber) {
                case 1:
                    showPokemons(storageService.getPokemons(trainer));
                    break;
                case 2:
                    showPokemons(trainer.getBackPack());
                    break;
                case 3:
                    showPokemons(storageService.getPokemons(trainer));
                    pokemonNumber = getPokemonNumber();
                    storageService.deposit(trainer, pokemonNumber);
                    break;
                case 4:
                    showPokemons(trainer.getBackPack());
                    pokemonNumber = getPokemonNumber();
                    storageService.withdraw(trainer, pokemonNumber);
                    break;
                case 5:
                    return true;
                case 6:
                    return false;
                default:
                    System.out.println("Command's not in the list.");
            }

            enterToContinue();
        }
    }

    private void showPokemons(Iterable<Pokemon> pokemons) {
        Iterator<Pokemon> iteratorPokemon = pokemons.iterator();
        StringBuilder builder = new StringBuilder();
        if (!iteratorPokemon.hasNext()) {
            builder.append("Without pokemons to show.");
        }
        else {
            for (int i = 0; iteratorPokemon.hasNext(); i++) {
                Pokemon pokemon = iteratorPokemon.next();
                builder.append("\t")
                        .append(i).append(") ")
                        .append(pokemon.getAlias()).append(", ")
                        .append(pokemon.getCurrentHealth()).append(" hp\n");
            }
        }
        System.out.println(builder.toString());
    }


    private int getPokemonNumber() {
        System.out.println("Insert pokemon number:");
        return scanner.nextInt();
    }

    private void enterToContinue() {
        System.out.print("Press any <key> to continue.\n");
        scanner.next();
    }
}

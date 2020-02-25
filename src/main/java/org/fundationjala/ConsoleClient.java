package org.fundationjala;

import java.util.List;
import java.util.Scanner;

public class ConsoleClient {

    private Scanner scanner;
    private List<Trainer> trainers;
    private StorageBox box;
    private StorageService storageService;

    public ConsoleClient(List<Trainer> trainers, StorageBox box, StorageService storageService) {
        this.storageService = storageService;
        this.trainers = trainers;
        this.box = box;
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
                    System.out.println(storageService.getPokemonsDetails(box, trainer));
                    break;
                case 2:
                    List<Pokemon> pokemons = trainer.getBackPack().getPokemons();
                    System.out.println(storageService.getPokemonsDetails(pokemons));
                    break;
                case 3:
                    System.out.println("Insert pokemon number of your backpack:");
                    pokemonNumber = scanner.nextInt();
                    storageService.deposit(trainer, pokemonNumber, box);
                    break;
                case 4:
                    System.out.println("Select pokemon number of PC box:");
                    pokemonNumber = scanner.nextInt();
                    storageService.withdraw(trainer, pokemonNumber, box);
                    break;
                case 5:
                    return true;
                case 6:
                    return false;
                default:
                    System.out.println("Command not in the list.");
            }
        }
    }


    private void showTrainer(int index) {
        Trainer trainer = trainers.get(index);

        System.out.println("Name: " + trainer.getName());
        System.out.println("Username: " + trainer.getNickname());
        System.out.println("Pokemons: ");
        for (Pokemon pokemon: trainer.getBackPack()) {
            System.out.println("\tName: " + pokemon.getAlias());
            System.out.println("\tType: " + pokemon.getGender());
            System.out.println("\tHP: " + pokemon.getCurrentHealth());
            System.out.println();
        }
    }
}

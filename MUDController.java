    package Game.controller.MUDController;

    import Game.Item.Item;
    import Game.player.Player;
    import Game.Entities.Room;
    import Game.GAMEENTITY.IGameEntity;

    import java.util.HashMap;
    import java.util.Scanner;

    public class MUDController {
        private final Player player;
        private boolean running;
        private final HashMap<String, Room> gameWorld;

        public MUDController(Player player) {
            this.player = player;
            this.running = true;
            this.gameWorld = new HashMap<>();
            initializeGameWorld();
        }

        public void runGameLoop() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the MUD game! Type 'help' for available commands.");

            while (running) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("quit")) {
                    running = false;
                    System.out.println("Goodbye!");
                    continue;
                }
                handleInput(input);
            }
            scanner.close();
        }
        private void initializeGameWorld() {
            Room mainHall = new Room("Main Hall", "A grand hall with a chandelier and a mysterious door.");
            Room treasureRoom = new Room("Treasure Room", "A room filled with gold and jewels.");
            Room guardRoom = new Room("Guard Room", "A dimly lit room with a fierce guard.");
            Room library = new Room("Library", "A quiet room filled with ancient books.");

            mainHall.addExit("north", treasureRoom);
            mainHall.addExit("east", guardRoom);
            guardRoom.addExit("west", mainHall);
            guardRoom.addExit("south", library);
            library.addExit("north", guardRoom);
            treasureRoom.addExit("south", mainHall);

            mainHall.addItems(new Item("Sword", "A sharp blade for combat."));
            treasureRoom.addItems(new Item("Gold Coin", "A shiny gold coin."));
            library.addItems(new Item("Ancient Book", "A dusty book with mysterious writings."));

            gameWorld.put("Main Hall", mainHall);
            gameWorld.put("Treasure Room", treasureRoom);
            gameWorld.put("Guard Room", guardRoom);
            gameWorld.put("Library", library);

            player.setCurrentRoom(mainHall);
        }
        public void handleInput(String input) {
            if (input == null || input.isEmpty()) {
                System.out.println("Invalid command");
                return;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "look":
                    lookAround();
                    break;
                case "move":
                    move(argument);
                    break;
                case "pick":
                    pickUp(argument);
                    break;
                case "inventory":
                    checkInventory();
                    break;
                case "help":
                    showHelp();
                    break;
                default:
                    System.out.println("Unknown command. Type 'help' for available commands.");
            }
        }

        private void lookAround() {
            Room currentRoom = (Room) player.getCurrentRoom();
            currentRoom.describe();
            System.out.println("Items in room:");
            currentRoom.getItems().forEach(IGameEntity::describe);
        }

        private void move(String direction) {
            Room currentRoom = (Room) player.getCurrentRoom();
            Room nextRoom = currentRoom.getExit(direction);

            if (nextRoom != null) {
                player.setCurrentRoom(nextRoom);
                System.out.println("You moved " + direction);
                lookAround();
            } else {
                System.out.println("There's no exit in that direction!");
            }
        }

        private void pickUp(String arg) {
            if (!arg.startsWith("up ")) {
                System.out.println("Usage: 'pick up <item>'");
                return;
            }

            String itemName = arg.substring(3).trim();
            Room currentRoom = (Room) player.getCurrentRoom();
            IGameEntity item = currentRoom.removeItem(itemName);

            if (item != null) {
                player.addItemToInventory(item);
                System.out.println("Picked up: " + itemName);
            } else {
                System.out.println("Item not found: " + itemName);
            }
        }

        private void checkInventory() {
            System.out.println("Your inventory:");
            player.getInventory().forEach(item ->
                    System.out.println("- " + ((Item) item).getName())
            );
        }

        private void showHelp() {
            System.out.println("Available commands:");
            System.out.println("look - Show current room description");
            System.out.println("move <direction> - Move in specified direction");
            System.out.println("pick up <item> - Pick up an item");
            System.out.println("inventory - Show your inventory");
            System.out.println("help - Show this help message");
            System.out.println("quit - Exit the game");
        }
    }
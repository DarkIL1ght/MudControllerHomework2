package Game.controller.MUDController;

import Game.player.Player;

public class MUDController {


    //private final Player player;
    private boolean running;

    /**
     * Constructs the controller with a reference to the current player.
     */
    public MUDController(Player player) {
        // Initialize fields here (if needed)
    }

    /**
     * Main loop method that repeatedly reads input from the user
     * and dispatches commands until the game ends.
     */
    public void runGameLoop() {
        // TODO: Implement a loop that:
        // 1) Prints a prompt (e.g., "> ")
        // 2) Reads user input
        // 3) Calls handleInput(input)
        // 4) Terminates when 'running' is set to false
    }

    /**
     * Handle a single command input (e.g. 'look', 'move forward', 'pick up sword').
     */
    public void handleInput(String input) {
        // TODO:
        // 1) Parse the input into a command and optionally an argument
        // 2) Use a switch/case (or if/else) to call the correct method below
        //    based on the command word
    }

    /**
     * Look around the current room: describe it and show items/NPCs.
     */
    private void lookAround() {
        // TODO: Print information about the player's current room
    }

    /**
     * Move the player in a given direction (forward, back, left, right).
     */
    private void move(String direction) {
        // TODO: Attempt to move to the next room in the given direction
        //       If there's no room in that direction, print an error message
        //       If successfully moved, describe the new room
    }

    /**
     * Pick up an item (e.g. "pick up sword").
     */
    private void pickUp(String arg) {
        // TODO:
        // 1) Parse out the item name if 'arg' starts with "up "
        // 2) Check if that item exists in the current room
        // 3) Remove from room, add to player's inventory
    }

    /**
     * Check the player's inventory.
     */
    private void checkInventory() {
        // TODO: List the items in the player's inventory
        //       If no items, indicate that the inventory is empty
    }

    /**
     * Show help commands
     */
    private void showHelp() {
        // TODO: Print a list of available commands and brief instructions
    }

    /**
     * (Optional) Add any other methods (e.g., attack, open door, talk, etc.)
     * if you want to extend the game logic further.
     */
}

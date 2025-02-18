# MUD Controller – Homework Assignment

## Overview

In this assignment, you will implement a simple **MUD (Multi-User Dungeon) Controller** that processes basic player commands (e.g. `look`, `move`, `pick up`, `inventory`, etc.). You will fill in the logic within the `MUDController` skeleton so that it interacts with the rest of your MUD classes (like `Player`, `Room`, `Item`, etc.) to create a simple, playable command-line experience.

---

## Objectives

1. **Command Parsing:**  
   - Read textual commands (like `move forward`, `pick up sword`, `inventory`) and identify the _main_ command plus any _arguments_ (e.g., `forward`, `sword`).

2. **Room & Movement Logic:**  
   - When the player types `move forward`, the controller should check if the current room has a “forward” connection and move the player there if possible.  
   - If the direction is invalid or blocked, display an appropriate message.

3. **Interaction with Entities:**  
   - `look`: Describe the current room (e.g., name, description, items on the ground, NPCs).  
   - `pick up <itemName>`: Search for an item in the room, remove it from the room, and add it to the player’s inventory.  
   - `inventory`: List the items the player is carrying.

4. **Help & Exit:**  
   - Display a simple help menu for available commands.  
   - Allow the user to quit/exit the loop.

5. **SOLID & Clean Code:**  
   - Keep your implementation clear, concise, and properly commented.  
   - Adhere to single-responsibility for each method (no overly massive methods).

---

## Requirements

1. **You Must Use the Provided Skeleton:**  
   - The `MUDController` class has placeholders (methods, attributes) with `// TODO:` comments.  
   - **Do not** change method signatures or remove essential fields; however, you can add supporting helper methods if needed.

2. **Integrate with Existing Classes:**  
   - Make sure the controller uses your existing `Player`, `Room`, `Item`, etc.  
   - Confirm that `player.getCurrentRoom()` gives you the room object where the player stands, which is essential for `look`, `move`, and `pick up`.

3. **Minimal Set of Commands:**  
   - `look` – Describes the current room.  
   - `move <forward|back|left|right>` – Moves in a specified direction if possible.  
   - `pick up <itemName>` – Picks up an item from the ground.  
   - `inventory` – Lists items the player is carrying.  
   - `help` – Shows command usage.  
   - `quit` or `exit` – Ends the loop.

4. **Handle Errors Gracefully:**  
   - If a direction is invalid, print “You can’t go that way!”  
   - If an item doesn’t exist in the room, print “No item named X here!”  
   - If a command is unknown, print “Unknown command.”

5. **Write at Least Basic Tests or a Main Method:**  
   - Make sure you can compile and run your code, then enter commands to test each feature.

---

## Suggested Implementation Steps

1. **Start with the Skeleton**  
   - Open `MUDController.java` in your editor.  
   - Note the attributes (`player`, `running`) and the methods (`runGameLoop()`, `handleInput(...)`, `lookAround()`, etc.).

2. **Implement `runGameLoop()`**  
   - Create a simple loop that repeatedly reads user input and calls `handleInput(...)`.  
   - If the user types `quit` or `exit`, set `running = false` to break the loop.

3. **Implement `handleInput(...)`**  
   - Split the command line into `[command, argument]`.  
   - Use a `switch` (or `if/else`) to call `lookAround()`, `move(...)`, `pickUp(...)`, etc.

4. **Implement the Command Methods**  
   - **`lookAround()`**: Print the current room’s description (`room.describe()`), occupant info, etc.  
   - **`move(String direction)`**: Check room connections (e.g., `getForward()`). If valid, update the player’s room; else print an error.  
   - **`pickUp(String arg)`**: Parse out the item name, remove the item from the room, add to player inventory.  
   - **`checkInventory()`**: Loop through the player’s inventory to display items.  
   - **`showHelp()`**: Print usage info for each command.

5. **Testing**  
   - Write a small `main()` class that creates a `Room` with some items, a `Player` in that room, and a new `MUDController(player)`.  
   - Call `controller.runGameLoop()` and type commands to see if they behave correctly.

---

## Example Usage

Here’s how your game might look in the console after you implement the controller:

look Room: A small stone chamber Items here: sword, shield No NPCs present

pick up sword You pick up the sword

inventory You are carrying:

sword
move forward You can't go that way!

help Available commands:

look
move <forward|back|left|right>
pick up <itemName>
inventory
help
quit/exit


*(Outputs and wording may differ based on your actual code.)*

---

## Grading Criteria

- **Completeness**  
  - Does your controller handle the required commands properly?

- **Correctness**  
  - Are errors handled gracefully?  
  - Does `move` only succeed if there’s a connected room?

- **Code Quality**  
  - Are methods short and readable?  
  - Are you consistent with naming and minor details like logging messages?

- **Testing Effort**  
  - Have you tested the commands thoroughly?  
  - Do you demonstrate various scenarios (e.g., picking up a non-existent item)?

---

## Submission

1. **Implement the methods** in `MUDController.java` without modifying method signatures.  
3. Provide **instructions** (or a short `Main` method) showing how to compile/run your code.  
2. **Submit** your github link to Canvas

4. For extra credit, add at least one new command (like `attack`, `open door`, or `talk`) to demonstrate extension.

**Good luck, and have fun building your MUD controller!**

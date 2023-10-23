# ShadowDance Game

This is a music arcade game called ShadowDance implemented in Java as part of the SWEN20003 Object Oriented Software Development project.

## Game Overview

The aim of the game is to hit the corresponding musical notes that appear on the screen in different lanes on time to score points. There are three levels in the game, each with its own set of challenges and target scores. The player needs to beat the target score for each level to progress to the next level.

## Features

- Start Screen: The game starts with a start screen where the player can select the level to play.
- Level 1: In this level, the player needs to hit the notes in the four lanes by pressing the corresponding arrow keys.
- Level 2: This level introduces a special lane with special notes that have different effects when activated.
- Level 3: The final level includes enemies that try to steal notes from the lanes and a guardian that can shoot projectiles at the enemies.
- End Screen: After completing each level, the player is shown an end screen with the result and an option to return to the level selection.

## Implementation

The game is implemented using the Bagel game engine. Bagel is a basic academic game engine library that provides the necessary functionality for developing games in Java. You can find the detailed documentation for Bagel [here](https://people.eng.unimelb.edu.au/mcmurtrye/bagel-doc). The game entities, such as lanes, notes, hold notes, special notes, enemies, guardian, and projectiles, are represented by images and have their own behavior and interactions. The game logic is updated in each frame, and the graphics are rendered accordingly.

## Getting Started

To run the game, you need to have Java and the Bagel library installed. You can compile and run the ShadowDance class to start the game. Make sure to follow the instructions in the project specification for setting up the project and submitting your work.

## Customization

You have the option to customize the game by adding new features, modifying the graphics, or extending the gameplay. However, to be eligible for full marks, you must implement all the required features as outlined in the project specification.

## Credits

I would like to express my gratitude to my cat, Coffee, for keeping me company during those late-night coding sessions.

## License

This project is licensed under the MIT License. See the LICENSE file for more information.
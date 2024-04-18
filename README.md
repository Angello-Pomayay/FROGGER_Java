# Frogger Game in Java

This project is a Java game inspired by the classic arcade game, Frogger. This project was made by me as part of my
university programming course, was intended to show what I learned during the course.

## Features

- **Gameplay**: The game involves a frog that the player must navigate across a busy road to reach a river safety. The player must avoid cars. The cars speed increase while your score gets higher.

- **Graphics**: The game uses some images from the original game for the frog and cars. These images are loaded from the `img` directory.

- **Custom Fonts**: The game uses the font "Press Start 2P" loaded from the `fonts` directory.

- **Scoring**: The game keeps track of the player's score, which is displayed on the screen.

## Code Structure

The project is structured into several Java classes:

- `Frogger.java`: This is the main class of the game. It handles the game logic and score calculation. It sets up the game window and game loop.

- `Frog.java`: This class represents the frog in the game. The frog has a position and can move in different directions.

- `Car.java`: This class represents a car in the game. Each car has a position and a speed, and can move across the screen. This class also handles collision detection with the frog.

- `Riga.java`: This class handles all the queues of cars in the game, checking also their position to remove them from the queue when they reach the other side.

- `Vite.java`: This class represents the lives of the frog. The frog has 3 lives plus the starting one.

## Running the Game

To run the game, execute the `main` method in the `Frogger` class. The game window will open, and the game will start immediately.

## Future Improvements

While the game is fully functional, there are several potential areas for improvement:

- Adding sounds, such as background music and audio effects as the frog moves and when it reaches the river.
- Adding the others cars of the original game that had different lengths.
- Adding a high score system.
- Adding the second section of the game, where the frog must cross the river by jumping on logs and avoiding crocodiles.
- Implementing power-ups or other gameplay elements to make the game more diverse. Also adding a bonus level to certain scores.
- Adding a pause menu or other user interface elements to make the game more user-friendly.
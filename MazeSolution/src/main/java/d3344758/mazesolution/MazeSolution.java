/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package d3344758.mazesolution;

/**
 *
 * @author d3344758
 */
import java.util.Scanner;

public class MazeSolution {

    private char[][] maze;

    // Constructor to initialize the maze
    public MazeSolution(char[][] maze) {
        this.maze = maze;
    }

    // Getter for the maze
    public char[][] getMaze() {
        return maze;
    }

    // Setter for the maze
    public void setMaze(char[][] maze) {
        this.maze = maze;
    }

    // Task 1 - Player location
    public int[] getPlayerLocation() {
        /**
         * Returns an array of the current player position [0] = X [1] = Y
         */
        int playerX = 0;
        int playerY = 0;

        for (int i = 0; i < this.maze.length; i++) {
            for (int j = 0; j < this.maze[i].length; j++) {
                if (this.maze[i][j] == 'P') {
                    playerX = i;
                    playerY = j;
                    break;
                }
            }
        }

        int[] playerCoords = {playerX, playerY};
        return playerCoords;
    }

    public void printMazeToConsole() {
        for (int i = this.maze.length - 1; i >= 0; i--) {
            System.out.println(this.maze[i]);
        }
    }

    // T ask 3...
    public int[] movePlayerLogic(int[] playerCoords, String input, char[][] maze) {
        /**
         * Gets and updates the players position according to input inputs
         * accepted up, down, left, right requires player Co-ordinates, player
         * player input and the current maze
         *
         * returns an array: [0] is the NEW X co-ord [1] is the NEW Y co-ord [2]
         * is the OLD X co-ord [3] is the OLD Y co-ord
         */
        int[] newLocation = new int[4];

        int playerX = playerCoords[0];
        int playerY = playerCoords[1];

        newLocation[2] = playerX;
        newLocation[3] = playerY;

        if ((playerX != 0 && playerX != 9) && (playerY != 0 && playerY != 8)) {
            if ((maze[playerX + 1][playerY] != 'W') && (input.toLowerCase().equals("up"))) {
                newLocation[0] = playerX + 1;
                newLocation[1] = playerY;
            } else if ((maze[playerX - 1][playerY] != 'W') && (input.toLowerCase().equals("down"))) {
                newLocation[0] = playerX - 1;
                newLocation[1] = playerY;
            } else if ((maze[playerX][playerY + 1] != 'W') && (input.toLowerCase().equals("right"))) {
                newLocation[0] = playerX;
                newLocation[1] = playerY + 1;
            } else if ((maze[playerX][playerY - 1] != 'W') && (input.toLowerCase().equals("left"))) {
                newLocation[0] = playerX;
                newLocation[1] = playerY - 1;
            } else {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
            }
        } else if (playerX == 0) {
            if ((maze[playerX + 1][playerY] != 'W') && (input.toLowerCase().equals("up"))) {
                newLocation[0] = playerX + 1;
                newLocation[1] = playerY;
            } else if (input.toLowerCase().equals("down")) {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
                System.out.println("You cannot leave the Maze, please choose a different direction.");
            } else if ((maze[playerX][playerY + 1] != 'W') && (input.toLowerCase().equals("right"))) {
                newLocation[0] = playerX;
                newLocation[1] = playerY + 1;
            } else if ((maze[playerX][playerY - 1] != 'W') && (input.toLowerCase().equals("left"))) {
                newLocation[0] = playerX;
                newLocation[1] = playerY - 1;
            } else {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
            }
        } else if (playerX == 9) {
            if (input.toLowerCase().equals("up")) {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
                System.out.println("You cannot leave the Maze, please choose a different direction.");
            } else if (input.toLowerCase().equals("down")) {
                newLocation[0] = playerX - 1;
                newLocation[1] = playerY;
            } else if ((maze[playerX][playerY + 1] != 'W') && (input.toLowerCase().equals("right"))) {
                newLocation[0] = playerX;
                newLocation[1] = playerY + 1;
            } else if ((maze[playerX][playerY - 1] != 'W') && (input.toLowerCase().equals("left"))) {
                newLocation[0] = playerX;
                newLocation[1] = playerY - 1;
            } else {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
            }
        } else if (playerY == 0) {
            if ((maze[playerX + 1][playerY] != 'W') && (input.toLowerCase().equals("up"))) {
                newLocation[0] = playerX + 1;
                newLocation[1] = playerY;
            } else if ((maze[playerX - 1][playerY] != 'W') && (input.toLowerCase().equals("down"))) {
                newLocation[0] = playerX - 1;
                newLocation[1] = playerY;
            } else if ((maze[playerX][playerY + 1] != 'W') && (input.toLowerCase().equals("right"))) {
                newLocation[0] = playerX;
                newLocation[1] = playerY + 1;
            } else if (input.toLowerCase().equals("left")) {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
                System.out.println("You cannot leave the Maze, please choose a different direction.");
            } else {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
            }
        } else if (playerY == 8) {
            if ((maze[playerX + 1][playerY] != 'W') && (input.toLowerCase().equals("up"))) {
                newLocation[0] = playerX + 1;
                newLocation[1] = playerY;
            } else if ((maze[playerX - 1][playerY] != 'W') && (input.toLowerCase().equals("down"))) {
                newLocation[0] = playerX - 1;
                newLocation[1] = playerY;
            } else if (input.toLowerCase().equals("right")) {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
                System.out.println("You cannot leave the Maze, please choose a different direction.");
            } else if ((maze[playerX][playerY - 1] != 'W') && (input.toLowerCase().equals("left"))) {
                newLocation[0] = playerX;
                newLocation[1] = playerY - 1;
            } else {
                newLocation[0] = playerX;
                newLocation[1] = playerY;
            }
        }

        return newLocation;
    }

    public static int[] goalLocation(char[][] maze) {

        int[] goalLocation = new int[2];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'G') {
                    goalLocation[0] = i;
                    goalLocation[1] = j;
                    break;
                }
            }
        }

        return goalLocation;
    }

    public void updateMaze(int[] playerMovement) {
        int oldX = playerMovement[2];
        int oldY = playerMovement[3];

        int newX = playerMovement[0];
        int newY = playerMovement[1];

        char[][] oldMaze = this.getMaze();

        if (oldMaze[newX][newY] != 'P') {
            oldMaze[newX][newY] = 'P';
            oldMaze[oldX][oldY] = ' ';
        }

        this.setMaze(oldMaze);

    }

    public static void main(String[] args) {
        /* 
        10x9 (2D) char array  (9 x 8)
        W = wall
        P = player
        G = goal
         */
        char[][] initialMaze = {
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, // Row 0
            {'W', ' ', ' ', ' ', ' ', 'W', 'G', ' ', 'W'}, // Row 1
            {'W', ' ', 'W', 'W', 'W', 'W', 'W', ' ', 'W'}, // Row 2
            {'W', ' ', 'W', ' ', 'W', ' ', 'W', ' ', 'W'}, // Row 3
            {'W', ' ', 'W', ' ', 'W', ' ', 'W', ' ', 'W'}, // Row 4
            {'W', ' ', 'W', ' ', 'W', ' ', 'W', ' ', 'W'}, // Row 5
            {'W', ' ', 'W', ' ', 'W', ' ', 'W', ' ', 'W'}, // Row 6
            {'W', ' ', 'W', ' ', 'W', ' ', 'W', ' ', 'W'}, // Row 7
            {'W', 'P', ' ', ' ', ' ', ' ', ' ', ' ', 'W'}, // Row 8
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'} // Row 9
        };

        Scanner userInput = new Scanner(System.in);

        String[] validCommands = {
            "up", "down", "left", "right",};

        MazeSolution maze = new MazeSolution(initialMaze);
        maze.setMaze(initialMaze);

        char[][] retrieveMaze = maze.getMaze();
        int[] goalLocation = maze.goalLocation(retrieveMaze);

        int[] pLocation = maze.getPlayerLocation();

        while (pLocation[0] != goalLocation[0] || pLocation[1] != goalLocation[1]) {
            // Get player location and print maze
            pLocation = maze.getPlayerLocation();
            maze.printMazeToConsole();

            // Getting and handling user input
            System.out.println("Please pick a direction:  up, down, left or right.");
            String input = userInput.nextLine();
            // check for valid command and execute movement accordingly
            for (int i = 0; i < validCommands.length; i++) {
                if (input.toLowerCase().equals(validCommands[i])) {
                    int[] playerMovement = maze.movePlayerLogic(pLocation, input, retrieveMaze);
                    maze.updateMaze(playerMovement);
                    pLocation = maze.getPlayerLocation();
                    break;
                }
            }
            if ((pLocation[0] == goalLocation[0]) && (pLocation[1] == goalLocation[1])) {
                maze.printMazeToConsole();
                System.out.println("You have completed the maze! Well done!");
                break;
            }
        }

    }
}

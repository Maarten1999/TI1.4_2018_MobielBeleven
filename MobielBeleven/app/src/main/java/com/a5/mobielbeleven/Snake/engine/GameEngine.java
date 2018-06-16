package com.a5.mobielbeleven.Snake.engine;

import com.a5.mobielbeleven.Snake.classes.Coordinate;
import com.a5.mobielbeleven.Snake.enums.Direction;
import com.a5.mobielbeleven.Snake.enums.GameState;
import com.a5.mobielbeleven.Snake.enums.TileType;

import java.util.ArrayList;
import java.util.List;

public class GameEngine
{
    public static final int GameWidth = 20;
    public static final int GameHeight = 30;

    private List<Coordinate> walls = new ArrayList<>();
    private List<Coordinate> snake = new ArrayList<>();
    private List<Coordinate> apples = new ArrayList<>();

    private boolean increaseTail = false;
    private int score = 0;

    private Direction currentDirection = Direction.EAST;

    private GameState currentGameState = GameState.RUNNING;

    private Coordinate getSnakeHead()
    {
        return snake.get(0);
    }

    public GameEngine()
    {

    }

    public void initGame()
    {
        addSnake();
        //addWalls();
        addApple();
    }

    public void updateDirection(Direction newDirection)
    {
        if (Math.abs(newDirection.ordinal() - currentDirection.ordinal()) % 2 == 1) {
            currentDirection = newDirection;
        }
    }

    public void update()
    {
        //update the snake
        switch (currentDirection) {
            case NORTH:
                updateSnake(0, -1);
                break;
            case EAST:
                updateSnake(1, 0);
                break;
            case SOUTH:
                updateSnake(0, 1);
                break;
            case WEST:
                updateSnake(-1, 0);
                break;
        }

//        //check wall collision
//        for (Coordinate wall : walls) {
//            if (snake.get(0).equals(wall)) {
//                currentGameState = GameState.LOST;
//            }
//        }

        //check screen appearance
        if(getSnakeHead().getY() > GameHeight-1)
            snake.get(0).setY(0);
        if(getSnakeHead().getY() < 0)
            snake.get(0).setY(GameHeight-1);
        if(getSnakeHead().getX() > GameWidth-1)
            snake.get(0).setX(0);
        if(getSnakeHead().getX() < 0)
            snake.get(0).setX(GameWidth-1);

        //check collision tail
        for (int i = 1; i < snake.size() ; i++) {
            if (getSnakeHead().equals(snake.get(i))) {
                currentGameState = GameState.LOST;
            }
        }

        //check collision apple
        Coordinate appleToRemove = null;
        for (Coordinate apple : apples) {
            if (getSnakeHead().equals(apple)) {
                appleToRemove = apple;
                increaseTail = true;
                score++;

            }
        }
        if (appleToRemove != null) {
            apples.remove(appleToRemove);
            addApple();
        }
    }

    //aanmaken map voor de snakeview
    public TileType[][] getMap()
    {
        TileType[][] map = new TileType[GameWidth][GameHeight];
        for (int x = 0; x < GameWidth; x++) {
            for (int y = 0; y < GameHeight; y++) {
                map[x][y] = TileType.NOTHING;
            }
        }

        for (Coordinate s : snake) {
            map[s.getX()][s.getY()] = TileType.SNAKETAIL;
        }
        map[snake.get(0).getX()][snake.get(0).getY()] = TileType.SNAKEHEAD;

//        for (Coordinate wall : walls) {
//            map[wall.getX()][wall.getY()] = TileType.WALL;
//        }

        for (Coordinate apple : apples) {
            map[apple.getX()][apple.getY()] = TileType.APPLE;
        }
        return map;
    }

    //code voor het updaten van de positie van de snake en toevoegen van eventuele nieuwe snakestaart
    private void updateSnake(int x, int y)
    {
        int newX = snake.get(snake.size() - 1).getX();
        int newY = snake.get(snake.size() - 1).getY();

        for (int i = snake.size() - 1; i > 0 ; i--) {
            snake.get(i).setX(snake.get(i - 1).getX());
            snake.get(i).setY(snake.get(i - 1).getY());
        }

        if (increaseTail) {
            snake.add(new Coordinate(newX, newY));
            increaseTail = false;
        }
        snake.get(0).setX(snake.get(0).getX() + x);
        snake.get(0).setY(snake.get(0).getY() + y);
    }

    private void addSnake()
    {
        snake.clear();
        snake.add(new Coordinate(7, 7));
        snake.add(new Coordinate(6, 7));
        snake.add(new Coordinate(5, 7));
//        snake.add(new Coordinate(4, 7));
//        snake.add(new Coordinate(3, 7));
//        snake.add(new Coordinate(2, 7));

    }

    private void addWalls()
    {
        //top and bottom walls
        for (int x = 0; x < GameWidth; x++) {
            walls.add(new Coordinate(x, 0));
            walls.add(new Coordinate(x, GameHeight - 1));
        }

        // left and right walls
        for (int y = 1; y < GameHeight; y++) {
            walls.add(new Coordinate(0, y));
            walls.add(new Coordinate(GameWidth - 1, y));
        }
    }

    // toevoegen van een apple op random locatie
    private void addApple()
    {
        Coordinate coordinate = null;

        boolean added = false;

        while (!added) {
            int x = 1 + (int)(Math.random() * (GameWidth - 2));
            int y = 1 + (int)(Math.random() * (GameHeight - 2));

            coordinate = new Coordinate(x, y);
            boolean collision = false;
            for (Coordinate s : snake) {
                if (s.equals(coordinate)) {
                    collision = true;
                    break;
                }
            }
            if(collision)
                continue;

            for (Coordinate a : apples) {
                if (a.equals(coordinate)) {
                    collision = true;
                    break;
                }
            }
            added = !collision;
        }
        apples.add(coordinate);
    }

    public GameState getCurrentGameState()
    {
        return currentGameState;
    }

    public int getScore()
    {
        return score;
    }

}

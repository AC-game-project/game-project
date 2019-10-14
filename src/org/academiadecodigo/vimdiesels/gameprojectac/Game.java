package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.EnemyFactory;

import java.util.LinkedList;

public class Game implements KeyboardHandler {

    private Score score;
    private Rectangle canvasSize;
    private Picture background;
    private Picture planet;
    private CollisionDetector cDetector;
    private Menu menu;
    private Player player;
    private LinkedList<Enemy> enemyLinkedList;
    private Keyboard keyboard;
    private boolean hasStarted;

    public Game() {

        this.hasStarted = false;
        this.canvasSize = new Rectangle(GameConfig.PADDING, GameConfig.PADDING, GameConfig.CANVAS_WIDTH, GameConfig.CANVAS_HEIGHT);
        this.background = new Picture(GameConfig.PADDING, GameConfig.PADDING);

        this.score = new Score();
        this.menu = new Menu();
        this.player = new Player();
        this.enemyLinkedList = new LinkedList<>();
        this.keyboard = new Keyboard(this);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);
        addPlayerEvents();
    }

    public void init() throws InterruptedException {

        canvasSize.setColor(Color.BLACK);
        canvasSize.fill();

        background.load("resources/Stars Small_1v02.png");
        background.draw();

        this.planet = new Picture(40, 30, "resources/planet.png");
        this.planet.draw();

        createEnemy();

        menu.init();

        while (true) {
            Thread.sleep(100);
            if (hasStarted) {
                try {
                    menu.hideMenu();
                    start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void start() throws InterruptedException {

        player.init();
        score.init();

        this.cDetector = new CollisionDetector(player);

        while (!enemyLinkedList.getLast().isDestroyed()) {
            Thread.sleep(GameConfig.THREAD_DELAY);
            moveEnemy();
        }
    }

    public void createEnemy() {

        for (int i = 0; i < GameConfig.NUMBER_ENEMIES; i++) {
            enemyLinkedList.add(EnemyFactory.getNewEnemy());
        }
    }


    public void moveEnemy() {

        for (Enemy enemy : enemyLinkedList) {
            int currentI = enemyLinkedList.indexOf(enemy);

            if (currentI == 0 || enemyLinkedList.get(currentI - 1).getEnemyPicture().getY() > GameConfig.ENEMIES_DISTANCE) {
                enemy.move();

                if (cDetector.doOverlap(enemy) || enemyLinkedList.get(currentI).getEnemyPicture().getY() == (GameConfig.CANVAS_HEIGHT - GameConfig.ENEMIES_SIZE)) {
                    enemy.getEnemyPicture().delete();

                    if (enemy.isDestroyed()) {
                        enemyLinkedList.clear();
                        GameOver gameOver = new GameOver();
                        continue;
                    }

                    score.setScore(10);
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                hasStarted = true;
                break;
            case KeyboardEvent.KEY_LEFT:
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();
                break;
            default:
                System.out.println("no energy!!");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void addPlayerEvents() {

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);
    }
}

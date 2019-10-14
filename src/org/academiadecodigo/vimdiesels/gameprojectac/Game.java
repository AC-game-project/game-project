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
    private boolean lost;
    private Rectangle canvasSize;
    private Picture background;
    private Picture planet;
    private CollisionDetector cDetector;
    private Menu menu;
    private Player player;
    private LinkedList<Enemy> enemyLinkedList;
    private Keyboard keyboard;

    public Game() {

        this.lost = false;
        this.player = new Player();
        this.canvasSize = new Rectangle(GameConfig.PADDING, GameConfig.PADDING, GameConfig.CANVAS_WIDTH, GameConfig.CANVAS_HEIGHT);
        this.background = new Picture(GameConfig.PADDING, GameConfig.PADDING);

        this.keyboard = new Keyboard(this);
        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        enemyLinkedList = new LinkedList<>();
    }

    public void init() throws InterruptedException {

        canvasSize.setColor(Color.BLACK);
        canvasSize.fill();

        background.load("resources/Stars Small_1v02.png");
        background.draw();

        this.planet =  new Picture(40, 30, "resources/planet.png");
        this.planet.draw();

        //this.menu = new Menu();

        createEnemy();
    }


    public void start() throws InterruptedException {


        this.score = new Score();

        player.init();

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


    public void moveEnemy() throws InterruptedException {

        for (Enemy enemy : enemyLinkedList) {
            int currentI = enemyLinkedList.indexOf(enemy);

            if (currentI == 0 || enemyLinkedList.get(currentI - 1).getEnemyPicture().getY() > GameConfig.ENEMIES_DISTANCE) {
                enemy.move();

                if (cDetector.doOverlap(enemy) || enemyLinkedList.get(currentI).getEnemyPicture().getY() == (GameConfig.CANVAS_HEIGHT - GameConfig.ENEMIES_SIZE)) {
                    enemy.getEnemyPicture().delete();

                    if (enemy.isDestroyed()) {
                        enemyLinkedList.clear();
                        GameOver gameOver = new GameOver();
                        //continue;
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
                try {
                    menu.hideMenu();
                    start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("no energy!!");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

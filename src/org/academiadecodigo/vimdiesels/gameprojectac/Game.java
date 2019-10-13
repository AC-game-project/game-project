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
    private CollisionDetector cDetector;

    private Menu menu;

    private Player player;
    private Enemy[] enemies;
    private LinkedList<Enemy> enemyLinkedList;

    private Keyboard keyboard;

    public Game() {


        this.lost = false;
        this.enemies = new Enemy[GameConfig.NUMBER_ENEMIES];
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

        //create menu
        //this.menu = new Picture(20, 20, "resources/optionst_buttons_pressed.png");
        //menu.draw();

        this.menu = new Menu();
        menu.start();

        createEnemy();
    }


    public void start() throws InterruptedException {
        //menu.hideMenu();
        this.score = new Score();

        player.init();

        this.cDetector = new CollisionDetector(player);

        while (true) {

            Thread.sleep(5);

            moveEnemy();
        }
    }

    public Menu createMenu() {

        //inicialize a new StartMenu;
        // menu show();
        return null;
    }

    public void createEnemy() {

        for (int i = 0; i < enemies.length; i++) {

            enemyLinkedList.add(EnemyFactory.getNewEnemy());
            System.out.println(enemyLinkedList.get(i));
            enemies[i] = EnemyFactory.getNewEnemy();
        }


    }


    public void moveEnemy() throws InterruptedException {

        //when enemy passes our max y , it hides and score increseases

        for (Enemy enemy : enemyLinkedList) {
            int currentI = enemyLinkedList.indexOf(enemy);

            if (currentI == 0 || enemyLinkedList.get(currentI - 1).getEnemyPicture().getY() > GameConfig.ENEMIES_DISTANCE) {
                enemy.move();

                if (cDetector.doOverlap(enemy) || enemyLinkedList.get(currentI).getEnemyPicture().getY() == (GameConfig.CANVAS_HEIGHT - GameConfig.ENEMIES_SIZE)) {
                    enemy.getEnemyPicture().delete();
                    if (enemy.isDestroyed()) {
                        score.setScore(-10);

                        continue;
                    }
                    score.setScore(10);
                }
            }


        }
    }

    public void changeLevel() {

        //makes enemies move faster
        //creates more enemies?

    }

    public void gameOver() {

        // relate with score control
        // go back no start menu
    }

    public void gameExit() {

        // is it needed?
        //hides everything
        // maybe funny see ya later background
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:


                menu.hideMenu();
                try {
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

package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.EnemyFactory;

public class Game {

    private Score score;

    private boolean lost;

    private Rectangle canvasSize;
    private Picture background;
    private CollisionDetector cDetector;

    private Menu menu;
    private Player player;
    private Enemy[] enemies;

    public Game() {


        this.lost = false;
        this.enemies = new Enemy[GameConfig.NUMBER_ENEMIES];
        this.player = new Player();
        this.canvasSize = new Rectangle(GameConfig.PADDING, GameConfig.PADDING, GameConfig.CANVAS_WIDTH, GameConfig.CANVAS_HEIGHT);
        this.background = new Picture(GameConfig.PADDING, GameConfig.PADDING);

    }

    public void init() throws InterruptedException {

        canvasSize.setColor(Color.BLACK);
        canvasSize.fill();

        //create menu
        this.menu = new Menu(this);

        menu.start();

        //this.start();
        /*if(menu.isSpaceStart()) {
            this.start();
        }*/
    }


    public void start() throws InterruptedException {

        System.out.println("here");
        menu.hideMenu();

        canvasSize.setColor(Color.BLACK);
        canvasSize.fill();
        background.load("resources/Stars Small_1v02.png");
        background.draw();

        System.out.println("background");
        this.score = new Score();


        player.init();
        System.out.println("player;");

        this.cDetector = new CollisionDetector(player);

        createEnemy();

        while (true) {

            Thread.sleep(GameConfig.THREAD_DELAY);
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

            enemies[i] = EnemyFactory.getNewEnemy();
        }
    }


    public void moveEnemy() {

        //when enemy passes our max y , it hides and score increseases
        for (int j = 0; j < enemies.length; j++) {

            if (j == 0 || enemies[j - 1].getEnemyPicture().getY() > GameConfig.ENEMIES_DISTANCE) {
                    enemies[j].move(this.score);
                if (cDetector.doOverlap(enemies[j]) || enemies[j].getEnemyPicture().getY() == (GameConfig.CANVAS_HEIGHT - GameConfig.ENEMIES_SIZE)) {

                        enemies[j].setDestroyed();
                }

            }

            /*if (enemies[j - 1].getEnemyPicture().getY() > GameConfig.ENEMIES_DISTANCE) {
                enemies[j].move(this.score);
                if (cDetector.doOverlap(enemies[j])) {
                    enemies[j].setDestroyed();
                }


            }*/
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
}

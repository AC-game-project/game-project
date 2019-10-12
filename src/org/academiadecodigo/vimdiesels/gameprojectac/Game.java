package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.EnemyFactory;

public class Game {

    private int score;

    private boolean lost;

    private Rectangle canvasSize;
    private Picture background;
    private CollisionDetector cDetector;

    private Menu menu;
    private Player player;
    private Enemy[] enemies;

    public Game() {

        this.score = 0;
        this.lost = false;
        this.enemies = new Enemy[GameConfig.NUMBER_ENEMIES];
        this.player = new Player();
        this.canvasSize = new Rectangle(GameConfig.PADDING, GameConfig.PADDING, GameConfig.CANVAS_WIDTH, GameConfig.CANVAS_HEIGHT);
        this.background = new Picture(GameConfig.PADDING, GameConfig.PADDING);

    }

    public void init() {

        canvasSize.setColor(Color.BLACK);
        canvasSize.fill();

        //create menu
        // menu = new Menu();
        // menu.start();
    }


    public void start() throws InterruptedException {

        canvasSize.setColor(Color.BLACK);
        canvasSize.fill();
        background.load("resources/Stars Small_1v02.png");
        background.draw();

        player.init();

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

    public void createEnemy() throws InterruptedException {

        for (int i = 0; i < enemies.length; i++) {

            enemies[i] = EnemyFactory.getNewEnemy();
        }
    }


    public void moveEnemy() {

        //when enemy passes our max y , it hides and score increseases
        for (int j = 0; j < enemies.length; j++) {

            if(j == 0){
                enemies[j].move();
                if (cDetector.doOverlap(enemies[j]) || enemies[j].getEnemyPicture().getY() > (GameConfig.CANVAS_HEIGHT - GameConfig.ENEMIES_SIZE - GameConfig.PADDING)) {
                    enemies[j].getEnemyPicture().delete();
                }

            } else {
                if(enemies[j - 1].getEnemyPicture().getY()  > GameConfig.ENEMIES_DISTANCE){
                    enemies[j].move();
                    if (cDetector.doOverlap(enemies[j]) || enemies[j].getEnemyPicture().getY() > (GameConfig.CANVAS_HEIGHT - GameConfig.ENEMIES_SIZE - GameConfig.PADDING)) {
                        enemies[j].getEnemyPicture().delete();
                    }
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
}

package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.Enemy;
import org.academiadecodigo.vimdiesels.gameprojectac.enemy.EnemyFactory;

public class Game {

    private static final double PADDING = 10;
    private int score;

    private boolean lost;

    private Rectangle canvasSize;
    private Picture background;
    private Position canvasPosition;

    private Menu menu;
    private Player player;
    private Enemy[] enemies;

    private int numEnemies = 30;
    private int count = 0;
    private int i = 0;

    public Game() {

        this.score = 0;
        this.lost = false;
        this.enemies = new Enemy[numEnemies];
        this.player = new Player();
        this.canvasSize = new Rectangle(PADDING, PADDING, 600, 900);
        this.background = new Picture(PADDING, PADDING, "resources/Stars Small_1v02.png");

    }

    public void init() {

        canvasSize.setColor(Color.BLACK);
        canvasSize.fill();
        this.canvasPosition = new Position(canvasSize);
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


        //iniciate enemies
        createEnemy();

        while (true) {

            System.out.println("hello");
            Thread.sleep(5);
            moveEnemy();

        }
    }

    public Menu createMenu() {

        //inicialize a new StartMenu;
        // menu show();
        return null;
    }

    public void createEnemy() throws InterruptedException {

        //moveEnemy( EnemyFactory.getNewEnemy());
        for (int i = 0; i < enemies.length; i++) {

            enemies[i] = EnemyFactory.getNewEnemy();
            System.out.println(enemies[i]);
        }

        /*enemies[i] = EnemyFactory.getNewEnemy();
        i++;*/


    }


    public void moveEnemy() throws InterruptedException {


        //when enemy passes our max y , it hides and score increseases
        System.out.println(enemies.length);
        for (int j = 0; j < enemies.length; j++) {
            // enemies[j].move();

            if(j == 0){
                enemies[j].move();
            } else {
                if(enemies[j - 1].getEnemyPicture().getY()  > 30){
                    enemies[j].move();
                }
            }

            if (enemies[j].getEnemyPicture().getY() > 840) {
                enemies[j].getEnemyPicture().delete();
                //i--;
            }
            count++;
            if (count == 100) {
                count = 0;
                //createEnemy();
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

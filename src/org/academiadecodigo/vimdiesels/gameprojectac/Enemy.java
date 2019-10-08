package org.academiadecodigo.vimdiesels.gameprojectac;

public class Enemy {

    private boolean destroyed;
    private Position pos;
    public Enemy () {
    }
    public void move() {
        //method to move down the enemy or asteroid
        //accelerate(currentDirection);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void hit () {
        destroyed = true;
        return;
    }

}

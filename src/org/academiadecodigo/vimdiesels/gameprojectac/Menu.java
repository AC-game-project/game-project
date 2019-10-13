package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    private Picture splashScreen;

    public Menu() {

        this.splashScreen = new Picture((GameConfig.CANVAS_WIDTH / 2) - 156, (GameConfig.CANVAS_HEIGHT / 2) - 201, "resources/splash-screen.png");
        splashScreen.draw();
    }

    public void hideMenu() {
        splashScreen.delete();
    }
}



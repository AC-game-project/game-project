package org.academiadecodigo.vimdiesels.gameprojectac;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    private Picture splashScreen;
    private Picture enterText;

    public void init() {

        this.splashScreen = new Picture((GameConfig.CANVAS_WIDTH / 2) - 156, (GameConfig.CANVAS_HEIGHT / 2) - 201, "resources/splash-screen.png");
        splashScreen.draw();

        this.enterText = new Picture((GameConfig.CANVAS_WIDTH / 2) - 130, GameConfig.CANVAS_HEIGHT - 150, "resources/spacebar.png");
        enterText.draw();
    }

    public void hideMenu() {

        splashScreen.delete();
        enterText.delete();
    }
}



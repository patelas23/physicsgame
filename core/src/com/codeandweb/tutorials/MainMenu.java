package com.codeandweb.tutorials;

import com.badlogic.gdx.Screen;

public class MainMenu implements Screen {
    PhysicsGame game;

    public MainMenu(PhysicsGame game) {
        this.game = game;
    }

    public void render(float delta) {

    }

    public void resize(int width, int height) {

    }

    public void show() {
        //called when this screen is set as
        //the screen with game.setScreen
    }

    public void hide() {
    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {
        //never called automatically
    }

}

package com.codeandweb.tutorials;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import javax.xml.soap.Text;


public class MainMenuScreen implements Screen {
    PhysicsGame game;
    TextureAtlas textureAtlas;

    public MainMenuScreen(PhysicsGame game) {
        this.game = game;
    }

    public void render(float delta) {
        textureAtlas = new TextureAtlas("sprites.txt");
        textureAtlas.createSprite("playButton.png");
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
        textureAtlas.dispose();
    }

}

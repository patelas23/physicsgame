package com.codeandweb.tutorials;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.codeandweb.physicseditor.PhysicsShapeCache;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class PhysicsGame extends Game {

    static final float STEP_TIME = 1f / 60f;
    static final int VELOCITY_ITERATIONS = 6;
    static final int POSITION_ITERATIONS = 2;
    static final float SCALE = 0.05f;

    static TextureAtlas textureAtlasButtons;

    private BitmapFont font;
    private Texture texture;
    private Sprite sprite;

    Box2DDebugRenderer debugRenderer;

    final HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();

    World world;

    float accumulator = 0;
    PhysicsShapeCache physicsBodies;
    OrthographicCamera camera;
    ExtendViewport viewport;
    TextureAtlas textureAtlas;
    Body ground;
	SpriteBatch batch;


	@Override
	public void create () {
	    MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
	    
        setScreen(mainMenuScreen);

	}

	private void stepWorld() {
	    float delta = Gdx.graphics.getDeltaTime();

	    accumulator += Math.min(delta, 0.25f);

	    if (accumulator >= STEP_TIME) {
	        accumulator -= STEP_TIME;
        }

        world.step(STEP_TIME, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

	@Override
	public void render () {
	    stepWorld();

		Gdx.gl.glClearColor(0.57f, 0.77f, 0.85f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {

        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

        }

		batch.begin();

        font.draw(batch, "Hello World", 15, 25);

		batch.end();



        debugRenderer.render(world, camera.combined);

    }

	@Override
    public void resize(int width, int height) {
	    viewport.update(width, height, true);

	    batch.setProjectionMatrix(camera.combined);

	    createGround();
    }
	
	@Override
	public void dispose () {
	    textureAtlas.dispose();
		world.dispose();
		sprites.clear();
		font.dispose();

		debugRenderer.dispose();
	}



    private void createGround() {
	    if (ground != null) world.destroyBody(ground);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.friction = 1;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(camera.viewportWidth, 1);

        fixtureDef.shape = shape;

        ground = world.createBody(bodyDef);
        ground.createFixture(fixtureDef);
        ground.setTransform(0, 0, 0);

        shape.dispose();
    }


}

package com.badlogic.tankgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class PauseGameScreen implements Screen {
    final TankGame game;
    Texture pausedgames;
    OrthographicCamera camera;
    Rectangle pausegames;
    public PauseGameScreen(final TankGame game)
    {
        this.game=game;
        pausedgames=new Texture(Gdx.files.internal("PAUSEMENU.png"));
        camera=new OrthographicCamera();
        camera.setToOrtho(false,1280,720);
        pausegames= new Rectangle(0,0,1280,720);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(pausedgames,pausegames.x,pausegames.y,pausegames.width,pausegames.height);
        game.batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.R)||Gdx.input.isKeyPressed(Input.Keys.S) ){
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.M)){
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

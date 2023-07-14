package com.badlogic.tankgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class LosingScreen implements Screen {
    final TankGame game;
    Texture loseScr;
    OrthographicCamera camera;
    Rectangle losegames;
    public LosingScreen(final TankGame game)
    {
        this.game=game;
        loseScr=new Texture(Gdx.files.internal("losingscreen.png"));
        camera=new OrthographicCamera();
        camera.setToOrtho(false,1280,720);
        losegames=new Rectangle(0,0,1280,720);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(loseScr,losegames.x,losegames.y,losegames.width,losegames.height);
        game.batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.R)){
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

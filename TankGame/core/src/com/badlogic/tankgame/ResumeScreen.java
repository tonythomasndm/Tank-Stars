package com.badlogic.tankgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class ResumeScreen implements Screen {
    final TankGame game;
    Texture savedgames;
    OrthographicCamera camera;
    Rectangle savegames;
    public ResumeScreen(final TankGame game)
    {
        this.game=game;
        savedgames=new Texture(Gdx.files.internal("SAVED GAMES.png"));
        camera=new OrthographicCamera();
        camera.setToOrtho(false,1280,720);
        savegames= new Rectangle(0,0,1280,720);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(savedgames,savegames.x,savegames.y,savegames.width,savegames.height);
        game.batch.end();
        if(Gdx.input.isTouched()){
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if( Gdx.input.isKeyPressed(Input.Keys.B) ) {
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

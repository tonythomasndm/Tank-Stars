package com.badlogic.tankgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
public class ChooseTankScreen implements Screen{
    final TankGame game;
    OrthographicCamera camera;
    Texture chooseTank;
    Rectangle choosetank;
    public ChooseTankScreen(final TankGame game)
    {
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false,1280,720);
        chooseTank=new Texture(Gdx.files.internal("choosetankfinal.png"));
        choosetank=new Rectangle(0,0,1280,720);
    }
    @Override
    public void render(float delta){
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(chooseTank,choosetank.x,choosetank.y,choosetank.width,choosetank.height);
        game.batch.end();
        if(Gdx.input.isTouched())
        {
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if( Gdx.input.isKeyPressed(Input.Keys.F) ){
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if( Gdx.input.isKeyPressed(Input.Keys.S) ){
            game.setScreen(new GameScreen2(game));
            dispose();
        }
        if( Gdx.input.isKeyPressed(Input.Keys.T) ){
            game.setScreen(new GameScreen3(game));
            dispose();
        }
        if( Gdx.input.isKeyPressed(Input.Keys.B) ) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
    }
    @Override
    public void resize(int width, int height){

    }
    @Override
    public void show(){

    }
    @Override
    public void hide() {

    }
    @Override
    public void pause(){

    }
    @Override
    public void resume(){

    }
    @Override
    public void dispose(){
        chooseTank.dispose();
    }
}
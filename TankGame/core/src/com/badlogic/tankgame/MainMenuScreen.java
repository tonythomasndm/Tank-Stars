package com.badlogic.tankgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class MainMenuScreen implements Screen {
    final TankGame game;
    OrthographicCamera camera;
    Texture backgroundImage;
    Texture newGameButton;
    Texture resumeGameButton;
    Texture exitGameButton;
    Rectangle background;
    Rectangle newGame, resumeGame, exitGame;
    public MainMenuScreen(final TankGame game){
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,1280,720);
        backgroundImage = new Texture(Gdx.files.internal("TANK STARS.png"));
        newGameButton = new Texture(Gdx.files.internal("new.png"));
        resumeGameButton = new Texture(Gdx.files.internal("resu.png"));
        exitGameButton = new Texture(Gdx.files.internal("EXIT.png"));
        background=new Rectangle();
        background.x=0;
        background.y=0;
        background.width=1280;
        background.height=720;
        newGame= new Rectangle(640-240/2,290,240,80);
        resumeGame =new Rectangle(640-240/2,180,240,80);
        exitGame = new Rectangle(640-240/2,70,240,80);
    }
    @Override
    public void render(float delta){
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(backgroundImage,background.x,background.y,background.width,background.height);
        game.batch.draw(newGameButton,newGame.x,newGame.y,newGame.width,newGame.height);
        game.batch.draw(resumeGameButton,resumeGame.x,resumeGame.y,resumeGame.width,resumeGame.height);
        game.batch.draw(exitGameButton,exitGame.x,exitGame.y,exitGame.width,exitGame.height);
        game.batch.end();
        if(Gdx.input.isKeyPressed(Input.Keys.N) || (Gdx.input.isKeyPressed(Input.Keys.R)) || (Gdx.input.isKeyPressed(Input.Keys.E))){
            if( Gdx.input.isKeyPressed(Input.Keys.N) ) {
                game.setScreen(new ChooseTankScreen(game));
                dispose();
            }
            if( Gdx.input.isKeyPressed(Input.Keys.R) ) {
                game.setScreen(new ResumeScreen(game));
                dispose();
            }
            if( Gdx.input.isKeyPressed(Input.Keys.E) ) {
                game.setScreen(new ExitGameScreen(game));
                dispose();
            }
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
    public void dispose () {
        backgroundImage.dispose();
        newGameButton.dispose();
        resumeGameButton.dispose();
        exitGameButton.dispose();
    }
}
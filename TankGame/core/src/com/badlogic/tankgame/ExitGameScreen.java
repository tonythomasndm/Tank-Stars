package com.badlogic.tankgame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class ExitGameScreen implements Screen{
    final TankGame game;
    OrthographicCamera camera;
    Texture backgroundImage;
    Rectangle backgroundMsg;
    public ExitGameScreen(final TankGame game)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,1280,720);
        backgroundImage = new Texture(Gdx.files.internal("thnku.png"));
        backgroundMsg=new Rectangle(0,0,1280,720);

    }
    @Override
    public void render(float delta){
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(backgroundImage,backgroundMsg.x,backgroundMsg.y,backgroundMsg.width,backgroundMsg.height);
        game.batch.end();
        if(Gdx.input.isTouched()){
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
    public void dispose (){
        backgroundImage.dispose();
    }
}
package com.badlogic.tankgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import org.w3c.dom.css.Rect;

import java.util.Iterator;

public class GameScreen3 extends GameScreen implements Screen  {
    final TankGame game;
    Texture gamescr;
    OrthographicCamera camera;
    Rectangle gamemain, Tank1, Tank2, Fire,Fire2;
    Texture tank1, tank2, fire,fire2;
    int dir1, dir2;
    int shoot,rende,rende2,fuel1,fuel2;
    int tank1score,tank2score;
    Array<Rectangle> shooting;

    public GameScreen3(final TankGame game) {
        super(game);
        this.game = game;
        gamescr = new Texture(Gdx.files.internal("FUEL.png"));
        tank1 = new Texture(Gdx.files.internal("Tank3.png"));
        tank2 = new Texture(Gdx.files.internal("revtank2.png"));
        fire = new Texture(Gdx.files.internal("fire1.png"));
        fire2 = new Texture(Gdx.files.internal("fire2.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        gamemain = new Rectangle(0, 0, 1280, 720);
        Tank1 = new Rectangle(100, 261, 120, 60);
        Tank2 = new Rectangle(1080, 261, 160, 57);
        shooting=new Array<Rectangle>();
        dir1 = 0;
        dir2 = 0;
        shoot = 0;
        rende=0;rende2=0;
        tank1score=1000;
        tank2score=1000;
        fuel1=500;
        fuel2=500;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(gamescr, gamemain.x, gamemain.y, gamemain.width, gamemain.height);
        game.font.draw(game.batch,"Tank1 Score :"+tank1score,10,720);
        game.font.draw(game.batch,"Tank1 Fuel Ration :"+fuel1,10,680);
        game.font.draw(game.batch,"Tank2 Score :"+tank2score,1180-100,720);
        game.font.draw(game.batch,"Tank2 Fuel Ration :"+fuel2,1180-100,680);
        game.batch.draw(tank1, Tank1.x, Tank1.y, Tank1.width, Tank1.height);
        game.batch.draw(tank2, Tank2.x, Tank2.y, Tank2.width, Tank2.height);
        if(shoot==0) {
            Fire = new Rectangle(Tank1.x + Tank1.width + 1, Tank1.y + Tank2.height / 2, 60, 40);
            Fire2= new Rectangle(Tank2.x -50, Tank1.y + Tank2.height / 2, 60, 40);
        }
        if(shoot==1 && dir1==1){
            game.batch.draw(fire,Fire.x,Fire.y,Fire.width,Fire.height);
            rende=1;
            fuel1=500;
            fuel2=500;
        }
        if(shoot==1 && dir2==1){
            game.batch.draw(fire2,Fire2.x,Fire2.y,Fire2.width,Fire2.height);
            rende2=1;
            fuel1=500;
            fuel2=500;
        }

        game.batch.end();
        if (Gdx.input.isKeyPressed(Input.Keys.F)) {
            if(fuel1>0){
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    Tank1.x -= 150 * Gdx.graphics.getDeltaTime();
                    fuel1 -= 150 * Gdx.graphics.getDeltaTime();
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    Tank1.x += 150 * Gdx.graphics.getDeltaTime();
                    fuel1 -= 150 * Gdx.graphics.getDeltaTime();
                }
            }
//            if (Gdx.input.isKeyPressed(Input.Keys.UP) && dir1 == 0) {
//                tank1 = new Texture(Gdx.files.internal("revTank3.png"));
//                dir1 = 1;
//            }
//            if (Gdx.input.isKeyPressed(Input.Keys.UP) && dir1 == 1) {
//                tank1 = new Texture(Gdx.files.internal("Tank3.png"));
//                dir1 = 0;
//            }
            if(Tank1.x<0)
            {
                Tank1.x=0;
            }
            if(Tank1.x>1280-Tank1.width){
                Tank1.x=1280-Tank1.width;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
                shoot = 1;
                dir1=1;
                fuel1=500;
            }
        }

        if(rende==1 && Gdx.input.isTouched()) {
            Fire.x +=100 * Gdx.graphics.getDeltaTime();
                if(Tank1.x<=Tank2.x)
                {
                    tank1score+=20;
                    tank2score-=200;
                }
                if(Fire.x <= 1280 - Fire.width)
                {
                shoot=0;
                rende=0;
                dir1=0;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.O)) {
            if(fuel2>0){
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    Tank2.x -= 150 * Gdx.graphics.getDeltaTime();
                    fuel2 -= 150 * Gdx.graphics.getDeltaTime();
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    Tank2.x += 150 * Gdx.graphics.getDeltaTime();
                    fuel2 -= 150 * Gdx.graphics.getDeltaTime();
                }
            }
//                if (Gdx.input.isKeyPressed(Input.Keys.T)) {
//                    tank2 = new Texture(Gdx.files.internal("Tank2.png"));
//                    dir2 = 1;
//                }
//                if (Gdx.input.isKeyPressed(Input.Keys.T)) {
//                    tank2 = new Texture(Gdx.files.internal("revTank2.png"));
//                    dir2 = 0;
//                }
                if(Tank2.x<0)
                {
                    Tank2.x=0;
                }
                if(Tank2.x>1280-Tank2.width){
                    Tank2.x=1280-Tank2.width;
                }
            if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
                shoot = 1;
                dir2=1;
                fuel2=0;
            }
        }

        if(rende2==1 && Gdx.input.isTouched()) {
            Fire2.x -=100 * Gdx.graphics.getDeltaTime();
            if(Tank1.x<=Tank2.x)
            {
                tank2score+=20;
                tank1score-=200;
            }
            if(true)
            {
                shoot=0;
                rende2=0;
                dir2=0;
            }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.P)) {
                game.setScreen(new PauseGameScreen(game));
                dispose();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.L) || tank2score<=0 || tank1score<=0) {
                game.setScreen(new LosingScreen(game));
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

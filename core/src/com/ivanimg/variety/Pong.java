package com.ivanimg.variety;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pong implements Screen {
    VarietyGame game;
    public SpriteBatch batch;
	Texture img, player, rival, pelota;
    int ancho, largo, puntP=0, puntR=0;
    double posX, posY, posX2, posY2, posPX, posPY;
    boolean inicio = true, izq, arriba;

    public Pong (VarietyGame game) {
        Gdx.app.error("PongG", "Entra en pong");
        batch = new SpriteBatch();
        //img = new Texture("badlogic.jpg");
        this.game = game;
        player = new Texture("play_button_active.png");
        rival = new Texture("play_button_inactive.png");
        pelota = new Texture("pelota.jpg");
        ancho = Gdx.graphics.getWidth();
        largo = Gdx.graphics.getHeight();


        posX = ancho/100;
        posX2 = ancho-(rival.getWidth()+ancho/100);
        posY = largo*0.5;
        posY2 = largo*0.5;
        posPX = ancho*0.5;
        posPY = largo*0.5;

    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Gdx.app.error("PongG", "Antes de dibujar");

        game.batch.begin();
        //batch.draw(img, 0, 0);
        game.batch.draw(player, ((int) posX), ((int) posY), player.getWidth() , ancho/10 );
        game.batch.draw(rival, ((int) posX2), ((int) posY2), rival.getWidth() , ancho/10);
        game.batch.draw(pelota, ((int) posPX), ((int) posPY), largo/20 , ancho/20 );
        /*if((Gdx.input.getX() > (int) posX) && Gdx.input.getX() < ((int) posX+largo/10) && (Gdx.input.getY() > (int) posY && Gdx.input.getY() < ((int) posY+ancho/10))){
            posX++;
        }*/
        Gdx.input.setInputProcessor(new InputAdapter(){
        //Gdx.app.error("PongG", "input processor");

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                //while (posY!=screenY){
                    if(posY>screenY){
                        posY=screenY+(player.getWidth()/2);
                    } else {
                        posY=screenY-(player.getWidth()/2);
                    }
                //}
                Gdx.app.error("PongG", "Dentro del touch "+screenX+" "+screenY+" "+posX);
                return true;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                Gdx.app.error("PongG2", "Dentro del touch "+screenX+" "+screenY+" "+posX);
                if(posY>screenY){
                    posY=screenY+(player.getWidth()/2);
                } else {
                    posY=screenY-(player.getWidth()/2);
                }
                return true;
            }

        });

        if(inicio){
            Gdx.app.error("PongG", "Math.random()*2 "+Math.random()*2);
            if(((int)(Math.random()*2)==0)){
                izq=true;
                posPX--;
            } else {
                izq=false;
                posPX++;
            }
            if(((int)(Math.random()*2)==0)){
                arriba=true;
                posPY++;
            } else {
                arriba=false;
                posPY--;
            }
            inicio = false;
        } else {
            if(izq){
                posPX-=10;
            } else {
                posPX+=10;
            }
            if(arriba){
                posPY+=10;
            } else {
                posPY-=10;
            }
        }
        if(posPY+(pelota.getWidth()/2) >= posY2+(rival.getWidth()/2)){
            posY2+=5;
        } else {
            posY2-=5;
        }
        if(/*(posPX <= 0 || (posPX+ancho/20) >= ancho) ||*/choque()){
            izq = !izq;
        }
        if(posPY <= 0 || (posPY+largo/20) >= largo){
            arriba = !arriba;
        }
        if(posPX <= 0 || (posPX+ancho/20) >= ancho){
            posX = ancho/100;
            posX2 = ancho-(rival.getWidth()+ancho/100);
            posY = largo*0.5;
            posY2 = largo*0.5;
            posPX = ancho*0.5;
            posPX = ancho*0.5;
            posPY = largo*0.5;
            if(izq){
                puntP++;
                Gdx.app.error("PongG", "Punto para el jugador"+puntP);
            } else {
                puntR++;
                Gdx.app.error("PongG", "Punto para el rival"+puntR);
            }
            inicio=true;
        }
        game.batch.end();
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

    boolean choque(){
        if((posPX < posX+player.getWidth()  &&((((posPY+pelota.getHeight()) > posY) && (posPY+pelota.getHeight() < (posY+player.getHeight()))) || ((posPY < posY+player.getHeight()) && (posPY > posY))))
         ||(posPX+pelota.getWidth() > posX2 && ((((posPY+pelota.getWidth()+pelota.getHeight()) > posY2) && ((posPY+pelota.getWidth()) < posY2+player.getHeight())) || ((posPY+pelota.getWidth() < posY2+player.getHeight()) && (posPY+pelota.getWidth() > posY2))))
        ){
            Gdx.app.error("PongG", "Choque"+posPX+"posX+player.getWidth()"+posX+player.getWidth());
            return true;
        } else {
            return false;
        }
    }
}

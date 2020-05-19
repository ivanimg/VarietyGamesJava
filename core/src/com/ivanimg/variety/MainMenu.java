package com.ivanimg.variety;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MainMenu implements Screen {

    private BitmapFont font;
    private TextButton exitButton;
    private Stage stage;

    VarietyGame game;
    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;
    int ancho;
    int largo;

    public MainMenu (VarietyGame game) {

        stage= new Stage();
        Gdx.input.setInputProcessor(stage);

        this.game = game;
        playButtonActive = new Texture("play_button_active.png");
        playButtonInactive = new Texture("play_button_inactive.png");
        exitButtonActive = new Texture("exit_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");

        /*
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.fontColor = Color.BLACK;

        Gdx.app.error("ancho2", String.valueOf(ancho)+"-"+Gdx.files.getLocalStoragePath());
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
        buttonStyle.font =font;
        exitButton = new TextButton("Exit", buttonStyle);
        exitButton.addListener(new ClickListener() {
        });
        stage.addActor(exitButton);*/

        ancho = Gdx.graphics.getWidth();
        largo = Gdx.graphics.getHeight();
        Gdx.app.error("ancho2", String.valueOf(ancho)+"-"+Gdx.files.getLocalStoragePath());
        Gdx.app.error("largo", String.valueOf(largo));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        double posX = ancho*0.2;
        double posX2 = ancho*0.5;
        double posY = largo*0.5;

        //Gdx.gl.glClearColor(100, 100, 100, 1);
        //Gdx.gl.glClearColor(50, 50, 50, 1);
        //Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        //game.batch.draw(playButtonActive, 0, 0, stage.getWidth(), stage.getHeight());

        if((Gdx.input.getX() > (int) posX) && Gdx.input.getX() < ((int) posX+largo/10) && (Gdx.input.getY() > (int) posY && Gdx.input.getY() < ((int) posY+ancho/10))){
            //game.batch.draw(playButtonInactive, ((int) posX), ((int) posY), ancho / 10, largo / 10);
            game.batch.draw(playButtonActive, ((int) posX), ((int) posY), playButtonActive.getWidth(), playButtonActive.getHeight());
            Gdx.app.error("Click", String.valueOf((Gdx.input.getX())));
            if (Gdx.input.isTouched()){
                Gdx.app.error("Pong", String.valueOf(Gdx.input.getX()));
                this.dispose();
                game.setScreen(new Pong(game));
            }
        } else {
            //Gdx.app.error("No Pong", String.valueOf((Gdx.input.getX())));
            game.batch.draw(playButtonInactive, ((int) posX), ((int) posY), ancho/10 , largo / 10);

        }



        /*
        Gdx.app.error("ancho2/", String.valueOf(((int) posX)));
        Gdx.app.error("ancho2/", String.valueOf(((int) posX2)));
        Gdx.app.error("largo2", String.valueOf(((int) posY)));
        Gdx.app.error("Gdx.input.getX()", String.valueOf(((int) Gdx.input.getX())));
        Gdx.app.error("Gdx.input.getY()", String.valueOf(((int) Gdx.input.getY())));*/

        //game.batch.draw(exitButtonInactive,200,200,0 ,0 ,100,100,1,1,90,0,0,0,0,true,false);

        if((Gdx.input.getX() > (int) posX2) && Gdx.input.getX() < ((int) posX2+largo/10) && (Gdx.input.getY() > (int) posY && Gdx.input.getY() < ((int) posY+ancho/10))){
            //game.batch.draw(playButtonInactive, ((int) posX), ((int) posY), ancho / 10, largo / 10);
            game.batch.draw(exitButtonActive, ((int) posX2), ((int) posY), ancho / 10, largo / 10);
            if (Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        } else {
            game.batch.draw(exitButtonInactive, ((int) posX2), ((int) posY), ancho/10 , largo / 10);
        }
        //game.batch.draw(exitButtonInactive, ((int) posX2), ((int) posY),ancho/10,largo/10);

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
}
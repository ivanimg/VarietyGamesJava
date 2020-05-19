package com.ivanimg.variety

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.TextButton


class MainMenuK: Screen {

    val font: BitmapFont? = null
    val exitButton: TextButton? = null
    var stage: Stage? = null

    val game: VarietyGame? = null
    var playButtonActive: Texture? = null
    var playButtonInactive: Texture? = null
    var exitButtonActive: Texture? = null
    var exitButtonInactive: Texture? = null
    var ancho = 0
    var largo = 0

    fun MainMenu(game: VarietyGame?) {
        stage = Stage()
        Gdx.input.inputProcessor = stage
        //this.game = game
        playButtonActive = Texture("play_button_active.png")
        playButtonInactive = Texture("play_button_inactive.png")
        exitButtonActive = Texture("exit_button_active.png")
        exitButtonInactive = Texture("exit_button_inactive.png")
        /*
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.fontColor = Color.BLACK;

        Gdx.app.error("ancho2", String.valueOf(ancho)+"-"+Gdx.files.getLocalStoragePath());
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
        buttonStyle.font =font;
        exitButton = new TextButton("Exit", buttonStyle);
        exitButton.addListener(new ClickListener() {
        });
        stage.addActor(exitButton);*/ancho = Gdx.graphics.width
        largo = Gdx.graphics.height
        Gdx.app.error("ancho2", ancho.toString() + "-" + Gdx.files.localStoragePath)
        Gdx.app.error("largo", largo.toString())
    }

    override fun show() {}

    override fun render(delta: Float) {
        val posX = ancho * 0.2
        val posX2 = ancho * 0.5
        val posY = largo * 0.5
        //Gdx.gl.glClearColor(100, 100, 100, 1);
        //Gdx.gl.glClearColor(50, 50, 50, 1);
        //Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        game!!.batch.begin()
        //game.batch.draw(playButtonActive, 0, 0, stage.getWidth(), stage.getHeight());
        if (Gdx.input.x > posX && Gdx.input.x > posX + largo / 10 && Gdx.input.y > posY && Gdx.input.y < posY + ancho / 10) { //game.batch.draw(playButtonInactive, ((int) posX), ((int) posY), ancho / 10, largo / 10);
            game.batch.draw(playButtonInactive, posX.toInt().toFloat(), posY.toInt().toFloat(), ancho / 10.toFloat(), largo / 10.toFloat())
        } else {
            game.batch.draw(playButtonActive, posX.toInt().toFloat(), posY.toInt().toFloat(), ancho / 10.toFloat(), largo / 10.toFloat())
        }
        /*
        Gdx.app.error("ancho2/", String.valueOf(((int) posX)));
        Gdx.app.error("ancho2/", String.valueOf(((int) posX2)));
        Gdx.app.error("largo2", String.valueOf(((int) posY)));*/Gdx.app.error("ancho2/", posX.toInt().toString())
        Gdx.app.error("Gdx.input.getX()", Gdx.input.x.toString())
        Gdx.app.error("Gdx.input.getY()", Gdx.input.y.toString())
        Gdx.app.error("largo2", posY.toInt().toString())
        //game.batch.draw(exitButtonInactive,200,200,0 ,0 ,100,100,1,1,90,0,0,0,0,true,false);
        game.batch.draw(exitButtonInactive, posX2.toInt().toFloat(), posY.toInt().toFloat(), ancho / 10.toFloat(), largo / 10.toFloat())
        game.batch.end()
    }

    override fun resize(width: Int, height: Int) {}

    override fun pause() {}

    override fun resume() {}

    override fun hide() {}

    override fun dispose() {}

}
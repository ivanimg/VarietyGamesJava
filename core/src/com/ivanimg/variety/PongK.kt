package com.ivanimg.variety

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class PongK: Screen {
    var batch: SpriteBatch? = null
    var img: Texture? = Texture("badlogic.jpg");
    var ancho: Int = Gdx.graphics.getWidth()
    var largo: Int = Gdx.graphics.getHeight()

    override fun show() {}

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch?.begin();
        batch?.draw(img, 0f, 0f);
        batch?.end();
    }

    override fun hide() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resize(width: Int, height: Int) {
        this.resize(ancho, largo);
        //super().
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

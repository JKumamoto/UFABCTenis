package br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Scaling;

public class SimpleMenu implements Screen {

    protected Stage ui;
    protected Skin skin;
    private TextureRegion background;

    public SimpleMenu(SimpleSkin simpleSkin){
        skin=simpleSkin.getSkin();
        ui=new Stage();
        Gdx.input.setInputProcessor(ui);
    }

    protected void addBackground(final String path){
        background=new TextureRegion(new Texture(Gdx.files.internal(path)));
        Image backgroundImage=new Image(background);
        backgroundImage.setScaling(Scaling.fill);
        ui.addActor(backgroundImage);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        ui.act(Math.min(delta, 1/30f));
        ui.draw();
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
    public void dispose(){
        background.getTexture().dispose();
        ui.dispose();
        skin.dispose();
    }

}

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

    protected Game game;
    protected Stage ui;
    protected Skin skin;
    private TextureRegion background;

    public SimpleMenu(Game game, SimpleSkin simpleSkin, String path){
        this.game=game;

        skin=simpleSkin.getSkin();
        ui=new Stage();
        Gdx.input.setInputProcessor(ui);

        background=new TextureRegion(new Texture(Gdx.files.internal(path)));
        Image backgroundImage=new Image(background);
        backgroundImage.setScaling(Scaling.fill);
        ui.addActor(backgroundImage);
    }

    public SimpleMenu(Game game, SimpleSkin simpleSkin, Color color){
        this.game=game;

        skin=simpleSkin.getSkin();
        ui=new Stage();
        Gdx.input.setInputProcessor(ui);

        Pixmap pixmap=new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        background=new TextureRegion(new Texture(pixmap));
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

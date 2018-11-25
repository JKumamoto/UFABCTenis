package br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu;

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

    private String id;
    private boolean done;
    private TextureRegion background;
    protected Stage ui;
    protected Skin skin;

    public SimpleMenu(String id, SimpleSkin simpleSkin, String path){
        this.id=id;
        setDone(false);

        skin=simpleSkin.getSkin();
        ui=new Stage();
        Gdx.input.setInputProcessor(ui);

        background=new TextureRegion(new Texture(Gdx.files.internal(path)));
        Image backgroundImage=new Image(background);
        backgroundImage.setScaling(Scaling.fill);
        ui.addActor(backgroundImage);
    }

    public SimpleMenu(String id, SimpleSkin simpleSkin, Color color){
        this.id=id;
        setDone(false);

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

    public String getId(){
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public void show() {
    }

    public void render(float delta){
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ui.act(Math.min(delta, 1/30f));
        ui.draw();
    }

    public void resize(int width, int height) {
        ui.getViewport().update(width, height, true);
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

    public void dispose(){
        ui.dispose();
        skin.dispose();
    }

}

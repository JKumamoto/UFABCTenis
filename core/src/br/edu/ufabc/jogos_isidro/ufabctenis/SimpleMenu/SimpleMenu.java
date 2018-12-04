package br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu;

import br.edu.ufabc.jogos_isidro.ufabctenis.Util.Parameters;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class SimpleMenu implements Screen {

    protected Table table;
    protected Skin skin;
    private Stage ui;

    public SimpleMenu(){
        skin=Parameters.getSimpleSkin().getSkin();
        ui=new Stage();
        Gdx.input.setInputProcessor(ui);

        table=new Table(skin);
        table.setFillParent(true);
        table.setBackground("background");
        ui.addActor(table);
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

    @Override
    public void dispose(){
        ui.dispose();
        skin.dispose();
    }

}

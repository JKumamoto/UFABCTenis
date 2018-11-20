package br.edu.ufabc.jogos_isidro.ufabctenis.Screen;

import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen {

    public abstract void update(float delta);
    public abstract void draw(float delta);
    private boolean done;
    private String id;

    public AbstractScreen(String id){
        this.id=id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getId() {
        return id;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        draw(delta);
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

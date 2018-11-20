package br.edu.ufabc.jogos_isidro.ufabctenis.Screen;

import br.edu.ufabc.jogos_isidro.ufabctenis.Model.TennisBall;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class GameScreen extends AbstractScreen{

    private ModelBatch batch;
    private Environment environment;
    private PerspectiveCamera camera;
    private CameraInputController controller;
    private TennisBall ball;

    public GameScreen(String id){
        super(id);
        batch=new ModelBatch();
        environment=new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight,0.4f,0.4f,0.4f,1));
        environment.add(new DirectionalLight().set(0.8f,0.8f,0.8f,-1f,-0.8f,-0.2f));
        camera=new PerspectiveCamera(67.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(100f,100f,100f);
        camera.lookAt(0f,0f,0f);
        camera.near=0.1f;
        camera.far=100f;
        camera.update();
        controller=new CameraInputController(camera);
        Gdx.input.setInputProcessor(controller);

        ball=new TennisBall();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,1);

        batch.begin(camera);
        batch.render(ball.getCurrent(), environment);
        batch.end();
        camera.update();
    }

}

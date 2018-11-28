package br.edu.ufabc.jogos_isidro.ufabctenis.Menu;

import br.edu.ufabc.jogos_isidro.ufabctenis.Screen.GameScreen;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleMenu;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleSkin;
import br.edu.ufabc.jogos_isidro.ufabctenis.UFABCTenis;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class StartMenu extends SimpleMenu {

    public StartMenu(final SimpleSkin simpleSkin){
        super(simpleSkin);
        addBackground("Images/start.jpg");

        final TextButton button = new TextButton("Start", skin);
        button.setHeight(button.getHeight()*2);
        button.setPosition(100, 300);
        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen("Game"));
                dispose();
            }
        });
        ui.addActor(button);

        final TextButton credits = new TextButton("Creditos", skin);
        credits.setHeight(credits.getHeight()*2);
        credits.setPosition(100, 200);
        credits.addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y){
               ((Game)Gdx.app.getApplicationListener()).setScreen(new CreditsMenu(simpleSkin));
           }
        });
        ui.addActor(credits);

        final TextButton btn = new TextButton("Exit", skin);
        btn.setHeight(btn.getHeight()*2);
        btn.setPosition(100, 100);
        btn.addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y){
               System.out.println("Saindo do jogo");
               Gdx.app.exit();
           }
        });
        ui.addActor(btn);
    }

}

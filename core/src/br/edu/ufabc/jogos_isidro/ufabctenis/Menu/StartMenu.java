package br.edu.ufabc.jogos_isidro.ufabctenis.Menu;

import br.edu.ufabc.jogos_isidro.ufabctenis.Screen.GameScreen;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleMenu;
import br.edu.ufabc.jogos_isidro.ufabctenis.Util.Parameters;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;

public class StartMenu extends SimpleMenu {

    public StartMenu(){
        super();

        table.align(Align.topLeft);
        table.padLeft(100);
        table.padTop(100);

        final Label title=new Label("UFABC Tenis", skin, "title", Color.WHITE);
        table.add(title);
        table.row();

        VerticalGroup verticalGroup=new VerticalGroup();
        verticalGroup.bottom();
        verticalGroup.left();
        table.add(verticalGroup);

        ArrayList<Container> containers=new ArrayList<Container>();

        final TextButton button = new TextButton("Start", skin);
        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Parameters.setGameScreen(new GameScreen("Game"));
                dispose();
            }
        });
        containers.add(new Container<TextButton>(button));
        containers.get(0).width(button.getWidth()+5);

        final TextButton options = new TextButton("Opções", skin);
        options.addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y){
               Parameters.setGameScreen(new OptionsMenu());
           }
        });
        containers.add(new Container<TextButton>(options));
        containers.get(1).width(options.getWidth()+5);

        final TextButton credits = new TextButton("Creditos", skin);
        credits.addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y){
               Parameters.setGameScreen(new CreditsMenu());
           }
        });
        containers.add(new Container<TextButton>(credits));
        containers.get(2).width(credits.getWidth()+5);

        final TextButton btn = new TextButton("Exit", skin);
        btn.addListener(new ClickListener(){
           public void clicked(InputEvent event, float x, float y){
               System.out.println("Saindo do jogo");
               Gdx.app.exit();
           }
        });
        containers.add(new Container<TextButton>(btn));
        containers.get(3).width(btn.getWidth()+5);

        final Label label=new Label("Linha1\n2", skin, "title", Color.CLEAR);
        verticalGroup.addActor(label);
        verticalGroup.space(100);
        for(Container c : containers){
            c.height(button.getHeight()*2);
            verticalGroup.space(10);
            verticalGroup.addActor(c);
        }

    }

}

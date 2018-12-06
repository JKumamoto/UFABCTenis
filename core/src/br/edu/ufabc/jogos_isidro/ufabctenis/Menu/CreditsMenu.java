package br.edu.ufabc.jogos_isidro.ufabctenis.Menu;

import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleMenu;
import br.edu.ufabc.jogos_isidro.ufabctenis.Util.Parameters;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

class CreditsMenu extends SimpleMenu {

    CreditsMenu(){
        super();

        table.setBackground(skin.newDrawable("default", Color.BLACK));

        ArrayList<Container> containers=new ArrayList<Container>();
        containers.add(new Container<Label>(new Label("UFABC Tenis\n\n", skin, "title", Color.WHITE)));
        containers.add(new Container<Label>(new Label("Desenvolvido por:", skin)));
        containers.add(new Container<Label>(new Label("Jefferson e Hugo", skin)));
        containers.add(new Container<Label>(new Label("Line1\n2\n", skin, "title", Color.BLACK)));

        final TextButton back=new TextButton("Voltar", skin);
        back.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                Parameters.setGameScreen(new StartMenu());
            }
        });
        containers.add(new Container<TextButton>(back));
        containers.get(containers.size()-1).width(back.getWidth()+5);
        for(Container c :  containers){
            c.height(c.getActor().getHeight()*2);
            table.add(c);
            table.row();
        }
    }
}

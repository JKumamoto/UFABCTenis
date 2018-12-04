package br.edu.ufabc.jogos_isidro.ufabctenis.Menu;

import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleMenu;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class CreditsMenu extends SimpleMenu {

    public CreditsMenu(){
        super();

        table.setBackground(skin.newDrawable("default", Color.BLACK));

        table.add(new Label("UFABC Tenis\n\n\n", skin));
        table.row();
        table.add(new Label("Desenvolvido por:\nJefferson e Hugo", skin));
    }

}

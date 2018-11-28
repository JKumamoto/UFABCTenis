package br.edu.ufabc.jogos_isidro.ufabctenis.Menu;

import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleMenu;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleSkin;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class CreditsMenu extends SimpleMenu {

    public CreditsMenu(SimpleSkin simpleSkin){
        super(simpleSkin);

        final Label label=new Label("Desenvolvido por:\nJefferson e Hugo", skin);
        label.setPosition(100, 300);
        label.setWrap(true);

        ui.addActor(label);
    }

}

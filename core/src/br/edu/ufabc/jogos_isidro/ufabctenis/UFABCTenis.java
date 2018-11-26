package br.edu.ufabc.jogos_isidro.ufabctenis;

import br.edu.ufabc.jogos_isidro.ufabctenis.Menu.StartMenu;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleSkin;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;

public class UFABCTenis extends Game {

	private SimpleSkin skin;

	@Override
	public void create () {
		skin=new SimpleSkin();
		skin.addFont("fonts/PressStart2P.ttf", 26);
		skin.addTexture(Color.WHITE);
		skin.addLabelStyle(Color.WHITE, Color.CLEAR);
		skin.addButtonStyle(Color.CLEAR, Color.CLEAR, Color.GOLD, Color.ROYAL);

		this.setScreen(new StartMenu(this, skin));
	}

	@Override
	public void render () {
	    super.render();
	}
	
	@Override
	public void dispose () {
	}

}

package br.edu.ufabc.jogos_isidro.ufabctenis;

import br.edu.ufabc.jogos_isidro.ufabctenis.Menu.StartMenu;
import br.edu.ufabc.jogos_isidro.ufabctenis.Model.Factory;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleSkin;
import br.edu.ufabc.jogos_isidro.ufabctenis.Util.Parameters;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;

public class UFABCTenis extends Game {

	@Override
	public void create () {
		Parameters.setGame(this);
		Parameters.Init();

		SimpleSkin skin=new SimpleSkin();
		skin.addBackground("Images/background.jpg");
		skin.addFont("SimpleSkin/PressStart2P.ttf", 16);
		skin.addTexture(Color.WHITE);
		skin.addLabelStyle(Color.WHITE, Color.CLEAR);
		skin.addButtonStyle(Color.CLEAR, Color.CLEAR, Color.GOLD, Color.ROYAL);
		skin.addSliderStyle(Color.ROYAL, Color.WHITE);
		skin.addCheckBoxStyle("SimpleSkin/checked.png", "SimpleSkin/unchecked.png", Color.WHITE);
		Parameters.setSimpleSkin(skin);

		Factory.load();
		Parameters.setGameScreen(new StartMenu());
	}

	@Override
	public void render () {
	    super.render();
	}
	
	@Override
	public void dispose () {
	}

}

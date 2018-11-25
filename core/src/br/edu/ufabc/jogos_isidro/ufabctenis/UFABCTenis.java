package br.edu.ufabc.jogos_isidro.ufabctenis;

import br.edu.ufabc.jogos_isidro.ufabctenis.Menu.MenuScreen;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleMenu;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleSkin;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class UFABCTenis extends Game {

	private SimpleSkin skin;
    private SimpleMenu current;

	@Override
	public void create () {
		skin=new SimpleSkin();
		skin.addFont("fonts/PressStart2P.ttf", 26);
		skin.addTexture(Color.WHITE);
		skin.addButtonStyle(Color.CLEAR, Color.CLEAR, Color.GOLD, Color.ROYAL);

		current=new MenuScreen("JOGO", skin);
	}

	@Override
	public void render () {
		current.render(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
	}

}

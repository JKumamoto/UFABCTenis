package br.edu.ufabc.jogos_isidro.ufabctenis.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.edu.ufabc.jogos_isidro.ufabctenis.UFABCTenis;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new UFABCTenis(), config);
	}
}

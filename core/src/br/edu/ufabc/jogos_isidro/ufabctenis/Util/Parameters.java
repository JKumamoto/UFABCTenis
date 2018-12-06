package br.edu.ufabc.jogos_isidro.ufabctenis.Util;

import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleSkin;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Parameters {

    private static Game game;
    private static SimpleSkin simpleSkin;
    private static boolean SoundEnabled;
    private static float SoundVolume;
    private static boolean MusicEnabled;
    private static float MusicVolume;

    public static void Init(){
        setSoundEnabled(true);
        setSoundVolume(1.0f);
        setMusicEnabled(true);
        setMusicVolume(1.0f);
    }

    private static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        Parameters.game = game;
    }

    public static void setGameScreen(Screen screen) {
        getGame().setScreen(screen);
    }

    public static SimpleSkin getSimpleSkin() {
        return simpleSkin;
    }

    public static void setSimpleSkin(SimpleSkin simpleSkin) {
        Parameters.simpleSkin = simpleSkin;
    }

    public static boolean isSoundEnabled() {
        return SoundEnabled;
    }

    public static void setSoundEnabled(boolean soundEnabled) {
        SoundEnabled = soundEnabled;
    }

    public static float getSoundVolume() {
        return SoundVolume;
    }

    public static void setSoundVolume(float soundVolume) {
        SoundVolume = soundVolume;
    }

    public static boolean isMusicEnabled() {
        return MusicEnabled;
    }

    public static void setMusicEnabled(boolean musicEnabled) {
        MusicEnabled = musicEnabled;
    }

    public static float getMusicVolume() {
        return MusicVolume;
    }

    public static void setMusicVolume(float musicVolume) {
        MusicVolume = musicVolume;
    }
}

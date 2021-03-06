package br.edu.ufabc.jogos_isidro.ufabctenis.Model;

import br.edu.ufabc.jogos_isidro.ufabctenis.Util.Parameters;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.UBJsonReader;

import java.util.HashMap;

public class Factory {

    private static HashMap<String, Model> modelos=new HashMap<String, Model>();
    private static HashMap<String, Sound> sounds=new HashMap<String, Sound>();

    public static void load(){
        ModelLoader<ModelLoader.ModelParameters> loader;
        loader=new G3dModelLoader((new UBJsonReader()));
        System.out.println("Loading...");
        //modelos.put("TennisBall", loader.loadModel(Gdx.files.internal("models/tennisball.g3db")));

        sounds.put("applause", Gdx.audio.newSound(Gdx.files.internal(("SoundEffects/applause.mp3"))));
        sounds.put("bounce", Gdx.audio.newSound(Gdx.files.internal(("SoundEffects/bounce.mp3"))));
        sounds.put("racket", Gdx.audio.newSound(Gdx.files.internal(("SoundEffects/racket.mp3"))));
        System.out.println("DONE");
    }

    public static Model getModel(String name){
        return modelos.get(name);
    }

    public static void getSound(String name) {
        if(Parameters.isSoundEnabled())
            sounds.get(name).play(Parameters.getSoundVolume());
    }

}

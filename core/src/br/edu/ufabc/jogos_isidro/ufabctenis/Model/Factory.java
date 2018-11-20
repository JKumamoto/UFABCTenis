package br.edu.ufabc.jogos_isidro.ufabctenis.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.UBJsonReader;

import java.util.HashMap;

public class Factory {

    private static HashMap<String, Model> modelos=new HashMap<String, Model>();

    static {
        ModelLoader<ModelLoader.ModelParameters> loader;
        loader=new G3dModelLoader((new UBJsonReader()));
        System.out.println("Loading...");
        modelos.put("TennisBall", loader.loadModel(Gdx.files.internal("models/tennisball.g3db")));
        System.out.println("DONE");
    }

    public static Model getModel(String name){
        return modelos.get(name);
    }

}

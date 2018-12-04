package br.edu.ufabc.jogos_isidro.ufabctenis.Model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class TennisBall {

    private GameObject obj;

    public TennisBall(){
        ModelBuilder builder=new ModelBuilder();
        Model ball=builder.createSphere(1f, 1f, 1f, 36, 36,
                new Material(ColorAttribute.createDiffuse(Color.LIME)), Usage.Position | Usage.Normal);
        obj=new GameObject(ball);
    }

    public ModelInstance getCurrent(){
        return obj;
    }
}

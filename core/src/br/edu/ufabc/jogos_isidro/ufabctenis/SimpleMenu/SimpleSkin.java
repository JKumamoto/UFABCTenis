package br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class SimpleSkin{

    private Skin skin;

    public SimpleSkin(){
        skin=new Skin();
    }

    public void addFont(String path, int size){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(path));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = size;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
        skin.add("default", font);
        skin.getFont("default").getData().markupEnabled=true;
    }

    public void addTexture(Color color){
        Pixmap pixmap=new Pixmap(1,1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        skin.add("default", new Texture(pixmap));
    }

    public void addLabelStyle(Color font, Color background){
        LabelStyle labelStyle=new LabelStyle(skin.getFont("default"), font);
        labelStyle.background=skin.newDrawable("default", background);
        skin.add("default", labelStyle);
    }

    public void addButtonStyle(Drawable up, Drawable down, Drawable checked, Drawable over){
        ButtonStyle buttonStyle=new ButtonStyle(up, down, checked);
        buttonStyle.over=over;
        skin.add("default", buttonStyle);

        TextButtonStyle textButtonStyle=new TextButtonStyle(up, down, checked, skin.getFont("default"));
        textButtonStyle.over=over;
        skin.add("default", textButtonStyle);
    }

    public void addButtonStyle(Color up, Color down, Color checked, Color over){
        addButtonStyle(skin.newDrawable("default", up), skin.newDrawable("default", down),
                skin.newDrawable("default", checked), skin.newDrawable("default", over));
    }

    public Skin getSkin() {
        return skin;
    }

}

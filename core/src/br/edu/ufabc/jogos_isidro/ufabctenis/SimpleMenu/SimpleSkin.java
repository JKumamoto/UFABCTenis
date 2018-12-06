package br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SimpleSkin{

    private Skin skin;

    public SimpleSkin(){
        skin=new Skin();
    }

    public void addBackground(String path){
        TextureRegion background=new TextureRegion(new Texture(Gdx.files.internal(path)));
        skin.add("background", background);
    }

    public void addFont(String path, int size){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(path));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = size;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
        skin.add("default", font);
        skin.getFont("default").getData().markupEnabled=true;

        generator = new FreeTypeFontGenerator(Gdx.files.internal(path));
        parameter = new FreeTypeFontParameter();
        parameter.size = size*3;
        font = generator.generateFont(parameter);
        generator.dispose(); // don't forget to dispose to avoid memory leaks!
        skin.add("title", font);
        skin.getFont("title").getData().markupEnabled=true;
    }

    public void addTexture(Color color){
        Pixmap pixmap=new Pixmap(1,1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        skin.add("default", new Texture(pixmap));
        pixmap.dispose();
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

    public void addSliderStyle(Color knob, Color background){
        SliderStyle sliderStyle=new SliderStyle(skin.newDrawable("default", background),
                skin.newDrawable("default", knob));
        sliderStyle.knob.setMinHeight(10);
        sliderStyle.knob.setMinWidth(10);
        sliderStyle.background.setMinWidth(10);
        sliderStyle.background.setMinHeight(10);
        skin.add("default-horizontal", sliderStyle);
    }

    public void addCheckBoxStyle(String on, String off, Color font){
        CheckBoxStyle checkBoxStyle=new CheckBoxStyle(new TextureRegionDrawable(new TextureRegion(new Texture(off))),
                new TextureRegionDrawable(new TextureRegion(new Texture(on))), skin.getFont("default"), font);
        checkBoxStyle.checkboxOff.setMinHeight(skin.getFont("default").getLineHeight());
        checkBoxStyle.checkboxOff.setMinWidth(skin.getFont("default").getSpaceWidth());
        checkBoxStyle.checkboxOn.setMinHeight(skin.getFont("default").getLineHeight());
        checkBoxStyle.checkboxOn.setMinWidth(skin.getFont("default").getSpaceWidth());
        skin.add("default", checkBoxStyle);
    }

    public Skin getSkin() {
        return skin;
    }

}

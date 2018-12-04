package br.edu.ufabc.jogos_isidro.ufabctenis.Menu;

import br.edu.ufabc.jogos_isidro.ufabctenis.Model.Factory;
import br.edu.ufabc.jogos_isidro.ufabctenis.SimpleMenu.SimpleMenu;
import br.edu.ufabc.jogos_isidro.ufabctenis.Util.Parameters;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;

public class OptionsMenu extends SimpleMenu {

    public OptionsMenu(){
        super();

        table.align(Align.topLeft);
        table.padLeft(100);
        table.padTop(100);

        final Label title=new Label("Opções", skin, "title", Color.WHITE);
        table.add(title);
        table.row();

        final Label label=new Label("Linha1\n2", skin, "title", Color.CLEAR);
        table.add(label);
        table.row();

        Table table1=new Table();
        Container container=new Container(table1);
        table.add(container);
        ArrayList<Container> containers=new ArrayList<Container>();

        containers.add(new Container(new Label("Volume Musica", skin)));

        final Slider volumeMusic=new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusic.setValue(Parameters.getMusicVolume());
        volumeMusic.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Parameters.setMusicVolume(volumeMusic.getValue());
                return false;
            }
        });
        containers.add(new Container(volumeMusic));

        containers.add(new Container(new Label("Volume", skin)));

        final CheckBox musicCheckBox=new CheckBox(null, skin);
        musicCheckBox.setChecked(Parameters.isMusicEnabled());
        musicCheckBox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Parameters.setMusicEnabled(musicCheckBox.isChecked());
                return false;
            }
        });
        containers.add(new Container(musicCheckBox));

        containers.add(new Container(new Label("Volume Som", skin)));

        final Slider volumeSound=new Slider(0f, 1f, 0.1f, false, skin);
        volumeSound.setValue(Parameters.getSoundVolume());
        volumeSound.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Parameters.setSoundVolume(volumeSound.getValue());
                return false;
            }
        });
        containers.add(new Container(volumeSound));

        containers.add(new Container(new Label("Volume", skin)));

        final CheckBox soundCheckBox=new CheckBox(null, skin);
        soundCheckBox.setChecked(Parameters.isSoundEnabled());
        soundCheckBox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Parameters.setSoundEnabled(soundCheckBox.isChecked());
                return false;
            }
        });
        containers.add(new Container(soundCheckBox));

        containers.add(new Container(new Label("Linha1\n2", skin, "title", Color.CLEAR)));
        containers.add(new Container(new Label("Linha1\n2", skin, "title", Color.CLEAR)));

        Factory.getSound("applause").play(Parameters.getSoundVolume());
        final TextButton back=new TextButton("Voltar", skin);
        back.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                Parameters.setGameScreen(new StartMenu());
            }
        });
        containers.add(new Container(back));
        containers.add(new Container(new Label("", skin)));

        for(int i=0; i<containers.size(); i+=2){
            for(int j=0; j<2; j++) {
                containers.get(i + j).height(back.getHeight() * 2);
                table1.add(containers.get(i + j));
            }
            table1.row();
        }
    }

}

package br.edu.ufabc.jogos_isidro.ufabctenis.Menu;

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

class OptionsMenu extends SimpleMenu {

    OptionsMenu(){
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
        Container container=new Container<Table>(table1);
        table.add(container);
        ArrayList<Container> containers=new ArrayList<Container>();

        containers.add(new Container<Label>(new Label("Volume Musica", skin)));

        final Slider volumeMusic=new Slider(0f, 1f, 0.1f, false, skin);
        volumeMusic.setValue(Parameters.getMusicVolume());
        volumeMusic.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Parameters.setMusicVolume(volumeMusic.getValue());
                return false;
            }
        });
        containers.add(new Container<Slider>(volumeMusic));

        containers.add(new Container<Label>(new Label("Volume", skin)));

        final CheckBox musicCheckBox=new CheckBox(null, skin);
        musicCheckBox.setChecked(Parameters.isMusicEnabled());
        musicCheckBox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Parameters.setMusicEnabled(musicCheckBox.isChecked());
                return false;
            }
        });
        containers.add(new Container<CheckBox>(musicCheckBox));

        containers.add(new Container<Label>(new Label("Volume Som", skin)));

        final Slider volumeSound=new Slider(0f, 1f, 0.1f, false, skin);
        volumeSound.setValue(Parameters.getSoundVolume());
        volumeSound.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Parameters.setSoundVolume(volumeSound.getValue());
                return false;
            }
        });
        containers.add(new Container<Slider>(volumeSound));

        containers.add(new Container<Label>(new Label("Volume", skin)));

        final CheckBox soundCheckBox=new CheckBox(null, skin);
        soundCheckBox.setChecked(Parameters.isSoundEnabled());
        soundCheckBox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Parameters.setSoundEnabled(soundCheckBox.isChecked());
                return false;
            }
        });
        containers.add(new Container<CheckBox>(soundCheckBox));

        containers.add(new Container<Label>(new Label("Linha1\n2", skin, "title", Color.CLEAR)));
        containers.add(new Container<Label>(new Label("Linha1\n2", skin, "title", Color.CLEAR)));

        final TextButton back=new TextButton("Voltar", skin);
        back.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                Parameters.setGameScreen(new StartMenu());
            }
        });
        containers.add(new Container<TextButton>(back));
        containers.get(containers.size()-1).width(back.getWidth()+5);
        containers.add(new Container<Label>(new Label("", skin)));

        for(int i=0; i<containers.size(); i+=2){
            for(int j=0; j<2; j++) {
                containers.get(i + j).height(containers.get(i+j).getActor().getHeight() * 2);
                table1.add(containers.get(i + j));
            }
            table1.row();
        }
    }

}

package br.edu.ufabc.jogos_isidro.ufabctenis.Model;

public class TennisBall {

    private GameObject obj;

    public TennisBall(){
        obj=new GameObject(Factory.getModel("TennisBall"));
    }

    public GameObject getCurrent(){
        return obj;
    }
}

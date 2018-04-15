package Entity;

import android.graphics.Path;

public class Operator {
    private int id;
    private String libelle;

    public Operator(){}

    public Operator(Operator operator){
        this.id = operator.getId();
        this.libelle = operator.getLibelle();
    }

    public Operator(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getRow(){
        return "ID : "+id+"; LIBELLE : "+libelle;
    }
}

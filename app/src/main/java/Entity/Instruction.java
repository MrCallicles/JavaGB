package Entity;

public class Instruction {
    private int id;
    private String libelle;
    private String description;

    public Instruction(){}

    public Instruction(Instruction instruction){
        this.id = instruction.getId();
        this.libelle = instruction.getLibelle();
        this.description = instruction.getDescription();
    }

    public Instruction(String libelle, String description) {
        this.libelle = libelle;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRow(){
        return "ID : "+id+"; LIBELLE : "+libelle+"; DESCRIPTION : "+description;
    }
}

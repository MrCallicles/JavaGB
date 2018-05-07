//
//InfoRom.java
//
//Cette classe utilise une rom existante en ram
//Pour en retirer certaines informations
//Comme le titre. A voir si on peut pas mettres
//les trucs dans des BDD.
//Pt en faire une classe statique ?
//
package com.vdb.javagb.gb.memory;

public class InfoRom{
    private Ram _memory;

    public InfoRom(Ram ram){
        if (ram.romLoaded()){
            _memory = ram;
        }
        else{
            ///!\ rom non chargée !
            _memory = ram;
        }
    }

    public boolean legit(){
        //check si le logo nintendo est présent
        //sur la cartouche
        int[] nintendo = new int[] {
            0xCE, 0xED, 0x66, 0x66, 0xCC, 0x0D, 0x00, 0x0B, 0x03,
            0x73, 0x00, 0x83, 0x00, 0x0C, 0,00, 0x0D, 0x00, 0x08,
            0x11, 0x1F, 0x88, 0x89, 0x00, 0x0E, 0xDC, 0xCC, 0x6E,
            0xE6, 0xDD, 0xDD, 0xD9, 0x99, 0xBB, 0xBB, 0x67, 0x63,
            0x6E, 0x0E, 0xEC, 0xCC, 0xDD, 0xDC, 0x99, 0x9F, 0xBB,
            0xB9, 0x33, 0x3E };
        int[] check = new int[48];
        for(int i = 0; i < 47; i++){
            check[i] = _memory.getByte(i + 0x0104);
        }
        for(int i = 0; i < 47; i++){
            if(check[i] != nintendo[i]){
                return false;
            }
        }
        return true;
    }
    public String getTitle(){
        //retourne le titre
        int[] titre = new int[15];
        char[] charTitre = new char[15];
        for(int i = 0; i < 15; i++){
            titre[i] = _memory.getByte(i + 0x0134);
        }
        for(int i = 0; i < 15; i++){
            charTitre[i] = (char)titre[i];
        }

        return new String(charTitre);
    }

    public int cartridgeType(){
        return _memory.getByte(0x0147);
    }
    public String cartridgeTypeString(){
        int type = _memory.getByte(0x0147);
        switch(type){
            //à remplacer par une bdd ?
            case 0x00: return "ROM ONLY";
            case 0x01: return "MBC1";
            case 0x02: return "MBC1 + RAM";
            case 0x03: return "MBC1 + RAM + BATTERY";
            case 0x05: return "MBC2";
            case 0x06: return "MBC2 + BATTERY";
            case 0x08: return "ROM + RAM";
            case 0x09: return "ROM + RAM + BATTERY";
            case 0x0b: return "MMM01";
            case 0x0c: return "MMM01 + RAM";
            case 0x0d: return "MMM01 + RAM + BATTERY";
            case 0x0F: return "MBC03 + TIMER + BATTERY";
            case 0x10: return "MBC03 + TIMER + RAM + BATTERY";
            case 0x11: return "MBC03";
            case 0x12: return "MBC03 + RAM";
            default: return "UNKNOWN";
        }
    }
    public String cartridgeRomSize(){
        //retourne la taille de la rom en fonction d'une indication
        int size = _memory.getByte(0x0148);
        switch(size){
        case 0x00: return "32KBytes (no bank)";
        case 0x01: return "64KBytes (4 banks)";
        case 0x02: return "128KBytes (8 banks)";
        case 0x03: return "256KBytes (16 banks)";
        case 0x04: return "512KBytes (32 banks)";
        case 0x05: return "1MBytes (64 banks)";
        case 0x06: return "2MBytes (128 banks)";
        case 0x07: return "4MBytes (256 banks)";
        case 0x52: return "1.1MBytes (72 banks)";
        case 0x53: return "1.2MBytes (80 banks)";
        case 0x54: return "1.5MBytes (96 banks)";
        default: return "UNKNOWN";
        }
    }
    public String cartridgeRamSize(){
        int ramSize = _memory.getByte(0x149);
        switch (ramSize){
            case 0x00: return "None or 512x2";
            case 0x01: return "2 KBytes";
            case 0x02: return "8 KBytes";
            case 0x03: return "32 KBytes (4 banks of 8KBytes each)";
            default: return "UNKNOWN";
        }
    }
    public String cartridgeDestination(){
        int dest = _memory.getByte(0x014A);
        if (dest == 00) return "japanese";
        else return "non-japanese";
    }

    //public int globalChecksum(){
    //}
}

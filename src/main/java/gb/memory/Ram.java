package JavaGB.memory;

public class Ram{
    private int[] ram = new int[2^16];

    Ram(){
    }

    public void setByte(int address, int value){
        if(address >= 0xC000 && address <= 0xDE00){
            memory[address] = value;
            memory[address + 0x2000] = value; //echo ram
        }
        if(address >= 0xE000 && address <= 0xFE00){
            memory[address] = value;
            memory[address - 0x1000] = value; //echo ram
        }
        ram[address] = value & 0xff; //check que la valeur d'entrée est sur 8 bits
    }

    public int getByte(int address){
        return ram[address];
    }

    public void setWord(int address,int value){
        value = value & 0xffff; //check 16 bits
        this.setByte(address, value & 0xff);
        this.setByte(address + 1, (value >> 8 & 0xff));
    }

    public void getWord(int address){
        return ram[address] << 8 + ram[address + 1];
    }

    public void loadRomArray(int[] rom){
        //Charge une rom depuis un Array de
        //chiffres binaires
        //
        //check si la rom est assez petite
        //(pas de gestion des RMB) et
        //charge la rom au début de la ram
        for(int i = 0; i < rom.length; i++){
            ram[i] = rom[i];
        }
    }

    public void loadRomFile(){
    }

}

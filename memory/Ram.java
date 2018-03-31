package JavaGB.memory;

public class Ram{
    private int[] ram = new int[2^16];

    public void setByte(int address, int value){
        ram[address] = value & 0xff; //check que la valeur d'entrée est sur 8 bits
    }

    public int getByte(int address){
        return ram[address];
    }

    public void setWord(int address,int value){
        value = value & 0xffff; //check 16 bits
        ram[address] = value & 0xff; //bits bas
        ram[address+ 1] = (value >> 8) & 0xff; //bits hauts
    }

    public void getWord(int address){
        return ram[address] << 8 + ram[address + 1];
    }

}

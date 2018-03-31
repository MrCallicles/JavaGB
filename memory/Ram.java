package JavaGB.memory;

public class Ram{
    private int[] ram = new int[2^16];

    public void setByte(int address, int value){
        ram[address] = value;
    }

    public int getByte(int address){
        return ram[address];
    }
}

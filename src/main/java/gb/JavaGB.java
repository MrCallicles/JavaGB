package gb;

import gb.cpu.*;
import gb.memory.*;

import static gb.memory.TestRom;

public class JavaGB{
    public static void main(String[] args){
        Ram ram = new Ram();
        ExecCpu cpu = new ExecCpu(ram);

        ram.loadRomArray(testRom);
        cpu.execInstruction();
    }
}


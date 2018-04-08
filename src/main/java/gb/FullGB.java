//
//FullGB
//Sert de classe parent
//pour le truc android
//
package gb;

import gb.cpu.*;
import gb.memory.*;

import static gb.memory.TestRom;

public class FullGB{
    protected boolean breakpoints = new boolean[2^16];
    protected Ram ram;
    protected ExecCpu cpu;
    protected InfoRom infos;

    FullGB(int[] testRom){
        resetBreakpoints();
        Ram ram = new Ram();
        ExecCpu cpu = new ExecCpu(ram);
        InfoRom infos = new InfoRom();
        ram.loadRomArray(testRom);
    }
    FullGB(String pathRom){
        resetBreakpoints();
        Ram ram = new Ram();
        ExecCpu cpu = new ExecCpu(ram);
        InfoRom infos = new InfoRom();
        ram.loadRomFile(pathRom);
    }

    final protected addBreakpoint(int address){
        if((address >= 0) && (address <= 0xFFFF)){
            breakpoints[address] = true;
        }
    }

    final protected clearBreakpoint(int address){
        if((address >= 0) && (address <= 0xFFFF)){
            breakpoints[address] = false;
        }
    }

    final protected resetBreakpoints(){
        for(int i = 0; i < 0xFFFF; i++){
            breakpoints[i] = false;
        }
    }

    public run(){
        while(1){
            if (breakpoints[cpu.getInstruction()]){
                //break
                System.out.format("break at %02x\n",
                        cpu.getInstruction());
                
                breakProcedure();
            }
            cpu.execInstruction();
        }
    }

    protected breakProcedure(){
    }

    //fonctions privées
    private exec(){
        cpu.execInstruction();
    }

}


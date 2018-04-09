//
//FullGB
//Sert de classe parent
//pour le truc android
//
package gb;

import gb.cpu.*;
import gb.memory.*;
import gb.memory.Ram;
import gb.memory.TestRom;

public class FullGB{
    protected boolean[] breakpoints = new boolean[0xFFFF];
    protected Ram ram;
    protected ExecCpu cpu;
    protected InfoRom infos;

    public FullGB(int[] testRom){
        resetBreakpoints();
        Ram ram = new Ram();
        ram.loadRomArray(testRom);
        ExecCpu cpu = new ExecCpu(ram);
        InfoRom infos = new InfoRom(ram);
    }

    public FullGB(String pathRom){
        resetBreakpoints();
        Ram ram = new Ram();
        //ram.loadRomFile(pathRom);
        ExecCpu cpu = new ExecCpu(ram);
        InfoRom infos = new InfoRom(ram);
    }

    final protected void addBreakpoint(int address){
        if((address >= 0) && (address <= 0xFFFF)){
            breakpoints[address] = true;
        }
    }

    final protected void clearBreakpoint(int address){
        if((address >= 0) && (address <= 0xFFFF)){
            breakpoints[address] = false;
        }
    }

    final protected void resetBreakpoints(){
        for(int i = 0; i < 0xFFFF; i++){
            breakpoints[i] = false;
        }
    }

    public void run(){
        while(true){
            if (breakpoints[cpu.getInstruction()]){
                //break
                System.out.format("break at %02x\n",
                        cpu.getInstruction());
                breakProcedure();
            }
            cpu.execInstruction();
        }
    }

    protected void breakProcedure(){
    }

    //fonctions privées
    private void exec(){
        cpu.execInstruction();
    }

}


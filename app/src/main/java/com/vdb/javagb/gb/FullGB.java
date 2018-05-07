//
// FullGB sert de classe parent pour le truc android
//
package com.vdb.javagb.gb;

import com.vdb.javagb.gb.cpu.*;
import com.vdb.javagb.gb.memory.*;
import com.vdb.javagb.gb.memory.Ram;

public class FullGB{
    protected boolean[] breakpoints = new boolean[0xFFFF];
    protected Ram ram;
    protected Decompiler decompiler;
    public Registers registers;
    public ExecCpu cpu;
    public InfoRom infos;

    public FullGB(int[] testRom){
        ram = new Ram();
        decompiler = new Decompiler(ram);
        registers = new Registers();
        ram.loadRomArray(testRom);

        cpu = new ExecCpu(ram, registers);
        infos = new InfoRom(ram);

        this.resetBreakpoints();
    }

    public FullGB(String pathRom) {
        ram = new Ram();
        decompiler = new Decompiler(ram);
        registers = new Registers();
        ram.loadRomFile(pathRom);
        cpu = new ExecCpu(ram, registers);
        infos = new InfoRom(ram);

        this.resetBreakpoints();
    }

    final public void addBreakpoint(int address){
        if((address >= 0) && (address <= 0xFFFF)){
            breakpoints[address] = true;
        }
    }

    final public void clearBreakpoint(int address){
        if((address >= 0) && (address <= 0xFFFF)){
            breakpoints[address] = false;
        }
    }

    final public void resetBreakpoints(){
        for(int i = 0; i < 0xFFFF; i++){
            breakpoints[i] = false;
        }
    }

    public Decompiler getDecompiler(){
        return decompiler;
    }

    public int run(){
        //return true when
        //get a breakpoint
        while(true){
            if (breakpoints[cpu.getPCAddress()]){
                //break
                System.out.format("break at %02x\n",
                        cpu.getPCAddress());
                return cpu.getPCAddress();
            }
            cpu.execInstruction();
        }
    }

    public int step(){
        cpu.execInstruction();
        return cpu.getPCAddress();
    }

    public void showRegisters(){
        System.out.format("A: %02x\n", registers.getA());
        System.out.format("B: %02x\n", registers.getB());
        System.out.format("C: %02x\n", registers.getC());
        System.out.format("D: %02x\n", registers.getD());
        System.out.format("E: %02x\n", registers.getE());
        System.out.format("H: %02x\n", registers.getH());
        System.out.format("L: %02x\n", registers.getL());
        System.out.format("PC:%02x\n", registers.getPC());
        System.out.format("SP:%02x\n", registers.getSP());
    }

    //fonctions privées
    private void exec(){
        cpu.execInstruction();
    }

    public int[] dumpRam(){
        int[] dump = new int[0x7FFF];
        for(int i = 0; i < 0x7FFF; i++){
            dump[i] = ram.getByte(i);
        }
        return dump;
    }

    public int[] dumpRegisters(){
        int[] dump = new int[15];
        dump[0] = registers.getA();
        dump[1] = registers.getB();
        dump[2] = registers.getC();
        dump[3] = registers.getD();
        dump[4] = registers.getE();
        dump[5] = registers.getH();
        dump[6] = registers.getL();
        dump[7] = registers.getPC();
        dump[8] = registers.getSP();
        dump[9] = registers.getAF();
        dump[10] = registers.getBC();
        dump[11] = registers.getDE();
        dump[12] = registers.getHL();
        dump[13] = registers.getFlags();
        if(registers.getIME()) {
            dump[14] = 1;
        }
        else {
            dump[14] = 0;
        }
        return dump;
    }
}


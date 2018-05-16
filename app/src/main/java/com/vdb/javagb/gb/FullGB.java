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
    public boolean cursorBreaker;

    public FullGB(int[] testRom){
        ram = new Ram();
        registers = new Registers();
        ram.loadRomArray(testRom);
        decompiler = new Decompiler(ram);
        cpu = new ExecCpu(ram, registers);
        infos = new InfoRom(ram);

        this.resetBreakpoints();
    }

    public FullGB(String pathRom) {
        ram = new Ram();
        registers = new Registers();
        ram.loadRomFile(pathRom);
        decompiler = new Decompiler(ram);
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
            if (!cursorBreaker && breakpoints[cpu.getPCAddress()]){
                //break
                System.out.format("break at %02x\n",
                        cpu.getPCAddress());
                cursorBreaker = true;
                return cpu.getPCAddress();
            }
            cpu.execInstruction();
            cursorBreaker = false;
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

    public String[] dumpRegisters(){
        String[] dump = new String[15];
        dump[0] = "A         : "+String.format("0x%02x", registers.getA())+"\n";
        dump[1] = "B         : "+String.format("0x%02x", registers.getB())+"\n";
        dump[2] = "C         : "+String.format("0x%02x", registers.getC())+"\n";
        dump[3] = "D         : "+String.format("0x%02x", registers.getD())+"\n";
        dump[4] = "E         : "+String.format("0x%02x", registers.getE())+"\n";
        dump[5] = "H         : "+String.format("0x%02x", registers.getH())+"\n";
        dump[6] = "L         : "+String.format("0x%02x", registers.getL())+"\n\n";
        dump[7] = "PC       : "+String.format("0x%04x", registers.getPC())+"\n";
        dump[8] = "SP       : "+String.format("0x%04x", registers.getSP())+"\n";
        dump[9] = "AF       : "+String.format("0x%04x", registers.getAF())+"\n";
        dump[10] = "BC       : "+String.format("0x%04x", registers.getBC())+"\n";
        dump[11] = "DE       : "+String.format("0x%04x", registers.getDE())+"\n";
        dump[12] = "HL       : "+String.format("0x%04x", registers.getHL())+"\n\n";
        dump[13] = "Flags : "+ String.format("0x%02x",registers.getFlags())+"\n";
        if(registers.getIME()) {
            dump[14] = "IME     : 0x0"+1;
        }
        else {
            dump[14] = "IME     : 0x0"+0;
        }
        return dump;
    }
}


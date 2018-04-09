// Register.java
// Contient tous les registres
// du CPU ainsi que des getters et setters
// pour ceux-ci.
// Inclue aussi les getters et setters complexes
// AF, DE, HL
// Inclue aussi le registre Flag
//
package gb.cpu;

import static JavaGB.cpu.Utils.setBit;

public class Registers{
    private int a,b,c,d,e,h,l;
    private int sp;
    private int pc;
    private boolean ime;
    private int flags;

    Registers(){
        this.reset();
    }

    public void reset(){
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        h = 0;
        l = 0;
        sp = 0;
        pc = 0;
        ime = false;
        flags = 0;
    }

    public int getA(){ return a;}
    public int getB(){ return b;}
    public int getC(){ return c;}
    public int getD(){ return d;}
    public int getE(){ return e;}
    public int getH(){ return h;}
    public int getL(){ return l;}
    public int getPC(){ return pc;}
    public int getSP(){ return sp;}

    public int getAF(){return a << 8 + flags;}
    public int getBC(){return b << 8 + c;}
    public int getDE(){return d << 8 + e;}
    public int getHL(){return h << 8 + l;}

    public boolean getZFlag(){ return (flags & (1 << 7)) != 0; }; //0x80
    public boolean getNFlag(){ return (flags & (1 << 6)) != 0; }; //0x40
    public boolean getHFlag(){ return (flags & (1 << 5)) != 0; }; //0x20
    public boolean getCFlag(){ return (flags & (1 << 4)) != 0; }; //0x10
    public int getFlags(){ return flags;};

    public void setZFlag(boolean input){flags = setBit(flags, input, 7);};
    public void setNFlag(boolean input){flags = setBit(flags, input, 6);};
    public void setHFlag(boolean input){flags = setBit(flags, input, 5);};
    public void setCFlag(boolean input){flags = setBit(flags, input, 4);};
    public void setFlags(int input){flags = input & 0xFF;};

    public boolean getIME(){ return ime;}
    public void setIME(boolean input){ ime = input;}

    //& 0xFFFF pour contenir le résultat dans 16 bits
    public void incrementPC(){ pc = (pc + 1) & 0xFFFF;}
    public void incrementPC2(){ pc = (pc + 2) & 0xFFFF;}
    public void incrementSP(){ sp = (sp + 1) & 0xFFFF;}
    public void incrementSP2(){ sp = (sp + 2) & 0xFFFF;}
    public void decrementSP(){ sp = (sp - 1) & 0xFFFF;}
    public void decrementSP2(){ sp = (sp - 2) & 0xFFFF;}

    public void setA(int input){ a = input & 0xFF;}
    public void setB(int input){ b = input & 0xFF;}
    public void setC(int input){ c = input & 0xFF;}
    public void setD(int input){ d = input & 0xFF;}
    public void setE(int input){ e = input & 0xFF;}
    public void setH(int input){ h = input & 0xFF;}
    public void setL(int input){ l = input & 0xFF;}
    public void setPC(int input){ pc = input & 0xFF;}
    public void setSP(int input){ sp = input & 0xFF;}

    public void setAF(int input){ a = (input & 0xFF00) >> 8; this.setFlags(input & 0x00FF);}
    public void setBC(int input){ b = (input & 0xFF00) >> 8; c = (input & 0x00FF);}
    public void setDE(int input){ d = (input & 0xFF00) >> 8; e = (input & 0x00FF);}
    public void setHL(int input){ h = (input & 0xFF00) >> 8; l = (input & 0x00FF);}

    public void incrementHL(){int hl = this.getHL();hl += 1; this.setHL(hl);}
    public void decrementHL(){int hl = this.getHL();hl -= 1; this.setHL(hl);}

    public void incrementBC(){int bc = this.getBC();bc += 1; this.setBC(bc);}
    public void decrementBC(){int bc = this.getBC();bc -= 1; this.setBC(bc);}

    public void incrementDE(){int de = this.getDE();de += 1; this.setDE(de);}
    public void decrementDE(){int de = this.getDE();de -= 1; this.setDE(de);}

}


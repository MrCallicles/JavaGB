//
// Register.java
// Contient tous les registres
// du CPU ainsi que des getters et setters
// pour ceux-ci.
// Inclue aussi les getters et setters complexes
// AF, DE, HL
// Inclue aussi le registre Flag
//
package JavaGB.cpu;

public class Registers{
    private int a,b,c,d,e,h,l;
    private int sp;
    private int pc;

    private Flags flags = new Flags();

    public int getA(){ return a;};
    public int getB(){ return b;};
    public int getC(){ return c;};
    public int getD(){ return d;};
    public int getE(){ return e;};
    public int getH(){ return h;};
    public int getL(){ return l;};
    public int getPC(){ return pc;};
    public int getSP(){ return sp;};

    public int getAF(){return a << 8 + flags.getFlags();};
    public int getBC(){return b << 8 + c;};
    public int getDE(){return d << 8 + e;};
    public int getHL(){return h << 8 + l;};


    public Flags getFlags(){ return flags; };

    //& 0xFFFF pour contenir le résultat dans 16 bits
    public void incrementPC(){ pc = (pc + 1) & 0xFFFF;};
    public void incrementSP(){ sp = (sp + 1) & 0xFFFF;};
    public void decrementSP(){ sp = (sp - 1) & 0xFFFF;};

    public void setA(int input){ a = input;};
    public void setB(int input){ b = input;};
    public void setC(int input){ c = input;};
    public void setD(int input){ d = input;};
    public void setE(int input){ e = input;};
    public void setH(int input){ h = input;};
    public void setL(int input){ l = input;};
    public void setPC(int input){ pc = input;};
    public void setSP(int input){ sp = input;};

    public void setAF(int input){ a = (input & 0xFF00) >> 8; flags.setFlags(input & 0x00FF);};
    public void setBC(int input){ b = (input & 0xFF00) >> 8; c = (input & 0x00FF);};
    public void setDE(int input){ d = (input & 0xFF00) >> 8; e = (input & 0x00FF);};
    public void setHL(int input){ h = (input & 0xFF00) >> 8; l = (input & 0x00FF);};
}


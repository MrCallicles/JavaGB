package JavaGB.cpu;

public class Registers{
    private int a,b,c,d,e,h,l;
    private int sp;
    private int pc;

    private FlagsRegister flags = new FlagsRegister();

    public int getA(){ return a;};
    public int getB(){ return b;};
    public int getC(){ return c;};
    public int getD(){ return d;};
    public int getE(){ return e;};
    public int getH(){ return h;};
    public int getL(){ return l;};

    //getAF !!!!!
    public int getBC(){return b << 8 + c};
    public int getDE(){return d << 8 + e};
    public int getHL(){return h << 8 + l};

    public int getPC(){ return pc;};
    public int getSP(){ return sp;};

    public int FlagsRegister getFlags(){ return flags; };

    public void incrementPC(){ pc = (pc + 1)};
    public void incrementSP(){ sp = (sp + 1)};
    public void decrementSP(){ sp = (sp - 1)};

    //setters !!!

}

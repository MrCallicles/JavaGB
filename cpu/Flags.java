//
// Flags.java
// Stock le registre Flags ainsi que des méthodes
// pour accéder et modifier facilement chaque flag
//
package JavaGB.cpu;

import static JavaGB.cpu.Utils.setBit;

public class Flags{
    private int flags;

    public boolean getZ(){ return (flags & (1 << 7)) != 0; };
    public boolean getN(){ return (flags & (1 << 6)) != 0; };
    public boolean getH(){ return (flags & (1 << 5)) != 0; };
    public boolean getC(){ return (flags & (1 << 4)) != 0; };
    public int getFlags(){ return flags;};

    public void setZ(boolean input){flags = setBit(flags, input, 7);};
    public void setN(boolean input){flags = setBit(flags, input, 6);};
    public void setH(boolean input){flags = setBit(flags, input, 5);};
    public void setC(boolean input){flags = setBit(flags, input, 4);};
    public void setFlag(int input){flags = input;};
}

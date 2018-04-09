package gb;

import gb.memory.TestRom;

public class App{
    public static void main(String[] args){
        FullGB gb = new FullGB(TestRom.testRom);
    }
}

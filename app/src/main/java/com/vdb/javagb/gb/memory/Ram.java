package com.vdb.javagb.gb.memory;

import android.util.Log;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Ram{
    private int[] ram = new int[0xFFFF];
    private boolean romLoaded;
    private int romSize;

    public Ram(){
        romLoaded = false;
    }

    public void setByte(int address, int value){
        //modifie un bit dans la ram
        //prend en compte le mirroring
        //0xC000 - 0xCFFF -> 0xE000 -> 0xDFFF
        if(address >= 0xC000 && address <= 0xDE00){
            ram[address] = value;
            ram[address + 0x2000] = value; //echo ram
        }
        if(address >= 0xE000 && address <= 0xFE00){
            ram[address] = value;
            ram[address - 0x1000] = value; //echo ram
        }
        ram[address] = value & 0xff; //check que la valeur d'entrée est sur 8 bits
    }

    public boolean romLoaded(){
        return romLoaded;
    }

    public int getByte(int address){
        return ram[address];
    }

    public void setWord(int address,int value){
        value = value & 0xffff; //check 16 bits
        this.setByte(address, value & 0xff);
        this.setByte(address + 1, (value >> 8 & 0xff));
    }

    public int getWord(int address){
        return ram[address] << 8 + ram[address + 1];
    }

    public void loadRomArray(int[] rom){
        //Charge une rom depuis un Array de
        //chiffres binaires
        //
        //check si la rom est assez petite
        //(pas de gestion des RMB) et
        //charge la rom au début de la ram
        int n = 0x7FFF; //taille rom sur memory map ?? = 32767
        this.romSize = rom.length;
        if(rom.length < n) {
            for(int i = 0; i < rom.length; i++){
                ram[i] = rom[i];
            }
            romLoaded = true;
        }
        else{
            System.out.println("Rom trop longue");
        }
    }

    public void loadRomFile(String pathRom) {

        //charge une rom depuis un fichier
        int n = 0x7FFF; //taille rom sur memory map ?? = 32767
        try{
            File file = new File(pathRom);
            FileInputStream fileIn = new FileInputStream(file);
            byte[] rom = new byte[(int) fileIn.getChannel().size()];
            DataInputStream dis = new DataInputStream(fileIn);
            dis.readFully(rom);
            dis.close();
            //this.romSize = rom.length;
            if(rom.length > n){
                for(int i = 0; i < n; i++){
                    ram[i] = rom[i] & 0xFF;
                }
            }else{
                for(int i = 0; i < rom.length; i++){
                    ram[i] = rom[i] & 0xFF;
                }
            }
            fileIn.close();
        }catch (FileNotFoundException e) {
            Log.i("loadRomFile", e.getMessage());
        }
        catch (IOException e){
            Log.i("loadRomFile", e.getMessage());
        }

    }

    public int getRomSize(){
            return this.romSize;
        }

    }


package com.vdb.javagb.gb;

import com.vdb.javagb.gb.cpu.*;
import com.vdb.javagb.gb.memory.Ram;

import java.util.ArrayList;

public class Decompiler{
    private Ram _memory;
    private Registers registers;
    private int pc;
    private int instruction;

    public Decompiler(Ram ram){
        this.pc = 0;
        this.instruction = 0;
        this._memory = ram;
    }

    private void loadInstruction(){
        this.instruction = _memory.getByte(this.pc);
    }

    private void incrementPC(){
        this.pc += 1;
    }

    private String formatHexa(int hexa){
        return String.format("%2x", hexa);
    }

    public ArrayList<String[]> decompileRom(){
        ArrayList<String[]> tmp = new ArrayList();
        this.loadInstruction();
        for(int i = 0; i < 0x7FFF; i++){
            tmp.add(decompileInstruction());
            this.incrementPC();
            this.loadInstruction();
        }
        return tmp;
    }

    //les fonctions consOpcode construisent les strings à partir
    //de paramètre, on peut toujours modifier la construction
    //plus tard
    private String[] consOpcode(String mnemo, String opA, String opB){
        return new String[] {String.valueOf(this.pc), mnemo, opA, opB};
    }
    private String[] consOpcode(String mnemo, String op){
        return new String[] {String.valueOf(this.pc), mnemo, op, ""};
    }
    private String[] consOpcode(String mnemo){
        return new String[] {String.valueOf(this.pc), mnemo, "", ""};
    }

    private String opOctet(){
        this.incrementPC();
        return "Ox"+formatHexa(_memory.getByte(this.pc));
    }

    private String opWord(){
        this.incrementPC();
        String acc = formatHexa(_memory.getByte(this.pc));
        this.incrementPC();
        return "0x" + acc + formatHexa(_memory.getByte(this.pc));
    }

    public String[] decompileInstruction(){
        switch(this.instruction){
            case 0x00: return consOpcode("NOP");
            case 0x01: return consOpcode("LD", "BC", opWord());
            case 0x02: return consOpcode("LD","a","BC");
            case 0x03: return consOpcode("INC", "BC");
            case 0x04: return consOpcode("INC","b");
            case 0x05: return consOpcode("DEC","b");
            case 0x06: return consOpcode("LD","b",opOctet());
            case 0x07: return consOpcode("RLC","a");
            case 0x08: return consOpcode("LD","("+opWord()+")","SP");
            case 0x09: return consOpcode("ADD","HL","BC");
            case 0x0a: return consOpcode("LD","a", "BC");
            case 0x0b: return consOpcode("DEC","BC");
            case 0x0c: return consOpcode("INC","c");
            case 0x0d: return consOpcode("DEC","c");
            case 0x0e: return consOpcode("LD","c",opOctet());
            case 0x0f: return consOpcode("RCC","a");
            case 0x10: return consOpcode("STOP");
            case 0x11: return consOpcode("LD","DE",opWord());
            case 0x12: return consOpcode("LD","DE","a");
            case 0x13: return consOpcode("INC","DE");
            case 0x14: return consOpcode("INC","d");
            case 0x15: return consOpcode("DEC","d");
            case 0x16: return consOpcode("LD","d",opOctet());
            case 0x17: return consOpcode("RL","a");
            case 0x18: return consOpcode("JR",opOctet());
            case 0x19: return consOpcode("ADD","HL","DE");
            case 0x1a: return consOpcode("LD","a","DE");
            case 0x1b: return consOpcode("DEC","DE");
            case 0x1c: return consOpcode("INC","e");
            case 0x1d: return consOpcode("DEC","e");
            case 0x1e: return consOpcode("LD","e",opWord());
            case 0x1f: return consOpcode("RR","a");
            case 0x20: return consOpcode("JR","F",opOctet());
            case 0x21: return consOpcode("LD","HL",opWord());
            case 0x22: return consOpcode("LDI","HL","a");
            case 0x23: return consOpcode("INC","HL");
            case 0x24: return consOpcode("INC","h");
            case 0x25: return consOpcode("DEC","h");
            case 0x26: return consOpcode("LD","h",opOctet());
            case 0x27: return consOpcode("DAA");
            case 0x28: return consOpcode("JPZ",opOctet());
            case 0x29: return consOpcode("ADD","HL","HL");
            case 0x2a: return consOpcode("LDI", "a","HL");
            case 0x2b: return consOpcode("DEC","HL");
            case 0x2c: return consOpcode("INC","l");
            case 0x2d: return consOpcode("DEC","l");
            case 0x2e: return consOpcode("LD","l",opOctet());
            case 0x2f: return consOpcode("CPL");
            case 0x30: return consOpcode("JPC",opWord());
            case 0x31: return consOpcode("LD","SP", opWord());
            case 0x32: return consOpcode("LDD","HL","a");
            case 0x33: return consOpcode("INC","SP");
            case 0x34: return consOpcode("INC","HL");
            case 0x35: return consOpcode("DEC","HL");
            case 0x36: return consOpcode("LD","HL",opOctet());
            case 0x37: return consOpcode("SCF");
            case 0x38: return consOpcode("JPC",opOctet());
            case 0x39: return consOpcode("ADD","HL","SP");
            case 0x3a: return consOpcode("LDD","a","HL");
            case 0x3b: return consOpcode("DEC","SP");
            case 0x3c: return consOpcode("INC","a");
            case 0x3d: return consOpcode("DEC","a");
            case 0x3e: return consOpcode("LD","a", opOctet());
            case 0x3f: return consOpcode("CCF");
            case 0x40: return consOpcode("LD","b","b");
            case 0x41: return consOpcode("LD","b","c");
            case 0x42: return consOpcode("LD","b","d");
            case 0x43: return consOpcode("LD","b","e");
            case 0x44: return consOpcode("LD","b","h");
            case 0x45: return consOpcode("LD","b","l");
            case 0x46: return consOpcode("LD","b","HL");
            case 0x47: return consOpcode("LD","b","a");
            case 0x48: return consOpcode("LD","c","b");
            case 0x49: return consOpcode("LD","c","c");
            case 0x4a: return consOpcode("LD","c","d");
            case 0x4b: return consOpcode("LD","c","e");
            case 0x4c: return consOpcode("LD","c","h");
            case 0x4d: return consOpcode("LD","c","l");
            case 0x4e: return consOpcode("LD","c","HL");
            case 0x4f: return consOpcode("LD","c","a");
            case 0x50: return consOpcode("LD","d","b");
            case 0x51: return consOpcode("LD","d","c");
            case 0x52: return consOpcode("LD","d","d");
            case 0x53: return consOpcode("LD","d","e");
            case 0x54: return consOpcode("LD","d","h");
            case 0x55: return consOpcode("LD","d","l");
            case 0x56: return consOpcode("LD","d","HL");
            case 0x57: return consOpcode("LD","d","a");
            case 0x58: return consOpcode("LD","e","b");
            case 0x59: return consOpcode("LD","e","c");
            case 0x5a: return consOpcode("LD","e","d");
            case 0x5b: return consOpcode("LD","e","e");
            case 0x5c: return consOpcode("LD","e","h");
            case 0x5d: return consOpcode("LD","e","l");
            case 0x5e: return consOpcode("LD","e","HL");
            case 0x5f: return consOpcode("LD","e","a");
            case 0x60: return consOpcode("LD","h","b");
            case 0x61: return consOpcode("LD","h","c");
            case 0x62: return consOpcode("LD","h","d");
            case 0x63: return consOpcode("LD","h","e");
            case 0x64: return consOpcode("LD","h","h");
            case 0x65: return consOpcode("LD","h","l");
            case 0x66: return consOpcode("LD","h","HL");
            case 0x67: return consOpcode("LD","h","a");
            case 0x68: return consOpcode("LD","l","b");
            case 0x69: return consOpcode("LD","l","c");
            case 0x6a: return consOpcode("LD","l","d");
            case 0x6b: return consOpcode("LD","l","e");
            case 0x6c: return consOpcode("LD","l","h");
            case 0x6d: return consOpcode("LD","l","l");
            case 0x6e: return consOpcode("LD","l","HL");
            case 0x6f: return consOpcode("LD","l","a");
            case 0x70: return consOpcode("LD","HL","b");
            case 0x71: return consOpcode("LD","HL","c");
            case 0x72: return consOpcode("LD","HL","d");
            case 0x73: return consOpcode("LD","HL","e");
            case 0x74: return consOpcode("LD","HL","h");
            case 0x75: return consOpcode("LD","HL","l");
            case 0x76: return consOpcode("HALT");
            case 0x77: return consOpcode("LD","HL","a");
            case 0x78: return consOpcode("LD","a","b");
            case 0x79: return consOpcode("LD","a","c");
            case 0x7a: return consOpcode("LD","a","d");
            case 0x7b: return consOpcode("LD","a","e");
            case 0x7c: return consOpcode("LD","a","h");
            case 0x7d: return consOpcode("LD","a","l");
            case 0x7e: return consOpcode("LD","a","HL");
            case 0x7f: return consOpcode("LD","a","a");
            case 0x80: return consOpcode("ADD","a","b");
            case 0x81: return consOpcode("ADD","a","c");
            case 0x82: return consOpcode("ADD","a","d");
            case 0x83: return consOpcode("ADD","a","e");
            case 0x84: return consOpcode("ADD","a","h");
            case 0x85: return consOpcode("ADD","a","l");
            case 0x86: return consOpcode("ADD","a","HL");
            case 0x87: return consOpcode("ADD","a","a");
            case 0x88: return consOpcode("ADC","a","b");
            case 0x89: return consOpcode("ADC","a","c");
            case 0x8a: return consOpcode("ADC","a","d");
            case 0x8b: return consOpcode("ADC","a","e");
            case 0x8c: return consOpcode("ADC","a","h");
            case 0x8d: return consOpcode("ADC","a","l");
            case 0x8e: return consOpcode("ADC","a","HL");
            case 0x8f: return consOpcode("ADC","a","a");
            case 0x90: return consOpcode("SUB","a","b");
            case 0x91: return consOpcode("SUB","a","c");
            case 0x92: return consOpcode("SUB","a","d");
            case 0x93: return consOpcode("SUB","a","e");
            case 0x94: return consOpcode("SUB","a","h");
            case 0x95: return consOpcode("SUB","a","l");
            case 0x96: return consOpcode("SUB","a","HL");
            case 0x97: return consOpcode("SUB","a","a");
            case 0x98: return consOpcode("ADC","a","b");
            case 0x99: return consOpcode("ADC","a","c");
            case 0x9a: return consOpcode("SBC","a","d");
            case 0x9b: return consOpcode("SBC","a","e");
            case 0x9c: return consOpcode("SBC","a","h");
            case 0x9d: return consOpcode("SBC","a","l");
            case 0x9e: return consOpcode("SBC","a","HL");
            case 0x9f: return consOpcode("SBC","a","a");
            case 0xa0: return consOpcode("AND","a","b");
            case 0xa1: return consOpcode("AND","a","c");
            case 0xa2: return consOpcode("AND","a","d");
            case 0xa3: return consOpcode("AND","a","e");
            case 0xa4: return consOpcode("AND","a","h");
            case 0xa5: return consOpcode("AND","a","l");
            case 0xa6: return consOpcode("AND","a","HL");
            case 0xa7: return consOpcode("AND","a","a");
            case 0xa8: return consOpcode("XOR","a","b");
            case 0xa9: return consOpcode("XOR","a","c");
            case 0xaa: return consOpcode("XOR","a","d");
            case 0xab: return consOpcode("XOR","a","e");
            case 0xac: return consOpcode("XOR","a","h");
            case 0xad: return consOpcode("XOR","a","l");
            case 0xae: return consOpcode("XOR","a","HL");
            case 0xaf: return consOpcode("XOR","a","a");
            case 0xb0: return consOpcode("OR","a","b");
            case 0xb1: return consOpcode("OR","a","c");
            case 0xb2: return consOpcode("OR","a","d");
            case 0xb3: return consOpcode("OR","a","e");
            case 0xb4: return consOpcode("OR","a","h");
            case 0xb5: return consOpcode("OR","a","l");
            case 0xb6: return consOpcode("OR","a","HL");
            case 0xb7: return consOpcode("OR","a","a");
            case 0xb8: return consOpcode("CP","a","b");
            case 0xb9: return consOpcode("CP","a","c");
            case 0xba: return consOpcode("CP","a","d");
            case 0xbb: return consOpcode("CP","a","e");
            case 0xbc: return consOpcode("CP","a","h");
            case 0xbd: return consOpcode("CP","a","l");
            case 0xbe: return consOpcode("CP","a","HL");
            case 0xbf: return consOpcode("CP","a","a");
            case 0xc0: return consOpcode("RETNZ");
            case 0xc1: return consOpcode("POP","BC");
            case 0xc2: return consOpcode("JPNZ",opWord());
            case 0xc3: return consOpcode("JP",opOctet());
            case 0xc4: return consOpcode("CALLZ",opOctet());
            case 0xc5: return consOpcode("PUSH","BC");
            case 0xc6: return consOpcode("ADD","a",opOctet());
            case 0xc7: return consOpcode("RST","00");
            case 0xc8: return consOpcode("RETZ");
            case 0xc9: return consOpcode("POP","BC");
            case 0xca: return consOpcode("JPZ",opWord());
            case 0xcb: return StringDecompileInnerInstruction();
            case 0xcc: return consOpcode("CALLZ",opOctet());
            case 0xcd: return consOpcode("CALL",opOctet());
            case 0xce: return consOpcode("ADC","a",opOctet());
            case 0xcf: return consOpcode("RST","08");
            case 0xd0: return consOpcode("RETNC");
            case 0xd1: return consOpcode("POP","DE");
            case 0xd2: return consOpcode("JPNC",opWord());
            case 0xd3: return consOpcode("NOP");
            case 0xd4: return consOpcode("CALLC",opOctet());
            case 0xd5: return consOpcode("PUSH","DE");
            case 0xd6: return consOpcode("SUB","a",opOctet());
            case 0xd7: return consOpcode("RST","10");
            case 0xd8: return consOpcode("RETC");
            case 0xd9: return consOpcode("RETI");
            case 0xda: return consOpcode("JPC",opWord());
            case 0xdb: return consOpcode("NOP");
            case 0xdc: return consOpcode("CALLC",opOctet());
            case 0xdd: return consOpcode("NOP");
            case 0xde: return consOpcode("SBC","a",opOctet());
            case 0xdf: return consOpcode("RST","18");
            case 0xe0: return consOpcode("LD","IO","a");
            case 0xe1: return consOpcode("POP","HL");
            case 0xe2: return consOpcode("LD","(c)","a");
            case 0xe3: return consOpcode("NOP");
            case 0xe4: return consOpcode("NOP");
            case 0xe5: return consOpcode("PUSH","HL");
            case 0xe6: return consOpcode("AND","a",opOctet());
            case 0xe7: return consOpcode("RST","20");
            case 0xe8: return consOpcode("ADD","SP",opOctet());
            case 0xe9: return consOpcode("JP","HL");
            case 0xea: return consOpcode("LD","("+opWord()+")", "a");
            case 0xeb: return consOpcode("NOP");
            case 0xec: return consOpcode("NOP");
            case 0xed: return consOpcode("NOP");
            case 0xee: return consOpcode("XOR","a",opOctet());
            case 0xef: return consOpcode("RST","28");
            case 0xf0: return consOpcode("LD","a","IO");
            case 0xf1: return consOpcode("POP","AF");
            case 0xf2: return consOpcode("LD","a","(c)");
            case 0xf3: return consOpcode("DI");
            case 0xf4: return consOpcode("NOP");
            case 0xf5: return consOpcode("PUSH","AF");
            case 0xf6: return consOpcode("OR","a",opOctet());
            case 0xf7: return consOpcode("RST","30");
            case 0xf8: return consOpcode("LD","HL","SP"+opOctet());
            case 0xf9: return consOpcode("LD","SP","HL");
            case 0xfa: return consOpcode("LD","a","("+opWord()+")");
            case 0xfb: return consOpcode("EI");
            case 0xfc: return consOpcode("NOP");
            case 0xfd: return consOpcode("NOP");
            case 0xfe: return consOpcode("CP","a",opOctet());
            case 0xff: return consOpcode("RST","38");
            default: return consOpcode("NOP");
        }
    }

    public String[] StringDecompileInnerInstruction(){
        this.incrementPC();
        this.loadInstruction();
        switch(this.instruction) {
            case 0x00:
                return consOpcode("RLC", "b");
            case 0x01:
                return consOpcode("RLC", "c");
            case 0x02:
                return consOpcode("RLC", "d");
            case 0x03:
                return consOpcode("RLC", "e");
            case 0x04:
                return consOpcode("RLC", "h");
            case 0x05:
                return consOpcode("RLC", "l");
            case 0x06:
                return consOpcode("RLC", "HL");
            case 0x07:
                return consOpcode("RLC", "a");
            case 0x08:
                return consOpcode("RRC", "b");
            case 0x09:
                return consOpcode("RRC", "c");
            case 0x0a:
                return consOpcode("RRC", "d");
            case 0x0b:
                return consOpcode("RRC", "e");
            case 0x0c:
                return consOpcode("RRC", "h");
            case 0x0d:
                return consOpcode("RRC", "l");
            case 0x0e:
                return consOpcode("RRC", "HL");
            case 0x0f:
                return consOpcode("RRC", "a");
            case 0x10:
                return consOpcode("RL", "b");
            case 0x11:
                return consOpcode("RL", "c");
            case 0x12:
                return consOpcode("RL", "d");
            case 0x13:
                return consOpcode("RL", "e");
            case 0x14:
                return consOpcode("RL", "h");
            case 0x15:
                return consOpcode("RL", "l");
            case 0x16:
                return consOpcode("RL", "HL");
            case 0x17:
                return consOpcode("RL", "a");
            case 0x18:
                return consOpcode("RR", "b");
            case 0x19:
                return consOpcode("RR", "c");
            case 0x1a:
                return consOpcode("RR", "d");
            case 0x1b:
                return consOpcode("RR", "e");
            case 0x1c:
                return consOpcode("RR", "h");
            case 0x1d:
                return consOpcode("RR", "l");
            case 0x1e:
                return consOpcode("RR", "HL");
            case 0x1f:
                return consOpcode("RR", "a");
            case 0x20:
                return consOpcode("SLA", "b");
            case 0x21:
                return consOpcode("SLA", "c");
            case 0x22:
                return consOpcode("SLA", "d");
            case 0x23:
                return consOpcode("SLA", "e");
            case 0x24:
                return consOpcode("SLA", "h");
            case 0x25:
                return consOpcode("SLA", "l");
            case 0x26:
                return consOpcode("SLA", "HL");
            case 0x27:
                return consOpcode("SLA", "a");
            case 0x28:
                return consOpcode("SRA", "b");
            case 0x29:
                return consOpcode("SRA", "c");
            case 0x2a:
                return consOpcode("SRA", "d");
            case 0x2b:
                return consOpcode("SRA", "e");
            case 0x2c:
                return consOpcode("SRA", "h");
            case 0x2d:
                return consOpcode("SRA", "l");
            case 0x2e:
                return consOpcode("SRA", "HL");
            case 0x2f:
                return consOpcode("SRA", "a");
            case 0x30:
                return consOpcode("SWAP", "b");
            case 0x31:
                return consOpcode("SWAP", "c");
            case 0x32:
                return consOpcode("SWAP", "d");
            case 0x33:
                return consOpcode("SWAP", "e");
            case 0x34:
                return consOpcode("SWAP", "h");
            case 0x35:
                return consOpcode("SWAP", "l");
            case 0x36:
                return consOpcode("SWAP", "HL");
            case 0x37:
                return consOpcode("SWAP", "a");
            case 0x38:
                return consOpcode("SRL", "b");
            case 0x39:
                return consOpcode("SRL", "c");
            case 0x3a:
                return consOpcode("SRL", "d");
            case 0x3b:
                return consOpcode("SRL", "e");
            case 0x3c:
                return consOpcode("SRL", "h");
            case 0x3d:
                return consOpcode("SRL", "l");
            case 0x3e:
                return consOpcode("SRL", "HL");
            case 0x3f:
                return consOpcode("SRL", "a");
            case 0x40:
                return consOpcode("BIT", "0", "b");
            case 0x41:
                return consOpcode("BIT", "0", "c");
            case 0x42:
                return consOpcode("BIT", "0", "d");
            case 0x43:
                return consOpcode("BIT", "0", "e");
            case 0x44:
                return consOpcode("BIT", "0", "h");
            case 0x45:
                return consOpcode("BIT", "0", "l");
            case 0x46:
                return consOpcode("BIT", "0", "HL");
            case 0x47:
                return consOpcode("BIT", "0", "a");
            case 0x48:
                return consOpcode("BIT", "1", "b");
            case 0x49:
                return consOpcode("BIT", "1", "c");
            case 0x4a:
                return consOpcode("BIT", "1", "d");
            case 0x4b:
                return consOpcode("BIT", "1", "e");
            case 0x4c:
                return consOpcode("BIT", "1", "h");
            case 0x4d:
                return consOpcode("BIT", "1", "l");
            case 0x4e:
                return consOpcode("BIT", "1", "HL");
            case 0x4f:
                return consOpcode("BIT", "1", "a");
            case 0x50:
                return consOpcode("BIT", "2", "b");
            case 0x51:
                return consOpcode("BIT", "2", "c");
            case 0x52:
                return consOpcode("BIT", "2", "d");
            case 0x53:
                return consOpcode("BIT", "2", "e");
            case 0x54:
                return consOpcode("BIT", "2", "h");
            case 0x55:
                return consOpcode("BIT", "2", "l");
            case 0x56:
                return consOpcode("BIT", "2", "HL");
            case 0x57:
                return consOpcode("BIT", "2", "a");
            case 0x58:
                return consOpcode("BIT", "3", "b");
            case 0x59:
                return consOpcode("BIT", "3", "c");
            case 0x5a:
                return consOpcode("BIT", "3", "d");
            case 0x5b:
                return consOpcode("BIT", "3", "e");
            case 0x5c:
                return consOpcode("BIT", "3", "h");
            case 0x5d:
                return consOpcode("BIT", "3", "l");
            case 0x5e:
                return consOpcode("BIT", "3", "HL");
            case 0x5f:
                return consOpcode("BIT", "3", "a");
            case 0x60:
                return consOpcode("BIT", "4", "b");
            case 0x61:
                return consOpcode("BIT", "4", "c");
            case 0x62:
                return consOpcode("BIT", "4", "d");
            case 0x63:
                return consOpcode("BIT", "4", "e");
            case 0x64:
                return consOpcode("BIT", "4", "h");
            case 0x65:
                return consOpcode("BIT", "4", "l");
            case 0x66:
                return consOpcode("BIT", "4", "HL");
            case 0x67:
                return consOpcode("BIT", "4", "a");
            case 0x68:
                return consOpcode("BIT", "5", "b");
            case 0x69:
                return consOpcode("BIT", "5", "c");
            case 0x6a:
                return consOpcode("BIT", "5", "d");
            case 0x6b:
                return consOpcode("BIT", "5", "e");
            case 0x6c:
                return consOpcode("BIT", "5", "h");
            case 0x6d:
                return consOpcode("BIT", "5", "l");
            case 0x6e:
                return consOpcode("BIT", "5", "HL");
            case 0x6f:
                return consOpcode("BIT", "5", "a");
            case 0x70:
                return consOpcode("BIT", "6", "b");
            case 0x71:
                return consOpcode("BIT", "6", "c");
            case 0x72:
                return consOpcode("BIT", "6", "d");
            case 0x73:
                return consOpcode("BIT", "6", "e");
            case 0x74:
                return consOpcode("BIT", "6", "h");
            case 0x75:
                return consOpcode("BIT", "6", "l");
            case 0x76:
                return consOpcode("BIT", "6", "HL");
            case 0x77:
                return consOpcode("BIT", "6", "a");
            case 0x78:
                return consOpcode("BIT", "7", "b");
            case 0x79:
                return consOpcode("BIT", "7", "c");
            case 0x7a:
                return consOpcode("BIT", "7", "d");
            case 0x7b:
                return consOpcode("BIT", "7", "e");
            case 0x7c:
                return consOpcode("BIT", "7", "h");
            case 0x7d:
                return consOpcode("BIT", "7", "l");
            case 0x7e:
                return consOpcode("BIT", "7", "HL");
            case 0x7f:
                return consOpcode("BIT", "7", "a");
            case 0x80:
                return consOpcode("RES", "0", "b");
            case 0x81:
                return consOpcode("RES", "0", "c");
            case 0x82:
                return consOpcode("RES", "0", "d");
            case 0x83:
                return consOpcode("RES", "0", "e");
            case 0x84:
                return consOpcode("RES", "0", "h");
            case 0x85:
                return consOpcode("RES", "0", "l");
            case 0x86:
                return consOpcode("RES", "0", "HL");
            case 0x87:
                return consOpcode("RES", "0", "a");
            case 0x88:
                return consOpcode("RES", "1", "b");
            case 0x89:
                return consOpcode("RES", "1", "c");
            case 0x8a:
                return consOpcode("RES", "1", "d");
            case 0x8b:
                return consOpcode("RES", "1", "e");
            case 0x8c:
                return consOpcode("RES", "1", "h");
            case 0x8d:
                return consOpcode("RES", "1", "l");
            case 0x8e:
                return consOpcode("RES", "1", "HL");
            case 0x8f:
                return consOpcode("RES", "1", "a");
            case 0x90:
                return consOpcode("RES", "2", "b");
            case 0x91:
                return consOpcode("RES", "2", "c");
            case 0x92:
                return consOpcode("RES", "2", "d");
            case 0x93:
                return consOpcode("RES", "2", "e");
            case 0x94:
                return consOpcode("RES", "2", "h");
            case 0x95:
                return consOpcode("RES", "2", "l");
            case 0x96:
                return consOpcode("RES", "2", "HL");
            case 0x97:
                return consOpcode("RES", "2", "a");
            case 0x98:
                return consOpcode("RES", "3", "b");
            case 0x99:
                return consOpcode("RES", "3", "c");
            case 0x9a:
                return consOpcode("RES", "3", "d");
            case 0x9b:
                return consOpcode("RES", "3", "e");
            case 0x9c:
                return consOpcode("RES", "3", "h");
            case 0x9d:
                return consOpcode("RES", "3", "l");
            case 0x9e:
                return consOpcode("RES", "3", "HL");
            case 0x9f:
                return consOpcode("RES", "3", "a");
            case 0xa0:
                return consOpcode("RES", "4", "b");
            case 0xa1:
                return consOpcode("RES", "4", "c");
            case 0xa2:
                return consOpcode("RES", "4", "d");
            case 0xa3:
                return consOpcode("RES", "4", "e");
            case 0xa4:
                return consOpcode("RES", "4", "h");
            case 0xa5:
                return consOpcode("RES", "4", "l");
            case 0xa6:
                return consOpcode("RES", "4", "HL");
            case 0xa7:
                return consOpcode("RES", "4", "a");
            case 0xa8:
                return consOpcode("RES", "5", "b");
            case 0xa9:
                return consOpcode("RES", "5", "c");
            case 0xaa:
                return consOpcode("RES", "5", "d");
            case 0xab:
                return consOpcode("RES", "5", "e");
            case 0xac:
                return consOpcode("RES", "5", "h");
            case 0xad:
                return consOpcode("RES", "5", "l");
            case 0xae:
                return consOpcode("RES", "5", "HL");
            case 0xaf:
                return consOpcode("RES", "5", "a");
            case 0xb0:
                return consOpcode("RES", "6", "b");
            case 0xb1:
                return consOpcode("RES", "6", "c");
            case 0xb2:
                return consOpcode("RES", "6", "d");
            case 0xb3:
                return consOpcode("RES", "6", "e");
            case 0xb4:
                return consOpcode("RES", "6", "h");
            case 0xb5:
                return consOpcode("RES", "6", "l");
            case 0xb6:
                return consOpcode("RES", "6", "HL");
            case 0xb7:
                return consOpcode("RES", "6", "a");
            case 0xb8:
                return consOpcode("RES", "7", "b");
            case 0xb9:
                return consOpcode("RES", "7", "c");
            case 0xba:
                return consOpcode("RES", "7", "d");
            case 0xbb:
                return consOpcode("RES", "7", "e");
            case 0xbc:
                return consOpcode("RES", "7", "h");
            case 0xbd:
                return consOpcode("RES", "7", "l");
            case 0xbe:
                return consOpcode("RES", "7", "HL");
            case 0xbf:
                return consOpcode("RES", "7", "a");
            case 0xc0:
                return consOpcode("SET", "0", "b");
            case 0xc1:
                return consOpcode("SET", "0", "c");
            case 0xc2:
                return consOpcode("SET", "0", "d");
            case 0xc3:
                return consOpcode("SET", "0", "e");
            case 0xc4:
                return consOpcode("SET", "0", "h");
            case 0xc5:
                return consOpcode("SET", "0", "l");
            case 0xc6:
                return consOpcode("SET", "0", "HL");
            case 0xc7:
                return consOpcode("SET", "0", "a");
            case 0xc8:
                return consOpcode("SET", "1", "b");
            case 0xc9:
                return consOpcode("SET", "1", "c");
            case 0xca:
                return consOpcode("SET", "1", "d");
            case 0xcb:
                return consOpcode("SET", "1", "e");
            case 0xcc:
                return consOpcode("SET", "1", "h");
            case 0xcd:
                return consOpcode("SET", "1", "l");
            case 0xce:
                return consOpcode("SET", "1", "HL");
            case 0xcf:
                return consOpcode("SET", "1", "a");
            case 0xd0:
                return consOpcode("SET", "2", "b");
            case 0xd1:
                return consOpcode("SET", "2", "c");
            case 0xd2:
                return consOpcode("SET", "2", "d");
            case 0xd3:
                return consOpcode("SET", "2", "e");
            case 0xd4:
                return consOpcode("SET", "2", "h");
            case 0xd5:
                return consOpcode("SET", "2", "l");
            case 0xd6:
                return consOpcode("SET", "2", "HL");
            case 0xd7:
                return consOpcode("SET", "2", "a");
            case 0xd8:
                return consOpcode("SET", "3", "b");
            case 0xd9:
                return consOpcode("SET", "3", "c");
            case 0xda:
                return consOpcode("SET", "3", "d");
            case 0xdb:
                return consOpcode("SET", "3", "e");
            case 0xdc:
                return consOpcode("SET", "3", "h");
            case 0xdd:
                return consOpcode("SET", "3", "l");
            case 0xde:
                return consOpcode("SET", "3", "HL");
            case 0xdf:
                return consOpcode("SET", "3", "a");
            case 0xe0:
                return consOpcode("SET", "4", "b");
            case 0xe1:
                return consOpcode("SET", "4", "c");
            case 0xe2:
                return consOpcode("SET", "4", "d");
            case 0xe3:
                return consOpcode("SET", "4", "e");
            case 0xe4:
                return consOpcode("SET", "4", "h");
            case 0xe5:
                return consOpcode("SET", "4", "l");
            case 0xe6:
                return consOpcode("SET", "4", "HL");
            case 0xe7:
                return consOpcode("SET", "4", "a");
            case 0xe8:
                return consOpcode("SET", "5", "b");
            case 0xe9:
                return consOpcode("SET", "5", "c");
            case 0xea:
                return consOpcode("SET", "5", "d");
            case 0xeb:
                return consOpcode("SET", "5", "e");
            case 0xec:
                return consOpcode("SET", "5", "h");
            case 0xed:
                return consOpcode("SET", "5", "l");
            case 0xee:
                return consOpcode("SET", "5", "HL");
            case 0xef:
                return consOpcode("SET", "5", "a");
            case 0xf0:
                return consOpcode("SET", "6", "b");
            case 0xf1:
                return consOpcode("SET", "6", "c");
            case 0xf2:
                return consOpcode("SET", "6", "d");
            case 0xf3:
                return consOpcode("SET", "6", "e");
            case 0xf4:
                return consOpcode("SET", "6", "h");
            case 0xf5:
                return consOpcode("SET", "6", "l");
            case 0xf6:
                return consOpcode("SET", "6", "HL");
            case 0xf7:
                return consOpcode("SET", "6", "a");
            case 0xf8:
                return consOpcode("SET", "7", "b");
            case 0xf9:
                return consOpcode("SET", "7", "c");
            case 0xfa:
                return consOpcode("SET", "7", "d");
            case 0xfb:
                return consOpcode("SET", "7", "e");
            case 0xfc:
                return consOpcode("SET", "7", "h");
            case 0xfd:
                return consOpcode("SET", "7", "l");
            case 0xfe:
                return consOpcode("SET", "7", "HL");
            case 0xff:
                return consOpcode("SET", "7", "a");
            default: return consOpcode("NOP");
        }
    }

}

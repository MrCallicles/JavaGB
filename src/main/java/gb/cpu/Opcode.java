//
//
//
package gb.cpu;

class ExecCpu{

    private Cpu cpu = new Cpu();
    private int instruction;
    private long tick;

    public int getInstruction(){ return instruction; }
    public int execInstruction(){

        this.getInstruction();
        this.innerExecInstruction();
        tick += cpu.clock; //ajoute un cycle au nombre ticks
    }

    private void loadInstruction(){
        instruction = cpu.PC();
    }
    //fonctions privées
    private void innerExecInstruction(){
        switch(instruction){
            case 0x00: cpu.NOP(); break;
            case 0x01: cpu.LD_BCnn(); break;
            case 0x02: cpu.LD_aBC(); break;
            case 0x03: cpu.INC_BC(); break;
            case 0x04: cpu.INC_b(); break;
            case 0x05: cpu.DEC_b(); break;
            case 0x06: cpu.LD_bn(); break;
            case 0x07: cpu.RLC_a(); break;
            case 0x08: break; //LD_(a16), SP !!
            case 0x09: cpu.ADD_HLBC(); break;
            case 0x0a: cpu.LD_aBC(); break;
            case 0x0b: cpu.DEC_BC(); break;
            case 0x0c: cpu.INC_c(); break;
            case 0x0d: cpu.DEC_c(); break;
            case 0x0e: cpu.LD_cn(); break;
            case 0x0f: cpu.RRC_a(); break;
            case 0x10: cpu.STOP(); break;
            case 0x11: cpu.LD_DEnn(); break;
            case 0x12: cpu.LD_DEa(); break;
            case 0x13: cpu.INC_DE(); break;
            case 0x14: cpu.INC_d(); break;
            case 0x15: cpu.DEC_d(); break;
            case 0x16: cpu.LD_dn(); break;
            case 0x17: cpu.RL_a(); break;
            case 0x18: cpu.JR_PC(); break;
            case 0x19: cpu.ADD_HLDE(); break;
            case 0x1a: cpu.LD_aDE(); break;
            case 0x1b: cpu.DEC_DE(); break;
            case 0x1c: cpu.INC_e(); break;
            case 0x1d: cpu.DEC_e(); break;
            case 0x1e: cpu.LD_en(); break;
            case 0x1f: cpu.RR_a(); break;
            case 0x20: cpu.JR_fPC(); break;
            case 0x21: cpu.LD_HLnn(); break;
            case 0x22: cpu.LDi_HLa(); break;
            case 0x23: cpu.INC_HL(); break;
            case 0x24: cpu.INC_h(); break;
            case 0x25: cpu.DEC_h(); break;
            case 0x26: cpu.LD_hn(); break;
            case 0x27: cpu.DAA(); break;
            case 0x28: break; //JP_Z,N
            case 0x29: cpu.ADD_HLHL(); break;
            case 0x2a: cpu.LDi_aHL(); break;
            case 0x2b: cpu.DEC_HL(); break;
            case 0x2c: cpu.INC_l(); break;
            case 0x2d: cpu.DEC_l(); break;
            case 0x2e: cpu.LD_ln(); break;
            case 0x2f: cpu.CPL(); break;
            case 0x30: break; //JP_NC,*
            case 0x31: cpu.LD_SPnn(); break;
            case 0x32: cpu.LDd_HLa(); break;
            case 0x33: cpu.INC_SP(); break;
            case 0x34: cpu.INC_HL(); break;
            case 0x35: cpu.DEC_HL(); break;
            case 0x36: cpu.LD_HLn(); break;
            case 0x37: cpu.SCF(); break;
            case 0x38: break; //JR_C,*
            case 0x39: cpu.ADD_HLSP(); break;
            case 0x3a: cpu.LDd_aHL(); break;
            case 0x3b: cpu.DEC_SP(); break;
            case 0x3c: cpu.INC_a(); break;
            case 0x3d: cpu.DEC_a(); break;
            case 0x3e: cpu.LD_an(); break;
            case 0x3f: cpu.CCF(); break;
            case 0x40: cpu.LD_bb(); break;
            case 0x41: cpu.LD_bc(); break;
            case 0x42: cpu.LD_bd(); break;
            case 0x43: cpu.LD_be(); break;
            case 0x44: cpu.LD_bh(); break;
            case 0x45: cpu.LD_bl(); break;
            case 0x46: cpu.LD_bHL(); break;
            case 0x47: cpu.LD_ba(); break;
            case 0x48: cpu.LD_cb(); break;
            case 0x49: cpu.LD_cc(); break;
            case 0x4a: cpu.LD_cd(); break;
            case 0x4b: cpu.LD_ce(); break;
            case 0x4c: cpu.LD_ch(); break;
            case 0x4d: cpu.LD_cl(); break;
            case 0x4e: cpu.LD_cHL(); break;
            case 0x4f: cpu.LD_ca(); break;
            case 0x50: cpu.LD_db(); break;
            case 0x51: cpu.LD_dc(); break;
            case 0x52: cpu.LD_dd(); break;
            case 0x53: cpu.LD_de(); break;
            case 0x54: cpu.LD_dh(); break;
            case 0x55: cpu.LD_dl(); break;
            case 0x56: cpu.LD_dHL(); break;
            case 0x57: cpu.LD_da(); break;
            case 0x58: cpu.LD_eb(); break;
            case 0x59: cpu.LD_ec(); break;
            case 0x5a: cpu.LD_ed(); break;
            case 0x5b: cpu.LD_ee(); break;
            case 0x5c: cpu.LD_eh(); break;
            case 0x5d: cpu.LD_el(); break;
            case 0x5e: cpu.LD_eHL(); break;
            case 0x5f: cpu.LD_ea(); break;
            case 0x60: cpu.LD_hb(); break;
            case 0x61: cpu.LD_hc(); break;
            case 0x62: cpu.LD_hd(); break;
            case 0x63: cpu.LD_he(); break;
            case 0x64: cpu.LD_hh(); break;
            case 0x65: cpu.LD_hl(); break;
            case 0x66: cpu.LD_hHL(); break;
            case 0x67: cpu.LD_ha(); break;
            case 0x68: cpu.LD_lb(); break;
            case 0x69: cpu.LD_lc(); break;
            case 0x6a: cpu.LD_ld(); break;
            case 0x6b: cpu.LD_le(); break;
            case 0x6c: cpu.LD_lh(); break;
            case 0x6d: cpu.LD_ll(); break;
            case 0x6e: cpu.LD_lHL(); break;
            case 0x6f: cpu.LD_la(); break;
            case 0x70: cpu.LD_HLb(); break;
            case 0x71: cpu.LD_HLc(); break;
            case 0x72: cpu.LD_HLd(); break;
            case 0x73: cpu.LD_HLe(); break;
            case 0x74: cpu.LD_HLh(); break;
            case 0x75: cpu.LD_HLl(); break;
            case 0x76: cpu.HALT(); break;
            case 0x77: cpu.LD_HLa(); break;
            case 0x78: cpu.LD_ab(); break;
            case 0x79: cpu.LD_ac(); break;
            case 0x7a: cpu.LD_ad(); break;
            case 0x7b: cpu.LD_ae(); break;
            case 0x7c: cpu.LD_ah(); break;
            case 0x7d: cpu.LD_al(); break;
            case 0x7e: cpu.LD_aHL(); break;
            case 0x7f: cpu.LD_aa(); break;
            case 0x80: cpu.ADD_ab(); break;
            case 0x81: cpu.ADD_ac(); break;
            case 0x82: cpu.ADD_ad(); break;
            case 0x83: cpu.ADD_ae(); break;
            case 0x84: cpu.ADD_ah(); break;
            case 0x85: cpu.ADD_al(); break;
            case 0x86: cpu.ADD_aHL(); break;
            case 0x87: cpu.ADD_aa(); break;
            case 0x88: cpu.ADC_ab(); break;
            case 0x89: cpu.ADC_ac(); break;
            case 0x8a: cpu.ADC_ad(); break;
            case 0x8b: cpu.ADC_ae(); break;
            case 0x8c: cpu.ADC_ah(); break;
            case 0x8d: cpu.ADC_al(); break;
            case 0x8e: cpu.ADC_aHL(); break;
            case 0x8f: cpu.ADC_aa(); break;
            case 0x90: cpu.SUB_ab(); break;
            case 0x91: cpu.SUB_ac(); break;
            case 0x92: cpu.SUB_ad(); break;
            case 0x93: cpu.SUB_ae(); break;
            case 0x94: cpu.SUB_ah(); break;
            case 0x95: cpu.SUB_al(); break;
            case 0x96: cpu.SUB_aHL(); break;
            case 0x97: cpu.SUB_a(); break;
            case 0x98: cpu.SBC_ab(); break;
            case 0x99: cpu.SBC_ac(); break;
            case 0x9a: cpu.SBC_ad(); break;
            case 0x9b: cpu.SBC_ae(); break;
            case 0x9c: cpu.SBC_ah(); break;
            case 0x9d: cpu.SBC_al(); break;
            case 0x9e: cpu.SBC_aHL(); break;
            case 0x9f: cpu.SBC_aa(); break;
            case 0xa0: cpu.AND_ab(); break;
            case 0xa1: cpu.AND_ac(); break;
            case 0xa2: cpu.AND_ad(); break;
            case 0xa3: cpu.AND_ae(); break;
            case 0xa4: cpu.AND_ah(); break;
            case 0xa5: cpu.AND_al(); break;
            case 0xa6: cpu.AND_aHL(); break;
            case 0xa7: cpu.AND_aa(); break;
            case 0xa8: cpu.XOR_ab(); break;
            case 0xa9: cpu.XOR_ac(); break;
            case 0xaa: cpu.XOR_ad(); break;
            case 0xab: cpu.XOR_ae(); break;
            case 0xac: cpu.XOR_ah(); break;
            case 0xad: cpu.XOR_al(); break;
            case 0xae: cpu.XOR_aHL(); break;
            case 0xaf: cpu.XOR_aa(); break;
            case 0xb0: cpu.OR_ab(); break;
            case 0xb1: cpu.OR_ac(); break;
            case 0xb2: cpu.OR_ad(); break;
            case 0xb3: cpu.OR_ae(); break;
            case 0xb4: cpu.OR_ah(); break;
            case 0xb5: cpu.OR_al(); break;
            case 0xb6: cpu.OR_aHL(); break;
            case 0xb7: cpu.OR_aa(); break;
            case 0xb8: cpu.CP_ab(); break;
            case 0xb9: cpu.CP_ac(); break;
            case 0xba: cpu.CP_ad(); break;
            case 0xbb: cpu.CP_ae(); break;
            case 0xbc: cpu.CP_ah(); break;
            case 0xbd: cpu.CP_al(); break;
            case 0xbe: cpu.CP_aHL(); break;
            case 0xbf: cpu.CP_aa(); break;
            case 0xc0: cpu.RET_Z(); break;
            case 0xc1: cpu.POP_BC(); break;
            case 0xc2: break; //JP NZ, a16
            case 0xc3: cpu.JP_PC(); break;
            case 0xc4: cpu.CALL_ZPC(); break;
            case 0xc5: cpu.PUSH_BC(); break;
            case 0xc6: cpu.ADD_aPC(); break;
            case 0xc7: cpu.RST_00(); break;
            case 0xc8: cpu.RET_Z(); break;
            case 0xc9: cpu.RET(); break;
            case 0xca: break; //JP Z, a16
            case 0xcb: innerExecBCFunction(); break;
            case 0xcc: cpu.CALL_ZPC(); break;
            case 0xcd: cpu.CALL_PC(); break;
            case 0xce: cpu.ADC_aPC(); break;
            case 0xcf: cpu.RST_08(); break;
            case 0xd0: cpu.RET_C(); break;
            case 0xd1: cpu.POP_DE(); break;
            case 0xd2: break; // JP NC,a16
            case 0xd3: break;
            case 0xd4: cpu.CALL_CPC(); break;
            case 0xd5: cpu.PUSH_DE(); break;
            case 0xd6: cpu.SUB_aPC(); break;
            case 0xd7: cpu.RST_10(); break;
            case 0xd8: cpu.RET_C(); break;
            case 0xd9: cpu.RETI(); break;
            case 0xda: break; //JP C, a16
            case 0xdb: break;
            case 0xdc: cpu.CALL_CPC(); break;
            case 0xdd: break;
            case 0xde: cpu.SBC_an(); break;
            case 0xdf: cpu.RST_18(); break;
            case 0xe0: cpu.LD_IOa(); break;
            case 0xe1: cpu.POP_HL(); break;
            case 0xe2: break; //LD_(c),a
            case 0xe3: break;
            case 0xe4: break;
            case 0xe5: cpu.PUSH_HL(); break;
            case 0xe6: cpu.AND_aPC(); break;
            case 0xe7: cpu.RST_20(); break;
            case 0xe8: cpu.ADD_SPDD(); break;
            case 0xe9: cpu.JP_HL(); break;
            case 0xea: break; //LD (a16),a
            case 0xeb: break;
            case 0xec: break;
            case 0xed: break;
            case 0xee: cpu.XOR_aPC(); break;
            case 0xef: cpu.RST_28(); break;
            case 0xf0: cpu.LD_aIO(); break;
            case 0xf1: cpu.POP_AF(); break;
            case 0xf2: break; //LD a,(c)
            case 0xf3: cpu.DI(); break;
            case 0xf4: break;
            case 0xf5: cpu.PUSH_AF(); break;
            case 0xf6: cpu.OR_aPC(); break;
            case 0xf7: cpu.RST_30(); break;
            case 0xf8: break; //LD_HL, SP+r8
            case 0xf9: cpu.LD_SPHL(); break;
            case 0xfa: break; //LD_a,(a16)
            case 0xfb: cpu.EI(); break;
            case 0xfc: break;
            case 0xfd: break;
            case 0xfe: cpu.CP_aPC(); break;
            case 0xff: cpu.RST_38(); break;
        }
    }
    private void innerExecBCFunction(){};
}

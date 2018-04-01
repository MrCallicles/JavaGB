//
// Cpu.java
//
package JavaGB.cpu;

import JavaGB.memory.Ram;

class Cpu{
    private Registers _r = new Registers();
    private Ram _memory = new Ram();
    private clock;

    Cpu(){
    }

    /* LD */
    //LD regX from regY
    public void LD_aa(){ _r.setA(_r.getA); clock=1;}
    public void LD_ab(){ _r.setA(_r.getB); clock=1;}
    public void LD_ac(){ _r.setA(_r.getC); clock=1;}
    public void LD_ad(){ _r.setA(_r.getD); clock=1;}
    public void LD_ae(){ _r.setA(_r.getE); clock=1;}
    public void LD_ah(){ _r.setA(_r.getH); clock=1;}
    public void LD_al(){ _r.setA(_r.getL); clock=1;}
    public void LD_ba(){ _r.setB(_r.getA); clock=1;}
    public void LD_bb(){ _r.setB(_r.getB); clock=1;}
    public void LD_bc(){ _r.setB(_r.getC); clock=1;}
    public void LD_bd(){ _r.setB(_r.getD); clock=1;}
    public void LD_be(){ _r.setB(_r.getE); clock=1;}
    public void LD_bh(){ _r.setB(_r.getH); clock=1;}
    public void LD_bl(){ _r.setB(_r.getL); clock=1;}
    public void LD_ca(){ _r.setC(_r.getA); clock=1;}
    public void LD_cb(){ _r.setC(_r.getB); clock=1;}
    public void LD_cc(){ _r.setC(_r.getC); clock=1;}
    public void LD_cd(){ _r.setC(_r.getD); clock=1;}
    public void LD_ce(){ _r.setC(_r.getE); clock=1;}
    public void LD_ch(){ _r.setC(_r.getH); clock=1;}
    public void LD_cl(){ _r.setC(_r.getL); clock=1;}
    public void LD_da(){ _r.setD(_r.getA); clock=1;}
    public void LD_db(){ _r.setD(_r.getB); clock=1;}
    public void LD_dc(){ _r.setD(_r.getC); clock=1;}
    public void LD_dd(){ _r.setD(_r.getD); clock=1;}
    public void LD_de(){ _r.setD(_r.getE); clock=1;}
    public void LD_dh(){ _r.setD(_r.getH); clock=1;}
    public void LD_dl(){ _r.setD(_r.getL); clock=1;}
    public void LD_ea(){ _r.setE(_r.getA); clock=1;}
    public void LD_eb(){ _r.setE(_r.getB); clock=1;}
    public void LD_ec(){ _r.setE(_r.getC); clock=1;}
    public void LD_ed(){ _r.setE(_r.getD); clock=1;}
    public void LD_ee(){ _r.setE(_r.getE); clock=1;}
    public void LD_eh(){ _r.setE(_r.getH); clock=1;}
    public void LD_el(){ _r.setE(_r.getL); clock=1;}
    public void LD_ha(){ _r.setH(_r.getA); clock=1;}
    public void LD_hb(){ _r.setH(_r.getB); clock=1;}
    public void LD_hc(){ _r.setH(_r.getC); clock=1;}
    public void LD_hd(){ _r.setH(_r.getD); clock=1;}
    public void LD_he(){ _r.setH(_r.getE); clock=1;}
    public void LD_hh(){ _r.setH(_r.getH); clock=1;}
    public void LD_hl(){ _r.setH(_r.getL); clock=1;}
    public void LD_la(){ _r.setH(_r.getA); clock=1;}
    public void LD_lb(){ _r.setH(_r.getB); clock=1;}
    public void LD_lc(){ _r.setH(_r.getC); clock=1;}
    public void LD_ld(){ _r.setH(_r.getD); clock=1;}
    public void LD_le(){ _r.setH(_r.getE); clock=1;}
    public void LD_lh(){ _r.setH(_r.getH); clock=1;}
    public void LD_ll(){ _r.setH(_r.getL); clock=1;}

    //LD regX from PC (n)
    ///!\ le pointeurCounter pointe sur l'instruction d'après
    public void LD_an(){_r.setA(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2;}
    public void LD_bn(){_r.setB(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2;}
    public void LD_cn(){_r.setC(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2;}
    public void LD_dn(){_r.setD(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2;}
    public void LD_en(){_r.setE(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2;}
    public void LD_hn(){_r.setH(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2;}
    public void LD_ln(){_r.setL(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2;}

    //LD regX from (HL) et inversement
    public void LD_aHL(){_r.setA(_memory.getByte(_r.getHL()));clock=2;}
    public void LD_bHL(){_r.setB(_memory.getByte(_r.getHL()));clock=2;}
    public void LD_cHL(){_r.setC(_memory.getByte(_r.getHL()));clock=2;}
    public void LD_dHL(){_r.setD(_memory.getByte(_r.getHL()));clock=2;}
    public void LD_eHL(){_r.setE(_memory.getByte(_r.getHL()));clock=2;}
    public void LD_hHL(){_r.setH(_memory.getByte(_r.getHL()));clock=2;}
    public void LD_lHL(){_r.setL(_memory.getByte(_r.getHL()));clock=2;}
    public void LD_HLa(){_memory.setByte(_r.getHL(), _rgetA);clock=2;}
    public void LD_HLb(){_memory.setByte(_r.getHL(), _rgetB);clock=2;}
    public void LD_HLc(){_memory.setByte(_r.getHL(), _rgetC);clock=2;}
    public void LD_HLd(){_memory.setByte(_r.getHL(), _rgetD);clock=2;}
    public void LD_HLe(){_memory.setByte(_r.getHL(), _rgetE);clock=2;}
    public void LD_HLh(){_memory.setByte(_r.getHL(), _rgetH);clock=2;}
    public void LD_HLl(){_memory.setByte(_r.getHL(), _rgetL);clock=2;}

    //LD (HL) from PC (n)
    public void LD_HLPC(){_memory.setWord(_r.getHL(), _r.getPC()); _r.incrementPC();clock=3;}

    //LD a BC DE
    public void LD_aBC(){_r.setA(_memory.getByte(_r.getBC()));clock=2;}
    public void LD_aDE(){_r.setA(_memory.getByte(_r.getDE()));clock=2;}
    //LD a (nn) ???
    public void LD_BCa(){_memory.setWord(_r.getBC(), _rgetA);clock=2;}
    public void LD_DEa(){_memory.setWord(_r.getDE(), _rgetA);clock=2;}
    //LD (nn) a ???

    //LD A from/to (FF00 + pc (n)) io-port
    public void LD_aIO(){_r.setA(_memory.getByte(0xFF + _r.getPC())); _r.incrementPC();clock=3;}
    public void LD_IOa(){_memory.setByte(0xFF + _r.getPC(), _r.getA); _r.incrementPC();clock=3;}
    //LD a from/to (FF00 + C) ???
    public void LDi_HLa(){_memory.setByte(_r.getHL(), _r.getA); _r.incrementHL(); clock=2;}
    public void LDi_aHL(){_r.setA(_memory.getByte(_r.getHL())); _r.incrementHL(); clock=2;}
    public void LDd_HLa(){ _r.decrementHL(); _memory.setByte(_r.getHL(), _r.getA);clock=2;}
    public void LDd_aHL(){ _r.decrementHL(); _r.setA(_memory.getByte(_r.getHL()));clock=2;}

    //LD rr,nn
    public void LD_BCnn(){_r.setBC(_memory.getWord(_r.getPC())); _r.incrementPC2();clock=3;}
    public void LD_DEnn(){_r.setDE(_memory.getWord(_r.getPC())); _r.incrementPC2();clock=3;}
    public void LD_HLnn(){_r.setHL(_memory.getWord(_r.getPC())); _r.incrementPC2();clock=3;}
    public void LD_SPnn(){_r.setSP(_memory.getWord(_r.getPC())); _r.incrementPC2();clock=3;}

    public void LD_SPHL(){_r.setSP(_memory.getWord(_r.getHL()));clock=2;}

    public void PUSH_BC(){_r.decrementSP2(); _memory.setWord(_r.getSP(), _r.getBC());clock=4;}
    public void PUSH_DE(){_r.decrementSP2(); _memory.setWord(_r.getSP(), _r.getDE());clock=4;}
    public void PUSH_HL(){_r.decrementSP2(); _memory.setWord(_r.getSP(), _r.getHL());clock=4;}
    public void PUSH_AF(){_r.decrementSP2(); _memory.setWord(_r.getSP(), _r.getAF());clock=4;}

    public void POP_BC(){_memory.setWord(_r.getSP(), _r.getBC());_r.incrementSP2();clock=3;}
    public void POP_DE(){_memory.setWord(_r.getSP(), _r.getDE());_r.incrementSP2();clock=3;}
    public void POP_HL(){_memory.setWord(_r.getSP(), _r.getHL());_r.incrementSP2();clock=3;}
    public void POP_AF(){_memory.setWord(_r.getSP(), _r.getAF());_r.incrementSP2();clock=3;}

    /* Arithmetics/Logic */
    //add a,r
    public void ADD_aa(){
        int result = 0;
        result = _r.getA() + _r.getA();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ab(){
        int result = 0;
        result = _r.getA() + _r.getB();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ac(){
        int result = 0;
        result = _r.getA() + _r.getC();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ad(){
        int result = 0;
        result = _r.getA() + _r.getD();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ae(){
        int result = 0;
        result = _r.getA() + _r.getD();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ah(){
        int result = 0;
        result = _r.getA() + _r.getH();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_al(){
        int result = 0;
        result = _r.getA() + _r.getL();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }

    //add a,Pc
    public void ADD_aPC(){
        int result = 0;
        result = _r.getA() + _r.getPC();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        _r.incrementPC();
        clock=2;
    }
    //add a, HL
    public void ADD_aHL(){
        int result = 0;
        result = _r.getA() + _memory.getByte(_r.getHL());
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=2;
    }

    //ADC a,r
    public void ADC_aa(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _r.getA() + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ab(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _r.getB() + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ac(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _r.getC() + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ad(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _r.getD() + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ae(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _r.getE() + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ah(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _r.getH() + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_al(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _r.getL() + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }

    //adc a,pc
    public void ADC_aPC(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _r.getPC() + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        _r.incrementPC();
        clock=2;
    }
    public void ADD_aHL(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() + _memory.getByte(_r.getHL()) + carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=2;
    }

    //sub a,r
    public void SUB_aa(){
        int result = 0;
        result = _r.getA() - _r.getA();
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ab(){
        int result = 0;
        result = _r.getA() - _r.getB();
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ac(){
        int result = 0;
        result = _r.getA() - _r.getC();
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ad(){
        int result = 0;
        result = _r.getA() - _r.getD();
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ae(){
        int result = 0;
        result = _r.getA() - _r.getE();
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ah(){
        int result = 0;
        result = _r.getA() - _r.getH();
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_al(){
        int result = 0;
        result = _r.getA() - _r.getL();
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }

    //sub a,Pc
    public void SUB_aPC(){
        int result = 0;
        result = _r.getA() - _r.getPC();
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        _r.incrementPC();
        clock=2;
    }
    //sub a, HL
    public void SUB_aHL(){
        int result = 0;
        result = _r.getA() - _memory.getByte(_r.getHL());
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=2;
    }

    //sbC a,r
    public void SBC_aa(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _r.getA() - carry;
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ab(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _r.getB() - carry;
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ac(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _r.getC() - carry;
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ad(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _r.getD() - carry;
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ae(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _r.getE() - carry;
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ah(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _r.getH() - carry;
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_al(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _r.getL() - carry;
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=1;
    }

    //sbc a,pc
    public void SBC_aPC(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _r.getPC() - carry;
        result < 0x0 ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        _r.incrementPC();
        clock=2;
    }
    //sbc a,hl
    public void ADD_aHL(){
        int result = 0;
        int carry = 0;
        _r.getCFlag() ? carry = 1: carry = 0;
        result = _r.getA() - _memory.getByte(_r.getHL()) - carry;
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        ((result & 0xFF) == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.setA(result & 0xFF);
        clock=2;
    }

    //and a,r
    public void AND_aa(){_r.setA((_r.getA & _r.getA) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void AND_ab(){_r.setA((_r.getA & _r.getB) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void AND_ac(){_r.setA((_r.getA & _r.getC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void AND_ad(){_r.setA((_r.getA & _r.getD) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void AND_ae(){_r.setA((_r.getA & _r.getE) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void AND_ah(){_r.setA((_r.getA & _r.getH) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void AND_al(){_r.setA((_r.getA & _r.getL) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}

    //and a,pc
    public void AND_aPC(){_r.setA((_r.getA & _r.getPC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false); _r.incrementPC();}
    //and a,hl
    public void AND_aHL(){_r.setA((_r.getA & _memory.getByte(_r.getHL())) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}

    //xor a,r
    public void XOR_aa(){_r.setA((_r.getA ^ _r.getA) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void XOR_ab(){_r.setA((_r.getA ^ _r.getB) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void XOR_ac(){_r.setA((_r.getA ^ _r.getC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void XOR_ad(){_r.setA((_r.getA ^ _r.getD) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void XOR_ae(){_r.setA((_r.getA ^ _r.getE) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void XOR_ah(){_r.setA((_r.getA ^ _r.getH) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void XOR_al(){_r.setA((_r.getA ^ _r.getL) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}

    //xor a,pc
    public void XOR_aPC(){_r.setA((_r.getA ^ _r.getPC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false); _r.incrementPC();}
    //xor a,hl
    public void AND_aHL(){_r.setA((_r.getA ^ _memory.getByte(_r.getHL())) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}

    //or a,r
    public void OR_aa(){_r.setA((_r.getA | _r.getA) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void OR_ab(){_r.setA((_r.getA | _r.getB) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void OR_ac(){_r.setA((_r.getA | _r.getC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void OR_ad(){_r.setA((_r.getA | _r.getD) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void OR_ae(){_r.setA((_r.getA | _r.getE) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void OR_ah(){_r.setA((_r.getA | _r.getH) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}
    public void OR_al(){_r.setA((_r.getA | _r.getL) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}

    //or a,pc
    public void AND_aPC(){_r.setA((_r.getA | _r.getPC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false); _r.incrementPC();}
    //or a,hl
    public void AND_aHL(){_r.setA((_r.getA | _memory.getByte(_r.getHL())) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);}

    //compare a - r
    public void CP_aa(){}

}

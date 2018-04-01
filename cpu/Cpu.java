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
    public void AND_aa(){_r.setA((_r.getA & _r.getA) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void AND_ab(){_r.setA((_r.getA & _r.getB) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void AND_ac(){_r.setA((_r.getA & _r.getC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void AND_ad(){_r.setA((_r.getA & _r.getD) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void AND_ae(){_r.setA((_r.getA & _r.getE) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void AND_ah(){_r.setA((_r.getA & _r.getH) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void AND_al(){_r.setA((_r.getA & _r.getL) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}

    //and a,pc
    public void AND_aPC(){_r.setA((_r.getA & _r.getPC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false); _r.incrementPC();clock=2;}
    //and a,hl
    public void AND_aHL(){_r.setA((_r.getA & _memory.getByte(_r.getHL())) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=2;}

    //xor a,r
    public void XOR_aa(){_r.setA((_r.getA ^ _r.getA) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void XOR_ab(){_r.setA((_r.getA ^ _r.getB) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void XOR_ac(){_r.setA((_r.getA ^ _r.getC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void XOR_ad(){_r.setA((_r.getA ^ _r.getD) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void XOR_ae(){_r.setA((_r.getA ^ _r.getE) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void XOR_ah(){_r.setA((_r.getA ^ _r.getH) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void XOR_al(){_r.setA((_r.getA ^ _r.getL) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}

    //xor a,pc
    public void XOR_aPC(){_r.setA((_r.getA ^ _r.getPC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false); _r.incrementPC();clock=2;}
    //xor a,hl
    public void AND_aHL(){_r.setA((_r.getA ^ _memory.getByte(_r.getHL())) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=2;}

    //or a,r
    public void OR_aa(){_r.setA((_r.getA | _r.getA) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void OR_ab(){_r.setA((_r.getA | _r.getB) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void OR_ac(){_r.setA((_r.getA | _r.getC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void OR_ad(){_r.setA((_r.getA | _r.getD) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void OR_ae(){_r.setA((_r.getA | _r.getE) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void OR_ah(){_r.setA((_r.getA | _r.getH) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}
    public void OR_al(){_r.setA((_r.getA | _r.getL) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=1;}

    //or a,pc
    public void AND_aPC(){_r.setA((_r.getA | _r.getPC) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false); _r.incrementPC();clock=2;}
    //or a,hl
    public void AND_aHL(){_r.setA((_r.getA | _memory.getByte(_r.getHL())) & 0xff); _r.getA() == 0 ? _r.setZFlag(true):_r.setZFlag(false);clock=2;}

    //compare a - r
    //VÉFIRIER QUE ÇA FONCTIONNE BIEN !
    public void CP_aa(){
        int result = _r.getA - _r.getA;
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        clock=1;
    }
    public void CP_ab(){
        int result = _r.getA - _r.getB;
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        clock=1;
    }
    public void CP_ac(){
        int result = _r.getA - _r.getC;
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        clock=1;
    }
    public void CP_ad(){
        int result = _r.getA - _r.getC;
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        clock=1;
    }
    public void CP_ae(){
        int result = _r.getA - _r.getC;
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        clock=1;
    }
    public void CP_ah(){
        int result = _r.getA - _r.getC;
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        clock=1;
    }
    public void CP_al(){
        int result = _r.getA - _r.getC;
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        clock=1;
    }

    public void CP_aPC(){
        int result = _r.getA - _r.getPC;
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.incrementPC();
        clock=2;
    }
    public void CP_aHL(){
        int result = _r.getA - _memory.getByte(_r.getHL());
        (result < 0) ? _r.setCFlag(true): _r.setCFlag(false);
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true): _r.setZFlag(false);
        _r.incrementPC();
        clock=2;
    }

    //inc r
    public void INC_a(){_r.setA((_r.getA() + 1) & 0xff); (_r.getA() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void INC_b(){_r.setB((_r.getB() + 1) & 0xff); (_r.getB() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void INC_c(){_r.setC((_r.getC() + 1) & 0xff); (_r.getC() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void INC_d(){_r.setD((_r.getD() + 1) & 0xff); (_r.getD() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void INC_e(){_r.setE((_r.getE() + 1) & 0xff); (_r.getE() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void INC_h(){_r.setH((_r.getH() + 1) & 0xff); (_r.getH() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void INC_l(){_r.setL((_r.getL() + 1) & 0xff); (_r.getL() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    //dec (hl)
    public void INC_HL(){_memory.setByte(_r.getHL(), (_r.getHL + 1) & 0xff); (_memory.getByte(_r.getHL()) == 0) ? _r.setZFlag(true); _r.setZFlag(false);clock=3;}

    //dec r
    public void DEC_a(){_r.setA((_r.getA() - 1) & 0xff); (_r.getA() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void DEC_b(){_r.setB((_r.getB() - 1) & 0xff); (_r.getB() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void DEC_c(){_r.setC((_r.getC() - 1) & 0xff); (_r.getC() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void DEC_d(){_r.setD((_r.getD() - 1) & 0xff); (_r.getD() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void DEC_e(){_r.setE((_r.getE() - 1) & 0xff); (_r.getE() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void DEC_h(){_r.setH((_r.getH() - 1) & 0xff); (_r.getH() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    public void DEC_l(){_r.setL((_r.getL() - 1) & 0xff); (_r.getL() == 0) ? _r.setZFlag(true): _r.setZFlag(false);clock=1;}
    //dec (hl)
    public void INC_HL(){_memory.setByte(_r.getHL(), (_r.getHL - 1) & 0xff); (_memory.getByte(_r.getHL()) == 0) ? _r.setZFlag(true); _r.setZFlag(false);clock=3;}

    //daa ????
    public void DAA(){}

    //CPL
    public void CPL(){_r.setA(_r.regA() ^ 0xFF);clock=1;}

    //add HL,rr
    public void ADD_HLBC(){
        int result = 0;
        result = _r.getHL() + _r.getBC();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        _r.setHL(result & 0xFFFF);
        clock=2;
    }
    public void ADD_HLDE(){
        int result = 0;
        result = _r.getHL() + _r.getDE();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        _r.setHL(result & 0xFFFF);
        clock=2;
    }
    public void ADD_HLHL(){
        int result = 0;
        result = _r.getHL() + _r.getHL();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        _r.setHL(result & 0xFFFF);
        clock=2;
    }
    public void ADD_HLSP(){
        int result = 0;
        result = _r.getHL() + _r.getSP();
        result > 0xFF ? _r.setCFlag(true) : _r.setCFlag(false);
        _r.setHL(result & 0xFFFF);
        clock=2;
    }
    //inc rr
    public void INC_BC(){_r.incrementBC();clock=2;}
    public void INC_DE(){_r.incrementDE();clock=2;}
    public void INC_HL(){_r.incrementHL();clock=2;}
    public void INC_SP(){_r.incrementSP();clock=2;}
    //dec rr
    public void DEC_BC(){_r.decrementBC();clock=2;}
    public void DEC_DE(){_r.decrementDE();clock=2;}
    public void DEC_HL(){_r.decrementHL();clock=2;}
    public void DEC_SP(){_r.decrementSP();clock=2;}

    //add SP,dd (signed number)
    public void ADD_SPDD(){
        int result = _memory.getByte(_r.getPC());
        if (result > 127) result = -((~i+1)&255);
        _r.incrementPC();
        _r.setSP(_r.getSP() += result);
        clock=4;
    }

    public void LD_HLSPDD(){
        int result = _memory.getByte(_r.getPC());
        if (result > 127) result = -((~i+1)&255);
        _r.incrementPC();
        _r.setSP(_r.getSP() += result);
        _r.setH((result >> 8) & 255);
        _r.setL((result & 255));
        clock=3;
    }

    /* rotate/shift commands */ // à finir !!!!
    public void RLCA(){
        int result = _r.getA() << 1;
        if (result > 0xff) { _r.setCFlag(true); result |= 1;}
        result = result & 0xff;
        (result == 0) ? _r.setZFlag(true) : _r.setZFlag(false);
        clock=1;
    }
    public void RLA(){
        (_r.getA() & 0x80) == 0x80 ? _r.setZFlag(true) : _r.setZFlag(false);
        int result = _r.getA() << 1;
        _r.getCFlag() ? result = result | 1: ;
        _r.setA(result & 0xff);
        (_r.getA() == 0) ? _r.getZFlag(true) : _r.getZFlag(false);
        clock=1;
    }
    public void RRCA(){
    }
    public void RRA(){}
    public void RLC_r(){}
    public void RLC_HL(){}
    public void RL_r(){}
    public void RL_HL(){}
    public void RRC_r(){}
    public void RRC_HL(){}
    public void RR_r(){}
    public void RR_HL(){}
    public void SLA_r(){}
    public void SLA_HL(){}
    public void SWAP_r(){}
    public void SWAP_HL(){}
    public void SRA_r(){}
    public void SRA_HL(){}
    public void SRL_r(){}
    public void SRL_HL(){}

    /* singlebit operations */
    public void BIT_0a(){ (_r.getA() & 1) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_1a(){ (_r.getA() & 2) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_2a(){ (_r.getA() & 4) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_3a(){ (_r.getA() & 8) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_4a(){ (_r.getA() & 16) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_5a(){ (_r.getA() & 32) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_6a(){ (_r.getA() & 64) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_7a(){ (_r.getA() & 128) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}

    public void BIT_0b(){ (_r.getB() & 1) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_1b(){ (_r.getB() & 2) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_2b(){ (_r.getB() & 4) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_3b(){ (_r.getB() & 8) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_4b(){ (_r.getB() & 16) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_5b(){ (_r.getB() & 32) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_6b(){ (_r.getB() & 64) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_7b(){ (_r.getB() & 128) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}

    public void BIT_0c(){ (_r.getC() & 1) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_1c(){ (_r.getC() & 2) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_2c(){ (_r.getC() & 4) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_3c(){ (_r.getC() & 8) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_4c(){ (_r.getC() & 16) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_5c(){ (_r.getC() & 32) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_6c(){ (_r.getC() & 64) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_7c(){ (_r.getC() & 128) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}

    public void BIT_0d(){ (_r.getD() & 1) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_1d(){ (_r.getD() & 2) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_2d(){ (_r.getD() & 4) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_3d(){ (_r.getD() & 8) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_4d(){ (_r.getD() & 16) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_5d(){ (_r.getD() & 32) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_6d(){ (_r.getD() & 64) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_7d(){ (_r.getD() & 128) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}

    public void BIT_0e(){ (_r.getE() & 1) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_1e(){ (_r.getE() & 2) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_2e(){ (_r.getE() & 4) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_3e(){ (_r.getE() & 8) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_4e(){ (_r.getE() & 16) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_5e(){ (_r.getE() & 32) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_6e(){ (_r.getE() & 64) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_7e(){ (_r.getE() & 128) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}

    public void BIT_0h(){ (_r.getH() & 1) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_1h(){ (_r.getH() & 2) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_2h(){ (_r.getH() & 4) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_3h(){ (_r.getH() & 8) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_4h(){ (_r.getH() & 16) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_5h(){ (_r.getH() & 32) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_6h(){ (_r.getH() & 64) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_7h(){ (_r.getH() & 128) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}

    public void BIT_0l(){ (_r.getL() & 1) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_1l(){ (_r.getL() & 2) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_2l(){ (_r.getL() & 4) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_3l(){ (_r.getL() & 8) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_4l(){ (_r.getL() & 16) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_5l(){ (_r.getL() & 32) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_6l(){ (_r.getL() & 64) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}
    public void BIT_7l(){ (_r.getL() & 128) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=2;}

    public void BIT_0HL(){ (_memory.getByte(_r.getHL()) & 1) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=3;}
    public void BIT_1HL(){ (_memory.getByte(_r.getHL()) & 2) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=3;}
    public void BIT_2HL(){ (_memory.getByte(_r.getHL()) & 4) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=3;}
    public void BIT_3HL(){ (_memory.getByte(_r.getHL()) & 8) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=3;}
    public void BIT_4HL(){ (_memory.getByte(_r.getHL()) & 16) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=3;}
    public void BIT_5HL(){ (_memory.getByte(_r.getHL()) & 32) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=3;}
    public void BIT_6HL(){ (_memory.getByte(_r.getHL()) & 64) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=3;}
    public void BIT_7HL(){ (_memory.getByte(_r.getHL()) & 128) == 0 ? _r.setZFlag(true): _r.setZFlag(false);clock=3;}

    public void SET_0a(){_r.setA(_r.getA |= 1);clock=2;}
    public void SET_1a(){_r.setA(_r.getA |= 2);clock=2;}
    public void SET_2a(){_r.setA(_r.getA |= 4);clock=2;}
    public void SET_3a(){_r.setA(_r.getA |= 8);clock=2;}
    public void SET_4a(){_r.setA(_r.getA |= 16);clock=2;}
    public void SET_5a(){_r.setA(_r.getA |= 32);clock=2;}
    public void SET_6a(){_r.setA(_r.getA |= 64);clock=2;}
    public void SET_7a(){_r.setA(_r.getA |= 128);clock=2;}

    public void SET_0b(){_r.setB(_r.getB |= 1);clock=2;}
    public void SET_1b(){_r.setB(_r.getB |= 2);clock=2;}
    public void SET_2b(){_r.setB(_r.getB |= 4);clock=2;}
    public void SET_3b(){_r.setB(_r.getB |= 8);clock=2;}
    public void SET_4b(){_r.setB(_r.getB |= 16);clock=2;}
    public void SET_5b(){_r.setB(_r.getB |= 32);clock=2;}
    public void SET_6b(){_r.setB(_r.getB |= 64);clock=2;}
    public void SET_7b(){_r.setB(_r.getB |= 128);clock=2;}

    public void SET_0c(){_r.setC(_r.getC |= 1);clock=2;}
    public void SET_1c(){_r.setC(_r.getC |= 2);clock=2;}
    public void SET_2c(){_r.setC(_r.getC |= 4);clock=2;}
    public void SET_3c(){_r.setC(_r.getC |= 8);clock=2;}
    public void SET_4c(){_r.setC(_r.getC |= 16);clock=2;}
    public void SET_5c(){_r.setC(_r.getC |= 32);clock=2;}
    public void SET_6c(){_r.setC(_r.getC |= 64);clock=2;}
    public void SET_7c(){_r.setC(_r.getC |= 128);clock=2;}

    public void SET_0d(){_r.setD(_r.getD |= 1);clock=2;}
    public void SET_1d(){_r.setD(_r.getD |= 2);clock=2;}
    public void SET_2d(){_r.setD(_r.getD |= 4);clock=2;}
    public void SET_3d(){_r.setD(_r.getD |= 8);clock=2;}
    public void SET_4d(){_r.setD(_r.getD |= 16);clock=2;}
    public void SET_5d(){_r.setD(_r.getD |= 32);clock=2;}
    public void SET_6d(){_r.setD(_r.getD |= 64);clock=2;}
    public void SET_7d(){_r.setD(_r.getD |= 128);clock=2;}

    public void SET_0e(){_r.setE(_r.getE |= 1);clock=2;}
    public void SET_1e(){_r.setE(_r.getE |= 2);clock=2;}
    public void SET_2e(){_r.setE(_r.getE |= 4);clock=2;}
    public void SET_3e(){_r.setE(_r.getE |= 8);clock=2;}
    public void SET_4e(){_r.setE(_r.getE |= 16);clock=2;}
    public void SET_5e(){_r.setE(_r.getE |= 32);clock=2;}
    public void SET_6e(){_r.setE(_r.getE |= 64);clock=2;}
    public void SET_7e(){_r.setE(_r.getE |= 128);clock=2;}

    public void SET_0h(){_r.setH(_r.getH |= 1);clock=2;}
    public void SET_1h(){_r.setH(_r.getH |= 2);clock=2;}
    public void SET_2h(){_r.setH(_r.getH |= 4);clock=2;}
    public void SET_3h(){_r.setH(_r.getH |= 8);clock=2;}
    public void SET_4h(){_r.setH(_r.getH |= 16);clock=2;}
    public void SET_5h(){_r.setH(_r.getH |= 32);clock=2;}
    public void SET_6h(){_r.setH(_r.getH |= 64);clock=2;}
    public void SET_7h(){_r.setH(_r.getH |= 128);clock=2;}

    public void SET_0l(){_r.setL(_r.getL |= 1);clock=2;}
    public void SET_1l(){_r.setL(_r.getL |= 2);clock=2;}
    public void SET_2l(){_r.setL(_r.getL |= 4);clock=2;}
    public void SET_3l(){_r.setL(_r.getL |= 8);clock=2;}
    public void SET_4l(){_r.setL(_r.getL |= 16);clock=2;}
    public void SET_5l(){_r.setL(_r.getL |= 32);clock=2;}
    public void SET_6l(){_r.setL(_r.getL |= 64);clock=2;}
    public void SET_7l(){_r.setL(_r.getL |= 128);clock=2;}

    public void SET_0HL(){_memory.setByte(_r.getHl(), _r.getHL() |= 1);clock=4;}
    public void SET_1HL(){_memory.setByte(_r.getHl(), _r.getHL() |= 2);clock=4;}
    public void SET_2HL(){_memory.setByte(_r.getHl(), _r.getHL() |= 4);clock=4;}
    public void SET_3HL(){_memory.setByte(_r.getHl(), _r.getHL() |= 8);clock=4;}
    public void SET_4HL(){_memory.setByte(_r.getHl(), _r.getHL() |= 16);clock=4;}
    public void SET_5HL(){_memory.setByte(_r.getHl(), _r.getHL() |= 32);clock=4;}
    public void SET_6HL(){_memory.setByte(_r.getHl(), _r.getHL() |= 64);clock=4;}
    public void SET_7HL(){_memory.setByte(_r.getHl(), _r.getHL() |= 128);clock=4;}

    public void RES_0a(){_r.setA(_r.getA() & 0xFE);clock=2;}
    public void RES_1a(){_r.setA(_r.getA() & 0xFD);clock=2;}
    public void RES_2a(){_r.setA(_r.getA() & 0xFB);clock=2;}
    public void RES_3a(){_r.setA(_r.getA() & 0xF7);clock=2;}
    public void RES_4a(){_r.setA(_r.getA() & 0xEF);clock=2;}
    public void RES_5a(){_r.setA(_r.getA() & 0xDF);clock=2;}
    public void RES_6a(){_r.setA(_r.getA() & 0xBF);clock=2;}
    public void RES_7a(){_r.setA(_r.getA() & 0x7F);clock=2;}

    public void RES_0b(){_r.setB(_r.getB() & 0xFE);clock=2;}
    public void RES_1b(){_r.setB(_r.getB() & 0xFD);clock=2;}
    public void RES_2b(){_r.setB(_r.getB() & 0xFB);clock=2;}
    public void RES_3b(){_r.setB(_r.getB() & 0xF7);clock=2;}
    public void RES_4b(){_r.setB(_r.getB() & 0xEF);clock=2;}
    public void RES_5b(){_r.setB(_r.getB() & 0xDF);clock=2;}
    public void RES_6b(){_r.setB(_r.getB() & 0xBF);clock=2;}
    public void RES_7b(){_r.setB(_r.getB() & 0x7F);clock=2;}

    public void RES_0c(){_r.setC(_r.getC() & 0xFE);clock=2;}
    public void RES_1c(){_r.setC(_r.getC() & 0xFD);clock=2;}
    public void RES_2c(){_r.setC(_r.getC() & 0xFC);clock=2;}
    public void RES_3c(){_r.setC(_r.getC() & 0xF7);clock=2;}
    public void RES_4c(){_r.setC(_r.getC() & 0xEF);clock=2;}
    public void RES_5c(){_r.setC(_r.getC() & 0xDF);clock=2;}
    public void RES_6c(){_r.setC(_r.getC() & 0xCF);clock=2;}
    public void RES_7c(){_r.setC(_r.getC() & 0x7F);clock=2;}

    public void RES_0d(){_r.setD(_r.getD() & 0xFE);clock=2;}
    public void RES_1d(){_r.setD(_r.getD() & 0xFD);clock=2;}
    public void RES_2d(){_r.setD(_r.getD() & 0xFD);clock=2;}
    public void RES_3d(){_r.setD(_r.getD() & 0xF7);clock=2;}
    public void RES_4d(){_r.setD(_r.getD() & 0xEF);clock=2;}
    public void RES_5d(){_r.setD(_r.getD() & 0xDF);clock=2;}
    public void RES_6d(){_r.setD(_r.getD() & 0xDF);clock=2;}
    public void RES_7d(){_r.setD(_r.getD() & 0x7F);clock=2;}

    public void RES_0e(){_r.setE(_r.getE() & 0xFE);clock=2;}
    public void RES_1e(){_r.setE(_r.getE() & 0xFE);clock=2;}
    public void RES_2e(){_r.setE(_r.getE() & 0xFE);clock=2;}
    public void RES_3e(){_r.setE(_r.getE() & 0xF7);clock=2;}
    public void RES_4e(){_r.setE(_r.getE() & 0xEF);clock=2;}
    public void RES_5e(){_r.setE(_r.getE() & 0xEF);clock=2;}
    public void RES_6e(){_r.setE(_r.getE() & 0xEF);clock=2;}
    public void RES_7e(){_r.setE(_r.getE() & 0x7F);clock=2;}

    public void RES_0h(){_r.setH(_r.getH() & 0xFE);clock=2;}
    public void RES_1h(){_r.setH(_r.getH() & 0xFE);clock=2;}
    public void RES_2h(){_r.setH(_r.getH() & 0xFE);clock=2;}
    public void RES_3h(){_r.setH(_r.getH() & 0xF7);clock=2;}
    public void RES_4h(){_r.setH(_r.getH() & 0xEF);clock=2;}
    public void RES_5h(){_r.setH(_r.getH() & 0xEF);clock=2;}
    public void RES_6h(){_r.setH(_r.getH() & 0xEF);clock=2;}
    public void RES_7h(){_r.setH(_r.getH() & 0x7F);clock=2;}

    public void RES_0l(){_r.setL(_r.getL() & 0xFE);clock=2;}
    public void RES_1l(){_r.setL(_r.getL() & 0xFE);clock=2;}
    public void RES_2l(){_r.setL(_r.getL() & 0xFE);clock=2;}
    public void RES_3l(){_r.setL(_r.getL() & 0xF7);clock=2;}
    public void RES_4l(){_r.setL(_r.getL() & 0xEF);clock=2;}
    public void RES_5l(){_r.setL(_r.getL() & 0xEF);clock=2;}
    public void RES_6l(){_r.setL(_r.getL() & 0xEF);clock=2;}
    public void RES_7l(){_r.setL(_r.getL() & 0x7F);clock=2;}

    public void RES_0HL(){_memory.setByte(_r.getHl(), _r.getHL() & 0xFE);clock=4;}
    public void RES_1HL(){_memory.setByte(_r.getHl(), _r.getHL() & 0xFE);clock=4;}
    public void RES_2HL(){_memory.setByte(_r.getHl(), _r.getHL() & 0xFE);clock=4;}
    public void RES_3HL(){_memory.setByte(_r.getHl(), _r.getHL() & 0xF7);clock=4;}
    public void RES_4HL(){_memory.setByte(_r.getHl(), _r.getHL() & 0xEF);clock=4;}
    public void RES_5HL(){_memory.setByte(_r.getHl(), _r.getHL() & 0xEF);clock=4;}
    public void RES_6HL(){_memory.setByte(_r.getHl(), _r.getHL() & 0xEF);clock=4;}
    public void RES_7HL(){_memory.setByte(_r.getHl(), _r.getHL() & 0x7F);clock=4;}

    /* CPU-controlcommand */
    public void CCF(){_r.getCFlag() ? _r.setCFlag(false) : _r.setCFlag(true);clock=1;}
    public void SCF(){_r.setCFlag(true);clock=1;}
    public void NOP(){clock=1;}
    public void HALT(){clock=1;}
    public void STOP(){clock=1;}
    public void DI(){_r.setIME(false);}
    public void EI(){_r.setIME(true);}


    /* Jump commands */
    public void JP_PC(){
        int result = _r.getPC();
        _r.incrementPC();
        result = (result << 8) + _r.getPC();
        _r.setPC(result);
        _r.incrementPC();
        clock=4;
    }
    public void JP_HL(){ _r.setPC(_r.getHL()); }
    public void JP_fPC(){}
    public void JR(){}
    public void JR(){}
    public void Call_PC(){}
    public void Call_FPC(){}
    public void RET(){}
    public void RET_F(){}
    public void RETI(){}
    public void RST(){}
}




//
// Cpu.java
// manque daa, ld_nn_a
//
package JavaGB.cpu;

import JavaGB.memory.Ram;

class Cpu{
    private Registers _r = new Registers();
    private Ram _memory = new Ram();
    private int clock;

    /* LD */
    //LD regX from regY
    public void LD_aa(){ _r.setA(_r.getA()); clock=1;}
    public void LD_ab(){ _r.setA(_r.getB()); clock=1;}
    public void LD_ac(){ _r.setA(_r.getC()); clock=1;}
    public void LD_ad(){ _r.setA(_r.getD()); clock=1;}
    public void LD_ae(){ _r.setA(_r.getE()); clock=1;}
    public void LD_ah(){ _r.setA(_r.getH()); clock=1;}
    public void LD_al(){ _r.setA(_r.getL()); clock=1;}
    public void LD_ba(){ _r.setB(_r.getA()); clock=1;}
    public void LD_bb(){ _r.setB(_r.getB()); clock=1;}
    public void LD_bc(){ _r.setB(_r.getC()); clock=1;}
    public void LD_bd(){ _r.setB(_r.getD()); clock=1;}
    public void LD_be(){ _r.setB(_r.getE()); clock=1;}
    public void LD_bh(){ _r.setB(_r.getH()); clock=1;}
    public void LD_bl(){ _r.setB(_r.getL()); clock=1;}
    public void LD_ca(){ _r.setC(_r.getA()); clock=1;}
    public void LD_cb(){ _r.setC(_r.getB()); clock=1;}
    public void LD_cc(){ _r.setC(_r.getC()); clock=1;}
    public void LD_cd(){ _r.setC(_r.getD()); clock=1;}
    public void LD_ce(){ _r.setC(_r.getE()); clock=1;}
    public void LD_ch(){ _r.setC(_r.getH()); clock=1;}
    public void LD_cl(){ _r.setC(_r.getL()); clock=1;}
    public void LD_da(){ _r.setD(_r.getA()); clock=1;}
    public void LD_db(){ _r.setD(_r.getB()); clock=1;}
    public void LD_dc(){ _r.setD(_r.getC()); clock=1;}
    public void LD_dd(){ _r.setD(_r.getD()); clock=1;}
    public void LD_de(){ _r.setD(_r.getE()); clock=1;}
    public void LD_dh(){ _r.setD(_r.getH()); clock=1;}
    public void LD_dl(){ _r.setD(_r.getL()); clock=1;}
    public void LD_ea(){ _r.setE(_r.getA()); clock=1;}
    public void LD_eb(){ _r.setE(_r.getB()); clock=1;}
    public void LD_ec(){ _r.setE(_r.getC()); clock=1;}
    public void LD_ed(){ _r.setE(_r.getD()); clock=1;}
    public void LD_ee(){ _r.setE(_r.getE()); clock=1;}
    public void LD_eh(){ _r.setE(_r.getH()); clock=1;}
    public void LD_el(){ _r.setE(_r.getL()); clock=1;}
    public void LD_ha(){ _r.setH(_r.getA()); clock=1;}
    public void LD_hb(){ _r.setH(_r.getB()); clock=1;}
    public void LD_hc(){ _r.setH(_r.getC()); clock=1;}
    public void LD_hd(){ _r.setH(_r.getD()); clock=1;}
    public void LD_he(){ _r.setH(_r.getE()); clock=1;}
    public void LD_hh(){ _r.setH(_r.getH()); clock=1;}
    public void LD_hl(){ _r.setH(_r.getL()); clock=1;}
    public void LD_la(){ _r.setH(_r.getA()); clock=1;}
    public void LD_lb(){ _r.setH(_r.getB()); clock=1;}
    public void LD_lc(){ _r.setH(_r.getC()); clock=1;}
    public void LD_ld(){ _r.setH(_r.getD()); clock=1;}
    public void LD_le(){ _r.setH(_r.getE()); clock=1;}
    public void LD_lh(){ _r.setH(_r.getH()); clock=1;}
    public void LD_ll(){ _r.setH(_r.getL()); clock=1;}

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
    public void LD_HLa(){_memory.setByte(_r.getHL(),_r.getA());clock=2;}
    public void LD_HLb(){_memory.setByte(_r.getHL(),_r.getB());clock=2;}
    public void LD_HLc(){_memory.setByte(_r.getHL(),_r.getC());clock=2;}
    public void LD_HLd(){_memory.setByte(_r.getHL(),_r.getD());clock=2;}
    public void LD_HLe(){_memory.setByte(_r.getHL(),_r.getE());clock=2;}
    public void LD_HLh(){_memory.setByte(_r.getHL(),_r.getH());clock=2;}
    public void LD_HLl(){_memory.setByte(_r.getHL(),_r.getL());clock=2;}

    //LD (HL) from PC (n)
    public void LD_HLPC(){_memory.setWord(_r.getHL(), _r.getPC()); _r.incrementPC();clock=3;}

    //LD a BC DE
    public void LD_aBC(){_r.setA(_memory.getByte(_r.getBC()));clock=2;}
    public void LD_aDE(){_r.setA(_memory.getByte(_r.getDE()));clock=2;}
    public void LD_BCa(){_memory.setWord(_r.getBC(), _r.getA());clock=2;}
    public void LD_DEa(){_memory.setWord(_r.getDE(), _r.getA());clock=2;}
    //LD (nn) a ???
    public void LD_nn_a(){}

    //LD A from/to (FF00 + pc (n)) io-port
    public void LD_aIO(){_r.setA(_memory.getByte(0xFF + _r.getPC())); _r.incrementPC();clock=3;}
    public void LD_IOa(){_memory.setByte(0xFF + _r.getPC(), _r.getA()); _r.incrementPC();clock=3;}
    //LD a from/to (FF00 + C) ???
    public void LDi_HLa(){_memory.setByte(_r.getHL(), _r.getA()); _r.incrementHL(); clock=2;}
    public void LDi_aHL(){_r.setA(_memory.getByte(_r.getHL())); _r.incrementHL(); clock=2;}
    public void LDd_HLa(){ _r.decrementHL(); _memory.setByte(_r.getHL(), _r.getA());clock=2;}
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
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ab(){
        int result = 0;
        result = _r.getA() + _r.getB();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ac(){
        int result = 0;
        result = _r.getA() + _r.getC();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ad(){
        int result = 0;
        result = _r.getA() + _r.getD();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ae(){
        int result = 0;
        result = _r.getA() + _r.getD();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_ah(){
        int result = 0;
        result = _r.getA() + _r.getH();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADD_al(){
        int result = 0;
        result = _r.getA() + _r.getL();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }

    //add a,Pc
    public void ADD_aPC(){
        int result = 0;
        result = _r.getA() + _r.getPC();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        _r.incrementPC();
        clock=2;
    }
    //add a, HL
    public void ADD_aHL(){
        int result = 0;
        result = _r.getA() + _memory.getByte(_r.getHL());
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=2;
    }

    //ADC a,r
    public void ADC_aa(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _r.getA() + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ab(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _r.getB() + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ac(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _r.getC() + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ad(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _r.getD() + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ae(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _r.getE() + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_ah(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _r.getH() + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void ADC_al(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _r.getL() + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }

    //adc a,pc
    public void ADC_aPC(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _r.getPC() + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        _r.incrementPC();
        clock=2;
    }
    public void ADC_aHL(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() + _memory.getByte(_r.getHL()) + carry;
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=2;
    }

    //sub a,r
    public void SUB_aa(){
        int result = 0;
        result = _r.getA() - _r.getA();
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ab(){
        int result = 0;
        result = _r.getA() - _r.getB();
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ac(){
        int result = 0;
        result = _r.getA() - _r.getC();
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ad(){
        int result = 0;
        result = _r.getA() - _r.getD();
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ae(){
        int result = 0;
        result = _r.getA() - _r.getE();
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_ah(){
        int result = 0;
        result = _r.getA() - _r.getH();
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SUB_al(){
        int result = 0;
        result = _r.getA() - _r.getL();
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }

    //sub a,Pc
    public void SUB_aPC(){
        int result = 0;
        result = _r.getA() - _r.getPC();
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        _r.incrementPC();
        clock=2;
    }
    //sub a, HL
    public void SUB_aHL(){
        int result = 0;
        result = _r.getA() - _memory.getByte(_r.getHL());
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=2;
    }

    //sbC a,r
    public void SBC_aa(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _r.getA() - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ab(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _r.getB() - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ac(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _r.getC() - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ad(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _r.getD() - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ae(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _r.getE() - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_ah(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _r.getH() - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }
    public void SBC_al(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _r.getL() - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=1;
    }

    //sbc a,pc
    public void SBC_aPC(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _r.getPC() - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        _r.incrementPC();
        clock=2;
    }
    //sbc a,hl
    public void SBC_aHL(){
        int result = 0;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry = 0;}
        result = _r.getA() - _memory.getByte(_r.getHL()) - carry;
        if(result < 0x0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        if((result & 0xFF) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.setA(result & 0xFF);
        clock=2;
    }

    //and a,r
    public void AND_aa(){_r.setA((_r.getA() & _r.getA()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void AND_ab(){_r.setA((_r.getA() & _r.getB()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void AND_ac(){_r.setA((_r.getA() & _r.getC()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void AND_ad(){_r.setA((_r.getA() & _r.getD()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void AND_ae(){_r.setA((_r.getA() & _r.getE()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void AND_ah(){_r.setA((_r.getA() & _r.getH()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void AND_al(){_r.setA((_r.getA() & _r.getL()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}

    //and a,pc
    public void AND_aPC(){_r.setA((_r.getA() & _r.getPC()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);} _r.incrementPC();clock=2;}
    //and a,hl
    public void AND_aHL(){_r.setA((_r.getA() & _memory.getByte(_r.getHL())) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    //xor a,r
    public void XOR_aa(){_r.setA((_r.getA() ^ _r.getA()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void XOR_ab(){_r.setA((_r.getA() ^ _r.getB()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void XOR_ac(){_r.setA((_r.getA() ^ _r.getC()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void XOR_ad(){_r.setA((_r.getA() ^ _r.getD()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void XOR_ae(){_r.setA((_r.getA() ^ _r.getE()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void XOR_ah(){_r.setA((_r.getA() ^ _r.getH()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void XOR_al(){_r.setA((_r.getA() ^ _r.getL()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}

    //xor a,pc
    public void XOR_aPC(){_r.setA((_r.getA() ^ _r.getPC()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}; _r.incrementPC();clock=2;}
    //xor a,hl
    public void XOR_aHL(){_r.setA((_r.getA() ^ _memory.getByte(_r.getHL())) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    //or a,r
    public void OR_aa(){_r.setA((_r.getA() | _r.getA()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void OR_ab(){_r.setA((_r.getA() | _r.getB()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void OR_ac(){_r.setA((_r.getA() | _r.getC()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void OR_ad(){_r.setA((_r.getA() | _r.getD()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void OR_ae(){_r.setA((_r.getA() | _r.getE()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void OR_ah(){_r.setA((_r.getA() | _r.getH()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void OR_al(){_r.setA((_r.getA() | _r.getL()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}

    //or a,pc
    public void OR_aPC(){_r.setA((_r.getA() | _r.getPC()) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);} _r.incrementPC();clock=2;}
    //or a,hl
    public void OR_aHL(){_r.setA((_r.getA() | _memory.getByte(_r.getHL())) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    //compare a - r
    //VÉFIRIER QUE ÇA FONCTIONNE BIEN !
    public void CP_aa(){
        int result = _r.getA() - _r.getA();
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void CP_ab(){
        int result = _r.getA() - _r.getB();
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void CP_ac(){
        int result = _r.getA() - _r.getC();
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void CP_ad(){
        int result = _r.getA() - _r.getD();
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void CP_ae(){
        int result = _r.getA() - _r.getE();
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void CP_ah(){
        int result = _r.getA() - _r.getH();
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void CP_al(){
        int result = _r.getA() - _r.getC();
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }

    public void CP_aPC(){
        int result = _r.getA() - _r.getPC();
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.incrementPC();
        clock=2;
    }
    public void CP_aHL(){
        int result = _r.getA() - _memory.getByte(_r.getHL());
        if(result < 0){_r.setCFlag(true);}else{_r.setCFlag(false);}
        result = result & 0xff;
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        _r.incrementPC();
        clock=2;
    }

    //inc r
    public void INC_a(){_r.setA((_r.getA() + 1) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void INC_b(){_r.setB((_r.getB() + 1) & 0xff);if(_r.getB() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void INC_c(){_r.setC((_r.getC() + 1) & 0xff);if(_r.getC() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void INC_d(){_r.setD((_r.getD() + 1) & 0xff);if(_r.getD() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void INC_e(){_r.setE((_r.getE() + 1) & 0xff);if(_r.getE() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void INC_h(){_r.setH((_r.getH() + 1) & 0xff);if(_r.getH() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void INC_l(){_r.setL((_r.getL() + 1) & 0xff);if(_r.getL() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    //inc (hl)
    public void INC_HL(){_memory.setByte(_r.getHL(), (_r.getHL() + 1) & 0xff);if(_memory.getByte(_r.getHL()) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}

    //dec r
    public void DEC_a(){_r.setA((_r.getA() - 1) & 0xff);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void DEC_b(){_r.setB((_r.getB() - 1) & 0xff);if(_r.getB() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void DEC_c(){_r.setC((_r.getC() - 1) & 0xff);if(_r.getC() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void DEC_d(){_r.setD((_r.getD() - 1) & 0xff);if(_r.getD() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void DEC_e(){_r.setE((_r.getE() - 1) & 0xff);if(_r.getE() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void DEC_h(){_r.setH((_r.getH() - 1) & 0xff);if(_r.getH() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    public void DEC_l(){_r.setL((_r.getL() - 1) & 0xff);if(_r.getL() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=1;}
    //dec (hl)
    public void DEC_HL(){_memory.setByte(_r.getHL(), (_r.getHL() - 1) & 0xff);if(_memory.getByte(_r.getHL()) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}

    //daa ???? (decimal adjust register)
    public void DAA(){}

    //CPL
    public void CPL(){_r.setA(_r.getA() ^ 0xFF);clock=1;}

    //add HL,rr
    public void ADD_HLBC(){
        int result = 0;
        result = _r.getHL() + _r.getBC();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setHL(result & 0xFFFF);
        clock=2;
    }
    public void ADD_HLDE(){
        int result = 0;
        result = _r.getHL() + _r.getDE();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setHL(result & 0xFFFF);
        clock=2;
    }
    public void ADD_HLHL(){
        int result = 0;
        result = _r.getHL() + _r.getHL();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setHL(result & 0xFFFF);
        clock=2;
    }
    public void ADD_HLSP(){
        int result = 0;
        result = _r.getHL() + _r.getSP();
        if(result > 0xFF){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setHL(result & 0xFFFF);
        clock=2;
    }
    //inc rr
    public void INC_BC(){_r.incrementBC();clock=2;}
    public void INC_DE(){_r.incrementDE();clock=2;}
    // public void INC_HL(){_r.incrementHL();clock=2;}
    public void INC_SP(){_r.incrementSP();clock=2;}
    //dec rr
    public void DEC_BC(){_r.decrementBC();clock=2;}
    public void DEC_DE(){_r.decrementDE();clock=2;}
    //public void DEC_HL(){_r.decrementHL();clock=2;}
    public void DEC_SP(){_r.decrementSP();clock=2;}

    //add SP,dd (signed number)
    public void ADD_SPDD(){
        int result = _memory.getByte(_r.getPC());
        if (result > 127) result = -((~result+1)&255);
        _r.incrementPC();
        _r.setSP(_r.getSP() + result);
        clock=4;
    }

    public void LD_HLSPDD(){
        int result = _memory.getByte(_r.getPC());
        if (result > 127) result = -((~result+1)&255);
        _r.incrementPC();
        _r.setSP(_r.getSP() + result);
        _r.setH((result >> 8) & 255);
        _r.setL((result & 255));
        clock=3;
    }

    /* rotate/shift commands */
    //RLC r
    public void RLC_a(){
        int result = (_r.getA() << 1) + (_r.getA() >> 7);
        if(((_r.getA() >> 7) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setA(result);
        if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void RLC_b(){
        int result = (_r.getB() << 1) + (_r.getB() >> 7);
        if(((_r.getB() >> 7) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setB(result);
        if(_r.getB() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RLC_c(){
        int result = (_r.getC() << 1) + (_r.getC() >> 7);
        if(((_r.getC() >> 7) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setC(result);
        if(_r.getC() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RLC_d(){
        int result = (_r.getD() << 1) + (_r.getD() >> 7);
        if(((_r.getD() >> 7) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setD(result);
        if(_r.getD() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RLC_e(){
        int result = (_r.getE() << 1) + (_r.getE() >> 7);
        if(((_r.getE() >> 7) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setE(result);
        if(_r.getE() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RLC_h(){
        int result = (_r.getH() << 1)  + (_r.getH() >> 7);
        if(((_r.getH() >> 7) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setH(result);
        if(_r.getH() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RLC_l(){
        int result = (_r.getL() << 1)  + (_r.getL() >> 7);
        if(((_r.getL() >> 7) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setL(result);
        if(_r.getL() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RLC_HL(){
        int result = _memory.getByte(_r.getHL());
        result = (result << 1) + (result >> 7);
        if((result & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _memory.setByte(_r.getHL(), result);
        if((_memory.getByte(_r.getHL())) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=4;
    }

    //RL r
    public void RL_a(){
        int result = (_r.getA() << 1);
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry=0;}
        result += carry;
        if((_r.getA() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);};
        _r.setA(result);
        clock=1;
    }
    public void RL_b(){
        int result = (_r.getB() << 1);
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry=0;}
        result += carry;
        if((_r.getB() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);};
        _r.setB(result);
        clock=2;
    }
    public void RL_c(){
        int result = (_r.getC() << 1);
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry=0;}
        result += carry;
        if((_r.getC() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);};
        _r.setC(result);
        clock=2;
    }
    public void RL_d(){
        int result = (_r.getD() << 1);
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry=0;}
        result += carry;
        if((_r.getD() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);};
        _r.setD(result);
        clock=2;
    }
    public void RL_e(){
        int result = (_r.getE() << 1);
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry=0;}
        result += carry;
        if((_r.getE() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);};
        _r.setE(result);
        clock=2;
    }
    public void RL_h(){
        int result = (_r.getH() << 1);
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry=0;}
        result += carry;
        if((_r.getH() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);};
        _r.setH(result);
        clock=2;
    }
    public void RL_l(){
        int result = (_r.getL() << 1);
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry=0;}
        result += carry;
        if((_r.getL() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);};
        _r.setL(result);
        clock=2;
    }
    public void RL_HL(){
        int result = _memory.getByte(_r.getHL()) << 1;
        int carry = 0;
        if(_r.getCFlag()){carry = 1;}else{carry=0;}
        result += carry;
        if((_memory.getByte(_r.getHL()) >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _memory.setByte(_r.getHL(), result);
        clock=4;
    }

    //RRC r
    public void RRC_a(){
        int result = (_r.getA() >> 1);
        int carry = (_r.getA() << 7);
        result += carry;
        if((_r.getA() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setA(result);
        if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void RRC_b(){
        int result = (_r.getB() >> 1);
        int carry = (_r.getB() << 7);
        result += carry;
        if((_r.getB() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setB(result);
        if(_r.getB() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RRC_c(){
        int result = (_r.getC() >> 1);
        int carry = (_r.getC() << 7);
        result += carry;
        if((_r.getC() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setC(result);
        if(_r.getC() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RRC_d(){
        int result = (_r.getD() >> 1);
        int carry = (_r.getD() << 7);
        result += carry;
        if((_r.getD() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setD(result);
        if(_r.getD() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RRC_e(){
        int result = (_r.getE() >> 1);
        int carry = (_r.getE() << 7);
        result += carry;
        if((_r.getE() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setE(result);
        if(_r.getE() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RRC_h(){
        int result = (_r.getH() >> 1);
        int carry = (_r.getH() << 7);
        result += carry;
        if((_r.getH() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setH(result);
        if(_r.getH() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RRC_l(){
        int result = (_r.getL() >> 1);
        int carry = (_r.getL() << 7);
        result += carry;
        if((_r.getL() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setL(result);
        if(_r.getL() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RRC_HL(){
        int result = (_memory.getByte(_r.getHL()) >> 1);
        int carry = (_memory.getBYte(_r.getHL()) << 7);
        result += carry;
        if((_memory.getByte(_r.getHL()) & 0x1) == 1){_r.setCFlag(true);}{_r.setCFlag(false);}
        _memory.setByte(_r.getHL(), result);
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock = 4;
    }

    //RR r
    public void RR_a(){
        int result = 0;
        if(_r.getCFlag()){ result = 1 << 7; }
        result += _r.getA() >> 1;
        if((_r.getA() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setA(result);
        if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=1;
    }
    public void RR_b(){
        int result = 0;
        if(_r.getCFlag()){ result = 1 << 7; }
        result += _r.getB() >> 1;
        if((_r.getB() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setB(result);
        if(_r.getB() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RR_c(){
        int result = 0;
        if(_r.getCFlag()){ result = 1 << 7; }
        result += _r.getC() >> 1;
        if((_r.getC() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setC(result);
        if(_r.getC() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RR_d(){
        int result = 0;
        if(_r.getCFlag()){ result = 1 << 7; }
        result += _r.getD() >> 1;
        if((_r.getD() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setD(result);
        if(_r.getD() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RR_e(){
        int result = 0;
        if(_r.getCFlag()){ result = 1 << 7; }
        result += _r.getE() >> 1;
        if((_r.getE() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setE(result);
        if(_r.getE() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RR_h(){
        int result = 0;
        if(_r.getCFlag()){ result = 1 << 7; }
        result += _r.getH() >> 1;
        if((_r.getH() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setH(result);
        if(_r.getH() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RR_l(){
        int result = 0;
        if(_r.getCFlag()){ result = 1 << 7; }
        result += _r.getL() >> 1;
        if((_r.getL() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _r.setL(result);
        if(_r.getL() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=2;
    }
    public void RR_HL(){
        int result = 0;
        if(_r.getCFlag()){ result = 1 << 7; }
        result += _memory.getByte(_r.getHL()) >> 1;
        if((_memory.getByte(_r.getHL()) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _memory.setByte(_r.getHL(), result);
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=4;
    }

    public void SLA_a(){int result = _r.getA()<<1;if((_r.getA() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setA(result);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SLA_b(){int result = _r.getB()<<1;if((_r.getB() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setB(result);if(_r.getB() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SLA_c(){int result = _r.getC()<<1;if((_r.getC() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setC(result);if(_r.getC() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SLA_d(){int result = _r.getD()<<1;if((_r.getD() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setD(result);if(_r.getD() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SLA_e(){int result = _r.getE()<<1;if((_r.getE() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setE(result);if(_r.getE() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SLA_h(){int result = _r.getH()<<1;if((_r.getH() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setH(result);if(_r.getH() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SLA_l(){int result = _r.getL()<<1;if((_r.getL() >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setL(result);if(_r.getL() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SLA_HL(){
        int result = _memory.getByte(_r.getHL()) << 1;
        if((_memory.getByte(_r.getHL()) >> 7) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _memory.getByte(_r.getHL(), result);
        if(result == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=4;
    }

    public void SWAP_a(){int HNibble = (_r.getA()>>4)&0xf;int LNibble = _r.getA()&0xf;_r.setA(HNibble + LNibble);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SWAP_b(){int HNibble = (_r.getB()>>4)&0xf;int LNibble = _r.getB()&0xf;_r.setB(HNibble + LNibble);if(_r.getB() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SWAP_c(){int HNibble = (_r.getC()>>4)&0xf;int LNibble = _r.getC()&0xf;_r.setC(HNibble + LNibble);if(_r.getC() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SWAP_d(){int HNibble = (_r.getD()>>4)&0xf;int LNibble = _r.getD()&0xf;_r.setD(HNibble + LNibble);if(_r.getD() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SWAP_e(){int HNibble = (_r.getE()>>4)&0xf;int LNibble = _r.getE()&0xf;_r.setE(HNibble + LNibble);if(_r.getE() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SWAP_h(){int HNibble = (_r.getH()>>4)&0xf;int LNibble = _r.getH()&0xf;_r.setH(HNibble + LNibble);if(_r.getH() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SWAP_l(){int HNibble = (_r.getL()>>4)&0xf;int LNibble = _r.getL()&0xf;_r.setL(HNibble + LNibble);if(_r.getL() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SWAP_HL(){
        int HNibble = (_memory.getByte(_r.getHL()) >> 4) & 0xf;
        int LNibble = (_memory.getByte(_r.getHL()));
        _memory.setByte(_r.getHL(), HNibble + LNibble);
        if(_memory.getByte(_r.getHL()) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}
        clock=4;
    }

    public void SRA_a(){int result = _r.getA()>>1;if((_r.getA() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setA(result);if(_r.getA()==0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRA_b(){int result = _r.getB()>>1;if((_r.getB() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setB(result);if(_r.getB()==0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRA_c(){int result = _r.getC()>>1;if((_r.getC() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setC(result);if(_r.getC()==0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRA_d(){int result = _r.getD()>>1;if((_r.getD() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setD(result);if(_r.getD()==0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRA_e(){int result = _r.getE()>>1;if((_r.getE() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setE(result);if(_r.getE()==0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRA_h(){int result = _r.getH()>>1;if((_r.getH() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setH(result);if(_r.getH()==0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRA_l(){int result = _r.getL()>>1;if((_r.getL() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setL(result);if(_r.getL()==0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRA_HL(){
        int result = (_memory.getByte(_r.getHL()) >> 1);
        if((_memory.getByte(_r.getHL()) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _memory.setByte(_r.getHL(), result);
        if((_memory.getByte(_r.getHL()) == 0)){_r.setZFlag(true);{_r.setZFlag(false);}
        clock=4;
        }
    }

    public void SRL_a(){ int result = _r.getA() >>> 1;if((_r.getA() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setA(result);if(_r.getA() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRL_b(){ int result = _r.getB() >>> 1;if((_r.getB() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setB(result);if(_r.getB() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRL_c(){ int result = _r.getC() >>> 1;if((_r.getC() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setC(result);if(_r.getC() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRL_d(){ int result = _r.getD() >>> 1;if((_r.getD() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setD(result);if(_r.getD() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRL_e(){ int result = _r.getE() >>> 1;if((_r.getE() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setE(result);if(_r.getE() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRL_h(){ int result = _r.getH() >>> 1;if((_r.getH() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setH(result);if(_r.getH() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRL_l(){ int result = _r.getL() >>> 1;if((_r.getL() & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}_r.setL(result);if(_r.getL() == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void SRL_HL(){
        int result = (_memory.getByte(_r.getHL()) >>> 1);
        if((_memory.getByte(_r.getHL()) & 0x1) == 1){_r.setCFlag(true);}else{_r.setCFlag(false);}
        _memory.setByte(_r.getHL(), result);
        if(_memory.getByte(_r.getHL()) == 0){_r.setZFlag(true);{_r.setZFlag(false);}
        clock=4;
        }
    }

    /* singlebit operations */
    public void BIT_0a(){if((_r.getA() & 1)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_1a(){if((_r.getA() & 2)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_2a(){if((_r.getA() & 4)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_3a(){if((_r.getA() & 8)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_4a(){if((_r.getA() & 16)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_5a(){if((_r.getA() & 32)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_6a(){if((_r.getA() & 64)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_7a(){if((_r.getA() & 128) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    public void BIT_0b(){if((_r.getB() & 1)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_1b(){if((_r.getB() & 2)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_2b(){if((_r.getB() & 4)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_3b(){if((_r.getB() & 8)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_4b(){if((_r.getB() & 16)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_5b(){if((_r.getB() & 32)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_6b(){if((_r.getB() & 64)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_7b(){if((_r.getB() & 128) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    public void BIT_0c(){if((_r.getC() & 1)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_1c(){if((_r.getC() & 2)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_2c(){if((_r.getC() & 4)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_3c(){if((_r.getC() & 8)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_4c(){if((_r.getC() & 16)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_5c(){if((_r.getC() & 32)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_6c(){if((_r.getC() & 64)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_7c(){if((_r.getC() & 128) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    public void BIT_0d(){if((_r.getD() & 1)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_1d(){if((_r.getD() & 2)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_2d(){if((_r.getD() & 4)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_3d(){if((_r.getD() & 8)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_4d(){if((_r.getD() & 16)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_5d(){if((_r.getD() & 32)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_6d(){if((_r.getD() & 64)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_7d(){if((_r.getD() & 128) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    public void BIT_0e(){if((_r.getE() & 1)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_1e(){if((_r.getE() & 2)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_2e(){if((_r.getE() & 4)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_3e(){if((_r.getE() & 8)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_4e(){if((_r.getE() & 16)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_5e(){if((_r.getE() & 32)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_6e(){if((_r.getE() & 64)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_7e(){if((_r.getE() & 128) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    public void BIT_0h(){if((_r.getH() & 1)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_1h(){if((_r.getH() & 2)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_2h(){if((_r.getH() & 4)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_3h(){if((_r.getH() & 8)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_4h(){if((_r.getH() & 16)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_5h(){if((_r.getH() & 32)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_6h(){if((_r.getH() & 64)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_7h(){if((_r.getH() & 128) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    public void BIT_0l(){if((_r.getL() & 1)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_1l(){if((_r.getL() & 2)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_2l(){if((_r.getL() & 4)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_3l(){if((_r.getL() & 8)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_4l(){if((_r.getL() & 16)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_5l(){if((_r.getL() & 32)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_6l(){if((_r.getL() & 64)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}
    public void BIT_7l(){if((_r.getL() & 128) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=2;}

    public void BIT_0HL(){if((_memory.getByte(_r.getHL()) & 1)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}
    public void BIT_1HL(){if((_memory.getByte(_r.getHL()) & 2)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}
    public void BIT_2HL(){if((_memory.getByte(_r.getHL()) & 4)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}
    public void BIT_3HL(){if((_memory.getByte(_r.getHL()) & 8)   == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}
    public void BIT_4HL(){if((_memory.getByte(_r.getHL()) & 16)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}
    public void BIT_5HL(){if((_memory.getByte(_r.getHL()) & 32)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}
    public void BIT_6HL(){if((_memory.getByte(_r.getHL()) & 64)  == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}
    public void BIT_7HL(){if((_memory.getByte(_r.getHL()) & 128) == 0){_r.setZFlag(true);}else{_r.setZFlag(false);}clock=3;}

    public void SET_0a(){_r.setA(_r.getA() | 1);clock=2;}
    public void SET_1a(){_r.setA(_r.getA() | 2);clock=2;}
    public void SET_2a(){_r.setA(_r.getA() | 4);clock=2;}
    public void SET_3a(){_r.setA(_r.getA() | 8);clock=2;}
    public void SET_4a(){_r.setA(_r.getA() | 16);clock=2;}
    public void SET_5a(){_r.setA(_r.getA() | 32);clock=2;}
    public void SET_6a(){_r.setA(_r.getA() | 64);clock=2;}
    public void SET_7a(){_r.setA(_r.getA() | 128);clock=2;}

    public void SET_0b(){_r.setB(_r.getB() | 1);clock=2;}
    public void SET_1b(){_r.setB(_r.getB() | 2);clock=2;}
    public void SET_2b(){_r.setB(_r.getB() | 4);clock=2;}
    public void SET_3b(){_r.setB(_r.getB() | 8);clock=2;}
    public void SET_4b(){_r.setB(_r.getB() | 16);clock=2;}
    public void SET_5b(){_r.setB(_r.getB() | 32);clock=2;}
    public void SET_6b(){_r.setB(_r.getB() | 64);clock=2;}
    public void SET_7b(){_r.setB(_r.getB() | 128);clock=2;}

    public void SET_0c(){_r.setC(_r.getC() | 1);clock=2;}
    public void SET_1c(){_r.setC(_r.getC() | 2);clock=2;}
    public void SET_2c(){_r.setC(_r.getC() | 4);clock=2;}
    public void SET_3c(){_r.setC(_r.getC() | 8);clock=2;}
    public void SET_4c(){_r.setC(_r.getC() | 16);clock=2;}
    public void SET_5c(){_r.setC(_r.getC() | 32);clock=2;}
    public void SET_6c(){_r.setC(_r.getC() | 64);clock=2;}
    public void SET_7c(){_r.setC(_r.getC() | 128);clock=2;}

    public void SET_0d(){_r.setD(_r.getD() | 1);clock=2;}
    public void SET_1d(){_r.setD(_r.getD() | 2);clock=2;}
    public void SET_2d(){_r.setD(_r.getD() | 4);clock=2;}
    public void SET_3d(){_r.setD(_r.getD() | 8);clock=2;}
    public void SET_4d(){_r.setD(_r.getD() | 16);clock=2;}
    public void SET_5d(){_r.setD(_r.getD() | 32);clock=2;}
    public void SET_6d(){_r.setD(_r.getD() | 64);clock=2;}
    public void SET_7d(){_r.setD(_r.getD() | 128);clock=2;}

    public void SET_0e(){_r.setE(_r.getE() | 1);clock=2;}
    public void SET_1e(){_r.setE(_r.getE() | 2);clock=2;}
    public void SET_2e(){_r.setE(_r.getE() | 4);clock=2;}
    public void SET_3e(){_r.setE(_r.getE() | 8);clock=2;}
    public void SET_4e(){_r.setE(_r.getE() | 16);clock=2;}
    public void SET_5e(){_r.setE(_r.getE() | 32);clock=2;}
    public void SET_6e(){_r.setE(_r.getE() | 64);clock=2;}
    public void SET_7e(){_r.setE(_r.getE() | 128);clock=2;}

    public void SET_0h(){_r.setH(_r.getH() | 1);clock=2;}
    public void SET_1h(){_r.setH(_r.getH() | 2);clock=2;}
    public void SET_2h(){_r.setH(_r.getH() | 4);clock=2;}
    public void SET_3h(){_r.setH(_r.getH() | 8);clock=2;}
    public void SET_4h(){_r.setH(_r.getH() | 16);clock=2;}
    public void SET_5h(){_r.setH(_r.getH() | 32);clock=2;}
    public void SET_6h(){_r.setH(_r.getH() | 64);clock=2;}
    public void SET_7h(){_r.setH(_r.getH() | 128);clock=2;}

    public void SET_0l(){_r.setL(_r.getL() | 1);clock=2;}
    public void SET_1l(){_r.setL(_r.getL() | 2);clock=2;}
    public void SET_2l(){_r.setL(_r.getL() | 4);clock=2;}
    public void SET_3l(){_r.setL(_r.getL() | 8);clock=2;}
    public void SET_4l(){_r.setL(_r.getL() | 16);clock=2;}
    public void SET_5l(){_r.setL(_r.getL() | 32);clock=2;}
    public void SET_6l(){_r.setL(_r.getL() | 64);clock=2;}
    public void SET_7l(){_r.setL(_r.getL() | 128);clock=2;}

    public void SET_0HL(){_memory.setByte(_r.getHL(), _memory.getByte(_r.getHL()) | 1);clock=4;}
    public void SET_1HL(){_memory.setByte(_r.getHL(), _memory.getByte(_r.getHL()) | 2);clock=4;}
    public void SET_2HL(){_memory.setByte(_r.getHL(), _memory.getByte(_r.getHL()) | 4);clock=4;}
    public void SET_3HL(){_memory.setByte(_r.getHL(), _memory.getByte(_r.getHL()) | 8);clock=4;}
    public void SET_4HL(){_memory.setByte(_r.getHL(), _memory.getByte(_r.getHL()) | 16);clock=4;}
    public void SET_5HL(){_memory.setByte(_r.getHL(), _memory.getByte(_r.getHL()) | 32);clock=4;}
    public void SET_6HL(){_memory.setByte(_r.getHL(), _memory.getByte(_r.getHL()) | 64);clock=4;}
    public void SET_7HL(){_memory.setByte(_r.getHL(), _memory.getByte(_r.getHL()) | 128);clock=4;}

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

    public void RES_0HL(){_memory.setByte(_r.getHL(), _r.getHL() & 0xFE);clock=4;}
    public void RES_1HL(){_memory.setByte(_r.getHL(), _r.getHL() & 0xFE);clock=4;}
    public void RES_2HL(){_memory.setByte(_r.getHL(), _r.getHL() & 0xFE);clock=4;}
    public void RES_3HL(){_memory.setByte(_r.getHL(), _r.getHL() & 0xF7);clock=4;}
    public void RES_4HL(){_memory.setByte(_r.getHL(), _r.getHL() & 0xEF);clock=4;}
    public void RES_5HL(){_memory.setByte(_r.getHL(), _r.getHL() & 0xEF);clock=4;}
    public void RES_6HL(){_memory.setByte(_r.getHL(), _r.getHL() & 0xEF);clock=4;}
    public void RES_7HL(){_memory.setByte(_r.getHL(), _r.getHL() & 0x7F);clock=4;}

    /* CPU-controlcommand */
    public void CCF(){if(_r.getCFlag()){_r.setCFlag(false);}else{_r.setCFlag(true);}clock=1;}
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
    public void JP_HL(){ _r.setPC(_r.getHL());clock=1;}
    public void JP_fPC(){
        int result = _r.getPC();
        _r.incrementPC();
        result = (result << 8) + _r.getPC();
        if(_r.getZFlag() || _r.getCFlag()){
            _r.setPC(result);
            clock=4;
        }
        else{
            clock=3;
            _r.incrementPC();
        }
    }
    public void JR_PC(){
        int offset = _r.getPC();
        _r.setPC(_r.getPC() + offset);
        clock=3;
    }
    public void JR_fPC(){
        int offset = _r.getPC();
        if(_r.getZFlag() || _r.getCFlag()){
            _r.setPC(_r.getPC() + offset);
            clock=3;
        }
        else{clock=2;
        _r.incrementPC();
        }
    }
    public void Call_PC(){
        int newPC = _r.getPC() << 8;
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.incrementPC();
        newPC += _r.getPC();
        _r.setPC(newPC);
        clock=8;
    }
    public void Call_FPC(){
        if(_r.getZFlag() || _r.getCFlag())
        {
            int newPC = _r.getPC() << 8;
            _r.decrementSP2();
            _memory.setWord(_r.getSP(), _r.getPC());
            _r.incrementPC();
            newPC += _r.getPC();
            _r.setPC(newPC);
            clock=8;
        }
        else{
            _r.incrementPC2();
            clock=4;
        }
    }
    public void RET(){
        _r.setPC(_memory.getWord(_r.getPC()));
        _r.incrementSP2();
        clock=4;
    }
    public void RET_F(){
        if(_r.getZFlag() || _r.getCFlag()){
            _r.setPC(_memory.getWord(_r.getPC()));
            _r.incrementSP2();
            clock=5;
        }
        else{
            clock=2;
        }
    }
    public void RETI(){
        _r.setPC(_memory.getWord(_r.getPC()));
        _r.incrementSP2();
        _r.setIME(true);
        clock=4;
    }
    public void RST_00(){
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.setPC(0x0000);
        clock = 4;
    }
    public void RST_08(){
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.setPC(0x0008);
        clock = 4;
    }
    public void RST_10(){
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.setPC(0x0010);
        clock = 4;
    }
    public void RST_18(){
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.setPC(0x0018);
        clock = 4;
    }
    public void RST_20(){
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.setPC(0x0020);
        clock = 4;
    }
    public void RST_28(){
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.setPC(0x0028);
        clock = 4;
    }
    public void RST_30(){
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.setPC(0x0030);
        clock = 4;
    }
    public void RST_38(){
        _r.decrementSP2();
        _memory.setWord(_r.getSP(), _r.getPC());
        _r.setPC(0x0038);
        clock = 4;
    }
}

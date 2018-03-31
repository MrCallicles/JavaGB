//
// Cpu.java
//
//
//ld
//  ld   r,r         [x]
//  ld   r,n         [x]
//  ld   r,(HL)      [x]
//  ld   (HL),r      [x]
//  ld   (HL),n      [x]
//  ld   A,(BC)      [x] ld   A,(DE)      [x] ld   A,(nn)      [ ]
//  ld   (BC),A      [x]
//  ld   (DE),A      [x]
//  ld   (nn),A      [ ]
//  ld   A,(FF00+n)  [ ]
//  ld   (FF00+n),A  [ ]
//  ld   A,(FF00+C)  [ ]
//  ld   (FF00+C),A  [ ]
//  ldi  (HL),A      [ ]
//  ldi  A,(HL)      [ ]
//  ldd  (HL),A      [ ]
//  ldd  A,(HL)      [ ]
//
//  ld   rr,nn       [ ]
//  ld   SP,HL       [ ]
//  push rr          [ ]
//  pop  rr          [ ]
//
//arithmetics
//

package JavaGB.cpu;

import JavaGB.memory.Ram;

class Cpu{
    public static void main(String[] args){
        Registers _r = new Registers();
        Ram _memory = new Ram();
    }

    /* LD */
    //LD regX from regY
    public void LD_aa(){ _r.setA(_r.getA);};
    public void LD_ab(){ _r.setA(_r.getB);};
    public void LD_ac(){ _r.setA(_r.getC);};
    public void LD_ad(){ _r.setA(_r.getD);};
    public void LD_ae(){ _r.setA(_r.getE);};
    public void LD_ah(){ _r.setA(_r.getH);};
    public void LD_al(){ _r.setA(_r.getL);};
    public void LD_ba(){ _r.setB(_r.getA);};
    public void LD_bb(){ _r.setB(_r.getB);};
    public void LD_bc(){ _r.setB(_r.getC);};
    public void LD_bd(){ _r.setB(_r.getD);};
    public void LD_be(){ _r.setB(_r.getE);};
    public void LD_bh(){ _r.setB(_r.getH);};
    public void LD_bl(){ _r.setB(_r.getL);};
    public void LD_ca(){ _r.setC(_r.getA);};
    public void LD_cb(){ _r.setC(_r.getB);};
    public void LD_cc(){ _r.setC(_r.getC);};
    public void LD_cd(){ _r.setC(_r.getD);};
    public void LD_ce(){ _r.setC(_r.getE);};
    public void LD_ch(){ _r.setC(_r.getH);};
    public void LD_cl(){ _r.setC(_r.getL);};
    public void LD_da(){ _r.setD(_r.getA);};
    public void LD_db(){ _r.setD(_r.getB);};
    public void LD_dc(){ _r.setD(_r.getC);};
    public void LD_dd(){ _r.setD(_r.getD);};
    public void LD_de(){ _r.setD(_r.getE);};
    public void LD_dh(){ _r.setD(_r.getH);};
    public void LD_dl(){ _r.setD(_r.getL);};
    public void LD_ea(){ _r.setE(_r.getA);};
    public void LD_eb(){ _r.setE(_r.getB);};
    public void LD_ec(){ _r.setE(_r.getC);};
    public void LD_ed(){ _r.setE(_r.getD);};
    public void LD_ee(){ _r.setE(_r.getE);};
    public void LD_eh(){ _r.setE(_r.getH);};
    public void LD_el(){ _r.setE(_r.getL);};
    public void LD_ha(){ _r.setH(_r.getA);};
    public void LD_hb(){ _r.setH(_r.getB);};
    public void LD_hc(){ _r.setH(_r.getC);};
    public void LD_hd(){ _r.setH(_r.getD);};
    public void LD_he(){ _r.setH(_r.getE);};
    public void LD_hh(){ _r.setH(_r.getH);};
    public void LD_hl(){ _r.setH(_r.getL);};
    public void LD_la(){ _r.setH(_r.getA);};
    public void LD_lb(){ _r.setH(_r.getB);};
    public void LD_lc(){ _r.setH(_r.getC);};
    public void LD_ld(){ _r.setH(_r.getD);};
    public void LD_le(){ _r.setH(_r.getE);};
    public void LD_lh(){ _r.setH(_r.getH);};
    public void LD_ll(){ _r.setH(_r.getL);};

    //LD regX from PC (n)
    public void LD_an(){_r.setA(_memory.getByte(_r.getPC())); _r.incrementPC();};
    public void LD_bn(){_r.setB(_memory.getByte(_r.getPC())); _r.incrementPC();};
    public void LD_cn(){_r.setC(_memory.getByte(_r.getPC())); _r.incrementPC();};
    public void LD_dn(){_r.setD(_memory.getByte(_r.getPC())); _r.incrementPC();};
    public void LD_en(){_r.setE(_memory.getByte(_r.getPC())); _r.incrementPC();};
    public void LD_hn(){_r.setH(_memory.getByte(_r.getPC())); _r.incrementPC();};
    public void LD_ln(){_r.setL(_memory.getByte(_r.getPC())); _r.incrementPC();};

    //LD regX from (HL) et inversement
    public void LD_aHL(){_r.setA(_memory.getByte(_r.getH << 8 + _r.getL));};
    public void LD_bHL(){_r.setB(_memory.getByte(_r.getH << 8 + _r.getL));};
    public void LD_cHL(){_r.setC(_memory.getByte(_r.getH << 8 + _r.getL));};
    public void LD_dHL(){_r.setD(_memory.getByte(_r.getH << 8 + _r.getL));};
    public void LD_eHL(){_r.setE(_memory.getByte(_r.getH << 8 + _r.getL));};
    public void LD_hHL(){_r.setH(_memory.getByte(_r.getH << 8 + _r.getL));};
    public void LD_lHL(){_r.setL(_memory.getByte(_r.getH << 8 + _r.getL));};
    public void LD_HLa(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetA);};
    public void LD_HLb(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetB);};
    public void LD_HLc(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetC);};
    public void LD_HLd(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetD);};
    public void LD_HLe(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetE);};
    public void LD_HLh(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetH);};
    public void LD_HLl(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetL);};

    //LD (HL) from PC
    public void LD_HLPC(){_memory.setByte(_r.getH<<8 + _r.getL, _r.getPC()); _r.incrementPC();}; //PAS BON !!!

    //LD a BC DE
    public void LD_aBC(){_r.setA(_memory.getByte(_r.getB << 8 + _r.getC));};
    public void LD_aDE(){_r.setA(_memory.getByte(_r.getD << 8 + _r.getE));};
    public void LD_BCa(){_memory.setByte(_r.getB<<8 + _r.getC, _rgetA);}; // PAS BON !!!!
    public void LD_DEa(){_memory.setByte(_r.getD<<8 + _r.getE, _rgetA);}; // PAS BON !!!!


}

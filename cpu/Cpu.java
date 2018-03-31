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
    public void LD_aa(){ _r.setA(_r.getA); clock=1}
    public void LD_ab(){ _r.setA(_r.getB); clock=1}
    public void LD_ac(){ _r.setA(_r.getC); clock=1}
    public void LD_ad(){ _r.setA(_r.getD); clock=1}
    public void LD_ae(){ _r.setA(_r.getE); clock=1}
    public void LD_ah(){ _r.setA(_r.getH); clock=1}
    public void LD_al(){ _r.setA(_r.getL); clock=1}
    public void LD_ba(){ _r.setB(_r.getA); clock=1}
    public void LD_bb(){ _r.setB(_r.getB); clock=1}
    public void LD_bc(){ _r.setB(_r.getC); clock=1}
    public void LD_bd(){ _r.setB(_r.getD); clock=1}
    public void LD_be(){ _r.setB(_r.getE); clock=1}
    public void LD_bh(){ _r.setB(_r.getH); clock=1}
    public void LD_bl(){ _r.setB(_r.getL); clock=1}
    public void LD_ca(){ _r.setC(_r.getA); clock=1}
    public void LD_cb(){ _r.setC(_r.getB); clock=1}
    public void LD_cc(){ _r.setC(_r.getC); clock=1}
    public void LD_cd(){ _r.setC(_r.getD); clock=1}
    public void LD_ce(){ _r.setC(_r.getE); clock=1}
    public void LD_ch(){ _r.setC(_r.getH); clock=1}
    public void LD_cl(){ _r.setC(_r.getL); clock=1}
    public void LD_da(){ _r.setD(_r.getA); clock=1}
    public void LD_db(){ _r.setD(_r.getB); clock=1}
    public void LD_dc(){ _r.setD(_r.getC); clock=1}
    public void LD_dd(){ _r.setD(_r.getD); clock=1}
    public void LD_de(){ _r.setD(_r.getE); clock=1}
    public void LD_dh(){ _r.setD(_r.getH); clock=1}
    public void LD_dl(){ _r.setD(_r.getL); clock=1}
    public void LD_ea(){ _r.setE(_r.getA); clock=1}
    public void LD_eb(){ _r.setE(_r.getB); clock=1}
    public void LD_ec(){ _r.setE(_r.getC); clock=1}
    public void LD_ed(){ _r.setE(_r.getD); clock=1}
    public void LD_ee(){ _r.setE(_r.getE); clock=1}
    public void LD_eh(){ _r.setE(_r.getH); clock=1}
    public void LD_el(){ _r.setE(_r.getL); clock=1}
    public void LD_ha(){ _r.setH(_r.getA); clock=1}
    public void LD_hb(){ _r.setH(_r.getB); clock=1}
    public void LD_hc(){ _r.setH(_r.getC); clock=1}
    public void LD_hd(){ _r.setH(_r.getD); clock=1}
    public void LD_he(){ _r.setH(_r.getE); clock=1}
    public void LD_hh(){ _r.setH(_r.getH); clock=1}
    public void LD_hl(){ _r.setH(_r.getL); clock=1}
    public void LD_la(){ _r.setH(_r.getA); clock=1}
    public void LD_lb(){ _r.setH(_r.getB); clock=1}
    public void LD_lc(){ _r.setH(_r.getC); clock=1}
    public void LD_ld(){ _r.setH(_r.getD); clock=1}
    public void LD_le(){ _r.setH(_r.getE); clock=1}
    public void LD_lh(){ _r.setH(_r.getH); clock=1}
    public void LD_ll(){ _r.setH(_r.getL); clock=1}

    //LD regX from PC (n)
    public void LD_an(){_r.setA(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2}
    public void LD_bn(){_r.setB(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2}
    public void LD_cn(){_r.setC(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2}
    public void LD_dn(){_r.setD(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2}
    public void LD_en(){_r.setE(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2}
    public void LD_hn(){_r.setH(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2}
    public void LD_ln(){_r.setL(_memory.getByte(_r.getPC())); _r.incrementPC();clock=2}

    //LD regX from (HL) et inversement
    public void LD_aHL(){_r.setA(_memory.getByte(_r.getH << 8 + _r.getL));clock=2}
    public void LD_bHL(){_r.setB(_memory.getByte(_r.getH << 8 + _r.getL));clock=2}
    public void LD_cHL(){_r.setC(_memory.getByte(_r.getH << 8 + _r.getL));clock=2}
    public void LD_dHL(){_r.setD(_memory.getByte(_r.getH << 8 + _r.getL));clock=2}
    public void LD_eHL(){_r.setE(_memory.getByte(_r.getH << 8 + _r.getL));clock=2}
    public void LD_hHL(){_r.setH(_memory.getByte(_r.getH << 8 + _r.getL));clock=2}
    public void LD_lHL(){_r.setL(_memory.getByte(_r.getH << 8 + _r.getL));clock=2}
    public void LD_HLa(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetA);clock=2}
    public void LD_HLb(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetB);clock=2}
    public void LD_HLc(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetC);clock=2}
    public void LD_HLd(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetD);clock=2}
    public void LD_HLe(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetE);clock=2}
    public void LD_HLh(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetH);clock=2}
    public void LD_HLl(){_memory.setByte(_r.getH<<8 + _r.getL, _rgetL);clock=2}

    //LD (HL) from PC
    public void LD_HLPC(){_memory.setWord(_r.getH<<8 + _r.getL, _r.getPC()); _r.incrementPC();}

    //LD a BC DE
    public void LD_aBC(){_r.setA(_memory.getByte(_r.getB << 8 + _r.getC));}
    public void LD_aDE(){_r.setA(_memory.getByte(_r.getD << 8 + _r.getE));}
    public void LD_BCa(){_memory.setWord(_r.getB<<8 + _r.getC, _rgetA);}
    public void LD_DEa(){_memory.setWord(_r.getD<<8 + _r.getE, _rgetA);}


}

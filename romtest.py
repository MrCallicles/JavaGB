#!/usr/bin/python3

rom = bytearray()
def appendBC(ins):
    rom.append(int('BC',16))
    rom.append(int(ins,16))

#nop
rom.append(int('0',16))
#ld bc,16
rom.append(int('01',16))
rom.append(int('DD',16))
rom.append(int('DD',16))
#ld (bc),a
rom.append(int('02',16))
#inc bc
rom.append(int('03',16))
#inc b
rom.append(int('04',16))
#dec b
rom.append(int('05',16))
#ld b,8
rom.append(int('06',16))
rom.append(int('DD',16))
#rlca
rom.append(int('07',16))
#ld (a16),sp
rom.append(int('08',16))
#ld add HL,BC
rom.append(int('09',16))
#ld a,(bc)
rom.append(int('0A',16))
#dec bc
rom.append(int('0b',16))
#inc c
rom.append(int('0c',16))
#dec c
rom.append(int('0d',16))
#ld c,8
rom.append(int('0e',16))
rom.append(int('DD',16))
#rrca
rom.append(int('0f',16))
#---------
#stop
rom.append(int('10',16))
#ld de,16
rom.append(int('11',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#ld (de),a
rom.append(int('12',16))
#inc de
rom.append(int('13',16))
#inc d
rom.append(int('14',16))
#dec d
rom.append(int('15',16))
#ld d,8
rom.append(int('16',16))
rom.append(int('EE',16))
#rla
rom.append(int('17',16))
#jr
rom.append(int('18',16))
rom.append(int('0',16))
#add hl,de
rom.append(int('19',16))
#ld a,(de)
rom.append(int('1A',16))
#dec de
rom.append(int('1B',16))
#inc e
rom.append(int('1C',16))
#dec e
rom.append(int('1D',16))
#ld e,8
rom.append(int('1E',16))
rom.append(int('EE',16))
#rra
rom.append(int('1F',16))
#jr nz
rom.append(int('20',16))
rom.append(int('0',16))
#ld hl,16
rom.append(int('21',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#ld (hl+),a
rom.append(int('22',16))
#inc hl
rom.append(int('23',16))
#inc h
rom.append(int('24',16))
#dec h
rom.append(int('25',16))
#ld h,8
rom.append(int('26',16))
#dda
rom.append(int('27',16))
#jr z,8
rom.append(int('28',16))
rom.append(int('0',16))
#add hl,hl
rom.append(int('29',16))
#ld a,(HL+)
rom.append(int('2A',16))
#dec hl
rom.append(int('2B',16))
#inc l
rom.append(int('2C',16))
#dec l
rom.append(int('2D',16))
#ld l,8
rom.append(int('2E',16))
rom.append(int('EE',16))
#cpl
rom.append(int('2F',16))
#----------
#jr nc,8
rom.append(int('30',16))
rom.append((int('0',16)))
#ld sp, 16
rom.append(int('31',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#ld (hl-),a
rom.append(int('32',16))
#inc sp
rom.append(int('33',16))
#inc (hl)
rom.append(int('34',16))
#dec (hl)
rom.append(int('35',16))
#ld (hl),8
rom.append(int('36',16))
rom.append(int('EE',16))
#scf
rom.append(int('37',16))
#jr c,8
rom.append(int('38',16))
rom.append(int('0',16))
#add hl,sp
rom.append(int('39',16))
#ld a,(hl-)
rom.append(int('3A',16))
#dec sp
rom.append(int('3B',16))
#inc a
rom.append(int('3C',16))
#dec a
rom.append(int('3D',16))
#ld a,8
rom.append(int('3E',16))
rom.append(int('EE',16))
#ccf
rom.append(int('3F',16))
#----------
#ld b,b
rom.append(int('40',16))
#ld b,c
rom.append(int('41',16))
#ld b,d
rom.append(int('42',16))
#ld b,e
rom.append(int('43',16))
#ld b,h
rom.append(int('44',16))
#ld b,l
rom.append(int('45',16))
#ld b,(hl)
rom.append(int('46',16))
#ld b,a
rom.append(int('47',16))
#ld c,b
rom.append(int('48',16))
#ld c,c
rom.append(int('49',16))
#ld c,d
rom.append(int('4A',16))
#ld c,e
rom.append(int('4B',16))
#ld c,h
rom.append(int('4C',16))
#ld c,l
rom.append(int('4D',16))
#ld c,(hl)
rom.append(int('4E',16))
#ld c,a
rom.append(int('4F',16))
#----------
#ld d,b
rom.append(int('50',16))
#ld d,c
rom.append(int('51',16))
#ld d,d
rom.append(int('52',16))
#ld d,e
rom.append(int('53',16))
#ld d,h
rom.append(int('54',16))
#ld d,l
rom.append(int('55',16))
#ld d,(hl)
rom.append(int('56',16))
#ld d,a
rom.append(int('57',16))
#ld e,b
rom.append(int('58',16))
#ld e,c
rom.append(int('59',16))
#ld e,d
rom.append(int('5A',16))
#ld e,e
rom.append(int('5B',16))
#ld e,h
rom.append(int('5C',16))
#ld e,l
rom.append(int('5D',16))
#ld e,(hl)
rom.append(int('5E',16))
#ld e,a
rom.append(int('5F',16))
#----------
#ld h,b
rom.append(int('60',16))
#ld h,c
rom.append(int('61',16))
#ld h,d
rom.append(int('62',16))
#ld h,e
rom.append(int('63',16))
#ld h,h
rom.append(int('64',16))
#ld h,l
rom.append(int('65',16))
#ld h,(hl)
rom.append(int('66',16))
#ld h,a
rom.append(int('67',16))
#ld l,b
rom.append(int('68',16))
#ld l,c
rom.append(int('69',16))
#ld l,d
rom.append(int('6A',16))
#ld l,e
rom.append(int('6B',16))
#ld l,h
rom.append(int('6C',16))
#ld l,l
rom.append(int('6D',16))
#ld l,(hl)
rom.append(int('6E',16))
#ld l,a
rom.append(int('6F',16))
#----------
#ld (hl),b
rom.append(int('70',16))
#ld (hl),c
rom.append(int('71',16))
#ld (hl),d
rom.append(int('72',16))
#ld (hl),e
rom.append(int('73',16))
#ld (hl),h
rom.append(int('74',16))
#ld (hl),l
rom.append(int('75',16))
#halt
rom.append(int('76',16))
#ld (hl),a
rom.append(int('77',16))
#ld a,b
rom.append(int('78',16))
#ld a,c
rom.append(int('79',16))
#ld a,d
rom.append(int('7A',16))
#ld a,e
rom.append(int('7B',16))
#ld a,h
rom.append(int('7C',16))
#ld a,l
rom.append(int('7D',16))
#ld a,(hl)
rom.append(int('7E',16))
#ld a,a
rom.append(int('7F',16))
#----------
#add a,b
rom.append(int('80',16))
#add a,c
rom.append(int('81',16))
#add a,d
rom.append(int('82',16))
#add a,e
rom.append(int('83',16))
#add a,h
rom.append(int('84',16))
#add a,l
rom.append(int('85',16))
#add a,(hl)
rom.append(int('86',16))
#add a,a
rom.append(int('87',16))
#adc a,b
rom.append(int('88',16))
#adc a,c
rom.append(int('89',16))
#adc a,d
rom.append(int('8A',16))
#adc a,e
rom.append(int('8B',16))
#adc a,h
rom.append(int('8C',16))
#adc a,l
rom.append(int('8D',16))
#adc a,(hl)
rom.append(int('8E',16))
#adc a,a
rom.append(int('8F',16))
#----------
#sub b
rom.append(int('90',16))
#sub c
rom.append(int('91',16))
#sub d
rom.append(int('92',16))
#sub e
rom.append(int('93',16))
#sub h
rom.append(int('94',16))
#sub l
rom.append(int('95',16))
#sub (hl)
rom.append(int('96',16))
#sub a
rom.append(int('97',16))
#sbc a,b
rom.append(int('98',16))
#sbc a,c
rom.append(int('99',16))
#sbc a,d
rom.append(int('9A',16))
#sbc a,e
rom.append(int('9B',16))
#sbc a,h
rom.append(int('9C',16))
#sbc a,l
rom.append(int('9D',16))
#sbc a,(hl)
rom.append(int('9E',16))
#sbc a,a
rom.append(int('9F',16))
#----------
#and b
rom.append(int('A0',16))
#and c
rom.append(int('A1',16))
#and d
rom.append(int('A2',16))
#and e
rom.append(int('A3',16))
#and h
rom.append(int('A4',16))
#and l
rom.append(int('A5',16))
#and (hl)
rom.append(int('A6',16))
#and a
rom.append(int('A7',16))
#xor b
rom.append(int('A8',16))
#xor c
rom.append(int('A9',16))
#xor d
rom.append(int('AA',16))
#xor e
rom.append(int('AB',16))
#xor h
rom.append(int('AC',16))
#xor l
rom.append(int('AD',16))
#xor (hl)
rom.append(int('AE',16))
#xor a
rom.append(int('AF',16))
#----------
#or b
rom.append(int('B0',16))
#or c
rom.append(int('B1',16))
#or d
rom.append(int('B2',16))
#or e
rom.append(int('B3',16))
#or h
rom.append(int('B4',16))
#or l
rom.append(int('B5',16))
#or (hl)
rom.append(int('B6',16))
#or a
rom.append(int('B7',16))
#cp b
rom.append(int('B8',16))
#cp c
rom.append(int('B9',16))
#cp d
rom.append(int('BA',16))
#cp e
rom.append(int('BB',16))
#cp h
rom.append(int('BC',16))
#cp l
rom.append(int('BD',16))
#cp (hl)
rom.append(int('BE',16))
#cp a
rom.append(int('BF',16))
#----------
#ret nz
rom.append(int('C0',16))
#pop bc
rom.append(int('C1',16))
#jp NZ,16
rom.append(int('C2',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#jp 16
rom.append(int('C3',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#call nz,16
rom.append(int('C4',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#push bc
rom.append(int('C5',16))
#add a,8
rom.append(int('C6',16))
rom.append(int('AA',16))
#rst 00
rom.append(int('C7',16))
#ret Z
rom.append(int('C8',16))
#ret
rom.append(int('C9',16))
#jp z,16
rom.append(int('CA',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#prefix cb
#rom.append(int('CB',16))
#call z,16
rom.append(int('CC',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#call 16
rom.append(int('CD',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#adc a,8
rom.append(int('CE',16))
rom.append(int('AA',16))
#rst 08
rom.append(int('CF',16))
#----------
#ret nc
rom.append(int('D0',16))
#pop de
rom.append(int('D1',16))
#jp NC,16
rom.append(int('D2',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#call nc,16
rom.append(int('D4',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#push de
rom.append(int('D5',16))
#sub a,8
rom.append(int('D6',16))
rom.append(int('AA',16))
#rst 10
rom.append(int('D7',16))
#ret C
rom.append(int('D8',16))
#reti
rom.append(int('D9',16))
#jp c,16
rom.append(int('DA',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#call c,16
rom.append(int('DC',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#sbc a,8
rom.append(int('DE',16))
rom.append(int('AA',16))
#rst 18
rom.append(int('DF',16))
#----------
#ldh (8),a
rom.append(int('E0',16))
rom.append(int('AA',16))
#pop hl
rom.append(int('E1',16))
#ld (c),a
rom.append(int('D2',16))
rom.append(int('AA',16))
#push hl
rom.append(int('E5',16))
#and a,8
rom.append(int('E6',16))
#rst 20
rom.append(int('E7',16))
#add sp,8
rom.append(int('E8',16))
#jp (hl)
rom.append(int('E9',16))
#ld (16),a
rom.append(int('EA',16))
#xor a,8
rom.append(int('EE',16))
#rst 28
rom.append(int('EF',16))
#----------
#ldh a,(8)
rom.append(int('F0',16))
rom.append(int('AA',16))
#pop af
rom.append(int('F1',16))
#ld a,(c)
rom.append(int('F2',16))
rom.append(int('AA',16))
#di
rom.append(int('F3',16))
#push af
rom.append(int('F5',16))
#or a,8
rom.append(int('F6',16))
rom.append(int('AA',16))
#rst 30
rom.append(int('F7',16))
#ld hl,sp+8
rom.append(int('F8',16))
rom.append(int('AA',16))
#ld sp,hl
rom.append(int('F9',16))
#ld a,(16)
rom.append(int('FA',16))
rom.append(int('EE',16))
rom.append(int('EE',16))
#ei
rom.append(int('FB',16))
#cp a,8
rom.append(int('FE',16))
rom.append(int('AA',16))
#rst 38
rom.append(int('FF',16))

#-------------
#BC
#-------------
#rlc b
appendBC('00')
#rlc c
appendBC('01')
#rlc d
appendBC('02')
#rlc e
appendBC('03')
#rlc h
appendBC('04')
#rlc l
appendBC('05')
#rlc (hl)
appendBC('06')
#rlc a
appendBC('07')
#rrc b
appendBC('08')
#rrc c
appendBC('09')
#rrc d
appendBC('0A')
#rrc e
appendBC('0B')
#rrc h
appendBC('0C')
#rrc l
appendBC('0D')
#rrc (hl)
appendBC('0E')
#rrc a
appendBC('0F')
#-------------
#rl b
appendBC('10')
#rl c
appendBC('11')
#rl d
appendBC('12')
#rl e
appendBC('13')
#rl h
appendBC('14')
#rl l
appendBC('15')
#rl (hl)
appendBC('16')
#rl a
appendBC('17')
#rr b
appendBC('18')
#rr c
appendBC('19')
#rr d
appendBC('1A')
#rr e
appendBC('1B')
#rr h
appendBC('1C')
#rr l
appendBC('1D')
#rr (hl)
appendBC('1E')
#rr a
appendBC('1F')
#-------------
#sla b
appendBC('20')
#sla c
appendBC('21')
#sla d
appendBC('22')
#sla e
appendBC('23')
#sla h
appendBC('24')
#sla l
appendBC('25')
#sla (hl)
appendBC('26')
#sla a
appendBC('27')
#sra b
appendBC('28')
#sra d
appendBC('2A')
#sra e
appendBC('2B')
#sra h
appendBC('2C')
#sra l
appendBC('2D')
#sra (hl)
appendBC('2E')
#sra a
appendBC('2F')
#-------------
#swap b
appendBC('30')
#swap c
appendBC('31')
#swap d
appendBC('32')
#swap e
appendBC('33')
#swap h
appendBC('34')
#swap l
appendBC('35')
#swap (hl)
appendBC('36')
#swap a
appendBC('37')
#srl b
appendBC('38')
#srl c
appendBC('39')
#srl d
appendBC('3A')
#srl e
appendBC('3B')
#srl h
appendBC('3C')
#srl l
appendBC('3D')
#srl (hl)
appendBC('3E')
#srl a
appendBC('3F')
#-------------
#bit 0,b
appendBC('40')
#bit 0,c
appendBC('41')
#bit 0,d
appendBC('42')
#bit 0,e
appendBC('43')
#bit 0,h
appendBC('44')
#bit 0,l
appendBC('45')
#bit 0,(hl)
appendBC('46')
#bit 0,a
appendBC('47')
#bit 1,b
appendBC('48')
#bit 1,c
appendBC('49')
#bit 1,d
appendBC('4A')
#bit 1,e
appendBC('4B')
#bit 1,h
appendBC('4C')
#bit 1,l
appendBC('4D')
#bit 1,(hl)
appendBC('4E')
#bit 1,a
appendBC('4F')
#-------------
#bit 2,b
appendBC('50')
#bit 2,c
appendBC('51')
#bit 2,d
appendBC('52')
#bit 2,e
appendBC('53')
#bit 2,h
appendBC('54')
#bit 2,l
appendBC('55')
#bit 2,(hl)
appendBC('56')
#bit 2,a
appendBC('57')
#bit 3,b
appendBC('58')
#bit 3,c
appendBC('59')
#bit 3,d
appendBC('5A')
#bit 3,e
appendBC('5B')
#bit 3,h
appendBC('5C')
#bit 3,l
appendBC('5D')
#bit 3,(hl)
appendBC('5E')
#bit 3,a
appendBC('5F')
#-------------
#bit 4,b
appendBC('60')
#bit 4,c
appendBC('61')
#bit 4,d
appendBC('62')
#bit 4,e
appendBC('63')
#bit 4,h
appendBC('64')
#bit 4,l
appendBC('65')
#bit 4,(hl)
appendBC('66')
#bit 4,a
appendBC('67')
#bit 5,b
appendBC('68')
#bit 5,c
appendBC('69')
#bit 5,d
appendBC('6A')
#bit 5,e
appendBC('6B')
#bit 5,h
appendBC('6C')
#bit 5,l
appendBC('6D')
#bit 5,(hl)
appendBC('6E')
#bit 5,a
appendBC('6F')
#-------------
#bit 6,b
appendBC('70')
#bit 6,c
appendBC('71')
#bit 6,d
appendBC('72')
#bit 6,e
appendBC('73')
#bit 6,h
appendBC('74')
#bit 6,l
appendBC('75')
#bit 6,(hl)
appendBC('76')
#bit 6,a
appendBC('77')
#bit 7,b
appendBC('78')
#bit 7,c
appendBC('79')
#bit 7,d
appendBC('7A')
#bit 7,e
appendBC('7B')
#bit 7,h
appendBC('7C')
#bit 7,l
appendBC('7D')
#bit 7,(hl)
appendBC('7E')
#bit 7,a
appendBC('7F')
#-------------
#res 0,b
appendBC('80')
#res 0,c
appendBC('81')
#res 0,d
appendBC('82')
#res 0,e
appendBC('83')
#res 0,h
appendBC('84')
#res 0,l
appendBC('85')
#res 0,(hl)
appendBC('86')
#res 0,a
appendBC('87')
#res 1,b
appendBC('88')
#res 1,c
appendBC('89')
#res 1,d
appendBC('8A')
#res 1,e
appendBC('8B')
#res 1,h
appendBC('8C')
#res 1,l
appendBC('8D')
#res 1,(hl)
appendBC('8E')
#res 1,a
appendBC('8F')
#-------------
#res 2,b
appendBC('90')
#res 2,c
appendBC('91')
#res 2,d
appendBC('92')
#res 2,e
appendBC('93')
#res 2,h
appendBC('94')
#res 2,l
appendBC('95')
#res 2,(hl)
appendBC('96')
#res 2,a
appendBC('97')
#res 3,b
appendBC('98')
#res 3,c
appendBC('99')
#res 3,d
appendBC('9A')
#res 3,e
appendBC('9B')
#res 3,h
appendBC('9C')
#res 3,l
appendBC('9D')
#res 3,(hl)
appendBC('9E')
#res 3,a
appendBC('9F')
#-------------
#res 4,b
appendBC('A0')
#res 4,c
appendBC('A1')
#res 4,d
appendBC('A2')
#res 4,e
appendBC('A3')
#res 4,h
appendBC('A4')
#res 4,l
appendBC('A5')
#res 4,(hl)
appendBC('A6')
#res 4,a
appendBC('A7')
#res 5,b
appendBC('A8')
#res 5,c
appendBC('A9')
#res 5,d
appendBC('AA')
#res 5,e
appendBC('AB')
#res 5,h
appendBC('AC')
#res 5,l
appendBC('AD')
#res 5,(hl)
appendBC('AE')
#res 5,a
appendBC('AF')
#-------------
#res 6,b
appendBC('B0')
#res 6,c
appendBC('B1')
#res 6,d
appendBC('B2')
#res 6,e
appendBC('B3')
#res 6,h
appendBC('B4')
#res 6,l
appendBC('B5')
#res 6,(hl)
appendBC('B6')
#res 6,a
appendBC('B7')
#res 7,b
appendBC('B8')
#res 7,c
appendBC('B9')
#res 7,d
appendBC('BA')
#res 7,e
appendBC('BB')
#res 7,h
appendBC('BC')
#res 7,l
appendBC('BD')
#res 7,(hl)
appendBC('BE')
#res 7,a
appendBC('BF')
#-------------
#set 0,b
appendBC('C0')
#set 0,c
appendBC('C1')
#set 0,d
appendBC('C2')
#set 0,e
appendBC('C3')
#set 0,h
appendBC('C4')
#set 0,l
appendBC('C5')
#set 0,(hl)
appendBC('C6')
#set 0,a
appendBC('C7')
#set 1,b
appendBC('C8')
#set 1,c
appendBC('C9')
#set 1,d
appendBC('CA')
#set 1,e
appendBC('CB')
#set 1,h
appendBC('CC')
#set 1,l
appendBC('CD')
#set 1,(hl)
appendBC('CE')
#set 1,a
appendBC('CF')
#-------------
#set 2,b
appendBC('D0')
#set 2,c
appendBC('D1')
#set 2,d
appendBC('D2')
#set 2,e
appendBC('D3')
#set 2,h
appendBC('D4')
#set 2,l
appendBC('D5')
#set 2,(hl)
appendBC('D6')
#set 2,a
appendBC('D7')
#set 3,b
appendBC('D8')
#set 3,c
appendBC('D9')
#set 3,d
appendBC('DA')
#set 3,e
appendBC('DB')
#set 3,h
appendBC('DC')
#set 3,l
appendBC('DD')
#set 3,(hl)
appendBC('DE')
#set 3,a
appendBC('DF')
#-------------
#set 4,b
appendBC('E0')
#set 4,c
appendBC('E1')
#set 4,d
appendBC('E2')
#set 4,e
appendBC('E3')
#set 4,h
appendBC('E4')
#set 4,l
appendBC('E5')
#set 4,(hl)
appendBC('E6')
#set 4,a
appendBC('E7')
#set 5,b
appendBC('E8')
#set 5,c
appendBC('E9')
#set 5,d
appendBC('EA')
#set 5,e
appendBC('EB')
#set 5,h
appendBC('EC')
#set 5,l
appendBC('ED')
#set 5,(hl)
appendBC('EE')
#set 5,a
appendBC('EF')
#-------------
#set 6,b
appendBC('F0')
#set 6,c
appendBC('F1')
#set 6,d
appendBC('F2')
#set 6,e
appendBC('F3')
#set 6,h
appendBC('F4')
#set 6,l
appendBC('F5')
#set 6,(hl)
appendBC('F6')
#set 6,a
appendBC('F7')
#set 7,b
appendBC('F8')
#set 7,c
appendBC('F9')
#set 7,d
appendBC('FA')
#set 7,e
appendBC('FB')
#set 7,h
appendBC('FC')
#set 7,l
appendBC('FD')
#set 7,(hl)
appendBC('FE')
#set 7,a
appendBC('FF')

with open("romtest.gb", "bw") as romfile:
    romfile.write(rom)
    romfile.close()


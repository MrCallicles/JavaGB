package Entity;

public class OpCode {
    private String hexa_id;
    private Instruction instruction;
    private Operator operatorSrc;
    private Operator operatorBut;
    private Boolean selected = false;
    private Boolean checking = false;
    private int address = -1;
    private int position = -1;

    public OpCode(){}

    public OpCode(String hexa_id) {
        this.hexa_id = hexa_id;
    }

    public OpCode(OpCode opCode) {
        this.hexa_id = opCode.getHexa_id();
        this.instruction = (opCode.getInstruction()!=null)?new Instruction(opCode.getInstruction()):null;
        this.operatorSrc = (opCode.getOperatorSrc()!=null)?new Operator(opCode.getOperatorSrc()):null;
        this.operatorBut = (opCode.getOperatorBut()!=null)?new Operator(opCode.getOperatorBut()):null;
    }

    public String getHexa_id() {
        return hexa_id;
    }

    public void setHexa_id(String hexa_id) {
        this.hexa_id = hexa_id;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public Operator getOperatorSrc() {
        return operatorSrc;
    }

    public void setOperatorSrc(Operator operatorSrc) {
        this.operatorSrc = operatorSrc;
    }

    public Operator getOperatorBut() {
        return operatorBut;
    }

    public void setOperatorBut(Operator operatorBut) {
        this.operatorBut = operatorBut;
    }

    public void toggle(){
        selected = (selected) ? false : true;
    }

    public void setSelected(Boolean b){
        selected = b;
    }

    public boolean isSelected(){
        return selected;
    }

    public void setChecking(Boolean b){
        checking = b;
    }

    public boolean isChecking(){
        return checking;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getRow(){
        return "ID : "+hexa_id+"\n"
                +"INSTRUCTION : "+((instruction!=null)?instruction.getRow():"null")+"\n"
                +"OPERATEUR SOURCE : "+((operatorSrc!=null)?operatorSrc.getRow():"null")+"\n"
                +"OPERATEUR BUT : "+((operatorBut!=null)?operatorBut.getRow():"null");
    }
}

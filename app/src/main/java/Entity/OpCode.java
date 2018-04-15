package Entity;

public class OpCode {
    private String hexa_id;
    private Instruction instruction;
    private Operator operatorSrc;
    private Operator operatorBut;
    private Boolean selected = false;
    private int position;

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getRow(){
        return "ID : "+hexa_id+"\n"
                +"INSTRUCTION : "+((instruction!=null)?instruction.getRow():"null")+"\n"
                +"OPERATEUR SOURCE : "+((operatorSrc!=null)?operatorSrc.getRow():"null")+"\n"
                +"OPERATEUR BUT : "+((operatorBut!=null)?operatorBut.getRow():"null");
    }
}

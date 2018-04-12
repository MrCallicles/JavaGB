package Entity;

public class OpCode {
    private String hexa_id;
    private Instruction instruction;
    private Operator operatorSrc;
    private Operator operatorBut;

    public OpCode(){}

    public OpCode(String hexa_id) {
        this.hexa_id = hexa_id;
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
}

package day_17;

import shared.DataSet;

public class Program {
    Computer computer;
    private int opcode;
    private int operand;
    int combo;
    boolean isJNZ;

    public Program(DataSet file) {
        this.computer = new Computer(file);
        this.isJNZ = false;
    }

    public void operate() {

    }

    public void runProgram() {
        int i = 0;
        while(i < computer.getInput().length) {
            this.setOpcode(computer.getInput()[i]);
            this.setOperand(computer.getInput()[i + 1]);
            Operations operation = Operations.setOpcode(computer.getInput()[i]);
            System.out.println("Main loop: Opcode=" + getOpcode() + " Operand=" + getOperand());
            operation.operate(this);
            i += 2;
            if(isJNZ) {
                i = getOperand();
                System.out.println("i=" + i + " operand:=" + getOperand());

            }
            isJNZ = false;

        }
        System.out.println("output: ");
        for(Integer out : computer.getOutput()) {
            System.out.print(out);
        }
        System.out.println();
        System.out.println("A: " + computer.getA());
        System.out.println("B: " + computer.getB());
        System.out.println("C: " + computer.getC());
    }

    public void setCombo(int operand) {
        switch (operand) {
            case 0, 1, 2, 3:
                this.combo = operand;
                break;
            case 4:
                this.combo = computer.getA();
                break;
            case 5:
                this.combo = computer.getB();
                break;
            case 6:
                this.combo = computer.getC();
                break;
            default:
                break;
        }
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public int getOperand() {
        return operand;
    }
}

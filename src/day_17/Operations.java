package day_17;

public enum Operations {
    ADV(0) {
        @Override
        void operate(Program p) {
            p.setCombo(p.getOperand());
            int result = (int) (p.computer.getA() / Math.pow(2, p.combo));
            p.computer.setA(result);
            System.out.println("ADV " + p.computer.getA());
        }
    },

    BXL(1) {
        @Override
        void operate(Program p) {
            System.out.println("Register B: " + p.computer.getB());
            int result = p.computer.getB() ^ p.getOperand();
            p.computer.setB(result);
            System.out.println("result: " + result + " B: " + p.computer.getB());
        }
    },

    BST(2) {
      @Override
      void operate(Program p) {
          p.setCombo(p.getOperand());
          int result = p.combo % 8;
          p.computer.setB(result);
          System.out.println("combo: " + p.combo + " B: " + p.computer.getB());
      }
    },

    JNZ(3) {
        @Override
        void operate(Program p) {
            System.out.println("pętla");
            p.isJNZ = p.computer.getA() != 0;
        }
    },

    BXC(4) {
        @Override
        void operate(Program p) {
            int result = p.computer.getB() ^ p.computer.getC();
            p.computer.setB(result);
            System.out.println("B: " + p.computer.getB());
        }
    },

    OUT(5) {
        @Override
        void operate(Program p) {
            p.setCombo(p.getOperand());
            System.out.println("Combo: " + p.combo + " operand: " + p.getOperand());
            int result = p.combo % 8;
            p.computer.addResult(result);
            System.out.println("Output: " + result);
        }
    },

    BDV(6) {
        @Override
        void operate(Program p) {
            p.setCombo(p.getOperand());
            int result = p.computer.getA() / (int) Math.pow(2, p.combo);
            p.computer.setB(result);
            System.out.println("B: " + p.computer.getB());
        }
    },

    CDV(7) {
        @Override
        void operate(Program p) {
            p.setCombo(p.getOperand());
            int result = p.computer.getA() / (int) Math.pow(2, p.combo);
            p.computer.setC(result);
            System.out.println("C: " + p.computer.getC());
        }
    };


    private final int opcode;

    Operations(int opcode){
        this.opcode = opcode;
    }

    public static Operations setOpcode(int opcode) {
        for(Operations op : values()) {
            if(op.opcode == opcode) {
                return op;
            }
        }
        throw new IllegalArgumentException();
    }

    abstract void operate(Program program);
}

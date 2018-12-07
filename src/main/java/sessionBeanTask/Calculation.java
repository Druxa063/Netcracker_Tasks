package sessionBeanTask;

import javax.ejb.Stateful;

@Stateful
public class Calculation {

    private int operand_A;
    private int operand_B;
    private int currentResult;
    private int memory;

    public void addition() {
        System.out.println("Method addition" + " a " + operand_A + " , b " + operand_B);
        currentResult = operand_A + operand_B;
    }

    public void subtraction() {
        currentResult = operand_A - operand_B;
    }

    public void multiplication() {
        currentResult = operand_A * operand_B;
    }

    public void division() {
        currentResult = operand_A / operand_B;
    }

    public void saveCurrentResultInMemory() {
        memory = currentResult;
    }

    public void extractMemoryInOperands() {
        operand_A = memory;
        operand_B = memory;
    }

    public void resetMemory() {
        memory = 0;
    }

    public int getOperand_A() {
        return operand_A;
    }

    public void setOperand_A(int operand_A) {
        System.out.println("Method setOperand_A");
        this.operand_A = operand_A;
    }

    public int getOperand_B() {
        return operand_B;
    }

    public void setOperand_B(int operand_B) {
        this.operand_B = operand_B;
    }

    public int getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getJSON() {
        return "{" +
                "\"operand_A\":" + operand_A +
                ", \"operand_B\":" + operand_B +
                ", \"currentResult\":" + currentResult +
                ", \"memory\":" + memory +
                "}";
    }
}

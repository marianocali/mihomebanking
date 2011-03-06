package bkc1003;


public class CalculatorBean {
  private int memory;
  
  public void setMemory(int number) {
    memory = number;
  }
 
  public int getMemory() {
    return memory;
  }
  public int doubleIt(int number) {
    return 2 * number;
  }
}

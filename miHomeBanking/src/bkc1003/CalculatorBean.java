package bkc1003;


public class CalculatorBean {
  private int memory;
  private int saldo;
  
  public int getSaldo() {
	saldo = doubleIt(saldo);   
	return saldo;
}

public void setSaldo(int saldo) {
	this.saldo = saldo;
	saldo = doubleIt(saldo);
}

public void setMemory(int number) {
    memory = number +2;
  }
 
  public int getMemory() {
    return memory;
  }
  public int doubleIt(int number) {
    return 2 * number;
    
  }
}

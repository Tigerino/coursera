package ml.math;

import java.math.BigDecimal;

public class Matrix {

  private BigDecimal[][] values;

  public BigDecimal getElementAt(int rowNo, int colNo) {
    return values[rowNo][colNo];
  }
  
  
}

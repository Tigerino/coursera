package ml.alg;

import java.math.BigDecimal;

public class ThetaValue {

  private BigDecimal theta1;

  private BigDecimal theta2;

  public ThetaValue(BigDecimal theta1, BigDecimal theta2) {
    this.theta1 = theta1;
    this.theta2 = theta2;
  }

  public BigDecimal getTheta1() {
    return theta1;
  }

  public BigDecimal getTheta2() {
    return theta2;
  }

  @Override
  public String toString() {
    return "t1=" + theta1.toPlainString() + ", t2=" + theta2.toPlainString();
  }
}
package ml.alg.hypos;

import java.math.BigDecimal;

import ml.alg.Hypothesis;

public class LinearHypothesisFunction implements Hypothesis {

  @Override
  public BigDecimal calculate(BigDecimal theta1, BigDecimal theta2, BigDecimal x) {
    return theta1.add(theta2.multiply(x));
  }

}

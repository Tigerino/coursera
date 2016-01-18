package ml.alg;

import java.math.BigDecimal;

public interface Hypothesis {
  BigDecimal calculate(BigDecimal theta1, BigDecimal theta2, BigDecimal x);
}

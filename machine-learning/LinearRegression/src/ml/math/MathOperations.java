package ml.math;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class MathOperations {

  public static final BiFunction<BigDecimal, BigDecimal, BigDecimal> ADD = (a, b) -> a.add(b);
  
  public static final BiFunction<BigDecimal, BigDecimal, BigDecimal> SUBTRACT = (a, b) -> a.subtract(b);
  
  public static final BiFunction<BigDecimal, BigDecimal, BigDecimal> MULTIPLY = (a, b) -> a.multiply(b);
  
  public static final BiFunction<BigDecimal, BigDecimal, BigDecimal> DIVIDE = (a, b) -> a.divide(b);
  
  
}

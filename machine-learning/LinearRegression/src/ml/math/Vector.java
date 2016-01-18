package ml.math;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class Vector {

  private final BigDecimal[] values;

  public Vector(BigDecimal... values) {
    this.values = values;
  }

  public int getDimension() {
    return values.length;
  }

  public BigDecimal[] getValues() {
    return this.values;
  }

  public BigDecimal getValue(int index) {
    return this.values[index];
  }

  private Vector calculate(Vector other, BiFunction<BigDecimal, BigDecimal, BigDecimal> function) {
    if (this.getDimension() != other.getDimension()) {
      throw new IncompatibleOperandException("Cannot add vectors with different dimensions: " + this + " + " + other);
    }

    BigDecimal[] resultValues = new BigDecimal[this.getDimension()];

    for (int i = 0; i < this.values.length; i++) {
      resultValues[i] = function.apply(this.values[i], other.getValue(i));
    }

    return new Vector(resultValues);

  }

  public Vector add(Vector other) {
    return calculate(other, MathOperations.ADD);
  }

  public Vector subtract(Vector other) {
    return calculate(other, MathOperations.SUBTRACT);
  }
  
  public Vector divide(Vector other) {
    return calculate(other, MathOperations.DIVIDE);
  }
  
  public Vector multiply(Vector other) {
    return calculate(other, MathOperations.MULTIPLY);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Vector[");
    sb.append("dim=" + this.getDimension() + ",");

    for (BigDecimal decimal : this.values) {
      sb.append(" ");
      sb.append(decimal.toPlainString());
    }

    sb.append("]");
    return sb.toString();
  }
}
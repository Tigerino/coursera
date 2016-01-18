package ml.data;

import java.math.BigDecimal;

public class Data {

  private BigDecimal x;

  private BigDecimal y;

  public Data(String x, String y) {
    this(new BigDecimal(x), new BigDecimal(y));
  }

  public Data(BigDecimal x, BigDecimal y) {
    this.x = x;
    this.y = y;
  }

  public BigDecimal getX() {
    return x;
  }

  public BigDecimal getY() {
    return y;
  }
}
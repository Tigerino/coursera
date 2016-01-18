package ml.alg;

import java.math.BigDecimal;

import ml.data.Data;
import ml.data.DataSource;

public class CostMatrix {

  private final BigDecimal[] costs;

  private BigDecimal totalCost = BigDecimal.ZERO;

  private BigDecimal squarredErrorCost = BigDecimal.ZERO;

  public CostMatrix(Hypothesis hypothesis, DataSource source, BigDecimal theta1, BigDecimal theta2) {
    Data[] dataSet = source.fetch();

    this.costs = new BigDecimal[dataSet.length];

    for (int i = 0; i < dataSet.length; i++) {
      Data data = dataSet[i];

      costs[i] = hypothesis.calculate(theta1, theta2, data.getX()).subtract(data.getY());
      totalCost = totalCost.add(costs[i]);
      squarredErrorCost = squarredErrorCost.add(costs[i].pow(2));
    }

  }

  public BigDecimal getSquarredErrorCost() {
    return squarredErrorCost;
  }

  public BigDecimal getTotalCost() {
    return totalCost;
  }

  public BigDecimal getCostForIndex(int idx) {
    return this.costs[idx];
  }

}
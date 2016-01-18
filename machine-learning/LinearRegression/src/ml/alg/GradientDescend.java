package ml.alg;

import java.math.BigDecimal;
import java.math.MathContext;

import ml.data.Data;
import ml.data.DataSource;

public class GradientDescend {

  private Hypothesis hypothesis;

  private DataSource source;

  private BigDecimal theta1 = BigDecimal.ZERO;

  private BigDecimal theta2 = BigDecimal.ZERO;

  private BigDecimal learningFactor = BigDecimal.valueOf(0.000002d);

  private final int MAXIMUM_ITERATIONS = 3000000;

  private final BigDecimal FINISH_AFTER_REACHING_PRECISION = BigDecimal.valueOf(0.000001);

  private final int HEARTBEAT_EVERY_ITERATIONS = 500;
  
  public GradientDescend(Hypothesis hypothesis, DataSource source) {
    this.hypothesis = hypothesis;
    this.source = source;
  }

  public void start() {
    BigDecimal lastSquaredErrorCost = null;

    theta1 = BigDecimal.valueOf(0);
    theta2 = BigDecimal.valueOf(0);
    
    System.out.println("Starting descend at t0=" + theta1.toPlainString() + ", t1=" + theta2.toPlainString());
    System.out.println("Learning Factor: " + learningFactor.toPlainString());
    System.out.println("Max iterations:" + MAXIMUM_ITERATIONS);
    System.out.println("Finish descend after cost delta below: " + FINISH_AFTER_REACHING_PRECISION.toPlainString());

    for (int i = 0; i < MAXIMUM_ITERATIONS; i++) {
      CostMatrix cost = new CostMatrix(hypothesis, source, theta1, theta2);

      BigDecimal costDelta = lastSquaredErrorCost != null ? cost.getSquarredErrorCost().subtract(lastSquaredErrorCost).abs() : null;
      
      if (costDelta != null && costDelta.compareTo(FINISH_AFTER_REACHING_PRECISION) < 0) {
        System.out.println("Converged at t0=" + theta1.toPlainString() + ", t1=" + theta2.toPlainString());
        System.out.println("Needed " + i + " iterations.");
        return;
      }

      ThetaValue newValue = getNewThethaValues(cost);

      theta1 = newValue.getTheta1();
      theta2 = newValue.getTheta2();

      if(i%HEARTBEAT_EVERY_ITERATIONS == 1){
        System.out.println("Current t0=" + theta1.toPlainString() + ", t2=" + theta2.toPlainString() + ", costDelta=" + costDelta.toPlainString());
      }
      
      lastSquaredErrorCost = cost.getSquarredErrorCost();
    }

    System.out.println("Reached max iteration cycles of " + MAXIMUM_ITERATIONS + " iterations.");
    System.out.println("Current t0=" + theta1.toPlainString() + ", t2" + theta2.toPlainString());
  }

  private ThetaValue getNewThethaValues(CostMatrix costMatrix) {
    BigDecimal theta1New = BigDecimal.ZERO, theta2New = BigDecimal.ZERO;

    Data[] dataList = source.fetch();
    int length = dataList.length;

    for (int i = 0; i < length; i++) {
      Data data = dataList[i];
      BigDecimal cost = costMatrix.getCostForIndex(i);

      theta1New = theta1New.add(cost);
      theta2New = theta2New.add(cost.multiply(data.getX()));
    }

    theta1New = divide(theta1New, length).multiply(learningFactor);
    theta2New = divide(theta2New, length).multiply(learningFactor);

    return new ThetaValue(theta1.subtract(theta1New), theta2.subtract(theta2New));
  }

  private static BigDecimal divide(BigDecimal op1, int op2) {
    return op1.divide(BigDecimal.valueOf(op2), MathContext.DECIMAL128);
  }
}

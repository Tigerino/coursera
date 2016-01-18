package ml.test;

import java.io.IOException;
import java.nio.file.Paths;

import ml.alg.GradientDescend;
import ml.alg.hypos.LinearHypothesisFunction;
import ml.data.CSVDataSource;

public class Test {

  public static void main(String[] args) throws IOException {
    CSVDataSource csvDataSource = new CSVDataSource(Paths.get("C:\\Users\\d047211\\ml\\data.csv"));

    new GradientDescend(new LinearHypothesisFunction(), csvDataSource).start();

  }

}

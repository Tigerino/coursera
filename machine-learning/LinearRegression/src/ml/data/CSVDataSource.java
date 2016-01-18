package ml.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVDataSource implements DataSource {

  private final Data[] data;

  public CSVDataSource(String csv) {
    String[] lines = csv.split("[\\r\\n]+");

    ArrayList<Data> dataList = new ArrayList<>();

    final int i = 0;
    Arrays.stream(lines).forEach((string) -> {
      String[] split = string.split(",");
      dataList.add(new Data(split[0], split[1]));
    });

    data = dataList.toArray(new Data[dataList.size()]);
  }

  public CSVDataSource(Path p) throws IOException {
    this(new String(Files.readAllBytes(p)));
  }

  @Override
  public Data[] fetch() {
    return this.data;
  }
}
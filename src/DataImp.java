/**
 * Created by Chris on 2/3/2017.
 */
import java.util.Random;
public class DataImp implements Data {
  private DataPointImp[] dataPointArray;
  private int dataPointArrayLength;
  private Random randomNumberGenerator;

  public DataImp(float[][] dataPoints) {
    this.dataPointArrayLength = dataPoints.length;
    this.dataPointArray = new DataPointImp[dataPointArrayLength];

    for (int i = 0; i < dataPointArrayLength; ++i) {
      this.dataPointArray[i] = new DataPointImp(dataPoints[i]);
    }
  }

  public DataPoint getRandomDataPoint() {
    int index = randomNumberGenerator.nextInt(this.dataPointArrayLength);
    return dataPointArray[index];
  }

}

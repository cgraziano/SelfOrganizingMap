/**
 * Created by Chris on 2/3/2017.
 */
import java.util.Random;
public class DataImp implements Data {
  private DataPoint[] dataPoints;
  private int numberOfDataPoints;
  private Random randomNumberGenerator;

  public DataImp(float[][] dataPointsFloatArray) {
    initializeRandomNumberGenerator();
    transferDataFromFloatArrayToDataPointsArray(dataPointsFloatArray);
  }

  private void transferDataFromFloatArrayToDataPointsArray(float[][] dataPointsFloatArray) {
    this.numberOfDataPoints = dataPointsFloatArray.length;
    this.dataPoints = new DataPoint[this.numberOfDataPoints];

    for (int i = 0; i < this.numberOfDataPoints; ++i) {
      this.dataPoints[i] = new DataPointImp(dataPointsFloatArray[i]);
    }
  }

  public DataPoint getRandomDataPoint() {
    int index = this.randomNumberGenerator.nextInt(this.numberOfDataPoints);
    return this.dataPoints[index];
  }

  private void initializeRandomNumberGenerator() {
    this.randomNumberGenerator = new Random();
  }

}

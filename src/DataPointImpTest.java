import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Created by Chris on 3/7/2017.
 */
public class DataPointImpTest {

  @Test
  public void vectorDifferenceBetweenTheSameAttributeIsZero() {
    float[] setOfAttributes = {1.0f,2.0f,3.0f};
    DataPoint dataPoint = new DataPointImp(setOfAttributes);
    float[] attributesDiff = dataPoint.differenceBetweenThisAttributesAndTheseAttributes(setOfAttributes);
    arrayOfFloatsContainsAllZeros(attributesDiff);
  }

  private void arrayOfFloatsContainsAllZeros(float[] arrayToTest) {
    int numberOfValues = arrayToTest.length;
    float error = 1.0e-6f;
    for (int i = 0; i < numberOfValues; ++i) {
      float valueToTest = arrayToTest[i];
      Assertions.assertEquals(0.0f, valueToTest, error);
    }
  }
}

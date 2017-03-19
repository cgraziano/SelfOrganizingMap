import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Created by Chris on 3/19/2017.
 */
public class DataImpTest {

  @Test
  public void getMethodReturnsDifferentValuesForDifferentIndices() {
    float[][] arrayOfPointsWithAttributes = buildArrayOfPointsWithAttributes();
    DataImp data = new DataImp(arrayOfPointsWithAttributes);
    DataPoint dataPoint0 = data.getDataPoint(0);
    DataPoint dataPoint2 = data.getDataPoint(2);
    float[] attributes0 = dataPoint0.getAttributes();
    float[] attributes2 = dataPoint2.getAttributes();
    float delta = 1.0e-6f;
    int lengthOfAttributesArrays = attributes0.length;
    Assertions.assertTrue(arraysAreNotEqual(attributes0,attributes2,delta,lengthOfAttributesArrays));

  }

  private float[][] buildArrayOfPointsWithAttributes() {
    int numberOfPoints = 3;
    int numberOfAttributes = 5;
    float[][] arrayOfPointsWithAttributes = new float[numberOfPoints][numberOfAttributes];
    int valueOfAttribute = 0;
    for (int indexOfPoint = 0; indexOfPoint < numberOfPoints; ++indexOfPoint) {
      for (int indexOfAttributre = 0; indexOfAttributre < numberOfAttributes; ++indexOfAttributre) {
        arrayOfPointsWithAttributes[indexOfPoint][indexOfAttributre] = valueOfAttribute;
        ++valueOfAttribute;
      }
    }
    return arrayOfPointsWithAttributes;
  }

  private boolean arraysAreNotEqual(float[] array0, float[] array1, float delta, int lengthOfArrays) {
    for (int i = 0; i < lengthOfArrays; ++i) {
      if ((array0[i] - delta > array1[i]) || (array1[i] >= array0[i] + delta)) {
        return true;
      }
    }
    return false;
  }

}

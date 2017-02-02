/**
 * Created by Chris on 2/2/2017.
 */
public class MinimumValueSaver {
  private float minimumValue = Float.MAX_VALUE;
  private Object objectWithMinimumValue;

  public void compareAndSaveMinimumValueAndCorrespondingObject(float valueToCompareToMinimum, Object object) {
    if (valueToCompareToMinimum<minimumValue) {
      this.minimumValue = valueToCompareToMinimum;
      objectWithMinimumValue = object;
    }
  }

  public float getMinimumValue() {
    return minimumValue;
  }

  public Object getObjectThatMinimumValueCorrespondsTo() {
    return objectWithMinimumValue;
  }
}

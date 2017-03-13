/**
 * Created by Chris on 2/3/2017.
 */
public class DataPointImp implements DataPoint{
  private float[] attributes;

  public DataPointImp(float[] attributes) {
    this.attributes = attributes;
  }

  public float[] getAttributes() {
    return this.attributes;
  }

  public float[] differenceBetweenThisAttributesAndTheseAttributes(float[] otherAttributes) {
    int numberOfAttributes = otherAttributes.length;
    float[] differenceBetweenAttributes = new float[numberOfAttributes];
    for (int i = 0; i < numberOfAttributes; ++i) {
      differenceBetweenAttributes[i] = this.attributes[i] - otherAttributes[i];
    }
    return differenceBetweenAttributes;
  }
}

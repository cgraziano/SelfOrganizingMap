/**
 * Created by Chris on 1/31/2017.
 */
public interface DataPoint {
  float[] getAttributes();
  float[] differenceBetweenThisAttributesAndTheseAttributes(float[] otherAttributes);
}

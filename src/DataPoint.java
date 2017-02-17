/**
 * Created by Chris on 1/31/2017.
 */
public interface DataPoint {
  public float[] getAttributes();
  public float[] differenceBetweenThisAttributesAndTheseAttributes(float[] otherAttributes);
}

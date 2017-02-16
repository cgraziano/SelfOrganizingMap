/**
 * Created by Chris on 2/3/2017.
 */
public class DataPointImp implements DataPoint{
  private float[] attributes;

  public DataPointImp(float[] attributes) {
    this.attributes = attributes;
  }

  public float[] getAttributes() {
    return attributes;
  }
}

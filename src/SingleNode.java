/**
 * Created by Chris on 2/1/2017.
 */
public interface SingleNode {
  public int getNodeID();

  public void setAttributes(float[] attributes);

  public float[] getAttributes();

  public void setLocation(float[] location);

  public float[] getLocation();

  public float calculateDistanceToNode(SingleNode node1);
}

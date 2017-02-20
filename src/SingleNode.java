/**
 * Created by Chris on 2/1/2017.
 */
public interface SingleNode {
  int getNodeID();

  void setAttributes(float[] attributes);

  float[] getAttributes();

  void setLocation(float[] location);

  float[] getLocation();

  float calculateDistanceToNode(SingleNode node1);
}

/**
 * Created by Chris on 2/1/2017.
 */
public class SingleNodeImp implements SingleNode {
  private float[] attributes;
  private float[] location;

  public void setAttributes(float[] attributes) {
    this.attributes = attributes;
  }

  public float[] getAttributes() {
    return this.attributes;
  }

  public void setLocation(float[] location) {
    this.location = location;
  }

  public float[] getLocation() {
    return this.location;
  }

  public float calculateDistanceToNode(SingleNode node1) {
    float thisNodeX = this.location[0];
    float thisNodeY = this.location[1];
    float[] node1Location = node1.getLocation();
    float node1X = node1Location[0];
    float node1Y = node1Location[1];
    float nodeXDiff = thisNodeX - node1X;
    float nodeYDiff = thisNodeY - node1Y;
    float distanceBetweenNodes = (float) Math.sqrt((nodeXDiff*nodeXDiff) + (nodeYDiff*nodeYDiff));
    return distanceBetweenNodes;
  }
}

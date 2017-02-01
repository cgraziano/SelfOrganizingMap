/**
 * Created by Chris on 2/1/2017.
 */
public class SingleNodeImp implements SingleNode {
  private float[] attributes;

  public void setAttributesOfNodes(float[] attributes) {
    this.attributes = attributes;
  }

  public float[] getAttributesOfNode() {
    return this.attributes;
  }
}

/**
 * Created by Chris on 1/31/2017.
 */
public interface NodeContainer {
  public SingleNode findClosestNodeTo(DataPoint dataPoint);
  public void updateSurroundingNodes(float[] centerNode);
}

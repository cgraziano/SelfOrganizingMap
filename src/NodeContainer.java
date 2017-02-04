/**
 * Created by Chris on 1/31/2017.
 */
public interface NodeContainer {
  public SingleNodeImp findClosestNodeTo(DataPointImp dataPoint);
  public void updateSurroundingNodes(SingleNodeImp centerNode);
}

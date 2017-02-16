/**
 * Created by Chris on 1/31/2017.
 */
import java.util.Iterator;

public interface Node2DContainer {
  public SingleNode findClosestNodeTo(DataPoint dataPoint);
  public int getNumberOfNodesInFirstDimension();
  public int getNumberOfNodesInSecondDimension();
  public SingleNode getNodeFromSpecifiedFirstAndSecondDimension(int firstDimensionIndex, int secondDimensionIndex);
  public Iterator<SingleNode> createIterator();
}

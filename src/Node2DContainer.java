/**
 * Created by Chris on 1/31/2017.
 */
import java.util.Iterator;

public interface Node2DContainer {
  SingleNode findClosestNodeTo(DataPoint dataPoint);
  int getNumberOfNodesInFirstDimension();
  int getNumberOfNodesInSecondDimension();
  int getNumberOfAttributesPerNode();
  SingleNode getNodeFromSpecifiedFirstAndSecondDimension(int firstDimensionIndex, int secondDimensionIndex);
  Iterator<SingleNode> createIterator();
}

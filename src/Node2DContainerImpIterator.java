/**
 * Created by Chris on 2/8/2017.
 */
import java.util.Iterator;

public class Node2DContainerImpIterator implements Iterator<SingleNode>{
  private Node2DContainer node2DContainer;
  private int iteratorIndex;
  private int numberOfNodesInFirstDimension;
  private int numberOfNodesInSecondDimension;
  private int numberOfNodes;

  public Node2DContainerImpIterator(Node2DContainer node2DContainer) {
    this.node2DContainer = node2DContainer;
    this.iteratorIndex = 0;
    this.numberOfNodesInFirstDimension = node2DContainer.getNumberOfNodesInFirstDimension();
    this.numberOfNodesInSecondDimension = node2DContainer.getNumberOfNodesInSecondDimension();
    this.numberOfNodes = numberOfNodesInFirstDimension*numberOfNodesInSecondDimension;
  }

  public SingleNode next() {
    int secondDimensionIndex = iteratorIndex/numberOfNodesInSecondDimension;
    int firstDimensionIndex = iteratorIndex%numberOfNodesInSecondDimension;
    increaseIteratorIndex();
    return this.node2DContainer.getNodeFromSpecifiedFirstAndSecondDimension(firstDimensionIndex,secondDimensionIndex);
  }

  public boolean hasNext() {
    return iteratorIndexLessThanNumberOfNodesAvailable();
  }

  private void increaseIteratorIndex() {
    ++iteratorIndex;
  }

  private boolean iteratorIndexLessThanNumberOfNodesAvailable() {
    return iteratorIndex < this.numberOfNodes;
  }


}

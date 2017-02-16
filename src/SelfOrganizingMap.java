import java.util.Iterator;

/**
 * Created by Chris on 1/24/2017.
 */
public class SelfOrganizingMap {
  private Node2DContainer node2DContainer;
  private int numberOfAttributes;
  private int maxIterations;
  private Data trainingData;
  private SingleNode centerNode;

  public SelfOrganizingMap(Node2DContainer node2DContainer) {
    this.node2DContainer = node2DContainer;
  }


  public void trainSelfOrganizingMap(Data trainingData, int maxIterations) {
    this.trainingData = trainingData;
    this.maxIterations = maxIterations;
    stepThroughTrainingIterations();
  }

  public void stepThroughTrainingIterations() {
    for (int iteration=0; iteration<maxIterations; ++iteration) {
      performOneTrainingIteration();
    }
  }

  public void performOneTrainingIteration() {
    DataPoint randomPoint = getRandomPointFromTrainingData();
    SingleNode closestNode = node2DContainer.findClosestNodeTo(randomPoint);
    updateAttributesOfSurroundingNodes(closestNode);
  }

  public void updateAttributesOfSurroundingNodes(SingleNode centerNode) {
    this.centerNode = centerNode;
    float distanceBeweenNodes = 0.0f;
    float scalarToUpdateNodeAttributes = 0.0f;
    Iterator<SingleNode> nodeContainerIterator = this.node2DContainer.createIterator();
    while (nodeContainerIterator.hasNext()) {
      updateNode(nodeContainerIterator.next());
    }
  }

  private void updateNode(SingleNode nodeToUpdate) {
    float distanceBeweenNodes = centerNode.calculateDistanceToNode(nodeToUpdate);
    scalarToUpdateNodeAttributes = 2.0f;
  }

  public DataPoint getRandomPointFromTrainingData() {
    return trainingData.getRandomDataPoint();
  }


}

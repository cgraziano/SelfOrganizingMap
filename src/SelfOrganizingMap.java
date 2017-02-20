import java.util.Iterator;

/**
 * Created by Chris on 1/24/2017.
 */
public class SelfOrganizingMap {
  private Node2DContainer node2DContainer;
  private int numberOfAttributes;
  private int maxIterations;
  private int currentIteration;
  private Data trainingData;
  private SingleNode centerNode;
  private DataPoint randomPoint;
  private int numberOfIterationsForLargeNeighborhoods;
  private float neighborhoodRadius;
  private float weightOnDifferenceInDataAndNodeAttributes;

  public SelfOrganizingMap(Node2DContainer node2DContainer) {
    this.node2DContainer = node2DContainer;
    this.numberOfAttributes = this.node2DContainer.getNumberOfAttributesPerNode();
    initializeNeighborhoodRadius();
  }

  public void trainSelfOrganizingMap(Data trainingData, int maxIterations) {
    this.trainingData = trainingData;
    this.maxIterations = maxIterations;
    this.numberOfIterationsForLargeNeighborhoods = calculateNumberOfIterationsForLargeNeighborhoods(maxIterations);
    stepThroughTrainingIterations();
  }

  public void stepThroughTrainingIterations() {
    for (this.currentIteration=0; this.currentIteration<this.maxIterations; ++this.currentIteration) {
      performOneTrainingIteration();
    }
  }

  public void performOneTrainingIteration() {
    this.randomPoint = getRandomPointFromTrainingData();
    SingleNode closestNode = this.node2DContainer.findClosestNodeTo(this.randomPoint);
    updateAttributesOfSurroundingNodes(closestNode);
  }

  public void updateAttributesOfSurroundingNodes(SingleNode centerNode) {
    this.centerNode = centerNode;
    Iterator<SingleNode> nodeContainerIterator = this.node2DContainer.createIterator();
    while (nodeContainerIterator.hasNext()) {
      updateNode(nodeContainerIterator.next());
    }
  }

  public Node2DContainer getNodesOfSelfOrganizingMap() {
    return this.node2DContainer;
  }

  private void updateNode(SingleNode nodeToUpdate) {
    if (currentIterationIsLessThan(this.numberOfIterationsForLargeNeighborhoods)) {
      this.weightOnDifferenceInDataAndNodeAttributes =
              0.9f*(1.0f-this.currentIteration/this.numberOfIterationsForLargeNeighborhoods);
      updateNodeWithLargeNeighborhood(nodeToUpdate);
    }
    else {
      this.weightOnDifferenceInDataAndNodeAttributes = 0.01f;
      updateNodeWithSmallNeighborhood(nodeToUpdate);
    }
  }

  private void updateNodeWithLargeNeighborhood(SingleNode nodeToUpdate) {
    if (nodeIsWithinUpdatingNeighborhoodZone(nodeToUpdate)) {
      float[] differenceBetweenDataAndNodeAttriutes =
              randomPoint.differenceBetweenThisAttributesAndTheseAttributes(nodeToUpdate.getAttributes());
      float[] newAttributes = new float[this.numberOfAttributes];
      for (int i = 0; i < this.numberOfAttributes; ++i) {
        newAttributes[i] = nodeToUpdate.getAttributes()[i] +
                differenceBetweenDataAndNodeAttriutes[i]*this.weightOnDifferenceInDataAndNodeAttributes;
      }
      nodeToUpdate.setAttributes(newAttributes);
    }
  }

  private void updateNodeWithSmallNeighborhood(SingleNode nodeToUpdate) {
    if (nodeIsWithinUpdatingNeighborhoodZone(nodeToUpdate)) {
      float[] differenceBetweenDataAndNodeAttriutes =
              randomPoint.differenceBetweenThisAttributesAndTheseAttributes(nodeToUpdate.getAttributes());
      float[] newAttributes = new float[this.numberOfAttributes];
      for (int i = 0; i < this.numberOfAttributes; ++i) {
        newAttributes[i] = nodeToUpdate.getAttributes()[i] +
                differenceBetweenDataAndNodeAttriutes[i]*this.weightOnDifferenceInDataAndNodeAttributes;
      }
      nodeToUpdate.setAttributes(newAttributes);
    }
  }

  private boolean currentIterationIsLessThan(int iterationMark) {
    return this.currentIteration < iterationMark;
  }

  private void initializeNeighborhoodRadius() {
    this.neighborhoodRadius = this.node2DContainer.getNumberOfNodesInFirstDimension();
  }

  private boolean nodeIsWithinUpdatingNeighborhoodZone(SingleNode node) {
    float distanceToCenterNode = this.centerNode.calculateDistanceToNode(node);
    return distanceToCenterNode < this.neighborhoodRadius;
  }

  private int calculateNumberOfIterationsForLargeNeighborhoods(int maxIterations) {
    if (maxIterations > 1000) {
      return 1000;
    }
    else {
      return (int) (0.1*maxIterations);
    }

  }

  public DataPoint getRandomPointFromTrainingData() {
    return trainingData.getRandomDataPoint();
  }


}

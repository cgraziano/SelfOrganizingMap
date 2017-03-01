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
  private int numberOfIterationsForLargeNeighborhoodUpdates;
  private float startingNeighborhoodRadius;
  private float currentNeighborhoodRadius;
  private float weightOnDifferenceInDataAndNodeAttributes;

  public SelfOrganizingMap(Node2DContainer node2DContainer) {
    this.node2DContainer = node2DContainer;
    this.numberOfAttributes = this.node2DContainer.getNumberOfAttributesPerNode();
    initializeNeighborhoodRadius();
  }

  private void initializeNeighborhoodRadius() {
    this.startingNeighborhoodRadius = this.node2DContainer.getNumberOfNodesInFirstDimension()*0.5f;
    this.currentNeighborhoodRadius = this.startingNeighborhoodRadius;
  }


  public void trainSelfOrganizingMap(Data trainingData, int maxIterations) {
    this.trainingData = trainingData;
    this.maxIterations = maxIterations;
    initializeNumberOfIterationsForLargeNeighborhoodUpdates();
    initializeWeightOnDifferenceBetweenNodeAndDataAttributes();
    stepThroughTrainingIterations();
  }

  private void initializeNumberOfIterationsForLargeNeighborhoodUpdates() {
    if (this.maxIterations > 1000) {
      this.numberOfIterationsForLargeNeighborhoodUpdates = 1000;
    }
    else {
      this.numberOfIterationsForLargeNeighborhoodUpdates = (int) (0.1*maxIterations);
    }
  }

  private void initializeWeightOnDifferenceBetweenNodeAndDataAttributes() {
    this.weightOnDifferenceInDataAndNodeAttributes =
            0.9f*(1.0f-this.currentIteration/this.numberOfIterationsForLargeNeighborhoodUpdates);
  }

  public void stepThroughTrainingIterations() {
    for (this.currentIteration=0; this.currentIteration<this.maxIterations; ++this.currentIteration) {
      performOneTrainingIteration();
      decreaseUpdateNeighborhoodSize();
      updateWeightOnDifferenceBetweenNodeAndDataAttributes();
    }
  }

  private void performOneTrainingIteration() {
    this.randomPoint = getRandomPointFromTrainingData();
    SingleNode closestNode = this.node2DContainer.findClosestNodeTo(this.randomPoint);
    updateAttributesOfSurroundingNodes(closestNode);
  }

  private void decreaseUpdateNeighborhoodSize() {
    if (this.currentIteration < this.numberOfIterationsForLargeNeighborhoodUpdates) {
      this.currentNeighborhoodRadius = -((this.startingNeighborhoodRadius-1.0f)/(this.numberOfIterationsForLargeNeighborhoodUpdates))*
              this.currentIteration+this.startingNeighborhoodRadius;
    } else {
      this.currentNeighborhoodRadius = 1.0f;
    }
  }

  private void updateWeightOnDifferenceBetweenNodeAndDataAttribute() {
    if (currentIterationIsLessThan(this.numberOfIterationsForLargeNeighborhoodUpdates)) {
      this.weightOnDifferenceInDataAndNodeAttributes =
              0.9f*(1.0f-this.currentIteration/this.numberOfIterationsForLargeNeighborhoodUpdates);
    }
    else {
      this.weightOnDifferenceInDataAndNodeAttributes = 0.01f;
    }
  }

  public void updateAttributesOfSurroundingNodes(SingleNode centerNode) {
    this.centerNode = centerNode;
    Iterator<SingleNode> nodeContainerIterator = this.node2DContainer.createIterator();
    while (nodeContainerIterator.hasNext()) {
      SingleNode node = nodeContainerIterator.next();
      if (nodeWithinUpdateNeighborhood(node));
        updateAttributesOfNode(nodeContainerIterator.next());
    }
  }

  private boolean nodeWithinUpdateNeighborhood(SingleNode node) {
    float distanceToCenterNode = this.centerNode.calculateDistanceToNode(node);
    return distanceToCenterNode < this.currentNeighborhoodRadius;
  }

  private void updateAttributesOfNode(SingleNode nodeToUpdate) {
    if (currentIterationIsLessThan(this.numberOfIterationsForLargeNeighborhoodUpdates)) {
      this.weightOnDifferenceInDataAndNodeAttributes =
              0.9f*(1.0f-this.currentIteration/this.numberOfIterationsForLargeNeighborhoodUpdates);
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



  public Node2DContainer getNodesOfSelfOrganizingMap() {
    return this.node2DContainer;
  }


  public DataPoint getRandomPointFromTrainingData() {
    return trainingData.getRandomDataPoint();
  }


}

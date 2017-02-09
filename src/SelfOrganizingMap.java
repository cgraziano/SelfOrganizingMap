/**
 * Created by Chris on 1/24/2017.
 */
public class SelfOrganizingMap {
  private NodeContainer nodeContainer;
  private int numberOfAttributes;
  private int maxIterations;
  private Data trainingData;
  private SingleNode centerNode;

  public SelfOrganizingMap(NodeContainer nodeContainer) {
    this.nodeContainer = nodeContainer;
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
    DataPointImp randomPoint = getRandomPointFromTrainingData();
    SingleNodeImp closestNode = nodeContainer.findClosestNodeTo(randomPoint);
    updateAttributesOfSurroundingNodes(closestNode);
  }

  public void updateAttributesOfSurroundingNodes(SingleNodeImp centerNode) {
    this.centerNode = centerNode;
    float distanceBeweenNodes = 0.0f;
    float scalarToUpdateNodeAttributes = 0.0f;
    //TODO For all nodes. update node// understand iterators.
    for (int i = 0; i < nodesInSecondDimension; ++i) {
      for (int j = 0; j < nodesInFirstDimension; ++j) {
        updateNodes(this.nodes[i][j]);
      }
    }
  }

  private void updateNodes(SingleNodeImp nodeToUpdated) {
    distanceBeweenNodes = centerNode.calculateDistanceToNode(this.nodes[i][j]);
    scalarToUpdateNodeAttributes =
  }

  public DataPointImp getRandomPointFromTrainingData() {
    return trainingData.getRandomDataPoint();
  }


}

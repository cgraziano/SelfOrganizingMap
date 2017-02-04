/**
 * Created by Chris on 1/24/2017.
 */
public class SelfOrganizingMap {
  private NodeContainer nodeContainer;
  private int numberOfAttributes;
  private int maxIterations;
  private Data trainingData;

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
    nodeContainer.updateSurroundingNodes(closestNode);
  }

  public DataPointImp getRandomPointFromTrainingData() {
    return trainingData.getRandomDataPoint();
  }


}

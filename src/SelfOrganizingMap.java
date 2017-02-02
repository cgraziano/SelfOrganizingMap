/**
 * Created by Chris on 1/24/2017.
 */
public class SelfOrganizingMap {
  private NodeContainer nodeContainer;
  private int numberOfAttributes;
  private int maxIterations;
  private TrainingData trainingData;

  public SelfOrganizingMap(NodeContainer nodeContainer, int numberOfNodeAttributes) {
    this.nodeContainer = nodeContainer;
    this.numberOfAttributes = numberOfNodeAttributes;
  }


  public void trainSelfOrganizingMap(TrainingData trainingData, int maxIterations) {
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
    SingleNode closestNode = nodeContainer.findClosestNodeTo(randomPoint);
    nodeContainer.updateSurroundingNodes(closestNode);
  }

  public DataPoint getRandomPointFromTrainingData() {
    return trainingData.getRandomPoint();
  }


}

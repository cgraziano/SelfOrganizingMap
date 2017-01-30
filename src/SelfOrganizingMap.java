/**
 * Created by Chris on 1/24/2017.
 */
public class SelfOrganizingMap {
  private int numberOfNodesInX;
  private int numberOfNodesInY;
  private int numberOfAttributes;
  private TrainingData trainingData;

  public SelfOrganizingMap(int nodesInXDirection, int nodesInYDirection, int numberOfNodeAttributes) {
      this.numberOfNodesInX = nodesInXDirection;
      this.numberOfNodesInY = nodesInYDirection;
      this.numberOfAttributes = numberOfNodeAttributes;
  }


  public void trainSelfOrganizingMap(TrainingData trainingData) {
      this.trainingData = trainingData;
      stepThroughTrainingIterations();
  }

  public void stepThroughTrainingIterations() {
    for (int iteration=0; iteration<maxIterations; ++iteration) {
      performOneTrainingIteration();
    }
  }

  public void performOneTrainingIteration() {
    randomPoint = getRandomPointFromTrainingData();
    NodeLocation nodeLocation = findClosestNode(randomPoint);
    updateSurroundingNodes(nodeLocation);
  }

  public TrainingDataPoint getRandomPointFromTrainingData() {
    return trainingData.getRandomPoint;
  }

  public float[] findClosestNode(float[] point) {
  }

  public void updateSurroundingNodes(NodeLocation nodeLocation) {
  }

  public float[][] classifyDataWithTrainedSelfOrganizingMap(float[][] inputData, SelfOrganizingMap) {

  }

}

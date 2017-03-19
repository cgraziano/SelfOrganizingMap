/**
 * Created by Chris on 2/2/2017.
 */
import java.util.Random;

public class testSelfOrganizingMap {

  public static void main(String[] arg) {
    testSelfOrganizingMapTraining();
  }

  public static void testSelfOrganizingMapTraining() {
    Node2DContainer nodeContainer = buildNodeContainer();
    SelfOrganizingMap selfOrganizingMap = buildSelfOrganizingMap(nodeContainer);

    int maxTrainingIterations = 100000;
    Data trainingData = createTrainingData();
    selfOrganizingMap.trainSelfOrganizingMap(trainingData,maxTrainingIterations);
    examineNodesOfSelfOrganizingMap(selfOrganizingMap);
  }

  public static void examineNodesOfSelfOrganizingMap(SelfOrganizingMap selfOrganizingMap) {
    Node2DContainer nodes = selfOrganizingMap.getNodesOfSelfOrganizingMap();
    Node2DContainerImpIterator nodeIterator = new Node2DContainerImpIterator(nodes);
    while (nodeIterator.hasNext()) {
      SingleNode currentNode = nodeIterator.next();
      float[] attributes = currentNode.getAttributes();
      System.out.println("Node ID = "+currentNode.getNodeID()+" Attribute 0,1 = "+attributes[0]+" , "+attributes[1]);
    }

  }

  public static Node2DContainer buildNodeContainer() {
    int numberOfNodesInFirstDimension = 10;
    int numberOfNodesInSecondDimension = 10;
    int numberOfAttributesPerNode = 2;
    Node2DContainerImp nodeContainer = new Node2DContainerImp(numberOfNodesInFirstDimension,
            numberOfNodesInSecondDimension, numberOfAttributesPerNode);
    return nodeContainer;
  }

  public static SelfOrganizingMap buildSelfOrganizingMap(Node2DContainer nodeContainer) {
    SelfOrganizingMap selfOrganizingMap = new SelfOrganizingMap(nodeContainer);
    return selfOrganizingMap;
  }

  public static Data createTrainingData() {
    int numberOfTrainingDataPoints = 200;
    float minX = -1.0f;
    float maxX =  1.0f;
    float minY = -1.0f;
    float maxY =  1.0f;
    float[][] trainingDataArray = generateDataWithinBox(numberOfTrainingDataPoints,minX,maxX,minY,maxY);
    Data trainigData = new DataImp(trainingDataArray);
    return trainigData;
  }

  public static float[][] generateDataWithinBox(int numberOfDataPoints, float minX, float maxX,
                                                                      float minY, float maxY){
    int numberOfAttributes = 2;
    float[][] data = new float[numberOfDataPoints][numberOfAttributes];

    Random randomNumberGenerator = new Random();
    float x = 0;
    float y = 0;
    for (int i=0; i<numberOfDataPoints; ++i) {
      x = randomNumberGenerator.nextFloat()*(maxX - minX) + minX;
      y = randomNumberGenerator.nextFloat()*(maxY - minY) + minY;
      data[i][0] = x;
      data[i][1] = y;
    }
    return data;
  }
}

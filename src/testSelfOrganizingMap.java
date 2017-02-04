/**
 * Created by Chris on 2/2/2017.
 */
import java.util.Random;

public class testSelfOrganizingMap {

  public static void main(String[] args) {
    int numberOfNodesInFirstDimension = 10;
    int numberOfNodesInSecondDimension = 10;
    int numberOfAttributesPerNode = 2;
    Node2DContainerImp nodeContainer = new Node2DContainerImp(numberOfNodesInFirstDimension,
                                                              numberOfNodesInSecondDimension,
                                                              numberOfAttributesPerNode);
    SelfOrganizingMap selfOrganizingMap = new SelfOrganizingMap(nodeContainer);

    int numberOfTrainingDataPoints = 20;
    float minX = -1.0f;
    float maxX =  1.0f;
    float minY = -1.0f;
    float maxY =  1.0f;
    float[][] trainingDataArray = generateDataWithinBox(numberOfTrainingDataPoints,minX,maxX,minY,maxY);
    Data trainigData = new DataImp(trainingDataArray);

    int maxIterations = 100;
    selfOrganizingMap.trainSelfOrganizingMap(trainigData,maxIterations);
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
      System.out.println("x = "+x);
      System.out.println("y = "+y);
    }
    return data;
  }
}

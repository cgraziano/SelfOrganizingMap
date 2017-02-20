/**
 * Created by Chris on 1/31/2017.
 */
import java.util.Iterator;

public class Node2DContainerImp implements Node2DContainer {
  private int numberOfAttributesPerNode;
  private int nodesInFirstDimension;
  private int nodesInSecondDimension;
  private SingleNodeImp[][] nodes;

  public Node2DContainerImp(int nodesInFirstDimension, int nodesInSecondDimension, int numberOfAttributesPerNode) {
    this.nodesInFirstDimension = nodesInFirstDimension;
    this.nodesInSecondDimension = nodesInSecondDimension;
    this.numberOfAttributesPerNode = numberOfAttributesPerNode;
    buildNodeContainer();
  }

  public SingleNode findClosestNodeTo(DataPoint dataPoint) {
    return searchAllNodesForClosestEuclideanDistance(dataPoint);
  }

  public SingleNode getNodeFromSpecifiedFirstAndSecondDimension(int i, int j) {
    return this.nodes[i][j];
  }

  public int getNumberOfNodesInFirstDimension() {
    return nodesInFirstDimension;
  }

  public int getNumberOfNodesInSecondDimension() {
    return nodesInSecondDimension;
  }

  public Iterator<SingleNode> createIterator() {
    return new Node2DContainerImpIterator(this);
  }

  public int getNumberOfAttributesPerNode() {
    return this.numberOfAttributesPerNode;
  }

  private void buildNodeContainer() {
    this.nodes = new SingleNodeImp[nodesInSecondDimension][nodesInFirstDimension];
    int numberOfNodeContainerDimensions = 2;
    float[] nodeLocation = new float[numberOfNodeContainerDimensions];
    float[] nodeAttributes = new float[numberOfAttributesPerNode];
    int nodeID = 0;
    for (int i = 0; i < nodesInSecondDimension; ++i) {
      for (int j = 0; j < nodesInSecondDimension; ++j) {
        nodeLocation[0] = i;
        nodeLocation[1] = j;
        this.nodes[i][j] = new SingleNodeImp(nodeID);
        this.nodes[i][j].setLocation(nodeLocation);
        this.nodes[i][j].setAttributes(nodeAttributes);
        ++nodeID;
      }
    }
  }

  private SingleNode searchAllNodesForClosestEuclideanDistance(DataPoint dataPoint) {
    float euclideanDistance = 0;
    MinimumValueSaver minimumValueSaver = new MinimumValueSaver();
    for (int i = 0; i<this.nodesInFirstDimension; ++i) {
      for (int j = 0; j<this.nodesInSecondDimension; ++j) {
        euclideanDistance = findEuclideanDistanceBetweenTwoPoints(dataPoint.getAttributes(),
                                                                  this.nodes[i][j].getAttributes());
        minimumValueSaver.compareAndSaveMinimumValueAndCorrespondingObject(euclideanDistance,nodes[i][j]);
      }
    }
    return (SingleNodeImp) minimumValueSaver.getObjectThatMinimumValueCorrespondsTo();
  }

  private float findEuclideanDistanceBetweenTwoPoints(float[] point1, float[] point2) {
    float point1MinusPoint2 = 0;
    float euclideanDistanceSquared = 0;
    int numberOfPointDimensions= point1.length;

    for (int i=0; i<numberOfPointDimensions; ++i) {
      point1MinusPoint2 = point1[i]-point2[i];
      euclideanDistanceSquared += point1MinusPoint2*point1MinusPoint2;
    }
    return (float) Math.sqrt((euclideanDistanceSquared));
  }


}

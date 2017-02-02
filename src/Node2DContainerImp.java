/**
 * Created by Chris on 1/31/2017.
 */
public class Node2DContainerImp implements NodeContainer {
  private int numberOfAttributesPerNode;
  private int nodesInFirstDimension;
  private int nodesInSecondDimension;
  private SingleNode[][] nodes;

  public Node2DContainerImp(int nodesInFirstDimension, int nodesInSecondDimension, int numberOfAttributesPerNode) {
    this. nodesInFirstDimension = nodesInFirstDimension;
    this. nodesInSecondDimension = nodesInSecondDimension;
    this.numberOfAttributesPerNode = numberOfAttributesPerNode;
    buildNodeContainer();
  }

  public SingleNode findClosestNodeTo(DataPoint dataPoint) {
    return searchAllNodesForClosestEuclideanDistance(dataPoint);
  }

  public void updateSurroundingNodes(float[] centerNode) {

  }

  private void buildNodeContainer() {
    this.nodes = new SingleNode[nodesInSecondDimension][nodesInFirstDimension];
  }

  private SingleNode searchAllNodesForClosestEuclideanDistance(DataPoint dataPoint) {
    float euclideanDistance = 0;
    float minimumEuclideanDistance = Float.MAX_VALUE;
    MinimumValueSaver  minimumValueSaver = new MinimumValueSaver();
    for (int i=0; i<this.nodesInFirstDimension; ++i) {
      for (int j = 0; j<this.nodesInSecondDimension; ++j) {
        euclideanDistance = findEuclideanDistanceBetweenTwoPoints(dataPoint.getAttributes(),
                                                                  nodes[i][j].getAttributes());
        minimumValueSaver.compareAndSaveMinimumValueAndCorrespondingObject(euclideanDistance,nodes[i][j]);
      }
    }
    return (SingleNode) minimumValueSaver.getObjectThatMinimumValueCorrespondsTo();
  }

  private float findEuclideanDistanceBetweenTwoPoints(float[] point1, float[] point2) {
    float point1MinusPoint2 = 0;
    float euclideanDistanceSquared = 0;
    int numberOfPointDimensions = point1.length;

    for (int i=0; i<numberOfPointDimensions; ++i) {
      point1MinusPoint2 = point1[i]-point2[i];
      euclideanDistanceSquared += point1MinusPoint2*point1MinusPoint2;
    }
    return (float) Math.sqrt((euclideanDistanceSquared));
  }


}

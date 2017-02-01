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
    searchAllNodesForClosestEuclideanDistance(dataPoint);
    }
    return SingleNode();
  }

  public void updateSurroundingNodes(float[] centerNode) {

  }

  private void buildNodeContainer() {
    this.nodes = new SingleNode[nodesInSecondDimension][nodesInFirstDimension][numberOfAttributesPerNode];
  }

  //A lot of things going on in this method. Try to extact different parts to make more readable and then
  //DELTE THIS COMMENT!
  private searchAllNodesForClosestEuclideanDistance(DataPoint dataPoint) {
    float euclideanDistance = 0;
    float minimumEuclideanDistance = Float.MAX_VALUE;
    SingleNode closestNode = new SingleNode();
    for (int i=0; i<this.nodesInFirstDimension; ++i) {
      for (int j = 0; j<this.nodesInSecondDimension; ++j) {
        float[] dataPointAttributes = dataPoint.getPointCoordinates();
        float[] nodeAttributes = nodes[i][j].getAttributesOfNode();
        euclideanDistance = findEuclideanDistanceBetweenTwoPoints(dataPointAttributes,nodeAttributes);
        if (euclideanDistance<minimumEuclideanDistance)
          minimumEuclideanDistance = euclideanDistance;


      }
    }
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

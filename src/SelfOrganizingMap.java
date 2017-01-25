/**
 * Created by Chris on 1/24/2017.
 */
public class SelfOrganizingMap {

    private int numberOfNodesInX;
    private int numberOfNodesInY;
    private int numberOfAttributes;
    private float[][][] trainingData;

    public SelfOrganizingMap(int nodesInXDirection, int nodesInYDirection, int numberOfNodeAttributes) {
        this.numberOfNodesInX = nodesInXDirection;
        this.numberOfNodesInY = nodesInYDirection;
        this.numberOfAttributes = numberOfNodeAttributes;
    }

    public void trainSelfOrganizingMap(float[][][] trainingData) {
        this.trainingData = trainingData;
    }
}

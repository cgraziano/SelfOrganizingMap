/**
 * Created by Chris on 2/8/2017.
 */
import java.util.Iterator;

public class Node2DContainerImpIterator implements Iterator<SingleNode>{
  private Node2DContainerImp nodeContainer;
  private int iteratorIndex;

  public Node2DContainerImpIterator(Node2DContainerImp nodeContainer) {
    this.nodeContainer = nodeContainer;
    this.iteratorIndex = 0;
  }

  public SingleNode next() {

    return this.nodeContainer.getNode();
  }

  public boolean hasNext() {
  }


}

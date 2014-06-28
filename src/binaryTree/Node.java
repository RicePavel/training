/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

/**
 * элемент дерева
 * @author Pavel Rice
 */
class Node {
  
  private Node leftChild;
  private Node rightChild;
  private Node parent;
  
  private String key;
  private Object value;

  public Node(String key, Object value) {
    this.key = key;
    this.value = value;
  }

  public int countChildNodes() {
    int count = 0;
    if (leftChild != null) {
      count += 1;
      count += leftChild.countChildNodes();
    }
    if (rightChild != null) {
      count += 1;
      count += rightChild.countChildNodes();
    }
    return count;
  }
  
  public boolean containsNode(Node node) {
    if (this.equals(node)) {
      return true;
    } else {
      if (leftChild != null) {
        if (leftChild.containsNode(node)) {
          return true;
        }
      }
      if (rightChild != null) {
        if (rightChild.containsNode(node)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  /*
  public void remove() {
    if (parent != null) {
      if (parent.getLeftChild() == this) {
        parent.setLeftChild(null);
      } else if (parent.getRightChild() == this) {
        parent.setRightChild(null);
      }
      parent = null;
    }
  }
  */
  
  public Node getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node node) {
    if (node != null) {
      node.setParent(this);
    }
    this.leftChild = node;
  }

  public Node getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node node) {
    if (node != null) {
      node.setParent(this);
    }
    this.rightChild = node;
  }

  public String getKey() {
    return key;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }
  
  
  
}

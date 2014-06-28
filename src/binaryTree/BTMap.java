/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

/**
 * список в виде бинарного дерева
 *
 * @author Pavel Rice
 */
public class BTMap {

  private Node root;

  public void put(String key, Object value) {
    // если корня нет - вставить в корень
    if (root == null) {
      Node newNode = new Node(key, value);
      root = newNode;
    } else {
      boolean inserted = false;
      Node currentNode = root;
      while (!inserted) {
        int compare = key.compareTo(currentNode.getKey());
        // если совпадает
        if (compare == 0) {
          // заменить значение
          currentNode.setValue(value);
          // выйти из метода
          inserted = true;
        } else if (compare < 0) {
          // если меньше
          // перейти к левому элементу
          if (currentNode.getLeftChild() == null) {
            Node newNode = new Node(key, value);
            currentNode.setLeftChild(newNode);
            inserted = true;
          } else {
            currentNode = currentNode.getLeftChild();
          }
        } else if (compare > 0) {
          // если больше 
          // перейти к правому элементу
          if (currentNode.getRightChild() == null) {
            Node newNode = new Node(key, value);
            currentNode.setRightChild(newNode);
            inserted = true;
          } else {
            currentNode = currentNode.getRightChild();
          }
        }
      }
    }
  }

  public Object get(String key) {
    // если корня нет - вставить в корень
    Node node = getNode(key);
    if (node == null) {
      return null;
    } else {
      return node.getValue();
    }
  }

  public int getCount() {
    int count = 0;
    if (root != null) {
      count += 1;
      count += root.countChildNodes();
    }
    return count;
  }

  private Node getNode(String key) {
    // если корня нет - вставить в корень
    if (root == null) {
      return null;
    } else {
      Node currentNode = root;
      while (true) {
        int compare = key.compareTo(currentNode.getKey());
        // если совпадает
        if (compare == 0) {
          return currentNode;
        } else if (compare < 0) {
          // если меньше
          // перейти к левому элементу
          if (currentNode.getLeftChild() == null) {
            return null;
          } else {
            currentNode = currentNode.getLeftChild();
          }
        } else if (compare > 0) {
          // если больше 
          // перейти к правому элементу
          if (currentNode.getRightChild() == null) {
            return null;
          } else {
            currentNode = currentNode.getRightChild();
          }
        }
      }
    }
  }

  public void remove(String key) {
    // найти вершину с таким ключом
    Node node = getNode(key);
    if (node != null) {
      // если вершина не имеет сыновей
      if (hasNoChild(node)) {
        // просто удалить вершину
        removeNode(node);
      } else if (hasOneChild(node)) {
        // если вершина имеет одного сына
        // удалить вершину
        // заменить её сыном
        if (node.getLeftChild() != null) {
          replaceNode(node, node.getLeftChild());
        } else if (node.getRightChild() != null) {
          replaceNode(node, node.getRightChild());
        }
      } else if (hasTwoChild(node)) {
        // если вершина имеет 2 сыновей
        // найти правого сына вершины #2
        Node n1 = node.getRightChild();
        // найти левого сына вершины #2
        // продолжать выбирать левых сыновей, 
        // пока не будет найдена вершина, у которой нет левого сына
        Node lastLeft = findLastLeftChild(n1);
        Node parentLastLeft = lastLeft.getParent();
        Node rightChild = lastLeft.getRightChild();
        // заменить начальную вершину на найденную
        replaceForRemove(node, lastLeft);        
        // сделать правого сына найденной вершины левым сыном родителя найденной вершины
        if (parentLastLeft != node) {
          parentLastLeft.setLeftChild(rightChild);
        }
      }
    }



  }

  private boolean containsNode(Node node) {
    if (root != null) {
      return root.containsNode(node);
    } else {
      return false;
    }
  }

  private Node findLastLeftChild(Node node) {
    while (true) {
      if (node.getLeftChild() == null) {
        return node;
      } else {
        node = node.getLeftChild();
      }
    }
  }

  private boolean hasNoChild(Node node) {
    return (node.getLeftChild() == null && node.getRightChild() == null);
  }

  private boolean hasOneChild(Node node) {
    return ((node.getLeftChild() == null && node.getRightChild() != null)
            || (node.getLeftChild() != null && node.getRightChild() == null));
  }

  private boolean hasTwoChild(Node node) {
    return (node.getLeftChild() != null && node.getRightChild() != null);
  }

  private void removeNode(Node node) {
    if (root == node) {
      root = null;
    } else {
      Node parent = node.getParent();
      if (parent.getLeftChild() == node) {
        parent.setLeftChild(null);
      } else if (parent.getRightChild() == node) {
        parent.setRightChild(null);
      }
    }
  }

  private void replaceNode(Node oldNode, Node newNode) {
    // удалить newNode
    removeNode(newNode);
    // удалить oldNode, и вместо oldNode поставить newNode
    if (root == oldNode) {
      root = newNode;
    } else {
      Node parent = oldNode.getParent();
      if (parent.getLeftChild() == oldNode) {
        parent.setLeftChild(newNode);
      } else if (parent.getRightChild() == oldNode) {
        parent.setRightChild(newNode);
      }
    }
  }

  private void replaceForRemove(Node oldNode, Node newNode) {
    // удалить newNode
    removeNode(newNode);
    // удалить oldNode, и вместо него поставить newNode
    if (root == oldNode) {
      root = newNode;
    } else {
      Node parent = oldNode.getParent();
      if (parent.getLeftChild() == oldNode) {
        parent.setLeftChild(newNode);
      } else if (parent.getRightChild() == oldNode) {
        parent.setRightChild(newNode);
      }
    }
    // сыновей oldNode сделать сыновями newNode
    if (oldNode.getLeftChild() != null && oldNode.getLeftChild() != newNode) {
      newNode.setLeftChild(oldNode.getLeftChild());
    }
    if (oldNode.getRightChild() != null && oldNode.getRightChild() != newNode) {
      newNode.setRightChild(oldNode.getRightChild());
    }
  }

  public boolean containsKey(String key) {
    return (get(key) != null);
  }
}

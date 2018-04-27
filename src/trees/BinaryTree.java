package trees;

public class BinaryTree {

    private TreeNode root;

    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
        } else {
            TreeNode current = root;
            TreeNode parent;

            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeftNode();
                    if (current == null) {
                        parent.setLeftNode(new TreeNode(key));
                        return;
                    }
                } else {
                    current = current.getRightNode();
                    if (current == null) {
                        parent.setRightNode(new TreeNode(key));
                        return;
                    }
                }
            }
        }
    }

    public void delete(int key) {
        TreeNode previous = findPrevious(key);
        TreeNode toDelete;

        if (key < previous.getKey()) {
            toDelete = previous.getLeftNode();
            if (toDelete.getLeftNode() == null && toDelete.getRightNode() == null) {
                setRootWithoutChildToNull(true, previous);
            } else if (toDelete.getLeftNode() != null && toDelete.getRightNode() == null) {
                setRootWithOneChildToNull(true, previous);
            } else if(toDelete.getLeftNode() == null && toDelete.getRightNode() != null) {
                setRootWithOneChildToNull(true, previous);
            } else {

            }
        } else if (key > previous.getKey()) {
            toDelete = previous.getRightNode();
            if (toDelete.getLeftNode() == null && toDelete.getRightNode() == null) {
                setRootWithoutChildToNull(false, previous);
            } else if(toDelete.getLeftNode() == null && toDelete.getRightNode() != null) {
                setRootWithOneChildToNull(false, previous);
            } else if(toDelete.getLeftNode() != null && toDelete.getRightNode() == null) {
                setRootWithOneChildToNull(false, previous);
            }
        }
    }

    private void setRootWithTwoChildNodesToNull(TreeNode parent) {
        TreeNode current = parent.getRightNode();
        TreeNode previous = null;

        while (current.getLeftNode() != null) {
            previous = current;
            current = current.getLeftNode();
        }

        TreeNode lastNode = previous.getLeftNode();

        if(previous.getRightNode() == null) {
            parent.setKey(lastNode.getKey());
        }
    }

    private void setRootWithOneChildToNull(boolean isLeftChild
            , TreeNode parent) {

        if(isLeftChild) {
            TreeNode current = parent.getLeftNode();
            if(current.getLeftNode() != null && current.getRightNode() == null) {
                parent.setLeftNode(current.getLeftNode());
            } else if(current.getLeftNode() == null && current.getRightNode() != null) {
                parent.setLeftNode(current.getRightNode());
            }
        } else {
            TreeNode current = parent.getRightNode();
            if(current.getLeftNode() != null && current.getRightNode() == null) {
                parent.setRightNode(current.getLeftNode());
            } else if(current.getLeftNode() == null && current.getRightNode() != null) {
                parent.setRightNode(current.getRightNode());
            }
        }
    }

    private void setRootWithoutChildToNull(boolean isLeftChild
            , TreeNode parent) {
        if (isLeftChild) {
            parent.setLeftNode(null);
        } else {
            parent.setRightNode(null);
        }
    }

    public TreeNode findPrevious(int key) {
        TreeNode current = root;
        TreeNode previous = root;

        if (root == null) {
            return null;
        } else {
            while (current.getKey() != key) {
                if (key > current.getKey()) {
                    previous = current;
                    current = current.getRightNode();
                } else if (key < current.getKey()) {
                    previous = current;
                    current = current.getLeftNode();
                } else if (current == null) {
                    return null;
                }
            }
        }
        return previous;
    }

    public TreeNode find(int key) {
        TreeNode current = root;

        if (root == null) {
            return null;
        } else {
            while (current.getKey() != key) {
                if (key < current.getKey()) {
                    current = current.getLeftNode();
                } else if (key > current.getKey()) {
                    current = current.getRightNode();
                } else if (current == null) {
                    return null;
                }
            }
        }
        return current;
    }

    public TreeNode minimum() {
        TreeNode current = root;

        while (current.getLeftNode() != null) {
            current = current.getLeftNode();
        }
        return current;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeftNode());

            System.out.println("Key: " + root.getKey());
            inOrder(root.getRightNode());
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}

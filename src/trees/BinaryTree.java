package trees;

public class BinaryTree {

    private TreeNode root;

    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
        } else {
            TreeNode current = root;
            TreeNode parent;

            while(true) {
                parent = current;
                if(key < current.getKey()) {
                    current = current.getLeftNode();
                    if(current == null) {
                        parent.setLeftNode(new TreeNode(key));
                        return;
                    }
                } else {
                    current = current.getRightNode();
                    if(current == null) {
                        parent.setRightNode(new TreeNode(key));
                        return;
                    }
                }
            }
        }
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
        if(root != null) {
            inOrder(root.getLeftNode());

            System.out.println("Key: " + root.getKey());
            inOrder(root.getRightNode());
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}

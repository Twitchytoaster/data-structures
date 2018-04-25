package trees;

public class BinaryTree {

    private TreeNode root;

    public void insert(int key) {
        if (root == null) {
            root.setKey(key);
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
}

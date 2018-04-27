package trees;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(12);
        tree.insert(10);
        tree.insert(11);
        tree.insert(15);
        tree.inOrder(tree.getRoot());
        tree.delete(10);
        System.out.println();
        tree.inOrder(tree.getRoot());
    }
}

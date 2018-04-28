package trees;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(12);
        tree.insert(10);
        tree.insert(11);
        tree.insert(15);
        tree.insert(13);
        tree.insert(18);
        tree.insert(16);
        tree.insert(17);
        tree.inOrder(tree.getRoot());
        tree.delete(15);

        System.out.println();

        tree.inOrder(tree.getRoot());

        System.out.println("left key: " + tree.find(16).getLeftNode().getKey() + " right key: " + tree.find(16).getRightNode().getKey() );
        System.out.println("key should 17: " + tree.find(18).getLeftNode().getKey());
    }
}

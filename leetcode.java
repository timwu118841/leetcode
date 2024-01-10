public class leetcode {

    public static class InitValue {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(10);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(9);
        TreeNode h = new TreeNode(2);

        public void setValue() {
            a.left = b;
            a.right = c;
            b.right = d;
            c.left = e;
            c.right = f;
            d.left = g;
            d.right = h;
        }

    }

    public static void main(String[] args) {
        InitValue i = new InitValue();
        i.setValue();
        solution s = new solution();
        int res = s.amountOfTime(i.a, 3);
    }
}
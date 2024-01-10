import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class solution {
      public int amountOfTime(TreeNode a, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        createGraph(a, graph);
        return maxDistance(graph, new LinkedList<>(List.of(start)), new HashSet<>(start));
    }

    private void createGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        List<Integer> adjacent = graph.computeIfAbsent(root.val, k -> new ArrayList<>());// computeIfAbsent() = get and put 同時間 有值就get 沒值就put新的然後get

        if (root.left != null) {
            graph.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
            adjacent.add(root.left.val);
            createGraph(root.left, graph);
        }
        if (root.right != null) {
            graph.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
            adjacent.add(root.right.val);
            createGraph(root.right, graph);
        }
    }
      private int maxDistance(Map<Integer, List<Integer>> graph, Queue<Integer> queue, Set<Integer> visited) {
        int maxDistance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int currentNode = queue.poll();
                for (int neighbour : graph.get(currentNode)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            maxDistance++;
        }

        return maxDistance - 1;
    }

   
}

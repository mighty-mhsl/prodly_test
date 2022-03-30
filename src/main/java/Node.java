import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Node<T> {
    private final T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String printTree() {
        Map<Integer, List<T>> map = new TreeMap<>();
        fillMap(map, 0);
        return buildString(map);
    }

    private void fillMap(Map<Integer, List<T>> map, int level) {
        if (left == null && right == null) {
            put(map, level, value);
        } else {
            put(map, level, value);
            if (left != null) {
                left.fillMap(map, level + 1);
            }
            if (right != null) {
                right.fillMap(map, level + 1);
            }
        }
    }

    private String buildString(Map<Integer, List<T>> map) {
        StringBuilder builder = new StringBuilder();
        map.forEach((level, values) -> {
            for (int i = 0; i < values.size(); i++) {
                builder.append(values.get(i));
                if (i < values.size() - 1) {
                    builder.append(", ");
                }
            }
            builder.append("\n");
        });
        return builder.toString();
    }

    private void put(Map<Integer, List<T>> map, int level, T value) {
        if (map.containsKey(level)) {
            map.get(level).add(value);
        } else {
            List<T> list = new ArrayList<>();
            list.add(value);
            map.put(level, list);
        }
    }
}

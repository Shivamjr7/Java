package yamlReader;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class YamlReader {

    public static void main(String[] args) {
        try {
            Yaml yaml = new Yaml();
            Reader reader = new FileReader("/Users/sjari/projects/java/Java/javapractices/src/main/java/yamlReader/endpoint.yml");
            Iterable<Node> nodes = yaml.composeAll(reader);
            for (Node node : nodes) {
                processNode(node, "digraph");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processNode(Object node, String prefix) {
        if (node instanceof Map) {
            Map<String, Object> mapNode = (Map<String, Object>) node;
            for (Map.Entry<String, Object> entry : mapNode.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(prefix + key + ": " + value);

                if (value instanceof Map || value instanceof List) {
                    processNode(value, prefix + key + ".");
                }
            }
        } else if (node instanceof List) {
            List<Object> listNode = (List<Object>) node;
            for (int i = 0; i < listNode.size(); i++) {
                Object listItem = listNode.get(i);
                System.out.println(prefix + i + ": " + listItem);

                if (listItem instanceof Map || listItem instanceof List) {
                    processNode(listItem, prefix + i + ".");
                }
            }
        } else if (node instanceof ScalarNode) {
            ScalarNode scalarNode = (ScalarNode) node;
            System.out.println(prefix + scalarNode.getValue());
        }
    }
}

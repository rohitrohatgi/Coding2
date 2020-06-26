package rohit.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        int[] position = new int[n];
        boolean[] visited = new boolean[n];
        int[] timer = new int[1];
        Map<Integer,List<Integer>> connectionsMap = getConnectionsMap(connections);
        find(connectionsMap, 0, -1,result, position, visited,timer);
        return result;
    }

    private int find(Map<Integer, List<Integer>> connectionsMap, int node, int parent, List<List<Integer>> result, int[] position, boolean[] visited,int[] timer) {
        if(visited[node]){
            return position[node];
        }
        visited[node] = true;
        position[node] = timer[0]++;
        List<Integer> connection = connectionsMap.get(node);
        int nodeMinPos = position[node];
        for(int x : connection){
            if(parent != -1 && x == parent){
                continue;
            }
            int minPosition = find(connectionsMap,x , node,result, position, visited,timer);

            if(minPosition > position[node]){
                result.add(Arrays.asList(x,node));
            }

            nodeMinPos = Math.min(nodeMinPos,minPosition);
        }
        position[node] = nodeMinPos;
        return nodeMinPos;
    }

    private Map<Integer, List<Integer>> getConnectionsMap(List<List<Integer>> connections) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for(List<Integer> connection : connections){
            result.computeIfAbsent(connection.get(0),f -> new ArrayList<Integer>()).add(connection.get(1));
            result.computeIfAbsent(connection.get(1),f -> new ArrayList<Integer>()).add(connection.get(0));
        }
        return result;
    }

    public static void main(String[] args) {
        CriticalConnectionsInANetwork criticalConnectionsInANetwork = new CriticalConnectionsInANetwork();
        List<List<Integer>> connections = new ArrayList<>();

        //[[0,1],[1,2],[2,0],[1,3]]
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        System.out.println(criticalConnectionsInANetwork.criticalConnections(4,connections));

    }
}

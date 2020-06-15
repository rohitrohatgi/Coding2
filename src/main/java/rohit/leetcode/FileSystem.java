package rohit.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rohit on 15/6/20.
 */
class FileSystem {
    class Dir{
        Map<String, Dir> directories = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }
    Dir root;

    public FileSystem() {
        root = new Dir();
    }

    public List<String> ls(String path) {
        String[] pathArray = path.split("/");
        Dir toReach =  root;
        for(int i=1;i<pathArray.length;i++){
            toReach = toReach.directories.get(pathArray[i]);
        }
        List<String> result = new ArrayList<>();

        result.addAll(toReach.directories.keySet());
        result.addAll(toReach.files.keySet());

        return result;

    }

    public void mkdir(String path) {
        String[] pathArray = path.split("/");
        Dir toReach =  root;
        for(int i=1;i<pathArray.length;i++){
            if(!toReach.directories.containsKey(pathArray[i]))
                toReach.directories.put(pathArray[i],new Dir());
            toReach = toReach.directories.get(pathArray[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] pathArray = filePath.split("/");
        Dir toReach =  root;
        for(int i=1;i<pathArray.length -1 ;i++){
            if(!toReach.directories.containsKey(pathArray[i]))
                toReach.directories.put(pathArray[i],new Dir());
            toReach = toReach.directories.get(pathArray[i]);
        }
        toReach.files.put(pathArray[pathArray.length-1],content);
    }

    public String readContentFromFile(String filePath) {
        String[] pathArray = filePath.split("/");
        Dir toReach =  root;
        for(int i=1;i<pathArray.length -1 ;i++){
            if(!toReach.directories.containsKey(pathArray[i]))
                toReach.directories.put(pathArray[i],new Dir());
            toReach = toReach.directories.get(pathArray[i]);
        }
        return toReach.files.get(pathArray[pathArray.length-1]);
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        System.out.println(fileSystem.ls("/"));
        fileSystem.mkdir("/Dir/Dir1/Dir2");
        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.ls("/Dir"));
        System.out.println(fileSystem.ls("/Dir/Dir1"));

        fileSystem.addContentToFile("/a/b/c/d","hello");
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));
    }
}


/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
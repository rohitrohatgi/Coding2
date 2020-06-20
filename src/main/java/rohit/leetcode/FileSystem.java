package rohit.leetcode;

import java.util.*;

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
        Collections.sort(result);
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
        String prefix = "";
        if(toReach.files.containsKey(pathArray[pathArray.length-1])){
            prefix = toReach.files.get(pathArray[pathArray.length-1]);
        }
        toReach.files.put(pathArray[pathArray.length-1],prefix + content);
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



/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
        List<String> param_1 = obj.ls("/");
        obj.mkdir("/rohit");
        obj.addContentToFile("/rohit/f1","hello");
        System.out.println(obj.readContentFromFile("/rohit/f1"));
    }
}
package rohit.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rohit on 17/6/20.
 */
class Node<K,V>{
    public K key;
    public V value;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }

}
class Bucket{
    private List<Node<Integer,Integer>> bucket;

    public Bucket(){
        this.bucket = new LinkedList<>();
    }

    public int get(int key){
        for(Node<Integer,Integer> node : bucket){
            if(node.key == key)
                return node.value;
        }
        return -1;
    }

    public void update(int key,int value){
        for(Node<Integer,Integer> node : bucket){
            if(node.key == key) {
                node.value = value;
                return;
            }
        }
        this.bucket.add(new Node<>(key,value));
    }

    public void remove(int key){
        for(Node<Integer,Integer> node : bucket) {
            if (node.key == key)
                this.bucket.remove(node); break;
        }
    }

}


public class MyHashMap {
    private List<Bucket> hashTable;
    private int size;

    public MyHashMap(){
        this.size = 10;
        this.hashTable = new ArrayList<Bucket>(size);
        for(int index = 0; index < size; index++){
            this.hashTable.add(index,new Bucket());
        }
    }

    private int getHashCode(int key){
        return key%size;
    }


    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.hashTable.get(getHashCode(key)).update(key,value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return this.hashTable.get(getHashCode(key)).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.hashTable.get(getHashCode(key)).remove(key);
    }

}

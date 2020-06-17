package leetcode;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import rohit.leetcode.FindLongestWordSolution;

import java.util.Arrays;
import java.util.List;

/** 
* FindLongestWordSolution Tester. 
* 
* @author <Authors name> 
* @since <pre>Jun 16, 2020</pre> 
* @version 1.0 
*/ 
public class FindLongestWordSolutionTest {

    FindLongestWordSolution findLongestWordSolution = null;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("before class");
    }
    @Before
    public void before() throws Exception {
        System.out.println("before ");
        findLongestWordSolution = new FindLongestWordSolution();
    }

    @After
    public void after() throws Exception {
        System.out.println("after");
    }

    /**
    *
    * Method: findLongestWord(String s, List< String > d)
    *
    */
    @Test
    public void testFindLongestWord() throws Exception {
        //given
        String toFind = "abpcplea"; //
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea","aaaa"); //
        //when
        String result = findLongestWordSolution.findLongestWord(toFind,dictionary);
        //then
        assertEquals("apple",result);
    }

    /**
    *
    * Method: main(String[] args)
    *
    */
    @Test
    public void testMain() throws Exception {
        System.out.println("test main");
    }


    /**
    *
    * Method: match(String s, String item)
    *
    */
    @Test
    public void testMatch() throws Exception {
        System.out.println("test main");
    //TODO: Test goes here...
    /*
    try {
       Method method = FindLongestWordSolution.getClass().getMethod("match", String.class, String.class);
       method.setAccessible(true);
       method.invoke(<Object>, <Parameters>);
    } catch(NoSuchMethodException e) {
    } catch(IllegalAccessException e) {
    } catch(InvocationTargetException e) {
    }
    */
    }

} 

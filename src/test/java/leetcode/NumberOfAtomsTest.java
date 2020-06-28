package leetcode;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import rohit.leetcode.NumberOfAtoms;

import static org.junit.Assert.assertEquals;

public class NumberOfAtomsTest {

    NumberOfAtoms numberOfAtoms = null;
    @Before
    public void setUp(){
        numberOfAtoms = new NumberOfAtoms();
    }

    @Test
    public void testNestedBracket(){
        //formula = "K4(ON(SO3)2)2"
        //Output: "K4N2O14S4"

        assertEquals("K4N2O14S4",numberOfAtoms.countOfAtoms("K4(ON(SO3)2)2"));
    }

}

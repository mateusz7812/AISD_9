package tests;

import com.company.BinarySearchTree.BinarySearchTree;
import com.company.BinarySearchTree.NodeInterface;
import com.company.Comparator.IntegerComparator;
import org.junit.Assert;
import org.junit.Test;

public class TestBinarySearchTree {
    class TestIntegerBST extends BinarySearchTree<Integer>{
        public TestIntegerBST() {
            super(new IntegerComparator());
        }

        public NodeInterface<Integer> getNil(){
            return super.nil;
        }
    }

    @Test
    public void Test1(){
        var bst = new TestIntegerBST();
        Assert.assertNull(bst.getNil());

        bst.Add(1);

        Assert.assertNotNull(bst.getNil());
    }

    @Test
    public void Test2(){
        var bst = new TestIntegerBST();
        Assert.assertNull(bst.Get(2));

        bst.Add(2);

        NodeInterface<Integer> node = bst.Get(2);
        Assert.assertNotNull(node);
        Assert.assertEquals(2, node.getValue().intValue());
    }

    @Test
    public void Test3(){
        var bst = new TestIntegerBST();
        Assert.assertNull(bst.getNil());

        bst.Add(1);
        bst.Add(2);
        bst.Add(0);

        NodeInterface<Integer> nil = bst.getNil();
        Assert.assertNotNull(nil);
        Assert.assertEquals(1, nil.getValue().intValue());

        NodeInterface<Integer> rightChild = nil.getRightChild();
        Assert.assertNotNull(rightChild);
        Assert.assertEquals(2, rightChild.getValue().intValue());
        Assert.assertEquals(nil, rightChild.getParent());

        NodeInterface<Integer> leftChild = nil.getLeftChild();
        Assert.assertNotNull(leftChild);
        Assert.assertEquals(0, leftChild.getValue().intValue());
        Assert.assertEquals(nil, leftChild.getParent());
    }

    @Test
    public void Test4(){
        var bst = new TestIntegerBST();
        Assert.assertNull(bst.getNil());

        bst.Add(1);
        bst.Add(2);
        bst.Add(0);

        var first = bst.Get(1);
        Assert.assertNotNull(first);
        Assert.assertEquals(1, first.getValue().intValue());

        var second = bst.Get(2);
        Assert.assertNotNull(second);
        Assert.assertEquals(2, second.getValue().intValue());

        var third = bst.Get(0);
        Assert.assertNotNull(third);
        Assert.assertEquals(0, third.getValue().intValue());

        var fourth = bst.Get(10);
        Assert.assertNull(fourth);
    }

    @Test
    public void Test5(){
        var bst = new TestIntegerBST();

        bst.Add(4);
        bst.Add(3);

        bst.Remove(3);

        var nil = bst.getNil();
        Assert.assertEquals(4, nil.getValue().intValue());
        Assert.assertNull(nil.getLeftChild());
    }

    @Test
    public void Test6(){
        var bst = new TestIntegerBST();

        bst.Add(4);
        bst.Add(3);
        bst.Add(2);

        bst.Remove(3);

        var nil = bst.getNil();
        Assert.assertEquals(4, nil.getValue().intValue());
        Assert.assertEquals(2, nil.getLeftChild().getValue().intValue());
    }

    @Test
    public void Test7(){
        var bst = new TestIntegerBST();

        bst.Add(5);
        bst.Add(3);
        bst.Add(4);

        bst.Remove(3);

        var nil = bst.getNil();
        Assert.assertEquals(5, nil.getValue().intValue());
        Assert.assertEquals(4, nil.getLeftChild().getValue().intValue());
    }

    @Test
    public void Test8(){
        var bst = new TestIntegerBST();

        bst.Add(5);
        bst.Add(3);
        bst.Add(2);
        bst.Add(4);

        bst.Remove(3);

        var nil = bst.getNil();
        Assert.assertEquals(5, nil.getValue().intValue());
        Assert.assertEquals(4, nil.getLeftChild().getValue().intValue());
        Assert.assertEquals(2, nil.getLeftChild().getLeftChild().getValue().intValue());
    }

    @Test
    public void Test9(){
        var bst = new TestIntegerBST();

        bst.Add(6);
        bst.Add(2);
        bst.Add(1);
        bst.Add(4);
        bst.Add(5);
        bst.Add(3);

        bst.Remove(2);

        var nil = bst.getNil();
        Assert.assertEquals(6, nil.getValue().intValue());
        Assert.assertEquals(3, nil.getLeftChild().getValue().intValue());
        Assert.assertEquals(1, nil.getLeftChild().getLeftChild().getValue().intValue());
        Assert.assertEquals(4, nil.getLeftChild().getRightChild().getValue().intValue());
        Assert.assertEquals(5, nil.getLeftChild().getRightChild().getRightChild().getValue().intValue());
    }
}

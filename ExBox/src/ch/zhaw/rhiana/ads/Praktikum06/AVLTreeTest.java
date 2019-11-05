package ch.zhaw.rhiana.ads.Praktikum06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {
    AVLTree<String> tree;

    private void init(AVLTree<String> tree) {
        tree.insert("E");
        tree.insert("F");
        tree.insert("G");
        tree.insert("H");
        tree.insert("J");
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
    }

    @Before
    public void setUp() throws Exception {
        tree = new AVLTree<String>();
        init(tree);
    }

    @Test
    public void testInorder() {
        Visitor<String> v = new MyVisitor<String>();
        tree.getTraversal().inorder(v);
        assertEquals("inorder", "ABCDEFGHJ", v.toString());
    }

    @Test
    public void testPreorder() {
        Visitor<String> v = new MyVisitor<String>();
        tree.getTraversal().preorder(v);
        assertEquals("preorder", "FBADCEHGJ", v.toString());
    }

    @Test
    public void testPostorder() {
        Visitor<String> v = new MyVisitor<String>();
        tree.getTraversal().postorder(v);
        assertEquals("postorder", "ACEDBGJHF", v.toString());
    }

    @Test
    public void testLevelorder() {
        Visitor<String> v = new MyVisitor<String>();
        tree.getTraversal().levelorder(v);
        assertEquals("levelorder", "FBHADGJCE", v.toString());
    }

    @Test
    public void testHeight() {
        assertEquals(4,tree.height());
    }

    @Test
    public void testBalanced() {
        init(tree);
        assertTrue(tree.isBalanced());
        AVLTree<String>  tree2 = new AVLTree<String> ();
        tree2.insert("A");
        tree2.insert("B");
        tree2.insert("C");
        assertTrue(tree2.isBalanced());
    }


    @Test
    public void testRemove() {
        tree = new AVLTree<String>();
        init(tree);
        tree.delete("F");
        tree.delete("H");
        tree.delete("J");
        Visitor<String> v = new MyVisitor<String>();
        tree.getTraversal().inorder(v);
        assertEquals("remove", "ABCDEG", v.toString());
        v = new MyVisitor<String>();
        tree.getTraversal().levelorder(v);
        assertEquals("remove", "DBGACE", v.toString());
    }


    @Test
    public void testMixed() {
        tree = new AVLTree<String>();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 25; i++) {
            Character c = (char) ('A' + (Math.random() * 26));
            int op = (int) (Math.random() * 2);
            switch (op) {
                case 0:
                    list.add(c.toString());
                    tree.insert(c.toString());
                    break;
                case 1:
                    list.remove(c.toString());
                    tree.delete(c.toString());
                    break;
            }
        }
        assertTrue(tree.isBalanced());
        assertEquals(tree.count(),list.size());
        Collections.sort(list);
        StringBuilder b = new StringBuilder();
        for (String s : list) {b.append(s);};
        Visitor<String> v = new MyVisitor<String>();
        tree.getTraversal().inorder(v);
        assertEquals("mixed",b.toString(), v.toString());
    }

}



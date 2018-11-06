package com.sj.binaysearchtree;

import com.sj.exception.ElementNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BSTNodeTest {


    private BSTNode root = new BSTNode<Integer>(3);
    @BeforeEach
    public void init(){
        root = root.insert(root,8);
        root = root.insert(root,1);
        root = root.insert(root,4);
        root = root.insert(root,6);
        root = root.insert(root,2);
        root = root.insert(root,10);
        root = root.insert(root,9);
        root = root.insert(root,20);
        root = root.insert(root,25);
        root = root.insert(root,15);
        root = root.insert(root,16);
    }

    @Test
    void shouldReturnSearchedValue() {
        root.display(root);
        assertTrue(root.search(root,4));
    }

    @Test
    void shouldThrowNotFoundException() {
        assertThrows(ElementNotFoundException.class, () ->  root.search(root, 100));
    }

    @Test
    void shouldDeleteNodeWith2Children() {
        root.display(root);
        assertTrue(root.delete(root, 10));
    }

    @Test
    void shouldNotFindAndReturnFalseOnDelete() {
        root.display(root);
        assertFalse(root.delete(root, 100));
    }

    @Test
    void shouldDeleteNodeWithNoChildren() {
        root.display(root);
        assertTrue(root.delete(root, 2));
    }

    @Test
    void shouldDeleteNodeWith1Children() {
        root.display(root);
        assertTrue(root.delete(root, 4));
    }
}

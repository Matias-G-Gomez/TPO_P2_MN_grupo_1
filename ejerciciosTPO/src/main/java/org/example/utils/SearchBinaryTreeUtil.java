package org.example.utils;

import org.example.adt.BinaryTree;
import org.example.adt.SearchBinaryTree;

public class SearchBinaryTreeUtil {
    public static boolean exists(int value, SearchBinaryTree sbt) {
        if(sbt == null) {
            return false;
        }
        if(sbt.getRoot() == value) {
            return true;
        }
        if(value < sbt.getRoot()) {
            return exists(value, sbt.getLeft());
        }
        return exists(value, sbt.getRight());
    }

    public static boolean isSBT(BinaryTree binaryTree) {
        // TODO
        return false;
    }
}

package com.grsisfee.Tools.Trie;

import java.util.HashMap;

/**
 * Author: Grsis Fee
 * Date:   2016/1/18.
 * 实现Trie树节点数据结构
 */
@SuppressWarnings("unused")
public class Node {

    public Node() {
        children = null;
        values = null;
    }

    public Node(Character content) {
        this.content = content;
        children = null;
        values = null;
    }

    public Node(Character content, HashMap<Character, Node> children) {
        this.content = content;
        this.children = children;
        values = null;
    }

    public Node(Character content, HashMap<Character, Node> children, HashMap values) {
        this.content = content;
        this.children = children;
        this.values = values;
    }

    public Character getContent() {
        return content;
    }

    public void setContent(Character content) {
        this.content = content;
    }

    public void setChildren(HashMap<Character, Node> children) {
        this.children = children;
    }

    public HashMap<Character, Node> getChildren() {
        return children;
    }

    public void setValues(HashMap values) {
        this.values = values;
    }

    public HashMap getValues() {
        return values;
    }

    private Character content;                              // Trie树节点内容
    private HashMap values;                                 // Trie树节点数据，HashMap参数模板不确定
    private HashMap<Character, Node> children;              // Trie树节点的孩子节点
}

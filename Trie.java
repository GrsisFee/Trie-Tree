package com.grsisfee.Tools.Trie;

import java.util.HashMap;

/**
 * Author: Grsis Fee
 * Date:   2016/1/18.
 * 实现Trie树数据结构
 */
@SuppressWarnings("unused")
public class Trie {

    public Trie() {
        root = new Node();
    }

    /**
     * 向字典树中添加一个词语，初始化设置当前节点为字典树的根节点，并设置词语末尾节点的值为null
     * @param word 待加入的词语
     */
    public void put(String word) {
        put(word, null);
    }

    /**
     * 向字典树中添加一个词语，初始化设置当前节点为字典树的根节点，并设置词语末尾节点的值
     * @param word 待加入的词语
     * @param values 词语对应的数据
     */
    public void put(String word, HashMap values) {
        Character tmpChar;
        int wordLength = word.length();
        currentNode = root;
        for (int i = 0; i < wordLength; i++) {
            tmpChar = word.charAt(i);
            if (nodeExist(tmpChar)) continue;
            createNode(tmpChar);
        }
        // currentNode 会移动到已有的或是新创建的树节点上
        currentNode.setValues(values);
    }

    /**
     * 在字典树中查询一个词语末尾节点对应的值
     * @param word 待在字典树中查找其末尾节点值的词语
     * @return 词语末尾节点对应的值
     *         若该词语末尾节点没有值，则返回null
     */
    public HashMap get(String word) {
        Character tmpChar;
        int wordLength = word.length();
        currentNode = root;
        for (int i = 0; i < wordLength; i++) {
            tmpChar = word.charAt(i);
            if (!nodeExist(tmpChar)) return null;
        }
        return currentNode.getValues();
    }

    /**
     * 判断字典树中词语是否存在
     * @param word 待判断的词语
     * @return 返回true：词语存在
     *         返回false：词语不存在
     */
    public boolean contains(String word) {
        Character tmpChar;
        int wordLength = word.length();
        currentNode = root;
        for (int i = 0; i < wordLength; i++) {
            tmpChar = word.charAt(i);
            if (!nodeExist(tmpChar))
                return false;
        }
        return true;
    }

    /**
     * 在当前节点的孩子节点中判断是否存在包含传入字符的节点
     * @param tmpChar 传入字符
     * @return 返回true：存在，此时会把当前节点移动到找到的孩子节点上
     *         返回false：不存在
     */
    private boolean nodeExist(Character tmpChar) {
        HashMap<Character, Node> children = currentNode.getChildren();
        if (children == null) return false;

        if (children.containsKey(tmpChar)) {
            currentNode = children.get(tmpChar);
            return true;
        } else return false;
    }

    /**
     * 根据传入字符创建字典树节点，并移动当前节点到新创建的节点
     * @param content 传入的字符
     */
    private void createNode(Character content) {
        HashMap<Character, Node> children = currentNode.getChildren();
        if (children == null) children = new HashMap<>();

        Node node = new Node(content);
        children.put(content, node);

        // 更新数据结构
        currentNode.setChildren(children);
        currentNode = node;
    }

    private Node currentNode;
    private Node root;
}

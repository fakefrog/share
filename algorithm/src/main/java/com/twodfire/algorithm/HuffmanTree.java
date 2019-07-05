package com.twodfire.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author baiyundou
 * @date 10:14 2019/7/5
 * @description
 */
public class HuffmanTree {

    static class Node {

        public Node parent;

        public Integer weight = 0;

        public boolean used = false;

        public boolean one;

        public String code;

    }

    public static void main(String[] args) {
        String s = "hello";
        ArrayList<Character> list = new ArrayList<Character>();
        ArrayList<Node> nodes = new ArrayList<Node>();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(sChars[i])) {
                list.add(sChars[i]);
                Node node = new Node();
                node.weight = 1;
                nodes.add(node);
            } else {
                Node node = nodes.get(list.indexOf(sChars[i]));
                node.weight = node.weight + 1;
            }
        }
        int len = list.size();
        Node[] nodeArray = new Node[len * 2 - 1];
        for (int i = 0; i < len; i++) {
            nodeArray[i] = nodes.get(i);
        }
        int index = len - 1;
        for (int i = 0; i < len - 1; i++) {
            Node newNode = findTheLeast(nodeArray, index);
            index++;
            nodeArray[index] = newNode;
        }

        for (int i = 0; i < list.size(); i++) {
            Node node = nodes.get(i);
            String code = node.one ? "1" : "0";
            node = node.parent;
            while (node.parent != null) {
                code = (node.one ? "1" : "0") + code;
                node = node.parent;
            }
            nodes.get(i).code = code;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChars.length; i++) {
            Node node = nodes.get(list.indexOf(sChars[i]));
            sb.append(node.code);
        }
        System.out.println(sb.toString());
    }

    private static Node findTheLeast(Node[] nodeArray, int index) {

        Node[] nodes = new Node[index + 1];
        System.arraycopy(nodeArray, 0, nodes, 0, nodes.length);
        List<Node> nodesList = Arrays.asList(nodes);
        nodesList.sort(Comparator.comparingInt(o -> o.weight));
        Node node = new Node();
        int flag = 0;
        for (int i = 0; i < nodesList.size() && flag < 2; i++) {
            Node getNode = nodesList.get(i);
            if (!getNode.used) {
                getNode.used = true;
                getNode.parent = node;
                if (flag == 0) {
                    getNode.one = false;
                } else {
                    getNode.one = true;
                }
                node.weight = node.weight + getNode.weight;
                flag++;
            }
        }
        return node;
    }

}

package algorithmCase;


import lombok.Data;

/**
 * @program: algorithms
 * @Title InvertedChainTable
 * @description: TODO
 * @author: ChengYi
 * @date: 2022-09-03 11:58
 * @Version 1.0
 **/
public class InvertedChainTable {
    public static void main(String[] args) {

    }

    static void invertedChainTable(Node head, Node prev) {
        if (head.next == null) {
            head.next = prev;
            return;
        }
        //把当前节点的下一个节点的位置信息存到temp
        Node tempNext = head.next;
        //把当前节点的下一个节点的位置设置成 它的 前一个节点
        head.next = prev;
        //把当前节点的信息保存到前面一个节点，相当于交换位置了
        prev = head;
        //当前节点此时已经完成了交换，所以要把它的下一个指向的内容还原回去
        head = tempNext;

        //递归处理写一个节点
        invertedChainTable(head, prev);

    }
}

@Data
class Node {
    int value;
    Node prev;
    Node next;
}

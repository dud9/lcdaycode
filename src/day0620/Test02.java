package day0620;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/6/20 - 18:38
 * 1600. 皇位继承顺序
 * l链表解法
 */
public class Test02 {
}

class ThroneInheritance1 {
    // 如果该节点没有孩子,新增的孩子就插入到该节点后面,否则插在该节点最后一个孩子的后面
    class Node {
        String name;
        Node last;
        Node next;
        boolean isDeleted = false;

        Node (String name) {
            this.name = name;
        }
    }
    // 链表不便于查找,所以要使用哈希表
    Map<String, Node> map = new HashMap<>();
    Node head;
    public ThroneInheritance1(String kingName) {
        Node fa = new Node(kingName);
        head = new Node("");
        head.next = fa;
        map.put(kingName, fa);
    }

    public void birth(String parentName, String childName) {
        Node child = new Node(childName);
        map.put(childName, child);
        // 插入链表中
        Node p = map.get(parentName);
        Node temp = p;
        while (temp.last != null) {
            temp = temp.last;
        }
        child.next = temp.next;
        temp.next = child;
        p.last = child;
    }

    public void death(String name) {
        Node node = map.get(name);
        node.isDeleted = true;
    }

    public List<String> getInheritanceOrder() {
        Node cur = head.next;
        List<String> ans = new ArrayList<>();
        while (cur != null) {
            if (!cur.isDeleted) ans.add(cur.name);
            cur = cur.next;
        }
        return ans;
    }

}
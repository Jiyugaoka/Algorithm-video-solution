/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        if (this.visited.containsKey(head)) return this.visited.get(head);
        Node headCopy = new Node(head.val);
        this.visited.put(head, headCopy);
        headCopy.next = copyRandomList(head.next);
        headCopy.random = copyRandomList(head.random);
        return headCopy;
    }

    private Node getCopy(Node head) {
        if (head == null) return null;
        if (this.visited.containsKey(head)) return this.visited.get(head);
        
        Node headCopy = new Node(head.val);
        this.visited.put(head, headCopy);
        return headCopy;
    }

    public Node copyRandomList2(Node head) {
        // 哨兵节点
        Node headCopyed = new Node(0);
        Node ptr1 = head;
        Node ptr2 = headCopyed;
        while (ptr1 != null) {
            ptr2.next = this.getCopy(ptr1);
            ptr2 = ptr2.next;
            // 对新节点的next和random指针进行copy
            ptr2.next = this.getCopy(ptr1.next);
            ptr2.random = this.getCopy(ptr1.random);
            // copy结束，原指针和新节点指针继续往后挪
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return headCopyed.next;
    }

    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        Node ptrOld = head;
        Node ptrNew = null;
        // 合并阶段
        // A->copy(A)->B->copy(B)->C->copy(C)->D
        while (ptrOld != null) {
            // copy操作：执行copy()操作
            ptrNew = new Node(ptrOld.val);
            // link操作：先链接A的后续节点，防止链表断裂。
            ptrNew.next = ptrOld.next;
            // link操作：将copy(A)与A链接
            ptrOld.next = ptrNew;
            // move操作：往后移动ptrOld
            ptrOld = ptrNew.next;
        }
        // 设置random节点阶段        
        ptrOld = head;
        while (ptrOld != null) {
            // 设置random节点阶段
            ptrOld.next.random = (ptrOld.random == null) ? null : ptrOld.random.next;
            // move操作：往后移动ptrOld
            ptrOld = ptrOld.next.next;
        }
        //将A->copy(A)->B->copy(B)->C->copy(C)拆分为两段
        // A->B->C
        // copy(A)->copy(B)->copy(C)
        Node dummy = new Node(0);
        ptrOld = head;
        ptrNew = head.next;
        dummy.next = ptrNew;
        while (ptrOld != null) {
            // 开始拆分
            ptrOld.next = ptrNew.next;
            // 旧指针向后挪
            ptrOld = ptrNew.next;

            if (ptrOld == null) break;
            ptrNew.next = ptrOld.next;
            // 新指针向后挪
            ptrNew = ptrOld.next;
            // 仔细观看拆分的代码，都是一个模板，先赋值next指针，然后挪到那个位置
        }
        return dummy.next;
    }
}
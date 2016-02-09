// Copy List with Random Pointer Total Accepted: 41235 Total Submissions: 164274 My Submissions Question Solution 
// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.

// Hide Tags Hash Table Linked List

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class RandomPonter {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
        	return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode node = head;
        // create new nodes and copy the label from the original one
        while (node != null) {
        	RandomListNode newNode = new RandomListNode(node.label);
        	map.put(node, newNode);
        	node = node.next;
        }
        node = head;
        RandomListNode temp;
        while (node != null) {
        	temp = map.get(node);
        	temp.next = map.get(node.next);
        	temp.random = map.get(node.random);
        	node = node.next;
        }

        return map.get(head);
    }
}

// slow version
// public class Solution {
//     public RandomListNode copyRandomList(RandomListNode head) {
//         if (head == null) {
//             return head;
//         }
        
//         HashMap<Integer, RandomListNode> map = new HashMap<>();
//         RandomListNode newHead = null;
//         while (head != null) {
//             // copy current node
//             RandomListNode curNode;
//             if (!map.containsKey(head.label)) {
//                 curNode = new RandomListNode(head.label);
//                 map.put(curNode.label, curNode);
//             }
//             else {
//                 curNode = map.get(head.label);
//             }
            
//             // copy next node
//             if (head.next != null) {
//                 if (!map.containsKey(head.next.label)) {
//                     curNode.next = new RandomListNode(head.next.label);
//                     map.put(curNode.next.label, curNode.next);
//                 }
//                 else {
//                     curNode.next = map.get(head.next.label);
//                 }
//             }
            
//             // copy random node
//             if (head.random != null) {
//                 if (!map.containsKey(head.random.label)) {
//                     curNode.random = new RandomListNode(head.random.label);
//                     map.put(curNode.random.label, curNode.random);
//                 }
//                 else {
//                     curNode.random = map.get(head.random.label);
//                 }
//             }
            
//             if (newHead == null) {
//                 newHead = curNode;
//             }
//             head = head.next;
//         }
        
//         return newHead;
//     }
// }


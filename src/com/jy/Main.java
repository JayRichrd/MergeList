package com.jy;

public class Main {

	public static void main(String[] args) {
		// 构造两个排序链表
		ListNode listNode9 = new ListNode(9, null);
		ListNode listNode7 = new ListNode(7, listNode9);
		ListNode listNode5 = new ListNode(5, listNode7);
		ListNode listNode3 = new ListNode(3, listNode5);
		ListNode listNode1 = new ListNode(1, listNode3);
		ListNode head1 = listNode1;

		ListNode listNode8 = new ListNode(8, null);
		ListNode listNode6 = new ListNode(6, listNode8);
		ListNode listNode4 = new ListNode(4, listNode6);
		ListNode listNode2 = new ListNode(2, listNode4);
		ListNode head2 = listNode2;

		System.out.print("有序链表1:");
		printListNode(head1);
		System.out.print("有序链表2:");
		printListNode(head2);

		System.out.print("合并后的链表3:");
		printListNode(mergerecursively(head1, head2));
		// printListNode(merge(head1, head2));

	}

	/**
	 * 合并两个有序的链表，并返回合并后链表的头结点
	 * 
	 * @param head1
	 *            待合并的有序链表1
	 * @param head2
	 *            待合并的有序链表2
	 * @return 合并后的链表的头结点
	 */
	public static ListNode merge(ListNode head1, ListNode head2) {
		// 鲁棒性检查
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		// 合并后链表的头节点
		ListNode head3 = null;
		// 确定合并后链表的头结点
		if (head1.mValue < head2.mValue) {
			head3 = head1;
			head1 = head1.mNext;
		} else {
			head3 = head2;
			head2 = head2.mNext;
		}
		// 合并后链表的当前节点
		ListNode listNode = head3;
		// 循环将两个链表合并
		while (head1 != null && head2 != null) {
			if (head1.mValue < head2.mValue) {
				listNode.mNext = head1;
				listNode = listNode.mNext;
				head1 = head1.mNext;
			} else {
				listNode.mNext = head2;
				listNode = listNode.mNext;
				head2 = head2.mNext;
			}
		}
		// 将剩余链表直接接到尾部
		if (head1 != null)
			listNode.mNext = head1;
		// 将剩余链表直接接到尾部
		if (head2 != null)
			listNode.mNext = head2;

		// 返回合并链表的头节点
		return head3;
	}

	/**
	 * 用递归的方式合并两个有序的链表，并返回合并后链表的头结点
	 * 
	 * @param head1
	 *            待合并的有序链表1
	 * @param head2
	 *            待合并的有序链表2
	 * @return 合并后的链表的头结点
	 */
	public static ListNode mergerecursively(ListNode head1, ListNode head2) {
		// 鲁棒性检查
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		// 合并后链表的头节点
		ListNode head3 = null;
		// 确定合并后链表的头结点
		if (head1.mValue < head2.mValue) {
			head3 = head1;
			// 递归
			head3.mNext = mergerecursively(head1.mNext, head2);
		} else {
			head3 = head2;
			// 递归
			head3.mNext = mergerecursively(head1, head2.mNext);
		}
		// 返回合并链表的头节点
		return head3;
	}

	/**
	 * 从头节点往后遍历输出链表
	 * 
	 * @param headNode
	 *            待输出链表的头节点
	 */
	public static void printListNode(ListNode headNode) {
		ListNode node = headNode;
		for (; node.mNext != null; node = node.mNext) {
			System.out.print(node.mValue + "->");
		}
		System.out.print(node.mValue);
		System.out.println();
	}

}

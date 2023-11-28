public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy head node for the resulting linked list
        ListNode current = dummyHead; // Current node to track the result

        int carry = 0; // Carry value for each sum

        while (l1 != null || l2 != null) {
            int sum = carry;

            // Add the values from l1 and l2 if they exist
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate the new carry and create a new node with the sum % 10 value
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        // If there is a remaining carry, create a new node with the carry value
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // Return the next node of the dummy head (start of the resulting linked list)
    }

    public static void main(String[] args) {

    }
}

class Node:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


class LinkedList:

    @staticmethod
    def print_ll(head):
        temp = head
        while temp:
            print(temp.val)
            temp = temp.next

    @staticmethod
    def size_of_ll(head):
        size = 0
        temp = head
        while temp:
            size += 1
            temp = temp.next
        return size

    @staticmethod
    def reverse_ll(head):
        curr = head
        prev = None

        while curr:
            future = curr.next
            curr.next = prev
            prev = curr
            curr = future

        return prev

    @staticmethod
    def mid_ll_second_even(head):
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        return slow

    @staticmethod
    def mid_ll_first_even(head):
        slow = head
        fast = head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        return slow

    def is_palindrome(self, head):
        h1 = head

        # Find mid
        mid = self.mid_ll_first_even(h1)

        # Split
        h2 = mid.next
        mid.next = None

        # Reverse second half
        h2 = self.reverse_ll(h2)

        # Compare
        while h1 and h2:
            if h1.val != h2.val:
                return False
            h1 = h1.next
            h2 = h2.next

        return True

    def reorder(self, head):
        h1 = head

        # Find mid
        mid = self.mid_ll_first_even(h1)

        # Split
        h2 = mid.next
        mid.next = None

        # Reverse second half
        h2 = self.reverse_ll(h2)

        # Merge
        while h1 and h2:
            f1 = h1.next
            f2 = h2.next

            h1.next = h2
            h2.next = f1

            h1 = f1
            h2 = f2

    def is_cycle(self, head):
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                return True

        return False

    def starting_node_of_cycle(self, head):
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                break
        else:
            return None  # no cycle

        t1 = slow
        t2 = head

        while t1 != t2:
            t1 = t1.next
            t2 = t2.next

        return t1

    def length_of_cycle(self, head):
        start = self.starting_node_of_cycle(head)
        if not start:
            return 0

        temp = start.next
        count = 1

        while temp != start:
            temp = temp.next
            count += 1

        return count


# Driver code
if __name__ == "__main__":
    n1 = Node(10)
    n2 = Node(20)
    n3 = Node(30)
    n4 = Node(40)

    n1.next = n2
    n2.next = n3
    n3.next = n4

    LinkedList.print_ll(n1)
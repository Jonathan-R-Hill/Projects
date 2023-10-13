const addTwoNumbers = (l1, l2) => {
    let answer = new ListNode(0)
    let count = answer
    let currentNum = 0
    let carry = 0

    while (l1 != null || l2 != null || currentNum != 0) {
        
        if (l1 !== null) {
            currentNum = l1.val + currentNum
            l1 = l1.next
        }

        if (l2 !== null) {
            currentNum = l2.val + currentNum
            l2 = l2.next
        }

        if (currentNum > 9) {
            carry = 1
            currentNum -= 10
        } else {
            carry = 0
        }

        count.next = new ListNode(currentNum)
        count = count.next

        currentNum = carry
    }
    return answer.next

};
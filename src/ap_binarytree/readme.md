# **When to Think of Using a Stack in Tree Problems?**

## Use a stack in tree construction when:

* You process nodes sequentially but need to track their hierarchy.
* You need to attach children to the correct parent while moving forward.
* You need to backtrack when going up the tree (i.e., when depth decreases).

## Why Stack works?
* **Tracks parents efficiently** → Last node in the stack is always the most recent unprocessed parent.
* **Handles backtracking** → Popping the stack ensures we attach nodes at the correct level.
* **Single pass over the input** → O(n) time complexity, O(n) space complexity (implicit tree storage).
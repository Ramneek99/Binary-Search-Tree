public class Bst <T extends Comparable<T>>
//Note that T extends comparable interface-- This guarantees our generic type will implement compareTo allowing us to compare 2
//values of type T. This is necessary because there is no way to know WHAT member functions T will have. This is also why we
//have to implement hashCode for Student since we are guaranteed to have a hashCode implementation since T is guaranteed to because
//an object and objects have hashCode implementation as well as equals and toString
{
    private BstNode root; //BstNode is a private inner class

    public Bst()
    {
        root=null;
    }

    public void add(T value)
    {

        //TODO 2A: Implement add of Bst such that if root is null root now points to a
        //BST Node With value. Otherwise it'll call add of BstNode with the T value on root.
        //(remember root is a BstNode)
        if(this.root ==null){
            this.root = new BstNode(value);
        } else {
            root.add(value);
        }

    }

    public T getObject(int idNumber)
    {
        //TODO 3A: if root equals null, return null. Otherwise call getTarget on root with the given ID number and
        // return the value that is returned from getTarget.
        if(this.root == null){
            return null;
        } else{
            return this.root.getTarget(idNumber);
        }
    }


    public T remove(int idNumber)
    {
        //TODO 4A: Implement remove in Bst. If root is null return null, Otherwise,
        // first call getTarget to get a reference to the node you want to remove.
        // If getTarget returns null, you're done and you return. If getTarget is not null then
        // call delete on the root with the idNumber. After it runs,
        // your return the reference to the deleted node you previously saved by using getTarget
        T removeTarget = this.getObject(idNumber);
        if(removeTarget == null){
            return null;
        }else {
            this.root.delete(idNumber);
        }
        return removeTarget;
    }

    public String toString()
    {
        String toReturn="";
        toReturn+="*****Printing Tree\n";
        if(root!=null)
        {
            toReturn+=root.toString();
        }
        toReturn+="*****End Tree\n";
        return toReturn;
    }


    private class BstNode
    {
        private T data;
        private BstNode left;
        private BstNode right;

        public BstNode(T dataToSet)
        {
            data=dataToSet;
            left=null;
            right=null;
        }

        public void setData(T dataToSet)
        {
            data= dataToSet;
        }

        public void setLeft(BstNode linkToSet)
        {
            left=linkToSet;
        }

        public void setRight(BstNode linkToSet)
        {
            right=linkToSet;
        }

        public T getData()
        {
            return data;
        }

        public BstNode getLeft()
        {
            return left;
        }

        public BstNode getRight()
        {
            return right;
        }

        public T getTarget(int key)
        {
            //Todo 3B: Implement getTarget recursively. We have 3 base cases.
            // Case 1: our data has the same hashcode as the key (i.e. same schoolID in the case Student is our Generic),
            // In this case we return the data reference because we found it!
            // Case 2: our key is less than the data of our hashCode and left is null, it means that the key is not in our tree,
            // we return null. Case 3: Our key is greaer than the data of our hashCode and right is null, we again return null.
            int ourKey = this.data.hashCode();
            if(ourKey == key){
                return this.data;
            }
            if(ourKey > key && this.left == null){
                return  null;
            }
            if (ourKey < key && this.right == null){
                return null;
            }

            if(ourKey > key){
                return this.left.getTarget(key);
            }else{
                return this.right.getTarget(key);
            }
            //TODO 3C:  Implement the recursive calls. These have 2 cases:
            // Case1: if our key is less than the hashCode of our data we return the result of calling getTarget on our left child.
            // Case 2: If our key is greater than the hashCode of our Data we return the result of calling getTarget on our right child.

        }

        public void add(T value)
        {
            //TODO 2B: Implement BstNode Add. This must be done recursively
            // We have 3 base cases-- The FIRST is if we have the value in the Tree Then we just return
            // (that item has already been added to the tree), we won't deal with multiple of the same
            // value added to the tree (it's easy, we just have a frequency variable in BstNode but in our context,
            // Student, it doesn't make sense, we would expect just one student with a given ID number).
            // The SECOND base case is that the value is less than our current node value and our left child is null.
            // The THIRD base case is that the value is greater than our current node value and right child is null.
            // For all of these we should use compareTo implemented in Student
            int compare = this.data.compareTo(value);
            if(compare ==0 ){return;}
            if(compare>0 && this.left==null){
                //value is high
                this.left = new BstNode(value);
                return;
            }
            if(compare<0 && this.right == null){
                //value is low
                this.right = new BstNode(value);
                return;
            }

            if(compare > 0){
                this.left.add(value);
            } else {
                this.right.add(value);
            }

            //TODO 2C: 2 cases for recursion:
            // Case 1: if the value we want to add is less than the current key and our left child is not null
            // we want to call add on the left node and Case 2: if the the value we want to add is greater than the
            // current key and the right child is not null we want to call add on the right node.
            // In both cases our parameter is the value to add

        }

        public BstNode delete(int key)
        {
            //TODO 4D: We have a three base cases here,
            // Remember we always return what our parent node will now point to
            // The FIRST CASE is the easiest-- removing a node with no children.
            // if our key equals our data's hashCode we return null.
            // The SECOND CASE is if our key equals our data's hashcode and we have 1 child,
            // we return that child (that is what our parent node should now point to).
            // The THIRD CASE is if our key equals our data's hashcode and we have 2 children.
            // We replace our data with the the data of the leftmost node in our right subtree
            // (call getLeftMost on our right child). At this point we will have 2 nodes with the same data.
            // So now, we call DELETE again on our right subtree with the key to remove the duplicate node.

            int childs = this.getNumChildren();
            int ourHashCode = this.data.hashCode();
            if (ourHashCode == key && childs==0){
                return null;
            }
            if (ourHashCode == key && childs == 1){
                return this.left == null ? this.right : this.left;
            }
            if(ourHashCode == key && childs == 2){
                this.data = this.right.getLeftMost().data;
                this.right = this.right.delete(this.data.hashCode());
                return this;
            }

            if(ourHashCode > key){
                if(this.left != null)
                this.left = this.left.delete(key);
            } else{
                if(this.right != null)
                this.right = this.right.delete(key);
            }

            //TODO 4E: if our Key is less than our hashcode we set our left child to whatever is returned from left.delete()
            // (think about this-- we are setting our left child to the recursive call on this delete function
            // which will return what we should be pointing to). On the other hand if our key is greater than our hashcode
            // we set our right child to whatever is returned from right.delete().

            return this;

        }

        private int getNumChildren()
        {
            //TODO 4B: Implement getNumChildren in BstNode--
            // this returns the number of children for a given BstNode. i
            // f left and right are both not null we have 2 children.
            // If left and right both equal null we know we have 0 children and if neither of those are true we know we have 1 child...
            if(this.right != null && this.left != null){
                return 2;
            }
            if(this.right == null && this.left== null){
                return 0;
            }
            return 1;
        }

        private BstNode getLeftMost()
        {
            //TODO 4C: Implement getLeftMost in BstNode-
            // remember to delete a node with 2 children we either have to get the leftMost of the right subtree
            // or the get the rightmost of the left subtree.
            // Here we are getting the leftMost of the right subtree.
            // This means we recursively drill down on the left subchild until we get to null.
            // Therefore our basecase is if left is null (we return the current node, this),
            // otherwise we recurse and we return getLeftMost of our left child. THis hsould be 4 lines of code MAX
            if(this.left == null){
                return this;
            } else {
                return this.left.getLeftMost();
            }
        }


        public String toString()
        {
            String toReturn="";
            toReturn+="Node: " +data+"\n";
            if(left!=null)
            {
                toReturn+="     Child Left: " + left.getData()+"\n";
            }
            if(left==null)
            {
                toReturn+="     Child Left: null\n";
            }
            if(right!=null)
            {
                toReturn+="     Child Right: " + right.getData()+"\n";
            }
            if(right==null)
            {
                toReturn+="     Child Right: null\n";
            }
            if(left!=null)
            {
                toReturn+=""+left;
            }
            if(right!=null)
            {
                toReturn+=""+right;
            }
            return toReturn;
        }


    }

}
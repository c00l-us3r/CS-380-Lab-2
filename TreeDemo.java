class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   inserts a node into the tree
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//closing while
      
      }//closing main if-else 
   }
   
   
   
   /***
    * Method that prints out the Pre-Order list
    * of the values within the BST.
    * @param root the root of the BST to traverse
    */
   public void preOrderTraversal(Node root){
      
      //base case
      if (root == null){
         return;
      }
   
      //print out the nodes
      System.out.print(root.value + ", ");
      
      //recursive call to go down left subtrees
      preOrderTraversal(root.left);
   
      //recursive call to go down right subtrees
      preOrderTraversal(root.right);
      
   }

   
   
   /***
    * Method to print out th In-Order list
    * of the values in the BST
    * @param root the root of the BST to traverse
    */
   public void inOrderTraversal(Node root){
      
      //base case
      if (root == null){
         return;
      }
      
      //recursive call to go down left subtrees
      inOrderTraversal(root.left);
      
      //print out the nodes
      System.out.print(root.value + ", ");
   
      //recursive call to go down right subtrees
      inOrderTraversal(root.right);      
   }
   
   
   
   /***
    * Method to print the Post-Order list
    * of the values inside the BST.
    * @param root the root of the BST to traverse
    */
   public void postOrderTraversal(Node root){
      
      //base case
      if(root==null){
         return;
      }
      
      //recursive call down the left subtree
      postOrderTraversal(root.left);
      
      //recursive call down the right subtree
      postOrderTraversal(root.right);
      
      //print out the nodes
      System.out.println(root.value + ", ");
      
   }
   
   
   
   /***
    * Method that will locate the node
    * that contains the specified key.
    * @param root the root of the BST that will be searched
    * @param kay the specific value that will be found
    * @return boolean value to indicate whether the speciied key exists within the BST
    */
   public boolean find(Node root, int key){
   
      //result variable
      boolean result = false;
      
      if(root == null){             //base case
         return false;
      }else if(key > root.value){   //go left if smaller
         result = find(root.left, key);
      }else if(key < root.value){   //go right if larger
         result = find(root.right, key);
      }else if(key == root.value){  //return true when found
         return true;
      }  
      //return
      return result;       
   }
   
   
   
   /***
    * Method to retrieve the minimum value
    * stored within the BST.
    * @param root the root of the BST to be searched
    * @return the minimum value within the BST
    */
   public int getMin(Node root){
   
      //base case
      if(root == null){
         return Integer.MAX_VALUE;
      }
      
      //result variable
      int result = 0;
      
      //keep going left until no
      //left is available 
      if(root.left != null){
         result = getMin(root.left);
      }else{
         return root.value;
      }
      //return
      return result;
   }
  
  
  
   /***
    * Method to retrive the maximum value
    * stored within the BST.
    * @param root the root of the BST to be searched
    * @return the maximum value within the BST
    */
   public int getMax(Node root){
     
      //base case
      if(root == null){
         return Integer.MAX_VALUE;
      }
      
      //result variable
      int result = 0;
      
      //keep going right until no
      //right is available 
      if(root.right != null){
         result = getMax(root.right);
      }else{
         return root.value;
      }   
      //return
      return result;  
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}
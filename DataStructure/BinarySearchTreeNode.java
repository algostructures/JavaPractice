/*Implementation of Binary Search tree*/
public class BinarySearchTreeNode {
	private int data;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public BinarySearchTreeNode getLeft(){
		return left;
	}
	
	public void setLeft(BinarySearchTreeNode left){
		this.left = left;
	}
	
	public BinarySearchTreeNode getRight(){
		return right;
	}
	
	public void setRight(BinarySearchTreeNode right){
		this.right = right;
	}
	
	BinarySearchTreeNode rFind(BinarySearchTreeNode root, int data){
		if(root == null)
			return null;
		if(data < root.getData())
			return rFind(root.getLeft(), data);
		if(data > root.getData())
			return rFind(root.getRight(), data);
		return root;
	}
	
	BinarySearchTreeNode Find(BinarySearchTreeNode root, int data){
		if(root == null)
			return null;
		while(root != null){
			if(data == root.getData())
				return root;
			else if(data > root.getData())
				root = root.getRight();
			else 
				root = root.getLeft();
		}
		return null;
	}
	
	BinarySearchTreeNode rFindMin(BinarySearchTreeNode root){
		if(root == null)
			return null;
		if(root.getLeft() == null)
			return root;
		else
			rFindMin(root.getLeft());
		return null;
	}
	
	BinarySearchTreeNode FindMin(BinarySearchTreeNode root){
		if(root == null)
			return null;
		while(root.getLeft() != null)
			root = root.getLeft();
		return root;
	}
	
	BinarySearchTreeNode Insert(BinarySearchTreeNode root, int data){
		if(root == null){
			root = new BinarySearchTreeNode();
			root.setData(data);
			root.setLeft(null);
			root.setRight(null);
		}
		
		else{
			if(data < root.getData())
				root.setLeft(Insert(root.getLeft(),data));
			else if(data > root.getData())
				root.setRight(Insert(root.getRight(),data));
		}
		return root;
	}
	
	BinarySearchTreeNode Delete(BinarySearchTreeNode root, int data){
		BinarySearchTreeNode temp = new BinarySearchTreeNode();
		if(root == null)
			return null;
		if(root.getData() > data)
			root.left = (Delete(root.getLeft(),data));
		else if(root.getData() < data)
			root.right =(Delete(root.getRight(),data));
		
		else {
			if((root.getLeft()!=null) && (root.getRight()!=null)){
				temp = FindMax(root.getLeft());
				root.data= temp.getData();
				root.left = Delete(root.getLeft(), root.getData());
			}
			else{
				temp = root;
				if(root.getLeft() == null)
					root = root.getRight();
				if(root.getRight() == null)
					root = root.getLeft();
				temp = null;
			}
		}
		return root;
	}
	
	void InOrder(BinarySearchTreeNode root){
		if(root != null){
		InOrder(root.getLeft());
		System.out.println(root.getData());
		InOrder(root.getRight());
		}
	}
	
	BinarySearchTreeNode FindMax(BinarySearchTreeNode root){
		if(root == null)
			return null;
		else{
			if(root.getRight() == null)
				return root;
			return FindMax(root.getRight());
		}
	}
	
	BinarySearchTreeNode kthSmallest(BinarySearchTreeNode root, int k, int count){
		if(root == null)
			return null;
		BinarySearchTreeNode left = kthSmallest(root.getLeft(), k, count);
		if(left != null)
			return left;
		if(++count == k)
			return root;
		return kthSmallest(root.getRight(), k, count);
	}
	
}


package classdatabase;

import java.util.LinkedList;

public class TreeIterator<T> implements java.util.Iterator<T> {
	
	//Fields
	
	private BaseBinaryTree<T> targetTree;
	private LinkedList<TreeNode<T>> list;
	
	//Constructors
	
	public TreeIterator(BaseBinaryTree<T> tree) {
		this.targetTree = tree;
		this.list = new LinkedList<TreeNode<T>>();
	}
	
	//Methods
	
	@Override
	public boolean hasNext() {
		return !(this.list.isEmpty());
	}

	@Override
	public T next() throws java.util.NoSuchElementException {
		TreeNode<T> nextNode = this.list.remove();
		return nextNode.getElement();
	}
	
	public void remove() throws UnsupportedOperationException { 
	throw new UnsupportedOperationException("Operation not support for tree iterators");
	}
	
	public void setPreorder() {
		this.list.clear();
		this.preorder(this.targetTree.root);
	}
	
	public void setInorder() {
		this.list.clear();
		this.inorder(this.targetTree.root);
	}
	
	public void setPostorder() {
		this.list.clear();
		this.postorder(this.targetTree.root);
	}

	private void preorder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			this.list.add(treeNode);
			preorder(treeNode.getLeft());
			preorder(treeNode.getRight());
		}
	}
	
	private void inorder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			inorder(treeNode.getLeft());
			this.list.add(treeNode);
			inorder(treeNode.getRight());
		}
	}
	
	private void postorder(TreeNode<T> treeNode) {
		if(treeNode != null) {
			postorder(treeNode.getLeft());
			postorder(treeNode.getRight());
			this.list.add(treeNode);
		}
	}
	
	private void inorderSorted(TreeNode<T> treeNode) {
		if(treeNode != null) {
			inorder(treeNode.getLeft());
			this.list.add(treeNode);
			inorder(treeNode.getRight());
		}
	}
	
}

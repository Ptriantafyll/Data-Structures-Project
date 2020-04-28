
public class RedBlackTree 
{
	private static final boolean red = true;
	private static final boolean black = false;
	private final RedBlackNode nil = new RedBlackNode(-1);
	private RedBlackNode root=nil;
	
	public RedBlackTree(){}

	class RedBlackNode 
	{
	
	
		int value; //value of node
		boolean color; //color of node
		RedBlackNode left,right,parent; 
		static final boolean red = true;
		static final boolean black = false;
		
		public RedBlackNode(int value)
		{
			this.value=value;
			this.setColor(black);
			this.setParent(nil);
			this.setLeftChild(nil);
			this.setRightChild(nil);
		}
		
		public void setParent(RedBlackNode n){this.parent=n;}
		public RedBlackNode getParent(){return this.parent;}
		
		public RedBlackNode getGrandParent(){return this.parent.parent;}
		
		public void setRightChild(RedBlackNode n){this.right=n;}
		public RedBlackNode getRightChild(){return this.right;}
		
		public void setLeftChild(RedBlackNode n){this.left=n;}
		public RedBlackNode getLeftChild(){return this.left;}
			
		public void setColor(boolean color){this.color=color;}
		public boolean getColor(){return this.color;}
		
		public void setValue(int value){this.value = value;}
		public int getValue(){return this.value;}
			
	}
	
	public RedBlackNode getRoot(){return this.root;}
	
	public boolean Access(int x)
	{
		RedBlackNode v = this.getRoot();
		
		while(v!=nil) 
		{
			if(x==v.getValue()) //if it is the value of a root return it 
			{
				return true;
			}	
			else if(x<v.getValue())// if the value is smaller than the root's go to the left child
			{
				v=v.getLeftChild();
			}
			else if(x>=v.getValue()) //if the value is bigger than the root's go to the right child
			{
				v=v.getRightChild();
			}
		}
		
		//if you dont find it
		return false;
	}
	
	public void insert(int x)
	{

		RedBlackNode n = new RedBlackNode(x); //initialization of new node
		
		RedBlackNode y = this.root;
		
		if(root==nil) //1st case (no other elements in tree)
		{
			root=n;
			n.setColor(black);
			n.setParent(nil);
		}
		else
		{
			while(true)
			{
			
				if(x<y.getValue())// if the value is smaller than the root's go to the left child
				{
					if(y.getLeftChild()==nil) // if the left child is a leaf put the new node in this position
					{
						y.setLeftChild(n);
						n.setParent(y);
						break;	
					}
					else //if the left child is not a leaf, keep going
					{
						y=y.getLeftChild();
					}
				}
				else //(x>=this.root.getValue()) if the value is bigger than the root's go to the right child
				{
					if(y.getRightChild()==nil)// if the right child is a leaf put the new node in this position
					{
						y.setRightChild(n);
						n.setParent(y);
						break;
					}
					else //if the right child is not a leaf, keep going
					{
						y=y.getRightChild(); 
					}
				}
			}

			adjustAfterInsertion(n);	//adjusts (if needed) after inserting 
		}
	}
	
	public void adjustAfterInsertion(RedBlackNode v)
	{		
		while(v.getParent().getColor() == red && v.getColor()==red) //red child black parent-> no problem
		{
			RedBlackNode uncle = nil;
			if(v.getParent() == v.getGrandParent().getLeftChild()) //father is a left child
			{
				uncle = v.getGrandParent().getRightChild(); //uncle is a right child
				
				if(uncle.getColor()==red && v.getGrandParent()!=root) //if uncle is red -> recolor and check grandparent
				{
					v.getParent().setColor(black);
					uncle.setColor(black);
					v.getGrandParent().setColor(red);
					v=v.getGrandParent();
					continue;
				}
				else if(uncle.getColor()==red && v.getGrandParent()==root) //if grandparent is root -> recolor 
				{
					uncle.setColor(black); 
					v.getParent().setColor(black);
				}
				else if(uncle.color==black) //uncle is black node -> 2 sub cases
				{
					if(v==v.getParent().getLeftChild()) //new node is a left child(same as father) -> single rotate and recolor
					{
						rightRotate(v.getParent()); //right rotate + recolor
						v.getParent().setColor(black);
						v.getParent().getRightChild().setColor(red);
						v.getParent().getLeftChild().setColor(red);
					}
					else if(v==v.getParent().getRightChild()) //new node is a right child (different than the father) -> double rotate and recolor
					{
						leftRotate(v); //double rotate + recolor
						rightRotate(v);
						v.setColor(black);
						v.getLeftChild().setColor(red);
						v.getRightChild().setColor(red);
					}
						
				}	
			}
			else if(v.getParent() == v.getGrandParent().getRightChild()) //father is a right child
			{
				uncle = v.getGrandParent().getLeftChild(); //uncle is a left child

				if(uncle.getColor()==red && v.getGrandParent()!=root) //if uncle is red -> recolor and check grandparent
				{
					
					v.getParent().setColor(black); 
					uncle.setColor(black);
					v.getGrandParent().setColor(red);
					v=v.getGrandParent();
					continue;
				}
				else if(uncle.getColor()==red && v.getGrandParent()==root)// if grandparent is root -> recolor
				{
					uncle.setColor(black);
					v.getParent().setColor(black);
				}
				else if(uncle.getColor()==black) //if uncle is a black node - > 2 sub cases 
				{
					if(v==v.getParent().getRightChild()) //new node is a right child (same as father) -> single rotate and recolor 
					{
						leftRotate(v.getParent());  //left rotate + recolor
						v.getParent().setColor(black);  
						v.getParent().getRightChild().setColor(red);
						v.getParent().getLeftChild().setColor(red);
						
					}
					else if(v==v.getParent().getLeftChild()) //new node is a left child(different than father) -> double rotate and recolor 
					{	
						rightRotate(v); //double rotate + recolor
						leftRotate(v);
						v.setColor(black);
						v.getLeftChild().setColor(red);
						v.getRightChild().setColor(red);

					}
						
				}
			}
			this.getRoot().setColor(black);
		}
	}
	
	public void leftRotate(RedBlackNode x)
	{
		RedBlackNode temp=nil;
		if(x.getParent()!=this.root) //check if I have to rotate root 
		{
			temp=x.getGrandParent(); 
			if(x.getParent()==temp.getLeftChild()) //x's father is a left child 
			{
				temp.getLeftChild().setRightChild(x.getLeftChild()); //x's father's right child becomes x's left child
				x.getLeftChild().setParent(temp.getLeftChild());
				
				x.setLeftChild(temp.getLeftChild()); //x's ex father becomes x's left child 
				temp.getLeftChild().setParent(x); 
				
				temp.setLeftChild(x); //x becomes grandparent's left child 
									  //( meaning x takes it's parents position )
			}
			else  //father of x is a right child
			{
				temp.getRightChild().setRightChild(x.getLeftChild()); //x'sfather's right child becomes x's left child
				x.getLeftChild().setParent(temp.getRightChild());
				
				x.setLeftChild(temp.getRightChild()); //x's ex father becomes x's left child 
				temp.getRightChild().setParent(x);
				
				temp.setRightChild(x);  //x becomes grandparent's right child 
										//( meaning x takes it's parents position )
			}
			x.setParent(temp);
					
		}
		else //need to rotate root
		{			
			temp=this.getRoot(); 
			
			temp.setRightChild(x.getLeftChild()); //x's left child becomes root's right child 
			x.getLeftChild().setParent(temp);
		
			temp.setParent(x); //ex root becomes x's left child
			x.setLeftChild(temp);
			
			x.setParent(nil); //x becomes new root
			this.root=x;
		}
	}
	
	public void rightRotate(RedBlackNode x)
	{
		RedBlackNode temp=nil; 
		if(x.getParent()!=this.root) //check if I have to rotate root 
		{
			temp=x.getGrandParent(); 
			if(x.getParent()==temp.getLeftChild())//x's father is a left child 
			{
				temp.getLeftChild().setLeftChild(x.getRightChild()); //x's father's left child becomes x's right child
				x.getRightChild().setParent(temp.getLeftChild());
				
				x.setRightChild(temp.getLeftChild()); //x's ex father becomes x's right child
				temp.getLeftChild().setParent(x);
				
				temp.setLeftChild(x); //x becomes grandparent's left child 
									  //( meaning x takes it's parents position )
			}
			else  //father of x is a right child
			{
				temp.getRightChild().setLeftChild(x.getRightChild()); //x's father's left child becomes x's right child 
				x.getRightChild().setParent(temp.getRightChild());
				
				x.setRightChild(temp.getRightChild()); //x's ex father becomes x's right child 
				temp.getRightChild().setParent(x);
				
				temp.setRightChild(x); //x becomes grandparent's right child 
									  //( meaning x takes it's parents position )
			}
			x.setParent(temp);
		}
		else //need to rotate root
		{			
			temp=this.getRoot(); 
			
			temp.setLeftChild(x.getRightChild()); //x's right child becomes root's left child 
			x.getRightChild().setParent(temp);
			
			temp.setParent(x); //ex root becomes x's right child
			x.setRightChild(temp);
			
			x.setParent(nil); //x becomes new root
			this.root=x;
			
		}
	}

	 public void printTree(RedBlackNode node)
	    {
	        if (node == nil) {
	            return;
	        }
	        printTree(node.left);
	        System.out.print(((node.getColor()==red)?"Color: Red ":"Color: Black ")+"Key: "+node.getValue()+" Parent: "+node.parent.getValue()+ " Left: " +node.getLeftChild().getValue() + " Right: " +node.getRightChild().getValue()+ "\n");
	        printTree(node.right);
	    }
}


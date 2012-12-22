package BinarySearchTree;

/**
 * Clasa tree ce prezinta Arborele
 * @author Dan
 *
 */
public class Tree
{
	public Node root; //radacina
	public Tree()
	{ 
		root = null; 
	}
	/**
	 * Metoda ce returneaza radacina
	 * @return root Radacina
	 */
	public Node returnRoot()
	{
		return root;
	}
	/**
	 * inserarea unui nod cu cheia id
	 * @param id cheia
	 */
	public void insert(int id)
	{
		Node newNode = new Node();
		newNode.item = id;
		if(root==null) //daca radacina e null atunci chaia devined radacina
			root = newNode;
		else
		{
			Node current = root;
			Node parent;
			while(true)
			{
				parent = current;
				if(id < current.item)
				{
					current = current.leftChild;
					if(current == null)
					{
						parent.leftChild = newNode;
						return;
					}
				} 
				else
				{
					current = current.rightChild;
					if(current == null) 
					{
						parent.rightChild = newNode;
						return;
					}
				} 
			} 
		} 
	} 
	/**
	 * Traversarea in modota preordine rad;SAS;SAD
	 * @param Root radacina Arborelui
	 */
	public void preOrder(Node Root)
	{
		if(Root != null)
		{	
			System.out.print(Root.item + " ");
			preOrder(Root.leftChild);
			preOrder(Root.rightChild);
		}
	}
	/**
	 * Traversarea in metoda inordine SAS;rad;SAD
	 * @param Root radacina Arborelui
	 */
	public void inOrder(Node Root)
	{
		if(Root != null)
		{
			inOrder(Root.leftChild);
			System.out.print(Root.item + " ");
			inOrder(Root.rightChild);
		}
	}
	/**
	 * Travesarea in metoda postordine SAS;SAD;rad 
	 * @param Root radacina Arborelui
	 */
	public void postOrder(Node Root)
	{
		if(Root != null)
		{
			postOrder(Root.leftChild);
			postOrder(Root.rightChild);
			System.out.print(Root.item + " ");
		}
	}
	/**
	 * Afisarea Arborelui introdus in main
	 */
	public void displayTree()
	{
		Stack globalStack = new Stack(); //folosim stiva globala pentru a introduce nodurile in ea
		globalStack.push(root);	
		int emptyLeaf = 32;
		boolean isRowEmpty = false;
		System.out.println("****......................................................****");
		while(isRowEmpty==false)
		{

			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j=0; j<emptyLeaf; j++)
				System.out.print(' ');
			//daca stiva globala este goala
			while(globalStack.isEmpty()==false)
			{
				Node temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.item);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null ||temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--"); //locurile goale na nivelul curent
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<emptyLeaf*2-2; j++)
					System.out.print(' ');
			}
			System.out.println();
			emptyLeaf /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}
	System.out.println("****......................................................****");
	} 
} 
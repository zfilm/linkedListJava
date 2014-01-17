class Node{
  	public int element;
  	public Node next;
  	public Node(){	
  	}
  	
  	public Node(int e, Node n){
    	element=e;
    	next=n;
  	}
  	public int findElement(){
    	return element;
  	}
  	public Node findNext(){
    	return next;
  	}
} //class Node

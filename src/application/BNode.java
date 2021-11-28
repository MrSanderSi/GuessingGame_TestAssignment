package application;

class BNode {
	String value;
	BNode left;
	BNode right;
	
	BNode(String value){
		this.value = value;
		right = null;
		left = null;
	}
	public BNode addNode(BNode current, String value) {
		return new BNode(value);
	}
}
package datastructures;

public class NodeLL <T>{
	T data;
	NodeLL<T> next;
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	public NodeLL(T data) {
		this.data = data;
	}
}
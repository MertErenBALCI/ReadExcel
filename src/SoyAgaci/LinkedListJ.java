package SoyAgaci;

public class LinkedListJ<T> {
	public class Node {
		T veri;
		Node next;
	
		public Node(T veri) {
			this.veri = veri;
			next = null;
		}
	}
	
	public Node on;
	public Node arka;
	public int size;
	public LinkedListJ() {
		on = null;
		arka = null;
		size = 0;
	}
	
	public void oneEkle(T veri) {
		if(on == null) {
			on = new Node(veri);
			arka = on;
		}
		else {
			Node yeniNode = new Node(veri);
			yeniNode.next = on;
			on = yeniNode;
		}
		size++;
	}
	public T ondenCikar() {
		T dondurelecek = on.veri;
		Node tmp = on;
		on = on.next;
		tmp = null;
		size--;
		return dondurelecek;
	}
	
	public void arkayaEkle(T veri) {
		if(on == null) {
			on = new Node(veri);
			arka = new Node(veri);
		}
		else {
			Node yeniNode = new Node(veri);
			arka.next = yeniNode;
			arka = arka.next;
		}
		size++;
	}
	
	public T arkadanCikar() {
		
		if(on == null) {
			System.out.println("Liste boş");
			return null;
		}
		if(on == arka) {
			T v = on.veri;
			on = arka = null;
			size--;
			return v;
		}
		
		Node a = on;
		Node b = on;
		
		while(a.next != null) {
			b = a;
			a = a.next;
		}
		T dondurulecek = a.veri;
		a = null;
		arka = b;
		b.next = null;
		size--;
		return dondurulecek;
	}
	
	public boolean bosMu() {
		if(on == null) {
			return true;
		}
		return false;
	}
	
	public T at(int i) {
		Node a = on;
		int c = 0;
		if(i > size - 1) {
			System.out.println("No index");
			return null;
		}
		while(a.next != null && c < i) {
			c++;
			a = a.next;
		}
		T veri = a.veri;
		
		return veri;
	}
}

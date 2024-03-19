package SoyAgaci;

import SoyAgaci.LinkedListJ.Node;

public class BinaryTree {
	public class Node {
		Kisi veri;
		Node sol;
		Node sag;
	
		public Node(Kisi veri) {
			this.veri = veri;
			sol = null;
			sag = null;
		}
	}
	
	public Node kok;
	public BinaryTree() {
		kok = null;
	}
	
	
	private Node yasaGoreDugumEkle(Node node, Kisi veri) {
		if(node == null) {
			return new Node(veri);
		}
		else {
			if(node.veri.BuyuklukAl() < veri.BuyuklukAl()) {
				node.sol = yasaGoreDugumEkle(node.sol, veri);
			}
			else {
				node.sag = yasaGoreDugumEkle(node.sag, veri);
			}
		}
		return node;
	}
	
	public void yasaGoreAgacaEkle(Kisi veri) {
		kok = yasaGoreDugumEkle(kok, veri);
	}
	
	private Node alfabetikDugumEkle(Node node, Kisi veri) {
		if(node == null) {
			return new Node(veri);
		}
		else {
			if(node.veri.getId().equals(veri.getId())) {
				return node;
			}
			
			if(node.veri.getAd().compareToIgnoreCase(veri.getAd()) > 0) {
				node.sol = alfabetikDugumEkle(node.sol, veri);
			}
			else {
				node.sag = alfabetikDugumEkle(node.sag, veri);
			}
		}
		return node;
	}
	
	public void alfabetikAgacaEkle(Kisi veri) {
		kok = alfabetikDugumEkle(kok, veri);
	}
	
	private void isimSoyIsim(Node node) {
		System.out.print(node.veri.getAd() + " " + node.veri.getSoyAd() + " ");
	}
	
	private void dogumTarihiString(Node node) {
		System.out.print(node.veri.getDogumTarihi() + " ");
	}
	
	private void kanGrubu(Node node) {
		System.out.print(node.veri.getKanGrubuString() + " ");
	}
	
	private void meslek(Node node) {
		System.out.print(node.veri.getMeslek() + " ");
	}
	
	private void yas(Node node) {
		int yas = 2022 - node.veri.getDogumTarihi().y;
		System.out.print(yas + " ");
	}
	
	public void dugumGez(Node node) {
		if(node != null) {
			dugumGez(node.sol);
			isimSoyIsim(node);
			meslek(node);
			yas(node);
			System.out.println();
			dugumGez(node.sag);
		}
	}
	
	public void agacGez() {
		dugumGez(kok);
	}
	
}

package SoyAgaci;

import java.util.ArrayList;

public class Dugum {
	
	public static final int HAZIR = 0;
	public static final int BEKLEMEDE = 1;
	public static final int ISLENMIS = 2;
	
	
	
	public Kisi veri;
	public int durum;
	
	public Dugum(Kisi veri) {
		this.veri = veri;
		this.durum = HAZIR;
	}
}

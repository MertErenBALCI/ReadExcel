package SoyAgaci;


import java.util.ArrayList;
import java.util.Date;


public class Kisi {
	
	public class KanGrubu {
		boolean isaret;
		char harf;
		
		public KanGrubu(char harf, boolean isaret) {
			this.harf = harf;
			this.isaret = isaret;
		}
	}
	
	public class DogumTarihi {
		int g;
		int a;
		int y;
		
		public DogumTarihi(int g, int a, int y) {
			this.g = g;
			this.a = a;
			this.y = y;
		}
	}
	
	
    //tcno id,ad ,soyad,doğum tarihi,anne adı,baba adı,kan grubu,
    //meslek özellikleri,kızlık soy adı,cinsiyet
    private String id;
    private String ad;
    private String soyAd;
    private DogumTarihi dogumTarihi; //gün, ay ,yıl şeklinde alınacak int değil???
    private String anneAdi;
    private String babaAdi;
    private String esAdi;
    private KanGrubu kanGrubu;
    private String meslek;
    private String kizlikSoyAdi;
    private String cinsiyet;//int olarak yapılabilir 1=erkek, 2=kız şeklinde
    private String medeniHal;
    
    private Kisi es;
    
    private Kisi anne;
    private Kisi baba;
    private ArrayList<Kisi> cocuklar;
    
    public int durum;
    
    public Kisi(){
    	anne = null;
    	baba = null;
    	es = null;
    	cocuklar = new ArrayList<Kisi>();
        durum = 0;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the ad
     */
    public String getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(String ad) {
        this.ad = ad;
    }

    /**
     * @return the soyAd
     */
    public String getSoyAd() {
        return soyAd;
    }

    /**
     * @param soyAd the soyAd to set
     */
    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    /**
     * @param dogumTarihi the dogumTarihi to set
     */
    public void setDogumTarihi(String dogumTarihi) {
    	String[] a = dogumTarihi.split("/");
    	
    	int gg = Integer.parseInt(a[0]);
    	int aa = Integer.parseInt(a[1]);
    	int yy = Integer.parseInt(a[2]);
    	
    	this.dogumTarihi = new DogumTarihi(gg, aa, yy);
    }

    /**
     * @return the anneAdi
     */
    public String getAnneAdi() {
        return anneAdi;
    }

    /**
     * @param anneAdi the anneAdi to set
     */
    public void setAnneAdi(String anneAdi) {
        this.anneAdi = anneAdi;
    }

    /**
     * @return the babaAdi
     */
    public String getBabaAdi() {
        return babaAdi;
    }

    /**
     * @param babaAdi the babaAdi to set
     */
    public void setBabaAdi(String babaAdi) {
        this.babaAdi = babaAdi;
    }

    /**
     * @return the kanGrubu
     */
    public String getKanGrubuString() {
    	
    	char isaret = (kanGrubu.isaret) ? '+' : '-';
    	
    	if(kanGrubu.harf == 'C') {
    		return String.format("AB(%c)", isaret);
    	}
    	
    	return String.format("%c(%c)", kanGrubu.harf, isaret);
    }
    
    public KanGrubu getKanGrubu() {
    	return kanGrubu;
    }
    /**
     * @param kanGrubu the kanGrubu to set
     */
    public void setKanGrubu(KanGrubu kanGrubu) {
        this.kanGrubu = kanGrubu;
    }
    
    public void setKanGrubu(String kanGrubu) {
    	boolean isaret = kanGrubu.contains("+");
    	char harf = 'C';
    	if(kanGrubu.contains("AB")) {
    		harf = 'C';
    	}
    	else if(kanGrubu.charAt(0) == 'B') {
    		harf = 'B';
    	}
    	else if(kanGrubu.charAt(0) == 'A') {
    		harf = 'A';
    	}
    	else if(kanGrubu.charAt(0) == '0') {
    		harf = '0';
    	}
    	
    	this.kanGrubu = new KanGrubu(harf, isaret);
    }
    
    /**
     * @return the meslek
     */
    public String getMeslek() {
        return meslek;
    }

    /**
     * @param meslek the meslek to set
     */
    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    /**
     * @return the kizlikSoyAdi
     */
    public String getKizlikSoyAdi() {
        return kizlikSoyAdi;
    }

    /**
     * @param kizlikSoyAdi the kizlikSoyAdi to set
     */
    public void setKizlikSoyAdi(String kizlikSoyAdi) {
        this.kizlikSoyAdi = kizlikSoyAdi;
    }

    public String getDogumTarihiString() {
		return String.format("%d/%d/%d", dogumTarihi.g, dogumTarihi.a, dogumTarihi.y);
	}
    
    public DogumTarihi getDogumTarihi() {
    	return dogumTarihi;
    }

	/**
     * @return the cinsiyet
     */
    public String getCinsiyet() {
        return cinsiyet;
    }

    /**
     * @param cinsiyet the cinsiyet to set
     */
    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    /**
     * @return the medeniHal
     */
    public String getMedeniHal() {
        return medeniHal;
    }

    /**
     * @param medeniHal the medeniHal to set
     */
    public void setMedeniHal(String medeniHal) {
        this.medeniHal = medeniHal;
    }

    /**
     * @return the esAdi
     */
    public String getEsAdi() {
        return esAdi;
    }

    /**
     * @param esAdi the esAdi to set
     */
    public void setEsAdi(String esAdi) {
        this.esAdi = esAdi;
    }
    
    public Kisi getEs() {
    	return es;
    }
    
    public void setEs(Kisi es) {
    	this.es = es;
    }

    public ArrayList<Kisi> getCocuklar() {
    	return cocuklar;
    }
    
    public Kisi getAnne() {
    	return anne;
    }
    
    public void cocukEkle(Kisi cocuk) {
    	cocuklar.add(cocuk);
    }
    
    public void ebeveynEkle(Kisi ebeveyn) {
    	this.anne = ebeveyn;
    }
    
    public float BuyuklukAl() {
    	
    	float toplam = 0;
    	toplam += (Float) (dogumTarihi.g / 30.f);
    	toplam += (Float) (dogumTarihi.a / 12.f);
    	toplam += (dogumTarihi.y);
    	
    	return toplam;
    }
}
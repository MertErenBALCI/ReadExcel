package SoyAgaci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.formula.BaseFormulaEvaluator;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SoyAgaci {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        ArrayList<Kisi> kisilerListe;

        File file = new File("D:\\Programlama\\JAVA\\ReadExcel\\TestDosyası.xlsx");   //creating a new file instance  
        
        kisilerListe = KisilerListesiOlustur(file);
        
        kisilerListe = bubbleSort(kisilerListe);
        
        esEkle(kisilerListe);
        cocuklariEkle(kisilerListe);
        
        
        /*	1 -----	Cocuksuz Kişiler
        
        BinaryTree cocuksuzlarYasSirasi = new BinaryTree();
        DFSCocuguOlmayanlarYasaGore(isimdenBul(kisilerListe, "Furkan", null), cocuksuzlarYasSirasi);
        
        cocuksuzlarYasSirasi.agacGez();
        
        */
        
        /*	2 -----	UveyKardeşler
        
        BinaryTree uveyAlfabetikSira = new BinaryTree();
        BFSUveyKardeslerAlfabetik(isimdenBul(kisilerListe, "Uğur", null), uveyAlfabetikSira);
        uveyAlfabetikSira.agacGez();
        
        */
        
        /*	3 -----	Kan Grubu
        BinaryTree kanGrubuA = new BinaryTree();
        BFSKanGrubunaGore(isimdenBul(kisilerListe,"Zeynep", null), '0', kanGrubuA);
        
        kanGrubuA.agacGez();
        */
        
        
        /*	4 -----	Meslek
        BinaryTree ayniMeslek = new BinaryTree();
        BFSMeslegeGore(isimdenBul(kisilerListe, "Furkan", null), ayniMeslek);
        
        ayniMeslek.agacGez();
        */
        
        /*	5 -----	Aynı İsim
        BinaryTree ayniIsim = new BinaryTree();
        BFSAyniIsim(isimdenBul(kisilerListe, "Furkan", null), ayniIsim);
        
        ayniIsim.agacGez();
        */
        
        /*	6 -----	İki kiş arasındaki ilişki 
         
         
        Kisi a = isimdenBul(kisilerListe, "Furkan", "Çelik");
        Kisi b = isimdenBul(kisilerListe, "İrem", "Çelik");
        
        BreadthFirstSearch(a);
        BreadthFirstSearchTerseDon(a);
        ikiKisininYakinlik(a, b);
        */
        
        
        /*	8, 	Maksimum Derinlik 
        Kisi a = isimdenBul(kisilerListe, "Almila", null);
        
        int d = BFSMaxDerinlik(a);
        System.out.println(d);
        
        9. soru -> d - 1
       	*/
       	
    }
    
    private static Kisi isimdenBul(ArrayList<Kisi> liste, String ad, String soyAd) {
    	for(Kisi k: liste) {
    		
    		if(soyAd == null) {
    			if(k.getAd().equals(ad)) {
        			return k;
        		}
    		}
    		else {
    			if(k.getAd().equals(ad) && k.getSoyAd().equals(soyAd)) {
        			return k;
        		}
    		}
    		
    	}
    	return null;
    }
    
    private static ArrayList<Kisi> bubbleSort(ArrayList<Kisi> liste) {
    	@SuppressWarnings("unchecked")
		ArrayList<Kisi> yeniListe = (ArrayList<Kisi>) liste.clone();
    	
    	for(int i = 0; i < yeniListe.size(); i++) {
    		for(int j = 0; j < yeniListe.size() - 1; j++) {
    			
    			if(yeniListe.get(j + 1).BuyuklukAl() < yeniListe.get(j).BuyuklukAl()) {
    				Kisi tmp = yeniListe.get(j);
    				yeniListe.set(j, yeniListe.get(j + 1));
    				yeniListe.set(j + 1, tmp);
    			}
    		}
    	}
    	
    	return yeniListe;
    }
    
    private static ArrayList<Kisi> KisilerListesiOlustur(File file) {
    	ArrayList<Kisi> kisilerListesi = new ArrayList<Kisi>();
    	try {
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
//creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            
            DataFormatter dt=new DataFormatter();
            dt.setUse4DigitYearsInAllDateFormats(true);
            
            for(int i=0;i<4;i++){
                XSSFSheet sheet = wb.getSheetAt(i);     //creating a Sheet object to retrieve object  
                Iterator<Row> itr = sheet.iterator();    //iterating over excel file 
               
            while (itr.hasNext()) {
                Row row = itr.next();
                if(row.getRowNum()==0){
                    continue;
                }
                Kisi temp=new Kisi();
                int j=0;
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cv=dt.formatCellValue(cell);
                    
                    
                    if(cv==null){
                        j++;
                        continue;
                    }
                    
                    if(j==0){
                        temp.setId(cv);
                    }
                    else if(j==1){
                        temp.setAd(cv);
                    }
                    else if(j==2){
                        temp.setSoyAd(cv);
                    }   
                    else if(j==3){
                        temp.setDogumTarihi(cv);
                    }
                    else if(j==4){
                       temp.setEsAdi(cv);
                    }
                    else if(j==5){
                       temp.setAnneAdi(cv);
                    }
                    else if(j==6){
                          temp.setBabaAdi(cv);
                    }
                    else if(j==7){
                       temp.setKanGrubu(cv);
                    }
                    else if(j==8){
                         temp.setMeslek(cv);
                    }
                    else if(j==9){
                        
                        temp.setMedeniHal(cv);
                    }
                    else if(j==10)
                        temp.setKizlikSoyAdi(cv);
                    else if (j==11){
                        temp.setCinsiyet(cv);
                    }
                    j++;
                }
                
                if(!searchID(kisilerListesi, temp.getId()))
                kisilerListesi.add(temp);
            }
            
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return kisilerListesi;
    	
    }

	private static boolean searchID(ArrayList<Kisi> kisilerListe, String id) {
		for(Kisi k: kisilerListe) {
			if(k.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	private static void esEkle(ArrayList<Kisi> liste) {
		for(int i = 0; i < liste.size(); i++) {
			Kisi eklenecekEs = liste.get(i);
			
			if(eklenecekEs.getEsAdi() != null && eklenecekEs.getEs() == null) {
				for(int j = 0; j < liste.size(); j++) {
					Kisi es = liste.get(j);
					
					if(eklenecekEs.getEsAdi().contains(es.getAd()) && es.getEsAdi().contains(eklenecekEs.getAd())) {
						eklenecekEs.setEs(es);
						es.setEs(eklenecekEs);
					}
				}
			}
		}
	}
	
	private static void cocuklariEkle(ArrayList<Kisi> liste) {
		for(int i = 0; i < liste.size(); i++) {
			Kisi eklenecekCocuk = liste.get(i);
			for(int j = 0; j <= i; j++) {
				Kisi ebeveyn = liste.get(j);
				
				if(ebeveyn.getAd().equals(eklenecekCocuk.getBabaAdi()) || ebeveyn.getAd().equals(eklenecekCocuk.getAnneAdi())) {
					ebeveyn.cocukEkle(eklenecekCocuk);
					
				}
			}
		}
	}

	
	
	private static void BreadthFirstSearch(Kisi kok) {
		LinkedListJ<Kisi> sira = new LinkedListJ<Kisi>();
		kok.durum = 1;
		sira.oneEkle(kok);
		while(!sira.bosMu()) {
			Kisi v = sira.arkadanCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 0) {
					k.durum = 1;
					k.ebeveynEkle(v);
					sira.oneEkle(k);
				}
			}

		}
	}
	
	private static void BreadthFirstSearchTerseDon(Kisi kok) {
		LinkedListJ<Kisi> sira = new LinkedListJ<Kisi>();
		kok.durum = 0;
		sira.oneEkle(kok);
		while(!sira.bosMu()) {
			Kisi v = sira.arkadanCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 1) {
					k.durum = 0;
					sira.oneEkle(k);
				}
			}
		}
	}
	
	private static void DepthFirstSearch(Kisi kok) {
		LinkedListJ<Kisi> stack = new LinkedListJ<Kisi>();
		kok.durum = 1;
		stack.oneEkle(kok);
		while(!stack.bosMu()) {
			Kisi v = stack.ondenCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 0) {
					k.durum = 1;
					stack.oneEkle(k);
				}
			}
			
			System.out.println(v.getAd());
		}
	}
	
	private static void DepthFirstSearchTerseDon(Kisi kok) {
		LinkedListJ<Kisi> stack = new LinkedListJ<Kisi>();
		kok.durum = 0;
		stack.oneEkle(kok);
		while(!stack.bosMu()) {
			Kisi v = stack.ondenCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 1) {
					k.durum = 0;
					stack.oneEkle(k);
				}
			}
			
		}
	}
	
	private static void DFSCocuguOlmayanlarYasaGore(Kisi kok, BinaryTree agac) {
		LinkedListJ<Kisi> stack = new LinkedListJ<Kisi>();
		kok.durum = 1;
		stack.oneEkle(kok);
		while(!stack.bosMu()) {
			Kisi v = stack.ondenCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 0) {
					k.durum = 1;
					stack.oneEkle(k);
				}
			}
			
			if(v.getCocuklar().size() == 0) {
				agac.yasaGoreAgacaEkle(v);
			}
		}
		
		DepthFirstSearchTerseDon(kok);
	}
	
	private static void BFSUveyKardeslerAlfabetik(Kisi kok, BinaryTree agac) {
		LinkedListJ<Kisi> sira = new LinkedListJ<Kisi>();
		kok.durum = 1;
		sira.oneEkle(kok);
		while(!sira.bosMu()) {
			Kisi v = sira.arkadanCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 0) {
					k.durum = 1;
					sira.oneEkle(k);
				}
			}
			
			for(int i = 0; i < sira.size; i++) {
				Kisi a = sira.at(i);
				for(int j = 0; j < sira.size; j++) {
					if(j != i) {
						Kisi b = sira.at(j);
						if(a.getAnneAdi().equals(b.getAnneAdi()) && !a.getBabaAdi().equals(b.getBabaAdi())) {
							agac.alfabetikAgacaEkle(a);
							agac.alfabetikAgacaEkle(b);
						}
						else if(!a.getAnneAdi().equals(b.getAnneAdi()) && a.getBabaAdi().equals(b.getBabaAdi())) {
							agac.alfabetikAgacaEkle(a);
							agac.alfabetikAgacaEkle(b);
						}
					}
				}
			}
		}
		
		BreadthFirstSearchTerseDon(kok);
	}
	
	// 'A' -> A, 'B' -> B, 'C' -> AB, '0' -> 0
	private static void BFSKanGrubunaGore(Kisi kok, char grup, BinaryTree agac) {
		LinkedListJ<Kisi> sira = new LinkedListJ<Kisi>();
		kok.durum = 1;
		sira.oneEkle(kok);
		while(!sira.bosMu()) {
			Kisi v = sira.arkadanCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 0) {
					k.durum = 1;
					sira.oneEkle(k);
				}
			}
			
			if(v.getKanGrubu().harf == grup) {
				agac.yasaGoreAgacaEkle(v);
			}
		}
		
		BreadthFirstSearchTerseDon(kok);
	}
	
	private static void BFSMeslegeGore(Kisi kok, BinaryTree agac) {
		LinkedListJ<Kisi> sira = new LinkedListJ<Kisi>();
		kok.durum = 1;
		sira.oneEkle(kok);
		while(!sira.bosMu()) {
			Kisi v = sira.arkadanCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 0) {
					k.durum = 1;
					sira.oneEkle(k);
				}
			}

			if(kok.getMeslek().equals(v.getMeslek())) {
				agac.yasaGoreAgacaEkle(v);
			}
		}
		
		BreadthFirstSearchTerseDon(kok);
	}
	
	private static void BFSAyniIsim(Kisi kok, BinaryTree agac) {
		LinkedListJ<Kisi> sira = new LinkedListJ<Kisi>();
		kok.durum = 1;
		sira.oneEkle(kok);
		while(!sira.bosMu()) {
			Kisi v = sira.arkadanCikar();
			
			for(Kisi k: v.getCocuklar()) {
				if(k.durum == 0) {
					k.durum = 1;
					sira.oneEkle(k);
				}
			}

			if(kok.getAd().equals(v.getAd())) {
				agac.yasaGoreAgacaEkle(v);
			}
		}
		
		BreadthFirstSearchTerseDon(kok);
	}
	
	private static void ikiKisininYakinlik(Kisi bir, Kisi iki) {
		ArrayList<String> stringListesi = new ArrayList<String>();
		
		if(iki.BuyuklukAl() < bir.BuyuklukAl()) {
			Kisi tmp = iki;
			iki = bir;
			bir = tmp;
		}
		
		Kisi a = iki.getAnne();
		while(a != null) {
			
			if(a.getAnne() == null) {
				if(a.getCinsiyet().equals("Kadın")) {
					stringListesi.add("Annesi");
				}
				else {
					stringListesi.add("Babası");
				}
			}
			else {
				if(a.getCinsiyet().equals("Kadın")) {
					stringListesi.add("Annesinin");
				}
				else {
					stringListesi.add("Babasının");
				}
			}
			
			a = a.getAnne();
		}
		
		System.out.print(bir.getAd() + ", " + iki.getAd() + "'nın ");
		for(String s: stringListesi) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	private static int BFSMaxDerinlik(Kisi kok) {
		LinkedListJ<Kisi> sira = new LinkedListJ<Kisi>();
		kok.durum = 1;
		sira.oneEkle(kok);
		sira.oneEkle(null);
		int derinlik = 0;
		
		while(!sira.bosMu()) {
			Kisi v = sira.arkadanCikar();
			
			if(v == null) {
				if(!sira.bosMu()) {
					sira.oneEkle(null);
				}
				derinlik++;
			}
			else {

				for(Kisi k: v.getCocuklar()) {
					if(k.durum == 0) {
						k.durum = 1;
						k.ebeveynEkle(v);
						sira.oneEkle(k);
					}
				}
			}

		}
		return derinlik;
	}
}

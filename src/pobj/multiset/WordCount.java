package pobj.multiset;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pobj.util.Chrono;

public class WordCount<T> {
	private MultiSet<T> ms;
	
	public WordCount(MultiSet<T> ms) {
		this.ms=ms;
	}
	
	
	public void wordcount(File file) throws FileNotFoundException { 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String line; 
		try {
			while ((line = br.readLine())!=null) { 
				for (String word : line.split("\\P{L}+")) { 
						if (word.equals("")) continue; // ignore les mots vides 
						else {
							ms.add((T) word);
						}
				} 
			}
			
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public void sort() {
		List<T> elements = ms.elements();
		
		Comparator<T> comparator = new Comparator<T>() {
            
			@Override
            public int compare(T o1, T o2) {
                return Integer.compare(ms.count(o2), ms.count(o1));
            }
        };
        
        Collections.sort(elements, comparator);
        
		for (int i =0; i<Math.min(10, elements.size()); i++) {
			T element = elements.get(i);
            System.out.println(element + " : " + ms.count(element));	
		}
	}
	
	
	public static void main(String[] args){
		MultiSet<String> hms = new HashMultiSet<>();
		WordCount<String> wc = new WordCount<>(hms);
		File file = new File("data/SmallTest.txt");
//		File file = new File("data/WarAndPeace.txt");
		
		try {
			wc.wordcount(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(hms);
	}
	
}
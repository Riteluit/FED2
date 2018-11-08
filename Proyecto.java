package proyecto;
import java.io.*;

public class Proyecto {
	static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));

	public static void main(String[] args) {
		try {
			String txt = ReadFromFile("/Users/elisa gomez/Desktop/Tweets.txt");
                        

		}catch (Exception ex) {
			
		}
	}
	public static void TopAutores(){
            
	} 
	
	public static void TopHashtag() {
            
	}
	
	public static void TopTagged() {
		
	}
	
	public static void TopWords(String [] tweet){
            
	}
	
	public static String ReadFromFile(String archivo)throws FileNotFoundException,IOException {
		String cadena;
        FileReader f = new FileReader("/Users/elisa gomez/Desktop/Tweets.txt");
        BufferedReader b = new BufferedReader(f);
			while((cadena = b.readLine())!=null) {
				String [] a=  cadena.split(("♠"));
				for (int i =0;i<a.length;i++) {
                                    bw.write(i+"- "+a[i]+"\n");
                                    bw.flush();
				}
                                String Nick = a[0];
                                String []tweet = a[1].split(" ");
                                String Ubica = a[2];
                                String hora = a[3];
                                
                                bw.write("Total de hashtag es de: "+ CounterHashtag(tweet)+"\n");
				bw.flush();
                                bw.write("Total de tageos es de: "+ CounterTagged(tweet)+"\n");
				bw.flush();
                                bw.write("Total de otras palabras es de: "+ CounterWords(tweet)+"\n"+"\n");
				bw.flush();
                                TopWords(tweet);
				
			}
			
		b.close();
		return null;
    }
	public static void CounterAutor(String array[]) {
					
		int count = 0;
		
		for (int i=0;i<array.length;i++) {
			String a = array[0];
			if (array[0].contains(a)){
				count += 1;
			}else { 	
				count += 0;
			}
		}
		System.out.println(count);
	}
	public static int CounterHashtag(String array[]) {
		int has=0;
		for (int i =0;i<array.length;i++) {
			String c = array[i].substring(0);
			if(c.contains("#")){
				has++;
			}else {
				has += 0 ;
			}
		}
		return has;
	}
	public static int CounterTagged(String array[]) {
		int tag=0;
		for (int i =0;i<array.length;i++) {
			String c = array[i].substring(0);
			if(c.contains("@")){
				tag++;
			}else {
				tag += 0 ;
			}
		}
		return tag;
	}
	public static int CounterWords(String array[]) {
		int other=0;
		for (int i =0;i<array.length;i++) {
			String c = array[i].substring(0);
			if(!c.contains("@")&&!c.contains("#")){
				other++;
			}
		}
		return other;
	}
}

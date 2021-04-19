import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HanoiTowers {
	public static String INPUT_FILE_NAME = "data/HanoiInput.txt";
	public static String OUTPUT_FILE_NAME = "data/HanoiOutput.txt"; 
	public static int BEGINING = 0;
	public static int MIDDLE = 1;
	public static int END = 2;
		
	private static int problems;
	private static int disks;
	private static int[] codification = new int[3];
	
	public static void main(String[] args) throws IOException {
		inputNOutput();
		
	}
	
	public static void inputNOutput() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
		PrintWriter pw = new PrintWriter(OUTPUT_FILE_NAME);
		
		problems = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < problems; i++) {
			for (int j = 0; j < codification.length; j++) {
				codification[j] = 0;
			}
			
			disks = Integer.parseInt(br.readLine());
						
			//PARA PODER CREARLO ARRIBA Y NO TENER QUE PASARLO COMO PARAMETRO.
			for (int j = 0; j < codification.length; j++) {
				if(j == 0) {
					codification[j] = disks;
				}else {
					codification[j] = 0;
				}
			}
			//FIN DEL FOR INTERNO.
		
			String strAux = disks + " " + codification[1] + " " + codification[2] + "\n";
			
			pw.write(strAux);
			hanoiTowers(disks,BEGINING,END,MIDDLE,pw);
			
			pw.write("\n");
			
		}
		
		br.close();
		pw.close();
	}
	
	public static void hanoiTowers(int n,int begining, int end, int middle, PrintWriter aux) throws FileNotFoundException {
		
		if(n == 1) {
			codification[begining]--;
			codification[end]++;
		
			String strAux = codification[0] + " " + codification[1] + " " + codification[2] + "\n";
			
			aux.write(strAux);
			
		}
		else {
			hanoiTowers(n-1,begining, middle, end,aux);
			
			codification[begining]--;
			codification[end]++;
					
			String strAux = codification[0] + " " + codification[1] + " " + codification[2] + "\n";
			
			aux.write(strAux);
			hanoiTowers(n-1,middle, end, begining,aux);
		}

	}
}

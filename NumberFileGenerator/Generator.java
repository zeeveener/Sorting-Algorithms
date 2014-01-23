import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Generator {
	public static void main(String[] args){
		int values=100, max=1000;
loop:	for(int i = 0; i < args.length; i++){
test:		switch(i){
			case 0:
				values = Integer.parseInt(args[i]);
				break test;
			case 1:
				max = Integer.parseInt(args[i]);
				break test;
			default:
				break loop;
			}
		}
		
		File file = new File("nums.txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw, 1024);
			Random r = new Random();
			for(int i = 0; i < values; i++){
				bw.append(" " + r.nextInt(max));
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

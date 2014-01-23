import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BubbleSort {

	public static void main(String[] args){
		if(args.length == 0 || !args[0].endsWith(".txt")){
			System.err.println("Use a file of space separated integers for the input.");
			return;
		}
		int comps=0, moves=0;
		long start = System.currentTimeMillis();
		BufferedReader br;
		ArrayList<String> input = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(new File(args[0])));
			String line;
			String[] tempArr;
			while((line = br.readLine()) != null){
				tempArr = line.split(" ");
				for(String s : tempArr) input.add(s);
				tempArr = null;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Input Size: " + input.size());
		for(String s : input) System.out.print(s + " ");
		System.out.println();
		
		/*
		 * Start Bubble Sort
		 */
		for(int i = 0; i < input.size()-1; i++){
			int count = 0;
			for(int j = 0; j < input.size()-1; j++){
				int a = Integer.parseInt(input.get(j));
				int b = Integer.parseInt(input.get(j+1));
				comps++;
				if(a > b){
					count++;
					moves++;
					System.out.println(moves + ": Switching " + a + " and " + b);
					int temp = a;
					input.set(j, String.valueOf(b));
					input.set(j+1, String.valueOf(temp));
				}
			}
			if(count == 0) break;
		}
		/*
		 * End Bubble Sort
		 */
		
		System.out.println("Checks: " + comps + "\tMoves: " + moves + "\tTime Elapsed: " + ((System.currentTimeMillis()-start)/1000) + "s");
		for(String s : input) System.out.print(s + " ");
		System.out.println();
	}
}

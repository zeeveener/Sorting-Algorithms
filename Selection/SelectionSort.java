import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SelectionSort {
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
		 * Start Selection Sort
		 */
		for(int i = 0; i < input.size()-1; i++){
			int index = i;
			for(int j = i+1; j < input.size(); j++){
				comps++;
				if(Integer.parseInt(input.get(j)) < Integer.parseInt(input.get(index))){
					index = j;
				}
			}
			moves++;
			System.out.println(moves + ": Switching " + input.get(i) + " and " + input.get(index));
			String temp = input.get(i);
			input.set(i, input.get(index));
			input.set(index, temp);
		}
		/*
		 * End Selection Sort
		 */
		
		
		System.out.println("Checks: " + comps + "\tMoves: " + moves + "\tTime Elapsed: " + ((System.currentTimeMillis()-start)) + "ms");
		for(String s : input) System.out.print(s + " ");
		System.out.println();
	}
}

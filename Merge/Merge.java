import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Merge {

	private static int comps=0, moves=0;
	
	public static void main(String[] args){
		if(args.length == 0 || !args[0].endsWith(".txt")){
			System.err.println("Use a file of space separated integers for the input.");
			return;
		}
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
		
		int[] a = new int[input.size()];
		for(int i = 0; i < a.length; i++){
			try {
				a[i] = Integer.parseInt(input.get(i));
			} catch (NumberFormatException e) {}
		}
		
		long start = System.currentTimeMillis();
		
		mergeSort(a);
		
		System.out.println("Checks: " + comps + "\tMoves: " + moves + "\tTime Elapsed: " + ((System.currentTimeMillis()-start)) + "ms");
		for(int s : a) System.out.print(s + " ");
		System.out.println();
	}
	
	private static void mergeSort(int[] x){
		if(x.length > 1){
			int mid = x.length/2;
			
			int[] a = Arrays.copyOfRange(x, 0, mid); //Left half of array x
			int[] b = Arrays.copyOfRange(x, mid, x.length); // Right half of array x
			
			mergeSort(a); //Sort the left half first
			mergeSort(b); //Then sort the right half
			
			mergeArrays(x, a, b); //Merge the two halves back into x
		}
	}
	
	private static void mergeArrays(int[] x, int[] l, int[] r){
		int total = l.length + r.length;
		int li = 0, ri = 0, i = 0;
		while(i < total){ //For the number of elements present
			if(li < l.length && ri < r.length){
				comps++;
				moves++;
				if(l[li] < r[ri]){ //If left value is smaller, move it into place
					x[i++] = l[li++];
				}else{ //Otherwise, move the right value into place
					x[i++] = r[ri++];
				}
			}else{
				if(li >= l.length){ //If we have used up all the left values, move the rest of the right values into place
					while(ri < r.length){
						moves++;
						x[i++] = r[ri++];
					}
				}
				if(ri >= r.length){ //If we have used up all the right values, move the rest of the left values into place
					while(li < l.length){
						moves++;
						x[i++] = l[li++];
					}
				}
			}
		}
	}
}

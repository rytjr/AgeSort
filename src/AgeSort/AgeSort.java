package AgeSort;

import java.util.*;


/*온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 
 * 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.*/
import java.io.*;

public class AgeSort {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int Num = Integer.parseInt(bf.readLine());
		
		String[][] arr = new String[Num][2];
		
		for(int i = 0; i < Num; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		mergeSort(arr, 0, Num-1);
		
		for(int i = 0; i < Num; i++) {
			for(int j = 0; j < 2; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}
	
	public static void mergeSort(String[][] arr, int left, int right) {
		
		
		if(left < right) {
			int middle = (left + right) / 2;
			
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			
			merge(arr, left, middle, right);
		}
	}
	
	public static void merge(String[][] arr, int left, int middle, int right) {
		
		
		int n1 = middle - left + 1;
		int n2 = right - middle;
		
		String[][] arrleft = new String[n1][2];
		String[][] arrright = new String[n2][2];
		
		
		
		for(int i = 0; i < n1; i++) {
			for(int j = 0; j < 2; j++) {
				arrleft[i][j] = arr[i + left][j];
			}
		}
		
		for(int i = 0; i < n2; i++) {
			for(int j = 0; j < 2; j++) {
				arrright[i][j] = arr[i + middle + 1][j];
			}
		}
		
		int i = 0; int j = 0; int k = left;
		
		while(i < n1 && j < n2) {
			//병합정렬이 중심을 기준으로 정렬하며 배열을 나누는 것으로 알고 있는데 이런식으로 하면 나이가 같을 경우 원래 배열의
		    //이름이 먼저 나온 순서인데 이게 왜 되는지 정확하게는 모르겠음
			if(Integer.parseInt(arrleft[i][0]) <= Integer.parseInt(arrright[j][0])) {
				arr[k][0] = arrleft[i][0];
				arr[k][1] = arrleft[i][1];
				i++;
			}
			else if(Integer.parseInt(arrleft[i][0]) > Integer.parseInt(arrright[j][0])) {
				arr[k][0] = arrright[j][0];
				arr[k][1] = arrright[j][1];
				j++;
			}
			else {
				
			}
			k++;
		}
		//여기 안써서 값이 다르게 나온거였음 주의해야 할듯
		while(i < n1) {
			arr[k][0] = arrleft[i][0];
			arr[k][1] = arrleft[i][1];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k][0] = arrright[j][0];
			arr[k][1] = arrright[j][1];
			j++;
			k++;
		}
	}
	
	//아래는 배열을 클래스로 만들어 정렬해본 것
	/*public static class Person {
		int age;
		String name;
        
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
        
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int Num = Integer.parseInt(bf.readLine());
		
		Person[] arr = new Person[Num];
		
		for(int i = 0; i < Num; i++) {
			st = new StringTokenizer(bf.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			arr[i] = new Person(age, name);
		}
		
		mergeSort(arr, 0, Num-1);
		
		for(int i = 0; i < Num; i++) {
			bw.write(arr[i] + "");
		}
		bw.flush();
		bw.close();
		
	}
	
	public static void mergeSort(Person[] arr, int left, int right) {
		
		
		if(left < right) {
			int middle = (left + right) / 2;
			
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			
			merge(arr, left, middle, right);
		}
	}
	
	public static void merge(Person[] arr, int left, int middle, int right) {
		
		
		int n1 = middle - left + 1;
		int n2 = right - middle;
		
		Person[] arrleft = new Person[n1];
		Person[] arrright = new Person[n2];
		
		
		
		for(int i = 0; i < n1; i++) {
				arrleft[i] = arr[i + left];
			
		}
		
		for(int i = 0; i < n2; i++) {
				arrright[i] = arr[i + middle + 1];
			
		}
		
		int i = 0; int j = 0; int k = left;
		
		 while (i < n1 && j < n2) {
		        // 정렬 기준은 나이(age)입니다.
		        if (arrleft[i].age <= arrright[j].age) {
		            arr[k] = arrleft[i];
		            i++;
		        } else {
		            arr[k] = arrright[j];
		            j++;
		        }
		        k++;
		    }

		    while (i < n1) {
		        arr[k] = arrleft[i];
		        i++;
		        k++;
		    }

		    while (j < n2) {
		        arr[k] = arrright[j];
		        j++;
		        k++;
		    }
	}
	*/

}

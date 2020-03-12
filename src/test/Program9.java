package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program9 {

	private static int[] IntArray;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("Please input an integer array, and use a comma as the separation mark");
		try {
			while ((str = br.readLine()) != null) {
				String[] StringArray = str.split(",");
				IntArray = new int[StringArray.length];
				for (int i = 0; i < StringArray.length; i++)
					IntArray[i] = Integer.parseInt(StringArray[i]);
				ArrayList<String> newList = getStringList(StringArray.length - 1);
				for (String list : newList)
					System.out.print(list + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<String> getStringList(int index) {
		ArrayList<String> sal = new ArrayList<String>();
		String str;
		if (index == 0) {
			if (IntArray[0] != 0 && IntArray[0] != 1) {
				int length = getNumLetterLength(IntArray[0]);
				int asc = getIniLetterAsc(IntArray[0]);
				for (int i = 0; i < length; i++) {
					str = String.valueOf((char) (asc + i));
					sal.add(str);
				}
			}
			return sal;
		} else {
			ArrayList<String> oldList = getStringList(index - 1);
			if (IntArray[index] == 0 || IntArray[index] == 1)
				return oldList;
			else {
				if (oldList.size() == 0) {
					if (IntArray[index] != 0 && IntArray[index] != 1) {
						int length = getNumLetterLength(IntArray[index]);
						int asc = getIniLetterAsc(IntArray[index]);
						for (int i = 0; i < length; i++) {
							str = String.valueOf((char) (asc + i));
							sal.add(str);
						}
					}
				} else {
					int length = getNumLetterLength(IntArray[index]);
					int asc = getIniLetterAsc(IntArray[index]);
					for (int i = 0; i < oldList.size(); i++) {
						str = oldList.get(i);
						for (int j = 0; j < length; j++)
							sal.add(str + String.valueOf((char) (asc + j)));
					}
				}
				return sal;
			}

		}
	}

	public static int getIniLetterAsc(int number) {
		if (number == 2)
			return 97;
		return getIniLetterAsc(number - 1) + getNumLetterLength(number - 1);
	}

	public static int getNumLetterLength(int number) {
		if (number >= 2 && number <= 6 || number == 8)
			return 3;
		if (number == 7 || number == 9)
			return 4;
		return 0;
	}

}

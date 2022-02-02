package com.gl.driver;

import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the total no of floors in the building: ");
		int noOfFloors = scanner.nextInt();
		if (noOfFloors > 0) {
			int[] floors = new int[noOfFloors];
			for (int i = 0; i < noOfFloors; i++) {
				System.out.print("Enter the floor size given on day " + (i + 1) + ": ");
				floors[i] = scanner.nextInt();
			}
			buildFloors(noOfFloors, floors);
		} else {
			System.out.println("Invalid number of floors");
		}
		scanner.close();
	}

	public static void buildFloors(int noOfFloors, int[] floors) {

		Stack<Integer> stack = new Stack<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		int[] tempArray = new int[noOfFloors];
		System.arraycopy(floors, 0, tempArray, 0, noOfFloors);
		Arrays.sort(tempArray);

		for (int i = 0, j = (noOfFloors - 1); i < noOfFloors; i++, j--) {
			System.out.println("Pushing element - " + tempArray[i]);
			stack.push(tempArray[i]);
			linkedList.add(tempArray[j]);
		}

		display(linkedList);
		System.out.println("\n-------------------------------------------\nThe order of construction is as follows");

		for (int i = 0; i < noOfFloors; i++) {
			int j = 0;
			boolean floorBuilt = false;
			System.out.print("Day " + (i + 1) + ": ");
			if (i != (noOfFloors - 1)) {
				if (linkedList.get(j) == floors[i]) {
					System.out.print(linkedList.remove(i));
					floorBuilt = true;
					System.out.println();
					//display(linkedList);
				}
				else {
					linkedList.add(linkedList.remove(i));
				}
			} else {
				while (linkedList.size() > 0) {
					j = 0;
					floorBuilt = true;
					System.out.print(linkedList.remove(j) + " ");
				}
			}

//			if (!floorBuilt) {
//				j = 0;
//				while (linkedList.size() > 0 &&  (linkedList.get(j) >= floors[i])) {
//					System.out.print(linkedList.remove(j) + " ");
//				}
//			}

			System.out.println();
		}
	}

	private static void display(LinkedList<Integer> ll) {
		for (int i = 0; i < ll.size(); i++) {
			System.out.print(ll.get(i) + " ");
		}
		System.out.println();
	}

}

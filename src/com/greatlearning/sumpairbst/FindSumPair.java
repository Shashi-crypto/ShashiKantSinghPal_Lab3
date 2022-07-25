package com.greatlearning.sumpairbst;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindSumPair {
	
	static class Node{
		int nodeData;
		Node leftNode, rightNode;
	};
	
	static Node newNode(int nodedata) {
		Node temp = new Node();
		temp.nodeData = nodedata;
		temp.leftNode= null;
		temp.rightNode= null;
		return temp;
		
	}
	
	private Node insert(Node root, int key) {
		if(root == null)
			return newNode(key);
		if(key<root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}
	//Driver code
	public static void main(String[] args) {
		
		Node root = null;
		
		FindSumPair findSP = new FindSumPair();
		root = findSP.insert(root, 40);
		root = findSP.insert(root, 20);
		root = findSP.insert(root, 60);
		root = findSP.insert(root, 10);
		root = findSP.insert(root, 30);
		root = findSP.insert(root, 50);
		root = findSP.insert(root, 70);
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Please input the Sum for which node pair needs to be find");
		
		int sum = sc.nextInt();
		findSP.findPairWithGivenSum(root,sum);
		sc.close();

	}

	private void findPairWithGivenSum(Node root, int sum) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		if(!findpaiUtil(root,sum,set)) {
			System.out.println("Nodes are not found");
		}
		
	}

	private boolean findpaiUtil(Node root, int sum, Set<Integer> set) {
		
		if(root == null)
			return false;
		
		//left
		if(findpaiUtil(root.leftNode,sum,set))
			return true;
		
		//node
		if(set.contains(sum-root.nodeData)) {
			System.out.println("Node Pair for given sum is ("+ (sum-root.nodeData)+","+root.nodeData+")");
			return true;
		}else {
			set.add(root.nodeData);
		}
		
		//Right
		return findpaiUtil(root.rightNode, sum, set);		
	}

}

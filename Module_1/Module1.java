package Graphs;

import java.util.Arrays;
import java.util.Scanner;

class Matrix
{
	int a[][];
	int n ,n1;
	Matrix(int n,int n1)
	{
		this.n=n;
		this.n1=n1;
		 a = new int[n][n1];
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<n1;j++)
			 {
				 a[i][j]=0;
			 }
		 }
	}
	void insert(int n,int n1)
	{
		a[n][n1]=1;
		a[n1][n]=1;
	}
	void display()
	{
		for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<n1;j++)
			 {
				 System.out.print(a[i][j]+" ");
			 }
			 System.out.println("");
		 }
	}
}
public class Module1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
		String str=sc.nextLine();
		int v= Integer.parseInt(sc.nextLine());
		int v1= Integer.parseInt(sc.nextLine()); 
		String state = sc.nextLine();
		String s[] = state.split(",");
		//System.out.println(Arrays.toString(s));
		switch(str)
		{
			case "Matrix":
			{
				Matrix ma =new Matrix(v,v1);
				for(int i=0;i<13;i++)
				{
					String m = sc.nextLine();
					String m1[] = m.split(" ");
					ma.insert(Integer.parseInt(m1[0]),Integer.parseInt(m1[1]));	
			    }
				ma.display();
				break;
			}
			case "List":
			{
				
				break;
			}
		}
	}

}

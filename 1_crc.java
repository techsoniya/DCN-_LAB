import java.util.*;
public class crc{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int n;
		System.out.println("Enter the size of the data");
		n=s.nextInt();
		int data[]=new int[n];
		System.out.println("enter the data bit by bit:");
		for(int i=0;i<n;i++){
			data[i]=s.nextInt();
			}
		System.out.println("enter the size of the devisor:");
		n=s.nextInt();
		int devisor[]=new int[n];
		System.out.println("enter the devisor bit by bit:");
		for(int i=0;i<n;i++)
			devisor[i]=s.nextInt();
		int remainder[]=devide(data,devisor);
		System.out.println("\n crc code generated is:");
		for(int i=0;i<data.length;i++)
			System.out.print(data[i]);
		for(int i=0;i<remainder.length-1;i++)
			System.out.print(remainder[i]);
		System.out.println();
		
		int sent_data[]=new int[data.length+remainder.length-1];
		System.out.println("enter the data to b sent:");
		for(int i=0;i<sent_data.length;i++)
			sent_data[i]=s.nextInt();
		recieve(sent_data,devisor);
		}
	static int[] devide(int old_data[],int devisor[]){
		int remainder[],i;
		int data[]=new int[old_data.length+devisor.length];
		System.arraycopy(old_data,0,data,0,old_data.length);
		System.out.println("messege bits after appending devisor-length-1 0's:");
		for(i=0;i<data.length-1;i++)
			System.out.println(data[i]);
			remainder=new int[devisor.length];
			System.arraycopy(data,0,remainder,0,devisor.length);
			for(i=0;i<old_data.length;i++){
				if(remainder[0]==1){
					for(int j=1;j<devisor.length;j++){
						remainder[j-1]=exor(remainder[j],devisor[j]);
						}
					}
				else{
				for(int j=1;j<devisor.length;j++)
					remainder[j-1]=exor(remainder[j],0);
				}
				remainder[devisor.length-1]=data[i+devisor.length];
			}
			return remainder;
		}
		
	static int exor(int a,int b){
		if (a==b)
			return 0;
		return 1;
	}
	
	static void recieve(int data[],int devisor[]){
	int remainder[]=devide(data,devisor);
	for(int i=0;i<remainder.length;i++){
		if(remainder[i]!=0){
			System.out.println("There is an error in recieved data....");
			return;
			}
		}
		System.out.println("data was recieved without any errors");
	}
}			
	

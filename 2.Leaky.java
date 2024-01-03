import java.math.*;
import java.util.*;
import java.util.Random;
import java.io.*;
import java.lang.*;
public class leakyy{
public static void main(String args[]){
int drop=0,mini,i,o_rate,b_size,nsec,p_remain=0;
int packet[]=new int[100];
Scanner in=new Scanner(System.in);
System.out.print("enter the bucket size");
b_size=in.nextInt();
System.out.print("enter the output rate");
o_rate=in.nextInt();
System.out.println("enter the number of seconds to stimulate");
nsec=in.nextInt();
Random rand=new Random();
for(i=0;i<nsec;i++)
packet[i]=(rand.nextInt(100));
System.out.println("seconds  packet received  packet sent   packet left  packet dropped");
System.out.println("--------------------------------------");
for(i=0;i<nsec;i++){
p_remain+=packet[i];
if(p_remain>b_size){
drop=p_remain-b_size;
p_remain=b_size;
System.out.print(i+1+"\t  ");
System.out.print(packet[i]+"  ");
mini=Math.min(p_remain,o_rate);
System.out.print(mini+"\t ");
p_remain=p_remain-mini;
System.out.print(p_remain+"\t  ");
System.out.print(drop+"\t  ");
System.out.println("\t  ");
drop=0;			
}
}
while(p_remain!=0){
if(p_remain>b_size){
drop=p_remain-b_size;
}
mini=Math.min(p_remain,o_rate);
System.out.print(" "+p_remain+ "\t  "+mini);
p_remain=p_remain-mini;
System.out.println(" "+p_remain+ "\t   "+drop);
drop=0;	
}
}
}


package acciones;
import java.io.*;

public class Acciones {
    
    static BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
    static BufferedWriter wr= new BufferedWriter (new OutputStreamWriter(System.out));
   
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            wr.write("Con cuantas acciones va operar");
            String v= br.readLine();
            int v2= Integer.parseInt(v);
            wr.write("Cantidad de semanas: ");
            wr.flush();
            String n= br.readLine();
            int n2= Integer.parseInt(n);
            int compra=0;
            int venta=0;
            
            int[][] week= new int [n2][6];
            for(int i=0;i<n2;i++){
                wr.write("Valores de los 6 dias de la semana "+(i+1)+" Separados por espacios "+"\n");
                wr.flush();
                week[i]= leerconsola();
                
                compra+=acciones(week[i],2);
                venta+=acciones(week[i],1);
                
            }
            wr.write(" Total ventas: "+(v2*venta));
            wr.flush();
            wr.write(" Total compras: "+(v2*compra));
            wr.flush();
            wr.write("Ganacias de: "+(compra-venta));
            wr.flush();
            
        }catch(Exception ex ){
            
        }
        
        
    } 
    public static int[] leerconsola() throws IOException{
        String [] number = br.readLine().split(" ");
        int[] a=new int[number.length];
            for(int i=0;i<number.length;i++){
                a[i]=Integer.parseInt(number[i]);
            }
            return a;
    }
    
    public static int acciones(int a[],int z){
        int dif2= -2147483648;
        int com=0;
        int vent=0;
        int com2=0;
        int vent2=0;
        
        for(int i=0;i<6;i++){
            int dif=0;
            com2=a[i];
            for(int j=i+1;j<6;j++){
                vent2=a[j];
                dif= vent2-com2;
                if(dif2<dif){
                    dif2=dif;
                    com=a[i];
                    vent=a[j];
                }
            }
        }
    
        if(z==1){
            return com;
        }
        if(z==2){
            return vent;
        }
        System.out.println(com+" y la venta es de "+vent+" : "+dif2);
        
        return dif2;
        
    }
    
    public static void imprimir(int array[]){
        
                for(int i=0;i<array.length;i++){
                System.out.println("["+array[i]+"]");
                
                }
            }
                
    }
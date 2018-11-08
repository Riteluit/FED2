package mochila;
import java.io.*;

public class Mochila {
        static BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
        static BufferedWriter wr= new BufferedWriter (new OutputStreamWriter(System.out));
        static int precio [];
        static int volumen [];
        static int tam;
        
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
      try{
          int a=0;
            do{
                wr.write("\n\nSelecione\n1.Mochila Gredy\n2.Mochila Optima\n3.Salir\nSu respuesta:");
                wr.flush();
                 a=Integer.parseInt(br.readLine());
                switch(a){
                    case 1:
                        gredy();
                        break;
                    case 2:
                        optima();
                        break;
                    case 3:
                        wr.write("\nGracias");
                        wr.flush();
                        break;
                }
            }while(a!=3);
        
      }catch(Exception ex){
			ex.printStackTrace();
		}  
    } 
   public static void optima(){
       try{
                wr.write("\nEl numero de elementos: ");
                wr.flush();
                tam=Integer.parseInt(br.readLine());
        
                precio = new int[tam];
                volumen =new int [tam];
                LeerVolumenYPrecio(precio,volumen);
                wr.write("\nEl volumen de la mochila es de:\n ");
                wr.flush();
                int mochila=Integer.parseInt(br.readLine());
                int mochilafinal[]=new int[tam];
                int solucion[]=new int[tam];
                int a=0; int b=0;int c=0;
                mochilaR(solucion,precio,volumen,mochilafinal,a,b,c,mochila);
        
                wr.write("\n La mejor combinacion es (1 se toma el elemento,cuando es 0 no se toma el elemnto):");
                wr.flush();
                imprimir(mochilafinal);
                resultado(mochilafinal,precio,volumen,0,0);
            }catch(Exception ex){
			ex.printStackTrace();
	}
   }
    public static void gredy(){
           
            try{
                    wr.write("El numero de elementos: ");
                    wr.flush();
                    tam=Integer.parseInt(br.readLine());

                    precio = new int[tam];
                    volumen =new int [tam];
        
                    LeerVolumenYPrecio(precio,volumen);
   
                     bubble(precio,volumen);
       
                    wr.write("\nEl volumen de la mochila es de:\n ");
                    wr.flush();
                    int mochila=Integer.parseInt(br.readLine());
        
                    suma(precio,volumen,mochila);
                    wr.flush();
                }
		catch(Exception ex){
			ex.printStackTrace();
		}
    }
    public static void imprimir(int array[]) {
         try{
                for(int i=0;i<array.length;i++){
                wr.write("["+array[i]+"]");
                wr.flush();
                }
            }
                catch(Exception ex){
			ex.printStackTrace();
		}
    }   
    public static void LeerVolumenYPrecio(int array[],int array2[]){
          try{
                for(int i=0;i<array.length;i++){
                wr.write("Valor del elemento "+(i+1)+"\n");
                wr.flush();
                array[i]=Integer.parseInt(br.readLine());
                wr.write("Volumen del elemento "+(i+1)+"\n");
                wr.flush();
                array2[i]=Integer.parseInt(br.readLine());
                }
             }
		catch(Exception ex){
			ex.printStackTrace();
		}
}
    public static void suma(int array[],int array2[], int pesomochila){
        try{
                int peso=0;
                int i=0;
                int beneficio=0;
                while(peso<pesomochila && i<array.length){
                    if(peso+array2[i]<=pesomochila){
                        peso= peso+array2[i];
                        beneficio= beneficio+array[i];
                    }
                    i++;
                }
                wr.write("\nEl beneficio es de:"+beneficio+" El volumen de la mochila era: "+pesomochila+" El volumen que se ocupo fue de: "+peso);
                wr.flush();
            }
		catch(Exception ex){
			ex.printStackTrace();
		}
    }
    public static void bubble(int array[],int array2[]){
                
                    for (int i=0;i<array.length-1;i++){
           
                     int s=0;
                     int s2=0;
                        for(int j=0;j<array.length-1;j++){
                            if (array[j]<array[j+1]){
                                s=array[j];
                                s2=array2[j];
                                array[j]=array[j+1];
                                array2[j]=array2[j+1];
                                array[j+1]=s;
                                array2[j+1]=s2;
                            }
                        }
                    }   
    }
    public static void resultado(int array1[],int array[],int array2[],int beneficio,int volumen){
            try{
                    for(int i=0;i<array1.length;i++){
                        if(array1[i]==1){
                            beneficio+= array[i];
                            volumen+=array2[i];
                        }   
                    }
                    wr.write("\nEl mejor beneficio es de: "+beneficio+" Utilizando un volumen de: "+volumen);
                    wr.flush();
                }
		catch(Exception ex){
			ex.printStackTrace();
		}
     }
    public static void actualizar(int solucion[],int array[],int array2[], int mochilafinal[],int b,int c,int mochila){
                int b2=0;
                int c2=0;
                for(int i=0;i<array.length;i++){
                    if(solucion[i]==1){
                        b2+=array[i];
                        c2+=array2[i];
                     }
                }
                if(b2>b){
                    for(int i=0;i<array.length;i++){
                        if(c2<=mochila){
                            mochilafinal[i]= solucion[i];
                            b= b2;
                            c= c2;
                        }
                    }
                }
     }
    public static void mochilaR(int solucion[],int array[],int array2[],int mochilafinal[],int a,int b,int c,int mochila){
                int i=0;
                do{
                    solucion[a]=i;
                    if(c<=mochila){
                        if(a==array.length-1){
                            actualizar(solucion,array,array2,mochilafinal,b,c,mochila);  
                        }else
                            mochilaR(solucion,array,array2,mochilafinal,a+1,b,c,mochila);
                        }
                    i++;
                  }while(solucion[a]!=1);
                solucion[a]=-1;
     }
}

   

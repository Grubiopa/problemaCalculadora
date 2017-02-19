/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemacalculadora2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class ProblemaCalculadora2 {

        /**
     * @param args the command line arguments
     */
    static int numeroSolucionesMinimas;
    private static int[] duplicates = new int [10000];
    private static Queue<Integer> queue = new LinkedList<Integer>();
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        numeroSolucionesMinimas = calcular1Solucion(a, b);
        //calcularMinimasSoluciones(a, b, -1);
        //numeroSolucionesMinimas = Integer.MAX_VALUE;
        planb(a,b,0);
        System.out.println(numeroSolucionesMinimas);
    }
    private static void planb(int start, int sol,int i)  throws IOException{
        int calc;
        queue.add(start);
        queue.add(null);
        while (!queue.isEmpty()) {

            Integer s = queue.poll();

            duplicates[start] = 0;

            if (s == null) {

                i += 1;
                queue.add(null);

                continue;

            }

            if (s == sol) {
                numeroSolucionesMinimas=i;
                break;

            }
            if (i<numeroSolucionesMinimas){
                calc = (s + 1) % 10000;

                if (duplicates[calc] == 0) {

                        queue.add(calc);

                        duplicates[calc] = 1;

                }

                calc = (s * 2) % 10000;

                if (duplicates[calc] == 0) {

                        queue.add(calc);

                        duplicates[calc] = 1;

                }

                calc = (s / 3) % 10000;

                if (duplicates[calc] == 0) {

                        queue.add(calc);

                        duplicates[calc] = 1;

                }
            }else{
                break;
            }
        }
        
    }
    private static int calcular1Solucion(int aAux, int b){
        int numeroSolucion= 0;
        /*if(aAux==0){
            aAux++;
            numeroSolucion++;
        }*/
        if(b>aAux){
            while((aAux*2)%10000<=b &&  aAux!=0){
                aAux*=2;
                aAux= aAux%10000;
                numeroSolucion++;
            }
            numeroSolucion+= (b-aAux);
        }else{
            while((aAux/3)%10000>=b && aAux!=0){
                aAux/=3;
                aAux= aAux%10000;
                numeroSolucion++;
            }
            numeroSolucion+=(Math.abs(b-aAux));
        }
      return numeroSolucion;
    }
    
    /*  
    static int realizarOperacion(int a, int b, int opcion){
    
            switch (opcion){
                case 1: 
                    a/=3;
                    a = a % 10000;
                    break;
                case 2:
                    a*=2;
                     a = a % 10000;
                    break;
                default:
                    a++;
                    a = a % 10000;
                    break;
            }         
            return a;
    }     
       
    static void calcularMinimasSoluciones(int a, int b, int numeroSolucionesAcumuladas){
        numeroSolucionesAcumuladas++;
      
        if(numeroSolucionesAcumuladas < numeroSolucionesMinimas){
            
                int valor = realizarOperacion(a, b, 1);
                if (duplicates[valor] == 0) {
                    duplicates[valor] = 1;
                    calcularMinimasSoluciones(valor, b, numeroSolucionesAcumuladas);
                    duplicates[valor] = 0;
                }
                
                valor = realizarOperacion(a, b, 2);
                if (duplicates[valor] == 0) {
                     duplicates[valor] = 1;
                    calcularMinimasSoluciones(valor, b, numeroSolucionesAcumuladas);
                   duplicates[valor] = 0;
                }
                
                valor = realizarOperacion(a, b, 3);
                if (duplicates[valor] == 0) {
                    duplicates[valor] = 1;
                    calcularMinimasSoluciones(valor, b, numeroSolucionesAcumuladas);
                    duplicates[valor] = 0;
                }
                             
        }
        
        if(a==b){
            numeroSolucionesMinimas = (numeroSolucionesAcumuladas < numeroSolucionesMinimas)?numeroSolucionesAcumuladas:numeroSolucionesMinimas;
        }
    } */
    
    
}


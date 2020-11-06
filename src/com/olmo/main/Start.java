package com.olmo.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Start {
	
	public static void main(String[] args) {
		Start s=new Start();
		
      s.ejecutarProcesoComplejo();

    }
	ProcessBuilder pb = new ProcessBuilder();
    BufferedReader br ;
    String str;
    int exitCode;
    
    public void ejecutar1ProcesoRuntime()  {
    	try {
            // create a process and execute notepad.exe
            Process process = Runtime.getRuntime().exec("notepad.exe");
        
         } catch (Exception ex) {
            ex.printStackTrace();
         }
    	
      }
    
    public void ejecutarProceso()  {
    	
    	pb.command("explorer.exe");
    	try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    
	
	
	public void elegirProceso() {
		

     
        Scanner sc = new Scanner(System.in);
        int eleccion = 0;
        
        System.out.println("Elige el proceso a ejecutar, 1 para Notepad, 2 para Explorer, 3 para WordPad");
        eleccion=sc.nextInt();
        
        switch(eleccion) {
        case 1:
        	pb.command("notepad.exe");
        	break;
        case 2:
        	pb.command("explorer.exe" );
        	break;
        case 3:
        	pb.command("write.exe");
        	break;
        	default:
        	System.out.println("número incorrecto");
        	break;
        }
        
        try {
			Process p= pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        
	}
	
	public void ejecutarVarios() {
		Process p;
		
		pb.command("notepad.exe");
		
		try {
			p=pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pb.command("explorer.exe");
		
		try {
			p=pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
public void ejecutarProcesoComplejo() {
		

        /* Ejecuta el  cmd, /c = acabar el proceso despuedes de esta ejecucion
         * dir = comando que uso 
         * */
        pb.command("cmd.exe", "/c", "dir");
       
       

        try {

            Process process = pb.start();

                     
            /*Buffered reader para leer el output del proceso */
                  br=  new BufferedReader(new InputStreamReader(process.getInputStream()));

           
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

           exitCode = process.waitFor();
            System.out.println("\nCódigo de error : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
		
	}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Monica
 */
public class TestaArqTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File pasta = new File("D:\\Documents\\NetBeansProjects\\AS33J-2021\\src\\arquivos");
        File arq = new File(pasta,"TestaArqTexto.java"); // identificar arquivo

        FileReader arqTxt ;
        try {
            arqTxt = new FileReader(arq); // abrindo arquivo
            BufferedReader arquivo = new BufferedReader(arqTxt);
            String linha;
            while((linha = arquivo.readLine())!= null){
                System.out.println(linha);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo "+arq+"não encontrado");
        } catch(EOFException e ){
            System.out.println("Fim de arquivo!");
        } catch(IOException ex){
            System.out.println("Erro na leitura "+ex.getMessage());
        }
    }
    
}

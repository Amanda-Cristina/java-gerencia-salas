/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monica
 */
public class TestaArqObjeto {

    public static void main(String[] args) {

        try {
            ObjectOutputStream arq = new ObjectOutputStream(new FileOutputStream("arqPessoa.dad"));
            Pessoa pe = new Pessoa();
            pe.setCod(10);
            pe.setNome("Joao");
            pe.setSalario(1550.90);
            arq.writeObject(pe);
            
            pe = new Pessoa();
            pe.setCod(15);
            pe.setNome("Joao pedro");
            pe.setSalario(2550.90);
            arq.writeObject(pe);
            
            arq.close();

            ObjectInputStream arq2 = new ObjectInputStream(new FileInputStream("arqPessoa.dad"));
            Pessoa p2 = (Pessoa) arq2.readObject();
            System.out.println("Nome: " + p2.getNome());
            p2 = (Pessoa) arq2.readObject();
            System.out.println("Nome: " + p2.getNome());
            arq2.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro " + ex.getMessage());
        }

    }
}

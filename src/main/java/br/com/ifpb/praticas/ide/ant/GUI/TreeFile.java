/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifpb.praticas.ide.ant.GUI;

import java.io.File;

/**
 * Classe criada para que quando o arquivo seja exibido na tela apenas o seu 
 * nome apareça e não o caminho completo do arquivo, a única modificação é no 
 * método toString, que agora retorna apenas o nome do arquivo.
 * @author Rafael
 */
class TreeFile extends File{

   public TreeFile(File parent, String child) {
      super(parent, child);
    }

    public TreeFile(String path) {
        super(path);
    }
 
    public String toString() {
      return getName();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifpb.praticas.ide.ant.GUI;

import java.io.File;

/**
 *
 * @author Rafael
 */
class TreeFile extends File{

   public TreeFile(File parent, String child) {
      super(parent, child);
    }

    TreeFile(String path) {
        super(path);
    }
 
    public String toString() {
      return getName();
    }
}

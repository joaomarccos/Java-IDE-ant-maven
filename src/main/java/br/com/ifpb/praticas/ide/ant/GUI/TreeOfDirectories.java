/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ifpb.praticas.ide.ant.GUI;

import java.io.File;
import java.util.ArrayList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * @author João Marcos F 
 * @author Rafael
 */
public class TreeOfDirectories implements TreeModel{

    private TreeFile root;
    private ArrayList<TreeModelListener> list; 
    
    public TreeOfDirectories(String path) {
        this.root = new TreeFile(path);
        this.list = new ArrayList<>();
    }
    
    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
            TreeFile directory = (TreeFile) parent;
            String[] children = directory.list();
            return new TreeFile(directory, children[index]);
    }

    @Override
    public int getChildCount(Object parent) {
        TreeFile file = (TreeFile) parent;
        if (file.isDirectory()) {
        String[] fileList = file.list();
        if (fileList != null)
            return file.list().length;
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        TreeFile file = (TreeFile) node;
        return file.isFile();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        TreeFile directory = (TreeFile) parent;
        TreeFile file = (TreeFile) child;
        String[] children = directory.list();
        for (int i = 0; i < children.length; i++) {
            if (file.getName().equals(children[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        list.add(l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        list.remove(l);
    }
    
}

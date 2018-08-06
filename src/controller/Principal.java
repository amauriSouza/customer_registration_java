
package controller;

import view.JFCadastro;

public class Principal {
    
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFCadastro frmCadastro = new JFCadastro();
                frmCadastro.setVisible(true);
                frmCadastro.setLocationRelativeTo(null);
                
            }
        });
    }
    
}

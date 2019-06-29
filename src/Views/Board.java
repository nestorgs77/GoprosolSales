/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.GoprosolVentas;
import Controller.client;
import Controller.vendor;
import Validate.JustUpperCase;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
import org.jdesktop.swingx.JXDatePicker;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author NESTORPC
 */
public class Board extends javax.swing.JFrame {

    GoprosolVentas gop = new GoprosolVentas();
    ArrayList<client> listaClientes = new ArrayList<>();
    JDateChooser j;

    public ArrayList<client> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<client> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public JList getjList1() {
        return jList1;
    }

    public void setjList1(JList jList1) {
        this.jList1 = jList1;
    }

    /**
     * Creates new form Board
     */
    public Board() {

        initComponents();
        jTextArea1.setDocument(new JustUpperCase());
        jTextArea1.setLineWrap(true); 
    
        habilitarJDate();
        //GoprosolVentas gop = new GoprosolVentas();
        gop.refillCLient(this.jComboBox1);
        AutoCompleteDecorator.decorate(jComboBox1);
        gop.refillVendor(this.jComboBox2);
        AutoCompleteDecorator.decorate(jComboBox2);
        jList1.setVisible(false);
        // jComboBox1.setSelectedIndex(-1);
        // jTextField1.setDocument(new JustUpperCase());
        // jTextField2.setDocument(new JustUpperCase());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<client>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jComboBox2 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(854, 540));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("LAST ADDED");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(675, 102, 136, 57);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("VENDOR");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 50, 54, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DESCRIPTION");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 182, 87, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("CLIENT");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 281, 45, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText(" SALE ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(730, 0, 80, 57);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "VENDOR", "DATE INSERTED", "DESCRIPTION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(368, 168, 452, 88);

        jButton1.setText("ADD SALE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(700, 390, 107, 29);

        jComboBox1.setEditable(true);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(133, 276, 172, 26);

        jButton2.setText("MULTIPLE CLIENTS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(454, 275, 173, 29);

        jButton3.setText("NEW CLIENT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(314, 275, 125, 29);

        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(133, 322, 172, 69);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(130, 50, 172, 26);

        jButton4.setText("NEW VENDOR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(310, 50, 135, 29);

        jLabel4.setText("DATE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 100, 51, 20);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea1.setMaximumSize(new java.awt.Dimension(162, 92));
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(130, 150, 170, 94);

        jMenu2.setText("USER");
        jMenu2.setDelay(250);

        jMenuItem1.setText("ADD USER");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("DELETE USER");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("VENDOR");

        jMenuItem3.setText("EDIT VENDOR");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("DELETE VENDOR");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("CLIENT");

        jMenuItem5.setText("EDIT CLIENT");
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("DELETE CLIENT");
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("SEARCH");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public boolean validarCampos() {

        String data = jTextArea1.getText().trim();
        String s = ((JTextField) j.getDateEditor().getUiComponent()).getText();

        try {

            if (jComboBox2.getSelectedItem().toString().equals("ADD A VENDOR")) {
                JOptionPane.showMessageDialog(rootPane, "INSERT A VALID VENDOR ");
            } else if (jTextArea1.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "INSERT A VALID DESCRIPTION");
            } else if (s.equals("__/__/____")) {

                JOptionPane.showMessageDialog(rootPane, "INSERT A VALID DATE");

            } else if (jComboBox1.getSelectedItem().toString().equals("ADD A CLIENT")) {
                JOptionPane.showMessageDialog(rootPane, "INSERT A VALID CLIENT ");

            } else {
                if (jList1.getModel().getSize() > 0) {
                    listaClientes.add((client) jComboBox1.getSelectedItem());
                    for (int i = 0; i < jList1.getModel().getSize(); i++) {
                        listaClientes.add((client) jList1.getModel().getElementAt(i));

                    }

                } else {
                    listaClientes.add((client) jComboBox1.getSelectedItem());

                }

                gop.insertSales((vendor) jComboBox2.getSelectedItem(), j.getDate(), jTextArea1.getText(), listaClientes);
               
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "SOME FIELDS ARE INVALIDS");
        }

        return true;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(rootPane, gop.creatingPo(j.getDate(), (client) jComboBox1.getSelectedItem(), (vendor) jComboBox2.getSelectedItem(), jTextArea1.getText()));
        validarCampos();
        cleaningFields();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
       
    public void cleaningFields(){
     jComboBox1.setSelectedIndex(-1);
    jComboBox2.setSelectedIndex(-1);
     GregorianCalendar grego = new GregorianCalendar();
     j.setCalendar(grego);
     jTextArea1.setText("");
    jList1.removeAll();
    
    }
    
    private void habilitarJDate() {
        // FORMATING WITH THE MASK THE JDATECHOOSER 
        j = new JDateChooser("MM/dd/yyyy", "####/##/##", '_');

        j.setBounds(133, 100, 170, 30); // x y ancho alto
        GregorianCalendar grego = new GregorianCalendar();
        j.setCalendar(grego);

        add(j);
    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        NewClient n = new NewClient(this, rootPaneCheckingEnabled, jComboBox1);
        n.setModal(true);
        n.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        multiplesClient multClient = new multiplesClient(Board.this, true);
        multClient.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged


    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        newVendor vendor = new newVendor(this, rootPaneCheckingEnabled, jComboBox2);
        vendor.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JComboBox<client> jComboBox1;
    public javax.swing.JComboBox jComboBox2;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
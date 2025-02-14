
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author dhooo
 */
public class administrative extends javax.swing.JFrame {

    ArrayList<History> accounts;
    File file;
    ListIterator li;
    String IBAN; // IBAN of selected row in the table
    DefaultTableModel tbModel; // Defining an instance of the table to access the functionalities of it 
    History managerAccount;
            
    public administrative() {
        initComponents();    
    }
    
    public administrative(History sendData){ // using the sendData for eliminating the manager account of being shown in the table so it would be deleted or modified by mistake
        initComponents();
        accounts = new ArrayList<History>();
        file = new File("CustomerInfo.txt");
        managerAccount = sendData; // defining the current user's data into a local object in that jFrame
        ReadTheFile();
        setInfo(); // setting the accounts info into the table
    }
    
    public void SaveToFile(){
        
        if(file.isFile()){
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("CustomerInfo.txt")));
                //oos = new ObjectOutputStream(new FileOutputStream(new File("CustomerInfo.txt")));
            
                for(int i = 0; i < accounts.size(); i++){
                    oos.writeObject(accounts.get(i));
                }
                oos.close();
                    
                JOptionPane.showMessageDialog(null, "Saved Seccessfully" + accounts.size());
                //this.dispose(); // closing the file...
            } catch(IOException e){
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "File Does Not Exist");
        }
        
        
        
    }
    
    public void ReadTheFile(){
        if(file.isFile()){
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("CustomerInfo.txt")));
                
        
                boolean endOfFile = false;
                
                while (!endOfFile) {
                    try {
                        accounts.add((History) ois.readObject());
                    } catch (EOFException e) {
                        endOfFile = true;
                    } catch (IOException | ClassNotFoundException f) {
                        JOptionPane.showMessageDialog(null, f.getMessage());
                    }
                }
                
                ois.close();
                  
            } catch(IOException e){
                e.printStackTrace();
            }

        }else{
            JOptionPane.showMessageDialog(null, "File Does Not Exist");
        }
    }
    
    
    
    public void setInfo(){ // setting the accounts' info into the table 
        
        
        tbModel = (DefaultTableModel) tbAccounts.getModel(); 
        
        ListIterator li = accounts.listIterator();
        
        while(li.hasNext()){
           
            History h = (History) li.next();
            if(!h.getIBAN().equals(managerAccount.getIBAN())){ // making sure that manager account doesn't get showed on the table 
                // adding the objects one by one into the table
                tbModel.addRow(new String[] {h.getIBAN(), h.getEmail() , h.getName() , h.getSurname() , h.getPassword() ,String.valueOf(h.getAmount()) , h.getContact()});
            }
        }
        
    }
    
    public boolean isFieldEmpty(){ // checking if any textfield is empty
        
        if(tfEmail.getText().isEmpty() || tfName.getText().isEmpty() || tfSurname.getText().isEmpty() || tfPassword.getText().isEmpty() || tfCurrentAmount.getText().isEmpty()
                || tfContact.getText().isEmpty()){
            return true;
        }else{
            
            return false;
        }
    }
    
    public int hashCode(){ // for helping out the search method for defining the state of the existance of the user's email
        return this.tfEmail.getText().toLowerCase().trim().hashCode(); // we turned this one to lowercase so it wouldnt matter if the email is added by uppercase or lowercase
    }
    
    public boolean search(){ // chacking the existance of the user's email 
        boolean found = false;
        
        ListIterator li = accounts.listIterator();
        
        while(li.hasNext()){
            History h = (History) li.next();
            if(h.hasCode() == hashCode()){
                found = true;
            }
        }
        
        return found;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfSurname = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfCurrentAmount = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        tfContact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btNew = new javax.swing.JButton();
        btModify = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAccounts = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btSignOut = new javax.swing.JButton();
        btClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(63, 0, 113));
        jPanel2.setForeground(new java.awt.Color(49, 8, 123));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ABRBANK");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(432, 39, 128, 52);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kisspng-credit-card-card-security-code-computer-icons-paym-payment-5ac2099cb1d5a1.0033384515226658847284.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(346, 39, 80, 52);

        tfEmail.setBackground(new java.awt.Color(255, 255, 255));
        tfEmail.setForeground(new java.awt.Color(0, 0, 0));
        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });
        jPanel2.add(tfEmail);
        tfEmail.setBounds(130, 200, 200, 22);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Admin");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(130, 114, 56, 25);

        tfSurname.setBackground(new java.awt.Color(255, 255, 255));
        tfSurname.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(tfSurname);
        tfSurname.setBounds(130, 320, 200, 22);

        tfName.setBackground(new java.awt.Color(255, 255, 255));
        tfName.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(tfName);
        tfName.setBounds(130, 260, 200, 22);

        tfCurrentAmount.setBackground(new java.awt.Color(255, 255, 255));
        tfCurrentAmount.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(tfCurrentAmount);
        tfCurrentAmount.setBounds(430, 260, 200, 22);

        tfPassword.setBackground(new java.awt.Color(255, 255, 255));
        tfPassword.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(tfPassword);
        tfPassword.setBounds(432, 196, 200, 22);

        tfContact.setBackground(new java.awt.Color(255, 255, 255));
        tfContact.setForeground(new java.awt.Color(0, 0, 0));
        tfContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContactActionPerformed(evt);
            }
        });
        jPanel2.add(tfContact);
        tfContact.setBounds(432, 320, 200, 22);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(130, 173, 40, 16);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(130, 230, 40, 16);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Surname");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(130, 292, 60, 16);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(432, 173, 60, 16);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Current TL");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(430, 230, 70, 16);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contact");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(432, 292, 60, 16);

        btNew.setBackground(new java.awt.Color(255, 255, 255));
        btNew.setForeground(new java.awt.Color(0, 0, 0));
        btNew.setText("New Account");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        jPanel2.add(btNew);
        btNew.setBounds(720, 190, 110, 23);

        btModify.setBackground(new java.awt.Color(255, 255, 255));
        btModify.setForeground(new java.awt.Color(0, 0, 0));
        btModify.setText("Modify");
        btModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifyActionPerformed(evt);
            }
        });
        jPanel2.add(btModify);
        btModify.setBounds(720, 240, 110, 23);

        btDelete.setBackground(new java.awt.Color(255, 255, 255));
        btDelete.setForeground(new java.awt.Color(0, 0, 0));
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btDelete);
        btDelete.setBounds(720, 290, 110, 23);

        tbAccounts.setBackground(new java.awt.Color(255, 255, 255));
        tbAccounts.setForeground(new java.awt.Color(0, 0, 0));
        tbAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IBAN", "Email", "Name", "Surname", "Password", "Current TL", "Contact"
            }
        )
        {
            public boolean isCellEditable(int row , int column){
                return false;
            }
        }
    );
    tbAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbAccountsMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tbAccounts);

    jPanel2.add(jScrollPane2);
    jScrollPane2.setBounds(120, 400, 730, 229);

    jLabel10.setForeground(new java.awt.Color(255, 255, 255));
    jLabel10.setText("select account :");
    jPanel2.add(jLabel10);
    jLabel10.setBounds(120, 370, 90, 16);

    btSignOut.setBackground(new java.awt.Color(255, 255, 255));
    btSignOut.setForeground(new java.awt.Color(0, 0, 0));
    btSignOut.setText("Sign Out");
    btSignOut.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btSignOutActionPerformed(evt);
        }
    });
    jPanel2.add(btSignOut);
    btSignOut.setBounds(755, 670, 90, 23);

    btClear.setBackground(new java.awt.Color(255, 255, 255));
    btClear.setForeground(new java.awt.Color(0, 0, 0));
    btClear.setText("Clear");
    btClear.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btClearActionPerformed(evt);
        }
    });
    jPanel2.add(btClear);
    btClear.setBounds(720, 340, 110, 23);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
            .addGap(0, 0, 0))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContactActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        li = accounts.listIterator();
        
        
        if(isFieldEmpty()){ // is any field is empty
            JOptionPane.showMessageDialog(null, "Please fill the empty Field");
        }else{
            if(tbAccounts.getSelectedRowCount()== 1){ // have to select a row at first to use the delete button
                tbModel.removeRow(tbAccounts.getSelectedRow()); // remove the row from the table 

                while(li.hasNext()){ // removing the selected row's data from the arraylist
                    History h = (History) li.next();
                    if(h.getIBAN().equals(IBAN)){ // for removing the selected data for our arraylist
                        li.remove();
                    break; // for decreasing  the time complexity 
                    }
                }
                
                SaveToFile();
                
            }else{
                if(tbAccounts.getRowCount() == 0){ // if there is no empty no data
                    JOptionPane.showMessageDialog(this, "Table is Empty");
                }else{
                    // if table is not empty but row is not selected  or multiple row is selected 
                    JOptionPane.showMessageDialog(this, "Please select a single row for delete");
                }
            }
        }
        
        
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tbAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccountsMouseClicked
        
        //using the clickability of the mouse to select the user's info from a row  
        
        DefaultTableModel tbModel = (DefaultTableModel) tbAccounts.getModel();
        
        //The ease of finding the data for other functionality
        IBAN = tbModel.getValueAt(tbAccounts.getSelectedRow(), 0).toString(); 
        
        // setting every info from the table in its textField 
        tfEmail.setText(tbModel.getValueAt(tbAccounts.getSelectedRow(), 1).toString()); 
        tfName.setText(tbModel.getValueAt(tbAccounts.getSelectedRow(), 2).toString());
        tfSurname.setText(tbModel.getValueAt(tbAccounts.getSelectedRow(), 3).toString());
        tfPassword.setText(tbModel.getValueAt(tbAccounts.getSelectedRow(), 4).toString());
        tfCurrentAmount.setText(tbModel.getValueAt(tbAccounts.getSelectedRow(), 5).toString());
        tfContact.setText(tbModel.getValueAt(tbAccounts.getSelectedRow(), 6).toString());
        
    }//GEN-LAST:event_tbAccountsMouseClicked

    private void btSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignOutActionPerformed
        this.dispose(); // closing the current jFrame
        new LogInForm().setVisible(true); // setting the signInForm visible 
    }//GEN-LAST:event_btSignOutActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // using the clear button for clearing out the text field 
        tfEmail.setText("");
        tfName.setText("");
        tfSurname.setText("");
        tfPassword.setText("");
        tfCurrentAmount.setText("");
        tfContact.setText("");
        // after clicking on any row we must cleaer that out for other functionality ... that is the use of clearSelection() method 
        tbAccounts.clearSelection();
    }//GEN-LAST:event_btClearActionPerformed

    private void btModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifyActionPerformed
        if(isFieldEmpty()){
            JOptionPane.showMessageDialog(null, "Fill The Empty Field");
        }else{
            if(tbAccounts.getSelectedRowCount()== 1){  // select row at first to get the info 
                
                // setting the modified info into the table 
                tbModel.setValueAt(IBAN ,tbAccounts.getSelectedRow(), 0);
                tbModel.setValueAt(tfEmail.getText() ,tbAccounts.getSelectedRow(), 1);
                tbModel.setValueAt(tfName.getText() ,tbAccounts.getSelectedRow(), 2);
                tbModel.setValueAt(tfSurname.getText() ,tbAccounts.getSelectedRow(), 3);
                tbModel.setValueAt(tfPassword.getText() ,tbAccounts.getSelectedRow(), 4);
                tbModel.setValueAt(tfCurrentAmount.getText() ,tbAccounts.getSelectedRow(), 5);
                tbModel.setValueAt(tfContact.getText() ,tbAccounts.getSelectedRow(), 6);
                
                li = accounts.listIterator(); // declaring the listIterator

                while(li.hasNext()){
                    History h = (History) li.next();
                    if(h.getIBAN().equals(IBAN)){ // for modifying the selected data for our arraylist
                        li.set(new History(IBAN, tfEmail.getText() , tfPassword.getText() , tfContact.getText() , tfName.getText()  , 
                                tfSurname.getText() , Double.parseDouble(tfCurrentAmount.getText())));
                    break; // for decreasing  the time complexity 
                    }
                }
                
                SaveToFile();
                
            }else{
                if(tbAccounts.getRowCount() == 0){ // if there is no empty no data
                    JOptionPane.showMessageDialog(this, "Table is Empty");
                }else{
                    // if table is not empty but row is not selected  or multiple row is selected 
                    JOptionPane.showMessageDialog(this, "Please select a single row for delete");
                }
            }
        }
    }//GEN-LAST:event_btModifyActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        
        
        li = accounts.listIterator();
        
        
        if(isFieldEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill the empty Field");
        }else{
            if(tbAccounts.getSelectedRowCount()== 0){ //for preventing the interfere of the selected row and adding the new account
                

                if(!search()){
                    // adding the new account
                    History newAccount = new History(tfEmail.getText(), tfPassword.getText() , tfContact.getText(),
                            tfName.getText()  , tfSurname.getText(),Double.parseDouble(tfCurrentAmount.getText()));
                    accounts.add( newAccount); // adding the data into the arraylist
                    tbModel.addRow(new String[] {newAccount.getIBAN(), newAccount.getEmail() , newAccount.getName() , newAccount.getSurname() ,
                        newAccount.getPassword() ,String.valueOf(newAccount.getAmount()) , newAccount.getContact()}); // adding the new account info int the table
                    SaveToFile();

                    
                }else{
                    JOptionPane.showMessageDialog(null, "The Account Does Exist");
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "Clear The Field...!");
            }
        }
    }//GEN-LAST:event_btNewActionPerformed

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
            java.util.logging.Logger.getLogger(administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(administrative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new administrative().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btModify;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSignOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbAccounts;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfCurrentAmount;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfSurname;
    // End of variables declaration//GEN-END:variables
}

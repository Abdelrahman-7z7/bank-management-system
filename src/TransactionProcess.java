
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author dhooo
 */
public class TransactionProcess extends javax.swing.JFrame {

    History currentUser;
    String tbIban = null;
    
    ArrayList<History> customerList;
    
    
    File file;
    
    public TransactionProcess() {
        initComponents();
    }
    
    public TransactionProcess(History currentAccount){
        initComponents();
        file = new File("CustomerInfo.txt");
        this.currentUser = currentAccount; //  holding the current user info and making as a local variable for other functionalities 
        customerList = new ArrayList<History>();
        ReadTheFile();
        setTransactionInfo();
       
        
    }
    
    public boolean isManagerAccount(History h){ // assuring that the manager account won't be an option in the transaction Table 
        
        String managerAccount = "admin@gmail.com";
        String managerPassword = "142536";
        
        if(managerAccount.equals(h.getEmail()) && managerPassword.equals(h.getPassword())){
            return false;
        }
        
        return true;
    }
    
    public void setTransactionInfo(){ 
        tfAccountNo.setText("" + currentUser.getIBAN()); // setting the current user IBAN
        tfAccountNo.setEditable(false);
        
        tfCurrentMoney.setText( "₺ " + String.valueOf(currentUser.getAmount()));
        tfCurrentMoney.setEditable(false);
        
        
        ListIterator li = customerList.listIterator();
        
        DefaultTableModel tbModel = (DefaultTableModel) tbAccounts.getModel();
        
        
        while(li.hasNext()){
            History h = (History) li.next();
            if(!h.getIBAN().equals(currentUser.getIBAN())){
                // checking out that the current user wont have his name as an option for transaction table neither the managerAccount
                if(isManagerAccount(h)){
                    tbModel.addRow(new String[] {h.getIBAN() , h.getName() , h.getSurname()});
                }
            }
        }
    }
    
    
    
    public void SaveToFile(){
        if(file.isFile()){
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("CustomerInfo.txt")));

                for(int i = 0 ; i < customerList.size(); i++){

                    oos.writeObject(customerList.get(i));
                }

                oos.close();
                JOptionPane.showMessageDialog(null, "Funds Transferred successfully");
            }catch(IOException e){
                e.printStackTrace();
            }
        } else {
              JOptionPane.showMessageDialog(null, "The File Doesn't Exist");
        }
 
    }
    
    public void ReadTheFile(){
        if(file.isFile()){
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("CustomerInfo.txt")));
                
                boolean endOfFile = false;
               
                while (!endOfFile) {
                    try {
                        customerList.add((History) ois.readObject());
                    } catch (EOFException e) {
                        endOfFile = true;
                    } catch(IOException | ClassNotFoundException e){
                        e.printStackTrace();
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
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAccounts = new javax.swing.JTable();
        tfCurrentMoney = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTransAmount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfAccountNo = new javax.swing.JTextField();
        bBack = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(63, 0, 113));
        jPanel2.setForeground(new java.awt.Color(49, 8, 123));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ABRBANK");

        tbAccounts.setBackground(new java.awt.Color(255, 255, 255));
        tbAccounts.setForeground(new java.awt.Color(0, 0, 0));
        tbAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IBAN", "Name", "Surname"
            }
        )
        {
            public boolean isCellEditable(int row , int column){
                return false;
            }
        }

    );
    tbAccounts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    tbAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbAccountsMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbAccounts);

    tfCurrentMoney.setBackground(new java.awt.Color(255, 255, 255));
    tfCurrentMoney.setForeground(new java.awt.Color(0, 0, 0));
    tfCurrentMoney.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tfCurrentMoneyActionPerformed(evt);
        }
    });

    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("Current Money ");

    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("Transaction Amount");

    tfTransAmount.setBackground(new java.awt.Color(255, 255, 255));
    tfTransAmount.setForeground(new java.awt.Color(0, 0, 0));
    tfTransAmount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tfTransAmountActionPerformed(evt);
        }
    });

    jButton1.setBackground(new java.awt.Color(255, 255, 255));
    jButton1.setForeground(new java.awt.Color(0, 0, 0));
    jButton1.setText("Trans");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Account Number");

    tfAccountNo.setBackground(new java.awt.Color(255, 255, 255));
    tfAccountNo.setForeground(new java.awt.Color(0, 0, 0));
    tfAccountNo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tfAccountNoActionPerformed(evt);
        }
    });

    bBack.setBackground(new java.awt.Color(255, 255, 255));
    bBack.setForeground(new java.awt.Color(0, 0, 0));
    bBack.setText("Back");
    bBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bBackActionPerformed(evt);
        }
    });

    jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kisspng-credit-card-card-security-code-computer-icons-paym-payment-5ac2099cb1d5a1.0033384515226658847284.png"))); // NOI18N

    jLabel4.setForeground(new java.awt.Color(255, 255, 255));
    jLabel4.setText("Select the ");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(156, 156, 156)
                    .addComponent(jLabel14)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 303, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGap(77, 77, 77)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(tfAccountNo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(tfCurrentMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(tfTransAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(bBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1)))
                    .addGap(31, 31, 31))))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(48, 48, 48)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(tfAccountNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tfCurrentMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfTransAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGap(56, 56, 56)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bBack)
                .addComponent(jButton1))
            .addGap(52, 52, 52))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCurrentMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCurrentMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCurrentMoneyActionPerformed

    private void tfAccountNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAccountNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAccountNoActionPerformed

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        this.dispose();
        try {
            new AccountProcessing(currentUser).setVisible(true); // passing the current user info for the previous jFrame to keep the current user in 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TransactionProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bBackActionPerformed

    private void tfTransAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTransAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTransAmountActionPerformed

    private void tbAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccountsMouseClicked
        DefaultTableModel tbModel = (DefaultTableModel) tbAccounts.getModel();
        
        tbIban = tbModel.getValueAt(tbAccounts.getSelectedRow(), 0).toString(); // selecting the IBAN to make the transaction to it 
        
        
    }//GEN-LAST:event_tbAccountsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ListIterator li = customerList.listIterator();
        
        int found = 0; 
        
        if(currentUser.getAmount() >= Double.parseDouble(tfTransAmount.getText()) && Double.parseDouble(tfTransAmount.getText()) >= 1){
            while(li.hasNext()){
                History account = (History) li.next();

                if(account.getIBAN().equals(tbIban)){ // finding the selected data
                    li.set(new History(account.getIBAN(), account.getEmail() , account.getPassword() , account.getContact() , account.getName()
                        , account.getSurname() , account.deposite(Double.parseDouble(tfTransAmount.getText()))));
                    found += 1;
                }

                if(account.getIBAN().equals(currentUser.getIBAN())){ // finding the currentUser
                    li.set(new History(account.getIBAN(), account.getEmail() , account.getPassword() , account.getContact() , account.getName()
                        , account.getSurname() , account.withdraw(Double.parseDouble(tfTransAmount.getText()))));
                    currentUser = account; // updating the currentUser data
                    found +=1;
                }

            }
        
            if(found == 2){ // chaking if the transaction has been added and remove it from the sender and the receiver
                SaveToFile();
            }else{
                JOptionPane.showMessageDialog(null, "Account Not found... select again!!");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "You entered Invalid amount of money / a negative amount");
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionProcess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAccounts;
    private javax.swing.JTextField tfAccountNo;
    private javax.swing.JTextField tfCurrentMoney;
    private javax.swing.JTextField tfTransAmount;
    // End of variables declaration//GEN-END:variables
}

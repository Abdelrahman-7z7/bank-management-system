
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


public class AccountProcessing extends javax.swing.JFrame {
    
    
    History currentUser;
    ArrayList<History> customerList;
    File file;
    
    
    public AccountProcessing() {
        initComponents();
    }
    
    
    public AccountProcessing(History sendData) throws ClassNotFoundException{ // this is for accessing the data of the loged in account
        initComponents();
        file = new File("CustomerInfo.txt");
        customerList = new ArrayList<History>();
        currentUser = sendData; // holding the current user info from the previous jFrame 
        
        ReadTheFile();
        setAccountInfo();
           
    }
    
    public void setAccountInfo(){ // setting each info in its textField && and making every one uneditable
        tfIban.setText(currentUser.getIBAN());
        tfIban.setEditable(false);
        
        tfName2.setText(currentUser.getName());
        tfName2.setEditable(false);
        
        tfSurname2.setText(currentUser.getSurname());
        tfSurname2.setEditable(false);
        
        tfEmail3.setText(currentUser.getEmail());
        tfEmail3.setEditable(false);
        
        tfContact.setText(currentUser.getContact());
        tfContact.setEditable(false);
        
        tfCurrentMoney.setText( "₺ " + String.valueOf(currentUser.getAmount())); //String.valueOf() it is used for casting to String datatype 
        tfCurrentMoney.setEditable(false);
    }
    
    public void SaveToFile(){
        
        if(file.isFile()){
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("CustomerInfo.txt")));
                
            
                for(int i = 0; i < customerList.size(); i++){
                    oos.writeObject(customerList.get(i));
                }
                oos.close();
                    
                JOptionPane.showMessageDialog(null, "Saved Seccessfully" + customerList.size());
                //this.dispose();
            } catch(IOException e){
                e.printStackTrace();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "File Does Not Exist");
        }
        
        
        
    }

    public void ReadTheFile() throws ClassNotFoundException{
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

        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfWithdraw = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDeposite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bDeposite = new javax.swing.JButton();
        bWithdraw = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCurrentMoney = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfIban = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfName2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfSurname2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfEmail3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfContact = new javax.swing.JTextField();
        bConfirm = new javax.swing.JButton();
        bSignOut = new javax.swing.JButton();
        bTransaction = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kisspng-credit-card-card-security-code-computer-icons-paym-payment-5ac2099cb1d5a1.0033384515226658847284.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(63, 0, 113));
        jPanel3.setForeground(new java.awt.Color(49, 8, 123));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ABRBANK");

        tfWithdraw.setBackground(new java.awt.Color(255, 255, 255));
        tfWithdraw.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfWithdrawActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Withdraw");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Deposite");

        tfDeposite.setBackground(new java.awt.Color(255, 255, 255));
        tfDeposite.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Account Details");

        bDeposite.setBackground(new java.awt.Color(255, 255, 255));
        bDeposite.setForeground(new java.awt.Color(51, 51, 51));
        bDeposite.setText("deposite");
        bDeposite.setToolTipText("");
        bDeposite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDepositeActionPerformed(evt);
            }
        });

        bWithdraw.setBackground(new java.awt.Color(255, 255, 255));
        bWithdraw.setForeground(new java.awt.Color(51, 51, 51));
        bWithdraw.setText("Withdraw");
        bWithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWithdrawActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Current Money");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        tfCurrentMoney.setBackground(new java.awt.Color(153, 153, 153));
        tfCurrentMoney.setForeground(new java.awt.Color(51, 51, 51));
        tfCurrentMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCurrentMoneyActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("IBAN");

        tfIban.setBackground(new java.awt.Color(153, 153, 153));
        tfIban.setForeground(new java.awt.Color(51, 51, 51));
        tfIban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIbanActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name");

        tfName2.setBackground(new java.awt.Color(153, 153, 153));
        tfName2.setForeground(new java.awt.Color(51, 51, 51));
        tfName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfName2ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Surname");

        tfSurname2.setBackground(new java.awt.Color(153, 153, 153));
        tfSurname2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email");

        tfEmail3.setBackground(new java.awt.Color(153, 153, 153));
        tfEmail3.setForeground(new java.awt.Color(51, 51, 51));
        tfEmail3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmail3ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contact");

        tfContact.setBackground(new java.awt.Color(153, 153, 153));
        tfContact.setForeground(new java.awt.Color(51, 51, 51));

        bConfirm.setBackground(new java.awt.Color(255, 255, 255));
        bConfirm.setForeground(new java.awt.Color(51, 51, 51));
        bConfirm.setText("Confirm");
        bConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmActionPerformed(evt);
            }
        });

        bSignOut.setBackground(new java.awt.Color(255, 255, 255));
        bSignOut.setForeground(new java.awt.Color(51, 51, 51));
        bSignOut.setText("Sign Out");
        bSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSignOutActionPerformed(evt);
            }
        });

        bTransaction.setBackground(new java.awt.Color(255, 255, 255));
        bTransaction.setForeground(new java.awt.Color(51, 51, 51));
        bTransaction.setText("Transaction");
        bTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTransactionActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kisspng-credit-card-card-security-code-computer-icons-paym-payment-5ac2099cb1d5a1.0033384515226658847284.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIban, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(tfContact, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfName2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(tfSurname2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(bSignOut)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bDeposite))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDeposite)
                                    .addComponent(tfWithdraw)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(bTransaction)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                        .addComponent(bConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfCurrentMoney)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel3))
                                .addGap(83, 83, 83)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(tfEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bWithdraw)))
                .addGap(74, 74, 74))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel3)))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDeposite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSurname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bDeposite)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bWithdraw)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCurrentMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTransaction)
                    .addComponent(bConfirm)
                    .addComponent(bSignOut))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSignOutActionPerformed
        this.dispose();
        new LogInForm().setVisible(true);
    }//GEN-LAST:event_bSignOutActionPerformed

    private void bConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmActionPerformed
        ListIterator li = customerList.listIterator();
        
        boolean found = false;

        while(li.hasNext()){
            History h = (History) li.next();
            
            if(h.getEmail().toLowerCase().equals(currentUser.getEmail().toLowerCase()) && h.getPassword().equals(currentUser.getPassword())){
                
                li.set(new History(h.getIBAN(), h.getEmail() , h.getPassword() , h.getContact() , h.getName()
                    , h.getSurname() , Double.parseDouble(tfCurrentMoney.getText().substring(2)))); // using the subString in order to escape the lira sign  
                found = true;
                
            }
         
        }
        
        if(found){ // checking is the account found then we shall save the data
            SaveToFile();
        }else{
            JOptionPane.showMessageDialog(null, "Email Not Found");
        }

    }//GEN-LAST:event_bConfirmActionPerformed

    private void tfEmail3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmail3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmail3ActionPerformed

    private void tfName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfName2ActionPerformed

    private void tfIbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIbanActionPerformed

    }//GEN-LAST:event_tfIbanActionPerformed

    private void tfCurrentMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCurrentMoneyActionPerformed
        //
    }//GEN-LAST:event_tfCurrentMoneyActionPerformed

    private void bWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bWithdrawActionPerformed
        // making sure that there is enough money for the withdraw process and it has to be at least 1 lira 
        if(currentUser.getAmount() >= Double.parseDouble(tfWithdraw.getText()) && Double.parseDouble(tfWithdraw.getText()) >= 1){ 
            tfCurrentMoney.setText( "₺ " + String.valueOf(currentUser.withdraw(Double.parseDouble(tfWithdraw.getText()))));
        }else{
            JOptionPane.showMessageDialog(null , "You have entered invalid money amount / Negative amount");
        }
        //String <= Double <= String
        //tfCurrentMoney's parameter takes String
        //withdraw Medthod's parameter takes Double
        // tfWithdraw is String
    }//GEN-LAST:event_bWithdrawActionPerformed

    private void bDepositeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDepositeActionPerformed
        // making sure that the user at least deposite 1 lire not ZERO
        if(Double.parseDouble(tfDeposite.getText()) >= 1){
            tfCurrentMoney.setText( "₺ " + String.valueOf(currentUser.deposite(Double.parseDouble(tfDeposite.getText()))));
        } else{
            JOptionPane.showMessageDialog(null, "You have entered a negative value");
        }
    }//GEN-LAST:event_bDepositeActionPerformed

    private void tfWithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfWithdrawActionPerformed

    }//GEN-LAST:event_tfWithdrawActionPerformed

    private void bTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTransactionActionPerformed
        this.dispose();
        new TransactionProcess(currentUser).setVisible(true);
        
    }//GEN-LAST:event_bTransactionActionPerformed

    
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
            java.util.logging.Logger.getLogger(AccountProcessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountProcessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountProcessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountProcessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccountProcessing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConfirm;
    private javax.swing.JButton bDeposite;
    private javax.swing.JButton bSignOut;
    private javax.swing.JButton bTransaction;
    private javax.swing.JButton bWithdraw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfCurrentMoney;
    private javax.swing.JTextField tfDeposite;
    private javax.swing.JTextField tfEmail3;
    private javax.swing.JTextField tfIban;
    private javax.swing.JTextField tfName2;
    private javax.swing.JTextField tfSurname2;
    private javax.swing.JTextField tfWithdraw;
    // End of variables declaration//GEN-END:variables
}

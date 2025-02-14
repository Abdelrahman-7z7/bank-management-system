
import java.awt.Cursor;
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


public class RegisterForm extends javax.swing.JFrame {
    
    
    
    ArrayList<History> customerList = null;
    File file;
    
    
    
    public RegisterForm() {
        
        initComponents();
        customerList = new ArrayList<History>();
        file = new File("CustomerInfo.txt");
        ReadTheFile();
        
    }
    
    public void SaveToFile(){ // writting the data into the file
        
        if(file.isFile()){ // for checking the existence of the file
            try{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("CustomerInfo.txt")));
            
                for(int i = 0; i < customerList.size(); i++){
                    oos.writeObject(customerList.get(i));
                }
                oos.close();
                    
                JOptionPane.showMessageDialog(null, "Saved Seccessfully" + customerList.size());
                this.dispose(); // closing the file...
            } catch(IOException e){
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "File Does Not Exist");
        }
        
    }
    
    public void ReadTheFile(){ //s reading the data from the file 
        if(file.isFile()){ // for checking the existence of the file
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("CustomerInfo.txt")));
                
        
                boolean endOfFile = false;
                
                while (!endOfFile) {
                    try {
                        customerList.add((History) ois.readObject());
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
    
    public int hashCode(){ // for searching the data out 
        return this.Email.getText().toLowerCase().trim().hashCode(); // we turned this one to lowercase so it wouldnt matter if the email is added by uppercase or lowercase
    }
    
    public boolean search(){ // for assuring the user's email hasn't been used
        boolean found = false;
        
        ListIterator li = customerList.listIterator();
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPassword1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        LogIn = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Contact = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfSurname = new javax.swing.JTextField();
        Jlable10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btSignUp = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(63, 0, 113));
        jPanel3.setForeground(new java.awt.Color(49, 8, 123));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ABRBANK");

        Email.setBackground(new java.awt.Color(255, 255, 255));
        Email.setForeground(new java.awt.Color(51, 51, 51));
        Email.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Email.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        jPassword1.setBackground(new java.awt.Color(255, 255, 255));
        jPassword1.setForeground(new java.awt.Color(51, 51, 51));
        jPassword1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword1ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("I do have an account?");

        LogIn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LogIn.setForeground(new java.awt.Color(255, 255, 255));
        LogIn.setText("Log In");
        LogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogInMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogInMousePressed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contact");

        Contact.setBackground(new java.awt.Color(255, 255, 255));
        Contact.setForeground(new java.awt.Color(0, 0, 0));
        Contact.setText("+90 ");
        Contact.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });

        tfName.setBackground(new java.awt.Color(255, 255, 255));
        tfName.setForeground(new java.awt.Color(51, 51, 51));
        tfName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfSurname.setBackground(new java.awt.Color(255, 255, 255));
        tfSurname.setForeground(new java.awt.Color(51, 51, 51));
        tfSurname.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Jlable10.setForeground(new java.awt.Color(255, 255, 255));
        Jlable10.setText("Name");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Surname");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(151, 114, 251));
        jLabel4.setForeground(new java.awt.Color(151, 114, 251));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(177, 177, 177))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kisspng-credit-card-card-security-code-computer-icons-paym-payment-5ac2099cb1d5a1.0033384515226658847284.png"))); // NOI18N

        btSignUp.setBackground(new java.awt.Color(255, 255, 255));
        btSignUp.setForeground(new java.awt.Color(0, 0, 0));
        btSignUp.setText("SignUp");
        btSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPassword1)
                        .addComponent(Email)
                        .addComponent(Contact)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Jlable10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(tfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LogIn))
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel8)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btSignUp))
                .addGap(78, 78, 78)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlable10)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btSignUp)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LogIn))
                .addGap(32, 32, 32))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        
    }//GEN-LAST:event_EmailActionPerformed

    private void jPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassword1ActionPerformed

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
        
    }//GEN-LAST:event_ContactActionPerformed

    private void LogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInMouseClicked
        this.dispose();
        new LogInForm().setVisible(true);
        
    }//GEN-LAST:event_LogInMouseClicked

    private void LogInMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogInMousePressed
        LogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  // in order to make a lable clickable
    }//GEN-LAST:event_LogInMousePressed

    private void btSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignUpActionPerformed
        
        if(this.Email.getText().isEmpty() || this.jPassword1.getText().isEmpty() || this.Contact.getText().isEmpty()
                || this.tfName.getText().isEmpty() || this.tfSurname.getText().isEmpty()){ // checking the textFields aren't empty
            JOptionPane.showMessageDialog(null, "Fill The Empty Field");
        }else{
            
            
                
                String name = this.tfName.getText().trim();
                String surname = this.tfSurname.getText().trim();
                String cEmail = this.Email.getText().trim();
                String cPassword = this.jPassword1.getText().trim();
                String cContact =this.Contact.getText().trim();
            
            if(!search()){ // using the search method for making sure that the email hasn't been used before 
                History hrgf = new History(cEmail , cPassword , cContact , name , surname , 0.0); // creation of the new account
                customerList.add( hrgf); // storeing the object in the arraylist
                SaveToFile(); // saving the data in the file
                    
                new LogInForm().setVisible(true);
            }else{
                
                JOptionPane.showMessageDialog(null, "The Account Does Exist");
                    
            }
        }
        
        
                
        
    }//GEN-LAST:event_btSignUpActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contact;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel Jlable10;
    private javax.swing.JLabel LogIn;
    private javax.swing.JButton btSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword1;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSurname;
    // End of variables declaration//GEN-END:variables
}

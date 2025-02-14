
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class LogInForm extends javax.swing.JFrame {
    // to open the managerJframe Email: admin@gmail.com   Password: 142536 //
    //if the manager doesn't open that means that you haven't at least register with the same name and password for one time // 
    
    History sendData = null;
    History hlgn;
    ArrayList<History> customerList;
    File file;
    
    
    
    public LogInForm() {
        initComponents();
        file = new File("CustomerInfo.txt");
        customerList = new ArrayList<History>();
        ReadTheFile();

        
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
    
    
    
    
    public boolean search(){ // for sending the data to another jFrame && searching for the existence of the account
        boolean found = false;
        
        ListIterator li = customerList.listIterator();
        
        while(li.hasNext()){ // using the listIterator method to loop into the arraylist 
            History h = (History) li.next();
            
            if(h.getEmail().toLowerCase().trim().equals(this.email2.getText().toLowerCase().trim()) && h.getPassword().trim().equals(this.jPassword2.getText().trim())){
                sendData = h;
                found = true;
                break;
            }
        }
        
        return found;
    }
    
    public boolean isManagerAccount(){ // searching the manager account out so if it get used then we open its jFrame
        
        String managerAccount = "admin@gmail.com";
        String managerPassword = "142536";
        
        if(managerAccount.equals(email2.getText().toLowerCase().trim()) && managerPassword.equals(jPassword2.getText().trim())){
            return true;
        }
        
        return false;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPassword2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        email2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        SignUp = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btSignIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(63, 0, 113));
        jPanel2.setForeground(new java.awt.Color(49, 8, 123));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ABRBANK");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        jPassword2.setBackground(new java.awt.Color(255, 255, 255));
        jPassword2.setForeground(new java.awt.Color(0, 0, 0));
        jPassword2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassword2ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Email");

        email2.setBackground(new java.awt.Color(255, 255, 255));
        email2.setForeground(new java.awt.Color(0, 0, 0));
        email2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        email2.setActionCommand("null");
        email2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        email2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Don't have an account? ");

        SignUp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SignUp.setForeground(new java.awt.Color(255, 255, 255));
        SignUp.setText("Sign Up");
        SignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignUpMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SignUpMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(151, 114, 251));
        jLabel4.setForeground(new java.awt.Color(151, 114, 251));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kisspng-credit-card-card-security-code-computer-icons-paym-payment-5ac2099cb1d5a1.0033384515226658847284.png"))); // NOI18N

        btSignIn.setBackground(new java.awt.Color(255, 255, 255));
        btSignIn.setForeground(new java.awt.Color(0, 0, 0));
        btSignIn.setText("Sign In");
        btSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SignUp))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSignIn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(email2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btSignIn)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SignUp))
                .addGap(66, 66, 66))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassword2ActionPerformed

    private void SignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseClicked
        this.dispose(); // closing the current jframe
        new RegisterForm().setVisible(true); // display the RegiterForm jFrame
    }//GEN-LAST:event_SignUpMouseClicked

    private void SignUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMousePressed
        
        SignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  // in order to make a lable clickable
    }//GEN-LAST:event_SignUpMousePressed

    private void SignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SignUpMouseEntered

    private void btSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignInActionPerformed
        
        if(this.email2.getText().isEmpty() || this.jPassword2.getText().isEmpty()){ // chacking textFields aren't empty
            
            JOptionPane.showMessageDialog(null, "Fill The Empty Field");
            
        }else{
             
            
            if(search()){ // searching the existence of the account 
                this.dispose();
                
                try {
                    if(isManagerAccount()){ // if the current user is the manager set that jFrame visible 
                        new administrative(sendData).setVisible(true);
                    }else{ // seting the normal user jframe visible
                        new AccountProcessing(sendData).setVisible(true);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogInForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "The Account Does Not Exist / The Password is Wrong");
            }
            
        }
        
        
    }//GEN-LAST:event_btSignInActionPerformed

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
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SignUp;
    private javax.swing.JButton btSignIn;
    private javax.swing.JTextField email2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword2;
    // End of variables declaration//GEN-END:variables
}

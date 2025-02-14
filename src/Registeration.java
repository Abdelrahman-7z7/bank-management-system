
import java.io.Serializable;






public class Registeration implements Serializable{
    
    // holding the local class serialVersionUID so that will prevent 
    // the causing of the losting the class local versionserialUID after any change in the class (preventing the interruption of deserializable process)
    
    private static final long serialVersionUID = -6333394887791736693L; 
    
    //state: 
    
    private String IBAN;
    private String email;
    private String Password;
    private String contact;
    private String name;
    private String surname;
    
    
    //Constructor

  
    public Registeration(String email, String password, String contact , String name, String surname){ // For a new Customer..
        this.email = email;
        this.Password = password;
        this.contact = contact;
        this.IBAN = ibanGenerator(); 
        this.name = name;
        this.surname = surname;
    }
    
    public Registeration(String iban , String email, String password, String contact, String name , String surname){ // for updated data so the iban won't get updated with The others...
        this.email = email;
        this.Password = password;
        this.contact = contact;
        this.IBAN = iban;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    //Behaviour

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getContact(){
        return contact;
    }

    public void setPhoneNumber(String contact) {
        this.contact = contact;
    }
    
    //ِAction:
    public String ibanGenerator(){ // for generating the iban by default for every account get created 
        
        String iban = " ";

        String st = "0123456789";
        
        
            for (int i = 0; i < 15; i++) {

                if(i !=4 && i !=9 && i !=14 ) { // it is for the way that the iban gets stored. After every four numbers a space written.  
                    int index = (int) (Math.random() * st.length()); // Math.random * range + from ==> [0 , 12]
                    iban += st.charAt(index);
                }else{
                    iban += " ";
                }
            }

        return iban;
    }
    
    
    public int hasCode(){ // used for searching the data out in the jframe 
        return this.getEmail().toLowerCase().hashCode();
    }

    
    
    //override method 
    @Override
    public String toString(){
        return IBAN +" " + getEmail() + " " + contact + " " + Password + " " + name + " " + surname; 
    }
    
          
    
}

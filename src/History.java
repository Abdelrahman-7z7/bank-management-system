
import java.io.Serializable;

/**
 *
 * @author dhooo
 */
public class History extends Registeration implements Serializable{
    
    // holding the local class serialVersionUID so that will prevent 
    // the causing of the losting the class local versionserialUID after any change in the class (preventing the interruption of deserializable process)
    
    private static final long serialVersionUID = -6333394887791736693L;
    
    //state: 
    private double amount;
    
    //Constructor
    public History(String email, String password, String contact, String name , String surname, double amount){
        super(email , password , contact , name , surname);
        this.amount = amount;
    }
    
    public History(String iban , String email, String password, String contact, String name , String surname, double amount){
        super(iban , email , password , contact , name , surname);
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
            this.amount = amount;
    }
    
    
    //deposıte
    public double deposite(double depositeAm){
        if(depositeAm >= 1){
            return this.amount += depositeAm; 
        }else{
            return this.amount;
        }
    }
    
    //withdraw
    public double withdraw(double withdrawAm){
        if( this.amount >= withdrawAm && withdrawAm >= 1){
            return amount-= withdrawAm;
        }else{
            return this.amount;
        }
    }
    
    
    
    
    
    //override

    /**
     *
     * @return
     */
    @Override
     public String toString(){
        return super.toString() + " " + amount;
    }
    
}

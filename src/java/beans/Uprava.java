package beans;
// Generated Sep 12, 2021 10:30:56 AM by Hibernate Tools 4.3.1



/**
 * Uprava generated by hbm2java
 */
public class Uprava  implements java.io.Serializable {


     private String username;
     private int idPoz;

    public Uprava() {
    }

    public Uprava(String username, int idPoz) {
       this.username = username;
       this.idPoz = idPoz;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public int getIdPoz() {
        return this.idPoz;
    }
    
    public void setIdPoz(int idPoz) {
        this.idPoz = idPoz;
    }




}



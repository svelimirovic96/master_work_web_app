package beans;
// Generated Sep 12, 2021 10:30:56 AM by Hibernate Tools 4.3.1



/**
 * Zamtosluzba generated by hbm2java
 */
public class Zamtosluzba  implements java.io.Serializable {


     private Integer idZamToSluzba;
     private int idMentToZam;
     private String idZam;
     private String idSluzba;
     private Integer status;

    public Zamtosluzba() {
    }

	
    public Zamtosluzba(int idMentToZam, String idZam, String idSluzba) {
        this.idMentToZam = idMentToZam;
        this.idZam = idZam;
        this.idSluzba = idSluzba;
    }
    public Zamtosluzba(int idMentToZam, String idZam, String idSluzba, Integer status) {
       this.idMentToZam = idMentToZam;
       this.idZam = idZam;
       this.idSluzba = idSluzba;
       this.status = status;
    }
   
    public Integer getIdZamToSluzba() {
        return this.idZamToSluzba;
    }
    
    public void setIdZamToSluzba(Integer idZamToSluzba) {
        this.idZamToSluzba = idZamToSluzba;
    }
    public int getIdMentToZam() {
        return this.idMentToZam;
    }
    
    public void setIdMentToZam(int idMentToZam) {
        this.idMentToZam = idMentToZam;
    }
    public String getIdZam() {
        return this.idZam;
    }
    
    public void setIdZam(String idZam) {
        this.idZam = idZam;
    }
    public String getIdSluzba() {
        return this.idSluzba;
    }
    
    public void setIdSluzba(String idSluzba) {
        this.idSluzba = idSluzba;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }




}



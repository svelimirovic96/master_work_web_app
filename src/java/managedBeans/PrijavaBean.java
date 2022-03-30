/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import beans.Korisnik;
import beans.Masterrad;
import beans.Predaje;
import beans.Predmet;
import beans.Prijava;
import beans.RukovodilacModula;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;


/**
 *
 * @author Sandra
 */
@ManagedBean(name = "prijavaB")
@SessionScoped
public class PrijavaBean {
    private String nazivPredmeta;
    private String mentor;
    private String mentor1;
    private String temaSrpski, temaEngleski;
    private boolean rukovodilac, mentorRada;
    
    private List<Korisnik> mentorList;
    private List<Predmet> predmetList;
    private UIComponent messagePrijava_1;

    public boolean isRukovodilac() {
        return rukovodilac;
    }

    public void setRukovodilac(boolean rukovodilac) {
        this.rukovodilac = rukovodilac;
    }

    public boolean isMentorRada() {
        return mentorRada;
    }

    public void setMentorRada(boolean mentorRada) {
        this.mentorRada = mentorRada;
    }

    
    public UIComponent getMessagePrijava_1() {
        return messagePrijava_1;
    }

    public void setMessagePrijava_1(UIComponent messagePrijava) {
        this.messagePrijava_1 = messagePrijava;
    }
    
    

    public String getTemaSrpski() {
        return temaSrpski;
    }

    public void setTemaSrpski(String temaSrpski) {
        this.temaSrpski = temaSrpski;
    }

    public String getTemaEngleski() {
        return temaEngleski;
    }

    public void setTemaEngleski(String temaEngleski) {
        this.temaEngleski = temaEngleski;
    }

    public String getMentor1() {
        return mentor1;
    }

    public void setMentor1(String mentor1) {
        this.mentor1 = mentor1;
    }

    
    
    public String getMentor() {
        return mentor;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public List<Predmet> getPredmetList() {
        return predmetList;
    }

    public void setPredmetList(List<Predmet> predmetList) {
        this.predmetList = predmetList;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public List<Korisnik> getMentorList() {
        return mentorList;
    }

    public void setMentorList(List<Korisnik> mentorList) {
        this.mentorList = mentorList;
    }
    
    public List<String> listaPredmeta(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Korisnik student=(Korisnik) httpSession.getAttribute("student");
       
        Query query=session.createQuery("from Predmet where idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')");
        predmetList=query.list();
        int i=0;
        List<String> listaPredmeta=new ArrayList<>();
        while (i<predmetList.size()){
            listaPredmeta.add(predmetList.get(i).getNaziv());
            i++;
        }
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
        }
        return listaPredmeta;
    }
    
     public void box1(ValueChangeEvent e){
         if (mentorRada==true){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Једна од тих опција мора бити означена!"));
     }
     }
     public void box2(ValueChangeEvent e){
         if (rukovodilac==true){
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Једна од тих опција мора бити означена!"));
         }
     }
    
    public void change_Mentor(ValueChangeEvent e){
        mentor=e.getNewValue().toString();
        mentor1=e.getNewValue().toString();
    }
    
    
    public String proveri(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (rukovodilac==false && mentorRada==false ){
             context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Једна од опција мора да се означи!"));
            return "student";
        }
        if (temaSrpski.length()==0) {
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите наслов мастер рада на српском језику!"));
            return "student";
        } 
        
        for(int i = 0; i < temaSrpski.length(); i++) {
             if(!(Character.UnicodeBlock.of(temaSrpski.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(temaSrpski.charAt(i))) || (Character.UnicodeBlock.of(temaSrpski.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Наслов теме на српском језику није написан ћирилицом!"));
                 return "student";
            }
        }
        if (temaEngleski.length()==0){
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите наслов мастер рада на енглеском језику!"));
            return "student";
        }
        for(int i = 0; i < temaEngleski.length(); i++) {
             if(!((Character.isWhitespace(temaEngleski.charAt(i))) || (Character.UnicodeBlock.of(temaEngleski.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Наслов теме на енглеском језику није написан латиницом!"));
                 return "student";
            }
        }
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession sesija=(HttpSession) context.getExternalContext().getSession(false);
        Korisnik student=(Korisnik) sesija.getAttribute("student");
        int index=0;
        String ment=mentor;
        while (!Character.isWhitespace(ment.charAt(index))) index++;
        String imeMentora=ment.substring(0, index);
        ment=mentor;
        String prezimeMentora=ment.substring(index+1);
        boolean ruk=false;
        Query query=session.createQuery("from Korisnik where ime='"+imeMentora+"' and prezime='"+prezimeMentora+"' and username in (select username from Mentor) and username in (select username from RukovodilacModula where idModul in (select idModul from Predmet where idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')))");
        List<Korisnik> korisnici=query.list();
        if (!korisnici.isEmpty() && mentorRada) {
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Изабрани руководилац модула није добро означен!"));
            if (session != null && session.isOpen()) {
            session.close();
        }
            
            return "student";
        }
        else if (!korisnici.isEmpty()) {ruk=true; nazivPredmeta="";}
        query=session.createQuery("from Korisnik where ime='"+imeMentora+"' and prezime='"+prezimeMentora+"' and username in (select username from Mentor)");
        korisnici=query.list();
        if (!korisnici.isEmpty() && rukovodilac && ruk==false){ 
             context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Изабрани професор није добро означен!"));
            if (session != null && session.isOpen()) {
            session.close();
        }
            
            return "student";
        }
        else if (!korisnici.isEmpty() && ruk==false){
            query=session.createQuery("from Predaje where idStudent='"+student.getUsername()+"' and idMentor='"+korisnici.get(0).getUsername()+"' and idPredmet in (select idPredmet from Predmet where naziv='"+nazivPredmeta+"')");
            List<Predaje> predmeti=query.list();
            if (predmeti.isEmpty()){
               context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Изаберите одговарајући предмет који Ваш професор држи!"));
              if (session != null && session.isOpen()) {
                 session.close();
            }
              
                 return "student"; 
        }
        }
        Masterrad rad=new Masterrad(temaSrpski, temaEngleski);
        session.save(rad);
        sesija.setAttribute("masterRad", rad);
        Prijava prijava;
        query=session.createQuery("from Korisnik where username=(select username from RukovodilacModula where idModul in (select idModul from Student where username='"+student.getUsername()+"'))");
        List<Korisnik> listaRukovodilaca=query.list();
        if (nazivPredmeta!=""){
        query=session.createQuery("from Predmet where naziv='"+nazivPredmeta+"' and idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')");
        List<Predmet> predmetList=query.list();
        
        if (rukovodilac) 
         prijava=new Prijava(student.getUsername(), korisnici.get(0).getUsername(),listaRukovodilaca.get(0).getUsername(), predmetList.get(0).getIdPredmet(),1, 1);
        else prijava=new Prijava(student.getUsername(), korisnici.get(0).getUsername(),listaRukovodilaca.get(0).getUsername(), predmetList.get(0).getIdPredmet(),0,1);
        
        }
        else {
            if (rukovodilac) prijava=new Prijava(student.getUsername(), korisnici.get(0).getUsername(), listaRukovodilaca.get(0).getUsername(), 0, 1, 1);
            else prijava=new Prijava(student.getUsername(), korisnici.get(0).getUsername(), listaRukovodilaca.get(0).getUsername(), 0, 0 , 1);
        
        }
        
        if (prijava.getIdMentor().equals(prijava.getIdRukovodilac())){
            query=session.createQuery("from RukovodilacModula where username='"+prijava.getIdRukovodilac()+"'");
            List<RukovodilacModula> listRuk=query.list();
            RukovodilacModula rukModula=listRuk.get(0);
            if (rukModula.getSprecen()==1) prijava.setIdMentorZ(rukModula.getUsernameZ());
                    
        }
        session.save(prijava);
        sesija.setAttribute("prijava", prijava);
        sesija.setAttribute("mentor", korisnici.get(0));
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return "biografija";
    }
}

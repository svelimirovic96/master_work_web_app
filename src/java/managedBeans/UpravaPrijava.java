/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;


import beans.Korisnik;
import beans.Masterrad;
import beans.Modul;
import beans.Predmet;
import beans.Prijava;
import beans.Sastanak;
import beans.VerzijaPrijave;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import util.HibernateUtil;

/**
 *
 * @author Sandra
 */
@ManagedBean(name = "upravaPrijava")
@SessionScoped
public class UpravaPrijava{
     private String ipStudent, ipMentor, ipRuk, ipRukRada, ipRukRad, ipKom1, ipKom2, ipKomisija1, ipKomisija2; //ime i prezime 
    private String indexStudent;
    private String sugestija, nazivModula, nazivPredmeta, bioText, nazivRadSer, nazivRadEn, radPredmet, radSadrzaj;
    private boolean rukovodilac, mentorRada, prihvata, odbija, sugerisi;
    private Date datum, datum1;
    private UIComponent messagePregled1;

    public UIComponent getMessagePregled1() {
        return messagePregled1;
    }

    public void setMessagePregled1(UIComponent messagePregled1) {
        this.messagePregled1 = messagePregled1;
    }
    
    

    public String getSugestija() {
        return sugestija;
    }

    public void setSugestija(String sugestija) {
        this.sugestija = sugestija;
    }

    public boolean isPrihvata() {
        return prihvata;
    }

    public void setPrihvata(boolean prihvata) {
        this.prihvata = prihvata;
    }

    public boolean isOdbija() {
        return odbija;
    }

    public void setOdbija(boolean odbija) {
        this.odbija = odbija;
    }

    public boolean isSugerisi() {
        return sugerisi;
    }

    public void setSugerisi(boolean sugerisi) {
        this.sugerisi = sugerisi;
    }

    
    
    public String getIpStudent() {
        return ipStudent;
    }

    public void setIpStudent(String ipStudent) {
        this.ipStudent = ipStudent;
    }

    public String getIpMentor() {
        return ipMentor;
    }

    public void setIpMentor(String ipMentor) {
        this.ipMentor = ipMentor;
    }

    public String getIpRuk() {
        return ipRuk;
    }

    public void setIpRuk(String ipRuk) {
        this.ipRuk = ipRuk;
    }

    public String getIpRukRada() {
        return ipRukRada;
    }

    public void setIpRukRada(String ipRukRada) {
        this.ipRukRada = ipRukRada;
    }

    public String getIpRukRad() {
        return ipRukRad;
    }

    public void setIpRukRad(String ipRukRad) {
        this.ipRukRad = ipRukRad;
    }

    public String getIpKom1() {
        return ipKom1;
    }

    public void setIpKom1(String ipKom1) {
        this.ipKom1 = ipKom1;
    }

    public String getIpKom2() {
        return ipKom2;
    }

    public void setIpKom2(String ipKom2) {
        this.ipKom2 = ipKom2;
    }

    public String getIpKomisija1() {
        return ipKomisija1;
    }

    public void setIpKomisija1(String ipKomisija1) {
        this.ipKomisija1 = ipKomisija1;
    }

    public String getIpKomisija2() {
        return ipKomisija2;
    }

    public void setIpKomisija2(String ipKomisija2) {
        this.ipKomisija2 = ipKomisija2;
    }

    public String getIndexStudent() {
        return indexStudent;
    }

    public void setIndexStudent(String indexStudent) {
        this.indexStudent = indexStudent;
    }

    public String getNazivModula() {
        return nazivModula;
    }

    public void setNazivModula(String nazivModula) {
        this.nazivModula = nazivModula;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getBioText() {
        return bioText;
    }

    public void setBioText(String bioText) {
        this.bioText = bioText;
    }

    public String getNazivRadSer() {
        return nazivRadSer;
    }

    public void setNazivRadSer(String nazivRadSer) {
        this.nazivRadSer = nazivRadSer;
    }

    public String getNazivRadEn() {
        return nazivRadEn;
    }

    public void setNazivRadEn(String nazivRadEn) {
        this.nazivRadEn = nazivRadEn;
    }

    public String getRadPredmet() {
        return radPredmet;
    }

    public void setRadPredmet(String radPredmet) {
        this.radPredmet = radPredmet;
    }

    public String getRadSadrzaj() {
        return radSadrzaj;
    }

    public void setRadSadrzaj(String radSadrzaj) {
        this.radSadrzaj = radSadrzaj;
    }

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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getDatum1() {
        return datum1;
    }

    public void setDatum1(Date datum1) {
        this.datum1 = datum1;
    }
    
    
    
   public String clan1(String username){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Korisnik where username='"+username+"'");
         List<Korisnik> listKor1=query.list();
         String ipKom1=listKor1.get(0).getIme()+" "+listKor1.get(0).getPrezime();
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return ipKom1;
      }
      public String clan2(String username){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Korisnik where username='"+username+"'");
         List<Korisnik> listKor2=query.list();
         String ipKom2=listKor2.get(0).getIme()+" "+listKor2.get(0).getPrezime();
          session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return ipKom2;
      }
      
      public String sluzba(String username){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Korisnik where username='"+username+"'");
         List<Korisnik> listKor1=query.list();
         String ipSluzba=listKor1.get(0).getIme()+" "+listKor1.get(0).getPrezime();
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return ipSluzba; 
      }
      
      public String studentPri(int prijava){
           Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Korisnik where username in (select idStudent from Prijava where idPrijava="+prijava+")");
         List<Korisnik> listKor2=query.list();
         String imePrezimeStudentaPrijave=listKor2.get(0).getIme()+" "+listKor2.get(0).getPrezime();
          session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return imePrezimeStudentaPrijave;
      }
      
      
      public String ocena(Sastanak sastanak){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Prijava where idPrijava="+sastanak.getIdPrijava());
         List<Prijava> listPrijava=query.list();
         Prijava prijava=listPrijava.get(0);
         
         if (prijava.getRukIliProf()==1){
         rukovodilac=true;
         mentorRada=false;
        }
        else {
         rukovodilac=false;
         mentorRada=true;
        }
        bioText=prijava.getBiografija();
        query=session.createQuery("from Korisnik where username='"+prijava.getIdStudent()+"'");
        List<Korisnik> listSt=new ArrayList<>();
        listSt=query.list();
        ipStudent=listSt.get(0).getIme()+" "+listSt.get(0).getPrezime();
        String ind=listSt.get(0).getUsername().substring(2, 8);
        if (Integer.parseInt(ind.substring(0, 2))>=0 && Integer.parseInt(ind.substring(0, 2))<=21) indexStudent="20"+ind.substring(0,2);
        else indexStudent="19"+ind.substring(0,2);
        indexStudent+="/"+ind.substring(2);
        query=session.createQuery("from Modul where idModul in (select idModul from Student where username='"+prijava.getIdStudent()+"')");
        List<Modul> listMod=new ArrayList<>();
        listMod=query.list();
        nazivModula=listMod.get(0).getNaziv();
         FacesContext context = FacesContext.getCurrentInstance();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        httpSession.setAttribute("prijava", prijava);
        httpSession.setAttribute("sastanak", sastanak);
        query=session.createQuery("from Korisnik where username='"+prijava.getIdRukovodilac()+"'");
        List<Korisnik> listRuk=query.list();
        Korisnik rukovodila=listRuk.get(0);
        ipRuk=rukovodila.getIme()+" "+rukovodila.getPrezime();
        query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        nazivRadSer=listRad.get(0).getNazivS();
        nazivRadEn=listRad.get(0).getNazivE();
        radPredmet=listRad.get(0).getPredmet();
        radSadrzaj=listRad.get(0).getSadrzaj();
        query=session.createQuery("from Korisnik where username in (select username from Mentor where username='"+prijava.getIdMentor()+"')");
        List<Korisnik> listMent=new ArrayList<>();
        listMent=query.list();
        ipMentor=listMent.get(0).getIme()+" "+listMent.get(0).getPrezime();
        query=session.createQuery("from Predmet where idPredmet="+prijava.getIdPredmet()+"");
        List<Predmet> listPredmet=new ArrayList<>();
        listPredmet=query.list();
        nazivPredmeta=listPredmet.get(0).getNaziv();
        query=session.createQuery("from Korisnik where username='"+sastanak.getIdUprava1()+"'");
        List<Korisnik> korList=query.list();
        ipKomisija1=korList.get(0).getIme()+" "+korList.get(0).getPrezime();
        query=session.createQuery("from Korisnik where username='"+sastanak.getIdUprava2()+"'");
        korList=query.list();
        ipKomisija2=korList.get(0).getIme()+" "+korList.get(0).getPrezime();
        datum=sastanak.getDatum();
        Calendar cal=Calendar.getInstance();
        datum1=cal.getTime();
        //SimpleDateFormat formt=new SimpleDateFormat("yyyy-mm-dd");
       // datum1=formt.format(cal.getTime());
        session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         
        return "pregledPrijaveUprava";
    }
      
       public void boxa(ValueChangeEvent e){
         if (odbija==true || sugerisi==true){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Једна од тих опција мора бити означена!"));
     }
     }
     public void boxb(ValueChangeEvent e){
         if (prihvata==true || sugerisi==true){
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Једна од тих опција мора бити означена!"));
         }
     }
     public void boxc(ValueChangeEvent e){
         if (prihvata==true || odbija==true){
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Једна од тих опција мора бити означена!"));
         }
     }
     public String izmeni(){
         
         FacesContext context = FacesContext.getCurrentInstance();
         if (sugerisi==false && prihvata==false && odbija==false && sugestija.isEmpty()){
             context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Нисте изабрали једну од опција нити сте попунили сугестију!"));
             return "pregledPrijaveUprava";
         }
         if (sugerisi==true && sugestija.isEmpty()){
             context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Нисте попунили сугестију!"));
             return "pregledPrijaveUprava";
         }
         if (sugerisi==true) {
              for(int i = 0; i < sugestija.length(); i++) {
             if(!(Character.UnicodeBlock.of(sugestija.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(sugestija.charAt(i))) || (Character.UnicodeBlock.of(sugestija.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Сугестија није написана ћирилицом!"));
                 return "pregledPrijaveUprava";
             }
            }
         }
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
         Sastanak sastanak=(Sastanak) httpSession.getAttribute("sastanak");
         sastanak.setOdrzan(1);
         session.update(sastanak);
         
         if (prihvata==true)
            prijava.setPrihvata(1);
         if (odbija==true)
           prijava.setPrihvata(2);
         if (sugerisi==true){
             
             prijava.setPrihvata(3);
             prijava.setSugestija(sugestija);
         }
         prijava.setDatumS(datum1);
         session.update(prijava);
         
            
        Query query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        Masterrad rad=listRad.get(0);
            Calendar cal=Calendar.getInstance();
            Date d=cal.getTime();
        //public VerzijaPrijave(int idPrijava, Date datumVer, String idStudent, 
        //String idMentor, String idMentorZ, int idRad, String nazivS, 
        //String nazivE, String predmet, String sadrzaj, Integer idPredmet,
        //int rukIliProf, String biografija, String idRukRada, String idKom1,
        //String idKom2, Date datum)
     
        VerzijaPrijave verzija=new VerzijaPrijave(prijava.getIdPrijava(), d, d,
                prijava.getIdStudent(), prijava.getIdMentor(), prijava.getIdMentorZ(),prijava.getIdRukovodilac(),
                rad.getIdRad(), rad.getNazivS(), rad.getNazivE(), rad.getPredmet(),
                rad.getSadrzaj(), prijava.getIdPredmet(), prijava.getRukIliProf(),
                prijava.getBiografija(), prijava.getIdRukRada(), prijava.getIdKom1(), prijava.getIdKom2(),
                prijava.getDatum(), prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);  
         
         context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте попунили закључак."));
             
        httpSession.setAttribute("prijava", prijava);
        httpSession.setAttribute("sastanak", sastanak);
         Korisnik uprava=(Korisnik) httpSession.getAttribute("uprava");
         query=session.createQuery("from Sastanak where idUprava1='"+uprava.getUsername()+"' or idUprava2='"+uprava.getUsername()+"'");
         List<Sastanak> listaSastanaka=new ArrayList<>();
         listaSastanaka=query.list();
         httpSession.setAttribute("sastanci", listaSastanaka);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
        return "pregledPrijaveUprava";
     } 
      
}
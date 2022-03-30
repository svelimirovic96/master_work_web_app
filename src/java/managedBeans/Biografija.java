/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import beans.KomentariSluzbaStudent;
import beans.KomentariSluzbaStudentz;
import beans.KomentariStMent;
import beans.Korisnik;
import beans.Masterrad;
import beans.Predmet;
import beans.Prijava;
import beans.VerzijaPrijave;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
/**
 *
 * @author Sandra
 */
@ManagedBean(name = "biografija")
@SessionScoped
public class Biografija{
    private String bios, nazivPredmeta;
    private UIComponent messagePrijava_2;
    
    private UIComponent messagePrijava_3;

    public UIComponent getMessagePrijava_3() {
        return messagePrijava_3;
    }

    public void setMessagePrijava_3(UIComponent messagePrijava_3) {
        this.messagePrijava_3 = messagePrijava_3;
    }
    
    

    public UIComponent getMessagePrijava_2() {
        return messagePrijava_2;
    }

    public void setMessagePrijava_2(UIComponent messagePrijava_2) {
        this.messagePrijava_2 = messagePrijava_2;
    }

    
    
    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }
    private String cilj, sadrzaj;

    public String getBios() {
        return bios;
    }

    public void setBios(String biografija) {
        this.bios = biografija;
    }

    public String getCilj() {
        return cilj;
    }

    public void setCilj(String cilj) {
        this.cilj = cilj;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }
    
    public List<String> listaPredmeta(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<String> listaPredmeta=new ArrayList<>();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
        if (prijava.getIdPredmet()!=0) {
            Query query=session.createQuery("from Predmet where idPredmet='"+prijava.getIdPredmet()+"')");
            List<Predmet> predmetList=query.list();
            listaPredmeta.add(predmetList.get(0).getNaziv());
        
        }
        else {
            Korisnik student=(Korisnik) httpSession.getAttribute("student");
            Korisnik rukovodilac=(Korisnik) httpSession.getAttribute("mentor");
            Query query=session.createQuery("from Predmet where idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"' and idMentor='"+rukovodilac.getUsername()+"')");
            List<Predmet> predmetList=query.list();
            int i=0;
            while (i<predmetList.size()){
                listaPredmeta.add(predmetList.get(i).getNaziv());
                i++;
            }
            }
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
        return listaPredmeta;
    }
    public String bioprovera(){
          
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (bios.length()==0) {
            context.addMessage(messagePrijava_2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите биографију!"));
            return "biografija";
        } 
        for(int i = 0; i < bios.length(); i++) {
             if(!(Character.UnicodeBlock.of(bios.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(bios.charAt(i))) || (Character.UnicodeBlock.of(bios.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Биографија није написана ћирилицом!"));
                 return "biografija";
            }
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession sesija=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) sesija.getAttribute("prijava");
        prijava.setBiografija(bios);
        session.update(prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return "obrazlozenje";
    }
    
    public String obrProvera(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (cilj.length()==0) {
            context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите предмет, циљ и методе мастер рада!"));
            return "obrazlozenje";
        } 
         for(int i = 0; i < cilj.length(); i++) {
             if(!(Character.UnicodeBlock.of(cilj.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(cilj.charAt(i))) || (Character.UnicodeBlock.of(cilj.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Предмет, циљ и методе мастер рада нису написани ћирилицом!"));
                 return "obrazlozenje";
            }
        }
         if (sadrzaj.length()==0) {
            context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите садржај и очекивани резултати мастер!"));
            return "obrazlozenje";
        } 
          for(int i = 0; i < sadrzaj.length(); i++) {
             if(!(Character.UnicodeBlock.of(sadrzaj.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(sadrzaj.charAt(i))) || (Character.UnicodeBlock.of(sadrzaj.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Садржај и очекивани резултати мастер рада нису написани ћирилицом!"));
                 return "obrazlozenje";
            }
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession sesija=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) sesija.getAttribute("prijava");
        Korisnik student=(Korisnik) sesija.getAttribute("student");
        if (prijava.getIdPredmet()==0) {
            Query query=session.createQuery("from Predmet where naziv='"+nazivPredmeta+"' and idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')");
            List<Predmet> predmetList=query.list();
            prijava.setIdPredmet(predmetList.get(0).getIdPredmet());
        }
        Masterrad rad=(Masterrad) sesija.getAttribute("masterRad");
        rad.setPredmet(cilj);
        rad.setSadrzaj(sadrzaj);
        session.update(rad);
        prijava.setIdRad(rad.getIdRad());
        session.update(prijava);
        Calendar cal=Calendar.getInstance();
        Date d=cal.getTime();
        //public VerzijaPrijave(int idPrijava, Date datumVer, String idStudent, 
        //String idMentor, String idMentorZ, int idRad, String nazivS, 
        //String nazivE, String predmet, String sadrzaj, Integer idPredmet,
        //int rukIliProf, String biografija, String idRukRada, String idKom1,
        //String idKom2, Date datum)
     
        VerzijaPrijave verzija=new VerzijaPrijave(prijava.getIdPrijava(), d, d,
                prijava.getIdStudent(), prijava.getIdMentor(), prijava.getIdMentorZ(), prijava.getIdRukovodilac(),
                rad.getIdRad(), rad.getNazivS(), rad.getNazivE(), rad.getPredmet(),
                rad.getSadrzaj(), prijava.getIdPredmet(), prijava.getRukIliProf(),
                prijava.getBiografija(), prijava.getIdRukRada(), prijava.getIdKom1(), prijava.getIdKom2(),
                prijava.getDatum(),prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);
        String naslov=rad.getNazivS();  //deklarisati
        String radPredmet=rad.getPredmet(); //deklarisati
        String radSadrzaj=rad.getSadrzaj(); //deklarisati
        Query query=session.createQuery("from Predmet where idPredmet="+prijava.getIdPredmet()+"");
        List<Predmet> listPredmeta=query.list();
        String naslovPredmeta=listPredmeta.get(0).getNaziv(); //deklarisati
        query=session.createQuery("from KomentariStMent where idPrijava="+prijava.getIdPrijava()+"");
        List<KomentariStMent> listaKomentara=query.list();
        query=session.createQuery("from KomentariSluzbaStudent where idStudent='"+student.getUsername()+"' and idRukToSluzba in (select idRukToSluzba from Ruktosluzba where idMentToRuk in (select idMentToRuk from Menttoruk where idPrijava="+prijava.getIdPrijava()+"))");
        List<KomentariSluzbaStudent> listaKomentara1=query.list(); //deklarisati
        query=session.createQuery("from KomentariSluzbaStudentz where idStudent='"+student.getUsername()+"' and idZamToSluzba in (select idZamToSluzba from Zamtosluzba where idMentToZam in (select idMentToZam from Menttozam where idPrijava="+prijava.getIdPrijava()+"))");
        List<KomentariSluzbaStudentz> listaKomentara2=query.list(); //deklarisati
        sesija.setAttribute("naslov", naslov);
        sesija.setAttribute("radPredmet", radPredmet);
        sesija.setAttribute("radSadrzaj", radSadrzaj);
        sesija.setAttribute("naslovPredmeta", naslovPredmeta);
        sesija.setAttribute("listaKomentara", listaKomentara);
        sesija.setAttribute("listaKomentara1", listaKomentara1);
        sesija.setAttribute("listaKomentara2", listaKomentara2);
        String statusPrijave="Успешно послата пријава";
        sesija.setAttribute("statusPrijave", statusPrijave); 
        query=session.createQuery("from VerzijaPrijave where idPrijava="+prijava.getIdPrijava()+" and idStudent='"+student.getUsername()+"'  order by datumVer desc, vremeVer desc");
                List<VerzijaPrijave> listVerzija=query.list();
                sesija.setAttribute("verzije", listVerzija);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return "podesiti_prijavu";
    }
   /* public void createPDF(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession sesija=(HttpSession) context.getExternalContext().getSession(true);
        String url="http://localhost:8080/Master2021/student.xhtml;jsessionid="+sesija.getId()+"?pdf=true";
        try{
            ITextRenderer rend=new ITextRenderer();
            rend.setDocument(new URL(url).toString());
            rend.layout();
            HttpServletResponse response=(HttpServletResponse) context.getExternalContext().getResponse();
            response.reset();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition","inline; filename=\"student.pdf\"");
            OutputStream output=response.getOutputStream();
            rend.createPDF(output);
        } catch(Exception ex) {ex.printStackTrace();}
        context.renderResponse();
    }*/
}

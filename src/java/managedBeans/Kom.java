/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import beans.KomentariMentRuk;
import beans.KomentariMentZam;
import beans.KomentariSluzbaMentor;
import beans.KomentariSluzbaStudent;
import beans.KomentariSluzbaStudentz;
import beans.KomentariSluzbaZamenik;
import beans.KomentariStMent;
import beans.Korisnik;
import beans.Masterrad;
import beans.Menttoruk;
import beans.Menttozam;
import beans.Modul;
import beans.Predaje;
import beans.Predmet;
import beans.Prijava;
import beans.Ruktosluzba;
import beans.Sastanak;
import beans.VerzijaPrijave;
import beans.Zamtosluzba;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Sandra
 */
@ManagedBean(name = "kom")
@SessionScoped
public class Kom {
    private String ipStudent, ipMentor, ipRuk;
    private String indexStudent;
    private Prijava prijava;
    private UIComponent messageImaKomentara;
    private List<KomentariSluzbaStudent> listaKomentara1=new ArrayList<>();
    private List<KomentariSluzbaStudentz> listaKomentara2=new ArrayList<>();
    private List<KomentariStMent> listaKomentara=new ArrayList<>();
    private String naslov;
    private String naslovPredmeta;
    private List<String> mentorList; 
    private List<String> listaPredmeta;
    private String temaEngleski;
    private String radPredmet;
    private String radSadrzaj;
    private UIComponent messagePrijava_1, messagePrijava_2, messagePrijava_3;
    private UIComponent messagePrijava_1a, messagePrijava_3a;
    
    private String sugestija, nazivModula, nazivPredmeta, bioText, nazivRadSer, nazivRadEn, nazivPredmeta1;
    private boolean rukovodilac, mentorRada, prihvata, odbija, sugerisi;
    private String ipZamenik, ipMentor1;
    private String ipKom1, ipKom2, ipRukRad;
    private Date datum, datum2;

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

    public Date getDatum2() {
        return datum2;
    }

    public void setDatum2(Date datum2) {
        this.datum2 = datum2;
    }

    
    
    public UIComponent getMessagePrijava_1a() {
        return messagePrijava_1a;
    }

    public void setMessagePrijava_1a(UIComponent messagePrijava_1a) {
        this.messagePrijava_1a = messagePrijava_1a;
    }

    public UIComponent getMessagePrijava_3a() {
        return messagePrijava_3a;
    }

    public void setMessagePrijava_3a(UIComponent messagePrijava_3a) {
        this.messagePrijava_3a = messagePrijava_3a;
    }

    
    
    public UIComponent getMessagePrijava_1() {
        return messagePrijava_1;
    }

    public void setMessagePrijava_1(UIComponent messagePrijava_1) {
        this.messagePrijava_1 = messagePrijava_1;
    }

    public UIComponent getMessagePrijava_2() {
        return messagePrijava_2;
    }

    public void setMessagePrijava_2(UIComponent messagePrijava_2) {
        this.messagePrijava_2 = messagePrijava_2;
    }

    public UIComponent getMessagePrijava_3() {
        return messagePrijava_3;
    }

    public void setMessagePrijava_3(UIComponent messagePrijava_3) {
        this.messagePrijava_3 = messagePrijava_3;
    }

    
    
    public String getIpMentor1() {
        return ipMentor1;
    }

    public void setIpMentor1(String ipMentor1) {
        this.ipMentor1 = ipMentor1;
    }

    
    
    public String getNazivPredmeta1() {
        return nazivPredmeta1;
    }

    public void setNazivPredmeta1(String nazivPredmeta1) {
        this.nazivPredmeta1 = nazivPredmeta1;
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

    public String getIpRukRad() {
        return ipRukRad;
    }

    public void setIpRukRad(String ipRukRad) {
        this.ipRukRad = ipRukRad;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    
    
    public String getIpStudent() {
        return ipStudent;
    }

    public void setIpStudent(String ipStudent) {
        this.ipStudent = ipStudent;
    }

    public String getIpRuk() {
        return ipRuk;
    }

    public void setIpRuk(String ipRuk) {
        this.ipRuk = ipRuk;
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

    public String getIpZamenik() {
        return ipZamenik;
    }

    public void setIpZamenik(String ipZamenik) {
        this.ipZamenik = ipZamenik;
    }
    
    

    public List<KomentariSluzbaStudentz> getListaKomentara2() {
        return listaKomentara2;
    }

    public void setListaKomentara2(List<KomentariSluzbaStudentz> listaKomentara2) {
        this.listaKomentara2 = listaKomentara2;
    }

    
    
    public List<KomentariSluzbaStudent> getListaKomentara1() {
        return listaKomentara1;
    }

    public void setListaKomentara1(List<KomentariSluzbaStudent> listaKomentara1) {
        this.listaKomentara1 = listaKomentara1;
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

    
    
    public String getTemaEngleski() {
        return temaEngleski;
    }

    public void setTemaEngleski(String temaEngleski) {
        this.temaEngleski = temaEngleski;
    }

    
    
    
    public List<String> getListaPredmeta() {
        return listaPredmeta;
    }

    public void setListaPredmeta(List<String> listaPredmeta) {
        this.listaPredmeta = listaPredmeta;
    }

    public List<String> getMentorList() {
        return mentorList;
    }

    public void setMentorList(List<String> mentorList) {
        this.mentorList = mentorList;
    }

    
    public String getIpMentor() {
        return ipMentor;
    }

    public void setIpMentor(String ipMentor) {
        this.ipMentor = ipMentor;
    }

    
    
    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovPredmeta() {
        return naslovPredmeta;
    }

    public void setNaslovPredmeta(String naslovPredmeta) {
        this.naslovPredmeta = naslovPredmeta;
    }

    public Prijava getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }

    public UIComponent getMessageImaKomentara() {
        return messageImaKomentara;
    }

    public void setMessageImaKomentara(UIComponent messageImaKomentara) {
        this.messageImaKomentara = messageImaKomentara;
    }

    public List<KomentariStMent> getListaKomentara() {
        return listaKomentara;
    }

    public void setListaKomentara(List<KomentariStMent> listaKomentara) {
        this.listaKomentara = listaKomentara;
    }
    
    
    /*public String pregled(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Korisnik student=(Korisnik) httpSession.getAttribute("student");
        Query query=session.createQuery("from Prijava where idStudent='"+student.getUsername()+"'");
        List<Prijava> listPrijava=query.list();
        prijava=listPrijava.get(0);
        query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRad=query.list();
        naslov=listRad.get(0).getNazivS();
        radPredmet=listRad.get(0).getPredmet();
        radSadrzaj=listRad.get(0).getSadrzaj();
        query=session.createQuery("from Predmet where idPredmet="+prijava.getIdPredmet()+"");
        List<Predmet> listPredmeta=query.list();
        naslovPredmeta=listPredmeta.get(0).getNaziv();
        query=session.createQuery("from KomentariStMent where idPrijava="+prijava.getIdPrijava()+"");
        listaKomentara=query.list();
        query=session.createQuery("from KomentariSluzbaStudent where idStudent='"+student.getUsername()+"' and idRukToSluzba in (select idRukToSluzba from Ruktosluzba where idMentToRuk in (select idMentToRuk from Menttoruk where idPrijava="+prijava.getIdPrijava()+"))");
        listaKomentara1=query.list();
        query=session.createQuery("from KomentariSluzbaStudentz where idStudent='"+student.getUsername()+"' and idZamToSluzba in (select idZamToSluzba from Zamtosluzba where idMentToZam in (select idMentToZam from Menttozam where idPrijava="+prijava.getIdPrijava()+"))");
        listaKomentara2=query.list();
       query=session.createQuery("from VerzijaPrijave where idPrijava="+prijava.getIdPrijava()+" and idStudent='"+student.getUsername()+"'");
       List<VerzijaPrijave> listVerzija=query.list();
        httpSession.setAttribute("verzije", listVerzija);
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "podesiti_prijavu";
    }*/
    
    public String mentor(String username){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username='"+username+"'");
        List<Korisnik> listMentor=query.list();
        Korisnik mentor=listMentor.get(0);
        ipMentor=mentor.getIme()+" "+mentor.getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    
        }
        return ipMentor;
    }
    public String sluzbenik(KomentariSluzbaStudent kom){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select idSluzba from Ruktosluzba where idRuktosluzba="+kom.getIdRukToSluzba()+")");
        List<Korisnik> listStudent=query.list();
        Korisnik student=listStudent.get(0);
        String imePreStudent=student.getIme()+" "+student.getPrezime();
        if (session != null && session.isOpen()) {
        session.close();
    
        }
        return imePreStudent;
    }
    
    public String sluzbenik2(KomentariSluzbaStudentz kom){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select idSluzba from Zamtosluzba where idZamtosluzba="+kom.getIdZamToSluzba()+")");
        List<Korisnik> listStudent=query.list();
        Korisnik student=listStudent.get(0);
        String imePreStudent=student.getIme()+" "+student.getPrezime();
        if (session != null && session.isOpen()) {
        session.close();
    
        }
        return imePreStudent;
    }
    
    
    public String odustani(){
       FacesContext context = FacesContext.getCurrentInstance();
       HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(false);
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       Korisnik student=(Korisnik) httpSession.getAttribute("student");
       Query query=session.createQuery("from Prijava where idStudent='"+student.getUsername()+"'");
       List<Prijava> listPrijava=query.list();
       Prijava prijava=listPrijava.get(0);
       query=session.createQuery("from Masterrad where idRad in (select idRad from Prijava where idPrijava="+prijava.getIdPrijava()+")");
       List<Masterrad> listRadova=query.list();
       Masterrad rad=listRadova.get(0);
       session.delete(rad);
       
       
       //brisati zamtosluzba,ruktosluzba,menttozam,menttoruk,komentari_st_ment,komentari_ment_ruk 
       //komentari_ment_zam, komentari_sluzba_mentor, komentari_sluzba_student, komentari_sluzba_studentz
       //komentari_sluzba_zamenik, sastanak
       query=session.createQuery("from Sastanak where idPrijava="+prijava.getIdPrijava());
       List<Sastanak> listSastanaka=query.list();
       while (!listSastanaka.isEmpty()){
       
		Sastanak sas=listSastanaka.remove(0);
		session.delete(sas);
       }
       	   query=session.createQuery("from KomentariStMent where idPrijava="+prijava.getIdPrijava()+"");
       List<KomentariStMent> listKomStMent=query.list();
       while (!listKomStMent.isEmpty()){
		KomentariStMent komStMent=listKomStMent.remove(0);
		session.delete(komStMent);
	   }
	   
	   query=session.createQuery("from Menttoruk where idPrijava="+prijava.getIdPrijava()+"");
       List<Menttoruk> listMR=query.list();
	   while (!listMR.isEmpty()){
			Menttoruk menttoruk=listMR.remove(0);
			query=session.createQuery("from KomentariMentRuk where idMentToRuk="+menttoruk.getIdMentToRuk()+"");
			List<KomentariMentRuk> listKomMentRuk=query.list();
			while (!listKomMentRuk.isEmpty()){
				KomentariMentRuk komMentRuk=listKomMentRuk.remove(0);
				session.delete(komMentRuk);
			}
			query=session.createQuery("from Ruktosluzba where idMentToRuk="+menttoruk.getIdMentToRuk()+"");
		    List<Ruktosluzba> listRS=query.list();
			while (!listRS.isEmpty()){
				Ruktosluzba ruktosluzba=listRS.remove(0);
				query=session.createQuery("from KomentariSluzbaMentor where idRukToSluzba="+ruktosluzba.getIdRukToSluzba()+"");
				List<KomentariSluzbaMentor> listKomSlMent=query.list();
				while (!listKomSlMent.isEmpty()){
					KomentariSluzbaMentor komSlMent=listKomSlMent.remove(0);
					session.delete(komSlMent);
				}
       
				query=session.createQuery("from KomentariSluzbaStudent where idRukToSluzba="+ruktosluzba.getIdRukToSluzba()+"");
				List<KomentariSluzbaStudent> listKomSlStudent=query.list();
				while (!listKomSlStudent.isEmpty()){
					KomentariSluzbaStudent komSlStudent=listKomSlStudent.remove(0);
					session.delete(komSlStudent);
				}
				
				session.delete(ruktosluzba);
			}
			
			session.delete(menttoruk);
		}
			
       query=session.createQuery("from Menttozam where idPrijava="+prijava.getIdPrijava()+"");
       List<Menttozam> listMZ=query.list();
	   while (!listMZ.isEmpty()){
			Menttozam menttozam=listMZ.remove(0);
            query=session.createQuery("from KomentariMentZam where idMentToZam="+menttozam.getIdMentToZam()+"");
			List<KomentariMentZam> listKomMentZam=query.list();
			while (!listKomMentZam.isEmpty()){
				KomentariMentZam komMentZam=listKomMentZam.remove(0);
				session.delete(komMentZam);
			}
			query=session.createQuery("from Zamtosluzba where idMentToZam="+menttozam.getIdMentToZam()+"");
			List<Zamtosluzba> listZS=query.list();
			while (!listZS.isEmpty()){
				Zamtosluzba zamtosluzba=listZS.remove(0);
				
				query=session.createQuery("from KomentariSluzbaZamenik where idZamToSluzba="+zamtosluzba.getIdZamToSluzba()+"");
				List<KomentariSluzbaZamenik> listKomSlZamenik=query.list();
				while (!listKomSlZamenik.isEmpty()){
					KomentariSluzbaZamenik komSlZamenik=listKomSlZamenik.remove(0);
					session.delete(komSlZamenik);
				}
       
				query=session.createQuery("from KomentariSluzbaStudentz where idZamToSluzba="+zamtosluzba.getIdZamToSluzba()+"");
				List<KomentariSluzbaStudentz> listKomSlStudentz=query.list();
				while (!listKomSlStudentz.isEmpty()){
					KomentariSluzbaStudentz komSlStudentz=listKomSlStudentz.remove(0);
					session.delete(komSlStudentz);
				}
				
				session.delete(zamtosluzba);
			}
			
			session.delete(menttozam);
	   }
      
       query=session.createQuery("from VerzijaPrijave where idPrijava="+prijava.getIdPrijava()+"");
        List<VerzijaPrijave> listVerzija=query.list();
				while (!listVerzija.isEmpty()){
					VerzijaPrijave verzija=listVerzija.remove(0);
					session.delete(verzija);
				}			
       session.delete(prijava);
       session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
       httpSession.invalidate();
       return "index";
    }
    
   public String pregVer(VerzijaPrijave verzija){
       FacesContext context = FacesContext.getCurrentInstance();
       HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(false);
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       prihvata=odbija=sugerisi=false;
       if (verzija.getPrihvata()!=null){
         if (verzija.getPrihvata()==1)
            prihvata=true;
        if (verzija.getPrihvata()==2)
         odbija=true;
        if (verzija.getPrihvata()==3)
            sugerisi=true;
       }
       if (verzija.getSugestija()!=null)
        sugestija=verzija.getSugestija();
       else sugestija="";
        datum2=verzija.getDatumS();
       if (verzija.getRukIliProf()==1){
         rukovodilac=true;
         mentorRada=false;
         nazivPredmeta1="";
         Query query1=session.createQuery("from Predmet where idPredmet="+verzija.getIdPredmet()+"");
         List<Predmet> listPredmet=new ArrayList<>();
         listPredmet=query1.list();
         nazivPredmeta=listPredmet.get(0).getNaziv();
        }
        else {
         rukovodilac=false;
         mentorRada=true;
         Query query1=session.createQuery("from Predmet where idPredmet="+verzija.getIdPredmet()+"");
         List<Predmet> listPredmet=new ArrayList<>();
         listPredmet=query1.list();
         nazivPredmeta1=nazivPredmeta=listPredmet.get(0).getNaziv();
        }
        bioText=verzija.getBiografija();
        Query query=session.createQuery("from Korisnik where username='"+verzija.getIdStudent()+"'");
        List<Korisnik> listSt=query.list();
        Korisnik student=listSt.get(0);
        ipStudent=student.getIme()+" "+student.getPrezime();
        String ind=student.getUsername().substring(2, 8);
        if (Integer.parseInt(ind.substring(0, 2))>=0 && Integer.parseInt(ind.substring(0, 2))<=21) indexStudent="20"+ind.substring(0,2);
        else indexStudent="19"+ind.substring(0,2);
        indexStudent+="/"+ind.substring(2);
        query=session.createQuery("from Modul where idModul in (select idModul from Student where username='"+student.getUsername()+"')");
        List<Modul> listMod=new ArrayList<>();
        listMod=query.list();
        nazivModula=listMod.get(0).getNaziv();
        query=session.createQuery("from Korisnik where username='"+verzija.getIdMentor()+"'");
        List<Korisnik> listMent=query.list();
        Korisnik mentor=listMent.get(0);
        ipMentor=mentor.getIme()+" "+mentor.getPrezime();
        nazivRadSer=verzija.getNazivS();
        nazivRadEn=verzija.getNazivE();
        radPredmet=verzija.getPredmet();
        radSadrzaj=verzija.getSadrzaj();
        query=session.createQuery("from Korisnik where username='"+verzija.getIdRukovodilac()+"'");
        List<Korisnik> listRuk=new ArrayList<>();
        listRuk=query.list();
        ipRuk=listRuk.get(0).getIme()+" "+listRuk.get(0).getPrezime();
       
        if (verzija.getIdRukRada()!=null){
            query=session.createQuery("from Korisnik where username='"+verzija.getIdRukRada()+"'");
            List<Korisnik> listRukRada=new ArrayList<>();
            listRukRada=query.list();
            ipRukRad=listRukRada.get(0).getIme()+" "+listRukRada.get(0).getPrezime();
        }
        else ipRukRad="";
        if (verzija.getIdKom1()!=null){
            query=session.createQuery("from Korisnik where username='"+verzija.getIdKom1()+"'");
            List<Korisnik> listKom1=new ArrayList<>();
            listKom1=query.list();
            ipKom1=listKom1.get(0).getIme()+" "+listKom1.get(0).getPrezime();
        }
        else ipKom1="";
        if (verzija.getIdKom2()!=null){
            query=session.createQuery("from Korisnik where username='"+verzija.getIdKom2()+"'");
            List<Korisnik> listKom2=new ArrayList<>();
            listKom2=query.list();
            ipKom2=listKom2.get(0).getIme()+" "+listKom2.get(0).getPrezime();
        }
        else ipKom2="";
        datum=verzija.getDatum();
       session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "verzijaKodStudenta";
   }
    
    public String izmeni(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        session.beginTransaction();
        Korisnik student=(Korisnik) httpSession.getAttribute("student");
        prijava=(Prijava) httpSession.getAttribute("prijava");
        String username=student.getUsername();
        String ind=username.substring(2, 8);
        if (Integer.parseInt(ind.substring(0, 2))>=0 && Integer.parseInt(ind.substring(0, 2))<=21) indexStudent="20"+ind.substring(0,2);
        else indexStudent="19"+ind.substring(0,2);
        indexStudent+="/"+ind.substring(2);
        Query query=session.createQuery("from Modul where idModul in (select idModul from Student where username='"+username+"')");
        List<Modul> listaModula=query.list();
        nazivModula=listaModula.get(0).getNaziv();
        query=session.createQuery("from Korisnik where username in "
                + "(select idMentor from Predaje where idPredmet in "
                + "(select idPredmet from Predmet where idModul=(select idModul from Modul"
                + " where naziv='"+nazivModula+"') and idStudent='"+username+"'))");
        List<Korisnik> listMent=query.list();
        mentorList=new ArrayList<>();
            int i=0;
            while (i<listMent.size()){
                mentorList.add(listMent.get(i).getIme()+" "+listMent.get(i).getPrezime());
                i++;
            }
        query=session.createQuery("from Korisnik where username='"+prijava.getIdMentor()+"'");
        List<Korisnik> listMent1=query.list();
        Korisnik mentor=listMent1.get(0);
        ipMentor1=ipMentor=mentor.getIme()+" "+mentor.getPrezime();
         query=session.createQuery("from Predmet where idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')");
        List<Predmet> predmetList=query.list();
        i=0;
        listaPredmeta=new ArrayList<>();
        while (i<predmetList.size()){
            listaPredmeta.add(predmetList.get(i).getNaziv());
            i++;
        }
        
        prijava=(Prijava) httpSession.getAttribute("prijava");
        query=session.createQuery("from Predmet where idPredmet="+prijava.getIdPredmet()+" and idModul in (select idModul from Student where username='"+prijava.getIdStudent()+"')");
        predmetList=query.list();
        nazivPredmeta1=nazivPredmeta=predmetList.get(0).getNaziv();
        query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> radovi=query.list();
        query=session.createQuery("from Korisnik where username='"+prijava.getIdRukovodilac()+"'");
        List<Korisnik> listRuk=query.list();
        ipRuk=listRuk.get(0).getIme()+" "+listRuk.get(0).getPrezime();
        nazivRadSer=radovi.get(0).getNazivS();
        nazivRadEn=radovi.get(0).getNazivE();
        radPredmet=radovi.get(0).getPredmet();
        radSadrzaj=radovi.get(0).getSadrzaj();
        bioText=prijava.getBiografija();
        if (prijava.getRukIliProf()==1){
         rukovodilac=true;
         mentorRada=false;
        }
        else {
         rukovodilac=false;
         mentorRada=true;
        }
        prihvata=odbija=sugerisi=false;
        if (prijava.getPrihvata()!=null){
         if (prijava.getPrihvata()==1)
            prihvata=true;
        if (prijava.getPrihvata()==2)
         odbija=true;
        if (prijava.getPrihvata()==3)
            sugerisi=true;
        }
        if (prijava.getSugestija()!=null) sugestija=prijava.getSugestija();
        else sugestija="";
        datum2=prijava.getDatumS();
        if (prijava.getIdRukRada()!=null){
            query=session.createQuery("from Korisnik where username='"+prijava.getIdRukRada()+"'");
            List<Korisnik> listRukRada=new ArrayList<>();
            listRukRada=query.list();
            ipRukRad=listRukRada.get(0).getIme()+" "+listRukRada.get(0).getPrezime();
        }
        else ipRukRad="";
        if (prijava.getIdKom1()!=null){
            query=session.createQuery("from Korisnik where username='"+prijava.getIdKom1()+"'");
            List<Korisnik> listKom1=new ArrayList<>();
            listKom1=query.list();
            ipKom1=listKom1.get(0).getIme()+" "+listKom1.get(0).getPrezime();
        }
        else ipKom1="";
        if (prijava.getIdKom2()!=null){
            query=session.createQuery("from Korisnik where username='"+prijava.getIdKom2()+"'");
            List<Korisnik> listKom2=new ArrayList<>();
            listKom2=query.list();
            ipKom2=listKom2.get(0).getIme()+" "+listKom2.get(0).getPrezime();
        }
        else ipKom2="";
        datum=prijava.getDatum();
         session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    
        }
        return "student_izmena_1";
    }
    
    public void box1(ValueChangeEvent e){
         if (mentorRada==true){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Један од тих опција мора бити означена!"));
     }
     }
     public void box2(ValueChangeEvent e){
         if (rukovodilac==true){
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Један од тих опција мора бити означена!"));
         }
     }
    
    public void change_Mentor(ValueChangeEvent e){
        ipMentor=e.getNewValue().toString();
        ipMentor1=e.getNewValue().toString();
    }
    
    public String proveri1(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (nazivRadSer.length()==0) {
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите наслов мастер рада на српском језику!"));
            return "student_izmena_1";
        } 
        
        for(int i = 0; i < nazivRadSer.length(); i++) {
             if(!(Character.UnicodeBlock.of(nazivRadSer.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(nazivRadSer.charAt(i))) || (Character.UnicodeBlock.of(nazivRadSer.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Наслов теме на српском језику није написан ћирилицом!"));
                 return "student_izmena_1";
            }
        }
        if (nazivRadEn.length()==0){
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите наслов мастер рада на енглеском језику!"));
            return "student_izmena_1";
        }
        for(int i = 0; i < nazivRadEn.length(); i++) {
             if(!((Character.isWhitespace(nazivRadEn.charAt(i))) || (Character.UnicodeBlock.of(nazivRadEn.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Наслов теме на енглеском језику није написан латиницом!"));
                 return "student_izmena_1";
            }
        }
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession sesija=(HttpSession) context.getExternalContext().getSession(false);
        Korisnik student=(Korisnik) sesija.getAttribute("student");
        prijava=(Prijava) sesija.getAttribute("prijava");
        int index=0;
        String ment=ipMentor;
        while (!Character.isWhitespace(ment.charAt(index))) index++;
        String imeMentora=ment.substring(0, index);
        ment=ipMentor;
        String prezimeMentora=ment.substring(index+1);
        boolean ruk=false;
        Query query=session.createQuery("from Korisnik where ime='"+imeMentora+"' and prezime='"+prezimeMentora+"' and username in (select username from Mentor) and username in (select username from RukovodilacModula where idModul in (select idModul from Predmet where idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')))");
        List<Korisnik> korisnici=query.list();
        if (!korisnici.isEmpty() && mentorRada) {
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Изабрани руководилац модула није добро означен!"));
            if (session != null && session.isOpen()) {
            session.close();
        }
            
            return "student_izmena_1";
        }
        else if (!korisnici.isEmpty()) {ruk=true; /*nazivPredmeta="";*/}
        query=session.createQuery("from Korisnik where ime='"+imeMentora+"' and prezime='"+prezimeMentora+"' and username in (select username from Mentor)");
        korisnici=query.list();
        if (!korisnici.isEmpty() && rukovodilac && ruk==false){ 
             context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Изабрани професор није добро означен!"));
            if (session != null && session.isOpen()) {
            session.close();
        }
            
            return "student_izmena_1";
        }
        else if (!korisnici.isEmpty() && ruk==false){
            query=session.createQuery("from Predaje where idStudent='"+student.getUsername()+"' and idMentor='"+korisnici.get(0).getUsername()+"' and idPredmet in (select idPredmet from Predmet where naziv='"+nazivPredmeta+"')");
            List<Predaje> predmeti=query.list();
            if (predmeti.isEmpty()){
               context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Изаберите одговарајући предмет који Ваш професор држи!"));
              if (session != null && session.isOpen()) {
                 session.close();
            }
              
                 return "student_izmena_1"; 
        }
        }
        boolean izm1=false, izm2=false, izm3=false, izm4=false, izm5=false;
        if (!korisnici.get(0).getUsername().equals(prijava.getIdMentor())){
             query=session.createQuery("from KomentariStMent where idPrijava="+prijava.getIdPrijava()+" and idMentor='"+prijava.getIdMentor()+"'");
             List<KomentariStMent> listKomStMent=query.list();
             while (!listKomStMent.isEmpty()){
		KomentariStMent komStMent=listKomStMent.remove(0);
		session.delete(komStMent);
	   }
	   
	   query=session.createQuery("from Menttoruk where idPrijava="+prijava.getIdPrijava()+" and idMentor='"+prijava.getIdMentor()+"'");
           List<Menttoruk> listMR=query.list();
	   while (!listMR.isEmpty()){
			Menttoruk menttoruk=listMR.remove(0);
			query=session.createQuery("from KomentariMentRuk where idMentToRuk="+menttoruk.getIdMentToRuk()+"");
			List<KomentariMentRuk> listKomMentRuk=query.list();
			while (!listKomMentRuk.isEmpty()){
				KomentariMentRuk komMentRuk=listKomMentRuk.remove(0);
				session.delete(komMentRuk);
			}
			query=session.createQuery("from Ruktosluzba where idMentToRuk="+menttoruk.getIdMentToRuk()+"");
		    List<Ruktosluzba> listRS=query.list();
			while (!listRS.isEmpty()){
				Ruktosluzba ruktosluzba=listRS.remove(0);
				query=session.createQuery("from KomentariSluzbaMentor where idRukToSluzba="+ruktosluzba.getIdRukToSluzba()+"");
				List<KomentariSluzbaMentor> listKomSlMent=query.list();
				while (!listKomSlMent.isEmpty()){
					KomentariSluzbaMentor komSlMent=listKomSlMent.remove(0);
					session.delete(komSlMent);
				}
       
				query=session.createQuery("from KomentariSluzbaStudent where idRukToSluzba="+ruktosluzba.getIdRukToSluzba()+"");
				List<KomentariSluzbaStudent> listKomSlStudent=query.list();
				while (!listKomSlStudent.isEmpty()){
					KomentariSluzbaStudent komSlStudent=listKomSlStudent.remove(0);
					session.delete(komSlStudent);
				}
				
				session.delete(ruktosluzba);
			}
			
			session.delete(menttoruk);
		}
       if (prijava.getIdMentorZ()!=null){	
            query=session.createQuery("from Menttozam where idPrijava="+prijava.getIdPrijava()+" and idZam='"+prijava.getIdMentorZ()+"' and idMentor='"+prijava.getIdMentor()+"'");
            List<Menttozam> listMZ=query.list();
	    while (!listMZ.isEmpty()){
			Menttozam menttozam=listMZ.remove(0);
                        query=session.createQuery("from KomentariMentZam where idMentToZam="+menttozam.getIdMentToZam()+"");
			List<KomentariMentZam> listKomMentZam=query.list();
			while (!listKomMentZam.isEmpty()){
				KomentariMentZam komMentZam=listKomMentZam.remove(0);
				session.delete(komMentZam);
			}
			query=session.createQuery("from Zamtosluzba where idMentToZam="+menttozam.getIdMentToZam()+"");
			List<Zamtosluzba> listZS=query.list();
			while (!listZS.isEmpty()){
				Zamtosluzba zamtosluzba=listZS.remove(0);
				
				query=session.createQuery("from KomentariSluzbaZamenik where idZamToSluzba="+zamtosluzba.getIdZamToSluzba()+"");
				List<KomentariSluzbaZamenik> listKomSlZamenik=query.list();
				while (!listKomSlZamenik.isEmpty()){
					KomentariSluzbaZamenik komSlZamenik=listKomSlZamenik.remove(0);
					session.delete(komSlZamenik);
				}
       
				query=session.createQuery("from KomentariSluzbaStudentz where idZamToSluzba="+zamtosluzba.getIdZamToSluzba()+"");
				List<KomentariSluzbaStudentz> listKomSlStudentz=query.list();
				while (!listKomSlStudentz.isEmpty()){
					KomentariSluzbaStudentz komSlStudentz=listKomSlStudentz.remove(0);
					session.delete(komSlStudentz);
				}
				
				session.delete(zamtosluzba);
			}
			
			session.delete(menttozam);
	   }
       }
            
            izm1=true;
            prijava.setIdMentorZ(null);
            ipZamenik="";
            prijava.setIdMentor(korisnici.get(0).getUsername());
            
        }
        query=session.createQuery("from Predmet where naziv='"+nazivPredmeta+"' and idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')");
        List<Predmet> listPredmet=query.list();
        int idPredmet=listPredmet.get(0).getIdPredmet();
            
        if (mentorRada && idPredmet!=prijava.getIdPredmet()){
            izm2=true;
            prijava.setIdPredmet(idPredmet);
            nazivPredmeta1=nazivPredmeta;
        }
        if (rukovodilac && prijava.getRukIliProf()==0){
            izm3=true;
            prijava.setRukIliProf(1);
            prijava.setIdPredmet(null);
        }
        if (mentorRada && prijava.getRukIliProf()==1){
            izm3=true;
            prijava.setRukIliProf(0);
        }
        
        query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRadova=query.list();
        Masterrad rad=listRadova.get(0);
        if (!nazivRadEn.equals(rad.getNazivE())){
            izm4=true;
            rad.setNazivE(nazivRadEn);
        }
        if (!nazivRadSer.equals(rad.getNazivS())){
            izm5=true;
            rad.setNazivS(nazivRadSer);
        }
        boolean izm=false;
        if (izm4 || izm5){
            session.update(rad);
            
            prijava.setImaGreske(5);
            prijava.setPrijavljena(0);
            session.update(prijava);
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно одрађена измена наслова теме."));
            izm=true;  
        }
        if (izm1 || izm2 || izm3){
            prijava.setImaGreske(5);
            prijava.setPrijavljena(0);
            if (prijava.getIdRukRada()!=null) {prijava.setIdRukRada(null); ipRukRad="";}
            if (prijava.getIdKom1()!=null) {prijava.setIdKom1(null); ipKom1="";}
            if (prijava.getIdKom2()!=null) {prijava.setIdKom2(null); ipKom2="";}
            if (prijava.getDatum()!=null) {prijava.setDatum(null); datum=null;}
            session.update(prijava);
            context.addMessage(messagePrijava_1a.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно одрађена измена професора и предмета."));
            izm=true;
        }
        if (izm){
        Calendar cal=Calendar.getInstance();
        Date d=cal.getTime();
        //public VerzijaPrijave(int idPrijava, Date datumVer, String idStudent, 
        //String idMentor, String idMentorZ, int idRad, String nazivS, 
        //String nazivE, String predmet, String sadrzaj, Integer idPredmet,
        //int rukIliProf, String biografija, String idRukRada, String idKom1,
        //String idKom2, Date datum)
     
        VerzijaPrijave verzija=new VerzijaPrijave(prijava.getIdPrijava(), d,d, 
                prijava.getIdStudent(), prijava.getIdMentor(), prijava.getIdMentorZ(), prijava.getIdRukovodilac(),
                rad.getIdRad(), rad.getNazivS(), rad.getNazivE(), rad.getPredmet(),
                rad.getSadrzaj(), prijava.getIdPredmet(), prijava.getRukIliProf(),
                prijava.getBiografija(), prijava.getIdRukRada(), prijava.getIdKom1(), prijava.getIdKom2(),
                prijava.getDatum(), prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);
        }
        String statusPrijave="";
         boolean ukiniIzmenu=false;
        switch (prijava.getImaGreske()){
                    case 0: statusPrijave="Потврђена од стране Студентске службе"; break;
                    case 1: statusPrijave="Успешно послата пријава"; break;
                    case 2: statusPrijave="Измена захтевана од стране ментора"; break;
                    case 3: statusPrijave="Послато руководиоцу/заменику"; ukiniIzmenu=true; break;
                    case 4: statusPrijave="Измена захтевана од стране руководиоца/заменика"; ukiniIzmenu=true; break;
                    case 5: statusPrijave="Успешно измењена пријава"; break;
                    case 6: statusPrijave="Послато Студентској служби"; ukiniIzmenu=true; break;
                    case 7: statusPrijave="Измена захтевана од стране Студентске службе"; break;
                    case 8: statusPrijave="Измена захтевана од стране Студентске службе"; break;
                    case 9: statusPrijave="Измењена од стране руководиоца рада"; break;
            }
        sesija.setAttribute("statusPrijave", statusPrijave); 
        sesija.setAttribute("ukiniIzmenu", ukiniIzmenu);
        sesija.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        
        return "student_izmena_1";
    }
    
     public String proveri2(){
          
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (bioText.length()==0) {
            context.addMessage(messagePrijava_2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите биографију!"));
            return "biografija_izmena_1";
        } 
        for(int i = 0; i < bioText.length(); i++) {
             if(!(Character.UnicodeBlock.of(bioText.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(bioText.charAt(i))) || (Character.UnicodeBlock.of(bioText.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Биографија није написана ћирилицом!"));
                 return "biografija_izmena_1";
            }
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession sesija=(HttpSession) context.getExternalContext().getSession(false);
        prijava=(Prijava) sesija.getAttribute("prijava");
        boolean izm=false;
        if (!bioText.equals(prijava.getBiografija())){
            prijava.setBiografija(bioText);
            prijava.setImaGreske(5);
            session.update(prijava);
            context.addMessage(messagePrijava_2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно обављена измена биографије."));
            izm=true;
        }
        
        Query query=session.createQuery("from Masterrad where idRad="+prijava.getIdPrijava()+"");
        List<Masterrad> listRadova=query.list();
        
        Masterrad rad=listRadova.get(0);
        
        if (izm){
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
                prijava.getDatum(), prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);
        }
        boolean ukiniIzmenu=false;
        String statusPrijave="";
        switch (prijava.getImaGreske()){
                     case 0: statusPrijave="Потврђена од стране Студентске службе"; break;
                    case 1: statusPrijave="Успешно послата пријава"; break;
                    case 2: statusPrijave="Измена захтевана од стране ментора"; break;
                    case 3: statusPrijave="Послато руководиоцу/заменику"; ukiniIzmenu=true; break;
                    case 4: statusPrijave="Измена захтевана од стране руководиоца/заменика"; ukiniIzmenu=true; break;
                    case 5: statusPrijave="Успешно измењена пријава"; break;
                    case 6: statusPrijave="Послато Студентској служби"; ukiniIzmenu=true; break;
                    case 7: statusPrijave="Измена захтевана од стране Студентске службе"; break;
                    case 8: statusPrijave="Измена захтевана од стране Студентске службе"; break;
                    case 9: statusPrijave="Измењена од стране руководиоца рада"; break;
            }
        sesija.setAttribute("ukiniIzmenu",ukiniIzmenu);
        sesija.setAttribute("statusPrijave", statusPrijave); 
        sesija.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return "biografija_izmena_1";
    }
     
     public String proveri3(){
         FacesContext context = FacesContext.getCurrentInstance();
        if (radPredmet.length()==0) {
            context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите предмет, циљ и методе мастер рада!"));
            return "obrazlozenje_izmena_1";
        } 
         for(int i = 0; i < radPredmet.length(); i++) {
             if(!(Character.UnicodeBlock.of(radPredmet.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(radPredmet.charAt(i))) || (Character.UnicodeBlock.of(radPredmet.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Предмет, циљ и методе мастер рада нису написани ћирилицом!"));
                 return "obrazlozenje_izmena_1";
            }
        }
         if (radSadrzaj.length()==0) {
            context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Напишите садржај и очекивани резултати мастер!"));
            return "obrazlozenje_izmena_1";
        } 
          for(int i = 0; i < radSadrzaj.length(); i++) {
             if(!(Character.UnicodeBlock.of(radSadrzaj.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(radSadrzaj.charAt(i))) || (Character.UnicodeBlock.of(radSadrzaj.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Садржај и очекивани резултати мастер рада нису написани ћирилицом!"));
                 return "obrazlozenje_izmena_1";
            }
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession sesija=(HttpSession) context.getExternalContext().getSession(false);
        prijava=(Prijava) sesija.getAttribute("prijava");
        boolean izm1=false;
        if (prijava.getIdPredmet()==0) {
            Korisnik student=(Korisnik) sesija.getAttribute("student");
            Query query=session.createQuery("from Predmet where naziv='"+nazivPredmeta1+"' and idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')");
            List<Predmet> predmetList=query.list();
            prijava.setIdPredmet(predmetList.get(0).getIdPredmet());
            izm1=true;
            if (prijava.getRukIliProf()==1) nazivPredmeta=nazivPredmeta1;
        }
        else {
            Korisnik student=(Korisnik) sesija.getAttribute("student");
            Query query=session.createQuery("from Predmet where naziv='"+nazivPredmeta1+"' and idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"')");
            List<Predmet> predmetList=query.list();
            int idPredmet=predmetList.get(0).getIdPredmet();
            if (idPredmet!=prijava.getIdPredmet()){
                izm1=true;
                prijava.setIdPredmet(idPredmet);
                
            if (prijava.getRukIliProf()==1) nazivPredmeta=nazivPredmeta1;
            }
        }
        boolean izm=false;
        if (izm1) {
            
            prijava.setImaGreske(5);
            session.update(prijava);  context.addMessage(messagePrijava_3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно обављена измена предмета."));
             izm=true; }
        boolean izm2=false, izm3=false;
        Query query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRadova=query.list();
        
        Masterrad rad=listRadova.get(0);
        if (!radPredmet.equals(rad.getPredmet())){
            izm2=true;
            rad.setPredmet(radPredmet);
        }
         if (!radSadrzaj.equals(rad.getSadrzaj())){
            izm3=true;
            rad.setSadrzaj(radSadrzaj);
        }
        if (izm2 || izm3){
            session.update(rad);
            
            prijava.setImaGreske(5);
            session.update(prijava);  
            context.addMessage(messagePrijava_3a.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно обављена циља и садржаја мастер рада."));
             izm=true;
        }
        if (izm){
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
                prijava.getDatum(), prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);
        }
        sesija.setAttribute("prijava", prijava);
        
        boolean ukiniIzmenu=false;
        String statusPrijave="";
        switch (prijava.getImaGreske()){
                     case 0: statusPrijave="Потврђена од стране Студентске службе"; break;
                    case 1: statusPrijave="Успешно послата пријава"; break;
                    case 2: statusPrijave="Измена захтевана од стране ментора"; break;
                    case 3: statusPrijave="Послато руководиоцу/заменику"; ukiniIzmenu=true; break;
                    case 4: statusPrijave="Измена захтевана од стране руководиоца/заменика"; ukiniIzmenu=true; break;
                    case 5: statusPrijave="Успешно измењена пријава"; break;
                    case 6: statusPrijave="Послато Студентској служби"; ukiniIzmenu=true; break;
                    case 7: statusPrijave="Измена захтевана од стране Студентске службе"; break;
                    case 8: statusPrijave="Измена захтевана од стране Студентске службе"; break;
                    case 9: statusPrijave="Измењена од стране руководиоца рада"; break;
            }
        sesija.setAttribute("ukiniIzmenu",ukiniIzmenu);
        sesija.setAttribute("statusPrijave", statusPrijave); 
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return "obrazlozenje_izmena_1";
     }
    
    public List<String> listaPredmeta(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<String> listaPredmeta1=new ArrayList<>();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        prijava=(Prijava) httpSession.getAttribute("prijava");
        if (prijava.getIdPredmet()!=null) {
            Query query=session.createQuery("from Predmet where idPredmet in (select idPredmet from Predaje where idMentor='"+prijava.getIdMentor()+"' and idStudent='"+prijava.getIdStudent()+"')");
            List<Predmet> predmetList=query.list();
            int i=0;
            while (i<predmetList.size()){
                listaPredmeta1.add(predmetList.get(i).getNaziv());
                i++;
            }
        
        }
        else {
            Korisnik student=(Korisnik) httpSession.getAttribute("student");
            Query query=session.createQuery("from Predmet where idPredmet in (select idPredmet from Predaje where idStudent='"+student.getUsername()+"' and idMentor='"+prijava.getIdRukovodilac()+"')");
            List<Predmet> predmetList=query.list();
            int i=0;
            while (i<predmetList.size()){
                listaPredmeta1.add(predmetList.get(i).getNaziv());
                i++;
            }
            }
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
        return listaPredmeta1;
    }
    public String vratiPod(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!nazivPredmeta.equals(nazivPredmeta1)){
            context.addMessage(messagePrijava_1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Молимо Вас да поклопите називе предмета на страници формулара и образложења пријаве!"));
            return "student_izmena_1";
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        prijava=(Prijava) httpSession.getAttribute("prijava");
        Korisnik student=(Korisnik) httpSession.getAttribute("student");
        Query query=session.createQuery("from VerzijaPrijave where idPrijava="+prijava.getIdPrijava()+" and idStudent='"+prijava.getIdStudent()+"' order by datumVer desc, vremeVer desc");
        List<VerzijaPrijave> listVerzija=query.list();
        query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRad=query.list();
        String naslov=listRad.get(0).getNazivS();  //deklarisati
                String radPredmet=listRad.get(0).getPredmet(); //deklarisati
                String radSadrzaj=listRad.get(0).getSadrzaj(); //deklarisati
                query=session.createQuery("from Predmet where idPredmet="+prijava.getIdPredmet()+"");
                List<Predmet> listPredmeta=query.list();
                String naslovPredmeta=listPredmeta.get(0).getNaziv(); //deklarisati
                query=session.createQuery("from KomentariStMent where idPrijava="+prijava.getIdPrijava()+"");
                List<KomentariStMent> listaKomentara=query.list();
                query=session.createQuery("from KomentariSluzbaStudent where idStudent='"+student.getUsername()+"' and idRukToSluzba in (select idRukToSluzba from Ruktosluzba where idMentToRuk in (select idMentToRuk from Menttoruk where idPrijava="+prijava.getIdPrijava()+"))");
                List<KomentariSluzbaStudent> listaKomentara1=query.list(); //deklarisati
                query=session.createQuery("from KomentariSluzbaStudentz where idStudent='"+student.getUsername()+"' and idZamToSluzba in (select idZamToSluzba from Zamtosluzba where idMentToZam in (select idMentToZam from Menttozam where idPrijava="+prijava.getIdPrijava()+"))");
                List<KomentariSluzbaStudentz> listaKomentara2=query.list(); //deklarisati
        httpSession.setAttribute("verzije", listVerzija);
         httpSession.setAttribute("naslov", naslov);
                httpSession.setAttribute("radPredmet", radPredmet);
                httpSession.setAttribute("radSadrzaj", radSadrzaj);
                httpSession.setAttribute("naslovPredmeta", naslovPredmeta);
                httpSession.setAttribute("listaKomentara", listaKomentara);
                httpSession.setAttribute("listaKomentara1", listaKomentara1);
                httpSession.setAttribute("listaKomentara2", listaKomentara2);
        session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
        return "podesiti_prijavu";
    }
    
   
   
    
}

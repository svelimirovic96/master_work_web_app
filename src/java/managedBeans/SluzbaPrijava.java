/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import beans.KomentariMentRuk;
import beans.KomentariSluzbaMentor;
import beans.KomentariSluzbaStudent;
import beans.KomentariSluzbaStudentz;
import beans.KomentariSluzbaZamenik;
import beans.Korisnik;
import beans.Masterrad;
import beans.Mentor;
import beans.Menttoruk;
import beans.Modul;
import beans.Predmet;
import beans.Prijava;
import beans.Ruktosluzba;
import beans.Sastanak;
import beans.Student;
import beans.Zamenik;
import beans.Zamtosluzba;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import beans.VerzijaPrijave;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Sandra
 */
@ManagedBean(name = "sluzbaPrijava")
@SessionScoped
public class SluzbaPrijava{
    private List<Ruktosluzba> listaZahteva;
    private List<Sastanak> listaSastanaka;
    private String ipStudent, ipMentor, ipRuk, ipRukRada, ipRukRad, ipKom1, ipKom2, ipKomisija1, ipKomisija2; //ime i prezime 
    private String indexStudent;
    private String nazivModula, nazivPredmeta, bioText, nazivRadSer, nazivRadEn, radPredmet, radSadrzaj;
    private UIComponent messagePregled1;
    private UIComponent messagePregled2;
    private UIComponent messagePregled3;
    private UIComponent messagePregled4;
    private UIComponent messagePregled5;
    private UIComponent messagePregled10;
    private UIComponent messageSastanak;
    private UIComponent messageUlaz;
    private boolean prijavljeno;
    private String sugestija, komEn, komSer, komBio, komPredmet, komSadrzaj;
    private boolean rukovodilac, mentorRada, prihvata, odbija, sugerisi;
    private Date datum, datum1, datum2;
    private String nazivPredmeta1;
    private boolean stampaj;

    public boolean isStampaj() {
        return stampaj;
    }

    public void setStampaj(boolean stampaj) {
        this.stampaj = stampaj;
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

    public Date getDatum2() {
        return datum2;
    }

    public void setDatum2(Date datum2) {
        this.datum2 = datum2;
    }

    
    
    public UIComponent getMessageUlaz() {
        return messageUlaz;
    }

    public void setMessageUlaz(UIComponent messageUlaz) {
        this.messageUlaz = messageUlaz;
    }

    
    
    public UIComponent getMessageSastanak() {
        return messageSastanak;
    }

    public void setMessageSastanak(UIComponent messageSastanak) {
        this.messageSastanak = messageSastanak;
    }

    
    
    public String getIpRukRad() {
        return ipRukRad;
    }

    public void setIpRukRad(String ipRukRad) {
        this.ipRukRad = ipRukRad;
    }

    
    
    public String getNazivPredmeta1() {
        return nazivPredmeta1;
    }

    public void setNazivPredmeta1(String nazivPredmeta1) {
        this.nazivPredmeta1 = nazivPredmeta1;
    }
    
    

    public boolean isPrijavljeno() {
        return prijavljeno;
    }

    public void setPrijavljeno(boolean prijavljeno) {
        this.prijavljeno = prijavljeno;
    }
    
    
    
    public UIComponent getMessagePregled10() {
        return messagePregled10;
    }

    public void setMessagePregled10(UIComponent messagePregled10) {
        this.messagePregled10 = messagePregled10;
    }

    
    
    public Date getDatum1() {
        return datum1;
    }

    public void setDatum1(Date datum1) {
        this.datum1 = datum1;
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

    public List<Sastanak> getListaSastanaka() {
        return listaSastanaka;
    }

    public void setListaSastanaka(List<Sastanak> listaSastanaka) {
        this.listaSastanaka = listaSastanaka;
    }

    
    
    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    

    public String getIpRukRada() {
        return ipRukRada;
    }

    public void setIpRukRada(String ipRukRada) {
        this.ipRukRada = ipRukRada;
    }

    
    
    public List<Ruktosluzba> getListaZahteva() {
        return listaZahteva;
    }

    public void setListaZahteva(List<Ruktosluzba> listaZahteva) {
        this.listaZahteva = listaZahteva;
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

    public UIComponent getMessagePregled1() {
        return messagePregled1;
    }

    public void setMessagePregled1(UIComponent messagePregled1) {
        this.messagePregled1 = messagePregled1;
    }

    public UIComponent getMessagePregled2() {
        return messagePregled2;
    }

    public void setMessagePregled2(UIComponent messagePregled2) {
        this.messagePregled2 = messagePregled2;
    }

    public UIComponent getMessagePregled3() {
        return messagePregled3;
    }

    public void setMessagePregled3(UIComponent messagePregled3) {
        this.messagePregled3 = messagePregled3;
    }

    public UIComponent getMessagePregled4() {
        return messagePregled4;
    }

    public void setMessagePregled4(UIComponent messagePregled4) {
        this.messagePregled4 = messagePregled4;
    }

    public UIComponent getMessagePregled5() {
        return messagePregled5;
    }

    public void setMessagePregled5(UIComponent messagePregled5) {
        this.messagePregled5 = messagePregled5;
    }

    public String getKomEn() {
        return komEn;
    }

    public void setKomEn(String komEn) {
        this.komEn = komEn;
    }

    public String getKomSer() {
        return komSer;
    }

    public void setKomSer(String komSer) {
        this.komSer = komSer;
    }

    public String getKomBio() {
        return komBio;
    }

    public void setKomBio(String komBio) {
        this.komBio = komBio;
    }

    public String getKomPredmet() {
        return komPredmet;
    }

    public void setKomPredmet(String komPredmet) {
        this.komPredmet = komPredmet;
    }

    public String getKomSadrzaj() {
        return komSadrzaj;
    }

    public void setKomSadrzaj(String komSadrzaj) {
        this.komSadrzaj = komSadrzaj;
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
    
    public String ruk(Ruktosluzba zahtev){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username='"+zahtev.getIdRuk()+"'");
        List<Korisnik> listaRuk=query.list();
        Korisnik rukovodilac=listaRuk.get(0);
        String rukNaziv=rukovodilac.getIme()+" "+rukovodilac.getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return rukNaziv;
    }
    public String modul(Ruktosluzba zahtev){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username='"+zahtev.getIdRuk()+"'");
        List<Korisnik> listaRuk=query.list();
        Korisnik rukovodilac=listaRuk.get(0);
        query=session.createQuery("from Modul where idModul in (select idModul from RukovodilacModula where username='"+rukovodilac.getUsername()+"')");
        List<Modul> listaModula=query.list();
        Modul modul=listaModula.get(0);
        String nazivModula=modul.getNaziv();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return nazivModula;
    }
    public String mentor(Ruktosluzba zahtev){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select idMentor from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk in (select idMentToRuk from Ruktosluzba where idRukToSluzba="+zahtev.getIdRukToSluzba()+")))");
        List<Korisnik> listaMent=query.list();
        Korisnik mentor=listaMent.get(0);
        String mentNaziv=mentor.getIme()+" "+mentor.getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return mentNaziv;
    }
    public String student(Ruktosluzba zahtev){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select idStudent from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk in (select idMentToRuk from Ruktosluzba where idRukToSluzba="+zahtev.getIdRukToSluzba()+")))");
        List<Korisnik> listaStudent=query.list();
        Korisnik student=listaStudent.get(0);
        String studentNaziv=student.getIme()+" "+student.getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return studentNaziv;
    
    }
    
    public String zam(Zamtosluzba zahtev){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username='"+zahtev.getIdZam()+"'");
        List<Korisnik> listaZam=query.list();
        Korisnik zamenik=listaZam.get(0);
        String zamNaziv=zamenik.getIme()+" "+zamenik.getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return zamNaziv;
    }
    
     public String ruk1(Zamtosluzba zahtev){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select username from RukovodilacModula where usernameZ='"+zahtev.getIdZam()+"' and username in (select idRukovodilac from Prijava where idPrijava in (select idPrijava from Menttozam where idMenttozam="+zahtev.getIdMentToZam()+")))");
        List<Korisnik> listaRuk=query.list(); 
        Korisnik rukovod=listaRuk.get(0);
        String rukNaziv=rukovod.getIme()+" "+rukovod.getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return rukNaziv;
    }
    public String modul1(Zamtosluzba zahtev){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select username from RukovodilacModula where usernameZ='"+zahtev.getIdZam()+"' and username in (select idRukovodilac from Prijava where idPrijava in (select idPrijava from Menttozam where idMenttozam="+zahtev.getIdMentToZam()+")))");
        List<Korisnik> listaRuk=query.list();
        Korisnik rukovod=listaRuk.get(0);
        query=session.createQuery("from Modul where idModul in (select idModul from RukovodilacModula where username='"+rukovod.getUsername()+"')");
        List<Modul> listaModula=query.list();
        Modul modul=listaModula.get(0);
        String nazivModul=modul.getNaziv();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return nazivModul;
    }
    public String mentor1(Zamtosluzba zahtev){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select idMentor from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam in (select idMentToZam from Zamtosluzba where idZamToSluzba="+zahtev.getIdZamToSluzba()+")))");
        List<Korisnik> listaMent=query.list();
        Korisnik mentor=listaMent.get(0);
        String mentNaziv=mentor.getIme()+" "+mentor.getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return mentNaziv;
    }
    public String student1(Zamtosluzba zahtev){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select idStudent from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam in (select idMentToZam from Zamtosluzba where idZamToSluzba="+zahtev.getIdZamToSluzba()+")))");
        List<Korisnik> listaStudent=query.list();
        Korisnik student=listaStudent.get(0);
        String studentNaziv=student.getIme()+" "+student.getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return studentNaziv;
    
    } 
    //statusi prijave
    
     public String status(Ruktosluzba zahtev){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
         String statusPrijave="";
           switch (prijava.getImaGreske()){
                    case 0: statusPrijave="Успешно потврђена"; break;
                    case 1: statusPrijave="Пријављена од стране студента"; break;
                    case 2: statusPrijave="Студент мора да измени"; break;
                    case 3: statusPrijave="Послато руководиоцу/заменику"; break;
                    case 4: statusPrijave="Руководилац рада мора да измени"; break;
                    case 5: statusPrijave="Измењена од стране студента"; break;
                    case 6: statusPrijave="Послато од стране руководиоца/заменика"; break;
                    case 7: statusPrijave="Послати коментари руководиоцу рада"; break;
                    case 8: statusPrijave="Послати коментари студенту"; break;
                    case 9: statusPrijave="Измењена од стране руководиоца рада"; break;
            }
            session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
           return statusPrijave;
     }
     public boolean ponisti(Ruktosluzba zahtev){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
         boolean vrati=false; 
        if (prijava.getImaGreske()==2 || prijava.getImaGreske()==3 || prijava.getImaGreske()==4 || prijava.getImaGreske()==7 || prijava.getImaGreske()==8)
           vrati=true;
             
            session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
           return vrati;
     }
     
     
     
     public String status1(Zamtosluzba zahtev){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
         String statusPrijave="";
           switch (prijava.getImaGreske()){
                    case 0: statusPrijave="Успешно потврђена"; break;
                    case 1: statusPrijave="Пријављена од стране студента"; break;
                    case 2: statusPrijave="Студент мора да измени"; break;
                    case 3: statusPrijave="Послато руководиоцу/заменику"; break;
                    case 4: statusPrijave="Руководилац рада мора да измени"; break;
                    case 5: statusPrijave="Измењена од стране студента"; break;
                    case 6: statusPrijave="Послато од стране руководиоца/заменика"; break;
                    case 7: statusPrijave="Послати коментари руководиоцу рада"; break;
                    case 8: statusPrijave="Послати коментари студенту"; break;
                    case 9: statusPrijave="Измењена од стране руководиоца рада"; break;
            }
            session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
           return statusPrijave;
     }
       public boolean ponisti1(Zamtosluzba zahtev){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        boolean vrati=false; 
        if (prijava.getImaGreske()==2 || prijava.getImaGreske()==3 || prijava.getImaGreske()==4 || prijava.getImaGreske()==7 || prijava.getImaGreske()==8)
           vrati=true;
             
            session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
           return vrati;
     }
     
    
    //azuriranja prijave
    public String azuriraj(Ruktosluzba zahtev){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+") and prihvata is not null");
        List<Prijava> listaPrijava=query.list();
        if (listaPrijava.isEmpty()){
            context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Пријава не може да се ажурира без потврде комисије!"));
             session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
            return "sluzba_pocetna";
        }
        Prijava odabranaPrijava=listaPrijava.get(0);
        query=session.createQuery("from Sastanak where idSluzba='"+zahtev.getIdSluzba()+"' and odrzan=1 and idPrijava="+odabranaPrijava.getIdPrijava()+" and idPrijava in (select idPrijava from Prijava where prihvata is not null)");
        if (query.list().isEmpty()){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Потребан Вам је закључак комисије за студије другог степена К2!"));
             session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
        return "sluzba_pocetna";
        }
        
        List<Sastanak> listSastanaka=query.list();
        int size=listSastanaka.size();
         Sastanak odSastanak=listSastanaka.get(size-1);
        query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava1()+"'");
         List<Korisnik> listKor1=query.list();
         ipKomisija1=listKor1.get(0).getIme()+" "+listKor1.get(0).getPrezime();
         
         query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava2()+"'");
         List<Korisnik> listKor2=query.list();
         ipKomisija2=listKor2.get(0).getIme()+" "+listKor2.get(0).getPrezime();
         datum1=odSastanak.getDatum();
        
        if (odabranaPrijava.getRukIliProf()==1){
         rukovodilac=true;
         mentorRada=false;
        }
        else {
         rukovodilac=false;
         mentorRada=true;
        }
        
        prihvata=odbija=sugerisi=false;
         if (odabranaPrijava.getPrihvata()==1)
            prihvata=true;
        if (odabranaPrijava.getPrihvata()==2)
         odbija=true;
        if (odabranaPrijava.getPrihvata()==3)
            sugerisi=true;
        sugestija=odabranaPrijava.getSugestija();
        datum2=odabranaPrijava.getDatumS();
        bioText=odabranaPrijava.getBiografija();
        query=session.createQuery("from Korisnik where username='"+odabranaPrijava.getIdStudent()+"'");
        List<Korisnik> listSt=new ArrayList<>();
        listSt=query.list();
        ipStudent=listSt.get(0).getIme()+" "+listSt.get(0).getPrezime();
        String ind=listSt.get(0).getUsername().substring(2, 8);
        if (Integer.parseInt(ind.substring(0, 2))>=0 && Integer.parseInt(ind.substring(0, 2))<=21) indexStudent="20"+ind.substring(0,2);
        else indexStudent="19"+ind.substring(0,2);
        indexStudent+="/"+ind.substring(2);
        query=session.createQuery("from Modul where idModul in (select idModul from Student where username='"+odabranaPrijava.getIdStudent()+"')");
        List<Modul> listMod=new ArrayList<>();
        listMod=query.list();
        nazivModula=listMod.get(0).getNaziv();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        httpSession.setAttribute("prijava", odabranaPrijava);
        httpSession.setAttribute("zahtev", zahtev);
        query=session.createQuery("from Korisnik where username='"+zahtev.getIdRuk()+"'");
        List<Korisnik> listRuk=query.list();
        Korisnik rukovodila=listRuk.get(0);
        ipRuk=rukovodila.getIme()+" "+rukovodila.getPrezime();
        query=session.createQuery("from Masterrad where idRad="+odabranaPrijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        nazivRadSer=listRad.get(0).getNazivS();
        nazivRadEn=listRad.get(0).getNazivE();
        radPredmet=listRad.get(0).getPredmet();
        radSadrzaj=listRad.get(0).getSadrzaj();
        query=session.createQuery("from Korisnik where username in (select username from Mentor where username='"+odabranaPrijava.getIdMentor()+"')");
        List<Korisnik> listMent=new ArrayList<>();
        listMent=query.list();
        ipMentor=listMent.get(0).getIme()+" "+listMent.get(0).getPrezime();
        query=session.createQuery("from Predmet where idPredmet="+odabranaPrijava.getIdPredmet()+"");
        List<Predmet> listPredmet=new ArrayList<>();
        listPredmet=query.list();
        nazivPredmeta=listPredmet.get(0).getNaziv();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveSluzba";
    }
    
    public String azuriraj1(Zamtosluzba zahtev){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+") and prihvata is not null");
        List<Prijava> listaPrijava=query.list();
        if (listaPrijava.isEmpty()){
            context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Пријава не може да се ажурира без потврде комисије!"));
             session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
            return "sluzba_pocetna";
        }
        Prijava odabranaPrijava=listaPrijava.get(0);
        query=session.createQuery("from Sastanak where idSluzba='"+zahtev.getIdSluzba()+"' and odrzan=1 and idPrijava="+odabranaPrijava.getIdPrijava()+" and idPrijava in (select idPrijava from Prijava where prihvata is not null)");
        if (query.list().isEmpty()){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Потребан Вам је закључак комисије за студије другог степена К2!"));
             session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
        return "sluzba_pocetna";
        }
        
        List<Sastanak> listSastanaka=query.list();
        int size=listSastanaka.size();
         Sastanak odSastanak=listSastanaka.get(size-1);
        query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava1()+"'");
         List<Korisnik> listKor1=query.list();
         ipKomisija1=listKor1.get(0).getIme()+" "+listKor1.get(0).getPrezime();
         
         query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava2()+"'");
         List<Korisnik> listKor2=query.list();
         ipKomisija2=listKor2.get(0).getIme()+" "+listKor2.get(0).getPrezime();
         datum1=odSastanak.getDatum();
        
        if (odabranaPrijava.getRukIliProf()==1){
         rukovodilac=true;
         mentorRada=false;
        }
        else {
         rukovodilac=false;
         mentorRada=true;
        
       }
        
        datum2=odabranaPrijava.getDatumS();
        prihvata=odbija=sugerisi=false;
         if (odabranaPrijava.getPrihvata()==1)
            prihvata=true;
        if (odabranaPrijava.getPrihvata()==2)
         odbija=true;
        if (odabranaPrijava.getPrihvata()==3)
            sugerisi=true;
        sugestija=odabranaPrijava.getSugestija();
        bioText=odabranaPrijava.getBiografija();
        query=session.createQuery("from Korisnik where username='"+odabranaPrijava.getIdStudent()+"'");
        List<Korisnik> listSt=new ArrayList<>();
        listSt=query.list();
        ipStudent=listSt.get(0).getIme()+" "+listSt.get(0).getPrezime();
        String ind=listSt.get(0).getUsername().substring(2, 8);
        if (Integer.parseInt(ind.substring(0, 2))>=0 && Integer.parseInt(ind.substring(0, 2))<=21) indexStudent="20"+ind.substring(0,2);
        else indexStudent="19"+ind.substring(0,2);
        indexStudent+="/"+ind.substring(2);
        query=session.createQuery("from Modul where idModul in (select idModul from Student where username='"+odabranaPrijava.getIdStudent()+"')");
        List<Modul> listMod=new ArrayList<>();
        listMod=query.list();
        nazivModula=listMod.get(0).getNaziv();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        httpSession.setAttribute("prijava", odabranaPrijava);
        httpSession.setAttribute("zahtev", zahtev);
        query=session.createQuery("from Korisnik where username in (select idRukovodilac from Prijava where idMentorZ='"+zahtev.getIdZam()+"' and idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
        List<Korisnik> listRuk=query.list();
        Korisnik rukovodil=listRuk.get(0);
        ipRuk=rukovodil.getIme()+" "+rukovodil.getPrezime();
        query=session.createQuery("from Masterrad where idRad="+odabranaPrijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        nazivRadSer=listRad.get(0).getNazivS();
        nazivRadEn=listRad.get(0).getNazivE();
        radPredmet=listRad.get(0).getPredmet();
        radSadrzaj=listRad.get(0).getSadrzaj();
        query=session.createQuery("from Korisnik where username in (select username from Mentor where username='"+odabranaPrijava.getIdMentor()+"')");
        List<Korisnik> listMent=new ArrayList<>();
        listMent=query.list();
        ipMentor=listMent.get(0).getIme()+" "+listMent.get(0).getPrezime();
        query=session.createQuery("from Predmet where idPredmet="+odabranaPrijava.getIdPredmet()+"");
        List<Predmet> listPredmet=new ArrayList<>();
        listPredmet=query.list();
        nazivPredmeta=listPredmet.get(0).getNaziv();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveSluzba1";
    }
    
      public String izmeni1(){
         FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
        Query query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        Masterrad rad=listRad.get(0);
        boolean presao1=false, presao2=false;
        if (!nazivRadSer.equals(rad.getNazivS())){
            rad.setNazivS(nazivRadSer);
            session.update(rad);
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењен наслов теме на српском језику."));
            presao1=true;
        }
         else {
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Наслов теме на српском језику се није променио."));
              
        }
        if (!nazivRadEn.equals(rad.getNazivE())){
            rad.setNazivE(nazivRadEn);
            session.update(rad);
            context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењен наслов теме на енглеском језику."));
            presao2=true;
        }
        else {
            context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Наслов теме на енглеском језику се није променио."));
              
        }
        boolean b1=false, b2=false, b3=false, b4=false;
        if (prijava.getIdRukRada()==null && ipMentor!=null){
            int index=0;
            String ment=ipMentor;
            while (!Character.isWhitespace(ment.charAt(index))) index++;
            String imeKom1=ment.substring(0, index);
            ment=ipMentor;
            String prezimeKom1=ment.substring(index+1);
            query=session.createQuery("from Korisnik where ime='"+imeKom1+"' and prezime='"+prezimeKom1+"'");
            List<Korisnik> listKor=query.list();
            prijava.setIdRukRada(listKor.get(0).getUsername());
            session.update(prijava);
            b1=true;
        } 
        if (prijava.getIdKom1()==null && ipKomisija1!=null){
            int index=0;
            String ment=ipKomisija1;
            while (!Character.isWhitespace(ment.charAt(index))) index++;
            String imeKom1=ment.substring(0, index);
            ment=ipKomisija1;
            String prezimeKom1=ment.substring(index+1);
            query=session.createQuery("from Korisnik where ime='"+imeKom1+"' and prezime='"+prezimeKom1+"'");
            List<Korisnik> listKor=query.list();
            prijava.setIdKom1(listKor.get(0).getUsername());
            session.update(prijava);
            b2=true;
        } 
        if (prijava.getIdKom2()==null && ipKomisija2!=null){
             int index=0;
            String ment=ipKomisija2;
            while (!Character.isWhitespace(ment.charAt(index))) index++;
            String imeKom2=ment.substring(0, index);
            ment=ipKomisija2;
            String prezimeKom2=ment.substring(index+1);
            query=session.createQuery("from Korisnik where ime='"+imeKom2+"' and prezime='"+prezimeKom2+"'");
            List<Korisnik> listKor=query.list();
             prijava.setIdKom2(listKor.get(0).getUsername());
            session.update(prijava);
            b3=true;
        }
        if (prijava.getDatum()==null && datum1!=null){
            prijava.setDatum(datum1);
            session.update(prijava);
            b4=true;
        
        }
        if (b1) context.addMessage(messagePregled10.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте изменили пријаву за првог члана К2 комисије."));
        if (b2 && b3 && b4) context.addMessage(messagePregled10.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте изменили пријаву у складу са одлуком К2 комисије."));
        if (b1 || b2 || b2 || b4 || presao1 || presao2){
           
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
        }
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveSluzba";
    }
    
     public String izmeni2(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
        Query query=session.createQuery("from Prijava where idPrijava="+prijava.getIdPrijava()+"");
        List<Prijava> listPrijava=new ArrayList<>();
        listPrijava=query.list();
        Prijava pri=listPrijava.get(0);
        if (!bioText.equals(pri.getBiografija())){
            pri.setBiografija(bioText);
            session.update(pri);
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењена биографија студента."));
            query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
            List<Masterrad> listRadova=query.list();
            Masterrad rad=listRadova.get(0);
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
                pri.getBiografija(), prijava.getIdRukRada(), prijava.getIdKom1(), prijava.getIdKom2(),
                prijava.getDatum(), prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);
        }
         else {
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Биографија студента се није променила."));
              
        }
        
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveSluzba";
    }
     
     
     
      public String izmeni3(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
        Query query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        Masterrad rad=listRad.get(0);
        boolean presao1=false, presao2=false;
        if (!radPredmet.equals(rad.getPredmet())){
            rad.setPredmet(radPredmet);
            session.update(rad);
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењени предмет, циљ и методе мастер рада."));
             presao1=true;
        }
         else {
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Предмет, циљ и методе мастер рада нису измењени."));
              
        }
        if (!radSadrzaj.equals(rad.getSadrzaj())){
            rad.setSadrzaj(radSadrzaj);
            session.update(rad);
            context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењени садржај и резултати мастер рада."));
            presao2=true;
        }
         else {
            context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Садржај и резултати мастер рада нису измењени."));
              
        }
        
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
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveSluzba";
    }
      
      //zamenik
      
      public String izmeni1Zam(){
         FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
        Query query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        Masterrad rad=listRad.get(0);
        boolean presao1=false, presao2=false;
        if (!nazivRadSer.equals(rad.getNazivS())){
            rad.setNazivS(nazivRadSer);
            session.update(rad);
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењен наслов теме на српском језику."));
            presao1=true;
        }
         else {
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Наслов теме на српском језику се није променио."));
              
        }
        if (!nazivRadEn.equals(rad.getNazivE())){
            rad.setNazivE(nazivRadEn);
            session.update(rad);
            context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењен наслов теме на енглеском језику."));
            presao2=true;
        }
        else {
            context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Наслов теме на енглеском језику се није променио."));
              
        }
        boolean b1=false, b2=false, b3=false, b4=false;
        if (prijava.getIdRukRada()==null && ipMentor!=null){
            int index=0;
            String ment=ipMentor;
            while (!Character.isWhitespace(ment.charAt(index))) index++;
            String imeKom1=ment.substring(0, index);
            ment=ipMentor;
            String prezimeKom1=ment.substring(index+1);
            query=session.createQuery("from Korisnik where ime='"+imeKom1+"' and prezime='"+prezimeKom1+"'");
            List<Korisnik> listKor=query.list();
            prijava.setIdRukRada(listKor.get(0).getUsername());
            session.update(prijava);
            b1=true;
        } 
        if (prijava.getIdKom1()==null && ipKomisija1!=null){
            int index=0;
            String ment=ipKomisija1;
            while (!Character.isWhitespace(ment.charAt(index))) index++;
            String imeKom1=ment.substring(0, index);
            ment=ipKomisija1;
            String prezimeKom1=ment.substring(index+1);
            query=session.createQuery("from Korisnik where ime='"+imeKom1+"' and prezime='"+prezimeKom1+"'");
            List<Korisnik> listKor=query.list();
            prijava.setIdKom1(listKor.get(0).getUsername());
            session.update(prijava);
            b2=true;
        } 
        if (prijava.getIdKom2()==null && ipKomisija2!=null){
             int index=0;
            String ment=ipKomisija2;
            while (!Character.isWhitespace(ment.charAt(index))) index++;
            String imeKom2=ment.substring(0, index);
            ment=ipKomisija2;
            String prezimeKom2=ment.substring(index+1);
            query=session.createQuery("from Korisnik where ime='"+imeKom2+"' and prezime='"+prezimeKom2+"'");
            List<Korisnik> listKor=query.list();
             prijava.setIdKom2(listKor.get(0).getUsername());
            session.update(prijava);
            b3=true;
        }
        if (prijava.getDatum()==null && datum1!=null){
            prijava.setDatum(datum1);
            session.update(prijava);
            b4=true;
        
        }
        if (b1) context.addMessage(messagePregled10.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте изменили пријаву за првог члана К2 комисије."));
        if (b2 && b3 && b4) context.addMessage(messagePregled10.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте изменили пријаву у складу са одлуком К2 комисије."));
        if (presao1 || presao2 || b1 || b2 || b3 || b4){
           
            Calendar cal=Calendar.getInstance();
            Date d=cal.getTime();
        //public VerzijaPrijave(int idPrijava, Date datumVer, String idStudent, 
        //String idMentor, String idMentorZ, int idRad, String nazivS, 
        //String nazivE, String predmet, String sadrzaj, Integer idPredmet,
        //int rukIliProf, String biografija, String idRukRada, String idKom1,
        //String idKom2, Date datum)
     
        VerzijaPrijave verzija=new VerzijaPrijave(prijava.getIdPrijava(), d,d,
                prijava.getIdStudent(), prijava.getIdMentor(), prijava.getIdMentorZ(),prijava.getIdRukovodilac(),
                rad.getIdRad(), rad.getNazivS(), rad.getNazivE(), rad.getPredmet(),
                rad.getSadrzaj(), prijava.getIdPredmet(), prijava.getRukIliProf(),
                prijava.getBiografija(), prijava.getIdRukRada(), prijava.getIdKom1(), prijava.getIdKom2(),
                prijava.getDatum(), prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);
        }
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveSluzba1";
    }
    
     public String izmeni2Zam(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
        Query query=session.createQuery("from Prijava where idPrijava="+prijava.getIdPrijava()+"");
        List<Prijava> listPrijava=new ArrayList<>();
        listPrijava=query.list();
        Prijava pri=listPrijava.get(0);
        if (!bioText.equals(pri.getBiografija())){
            pri.setBiografija(bioText);
            session.update(pri);
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењена биографија студента."));
           query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
            List<Masterrad> listRadova=query.list();
            Masterrad rad=listRadova.get(0);
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
                pri.getBiografija(), prijava.getIdRukRada(), prijava.getIdKom1(), prijava.getIdKom2(),
                prijava.getDatum(), prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);   
        }
         else {
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Биографија студента се није променила."));
              
        }
        
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveSluzba1";
    }
     
     
     
      public String izmeni3Zam(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
        Query query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        Masterrad rad=listRad.get(0);
        boolean presao1=false, presao2=false;
        if (!radPredmet.equals(rad.getPredmet())){
            rad.setPredmet(radPredmet);
            session.update(rad);
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењени предмет, циљ и методе мастер рада."));
            presao1=true;
        }
         else {
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Предмет, циљ и методе мастер рада нису измењени."));
              
        }
        if (!radSadrzaj.equals(rad.getSadrzaj())){
            rad.setSadrzaj(radSadrzaj);
            session.update(rad);
            context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно измењени садржај и резултати мастер рада."));
            presao2=true;     
        }
         else {
            context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Садржај и резултати мастер рада нису измењени."));
              
        }
        if (presao1 || presao2){
           
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
        }
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveSluzba1";
    }
      
      //zamenik
      
      
      public String komentarisi1(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!komEn.isEmpty() || !komSer.isEmpty()){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Ruktosluzba zahtev=(Ruktosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Student where username in (select idStudent from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+"))");
         List<Student> listSt=query.list();
         Student student=listSt.get(0);
         KomentariSluzbaStudent komentar;
         if (!komSer.isEmpty()){
              for(int i = 0; i < komSer.length(); i++) {
             if(!(Character.UnicodeBlock.of(komSer.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komSer.charAt(i))) || (Character.UnicodeBlock.of(komSer.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                    if (session != null && session.isOpen()) {
                    session.close();
                    }
                 return "pregledPrijaveSluzba";
            }
        }
            komentar=new KomentariSluzbaStudent(zahtev.getIdRukToSluzba(),student.getUsername(),komSer);
            session.save(komentar);
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за наслов теме на српском језику."));
              
        }
         if (!komEn.isEmpty()){
             for(int i = 0; i < komEn.length(); i++) {
             if(!(Character.UnicodeBlock.of(komEn.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komEn.charAt(i))) || (Character.UnicodeBlock.of(komEn.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                 if (session != null && session.isOpen()) {
                session.close();
          }
                 return "pregledPrijaveSluzba";
            }
        }
            komentar=new KomentariSluzbaStudent(zahtev.getIdRukToSluzba(),student.getUsername(),komEn);
            session.save(komentar);
            context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за наслов теме на енглеском језику."));
              
         }
        query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        prijava.setImaGreske(8);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         }
        else {
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Морате да напишете било шта у пољима за коментаре да бисте послали."));
         }
        komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
        return "pregledPrijaveSluzba";
      }
      
      public String komentarisi2(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!komBio.isEmpty()){
             for(int i = 0; i < komBio.length(); i++) {
             if(!(Character.UnicodeBlock.of(komBio.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komBio.charAt(i))) || (Character.UnicodeBlock.of(komBio.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                   context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 
                 return "pregledPrijaveSluzba";
            }
        }
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Ruktosluzba zahtev=(Ruktosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Student where username in (select idStudent from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+"))");
         List<Student> listSt=query.list();
         Student student=listSt.get(0);
         KomentariSluzbaStudent komentar;
         komentar=new KomentariSluzbaStudent(zahtev.getIdRukToSluzba(), student.getUsername(), komBio);
            session.save(komentar);
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за биографију студента."));
           query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        prijava.setImaGreske(8);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         }
        else {
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Морате да напишете било шта у пољима за коментаре да бисте послали."));
         }
        komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
        return "pregledPrijaveSluzba";
      }
      
      public String komentarisi3(){
        
          FacesContext context = FacesContext.getCurrentInstance();
        if (!komPredmet.isEmpty() || !komSadrzaj.isEmpty()){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Ruktosluzba zahtev=(Ruktosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Student where username in (select idStudent from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+"))");
         List<Student> listSt=query.list();
         Student student=listSt.get(0);
         KomentariSluzbaStudent komentar;
         if (!komPredmet.isEmpty()){
             for(int i = 0; i < komPredmet.length(); i++) {
             if(!(Character.UnicodeBlock.of(komPredmet.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komPredmet.charAt(i))) || (Character.UnicodeBlock.of(komPredmet.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                   context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                 if (session != null && session.isOpen()) {
                session.close();
          }
                 return "pregledPrijaveSluzba";
            }
        }
            komentar=new KomentariSluzbaStudent(zahtev.getIdRukToSluzba(), student.getUsername(), komPredmet);
            session.save(komentar);
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за предмет, циљ и методе."));
              
        }
         if (!komSadrzaj.isEmpty()){
             for(int i = 0; i < komSadrzaj.length(); i++) {
             if(!(Character.UnicodeBlock.of(komSadrzaj.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komSadrzaj.charAt(i))) || (Character.UnicodeBlock.of(komSadrzaj.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                  context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                 if (session != null && session.isOpen()) {
                session.close();
          }
                 return "pregledPrijaveSluzba";
            }
        }
            komentar=new KomentariSluzbaStudent(zahtev.getIdRukToSluzba(), student.getUsername(), komSadrzaj);
            session.save(komentar);
            context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за садржај и резултате."));
              
         }
         query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        prijava.setImaGreske(8);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         }
        else {
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Морате да напишете било шта у пољима за коментаре да бисте послали."));
         }
        komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
          return "pregledPrijaveSluzba";
      }
      
      //zamenik
      
      public String komentarisi1Z(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!komEn.isEmpty() || !komSer.isEmpty()){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Zamtosluzba zahtev=(Zamtosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Student where username in (select idStudent from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Student> listSt=query.list();
         Student student=listSt.get(0);
         KomentariSluzbaStudentz komentar;
         if (!komSer.isEmpty()){
             
             for(int i = 0; i < komSer.length(); i++) {
             if(!(Character.UnicodeBlock.of(komSer.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komSer.charAt(i))) || (Character.UnicodeBlock.of(komSer.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                    if (session != null && session.isOpen()) {
                    session.close();
                    }
                 return "pregledPrijaveSluzba1";
            }
        }
            komentar=new KomentariSluzbaStudentz(zahtev.getIdZamToSluzba(),student.getUsername(),komSer);
            session.save(komentar);
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за наслов теме на српском језику."));
              
        }
         if (!komEn.isEmpty()){
             for(int i = 0; i < komEn.length(); i++) {
             if(!(Character.UnicodeBlock.of(komEn.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komEn.charAt(i))) || (Character.UnicodeBlock.of(komEn.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                 if (session != null && session.isOpen()) {
                session.close();
          }
                 return "pregledPrijaveSluzba1";
            }
        }
            komentar=new KomentariSluzbaStudentz(zahtev.getIdZamToSluzba(),student.getUsername(),komEn);
            session.save(komentar);
            context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за наслов теме на енглеском језику."));
              
         }
         query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);  
        prijava.setImaGreske(8);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         }
        else {
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Морате да напишете било шта у пољима за коментаре да бисте послали."));
         }
        komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
        return "pregledPrijaveSluzba1";
      }
      
      public String komentarisi2Z(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!komBio.isEmpty()){
            for(int i = 0; i < komBio.length(); i++) {
             if(!(Character.UnicodeBlock.of(komBio.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komBio.charAt(i))) || (Character.UnicodeBlock.of(komBio.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                   context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 
                 return "pregledPrijaveSluzba1";
            }
        }
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Zamtosluzba zahtev=(Zamtosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Student where username in (select idStudent from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Student> listSt=query.list();
         Student student=listSt.get(0);
         KomentariSluzbaStudentz komentar;
         komentar=new KomentariSluzbaStudentz(zahtev.getIdZamToSluzba(), student.getUsername(), komBio);
            session.save(komentar);
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за биографију студента."));
        query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);  
        prijava.setImaGreske(8);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         }
        else {
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Морате да напишете било шта у пољима за коментаре да бисте послали."));
         }
        komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
        return "pregledPrijaveSluzba1";
      }
      
      public String komentarisi3Z(){
        
          FacesContext context = FacesContext.getCurrentInstance();
        if (!komPredmet.isEmpty() || !komSadrzaj.isEmpty()){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Zamtosluzba zahtev=(Zamtosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Student where username in (select idStudent from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Student> listSt=query.list();
         Student student=listSt.get(0);
         KomentariSluzbaStudentz komentar;
         if (!komPredmet.isEmpty()){
             for(int i = 0; i < komPredmet.length(); i++) {
             if(!(Character.UnicodeBlock.of(komPredmet.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komPredmet.charAt(i))) || (Character.UnicodeBlock.of(komPredmet.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                   context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                 if (session != null && session.isOpen()) {
                session.close();
          }
                 return "pregledPrijaveSluzba1";
            }
        }
            komentar=new KomentariSluzbaStudentz(zahtev.getIdZamToSluzba(), student.getUsername(), komPredmet);
            session.save(komentar);
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за предмет, циљ и методе."));
              
        }
         if (!komSadrzaj.isEmpty()){
             for(int i = 0; i < komSadrzaj.length(); i++) {
             if(!(Character.UnicodeBlock.of(komSadrzaj.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komSadrzaj.charAt(i))) || (Character.UnicodeBlock.of(komSadrzaj.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                  context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                 if (session != null && session.isOpen()) {
                session.close();
          }
                 return "pregledPrijaveSluzba1";
            }
        }
            komentar=new KomentariSluzbaStudentz(zahtev.getIdZamToSluzba(), student.getUsername(), komSadrzaj);
            session.save(komentar);
            context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за садржај и резултате."));
              
         }
         query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);  
        prijava.setImaGreske(8);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         }
        else {
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Морате да напишете било шта у пољима за коментаре да бисте послали."));
         }
        komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
          return "pregledPrijaveSluzba1";
      }
      
      //zamenik
      
      
      public String komentarisi1Ruk(){
        FacesContext context = FacesContext.getCurrentInstance();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Ruktosluzba zahtev=(Ruktosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Mentor where username in (select idMentor from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+"))");
         List<Mentor> listMen=query.list();
         Mentor mentor=listMen.get(0);
         KomentariSluzbaMentor komentar;
         komentar=new KomentariSluzbaMentor(zahtev.getIdRukToSluzba(), 0, mentor.getUsername(),"Дата пријава је неважећа, мораћете да начините измене у формулару пријаве.");
         session.save(komentar);
         context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили руководиоцу рада пријаву на поновну обраду."));
         query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        prijava.setImaGreske(7);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
        return "pregledPrijaveSluzba";
      }
      
      public String komentarisi2Ruk(){
        FacesContext context = FacesContext.getCurrentInstance();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Ruktosluzba zahtev=(Ruktosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Mentor where username in (select idMentor from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+"))");
         List<Mentor> listMen=query.list();
         Mentor mentor=listMen.get(0);
         KomentariSluzbaMentor komentar;
         komentar=new KomentariSluzbaMentor(zahtev.getIdRukToSluzba(), 0, mentor.getUsername(), "Дата пријава је неважећа, мораћете да начините измене у биографији студента.");
            session.save(komentar);
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили руководиоцу рада пријаву на поновну обраду."));
          query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        prijava.setImaGreske(7);
        session.update(prijava);
            session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
         return "pregledPrijaveSluzba";
      }
      
      public String komentarisi3Ruk(){
        
          FacesContext context = FacesContext.getCurrentInstance();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Ruktosluzba zahtev=(Ruktosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Mentor where username in (select idMentor from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+"))");
         List<Mentor> listMen=query.list();
         Mentor mentor=listMen.get(0);
         KomentariSluzbaMentor komentar;
        
            komentar=new KomentariSluzbaMentor(zahtev.getIdRukToSluzba(), 0,  mentor.getUsername(), "Дата пријава је неважећа, мораћете да начините измене у образложењу теме.");
            session.save(komentar);
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили руководиоцу рада пријаву на поновну обраду."));
         query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        prijava.setImaGreske(7);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
          return "pregledPrijaveSluzba";
      }
      
      //zamenik
      
       public String komentarisi1Zam(){
        FacesContext context = FacesContext.getCurrentInstance();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Zamtosluzba zahtev=(Zamtosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Mentor where username in (select idMentor from Prijava where idMentor<>idRukovodilac and idRukovodilac in (select username from RukovodilacModula where sprecen=1) and idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Mentor> listMen=query.list();
         if (!listMen.isEmpty()){
            Mentor mentor=listMen.get(0);
            KomentariSluzbaMentor komentar;
            komentar=new KomentariSluzbaMentor(0, zahtev.getIdZamToSluzba(), mentor.getUsername(), "Дата пријава је неважећа, мораћете да начините измене у формулару пријаве.");
            session.save(komentar);
            context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили руководиоцу рада пријаву на поновну обраду."));
            query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
            List<Prijava> listaPrijava=query.list();
            Prijava prijava=listaPrijava.get(0);  
            prijava.setImaGreske(7);
            session.update(prijava);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
            komEn=null;
            komSer=null;
            komBio=null;
            komPredmet=null;
            komSadrzaj=null;
            return "pregledPrijaveSluzba1";
         }
         query=session.createQuery("from Zamenik where username in (select idMentorZ from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Zamenik> listZam=query.list();
         Zamenik mentor=listZam.get(0);
         KomentariSluzbaZamenik komentar;
         komentar=new KomentariSluzbaZamenik(zahtev.getIdZamToSluzba(),mentor.getUsername(),"Дата пријава је неважећа, мораћете да начините измене у формулару пријаве.");
         session.save(komentar);
         context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили заменику руководиоца рада пријаву на поновну обраду."));
         query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
         List<Prijava> listaPrijava=query.list();
         Prijava prijava=listaPrijava.get(0);  
         prijava.setImaGreske(7);
         session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
        return "pregledPrijaveSluzba1";
      }
      
      public String komentarisi2Zam(){
        FacesContext context = FacesContext.getCurrentInstance();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Zamtosluzba zahtev=(Zamtosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Mentor where username in (select idMentor from Prijava where idMentor<>idRukovodilac and idRukovodilac in (select username from RukovodilacModula where sprecen=1) and idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Mentor> listMen=query.list();
         if (!listMen.isEmpty()){
            Mentor mentor=listMen.get(0);
            KomentariSluzbaMentor komentar;
            komentar=new KomentariSluzbaMentor(0, zahtev.getIdZamToSluzba(), mentor.getUsername(), "Дата пријава је неважећа, мораћете да начините измене у биографији студента.");
            session.save(komentar);
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили руководиоцу рада пријаву на поновну обраду."));
            query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
            List<Prijava> listaPrijava=query.list();
            Prijava prijava=listaPrijava.get(0);  
            prijava.setImaGreske(7);
            session.update(prijava);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
            komEn=null;
            komSer=null;
            komBio=null;
            komPredmet=null;
            komSadrzaj=null;
            return "pregledPrijaveSluzba1";
         }
         query=session.createQuery("from Zamenik where username in (select idMentorZ from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Zamenik> listZam=query.list();
         Zamenik mentor=listZam.get(0);
         KomentariSluzbaZamenik komentar;
         komentar=new KomentariSluzbaZamenik(zahtev.getIdZamToSluzba(), mentor.getUsername(), "Дата пријава је неважећа, мораћете да начините измене у биографији студента.");
            session.save(komentar);
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили заменику руководиоца рада пријаву на поновну обраду."));
          
            query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);  
        prijava.setImaGreske(7);
        session.update(prijava);
            session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
         return "pregledPrijaveSluzba1";
      }
      
      public String komentarisi3Zam(){
        
          FacesContext context = FacesContext.getCurrentInstance();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Zamtosluzba zahtev=(Zamtosluzba) httpSession.getAttribute("zahtev");
         Query query=session.createQuery("from Mentor where username in (select idMentor from Prijava where idMentor<>idRukovodilac and idRukovodilac in (select username from RukovodilacModula where sprecen=1) and idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Mentor> listMen=query.list();
         if (!listMen.isEmpty()){
            Mentor mentor=listMen.get(0);
            KomentariSluzbaMentor komentar;
            komentar=new KomentariSluzbaMentor(0, zahtev.getIdZamToSluzba(), mentor.getUsername(), "Дата пријава је неважећа, мораћете да начините измене у образложењу мастер теме.");
            session.save(komentar);
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили руководиоцу рада пријаву на поновну обраду."));
            query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
            List<Prijava> listaPrijava=query.list();
            Prijava prijava=listaPrijava.get(0);  
            prijava.setImaGreske(7);
            session.update(prijava);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
            komEn=null;
            komSer=null;
            komBio=null;
            komPredmet=null;
            komSadrzaj=null;
            return "pregledPrijaveSluzba1";
         }
         query=session.createQuery("from Zamenik where username in (select idMentorZ from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+"))");
         List<Zamenik> listZam=query.list();
         Zamenik mentor=listZam.get(0);
         KomentariSluzbaZamenik komentar;
        
            komentar=new KomentariSluzbaZamenik(zahtev.getIdZamToSluzba(), mentor.getUsername(), "Дата пријава је неважећа, мораћете да начините измене у образложењу теме.");
            session.save(komentar);
            context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте вратили заменику руководиоца рада пријаву на поновну обраду."));
         query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);  
        prijava.setImaGreske(7);
        session.update(prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
          return "pregledPrijaveSluzba1";
      }
      
      
      //zamenik
      
      
    
      public String clan1(String username){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Korisnik where username='"+username+"'");
         List<Korisnik> listKor1=query.list();
         ipKom1=listKor1.get(0).getIme()+" "+listKor1.get(0).getPrezime();
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
         ipKom2=listKor2.get(0).getIme()+" "+listKor2.get(0).getPrezime();
          session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return ipKom2;
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
      
      public String odr1(Ruktosluzba zahtev){
          
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
         List<Prijava> listPrijava=query.list();
         Prijava prijava=listPrijava.get(0);
         
         FacesContext context = FacesContext.getCurrentInstance();
         if (prijava.getImaGreske()==0 && prijava.getPrijavljena()==1){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Нема потребе да се састанак одржи пошто је пријава потврђена."));
             session.getTransaction().commit();
              if (session != null && session.isOpen()) {
              session.close();
            }
            return "sluzba_pocetna";
         }
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         httpSession.setAttribute("prijavaS", prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return "sastanak?faces-redirect=true";
      }
      
      public String odr2(Zamtosluzba zahtev){
          Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
         List<Prijava> listPrijava=query.list();
         Prijava prijava=listPrijava.get(0);
         
         FacesContext context = FacesContext.getCurrentInstance();
         if (prijava.getImaGreske()==0 && prijava.getPrijavljena()==1){
              context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Нема потребе да се састанак одржи пошто је пријава потврђена."));
              session.getTransaction().commit();
              if (session != null && session.isOpen()) {
              session.close();
            }
            return "sluzba_pocetna";
         }
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         httpSession.setAttribute("prijavaS", prijava);
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
          return "sastanak?faces-redirect=true";
      }
      
      public String napravi(){
         FacesContext context = FacesContext.getCurrentInstance();
         if (ipKom1.equals(ipKom2)){
             context.addMessage(messageSastanak.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Чланови комисије не смеју бити идентични!"));
             return "sastanak";
         }
         if (datum==null){
              context.addMessage(messageSastanak.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Датум састанка мора да буде унет!"));
             return "sastanak";
         }
         Calendar cal=Calendar.getInstance();
         Date d=cal.getTime();
         
         if (datum.before(d)){
             context.addMessage(messageSastanak.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Датум састанка не сме бити пре тренутног датума!"));
             return "sastanak";
         }
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Korisnik sluzba=(Korisnik) httpSession.getAttribute("sluzba");
         Prijava prijava=(Prijava) httpSession.getAttribute("prijavaS");
         int index=0;
        String ment=ipKom1;
        while (!Character.isWhitespace(ment.charAt(index))) index++;
        String imeKom1=ment.substring(0, index);
        ment=ipKom1;
        String prezimeKom1=ment.substring(index+1);
        index=0;
        ment=ipKom2;
        while (!Character.isWhitespace(ment.charAt(index))) index++;
        String imeKom2=ment.substring(0, index);
        ment=ipKom2;
        String prezimeKom2=ment.substring(index+1);
        Query query=session.createQuery("from Korisnik where username in (select username from Uprava) and ime='"+imeKom1+"' and prezime='"+prezimeKom1+"'");
        List<Korisnik> listKor1=query.list();
        Korisnik kor1=listKor1.get(0);
        query=session.createQuery("from Korisnik where username in (select username from Uprava) and ime='"+imeKom2+"' and prezime='"+prezimeKom2+"'");
        List<Korisnik> listKor2=query.list();
        Korisnik kor2=listKor2.get(0);
         Sastanak sastanak=new Sastanak(sluzba.getUsername(), kor1.getUsername(), kor2.getUsername(), prijava.getIdPrijava(), datum, 0);
         session.save(sastanak);
        session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         query=session.createQuery("from Sastanak where idSluzba='"+sluzba.getUsername()+"'");
         List<Sastanak> lista1=new ArrayList<>();
         lista1=query.list();
         httpSession.setAttribute("sastanci", lista1);
         context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно направљен састанак."));
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return "sluzba_pocetna";
      }
      
     /* public String izaberiSastanak(Sastanak sastanak){
          
        FacesContext context = FacesContext.getCurrentInstance();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         if (sastanak.getOdrzan()==1){
         Query query=session.createQuery("from Sastanak where idSastanak="+sastanak.getIdSastanak()+"");
         List<Sastanak> listSastanaka=query.list();
         Sastanak odSastanak=listSastanaka.get(0);
         query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava1()+"'");
         List<Korisnik> listKor1=query.list();
         ipKomisija1=listKor1.get(0).getIme()+" "+listKor1.get(0).getPrezime();
         
         query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava2()+"'");
         List<Korisnik> listKor2=query.list();
         ipKomisija2=listKor2.get(0).getIme()+" "+listKor2.get(0).getPrezime();
         datum1=odSastanak.getDatum();
         context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Можете да ажурирате пријаву и/или потврдите."));
             
         }
         else {
             ipKomisija1="";
             ipKomisija2="";
             datum1=null;
         }
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return "sluzba_pocetna";
      }*/
      
      
      
      public String potvrdi(Ruktosluzba zahtev){
        prijavljeno=false;
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+") and prihvata<>2");
        List<Prijava> listaPrijava=query.list();
        if (listaPrijava.isEmpty()){
            context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Пријава не може да се потврди без потврде комисије!"));
             session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
            return "sluzba_pocetna";
        }
        Prijava odabranaPrijava=listaPrijava.get(0);
        query=session.createQuery("from Sastanak where idSluzba='"+zahtev.getIdSluzba()+"' and odrzan=1 and idPrijava="+odabranaPrijava.getIdPrijava()+" and idPrijava in (select idPrijava from Prijava where prihvata<>2)");
        if (query.list().isEmpty()){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Потребан Вам је закључак комисије за студије другог степена К2!"));
             session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
        return "sluzba_pocetna";
        }
        
         List<Sastanak> listSastanaka=query.list();
         Sastanak odSastanak=listSastanaka.get(0);
        query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava1()+"'");
         List<Korisnik> listKor1=query.list();
         ipKomisija1=listKor1.get(0).getIme()+" "+listKor1.get(0).getPrezime();
         
         query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava2()+"'");
         List<Korisnik> listKor2=query.list();
         ipKomisija2=listKor2.get(0).getIme()+" "+listKor2.get(0).getPrezime();
         datum1=odSastanak.getDatum();
        if (odabranaPrijava.getPrijavljena()==1) {
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
            return "success";
        }
        
        prijavljeno=true;
        odabranaPrijava.setImaGreske(0);
        odabranaPrijava.setPrijavljena(1);
        session.update(odabranaPrijava);
        
        KomentariSluzbaStudent komentar=new KomentariSluzbaStudent(zahtev.getIdRukToSluzba(), odabranaPrijava.getIdStudent(), "Ваша пријава теме је успешно потврђена!");
        session.save(komentar);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
         session.close();
         }
        return "success";
      }
      
      public String potvrdi1(Zamtosluzba zahtev){
        prijavljeno=false;
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+") and prihvata<>2");
        List<Prijava> listaPrijava=query.list();
        if (listaPrijava.isEmpty()){
            context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Пријава не може да се потврди без потврде комисије!"));
             session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
            return "sluzba_pocetna";
        }
        Prijava odabranaPrijava=listaPrijava.get(0);
        query=session.createQuery("from Sastanak where idSluzba='"+zahtev.getIdSluzba()+"' and odrzan=1 and idPrijava="+odabranaPrijava.getIdPrijava()+" and idPrijava in (select idPrijava from Prijava where prihvata<>2)");
        if (query.list().isEmpty()){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Потребан Вам је закључак комисије за студије другог степена К2!"));
             session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
        return "sluzba_pocetna";
        }
        List<Sastanak> listSastanaka=query.list();
         Sastanak odSastanak=listSastanaka.get(0);
        query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava1()+"'");
         List<Korisnik> listKor1=query.list();
         ipKomisija1=listKor1.get(0).getIme()+" "+listKor1.get(0).getPrezime();
         
         query=session.createQuery("from Korisnik where username='"+odSastanak.getIdUprava2()+"'");
         List<Korisnik> listKor2=query.list();
         ipKomisija2=listKor2.get(0).getIme()+" "+listKor2.get(0).getPrezime();
         datum1=odSastanak.getDatum();
        if (odabranaPrijava.getPrijavljena()==1) {
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
            session.close();
            }
            return "success";
        }
        
        prijavljeno=true;
        odabranaPrijava.setImaGreske(0);
        odabranaPrijava.setPrijavljena(1);
        session.update(odabranaPrijava);
        
        KomentariSluzbaStudentz komentar=new KomentariSluzbaStudentz(zahtev.getIdZamToSluzba(), odabranaPrijava.getIdStudent(), "Ваша пријава теме је успешно потврђена!");
        session.save(komentar);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
         session.close();
         }
        return "success";
      }
      
      public String pregVer1(Ruktosluzba ruktosluzba){
          FacesContext context = FacesContext.getCurrentInstance();
          Session session = HibernateUtil.getSessionFactory().getCurrentSession();
          session.beginTransaction();  
          Query query=session.createQuery("from VerzijaPrijave where idPrijava in (select idPrijava from Menttoruk where idMenttoruk="+ruktosluzba.getIdMentToRuk()+")  order by datumVer desc, vremeVer desc");
          List<VerzijaPrijave> listVerzija=query.list();
          HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
          httpSession.setAttribute("listaVerzija", listVerzija);
           session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return "listaVerzijaSluzba";
      }
      
      public String pregVer2(Zamtosluzba zamtosluzba){
          FacesContext context = FacesContext.getCurrentInstance();
          Session session = HibernateUtil.getSessionFactory().getCurrentSession();
          session.beginTransaction();  
          Query query=session.createQuery("from VerzijaPrijave where idPrijava in (select idPrijava from Menttozam where idMenttozam="+zamtosluzba.getIdMentToZam()+")  order by datumVer desc, vremeVer desc");
          List<VerzijaPrijave> listVerzija=query.list();
          HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
          httpSession.setAttribute("listaVerzija", listVerzija);
          session.getTransaction().commit();
             if (session != null && session.isOpen()) {
                session.close();
           }
             return "listaVerzijaSluzba";
      }
      
      public String pregVer(VerzijaPrijave verzija){
       FacesContext context = FacesContext.getCurrentInstance();
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
        stampaj=false; 
       Query queryVer=session.createQuery("from VerzijaPrijave where idPrijava="+verzija.getIdPrijava()+" order by datumVer desc, vremeVer desc");
       List<VerzijaPrijave> listVerzija=queryVer.list();
       VerzijaPrijave verzijaPos=listVerzija.get(0);
       if (verzijaPos.getIdVer().equals(verzija.getIdVer())) stampaj=true;
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
        return "verzijaKodSluzbe";
   }
      
      public String obrisi(Ruktosluzba zahtev){
          
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
         List<Prijava> listPrijava=query.list();
         Prijava prijava=listPrijava.get(0);
         
         FacesContext context = FacesContext.getCurrentInstance();
         if (prijava.getIdRad()==0){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Тема је већ обрисана."));
             session.getTransaction().commit();
              if (session != null && session.isOpen()) {
              session.close();
            }
            return "sluzba_pocetna";
         }
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         prijava.setIdRad(0);
         session.update(prijava);
         context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Тема је обрисана."));
             
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return "sluzba_pocetna";
      
      }
      public boolean pro(Ruktosluzba zahtev){
          
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
         List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        if (prijava.getIdRad()==0) {
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return true;
        }
        session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return false;
       }
      
      
       public String vrati(Ruktosluzba zahtev){
          
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttoruk where idMentToRuk="+zahtev.getIdMentToRuk()+")");
         List<Prijava> listPrijava=query.list();
         Prijava prijava=listPrijava.get(0);
         
         FacesContext context = FacesContext.getCurrentInstance();
         if (prijava.getIdRad()!=0){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Тема није обрисана, па не треба је вратити."));
             session.getTransaction().commit();
              if (session != null && session.isOpen()) {
              session.close();
            }
            return "sluzba_pocetna";
         } 
         query=session.createQuery("from VerzijaPrijave where idPrijava="+prijava.getIdPrijava()+"");
         List<VerzijaPrijave> listVer=query.list();
         VerzijaPrijave verzija=listVer.get(listVer.size()-1);
         prijava.setIdRad(verzija.getIdRad());
         session.update(prijava);
         context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Тема је враћена."));
             
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return "sluzba_pocetna";
      
      }
      
      public String obrisi1(Zamtosluzba zahtev){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
         if (prijava.getIdRad()==0){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Тема је већ обрисана."));
             
             session.getTransaction().commit();
              if (session != null && session.isOpen()) {
              session.close();
            }
            return "sluzba_pocetna";
         }
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         prijava.setIdRad(0);
         session.update(prijava);
         context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Тема је обрисана."));
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return "sluzba_pocetna";
      }
      public String vrati1(Zamtosluzba zahtev){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
       
         if (prijava.getIdRad()!=0){
             context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Тема није обрисана, па не треба је вратити."));
             session.getTransaction().commit();
              if (session != null && session.isOpen()) {
              session.close();
            }
            return "sluzba_pocetna";
         } 
         query=session.createQuery("from VerzijaPrijave where idPrijava="+prijava.getIdPrijava()+"");
         List<VerzijaPrijave> listVer=query.list();
         VerzijaPrijave verzija=listVer.get(listVer.size()-1);
         prijava.setIdRad(verzija.getIdRad());
         session.update(prijava);
         context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Тема је враћена."));
             
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return "sluzba_pocetna";
      
          
      }
       public boolean pro1(Zamtosluzba zahtev){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query=session.createQuery("from Prijava where idPrijava in (select idPrijava from Menttozam where idMentToZam="+zahtev.getIdMentToZam()+")");
        List<Prijava> listaPrijava=query.list();
        Prijava prijava=listaPrijava.get(0);
        if (prijava.getIdRad()==0) {
         session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return true;
        }
        session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return false;
       }
      
      
}

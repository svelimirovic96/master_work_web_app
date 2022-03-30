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
import beans.Predmet;
import beans.Prijava;
import beans.RukovodilacModula;
import beans.Ruktosluzba;
import beans.Sastanak;
import beans.StudentskaSluzba;
import beans.Uprava;
import beans.VerzijaPrijave;
import beans.Zamenik;
import beans.Zamtosluzba;
import java.util.ArrayList;
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

/**
 *
 * @author Sandra
 */
@ManagedBean(name = "login")
@SessionScoped
public class Login {

    private String username, password, ime, prezime, nazivModula, indeksStudenta, rukovodilacModula;
    private UIComponent messagePrijava, messageUlaz;
    private List<Modul> listaModula=new ArrayList<>();
    private List<Korisnik> listaRukovodioca=new ArrayList<>();
    private List<Korisnik> mentorList=new ArrayList<>();
    private List<String> listMentor=new ArrayList<>();
    private List<Prijava> listaPrijavaZaMentora=new ArrayList<>();
    private List<Prijava> listaPrijavaZaMentora2=new ArrayList<>();
    private List<Menttoruk> listaMenttoruk=new ArrayList<>();
    private List<Menttozam> listaMenttozam=new ArrayList<>();
    private List<String> listaOsobaSluzbe=new ArrayList<>();
    private List<Ruktosluzba> listaZahtevaSluzbi=new ArrayList<>();
    private List<Zamtosluzba> listaZahtevaSluzbi1=new ArrayList<>();
    private List<String> listUprava=new ArrayList<>();
    private List<String> listZamenika=new ArrayList<>();
    private boolean prijavljena;
    private List<Korisnik> listaRukovodilacaZaZamenu=new ArrayList<>();
    private boolean sprecen;
    private String ipZamenik;
    private UIComponent messageSprecen;
    
    
    public List<Prijava> getListaPrijavaZaMentora2() {
        return listaPrijavaZaMentora2;
    }

    public void setListaPrijavaZaMentora2(List<Prijava> listaPrijavaZaMentora2) {
        this.listaPrijavaZaMentora2 = listaPrijavaZaMentora2;
    }

    
    
    public List<Zamtosluzba> getListaZahtevaSluzbi1() {
        return listaZahtevaSluzbi1;
    }

    public void setListaZahtevaSluzbi1(List<Zamtosluzba> listaZahtevaSluzbi1) {
        this.listaZahtevaSluzbi1 = listaZahtevaSluzbi1;
    }

    
    
    public String getIpZamenik() {
        return ipZamenik;
    }

    public void setIpZamenik(String ipZamenik) {
        this.ipZamenik = ipZamenik;
    }

    
    
    public UIComponent getMessageSprecen() {
        return messageSprecen;
    }

    public void setMessageSprecen(UIComponent messageSprecen) {
        this.messageSprecen = messageSprecen;
    }
    
    

    public boolean isSprecen() {
        return sprecen;
    }

    public void setSprecen(boolean sprecen) {
        this.sprecen = sprecen;
    }
    
    

    public List<Korisnik> getListaRukovodilacaZaZamenu() {
        return listaRukovodilacaZaZamenu;
    }

    public void setListaRukovodilacaZaZamenu(List<Korisnik> listaRukovodilacaZaZamenu) {
        this.listaRukovodilacaZaZamenu = listaRukovodilacaZaZamenu;
    }
    
    

    public List<Menttozam> getListaMenttozam() {
        return listaMenttozam;
    }

    public void setListaMenttozam(List<Menttozam> listaMenttozam) {
        this.listaMenttozam = listaMenttozam;
    }

    
    
    public List<String> getListZamenika() {
        return listZamenika;
    }

    public void setListZamenika(List<String> listZamenika) {
        this.listZamenika = listZamenika;
    }

    
    
    public boolean isPrijavljena() {
        return prijavljena;
    }

    public void setPrijavljena(boolean prijavljena) {
        this.prijavljena = prijavljena;
    }
    
    

    public List<String> getListUprava() {
        return listUprava;
    }

    public void setListUprava(List<String> listUprava) {
        this.listUprava = listUprava;
    }
    public List<Ruktosluzba> getListaZahtevaSluzbi() {
        return listaZahtevaSluzbi;
    }

    public void setListaZahtevaSluzbi(List<Ruktosluzba> listaZahtevaSluzbi) {
        this.listaZahtevaSluzbi = listaZahtevaSluzbi;
    }

    
    
    public List<String> getListaOsobaSluzbe() {
        return listaOsobaSluzbe;
    }

    public void setListaOsobaSluzbe(List<String> listaOsobaSluzbe) {
        this.listaOsobaSluzbe = listaOsobaSluzbe;
    }

    public List<Prijava> getListaPrijavaZaMentora() {
        return listaPrijavaZaMentora;
    }

    public void setListaPrijavaZaMentora(List<Prijava> listaPrijavaZaMentora) {
        this.listaPrijavaZaMentora = listaPrijavaZaMentora;
    }

    public List<Menttoruk> getListaMenttoruk() {
        return listaMenttoruk;
    }

    public void setListaMenttoruk(List<Menttoruk> listaMenttoruk) {
        this.listaMenttoruk = listaMenttoruk;
    }
    
    

   
    public List<String> getListMentor() {
        return listMentor;
    }

    public void setListMentor(List<String> listMentor) {
        this.listMentor = listMentor;
    }

    public List<Korisnik> getMentorList() {
        return mentorList;
    }

    public void setMentorList(List<Korisnik> mentorList) {
        this.mentorList = mentorList;
    }
    
    

    public String getRukovodilacModula() {
        return rukovodilacModula;
    }

    public void setRukovodilacModula(String rukovodilacModula) {
        this.rukovodilacModula = rukovodilacModula;
    }

    public List<Korisnik> getListaRukovodioca() {
        return listaRukovodioca;
    }

    public void setListaRukovodioca(List<Korisnik> listaRukovodioca) {
        this.listaRukovodioca = listaRukovodioca;
    }

    public String getIndeksStudenta() {
        return indeksStudenta;
    }

    public void setIndeksStudenta(String indeksStudenta) {
        this.indeksStudenta = indeksStudenta;
    }

    public List<Modul> getListaModula() {
        return listaModula;
    }

    public void setListaModula(List<Modul> listaModula) {
        this.listaModula = listaModula;
    }

    public String getNazivModula() {
        return nazivModula;
    }

    public void setNazivModula(String nazivModula) {
        this.nazivModula = nazivModula;
    }

    public UIComponent getMessageUlaz() {
        return messageUlaz;
    }

    public void setMessageUlaz(UIComponent messageUlaz) {
        this.messageUlaz = messageUlaz;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public UIComponent getMessagePrijava() {
        return messagePrijava;
    }

    public void setMessagePrijava(UIComponent messagePrijava) {
        this.messagePrijava = messagePrijava;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login(){
        prijavljena=false;
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
         String adresa="index";
        Korisnik k=(Korisnik) session.get(Korisnik.class, username);
        if (k==null){
            
            context.addMessage(messagePrijava.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Некоректно корисничко име или лозинка!"));
            adresa="index";
        }
        else if (!password.equals(k.getPassword())){
            context.addMessage(messagePrijava.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Некоректна лозинка!"));
            adresa="index";
        }
        else {
        ime=k.getIme();
        prezime=k.getPrezime();
        Query query=session.createQuery("from Student where Username='"+username+"'");
        if (query.list().size()==1){
            String ind=username.substring(2, 8);
            if (Integer.parseInt(ind.substring(0, 2))>=0 && Integer.parseInt(ind.substring(0, 2))<=21) indeksStudenta="20"+ind.substring(0,2);
            else indeksStudenta="19"+ind.substring(0,2);
            indeksStudenta+="/"+ind.substring(2);
           // context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Добродошли, '"+ime+"' '"+prezime+"'."));
            query=session.createQuery("from Modul where idModul in (select idModul from Student where username='"+username+"')");
            listaModula=query.list();
            nazivModula=listaModula.get(0).getNaziv();
            query=session.createQuery("from Korisnik where username=(select username from RukovodilacModula where idModul=(select idModul from Modul where naziv='"+nazivModula+"'))");
            listaRukovodioca=query.list();
            rukovodilacModula=listaRukovodioca.get(0).getIme()+" "+listaRukovodioca.get(0).getPrezime();
            query=session.createQuery("from Korisnik where username in "
                + "(select idMentor from Predaje where idPredmet in "
                + "(select idPredmet from Predmet where idModul=(select idModul from Modul"
                + " where naziv='"+nazivModula+"') and idStudent='"+username+"'))");
            mentorList=query.list();
            int i=0;
            while (i<mentorList.size()){
                listMentor.add(mentorList.get(i).getIme()+" "+mentorList.get(i).getPrezime());
                i++;
            }
            HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
            httpSession.setAttribute("student", k);
            query=session.createQuery("from Prijava where idStudent='"+username+"'");
            List<Prijava> listPrijava=query.list();
            if (listPrijava.isEmpty())
                adresa="student";
            else 
            { 
                adresa="podesiti_prijavu";
                Prijava prijava=listPrijava.get(0);
                String naslov="";  //deklarisati
                String radPredmet=""; //deklarisati
                String radSadrzaj="";
                query=session.createQuery("from Predmet where idPredmet="+prijava.getIdPredmet()+"");
                List<Predmet> listPredmeta=query.list();
                String naslovPredmeta=listPredmeta.get(0).getNaziv(); //deklarisati
                if (prijava.getIdRad()!=0)
                {
                query=session.createQuery("from Masterrad where idRad="+prijava.getIdRad()+"");
                List<Masterrad> listRad=query.list();
                naslov=listRad.get(0).getNazivS();  //deklarisati
                radPredmet=listRad.get(0).getPredmet(); //deklarisati
                radSadrzaj=listRad.get(0).getSadrzaj(); //deklarisati
                
            }
                query=session.createQuery("from KomentariStMent where idPrijava="+prijava.getIdPrijava()+"");
                List<KomentariStMent> listaKomentara=query.list();
                query=session.createQuery("from KomentariSluzbaStudent where idStudent='"+username+"' and idRukToSluzba in (select idRukToSluzba from Ruktosluzba where idMentToRuk in (select idMentToRuk from Menttoruk where idPrijava="+prijava.getIdPrijava()+"))");
                List<KomentariSluzbaStudent> listaKomentara1=query.list(); //deklarisati
                query=session.createQuery("from KomentariSluzbaStudentz where idStudent='"+username+"' and idZamToSluzba in (select idZamToSluzba from Zamtosluzba where idMentToZam in (select idMentToZam from Menttozam where idPrijava="+prijava.getIdPrijava()+"))");
                List<KomentariSluzbaStudentz> listaKomentara2=query.list(); //deklarisati
                query=session.createQuery("from VerzijaPrijave where idPrijava="+prijava.getIdPrijava()+" and idStudent='"+username+"'  order by datumVer desc, vremeVer desc");
                List<VerzijaPrijave> listVerzija=query.list();
                httpSession.setAttribute("verzije", listVerzija);
                httpSession.setAttribute("naslov", naslov);
                httpSession.setAttribute("radPredmet", radPredmet);
                httpSession.setAttribute("radSadrzaj", radSadrzaj);
                httpSession.setAttribute("naslovPredmeta", naslovPredmeta);
                httpSession.setAttribute("listaKomentara", listaKomentara);
                httpSession.setAttribute("listaKomentara1", listaKomentara1);
                httpSession.setAttribute("listaKomentara2", listaKomentara2);
                httpSession.setAttribute("prijava", prijava);
                String statusPrijave="";
                if (listPrijava.get(0).getPrijavljena()==1) prijavljena=true;
                boolean ukiniIzmenu=false;
                switch (listPrijava.get(0).getImaGreske()){
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
                if (listPrijava.get(0).getIdRad()==0) {ukiniIzmenu=true; statusPrijave="Дошло је до грешке, тема је неважећа";}
                httpSession.setAttribute("ukiniIzmenu", ukiniIzmenu); 
               httpSession.setAttribute("statusPrijave", statusPrijave); 
            }
        }
        else { //za rukovodioca
               query=session.createQuery("from RukovodilacModula where Username='"+username+"'");
               if (query.list().size()==1){
                   //  context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Добродошли, '"+ime+"' '"+prezime+"'."));
                   List<RukovodilacModula> listRu=query.list();
                   RukovodilacModula r=listRu.get(0);
                   if (r.getSprecen()==1) sprecen=true;
                   else sprecen=false;
                   query=session.createQuery("from Modul where idModul in (select idModul from RukovodilacModula where username='"+username+"')");
                   listaModula=query.list();
                   nazivModula=listaModula.get(0).getNaziv();
                   query=session.createQuery("from Prijava where idMentor='"+username+"' and rukIliProf=1");
                   listaPrijavaZaMentora=query.list();
                   query=session.createQuery("from Prijava where idMentor='"+username+"' and rukIliProf=0");
                   listaPrijavaZaMentora2=query.list();
                   //dodati listuPrijavaAdaovdenisuRukovodioci
                   query=session.createQuery("from Menttoruk where idRuk='"+username+"' and idRuk<>idMentor");
                   listaMenttoruk=query.list();
                   query=session.createQuery("from StudentskaSluzba");
                   List<StudentskaSluzba> listaUSluzbi=query.list();
                   int l=0;
                   while (l<listaUSluzbi.size()){
                       query=session.createQuery("from Korisnik where username='"+listaUSluzbi.get(l).getUsername()+"'");
                       List<Korisnik> sluzbenaLica=query.list();
                       listaOsobaSluzbe.add(sluzbenaLica.get(0).getIme()+" "+sluzbenaLica.get(0).getPrezime());
                               l++;
                   }
                   query=session.createQuery("from Zamenik");
                   List<Zamenik> listaZamenika=new ArrayList<>();
                   listaZamenika=query.list();
                   l=0;
                   while (l<listaZamenika.size()){
                       query=session.createQuery("from Korisnik where username='"+listaZamenika.get(l).getUsername()+"'");
                       List<Korisnik> lica=query.list();
                       listZamenika.add(lica.get(0).getIme()+" "+lica.get(0).getPrezime());
                       l++;
                   }
                   HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
                     httpSession.setAttribute("rukovodilac", k);
                     httpSession.setAttribute("listaPrijavaZaMentora", listaPrijavaZaMentora);
                     httpSession.setAttribute("listaPrijavaMentoraZaRuk", listaMenttoruk);
                     adresa="rukovodilac_pocetna";
               }
               else { //za zamenika
                   query=session.createQuery("from Zamenik where Username='"+username+"'");
               if (query.list().size()==1){
                   //  context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Добродошли, '"+ime+"' '"+prezime+"'."));
                   query=session.createQuery("from Korisnik where username in (select username from RukovodilacModula where usernameZ='"+username+"')");
                   List<Korisnik> listaRuk=query.list();
                   int v=0;
                   while (v<listaRuk.size()){
                    Korisnik kor=listaRuk.get(v);
                    listaRukovodilacaZaZamenu.add(kor);
                    v++;
                   }
                   query=session.createQuery("from Prijava where idMentorZ='"+username+"' and idRukovodilac=idMentor");
                   listaPrijavaZaMentora=query.list(); //zamenik osobe koja je i profesor i rukovodilac 
                   query=session.createQuery("from Menttozam where idZam='"+username+"' and status<>5 and idPrijava in (select idPrijava from Prijava where idRukovodilac<>idMentor)");
                   listaMenttozam=query.list(); //zamenik osobe koja je samo rukovodilac
                   query=session.createQuery("from StudentskaSluzba");
                   List<StudentskaSluzba> listaUSluzbi=query.list();
                   int l=0;
                   while (l<listaUSluzbi.size()){
                       query=session.createQuery("from Korisnik where username='"+listaUSluzbi.get(l).getUsername()+"'");
                       List<Korisnik> sluzbenaLica=query.list();
                       listaOsobaSluzbe.add(sluzbenaLica.get(0).getIme()+" "+sluzbenaLica.get(0).getPrezime());
                               l++;
                   }
                   HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
                     httpSession.setAttribute("zamenik", k);
                     httpSession.setAttribute("listaPrijavaZaMentora", listaPrijavaZaMentora);
                     httpSession.setAttribute("listaPrijavaMentoraZaZam", listaMenttozam);
                     adresa="zamenik_pocetna";
               
               }
                   else { //za mentora
                   query=session.createQuery("from Mentor where Username='"+username+"'");
                   if (query.list().size()==1){
                        //  context.addMessage(messageUlaz.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Добродошли, '"+ime+"' '"+prezime+"'."));
                        
                         query=session.createQuery("from Prijava where idMentor='"+username+"'");
                         listaPrijavaZaMentora=query.list();
                         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
                         httpSession.setAttribute("mentor", k);
                         httpSession.setAttribute("listaPrijavaZaMentora", listaPrijavaZaMentora);
                         adresa="profesor_pocetna";
                   }
                   else {
                       query=session.createQuery("from StudentskaSluzba where Username='"+username+"'");
                       if (query.list().size()==1){
                            query=session.createQuery("from Ruktosluzba where idSluzba='"+username+"'");
                            listaZahtevaSluzbi=query.list();
                            query=session.createQuery("from Zamtosluzba where idSluzba='"+username+"' and Status<>5");
                            listaZahtevaSluzbi1=query.list();
                            HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
                            query=session.createQuery("from Korisnik where username in (select username from Uprava)");
                            List<Korisnik> upravaList=query.list();
                            int l=0;
                            while (l<upravaList.size()){
                             listUprava.add(upravaList.get(l).getIme()+" "+upravaList.get(l).getPrezime());
                             l++;
                            }
                            query=session.createQuery("from Sastanak where idSluzba='"+username+"'");
                            List<Sastanak> listaSastanaka=new ArrayList<>();
                            listaSastanaka=query.list();
                            httpSession.setAttribute("sluzba", k);
                            httpSession.setAttribute("sastanci", listaSastanaka);
                            adresa="sluzba_pocetna";
                       
                       }
                       else {
                           query=session.createQuery("from Uprava where Username='"+username+"'");
                            if (query.list().size()==1){
                             query=session.createQuery("from Sastanak where idUprava1='"+username+"' or idUprava2='"+username+"' and idPrijava in (select idPrijava from Prijava where Prijavljena=1 and Prihvata=1)");
                             List<Sastanak> listaSastanaka=new ArrayList<>();
                             listaSastanaka=query.list();
                             HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
                             httpSession.setAttribute("uprava", k);
                             httpSession.setAttribute("sastanci", listaSastanaka);
                             adresa="uprava_pocetna";
                            }
                           
                           
                       }
                   }
               } //else za mentora
               
               } //else za zamenika   
          } //else za rukovodioca
        }
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return adresa;
    }
    
    public String odjava(){
       FacesContext context = FacesContext.getCurrentInstance();
       HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
       session.invalidate();
       return "index";
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
       query=session.createQuery("from Masterrad where idRad not in (select idRad from Prijava where idPrijava="+prijava.getIdPrijava()+" and idRad=0)");
       List<Masterrad> listRadova=query.list();
       Masterrad rad=listRadova.get(0);
       session.delete(rad);
       session.delete(prijava);
       session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
       httpSession.invalidate();
       return "index";
    }
    
     public String spreci(){
          
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        int index=0;
        String ment=ipZamenik;
        while (!Character.isWhitespace(ment.charAt(index))) index++;
        String imeZamenika=ment.substring(0, index);
        ment=ipZamenik;
        String prezimeZamenika=ment.substring(index+1);
        Query query=session.createQuery("from Korisnik where ime='"+imeZamenika+"' and prezime='"+prezimeZamenika+"'");
        List<Korisnik> zamenici=query.list();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Korisnik ruk=(Korisnik) httpSession.getAttribute("rukovodilac");
        query=session.createQuery("from RukovodilacModula where username='"+ruk.getUsername()+"'");
        List<RukovodilacModula> listRuk=query.list();
        RukovodilacModula rukov=listRuk.get(0);
        rukov.setUsernameZ(zamenici.get(0).getUsername());
        rukov.setSprecen(1);
        session.update(rukov);
        query=session.createQuery("from Prijava where idRukovodilac='"+ruk.getUsername()+"'");
        List<Prijava> listPrijava=query.list();
        if (!listPrijava.isEmpty()){
            int i=0;
            while (i<listPrijava.size()){
                Prijava prij=listPrijava.get(i);
                prij.setIdMentorZ(zamenici.get(0).getUsername());
                session.update(prij);
                i++;
            }
        }
            query=session.createQuery("from Menttoruk where idRuk='"+ruk.getUsername()+"' and idRuk in (select idRukovodilac from Prijava where idRukovodilac<>idMentor)");
            List<Menttoruk> listMenttoruk=query.list();
            if (!listMenttoruk.isEmpty()){
                int i=0;
                while (i<listMenttoruk.size()){
                    Menttoruk menttoruk=listMenttoruk.get(i);
                    Menttozam menttozam=new Menttozam(menttoruk.getIdPrijava(), menttoruk.getIdMentor(),zamenici.get(0).getUsername(), 0);
                    session.save(menttozam);
                    i++;
                }
            }
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
         }
        sprecen=true;
        context.addMessage(messageSprecen.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Спречени сте да прегледате пријаву студента и захтеве професора и да пошаљете захтеве Студентској служби."));
        return "rukovodilac_pocetna";
      }
      
      public String nastavi(){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Korisnik ruk=(Korisnik) httpSession.getAttribute("rukovodilac");
        Query query=session.createQuery("from RukovodilacModula where username='"+ruk.getUsername()+"'");
        List<RukovodilacModula> listRuk=query.list();
        RukovodilacModula rukov=listRuk.get(0);
        query=session.createQuery("from Menttozam where idZam='"+rukov.getUsernameZ()+"' and idMentor in (select idMentor from Prijava where idRukovodilac='"+rukov.getUsername()+"') and idPrijava in  (select idPrijava from Prijava where idRukovodilac='"+rukov.getUsername()+"')");
        List<Menttozam> listMenttozam=query.list();
        if (!listMenttozam.isEmpty()){
            int i=0;
            while (i<listMenttozam.size()){
                Menttozam menttozam=listMenttozam.get(i);
                i++;
                /*query=session.createQuery("from KomentariMentZam where idMentToZam="+menttozam.getIdMentToZam()+"");
                List<KomentariMentZam> listMentZam=query.list();
                while (!listMentZam.isEmpty()){
                    KomentariMentZam kom=listMentZam.remove(0);
                    session.delete(kom);
                }*/
                query=session.createQuery("from Zamtosluzba where idMentToZam="+menttozam.getIdMentToZam()+"");
                List<Zamtosluzba> listZamSluzba=query.list();
                int j=0;
                 while (j<listZamSluzba.size()){
                    Zamtosluzba zamToSluzba=listZamSluzba.get(j);
                    j++;
                    zamToSluzba.setStatus(5);
                    /*query=session.createQuery("from KomentariSluzbaZamenik where idZamToSluzba="+zamToSluzba.getIdZamToSluzba()+"");
                    List<KomentariSluzbaZamenik> listSluzbaZam=query.list();
                    while (!listSluzbaZam.isEmpty()){
                    KomentariSluzbaZamenik kom=listSluzbaZam.remove(0);
                    session.delete(kom);
                }
                    query=session.createQuery("from KomentariSluzbaStudentz where idZamToSluzba="+zamToSluzba.getIdZamToSluzba()+"");
                    List<KomentariSluzbaStudentz> listSluzbaZamZ=query.list();
                    while (!listSluzbaZamZ.isEmpty()){
                    KomentariSluzbaStudentz kom=listSluzbaZamZ.remove(0);
                    session.delete(kom);
                }*/
                    session.update(zamToSluzba);
                }
                menttozam.setStatus(5);
                session.update(menttozam);
            }
        }//videti da li brisati sve zaredom ili podesiti ali da se ne pojavljuje
        
            query=session.createQuery("from Prijava where idMentorZ='"+rukov.getUsernameZ()+"' and idRukovodilac='"+rukov.getUsername()+"'");
            List<Prijava> listPrijava=query.list();
            if (!listPrijava.isEmpty()){
                int i=0;
            while (i<listPrijava.size()){
                
                Prijava prijava=listPrijava.get(i);
                prijava.setIdMentorZ(null);
                session.update(prijava);
                i++;
            }
        }
        rukov.setUsernameZ(null);
        rukov.setSprecen(0);
        session.update(rukov);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
         }
        sprecen=false;
        context.addMessage(messageSprecen.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "У могућности сте да прегледате пријаву студента и захтеве професора и да пошаљете захтеве Студентској служби."));
        
        return "rukovodilac_pocetna";
      }
}

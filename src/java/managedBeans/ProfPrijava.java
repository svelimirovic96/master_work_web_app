/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import beans.KomentariMentRuk;
import beans.KomentariMentZam;
import beans.KomentariSluzbaMentor;
import beans.KomentariStMent;
import beans.Korisnik;
import beans.Masterrad;
import beans.Menttoruk;
import beans.Menttozam;
import beans.Modul;
import beans.Predmet;
import beans.Prijava;
import beans.RukovodilacModula;
import beans.VerzijaPrijave;
import beans.Zamenik;
import java.util.ArrayList;
import java.util.Calendar;
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
/**
 *
 * @author Sandra
 */
@ManagedBean(name = "profPrijava")
@SessionScoped
public class ProfPrijava{
    private List<Prijava> listaPrijava;
    private String ipStudent, ipMentor, ipRuk; //ime i prezime 
    private String indexStudent;
    private String nazivModula, nazivPredmeta, bioText, nazivRadSer, nazivRadEn, radPredmet, radSadrzaj;
    private UIComponent messagePregled1;
    private UIComponent messagePregled2;
    private UIComponent messagePregled3;
    private UIComponent messagePregled4;
    private UIComponent messagePregled5;
    private String komEn, komSer, komBio, komPredmet, komSadrzaj;
    private boolean rukovodilac, mentorRada, prihvata, odbija, sugerisi;
    private String ipZamenik;
    private boolean zamenikPotvrda;
    private boolean vecPoslato;
    private List<KomentariMentRuk> listaKomentara;
    private List<KomentariMentZam> listaKomentara2;
    private List<KomentariSluzbaMentor> listaKomentara1;
    private boolean stampaj;

    public boolean isStampaj() {
        return stampaj;
    }

    public void setStampaj(boolean stampaj) {
        this.stampaj = stampaj;
    }
    
    
    
    private String sugestija, ipKom1, ipKom2, ipRukRad, nazivPredmeta1;
    private Date datum, datum2;

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

    public String getSugestija() {
        return sugestija;
    }

    public void setSugestija(String sugestija) {
        this.sugestija = sugestija;
    }

    public Date getDatum2() {
        return datum2;
    }

    public void setDatum2(Date datum2) {
        this.datum2 = datum2;
    }
    
    

    public List<KomentariMentZam> getListaKomentara2() {
        return listaKomentara2;
    }

    public void setListaKomentara2(List<KomentariMentZam> listaKomentara2) {
        this.listaKomentara2 = listaKomentara2;
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

    public String getNazivPredmeta1() {
        return nazivPredmeta1;
    }

    public void setNazivPredmeta1(String nazivPredmeta1) {
        this.nazivPredmeta1 = nazivPredmeta1;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    

    public List<KomentariSluzbaMentor> getListaKomentara1() {
        return listaKomentara1;
    }

    public void setListaKomentara1(List<KomentariSluzbaMentor> listaKomentara1) {
        this.listaKomentara1 = listaKomentara1;
    }

    
    
    public List<KomentariMentRuk> getListaKomentara() {
        return listaKomentara;
    }

    public void setListaKomentara(List<KomentariMentRuk> listaKomentara) {
        this.listaKomentara = listaKomentara;
    }
    
    

    public boolean isZamenikPotvrda() {
        return zamenikPotvrda;
    }

    public void setZamenikPotvrda(boolean zamenikPotvrda) {
        this.zamenikPotvrda = zamenikPotvrda;
    }

    public boolean isVecPoslato() {
        return vecPoslato;
    }

    public void setVecPoslato(boolean vecPoslato) {
        this.vecPoslato = vecPoslato;
    }

    
    
    public String getIpZamenik() {
        return ipZamenik;
    }

    public void setIpZamenik(String ipZamenik) {
        this.ipZamenik = ipZamenik;
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
    
    

    public UIComponent getMessagePregled5() {
        return messagePregled5;
    }

    public void setMessagePregled5(UIComponent messagePregled5) {
        this.messagePregled5 = messagePregled5;
    }
    
    

    public UIComponent getMessagePregled4() {
        return messagePregled4;
    }

    public void setMessagePregled4(UIComponent messagePregled4) {
        this.messagePregled4 = messagePregled4;
    }
    
    

    public UIComponent getMessagePregled3() {
        return messagePregled3;
    }

    public void setMessagePregled3(UIComponent messagePregled3) {
        this.messagePregled3 = messagePregled3;
    }

    
    
    public UIComponent getMessagePregled2() {
        return messagePregled2;
    }

    public void setMessagePregled2(UIComponent messagePregled2) {
        this.messagePregled2 = messagePregled2;
    }

    
    public UIComponent getMessagePregled1() {
        return messagePregled1;
    }

    public void setMessagePregled1(UIComponent messagePregled1) {
        this.messagePregled1 = messagePregled1;
    }
    
    
    
    public String getIndexStudent() {
        return indexStudent;
    }

    public void setIndexStudent(String indexStudent) {
        this.indexStudent = indexStudent;
    }

    public List<Prijava> getListaPrijava() {
        return listaPrijava;
    }

    public void setListaPrijava(List<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
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

    public String getIpRuk() {
        return ipRuk;
    }

    public void setIpRuk(String ipRuk) {
        this.ipRuk = ipRuk;
    }
    
    public String posalji(Prijava prijava){
        zamenikPotvrda=false;
        vecPoslato=false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query=session.createQuery("from RukovodilacModula where username='"+prijava.getIdRukovodilac()+"'");
        List<RukovodilacModula> listaRuk=query.list();
        RukovodilacModula ruk=listaRuk.get(0);
        query=session.createQuery("from Menttoruk where idPrijava="+prijava.getIdPrijava()+" and idMentor='"+prijava.getIdMentor()+"' and idRuk='"+ruk.getUsername()+"' and status=0");
        List<Menttoruk> lista=query.list();
        if (lista.isEmpty()){
            Menttoruk menttoruk=new Menttoruk(prijava.getIdPrijava(), prijava.getIdMentor(), ruk.getUsername(), 0);
            session.save(menttoruk);
            query=session.createQuery("from Korisnik where username='"+ruk.getUsername()+"'");
            List<Korisnik> korisnikList=query.list();
            Korisnik rukModula=korisnikList.get(0);
            ipRuk=rukModula.getIme()+" "+rukModula.getPrezime();
            if (ruk.getSprecen()==1 && !ruk.getUsernameZ().isEmpty()){
                query=session.createQuery("from Menttozam where idPrijava="+prijava.getIdPrijava()+" and idMentor='"+prijava.getIdMentor()+"' and idZam='"+ruk.getUsernameZ()+"' and status=0");
                List<Menttozam> listaZam=query.list();
                if (listaZam.isEmpty()){
                Menttozam menttozam=new Menttozam(prijava.getIdPrijava(), prijava.getIdMentor(), ruk.getUsernameZ(), 0);
                session.save(menttozam);
                zamenikPotvrda=true;
                query=session.createQuery("from Korisnik where username='"+ruk.getUsernameZ()+"'");
                List<Korisnik> korisnikLista=query.list();
                Korisnik zam=korisnikLista.get(0);
                ipZamenik=zam.getIme()+" "+zam.getPrezime();
                } 
                else {
                    query=session.createQuery("from Korisnik where username='"+ruk.getUsernameZ()+"'");
                    List<Korisnik> korisnikLista=query.list();
                    Korisnik zam=korisnikLista.get(0);
                    ipZamenik=zam.getIme()+" "+zam.getPrezime();
                    zamenikPotvrda=true;
                    vecPoslato=true;
                }
            }
        }
        else {
            query=session.createQuery("from Korisnik where username='"+ruk.getUsername()+"'");
            List<Korisnik> korisnikList=query.list();
            Korisnik rukModula=korisnikList.get(0);
            ipRuk=rukModula.getIme()+" "+rukModula.getPrezime();
            vecPoslato=true;
        }
        prijava.setImaGreske(3);
        session.update(prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "prof_slanje_poruka";
    }
    
    public String vrati(){
        return "profesor_pocetna";
    }
    
    public String pregled(Prijava prijava){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Prijava where idPrijava="+prijava.getIdPrijava());
        listaPrijava=query.list();
        Prijava odabranaPrijava=listaPrijava.get(0);
        if (odabranaPrijava.getRukIliProf()==1){
         rukovodilac=true;
         mentorRada=false;
        }
        else {
         rukovodilac=false;
         mentorRada=true;
        }
        bioText=odabranaPrijava.getBiografija();
        if (odabranaPrijava.getIdRukRada()!=null){
            query=session.createQuery("from Korisnik where username='"+odabranaPrijava.getIdRukRada()+"'");
            List<Korisnik> listRukRada=new ArrayList<>();
            listRukRada=query.list();
            ipRukRad=listRukRada.get(0).getIme()+" "+listRukRada.get(0).getPrezime();
        }
        else ipRukRad="";
        if (odabranaPrijava.getIdKom1()!=null){
            query=session.createQuery("from Korisnik where username='"+odabranaPrijava.getIdKom1()+"'");
            List<Korisnik> listKom1=new ArrayList<>();
            listKom1=query.list();
            ipKom1=listKom1.get(0).getIme()+" "+listKom1.get(0).getPrezime();
        }
        else ipKom1="";
        if (odabranaPrijava.getIdKom2()!=null){
            query=session.createQuery("from Korisnik where username='"+odabranaPrijava.getIdKom2()+"'");
            List<Korisnik> listKom2=new ArrayList<>();
            listKom2=query.list();
            ipKom2=listKom2.get(0).getIme()+" "+listKom2.get(0).getPrezime();
        }
        else ipKom2="";
        datum=odabranaPrijava.getDatum();
       prihvata=odbija=sugerisi=false;
        if (odabranaPrijava.getPrihvata()!=null){
         if (odabranaPrijava.getPrihvata()==1)
            prihvata=true;
        if (odabranaPrijava.getPrihvata()==2)
         odbija=true;
        if (odabranaPrijava.getPrihvata()==3)
            sugerisi=true;
        }
        if (odabranaPrijava.getSugestija()!=null) sugestija=odabranaPrijava.getSugestija();
        else sugestija="";
        datum2=odabranaPrijava.getDatumS();
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
        httpSession.setAttribute("prijava", prijava);
        Korisnik mentor=(Korisnik) httpSession.getAttribute("mentor");       
        ipMentor=mentor.getIme()+" "+mentor.getPrezime();
        query=session.createQuery("from Masterrad where idRad="+odabranaPrijava.getIdRad()+"");
        List<Masterrad> listRad=new ArrayList<>();
        listRad=query.list();
        nazivRadSer=listRad.get(0).getNazivS();
        nazivRadEn=listRad.get(0).getNazivE();
        radPredmet=listRad.get(0).getPredmet();
        radSadrzaj=listRad.get(0).getSadrzaj();
        query=session.createQuery("from Korisnik where username='"+odabranaPrijava.getIdRukovodilac()+"'");
        List<Korisnik> listRuk=new ArrayList<>();
        listRuk=query.list();
        ipRuk=listRuk.get(0).getIme()+" "+listRuk.get(0).getPrezime();
        query=session.createQuery("from Predmet where idPredmet="+odabranaPrijava.getIdPredmet()+"");
        List<Predmet> listPredmet=new ArrayList<>();
        listPredmet=query.list();
        nazivPredmeta=listPredmet.get(0).getNaziv();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        komEn=null;
        komSer=null;
        komBio=null;
        komPredmet=null;
        komSadrzaj=null;
        return "pregledPrijaveStProf";
    }
    public String izmeni1(){
        FacesContext context = FacesContext.getCurrentInstance();
        for(int i = 0; i < nazivRadSer.length(); i++) {
             if(!(Character.UnicodeBlock.of(nazivRadSer.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(nazivRadSer.charAt(i))) || (Character.UnicodeBlock.of(nazivRadSer.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Наслов теме на српском језику није написан ћирилицом!"));
                 return "pregledPrijaveStProf";
            }
        }
        for(int i = 0; i < nazivRadEn.length(); i++) {
             if(!((Character.isWhitespace(nazivRadEn.charAt(i))) || (Character.UnicodeBlock.of(nazivRadEn.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Наслов теме на енглеском језику није написан латиницом!"));
                 return "pregledPrijaveStProf";
            }
        }
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
        if (presao1 || presao2){
            prijava.setImaGreske(9);
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
                prijava.getDatum(), prijava.getPrihvata(), prijava.getSugestija(), prijava.getDatumS(), prijava.getPredsednikKomisije());
        session.save(verzija);
        }
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveStProf";
    }
    
     public String izmeni2(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        for(int i = 0; i < bioText.length(); i++) {
             if(!(Character.UnicodeBlock.of(bioText.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(bioText.charAt(i))) || (Character.UnicodeBlock.of(bioText.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Биографија није написана ћирилицом!"));
                 return "pregledPrijaveStProf";
            }
        }
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
            
            pri.setImaGreske(9);
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
        return "pregledPrijaveStProf";
    }
     
     
     
      public String izmeni3(){
        
        FacesContext context = FacesContext.getCurrentInstance();
          for(int i = 0; i < radPredmet.length(); i++) {
             if(!(Character.UnicodeBlock.of(radPredmet.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(radPredmet.charAt(i))) || (Character.UnicodeBlock.of(radPredmet.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Предмет, циљ и методе мастер рада нису написани ћирилицом!"));
                 return "pregledPrijaveStProf";
            }
        }
           for(int i = 0; i < radSadrzaj.length(); i++) {
             if(!(Character.UnicodeBlock.of(radSadrzaj.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(radSadrzaj.charAt(i))) || (Character.UnicodeBlock.of(radSadrzaj.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Садржај и очекивани резултати мастер рада нису написани ћирилицом!"));
                 return "pregledPrijaveStProf";
            }
        }
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
            
            prijava.setImaGreske(9);
            session.update(prijava);
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
        httpSession.setAttribute("prijava", prijava);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "pregledPrijaveStProf";
    }
      
      public String komentarisi1(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!komEn.isEmpty() || !komSer.isEmpty()){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
         Korisnik mentor=(Korisnik) httpSession.getAttribute("mentor");
         KomentariStMent komentar;
         if (!komSer.isEmpty()){
             for(int i = 0; i < komSer.length(); i++) {
             if(!(Character.UnicodeBlock.of(komSer.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komSer.charAt(i))) || (Character.UnicodeBlock.of(komSer.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                 context.addMessage(messagePregled1.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                    if (session != null && session.isOpen()) {
                    session.close();
                    }
                 return "pregledPrijaveStProf";
            }
        }
            komentar=new KomentariStMent(prijava.getIdPrijava(), prijava.getIdStudent(), mentor.getUsername(), komSer);
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
                 return "pregledPrijaveStProf";
            }
        }
            komentar=new KomentariStMent(prijava.getIdPrijava(), prijava.getIdStudent(), mentor.getUsername(), komEn);
            session.save(komentar);
            context.addMessage(messagePregled2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за наслов теме на енглеском језику."));
              
         }
         prijava.setImaGreske(2);
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
        return "pregledPrijaveStProf";
      }
      
      public String komentarisi2(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!komBio.isEmpty()){
            for(int i = 0; i < komBio.length(); i++) {
             if(!(Character.UnicodeBlock.of(komBio.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komBio.charAt(i))) || (Character.UnicodeBlock.of(komBio.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                   context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 
                 return "pregledPrijaveStProf";
            }
        }
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
         
         Korisnik mentor=(Korisnik) httpSession.getAttribute("mentor");
         KomentariStMent komentar;
         komentar=new KomentariStMent(prijava.getIdPrijava(), prijava.getIdStudent(), mentor.getUsername(), komBio);
            session.save(komentar);
            context.addMessage(messagePregled3.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за биографију студента."));
           prijava.setImaGreske(2);
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
        return "pregledPrijaveStProf";
      }
      
      public String komentarisi3(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!komPredmet.isEmpty() || !komSadrzaj.isEmpty()){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
         Prijava prijava=(Prijava) httpSession.getAttribute("prijava");
         Korisnik mentor=(Korisnik) httpSession.getAttribute("mentor");
         KomentariStMent komentar;
         if (!komPredmet.isEmpty()){
            for(int i = 0; i < komPredmet.length(); i++) {
             if(!(Character.UnicodeBlock.of(komPredmet.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || (Character.isWhitespace(komPredmet.charAt(i))) || (Character.UnicodeBlock.of(komPredmet.charAt(i)).equals(Character.UnicodeBlock.BASIC_LATIN)))) {
                   context.addMessage(messagePregled4.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Коментари нису написани ћирилицом!"));
                 session.getTransaction().commit();
                 if (session != null && session.isOpen()) {
                session.close();
          }
                 return "pregledPrijaveStProf";
            }
        }
            komentar=new KomentariStMent(prijava.getIdPrijava(), prijava.getIdStudent(), mentor.getUsername(), komPredmet);
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
                 return "pregledPrijaveStProf";
            }
        }
            komentar=new KomentariStMent(prijava.getIdPrijava(), prijava.getIdStudent(), mentor.getUsername(), komSadrzaj);
            session.save(komentar);
            context.addMessage(messagePregled5.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Успешно сте послали коментар за садржај и резултате."));
            prijava.setImaGreske(2);
           session.update(prijava);
         }
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
        return "pregledPrijaveStProf";
      }
      
      public String pregledKomentara(Prijava prijava){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from KomentariMentRuk where idMentToRuk in (select idMentToRuk from Menttoruk where idPrijava="+prijava.getIdPrijava()+")");
        listaKomentara=query.list();
        query=session.createQuery("from KomentariMentZam where idMentToZam in (select idMentToZam from Menttozam where idPrijava="+prijava.getIdPrijava()+")");
        listaKomentara2=query.list();
         session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "listaKomentaraProf"; 
      }
      
      public String pregledKomentara1(Prijava prijava){
        FacesContext context = FacesContext.getCurrentInstance();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
        Korisnik mentor=(Korisnik) httpSession.getAttribute("mentor");
        Query query=session.createQuery("from KomentariSluzbaMentor where idMentor='"+mentor.getUsername()+"' and idRukToSluzba in (select idRukToSluzba from Ruktosluzba where idMentToRuk in (select idMentToRuk from Menttoruk where idPrijava="+prijava.getIdPrijava()+"))");
        listaKomentara1=query.list();
         session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
    }
        return "listaKomentaraProfOdSluzbe"; 
      }
      
      public String rukovodilacMod(KomentariMentRuk komentar){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select idRuk from Menttoruk where idMentToRuk in (select idMentToRuk from KomentariMentRuk where idKom="+komentar.getIdKom()+"))");
        List<Korisnik> rukovodioci=query.list();
        String ipRuk=rukovodioci.get(0).getIme()+" "+rukovodioci.get(0).getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
         }
        return ipRuk;
      }
      public String zaposleniSluzbaIP(KomentariSluzbaMentor komentar){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query=session.createQuery("from Korisnik where username in (select idSluzba from Ruktosluzba where idRukToSluzba="+komentar.getIdRukToSluzba()+")");
        List<Korisnik> sluzbenici=query.list();
         String ipSl=sluzbenici.get(0).getIme()+" "+sluzbenici.get(0).getPrezime();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
        session.close();
         }
        return ipSl;
      }
      
      public String pregVer1(Prijava prijava){
          FacesContext context = FacesContext.getCurrentInstance();
          Session session = HibernateUtil.getSessionFactory().getCurrentSession();
          session.beginTransaction();  
          Query query=session.createQuery("from VerzijaPrijave where idPrijava="+prijava.getIdPrijava()+"  order by datumVer desc, vremeVer desc");
          List<VerzijaPrijave> listVerzija=query.list();
          HttpSession httpSession=(HttpSession) context.getExternalContext().getSession(false);
          httpSession.setAttribute("listaVerzija", listVerzija);
          session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
          }
            return "listaVerzijaProf";
      }
      
       public String pregVer(VerzijaPrijave verzija){
       stampaj=false;
       FacesContext context = FacesContext.getCurrentInstance();
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
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
        bioText=verzija.getBiografija();
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
        
        query=session.createQuery("from Korisnik where username='"+verzija.getIdRukovodilac()+"'"); List<Korisnik> listRuk=new ArrayList<>();
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
        return "verzijaKodProfesora";
   }
       
        public String imePrezime(String username){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Korisnik where username='"+username+"'");
         List<Korisnik> listStudent=query.list();
         String ipKor=listStudent.get(0).getIme()+" "+listStudent.get(0).getPrezime();
          session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return ipKor;
          
      }
       public String zamenikIp(KomentariMentZam kom){
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         Query query=session.createQuery("from Korisnik where username in (select idZam from Menttozam where idMentToZam="+kom.getIdMentToZam()+")");
         List<Korisnik> listStudent=query.list();
         String ipKor=listStudent.get(0).getIme()+" "+listStudent.get(0).getPrezime();
          session.getTransaction().commit();
         if (session != null && session.isOpen()) {
         session.close();
          }
         return ipKor;
          
      }
       
       public String statusPrijave(int imaGreske){
           String statusPrijave="";
           switch (imaGreske){
                    case 0: statusPrijave="Потврђена од стране Студентске службе"; break;
                    case 1: statusPrijave="Пријављена од стране студента"; break;
                    case 2: statusPrijave="Послати коментари студенту"; break;
                    case 3: statusPrijave="Послато руководиоцу/заменику"; break;
                    case 4: statusPrijave="Измена захтевана од стране руководиоца/заменика"; break;
                    case 5: statusPrijave="Измењена од стране студента"; break;
                    case 6: statusPrijave="Послато Студентској служби"; break;
                    case 7: statusPrijave="Измена захтевана од стране Студентске службе"; break;
                    case 8: statusPrijave="Измена захтевана студенту од стране Студентске службе"; break;
                    case 9: statusPrijave="Успешно измењена пријава"; break;
           }
           return statusPrijave;
       }
}

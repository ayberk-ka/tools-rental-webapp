package bacit.web.bacit_web;

public class AnsattM {

    private int ansatt_id,adminstrator,unionn;
    private String password,fornavn,etternavn,addresse,mobil;

    public AnsattM
            (String password, String fornavn)
    {
        this.ansatt_id = ansatt_id;
        this.adminstrator = adminstrator;
        this.unionn = unionn;
        this.password = password;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.addresse = addresse;
        this.mobil = mobil;

    }

    public int getAnsatt_id() {
        return ansatt_id;
    }

    public void setAnsatt_id(int ansatt_id) {
        this.ansatt_id = ansatt_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public int getAdminstrator() {
        return adminstrator;
    }

    public void setAdminstrator(int adminstrator) {
        this.adminstrator = adminstrator;
    }

    public int getUnionn() {
        return unionn;
    }

    public void setUnionn(int unionn) {
        this.unionn = unionn;
    }

}
package modèle;

public class InformationClient {
    private String nom;
    private String prénom;
    private String Adresse1;
    private String Adresse2;
    private String ville;
    private String etat;
    private String codePostal;
    private String noTel;
    private String mail;

    public InformationClient() {
    	this.nom = "";
        this.prénom = "";
        this.Adresse1 = "";
        this.Adresse2 = "";
        this.ville = "";
        this.etat = "";
        this.codePostal = "";
        this.noTel = "";
        this.mail = "";
    }

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public void setAdresse1(String adresse1) {
		Adresse1 = adresse1;
	}

	public void setAdresse2(String adresse2) {
		Adresse2 = adresse2;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return "Nom : " + nom;
	}

	public String getPrénom() {
		return "Prénom : " + prénom;
	}

	public String getAdresse1() {
		return "Adresse 1 : " + Adresse1;
	}

	public String getAdresse2() {
		return "Adresse 2 : " + Adresse2;
	}

	public String getVille() {
		return "Ville 3 : " + ville;
	}

	public String getEtat() {
		return "État : " + etat;
	}

	public String getCodePostal() {
		return "Code Postal : " + codePostal;
	}

	public String getNoTel() {
		return "Numéro de téléphone : " + noTel;
	}

	public String getMail() {
		return "Mail : " + mail;
	}

	public String toStringInfos(){
        return " Nom : " + this.nom + "\n " +
		" Prénom :" + this.prénom + "\n " + 
		" Adresse 1 : " + this.Adresse1 + "\n " +
		" Adresse 2 : " + this.Adresse2 + "\n " +
		" Ville : " + this.ville + "\n " +
		" État : " + this.etat + "\n " +
		" Code Postal : " + this.codePostal + "\n " + 
		" Numéro de télephone : " + this.noTel + "\n " +
		" Mail : " + this.mail + " "; 
	}
}

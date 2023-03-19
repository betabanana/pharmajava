package tst;

import java.sql.Date;

public class Medicament {
    private int id_med; 
    private String image_med ;
    private String titre_med ;
    private String desc_med ;
    private Double prix_med ;
    private int nbr_Instante;
	private Boolean status_ord_med = false; //BOOLEAN DEFAULT FALSE,
    private Boolean status_med = true;//BOOLEAN DEFAULT TRUE,
    
    public Medicament() {
    	
    }
    

	public Medicament(int id_med, String image_med, String titre_med, String desc_med, Double prix_med,
			Boolean status_ord_med, Boolean status_med) {
		super();
		this.id_med = id_med;
		this.image_med = image_med;
		this.titre_med = titre_med;
		this.desc_med = desc_med;
		this.prix_med = prix_med;
		this.status_ord_med = status_ord_med;
		this.status_med = status_med;
	}


	public Medicament(String image_med, String titre_med, String desc_med, Double prix_med, Boolean status_ord_med,
			Boolean status_med) {
		super();
		this.image_med = image_med;
		this.titre_med = titre_med;
		this.desc_med = desc_med;
		this.prix_med = prix_med;
		this.status_ord_med = status_ord_med;
		this.status_med = status_med;
	}
	  public int getNbr_Instante() {
			return nbr_Instante;
		}


		public void setNbr_Instante(int nbr_Instante) {
			this.nbr_Instante = nbr_Instante;
		}







	public int getId_med() {
		return id_med;
	}

	public void setId_med(int id_med) {
		this.id_med = id_med;
	}

	public String getImage_med() {
		return image_med;
	}

	public void setImage_med(String image_med) {
		this.image_med = image_med;
	}

	public String getTitre_med() {
		return titre_med;
	}

	public void setTitre_med(String titre_med) {
		this.titre_med = titre_med;
	}

	public String getDesc_med() {
		return desc_med;
	}

	public void setDesc_med(String desc_med) {
		this.desc_med = desc_med;
	}

	public Boolean getStatus_ord_med() {
		return status_ord_med;
	}

	public void setStatus_ord_med(Boolean status_ord_med) {
		this.status_ord_med = status_ord_med;
	}

	public Boolean getStatus_med() {
		return status_med;
	}

	public void setStatus_med(Boolean status_med) {
		this.status_med = status_med;
	}

	@Override
	public String toString() {
		return "Medicament [id_med=" + id_med + ", image_med=" + image_med + ", titre_med=" + titre_med + ", desc_med="
				+ desc_med + ", status_ord_med=" + status_ord_med
				+ ", status_med=" + status_med + "]";
	}




	/**
	 * @return the prix_med
	 */
	public Double getPrix_med() {
		return prix_med;
	}




	/**
	 * @param prix_med the prix_med to set
	 */
	public void setPrix_med(Double prix_med) {
		this.prix_med = prix_med;
	}
	
	
    
    
}

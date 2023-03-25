package modèle;
import java.util.LinkedList;
import java.util.List;

public class Articles {

	private List<Fromage> lesFromages;
	
	public Articles() {
		this.lesFromages = new LinkedList<Fromage>();
	}
	
	public void addFromages(List<Fromage> fromages) {
		this.lesFromages.addAll(fromages);
	}
	
	public String toStringFromagesEtArticles() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			enForme.append(f.toString() + '\n');
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toString() + '\n');
				}
			}
		}
		return enForme.toString();
	}
	
	public String toStringArticlesEtStock() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toStringAvecStock() + '\n');
				}
			}
		}
		return enForme.toString();
	}
	
	public void regénérationDuStock() {
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					article.setQuantitéEnStock((int) Math.round(Math.random()*100));
				}
			}
		}
	}

	public List<Fromage> fromageAuLaitDe(TypeLait type) {
		List<Fromage> fromAuLaitDe = new LinkedList<Fromage>();
		for (Fromage fromage : this.lesFromages) {
			if (fromage.getTypeFromage() == type) {
				fromAuLaitDe.add(fromage);
			}
		}
		return fromAuLaitDe;
	}
	
	public String vérificationSaisie( ) {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() == 0) {
				enForme.append("Pas d'articles pour " + f.toString() + '\n');
			}
		}
		return enForme.toString();
	}
	
	public List<Fromage> getLesFromages() {
		return this.lesFromages;
	}
	
	public Article getArticle(String désignation, String clé) throws Exception{
		for (Fromage fromage : this.lesFromages) {
			if (fromage.getDésignation() == désignation) {
				for (Article article : fromage.getArticles()) {
					if (article.getClé() == clé) {
						return article;
					}
				}
			}
		}
		throw new Exception("Article non disponible");
	}
}

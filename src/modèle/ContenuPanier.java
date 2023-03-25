package modèle;

import java.util.LinkedList;
import java.util.List;

public class ContenuPanier {
    private List<Fromage> f;
    private List<Article> lArticles;
    private List<Float> liste_prix_a_lunite;
    private List<Integer> liste_quantité;
    private List<Float> prixTotal; 

    public ContenuPanier() {
        this.lArticles = new LinkedList<Article>();
        this.liste_quantité = new LinkedList<Integer>();
        this.prixTotal = new LinkedList<Float>();
        this.liste_prix_a_lunite = new LinkedList<Float>();
        this.f = new LinkedList<Fromage>();
    }

    public void toStringContenuPanier(){
        List<String> tsCP = new LinkedList<String>();
        for (int i = 0; i < lArticles.size(); i++) {
            tsCP.add(f.get(i).getDésignation() + 
            " : "+ this.lArticles.get(i).getClé() + 
            " " + this.liste_prix_a_lunite.get(i) + 
            " " + this.liste_quantité.get(i) +
            " " + this.prixTotal.get(i));
        }
        for (int i = 0; i < tsCP.size(); i++) {
            System.out.println(tsCP.get(i));
        }
        System.out.println("\n");
    }

    public void addArticleDansPanier(Fromage fr, Article a, int quantité){
        if (isAlreadyInCart(a)) {
            for (int i = 0; i < this.lArticles.size(); i++) {
                if (lArticles.get(i).equals(a)) {
                    int temp = this.liste_quantité.get(i) + quantité;
                    this.liste_quantité.add(i, temp);
                    this.prixTotal.add(i, temp * this.lArticles.get(i).getPrixTTC());
                }
            }
        } else {
            this.lArticles.add(a);
            this.liste_prix_a_lunite.add(a.getPrixTTC());
            this.liste_quantité.add(quantité);
            this.prixTotal.add(a.getPrixTTC()*quantité);
            this.f.add(fr);
        }
    }

    public List<Article> getArticles(){
        return this.lArticles;
    }

    public Article getArticle(int index){
        return this.lArticles.get(index);
    }

    public int getQuantitéChoisie(int index) {
        return this.liste_quantité.get(index);
    }

    public float getPrixArticle(int index) {
        return this.liste_prix_a_lunite.get(index);
    }

    public float getPrixTTCArticle(int index) {
        return this.prixTotal.get(index);
    }

    public boolean isAlreadyInCart(Article a) {
        for (Article article : lArticles) {
            if (article.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public int getTaillePanier(){
        return this.lArticles.size();
    }

    public void viderPanier(){
        this.f.clear();
        this.lArticles.clear();
        this.liste_prix_a_lunite.clear();
        this.prixTotal.clear();
    }

    public Object[] getRowItem(int index){
        Object row[] = new Object[4];
        for (int i = 0; i < row.length; i++) {
            row[0] = (f.get(index).getDésignation() + 
            " : "+ this.lArticles.get(index).getClé());
            row[1] = (getPrixArticle(index) + " €");
            row[2] = (getQuantitéChoisie(index));
            row[3] = (String.format("%10.2f", getPrixTTCArticle(index)) + " €");
        }
        return row;
    } 
}

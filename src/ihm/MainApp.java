package ihm;
import modèle.*;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainApp {
	
	protected static float prixIncPanier;
	protected static JButton bouton_panier;
	protected static InformationClient infosClient = new InformationClient();
	protected static ContenuPanier PANIER = new ContenuPanier();

	private JFrame frmAccueil;
	private JList<Object> list = new JList<>();
	private JScrollPane list_container = new JScrollPane();
	private List<String> list_content = new ArrayList<String>();
	private List<JButton> list_button = new ArrayList<JButton>();
	private List<String> fromageChevreList = new ArrayList<String>();
	private List<String> tout_les_fromages = new ArrayList<String>();
	private List<String> fromageVacheLlList = new ArrayList<String>();
	private List<String> fromages_brebisList = new ArrayList<String>();
	private List<Fromage> liste_des_fromages = new ArrayList<Fromage>();

	/**
	 * Launch the application
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmAccueil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Articles articles_ = GenerationFromages.générationBaseFromages();
		liste_des_fromages.addAll(articles_.getLesFromages());
		fillListesFromages();
		this.list_content.addAll(tout_les_fromages);

		frmAccueil = new JFrame();
		frmAccueil.setTitle("Accueil Fromagerie Seigneuret");
		frmAccueil.setBounds(100, 100, 600, 700);
		frmAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel Nord = new JPanel();
		Nord.setBorder(new LineBorder(new Color(0, 0, 0)));
		Nord.setBackground(SystemColor.text);
		frmAccueil.getContentPane().add(Nord, BorderLayout.NORTH);
		Nord.setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel titre = new JLabel("FROMAGERIRE SEIGNEURET");
		titre.setBackground(SystemColor.text);
		titre.setFont(new Font("Miriam Libre", Font.BOLD, 18));
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		Nord.add(titre);
		
		JLabel sout_titre = new JLabel("le plaisir du bon goût");
		sout_titre.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 16));
		sout_titre.setHorizontalAlignment(SwingConstants.CENTER);
		Nord.add(sout_titre);
		
		JPanel choix_fromages = new JPanel();
		Nord.add(choix_fromages);
		choix_fromages.setLayout(new GridLayout(0, 4, 0, 0));
		
		this.list = new JList<>(tout_les_fromages.toArray());
		this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.list.setFont(new Font("Arial", Font.BOLD, 14));
		list_container.setViewportView(this.list);
		
		JButton chevre_cat_but = new JButton("CHEVRE");
		bouton_clique(chevre_cat_but,fromageChevreList);
		chevre_cat_but.setIcon(new ImageIcon(MainApp.class.getResource("/Icons/chevre.png")));
		chevre_cat_but.setBackground(Color.WHITE);
		choix_fromages.add(chevre_cat_but);
		
		JButton vache_cat_but = new JButton("VACHE");
		bouton_clique(vache_cat_but,fromageVacheLlList);
		vache_cat_but.setIcon(new ImageIcon(MainApp.class.getResource("/Icons/silhouette-de-vache.png")));
		vache_cat_but.setBackground(Color.WHITE);
		choix_fromages.add(vache_cat_but);
		
		JButton brebis_cat_but = new JButton("BREBIS");
		bouton_clique(brebis_cat_but,fromages_brebisList);
		brebis_cat_but.setIcon(new ImageIcon(MainApp.class.getResource("/Icons/mouton.png")));
		brebis_cat_but.setBackground(Color.WHITE);
		choix_fromages.add(brebis_cat_but);
		
		JButton tout_cat_but = new JButton("TOUT");
		tout_cat_but.setIcon(null);
		bouton_clique(tout_cat_but,tout_les_fromages);		
		tout_cat_but.setBackground(Color.WHITE);
		choix_fromages.add(tout_cat_but);
		
		JPanel Centre = new JPanel();
		frmAccueil.getContentPane().add(Centre, BorderLayout.CENTER);
		Centre.setLayout(new BorderLayout(0, 0));
		Centre.add(list_container);

		JPanel Sud = new JPanel();
		frmAccueil.getContentPane().add(Sud, BorderLayout.SOUTH);
		Sud.setLayout(new BorderLayout(0, 0));
		
		JPanel bouton_panier_container = new JPanel();
		bouton_panier_container.setBackground(new Color(255, 250, 250));
		Sud.add(bouton_panier_container, BorderLayout.CENTER);

		FlowLayout fl_bouton_panier_container = new FlowLayout(FlowLayout.CENTER, 5, 5);
		fl_bouton_panier_container.setAlignOnBaseline(true);
		bouton_panier_container.setLayout(fl_bouton_panier_container);
		
		bouton_panier = new JButton("00.00 €");
		bouton_panier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panier wPanier = new Panier();
				wPanier.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				wPanier.setVisible(true);
			}
		});

		bouton_panier.setFont(new Font("Arial", Font.BOLD, 14));
		bouton_panier.setForeground(SystemColor.windowText);
		bouton_panier.setBackground(new Color(255, 250, 205));
		bouton_panier.setIcon(new ImageIcon(MainApp.class.getResource("/Icons/shopping-cart.png")));
		bouton_panier_container.add(bouton_panier);
		afficherDescription();

		this.list_button.add(chevre_cat_but);
		this.list_button.add(brebis_cat_but);
		this.list_button.add(vache_cat_but);
		this.list_button.add(tout_cat_but);
	}

	private boolean isColorSet(JButton bouton){
		Color c = new Color(255, 250, 205);
		if (bouton.getBackground().equals(c)){
			return true;
		}
		return false;
	}

	private void updateColor(JButton bouton) {
		bouton.setBackground(Color.WHITE);
	}

	private void afficherDescription() {
		this.list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fen_description_fromage fen_description_f;
				String fromage_selectionne_str = list.getSelectedValue().toString();
				Fromage f_selectioneFromage = getFromageSelected(fromage_selectionne_str);
				fen_description_f = new Fen_description_fromage(f_selectioneFromage);
				fen_description_f.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				fen_description_f.setVisible(true);
			}
		});
	}
	
	private void fillListesFromages() {
		for (Fromage f : liste_des_fromages) {
			// Tout les fromages
			tout_les_fromages.add(f.getDésignation());
			// Fromage de brebis
			if (f.getTypeFromage() == TypeLait.BREBIS){
				fromages_brebisList.add(f.getDésignation());
			// Fromage de chèvre
			} else if (f.getTypeFromage() == TypeLait.CHEVRE){
				fromageChevreList.add(f.getDésignation());
			} else{
				// Fromage de Vache
				if (f.getTypeFromage() == TypeLait.VACHE) {
					fromageVacheLlList.add(f.getDésignation());
				}
			}
		}
	}

	private Fromage getFromageSelected(String fromage_selectionne){
		for (Fromage f : liste_des_fromages) {
			if (f.getDésignation() == fromage_selectionne) {
				return f;
			}
		}
		return null;
	}

	private void bouton_clique(JButton button, List<String> listeAafficher) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (JButton b : list_button) {
					if (isColorSet(b)) {
						updateColor(b);
					}
				}
				button.setBackground(new Color(255, 250, 205));
				affichageTypeFromage(listeAafficher);
			}
		});
	}

	private void affichageTypeFromage(List<String> typeDeFromage) {
		if (!(this.list_content.isEmpty())) {
			this.list_content.clear();
		}
		this.list_content.addAll(typeDeFromage);
		this.list.removeAll();
		this.list.setListData(typeDeFromage.toArray());
	}
}

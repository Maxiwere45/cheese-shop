package ihm;

import modèle.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.awt.SystemColor;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fen_description_fromage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<Object> detailVenteArticle;
	private JSpinner nombre;
	private Fromage f;
	private List<Article> listArticles = new LinkedList<Article>();

	/**
	 * Create the dialog.
	 */
	public Fen_description_fromage(Fromage fromageSelected) {
		setType(Type.POPUP);
		this.f = fromageSelected;
		setTitle("Description du fromage");
		setBounds(100, 100, 515, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				JTextPane textPanelDescription = new JTextPane();
				textPanelDescription.setText(f.getDescription());
				textPanelDescription.setEditable(false);
				scrollPane.setViewportView(textPanelDescription);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				detailVenteArticle = new JComboBox<>();
				detailVenteArticle.setBackground(SystemColor.inactiveCaptionBorder);
				for (Article a : f.getArticles()) {
					detailVenteArticle.addItem(a.toString());
					this.listArticles.add(a);
				}
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				buttonPane.add(detailVenteArticle);
			}
			{
				this.nombre = new JSpinner();
				this.nombre.setModel(new SpinnerNumberModel(0, 0,
								getQuantiteDispo(), 1));
				buttonPane.add(nombre);
			}
			{
				JButton ajouterPanierButton = new JButton("Ajouter au panier");
				eventBoutonAjouterAuPanier(ajouterPanierButton);
				ajouterPanierButton.setForeground(Color.BLACK);
				ajouterPanierButton.setBackground(new Color(245, 245, 220));
				ajouterPanierButton.setActionCommand("OK");
				buttonPane.add(ajouterPanierButton);
				getRootPane().setDefaultButton(ajouterPanierButton);
			}
			{
				JButton annulerButton = new JButton("Annuler");
				annulerButton.setBackground(SystemColor.control);
				quit(annulerButton);
				annulerButton.setActionCommand("Close");
				buttonPane.add(annulerButton);
			}
		}
	}

	private void eventBoutonAjouterAuPanier(JButton ajouterPanierButton) {
		ajouterPanierButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = detailVenteArticle.getSelectedIndex();
				if ((int) nombre.getValue() == 0) {
					JOptionPane.showMessageDialog(contentPanel,
					"Veuiller ajouter le nombre de fromage souhaité !",
					"Attention !",
					JOptionPane.ERROR_MESSAGE);
				} else{
					MainApp.prixIncPanier = MainApp.prixIncPanier + (listArticles.get(index).getPrixTTC() * ((int) nombre.getValue()));
					for (Article a : f.getArticles()) {
						if (a.equals(listArticles.get(index))) {
							a.préempterQuantité((int) nombre.getValue());
						}
					}
					String aff = String.format("%10.2f", MainApp.prixIncPanier);
					MainApp.bouton_panier.setText(aff +" €");
					MainApp.PANIER.addArticleDansPanier(f,listArticles.get(index), (int) nombre.getValue());
					dispose();
				}
				listArticles.clear();
			}
		});
	}

	private int getQuantiteDispo(){
		for (Article article : f.getArticles()) {
			return article.getQuantitéEnStock();
		}
		return 0;
	}

	private void quit(JButton annulerButton) {
		annulerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
	}
}
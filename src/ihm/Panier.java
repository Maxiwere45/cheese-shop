package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class Panier extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JRadioButton colissimoD;
	private JRadioButton colissimoPR;
	private JRadioButton livraisonHelico;
	private float fraisDePort = 0.0F;
	private final JPanel contentPanel = new JPanel();
	private List<JRadioButton> jbuttons =  new LinkedList<JRadioButton>();
	private String[] colTable = {"Produits", "Prix", "Quantit\u00E9", "Total"};
	private DefaultTableModel tableModel = new DefaultTableModel(colTable, 0);

	/**
	 * Create the dialog.
	 */
	public Panier() {
		setBounds(100, 100, 641, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel_table = new JPanel();
			panel_table.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panel_table, BorderLayout.CENTER);
			panel_table.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				table = new JTable(tableModel);
				table.setEnabled(false);
				table.setRowSelectionAllowed(false);
				table.setFont(new Font("Tahoma", Font.BOLD, 13));
				updateTable();
				scrollPane.add(table);
				scrollPane.setViewportView(table);
				panel_table.add(scrollPane);
			}
			
		}
		{
			JPanel panel_livraison = new JPanel();
			panel_livraison.setBorder(null);
			contentPanel.add(panel_livraison, BorderLayout.SOUTH);
			panel_livraison.setLayout(new GridLayout(3, 0, 0, 0));
			{
				this.colissimoPR = new JRadioButton("Colissimo en point relais 4.90 €");
				this.jbuttons.add(colissimoPR);
				colissimoPR.setSelected(true);
				event_but_cPR();
				colissimoPR.setBackground(Color.WHITE);
				colissimoPR.setFont(new Font("Arial", Font.BOLD, 11));
				panel_livraison.add(colissimoPR);
			}
			{
				this.colissimoD = new JRadioButton("Colissimo à domicile 5.20 €");
				this.jbuttons.add(colissimoD);
				event_but_cD();
				colissimoD.setFont(new Font("Arial", Font.BOLD, 11));
				colissimoD.setBackground(Color.WHITE);
				panel_livraison.add(colissimoD);
			}
			{
				this.livraisonHelico = new JRadioButton("Livraison par hélicoptère 20.90 €");
				this.jbuttons.add(livraisonHelico);
				event_but_lH();
				livraisonHelico.setFont(new Font("Arial", Font.BOLD, 11));
				livraisonHelico.setBackground(Color.WHITE);
				panel_livraison.add(livraisonHelico);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Valider mon panier");
				okButton.setForeground(Color.WHITE);
				eventBoutonValiderPanier(okButton);
				okButton.setBackground(new Color(46, 139, 87));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnViderPanier = new JButton("Vider mon panier");
				btnViderPanier.setForeground(Color.WHITE);
				eventBoutonViderPanier(btnViderPanier);
				btnViderPanier.setBackground(new Color(165, 42, 42));
				buttonPane.add(btnViderPanier);
			}
			{
				JButton cancelButton = new JButton("Continuer mes achats");
				eventContinuerAchats(cancelButton);
				cancelButton.setBackground(new Color(224, 255, 255));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel Titre_panier = new JPanel();
			Titre_panier.setBackground(new Color(255, 250, 250));
			getContentPane().add(Titre_panier, BorderLayout.NORTH);
			Titre_panier.setLayout(new BorderLayout(0, 0));
			{
				JLabel panierLabel = new JLabel("Votre panier");
				panierLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panierLabel.setIcon(new ImageIcon(Panier.class.getResource("/Icons/shopping-cart.png")));
				Titre_panier.add(panierLabel);
			}
		}
	}

	private void event_but_cPR() {
		colissimoPR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateRadioButton();
				colissimoPR.setSelected(true);
				updateFraisDePort(colissimoPR);
				updatePrixTTCAvecFraisDePort();
			}
		});
	}

	private void event_but_cD() {
		colissimoD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateRadioButton();
				colissimoD.setSelected(true);
				updateFraisDePort(colissimoD);
				updatePrixTTCAvecFraisDePort();
			}
		});
	}

	private void event_but_lH() {
		livraisonHelico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateRadioButton();
				livraisonHelico.setSelected(true);
				updateFraisDePort(livraisonHelico);
				updatePrixTTCAvecFraisDePort();
			}
		});
	}

	private void eventContinuerAchats(JButton cancelButton) {
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}

	private void eventBoutonViderPanier(JButton btnViderPanier) {
		btnViderPanier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < tableModel.getRowCount()-4; i++) {
					tableModel.removeRow(i);
				}
				MainApp.PANIER.viderPanier();
				MainApp.prixIncPanier = 0F;
				MainApp.bouton_panier.setText(String.format("%10.2f", MainApp.prixIncPanier) + " €");
			}
		});
	}

	private void eventBoutonValiderPanier(JButton okButton) {
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MainApp.PANIER.getTaillePanier() == 0) {
					JOptionPane.showMessageDialog(contentPanel,
					"Votre panier est vide !",
					"Erreur !",
					JOptionPane.ERROR_MESSAGE);
				} else {
					SaisieCoordonnees sCoordonnees = new SaisieCoordonnees(tableModel);
					sCoordonnees.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					sCoordonnees.setVisible(true);
				}
			}
		});
	}

	private void updateTable() {
		Object[] objs = {null,null,null,null};
		for (int i = 0; i < MainApp.PANIER.getTaillePanier(); i++) {
			objs = MainApp.PANIER.getRowItem(i);
			tableModel.addRow(objs);
		}
		Object[] null_ = {null,null,null,null};
		Object[] sous_total = {null,null," SOUS TOTAL TTC ",(String.format("%10.2f",MainApp.prixIncPanier) + " €")};
		Object[] frais_de_port = {null,null," FRAIS DE PORT ", (String.format("%10.2f",this.fraisDePort))};		
		Object[] total_TTC_panier = {null,null, " TOTAL TTC ", (String.format("%10.2f",(MainApp.prixIncPanier + fraisDePort)))};
		tableModel.addRow(null_);
		tableModel.addRow(sous_total);
		tableModel.addRow(frais_de_port);
		tableModel.addRow(total_TTC_panier);
	}

	public void updateRadioButton() {
		for (JRadioButton j : jbuttons) {
			j.setSelected(false);
		}
	}

	private void updateFraisDePort(JRadioButton r){
		if (r.equals(this.livraisonHelico) && MainApp.prixIncPanier < 100) {
			this.fraisDePort = 20.9F;
		}else if (r.equals(this.colissimoPR) && MainApp.prixIncPanier < 100) {
			this.fraisDePort = 4.9F;
		}
		else if (r.equals(this.colissimoD) && MainApp.prixIncPanier < 100) {
			this.fraisDePort = 5.1F;
		} else {
            this.fraisDePort = 0.0F;
		}
	}

	private void updatePrixTTCAvecFraisDePort() {
		tableModel.setValueAt(String.format("%10.2f",this.fraisDePort) + " €", tableModel.getRowCount() - 2, 3);
		tableModel.setValueAt(String.format("%10.2f",this.fraisDePort + MainApp.prixIncPanier) + " €",tableModel.getRowCount() - 1, 3);
	}


}

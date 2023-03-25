package ihm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AffichageFacture extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	/**
	 * Create the dialog.
	 */
	public AffichageFacture(DefaultTableModel tableau) {
		setBounds(100, 100, 600, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 1, 0, 0));
		{
			JPanel infos = new JPanel();
			contentPanel.add(infos);
			infos.setLayout(new GridLayout(1, 1, 0, 0));
			{
				JTextPane textPane = new JTextPane();
				textPane.setEditable(false);
				textPane.setText(affichageInfosClient());
				infos.add(textPane);
			}
		}
		{
			JPanel tableauCommande = new JPanel();
			tableauCommande.setBackground(Color.WHITE);
			contentPanel.add(tableauCommande);
			tableauCommande.setLayout(new GridLayout(1, 0, 0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				tableauCommande.add(scrollPane);
				table = new JTable(tableau);
				table.setFont(new Font("Tahoma", Font.BOLD, 14));
				table.setEnabled(false);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				buttonPane.add(panel);
				panel.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JTextPane textPane = new JTextPane();
					textPane.setText("\t \t Merci pour votre confiance et à bientôt aves nos délices. \n   N'hésitez pas à nous contacter au 06 00 00 00 en cas de problème ou à envoyez un mail au service client.");
					panel.add(textPane);
				}
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1);
					{
						JButton cancelButton = new JButton("Quitter");
						cancelButton.setForeground(Color.WHITE);
						cancelButton.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								System.exit(0);
							}
						});
						cancelButton.setFont(new Font("Tahoma", Font.BOLD, 10));
						cancelButton.setBackground(new Color(165, 42, 42));
						cancelButton.setActionCommand("Cancel");
						panel_1.add(cancelButton);
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 245, 238));
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new GridLayout(4, 1, 0, 0));
			{
				JLabel titreFacture = new JLabel("VOTRE FACTURE");
				titreFacture.setHorizontalAlignment(SwingConstants.CENTER);
				titreFacture.setFont(new Font("Segoe UI Variable", Font.BOLD, 24));
				panel.add(titreFacture);
			}
			{
				JLabel sousLabel = new JLabel("FROMAGERIE SEIGNEURET");
				sousLabel.setHorizontalAlignment(SwingConstants.CENTER);
				sousLabel.setFont(new Font("Miriam Libre", Font.BOLD, 17));
				panel.add(sousLabel);
			}
			{
				JLabel lblNewLabel = new JLabel("à votre service");
				lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 16));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Information client");
				lblNewLabel_1.setBackground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel.add(lblNewLabel_1);
			}
		}
	}

	private String affichageInfosClient(){
		return MainApp.infosClient.getNom() + "\n" +
		MainApp.infosClient.getPrénom() + "\n" +
		MainApp.infosClient.getAdresse1() + "\n" +
		MainApp.infosClient.getAdresse2() + "\n" +
		MainApp.infosClient.getVille() + "\n" +
		MainApp.infosClient.getEtat() + "\n" +
		MainApp.infosClient.getCodePostal() + "\n" +
		MainApp.infosClient.getNoTel() + "\n" +
		MainApp.infosClient.getMail() + "\n";
	}

}

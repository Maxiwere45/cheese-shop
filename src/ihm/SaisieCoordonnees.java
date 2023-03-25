package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SaisieCoordonnees extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField saisieNom;
	private JTextField saisiePrenom;
	private JTextField saisieAdresse1;
	private JTextField saisieVille;
	private JTextField saisieAdresse2;
	private JTextField saisieEtat;
	private JTextField saisieCP;
	private JTextField saisieNumTel;
	private JTextField saisieMail;

	/**
	 * Create the dialog.
	 */
	public SaisieCoordonnees(DefaultTableModel tableau) {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Saisie des coordonnées");
		setBounds(100, 100, 579, 420);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(3, 0, 0, 0));
		{
			JPanel bloc1 = new JPanel();
			bloc1.setBackground(SystemColor.inactiveCaptionBorder);
			contentPanel.add(bloc1);
			bloc1.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JPanel content_bloc1 = new JPanel();
				content_bloc1.setBackground(SystemColor.inactiveCaptionBorder);
				bloc1.add(content_bloc1);
				content_bloc1.setLayout(new GridLayout(2, 1, 0, 0));
				{
					JPanel s1content_bloc1 = new JPanel();
					content_bloc1.add(s1content_bloc1);
					s1content_bloc1.setLayout(new GridLayout(2, 0, 0, 0));
					{
						JLabel lblNewLabel = new JLabel("Nom :");
						lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
						s1content_bloc1.add(lblNewLabel);
					}
					{
						saisieNom = new JTextField();
						s1content_bloc1.add(saisieNom);
						saisieNom.setColumns(10);
					}
				}
				{
					JPanel s2content_bloc1 = new JPanel();
					content_bloc1.add(s2content_bloc1);
					s2content_bloc1.setLayout(new GridLayout(2, 1, 0, 0));
					{
						JLabel lblPrnom = new JLabel("Prénom :");
						lblPrnom.setFont(new Font("Arial", Font.BOLD, 13));
						s2content_bloc1.add(lblPrnom);
					}
					{
						saisiePrenom = new JTextField();
						s2content_bloc1.add(saisiePrenom);
						saisiePrenom.setColumns(10);
					}
				}
			}
			{
				JPanel content2_bloc1 = new JPanel();
				bloc1.add(content2_bloc1);
				content2_bloc1.setLayout(new GridLayout(1, 0, 0, 0));
				{
					JLabel lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setIcon(new ImageIcon(SaisieCoordonnees.class.getResource("/Icons/user.png")));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					content2_bloc1.add(lblNewLabel_1);
				}
			}
		}
		{
			JPanel bloc2 = new JPanel();
			contentPanel.add(bloc2);
			bloc2.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JPanel content_bloc2 = new JPanel();
				bloc2.add(content_bloc2);
				content_bloc2.setLayout(new GridLayout(2, 1, 0, 0));
				{
					JPanel s1content_bloc1 = new JPanel();
					content_bloc2.add(s1content_bloc1);
					s1content_bloc1.setLayout(new GridLayout(2, 0, 0, 0));
					{
						JLabel lblAdresse = new JLabel("Adresse 1 :");
						lblAdresse.setFont(new Font("Arial", Font.BOLD, 13));
						s1content_bloc1.add(lblAdresse);
					}
					{
						saisieAdresse1 = new JTextField();
						saisieAdresse1.setColumns(10);
						s1content_bloc1.add(saisieAdresse1);
					}
				}
				{
					JPanel s2content_bloc2 = new JPanel();
					content_bloc2.add(s2content_bloc2);
					s2content_bloc2.setLayout(new GridLayout(2, 1, 0, 0));
					{
						JLabel lblVille = new JLabel("Ville :");
						lblVille.setFont(new Font("Arial", Font.BOLD, 13));
						s2content_bloc2.add(lblVille);
					}
					{
						saisieVille = new JTextField();
						saisieVille.setColumns(10);
						s2content_bloc2.add(saisieVille);
					}
				}
			}
			{
				JPanel content2_bloc2 = new JPanel();
				bloc2.add(content2_bloc2);
				content2_bloc2.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JPanel s1content_bloc1 = new JPanel();
					content2_bloc2.add(s1content_bloc1);
					s1content_bloc1.setLayout(new GridLayout(2, 0, 0, 0));
					{
						JLabel lblAdresse_1 = new JLabel("Adresse 2 :");
						lblAdresse_1.setFont(new Font("Arial", Font.BOLD, 13));
						s1content_bloc1.add(lblAdresse_1);
					}
					{
						saisieAdresse2 = new JTextField();
						saisieAdresse2.setColumns(10);
						s1content_bloc1.add(saisieAdresse2);
					}
				}
				{
					JPanel s2content_bloc2 = new JPanel();
					content2_bloc2.add(s2content_bloc2);
					s2content_bloc2.setLayout(new GridLayout(1, 2, 0, 0));
					{
						JPanel ss2content_bloc2 = new JPanel();
						s2content_bloc2.add(ss2content_bloc2);
						ss2content_bloc2.setLayout(new GridLayout(2, 0, 0, 0));
						{
							JLabel lbEtat = new JLabel("État :");
							lbEtat.setFont(new Font("Arial", Font.BOLD, 13));
							ss2content_bloc2.add(lbEtat);
						}
						{
							saisieEtat = new JTextField();
							saisieEtat.setColumns(10);
							ss2content_bloc2.add(saisieEtat);
						}
					}
					{
						JPanel ss2content2_bloc2 = new JPanel();
						s2content_bloc2.add(ss2content2_bloc2);
						ss2content2_bloc2.setLayout(new GridLayout(2, 0, 0, 0));
						{
							JLabel lblCodePostal = new JLabel("Code postal");
							lblCodePostal.setFont(new Font("Arial", Font.BOLD, 13));
							ss2content2_bloc2.add(lblCodePostal);
						}
						{
							saisieCP = new JTextField();
							saisieCP.setColumns(10);
							ss2content2_bloc2.add(saisieCP);
						}
					}
				}
			}
		}
		{
			JPanel bloc3 = new JPanel();
			contentPanel.add(bloc3);
			bloc3.setLayout(new GridLayout(0, 2, 0, 0));
			{
				JPanel content2_bloc2 = new JPanel();
				bloc3.add(content2_bloc2);
				content2_bloc2.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JPanel s1content_bloc1 = new JPanel();
					content2_bloc2.add(s1content_bloc1);
					s1content_bloc1.setLayout(new GridLayout(2, 0, 0, 0));
					{
						JLabel lblNoTel = new JLabel("N° de téléphone");
						lblNoTel.setFont(new Font("Arial", Font.BOLD, 13));
						s1content_bloc1.add(lblNoTel);
					}
					{
						saisieNumTel = new JTextField();
						saisieNumTel.setColumns(10);
						s1content_bloc1.add(saisieNumTel);
					}
				}
				{
					JPanel s2content_bloc2 = new JPanel();
					content2_bloc2.add(s2content_bloc2);
					s2content_bloc2.setLayout(new GridLayout(1, 2, 0, 0));
					{
						JPanel ss2content_bloc2 = new JPanel();
						s2content_bloc2.add(ss2content_bloc2);
						ss2content_bloc2.setLayout(new GridLayout(2, 0, 0, 0));
						{
							JLabel lblMl = new JLabel("Mél");
							lblMl.setFont(new Font("Arial", Font.BOLD, 13));
							ss2content_bloc2.add(lblMl);
						}
						{
							saisieMail = new JTextField();
							saisieMail.setColumns(10);
							ss2content_bloc2.add(saisieMail);
						}
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ajouterInformations();
						AffichageFacture affichagef = new AffichageFacture(tableau);
						affichagef.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						affichagef.setVisible(true);
					}
				});
				okButton.setBackground(SystemColor.inactiveCaptionBorder);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(SystemColor.control);
				buttonPane.add(cancelButton);
			}
		}
	}

	private void ajouterInformations(){
		MainApp.infosClient.setNom(this.saisieNom.getText());
		MainApp.infosClient.setPrénom(this.saisiePrenom.getText());
		MainApp.infosClient.setAdresse1(this.saisieAdresse1.getText());
		MainApp.infosClient.setAdresse2(this.saisieAdresse2.getText());
		MainApp.infosClient.setVille(this.saisieVille.getText());
		MainApp.infosClient.setEtat(this.saisieEtat.getText());
		MainApp.infosClient.setCodePostal(this.saisieCP.getText());
		MainApp.infosClient.setNoTel(this.saisieNumTel.getText());
		MainApp.infosClient.setMail(this.saisieMail.getText());
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pk.paiementbillets.dao;

import com.pk.paiementbillets.dao.Paiement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class ZDialog extends JDialog{
    private Paiement pinfo = new Paiement();
    private boolean sendData;
    private  JLabel nomLabel, numeroBltsLabel,numeroBlts2Label,prixLabel,sexeLabel,ageLabel, icon;
    private JRadioButton tranche1,tranche2,tranche3,tranche4;
    private JComboBox sexe,prix;
    private JTextField nom, numeroblts;
    
    public ZDialog(JFrame parent, String title, boolean modal){
        super(parent, title, modal);
        this.setSize(600, 270);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }
    public Paiement showZDialog(){
        this.sendData = false;
        this.setVisible(true);
        return this.pinfo;
    }  
    private void initComponent() {
        icon = new JLabel(new ImageIcon("images/icone.jpg"));
        JPanel panIcon = new JPanel();
        panIcon.setBackground(Color.RED);
        panIcon.setLayout(new BorderLayout());
        panIcon.add(icon);
        
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.RED);
        panNom.setPreferredSize(new Dimension(220, 60));
        nom = new JTextField();
        nom.setPreferredSize(new Dimension(100, 25));
        panNom.setBorder(BorderFactory.createTitledBorder("Nom du client"));
        nomLabel = new JLabel("Saisir votre nom :");
        panNom.add(nomLabel);
        panNom.add(nom);
        
        JPanel panSexe = new JPanel();
        panSexe.setBackground(Color.RED);
        panSexe.setPreferredSize(new Dimension(220, 60));
        panSexe.setBorder(BorderFactory.createTitledBorder("Sexe du client"));
        sexe = new JComboBox();
        sexe.addItem("Masculin");
        sexe.addItem("Féminin");
        sexe.addItem("Indéterminé");
        sexeLabel = new JLabel("Sexe : ");
        panSexe.add(sexeLabel);
        panSexe.add(sexe);
        
        JPanel panAge = new JPanel();
        panAge.setBackground(Color.RED);
        panAge.setBorder(BorderFactory.createTitledBorder("Age du client"));
        panAge.setPreferredSize(new Dimension(440, 60));
        tranche1 = new JRadioButton("15 - 25 ans");
        tranche1.setSelected(true);
        tranche2 = new JRadioButton("26 - 35 ans");
        tranche3 = new JRadioButton("35 - 50 ans");
        tranche4 = new JRadioButton("+ - 50 ans");
        ButtonGroup bg = new ButtonGroup();
        bg.add(tranche1);
        bg.add(tranche2);
        bg.add(tranche3);
        bg.add(tranche4);
        panAge.add(tranche1);
        panAge.add(tranche2);
        panAge.add(tranche3);
        panAge.add(tranche4);
        
        
        JPanel panNumeroBlts = new JPanel();
        panNumeroBlts.setBackground(Color.RED);
        panNumeroBlts.setPreferredSize(new Dimension(220, 60));
        panNumeroBlts.setBorder(BorderFactory.createTitledBorder("numero billet RET077P"));
        numeroBltsLabel = new JLabel("Numero billets");
        numeroBlts2Label = new JLabel("code");
        numeroblts = new JTextField("PK3455S");
        nom.setPreferredSize(new Dimension(90, 25));        
        panNumeroBlts.add(numeroBltsLabel);
        panNumeroBlts.add(numeroblts);
        panNumeroBlts.add(numeroBlts2Label);
        
        JPanel panPrix = new JPanel();
        panPrix.setBackground(Color.RED);
        panPrix.setPreferredSize(new Dimension(220, 60));
        panPrix.setBorder(BorderFactory.createTitledBorder("Montant à payé du client"));
        prix = new JComboBox();
        prix.addItem("50$");
        prix.addItem("100$");
        prix.addItem("150$");
        prixLabel = new JLabel("PRIX : ");
        panPrix.add(prixLabel);
        panPrix.add(prix);
        
        JPanel content = new JPanel();
        content.setBackground(Color.RED);
        content.add(panNom);
        content.add(panSexe);
        content.add(panAge);
        content.add(panNumeroBlts);
        content.add(panPrix);
        
        
        JPanel control = new JPanel();
        JButton enBouton = new JButton("ENREGISTRE");
        
        enBouton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            pinfo = new Paiement(nom.getText(),(String)prix.getSelectedItem() ,getnumeroBlts(),(String)sexe.getSelectedItem(),getAge());
            setVisible(false);  
        }
        public String getAge(){
            return (tranche1.isSelected()) ? tranche1.getText():
                   (tranche2.isSelected()) ? tranche2.getText():
                   (tranche3.isSelected()) ? tranche3.getText():
                   (tranche4.isSelected()) ? tranche4.getText():
                    tranche1.getText();
        }
        public String getnumeroBlts(){
            return (numeroblts.getText().equals("") ? "PK3455S" : numeroblts.getText());
        }
       });
       
       JButton cancelBouton =  new JButton("Annuler");
       cancelBouton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent arg0){
               setVisible(false);
           }
       });
       
       control.add(enBouton);
       control.add(cancelBouton);
       
       this.getContentPane().add(panIcon, BorderLayout.WEST);
       this.getContentPane().add(content, BorderLayout.CENTER);
       this.getContentPane().add(control, BorderLayout.SOUTH);
    }
    
}

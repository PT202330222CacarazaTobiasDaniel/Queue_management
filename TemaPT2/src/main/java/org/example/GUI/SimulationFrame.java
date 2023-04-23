package org.example.GUI;

import org.example.Model.Task;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;



public class SimulationFrame extends  JFrame {
    public int nrCozi,nrClienti,tMaxSim,minArrival,maxArrival,minService,maxService;
    public boolean ok;

    public SimulationFrame(List<Task> objectList) {
        initComponents(objectList);
    }


    @SuppressWarnings("unchecked")
    private void initComponents(List<Task> objectList) {

        Panel = new  JPanel();
        NrClienti = new  JTextField();
        NrCozi = new  JTextField();
        TMaxSim = new  JTextField();
        MinArrival = new  JTextField();
        MaxArrival = new  JTextField();
        MinService = new  JTextField();
        MaxService = new  JTextField();
        jLabel1 = new  JLabel();
        jLabel2 = new  JLabel();
        jLabel3 = new  JLabel();
        jLabel4 = new  JLabel();
        jLabel5 = new  JLabel();
        jLabel6 = new  JLabel();
        jLabel7 = new  JLabel();
        jLabel8 = new  JLabel();
        jLabel9 = new  JLabel();
        jLabel10 = new  JLabel();
        jLabel11 = new  JLabel();
        jScrollPane1 = new  JScrollPane();
        jScrollPane2 = new  JScrollPane();
        jTextArea1 = new  JTextArea();
        jTextArea2 = new  JTextArea();
        Ok = new   JButton();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setBounds(400,200,1,1);
        setTitle("Tema II");


        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("\n");
        jScrollPane1.setViewportView(jTextArea1);


        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("\n");
        jScrollPane2.setViewportView(jTextArea2);

        jLabel1.setText("Numarul de clienti :");
        jLabel2.setText("Numarul de cozi :");
        jLabel3.setText("Timp de simulare :");
        jLabel4.setText("Arrival time : ");
        jLabel5.setText("min");
        jLabel6.setText("max");
        jLabel7.setText("Service time :");
        jLabel8.setText("min");
        jLabel9.setText("max");
        jLabel10.setText("jLabel10");
        jLabel11.setText("jLabel11");

        Ok.setText("Ok");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        GroupLayout PanelLayout = new  GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addGroup(PanelLayout.createSequentialGroup()
                                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel7))
                                                                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel8)
                                                                         .addComponent(jLabel5))))
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                                        .addComponent(TMaxSim,  GroupLayout.PREFERRED_SIZE, 120,  GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(NrCozi,  GroupLayout.PREFERRED_SIZE, 120,  GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(NrClienti,  GroupLayout.PREFERRED_SIZE, 120,  GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(PanelLayout.createSequentialGroup()
                                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(MinArrival,GroupLayout.PREFERRED_SIZE,50,GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(MinService,GroupLayout.PREFERRED_SIZE,50,GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel9))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(MaxArrival,GroupLayout.PREFERRED_SIZE, 50,GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(MaxService,GroupLayout.PREFERRED_SIZE,50,GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup( GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 322,  GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2,  GroupLayout.PREFERRED_SIZE, 322,  GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(30, Short.MAX_VALUE))
                                                                .addGroup(  GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                                        .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Ok)
                                                                        .addGap(146, 146, 146))
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(jLabel10)
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(150, 150, 150))
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                        .addGroup( GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(NrClienti,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(NrCozi,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                                        .addComponent(TMaxSim,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addGap(10, 10, 10)
                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(MinArrival,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(MaxArrival,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(PanelLayout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9)
                                                        .addComponent(MinService,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(MaxService,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 300,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(66, 66, 66)
                                                .addComponent(Ok)
                                                .addPreferredGap(  LayoutStyle.ComponentPlacement.RELATED,   GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel11)
                                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2,  GroupLayout.PREFERRED_SIZE, 300,  GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

         GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Panel,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                        .addComponent(Panel,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {
        nrClienti = Integer.parseInt(NrClienti.getText().compareTo("") == 0?"0":NrClienti.getText());
        nrCozi = Integer.parseInt(NrCozi.getText().compareTo("") == 0?"0":NrCozi.getText());
        tMaxSim = Integer.parseInt(TMaxSim.getText().compareTo("") == 0?"0":TMaxSim.getText());
        maxArrival = Integer.parseInt(MaxArrival.getText().compareTo("") == 0?"0":MaxArrival.getText());
        minArrival = Integer.parseInt(MinArrival.getText().compareTo("") == 0?"0":MinArrival.getText());
        maxService = Integer.parseInt(MaxService.getText().compareTo("") == 0?"0":MaxService.getText());
        minService = Integer.parseInt(MinService.getText().compareTo("") == 0?"0":MinService.getText());
        ok = true;
    }

    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulationFrame(new ArrayList<Task>()).setVisible(true);
            }
        });
    }


    private  JPanel Panel;
    private  JTextArea jTextArea1;
    private  JScrollPane jScrollPane1;
    private  JList<String> jList1;
    private  JTextField MaxArrival;
    private  JTextField MaxService;
    private  JTextField MinArrival;
    private  JTextField MinService;
    private  JTextField NrClienti;
    private  JTextField NrCozi;
    private  JTextField TMaxSim;
    private  JLabel jLabel1;
    private  JLabel jLabel10;
    private  JLabel jLabel11;
    private  JLabel jLabel2;
    private  JLabel jLabel3;
    private  JLabel jLabel4;
    private  JLabel jLabel5;
    private  JLabel jLabel6;
    private  JLabel jLabel7;
    private  JLabel jLabel8;
    private  JLabel jLabel9;
    private   JButton Ok;
    private  JScrollPane jScrollPane2;
    private  JTextArea jTextArea2;
    public void updateT(List<Task> tasks) {
        String s = " ";
        if(tasks != null) {
            for(Task t: tasks)
                s += t + "\n";
            jTextArea1.setText(s);
        }
    }

}

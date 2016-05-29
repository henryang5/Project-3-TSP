package TSP;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TSPGUI extends javax.swing.JFrame
{

    private ArrayList<Cities> verticies = new ArrayList<Cities>();
    private String[] vertex;
    private int[][] edges;

    public TSPGUI ()
    {
        initComponents();
        // set NearestNeighorJButton to default 
        this.getRootPane().setDefaultButton(nearestNeighborJButton);
        this.setTitle("Traveling Sales Person");
        // set the icon on main form 
        this.setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/Data/TSPIcon.png"));
        // Center form
        this.setLocationRelativeTo(null);
    }

    //Java docs for Readfrom File
    public void readFromFile ()
    {
        try
        {
            verticies.clear();
            String fileName = "";
            JFileChooser myFileChooser = new JFileChooser("src/Data");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt", "Data");
            myFileChooser.setFileFilter(filter);
            int returnVal = myFileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File theFile = myFileChooser.getSelectedFile();
                fileName = theFile.getPath();
            }
            FileReader inputFile = new FileReader(fileName);
            BufferedReader input = new BufferedReader(inputFile);
            String line = input.readLine();     // Read first line of file 
            while (line != null)
            {
                Cities newVertex = new Cities();
                // Use the stringtokenizer class to seperate fields in the line 
                StringTokenizer token = new StringTokenizer(line, " ");
                while (token.hasMoreTokens())
                {
                    newVertex.setVertex(token.nextToken());
                    newVertex.setX(Integer.parseInt(token.nextToken()));
                    newVertex.setY(Integer.parseInt(token.nextToken()));
                }
                // add the verticies to the arraylist 
                // Read the next line
                verticies.add(newVertex);
                line = input.readLine();
            }
            vertex = new String[verticies.size()];
            edges = new int[verticies.size()][2];
            createArray();
            input.close();
        }
        catch (FileNotFoundException exp)
        {
            // exp.printStackTrace(); 
            // better: JFilecooser to select file 
            JFileChooser myFileChooser = new JFileChooser("src/Data");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt", "Data");
            myFileChooser.setFileFilter(filter);
            int returnVal = myFileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File theFile = myFileChooser.getSelectedFile();
                String fileName = theFile.getPath();
            }
            else
            {
                System.out.println("Open command cancelled by the user");
            }
        }
        catch (IOException exp)
        {
            exp.printStackTrace();
        }
    }

    public void createArray ()
    {
        for (int i = 0; i < verticies.size(); i++)
        {
            vertex[i] = verticies.get(i).getVertex();
            edges[i][0] = verticies.get(i).getX();
            edges[i][1] = verticies.get(i).getY();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        outputJPanel = new javax.swing.JPanel();
        outputJScrollPane = new javax.swing.JScrollPane();
        outputJTextArea = new javax.swing.JTextArea();
        methodJPanel = new javax.swing.JPanel();
        nearestNeighborJButton = new javax.swing.JButton();
        sortedEdgesJButton = new javax.swing.JButton();
        heldKarpJButton = new javax.swing.JButton();
        statisticsJPanel = new javax.swing.JPanel();
        numberOfCitiesJLabel = new javax.swing.JLabel();
        citiesVisitedJTextField = new javax.swing.JTextField();
        citiesVisitedJLabel = new javax.swing.JLabel();
        numberOfCitiesJTextField = new javax.swing.JTextField();
        actionJPanel = new javax.swing.JPanel();
        clearJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        imageJPanel = new javax.swing.JPanel();
        imageJLabel = new javax.swing.JLabel();
        TSPJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        openJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        printJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        methodJMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        editJMenu = new javax.swing.JMenu();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Output"));

        outputJTextArea.setColumns(20);
        outputJTextArea.setRows(5);
        outputJScrollPane.setViewportView(outputJTextArea);

        javax.swing.GroupLayout outputJPanelLayout = new javax.swing.GroupLayout(outputJPanel);
        outputJPanel.setLayout(outputJPanelLayout);
        outputJPanelLayout.setHorizontalGroup(
            outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outputJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );
        outputJPanelLayout.setVerticalGroup(
            outputJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outputJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputJScrollPane)
                .addContainerGap())
        );

        methodJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Method"));
        methodJPanel.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        nearestNeighborJButton.setText("Nearest Neighbor");
        methodJPanel.add(nearestNeighborJButton);

        sortedEdgesJButton.setText("Sorted Edges");
        methodJPanel.add(sortedEdgesJButton);

        heldKarpJButton.setText("Held Karp");
        methodJPanel.add(heldKarpJButton);

        statisticsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Statistics"));
        statisticsJPanel.setLayout(new java.awt.GridBagLayout());

        numberOfCitiesJLabel.setText("# of Cities:  ");
        statisticsJPanel.add(numberOfCitiesJLabel, new java.awt.GridBagConstraints());

        citiesVisitedJTextField.setMinimumSize(new java.awt.Dimension(30, 22));
        citiesVisitedJTextField.setPreferredSize(new java.awt.Dimension(30, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        statisticsJPanel.add(citiesVisitedJTextField, gridBagConstraints);

        citiesVisitedJLabel.setText("Cities Visited:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        statisticsJPanel.add(citiesVisitedJLabel, gridBagConstraints);

        numberOfCitiesJTextField.setMinimumSize(new java.awt.Dimension(30, 22));
        numberOfCitiesJTextField.setPreferredSize(new java.awt.Dimension(30, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        statisticsJPanel.add(numberOfCitiesJTextField, gridBagConstraints);

        actionJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Action"));
        actionJPanel.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        clearJButton.setText("Clear");
        actionJPanel.add(clearJButton);

        printJButton.setText("Print");
        actionJPanel.add(printJButton);

        saveJButton.setText("Save");
        actionJPanel.add(saveJButton);

        exitJButton.setText("Exit");
        actionJPanel.add(exitJButton);

        imageJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        imageJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data/TSPGUI.png"))); // NOI18N

        javax.swing.GroupLayout imageJPanelLayout = new javax.swing.GroupLayout(imageJPanel);
        imageJPanel.setLayout(imageJPanelLayout);
        imageJPanelLayout.setHorizontalGroup(
            imageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        imageJPanelLayout.setVerticalGroup(
            imageJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        fileJMenu.setText("File");

        openJMenuItem.setText("Open");
        openJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(openJMenuItem);

        clearJMenuItem.setText("Clear");
        fileJMenu.add(clearJMenuItem);

        saveJMenuItem.setText("Save");
        fileJMenu.add(saveJMenuItem);
        fileJMenu.add(fileJSeparator);

        printJMenuItem.setText("Print");
        fileJMenu.add(printJMenuItem);

        exitJMenuItem.setText("Exit");
        fileJMenu.add(exitJMenuItem);

        TSPJMenuBar.add(fileJMenu);

        methodJMenu.setText("Method");

        jMenuItem1.setText("Nearest Neighbor");
        methodJMenu.add(jMenuItem1);

        jMenuItem2.setText("Sorted Edges");
        methodJMenu.add(jMenuItem2);

        jMenuItem3.setText("Held Karp");
        methodJMenu.add(jMenuItem3);

        TSPJMenuBar.add(methodJMenu);

        editJMenu.setText("Edit");
        TSPJMenuBar.add(editJMenu);

        helpJMenu.setText("Help");

        aboutJMenuItem.setText("About");
        helpJMenu.add(aboutJMenuItem);

        TSPJMenuBar.add(helpJMenu);

        setJMenuBar(TSPJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(methodJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statisticsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outputJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statisticsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(methodJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actionJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openJMenuItemActionPerformed
    {//GEN-HEADEREND:event_openJMenuItemActionPerformed
        // Open the file slected by the user
        readFromFile();
    }//GEN-LAST:event_openJMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main (String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(()
                -> 
                {
                    try
                    {
                        SplashJDialog yes = new SplashJDialog(null, true);
                        new TSPGUI().setVisible(true);

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar TSPJMenuBar;
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JPanel actionJPanel;
    private javax.swing.JLabel citiesVisitedJLabel;
    private javax.swing.JTextField citiesVisitedJTextField;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JMenu editJMenu;
    private javax.swing.JButton exitJButton;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JButton heldKarpJButton;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JPanel imageJPanel;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu methodJMenu;
    private javax.swing.JPanel methodJPanel;
    private javax.swing.JButton nearestNeighborJButton;
    private javax.swing.JLabel numberOfCitiesJLabel;
    private javax.swing.JTextField numberOfCitiesJTextField;
    private javax.swing.JMenuItem openJMenuItem;
    private javax.swing.JPanel outputJPanel;
    private javax.swing.JScrollPane outputJScrollPane;
    private javax.swing.JTextArea outputJTextArea;
    private javax.swing.JButton printJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton saveJButton;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JButton sortedEdgesJButton;
    private javax.swing.JPanel statisticsJPanel;
    // End of variables declaration//GEN-END:variables
}

package TSP;

import java.awt.Toolkit;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * ----------------------------------------------------------------------------
 * TSPGUI.java A class representing the GUI used to calculate the shortest Total
 * Distance based on the supplied Cities.
 * <pre>
 *    Project:  ConvexGUI
 *    Platform: jdk 1.8.0_14; NetBeans IDE 8.0; Windows 8
 *    Course:   Java 143
 *    Hours:    16 hours and 45 minutes
 *    Created on:    May 30, 2016, 1:45:39 PM
 *    Revised on:    June 9, 2016
 *
 * @see java.awt.Toolkit;
 * @see java.io.*;
 * @see java.util.*;
 * @see javax.swing.*;
 * @see javax.swing.filechooser.FileNameExtensionFilter;
 * </pre>
 * ----------------------------------------------------------------------------
 */
public class TSPGUI extends javax.swing.JFrame
{

    public ArrayList<Point> pts = new ArrayList<>();
    public ArrayList<Integer> vertices = new ArrayList<>();
    public int[][] edges;
    public List<WeightedEdge> list = new ArrayList<>();
    private String[] vertex; 

    /**
     *
     */
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
        readFromFile(); 
    }

    //Java docs for Readfrom File

    /**
     *
     */
    public void readFromFile ()
    {
        try 
        {  
            File file = new File("");
            final JFileChooser chooser = new JFileChooser("src/Data");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(this);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                file = new File(chooser.getSelectedFile().toString());
                BufferedReader input = new BufferedReader(new FileReader(file));
                String line = input.readLine();

                while (line != null) 
                {
                    StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                    while (stringTokenizer.hasMoreElements()) 
                    {
                        vertices.add(Integer.parseInt(stringTokenizer.nextToken().trim()));
                        pts.add(new Point(Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    line = input.readLine();
                }
                createEdges(vertices, pts); 
                WeightedGraph<Integer> graph = new WeightedGraph<Integer>(list, vertices.size());
                graph.printWeightedEdges();
                WeightedGraph<Integer>.MST tree = graph.getMinimumSpanningTree(0);
                tree.printTree();
                input.close();
            }
        }
        catch(FileNotFoundException exp)
        {
            // exp.printStackTrace(); 
            // better: JFilecooser to select file 
            JFileChooser myFileChooser = new JFileChooser("src/Data");
            FileNameExtensionFilter filter = new 
                        FileNameExtensionFilter("Text File", "txt", "Data"); 
            myFileChooser.setFileFilter(filter);
            int returnVal = myFileChooser.showOpenDialog(null); 
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                File theFile = myFileChooser.getSelectedFile(); 
                String fileName = theFile.getPath(); 
            }
            else 
                System.out.println("Open command cancelled by the user");
        }
        catch(IOException exp)
        {
            exp.printStackTrace();        
        }
    }

    /**
     *
     * @param v
     * @param p
     */
    public void createEdges(ArrayList<Integer> v, ArrayList<Point> p)
    {
        edges = new int[p.size()][3];
        for (int i = 0; i < p.size(); i++)
        {
            for (int j = i + 1; j < p.size(); j++ )
            {
                edges[i][0]=i;
                edges[i][1]=j;
                edges[i][2]=(int)Point.getDistance(p.get(i), p.get(j)); 
                list.add(new WeightedEdge(edges[i][0],edges[i][1],edges[i][2]));
                list.add(new WeightedEdge(edges[i][1],edges[i][0],edges[i][2]));
                System.out.print(edges[i][0]+ " , "+edges[i][1] + ": ");
                System.out.println(edges[i][2]);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        methodJPanel = new javax.swing.JPanel();
        nearestNeighborJButton = new javax.swing.JButton();
        sortedEdgesJButton = new javax.swing.JButton();
        heldKarpJButton = new javax.swing.JButton();
        statisticsJPanel = new javax.swing.JPanel();
        numberOfCitiesJLabel = new javax.swing.JLabel();
        totalMilesJTextField = new javax.swing.JTextField();
        totalMilesJLabel = new javax.swing.JLabel();
        numberOfCitiesJTextField = new javax.swing.JTextField();
        nanosecondsJLabel = new javax.swing.JLabel();
        nanosecondsJTextField = new javax.swing.JTextField();
        methodJTextField = new javax.swing.JTextField();
        actionJPanel = new javax.swing.JPanel();
        clearJButton = new javax.swing.JButton();
        printFormJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        imageJPanel = new javax.swing.JPanel();
        imageJLabel = new javax.swing.JLabel();
        dataJTabbedPane = new javax.swing.JTabbedPane();
        inputJScrollPane = new javax.swing.JScrollPane();
        inputJTextArea = new javax.swing.JTextArea();
        outputJScrollPane = new javax.swing.JScrollPane();
        outputJTextArea = new javax.swing.JTextArea();
        TSPJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        openJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        printJMenu = new javax.swing.JMenu();
        printFormJMenuItem = new javax.swing.JMenuItem();
        printDataJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        methodJMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(224, 224, 224));
        setResizable(false);

        methodJPanel.setBackground(new java.awt.Color(237, 237, 237));
        methodJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Method"));
        methodJPanel.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        nearestNeighborJButton.setMnemonic('N');
        nearestNeighborJButton.setText("Nearest Neighbor");
        nearestNeighborJButton.setToolTipText("A method to find the shortest path.");
        methodJPanel.add(nearestNeighborJButton);

        sortedEdgesJButton.setMnemonic('E');
        sortedEdgesJButton.setText("Sorted Edges");
        sortedEdgesJButton.setToolTipText("A method to find the shortest path.");
        methodJPanel.add(sortedEdgesJButton);

        heldKarpJButton.setMnemonic('K');
        heldKarpJButton.setText("Held Karp");
        heldKarpJButton.setToolTipText("A method to find the shortest path.");
        methodJPanel.add(heldKarpJButton);

        statisticsJPanel.setBackground(new java.awt.Color(237, 237, 237));
        statisticsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Statistics"));
        statisticsJPanel.setLayout(new java.awt.GridBagLayout());

        numberOfCitiesJLabel.setText("# of Cities:");
        numberOfCitiesJLabel.setToolTipText("");
        statisticsJPanel.add(numberOfCitiesJLabel, new java.awt.GridBagConstraints());

        totalMilesJTextField.setEditable(false);
        totalMilesJTextField.setMinimumSize(new java.awt.Dimension(30, 22));
        totalMilesJTextField.setPreferredSize(new java.awt.Dimension(30, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        statisticsJPanel.add(totalMilesJTextField, gridBagConstraints);

        totalMilesJLabel.setText("Total Miles: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        statisticsJPanel.add(totalMilesJLabel, gridBagConstraints);

        numberOfCitiesJTextField.setEditable(false);
        numberOfCitiesJTextField.setMinimumSize(new java.awt.Dimension(30, 22));
        numberOfCitiesJTextField.setPreferredSize(new java.awt.Dimension(30, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        statisticsJPanel.add(numberOfCitiesJTextField, gridBagConstraints);

        nanosecondsJLabel.setText(" NanoSeconds:   ");
        statisticsJPanel.add(nanosecondsJLabel, new java.awt.GridBagConstraints());

        nanosecondsJTextField.setEditable(false);
        nanosecondsJTextField.setMinimumSize(new java.awt.Dimension(30, 22));
        nanosecondsJTextField.setPreferredSize(new java.awt.Dimension(40, 22));
        statisticsJPanel.add(nanosecondsJTextField, new java.awt.GridBagConstraints());

        methodJTextField.setEditable(false);
        methodJTextField.setPreferredSize(new java.awt.Dimension(130, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        statisticsJPanel.add(methodJTextField, gridBagConstraints);

        actionJPanel.setBackground(new java.awt.Color(237, 237, 237));
        actionJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Action"));
        actionJPanel.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        clearJButton.setMnemonic('C');
        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Clear the form.");
        clearJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearJButtonActionPerformed(evt);
            }
        });
        actionJPanel.add(clearJButton);

        printFormJButton.setText("Print Form");
        printFormJButton.setToolTipText("Print the form.");
        actionJPanel.add(printFormJButton);

        saveJButton.setMnemonic('S');
        saveJButton.setText("Save");
        saveJButton.setToolTipText("Save the displayed data.");
        actionJPanel.add(saveJButton);

        exitJButton.setMnemonic('x');
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Exit the program.");
        exitJButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitJButtonActionPerformed(evt);
            }
        });
        actionJPanel.add(exitJButton);

        imageJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        imageJLabel.setBackground(new java.awt.Color(224, 224, 224));
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

        dataJTabbedPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inputJTextArea.setEditable(false);
        inputJTextArea.setColumns(20);
        inputJTextArea.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        inputJTextArea.setRows(5);
        inputJTextArea.setText("  \n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n  Welcome to the Traveling Salesman\n \t       Program.\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        inputJTextArea.setToolTipText("Shows the calculated data.");
        inputJScrollPane.setViewportView(inputJTextArea);

        dataJTabbedPane.addTab("Input", inputJScrollPane);

        outputJTextArea.setEditable(false);
        outputJTextArea.setColumns(20);
        outputJTextArea.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        outputJTextArea.setRows(5);
        outputJTextArea.setToolTipText("Shows the calculated data.");
        outputJScrollPane.setViewportView(outputJTextArea);

        dataJTabbedPane.addTab("Output", outputJScrollPane);

        fileJMenu.setText("File");

        openJMenuItem.setMnemonic('O');
        openJMenuItem.setText("Open");
        openJMenuItem.setToolTipText("Open a file containing cities.");
        openJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(openJMenuItem);

        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clear the form.");
        fileJMenu.add(clearJMenuItem);

        saveJMenuItem.setText("Save");
        saveJMenuItem.setToolTipText("Save the displayed data.");
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);
        fileJMenu.add(fileJSeparator);

        printJMenu.setText("Print");

        printFormJMenuItem.setMnemonic('P');
        printFormJMenuItem.setText("Print Form");
        printFormJMenuItem.setToolTipText("Print the form.");
        printFormJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                printFormJMenuItemActionPerformed(evt);
            }
        });
        printJMenu.add(printFormJMenuItem);

        printDataJMenuItem.setMnemonic('D');
        printDataJMenuItem.setText("Print Data");
        printDataJMenuItem.setToolTipText("Print the outputed data.");
        printJMenu.add(printDataJMenuItem);

        fileJMenu.add(printJMenu);

        exitJMenuItem.setText("Exit");
        exitJMenuItem.setToolTipText("Exit the program.");
        fileJMenu.add(exitJMenuItem);

        TSPJMenuBar.add(fileJMenu);

        methodJMenu.setText("Method");

        jMenuItem1.setText("Nearest Neighbor");
        jMenuItem1.setToolTipText("A method to find the shortest path.");
        methodJMenu.add(jMenuItem1);

        jMenuItem2.setText("Sorted Edges");
        jMenuItem2.setToolTipText("A method to find the shortest path.");
        methodJMenu.add(jMenuItem2);

        jMenuItem3.setText("Held Karp");
        jMenuItem3.setToolTipText("A method to find the shortest path.");
        methodJMenu.add(jMenuItem3);

        TSPJMenuBar.add(methodJMenu);

        helpJMenu.setText("Help");
        helpJMenu.setToolTipText("");

        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("Display the about form.");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aboutJMenuItemActionPerformed(evt);
            }
        });
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
                    .addComponent(dataJTabbedPane)
                    .addComponent(statisticsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
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
                        .addComponent(dataJTabbedPane))
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

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aboutJMenuItemActionPerformed
    {//GEN-HEADEREND:event_aboutJMenuItemActionPerformed
        // Open the about form
        AboutJDialog myAbout = new AboutJDialog(this, rootPaneCheckingEnabled);
        myAbout.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitJButtonActionPerformed
    {//GEN-HEADEREND:event_exitJButtonActionPerformed
        // Exit the program
        System.exit(0);
    }//GEN-LAST:event_exitJButtonActionPerformed

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearJButtonActionPerformed
    {//GEN-HEADEREND:event_clearJButtonActionPerformed
        // Clear the form
        inputJTextArea.setText("");
        numberOfCitiesJTextField.setText("");
        nanosecondsJTextField.setText("");
        totalMilesJTextField.setText("");
        methodJTextField.setText("");
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
          // Save the Statistics of the program.
        // Save the context of the JTextArea to an external text file
        // Create a file to write onto
        try
        {
            FileWriter fwriter = new FileWriter("src/Data/results.txt", true);
            PrintWriter outputFile = new PrintWriter(fwriter);
            outputFile.println(inputJTextArea.getText());
            outputFile.close();
        }
        catch(IOException exp)
        {
            exp.printStackTrace();

        }
    }//GEN-LAST:event_saveJMenuItemActionPerformed

    private void printFormJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printFormJMenuItemActionPerformed
         // call print printComponent method of the printUtiliites
        // 7/99 Marty Hall, http://www.apl.jhu.edu/~hall/java/
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printFormJMenuItemActionPerformed

    /**
     * The main method for the Traveling Salesperson Problem.
     * 
     * @param args the command line arguments
     */
    public static void main (String args[])
    {
        /* Set the Nimbus look and feel */
        try
        {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e)
        {
            // handle exception
        }
        catch (ClassNotFoundException e)
        {
            // handle exception
        }
        catch (InstantiationException e)
        {
            // handle exception
        }
        catch (IllegalAccessException e)
        {
            // handle exception
        }
        // Create and display the form
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
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JTabbedPane dataJTabbedPane;
    private javax.swing.JButton exitJButton;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JButton heldKarpJButton;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JPanel imageJPanel;
    private javax.swing.JScrollPane inputJScrollPane;
    private javax.swing.JTextArea inputJTextArea;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu methodJMenu;
    private javax.swing.JPanel methodJPanel;
    private javax.swing.JTextField methodJTextField;
    private javax.swing.JLabel nanosecondsJLabel;
    private javax.swing.JTextField nanosecondsJTextField;
    private javax.swing.JButton nearestNeighborJButton;
    private javax.swing.JLabel numberOfCitiesJLabel;
    private javax.swing.JTextField numberOfCitiesJTextField;
    private javax.swing.JMenuItem openJMenuItem;
    private javax.swing.JScrollPane outputJScrollPane;
    private javax.swing.JTextArea outputJTextArea;
    private javax.swing.JMenuItem printDataJMenuItem;
    private javax.swing.JButton printFormJButton;
    private javax.swing.JMenuItem printFormJMenuItem;
    private javax.swing.JMenu printJMenu;
    private javax.swing.JButton saveJButton;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JButton sortedEdgesJButton;
    private javax.swing.JPanel statisticsJPanel;
    private javax.swing.JLabel totalMilesJLabel;
    private javax.swing.JTextField totalMilesJTextField;
    // End of variables declaration//GEN-END:variables
}

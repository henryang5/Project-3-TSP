package TSP;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Romanphb
 */
public class SplashJDialog extends javax.swing.JDialog
{
    final static int length = 3150;
    /**
     * Creates new form SplashJDialog
     */
    public SplashJDialog(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
      //  this.setIconImage(Toolkit.getDefaultToolkit().
         //       getImage("src/data/CardsIcon.png"));
        splashJProgressBar.setStringPainted(true);
        ImageIcon splashGif = new ImageIcon("src/data/DanceSplash.png");
        splashJLabel.setIcon(splashGif);
        
//        for (int i=0; i<=100; i++){
//	splashJProgressBar.setValue(i);
//	splashJProgressBar.repaint();
//	try{Thread.sleep((long) 31.5);}
//	catch (InterruptedException err){}
        Thread t = new Thread()
        {
            @Override
            public void run()
            {
                //SplashJDialog dialog = new SplashJDialog(new javax.swing.JFrame(), true);
                int i = 0;
                while(i <= 100)
                {
                    splashJProgressBar.setValue(i);
                    try
                    {
                       sleep(20); 
                    }
                    catch(InterruptedException ex)
                    {
                        Logger.getLogger(SplashJDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
                        splashJProgressBar.setString("Ready!");
                try
                {
                    sleep(1150);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(SplashJDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                        setVisible(false);
                        dispose();

        }   
        };
        t.start();
        setVisible(true);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleJLabel = new javax.swing.JLabel();
        splashJLabel = new javax.swing.JLabel();
        splashJProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "By: Roman Barlet and Henry Ang"));

        titleJLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleJLabel.setText("Traveling Salesman Problem ");
        titleJLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        splashJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data/DanceSplash.png"))); // NOI18N
        splashJLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        splashJProgressBar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        splashJProgressBar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loading", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        splashJProgressBar.setFocusable(false);
        splashJProgressBar.setInheritsPopupMenu(true);
        splashJProgressBar.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(splashJProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(splashJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splashJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splashJProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel splashJLabel;
    private javax.swing.JProgressBar splashJProgressBar;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}

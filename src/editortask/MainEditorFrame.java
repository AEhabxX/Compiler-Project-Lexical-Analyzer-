/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortask;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
//Youssef
public class MainEditorFrame extends javax.swing.JFrame {

    //File Variable that holds the File to be scanned
    File CurrentOpenedFile = null;
    //HoldsFile Data for Scanning Process
    String Buffer = "";

    //Comment and Uncomment Variables
    String Selected_Text_Comment;
    int start_index;
    int end_index;
    String Commented_Text;

    //Output Table Column Names
    DefaultTableModel model = new DefaultTableModel(new String[]{"Line No", "Lexeme", "ReturnToken", "Lexeme NO in Line ", "matchability"}, 0);
    //ArrayList To hold all KeyWords For AutoComplete
    List<String> Suggestions = new ArrayList<String>();

    public MainEditorFrame() {
        initComponents();
        //Add Title to main frame
        this.setTitle("Editor");
        ArrayList<String> Suggestions = new ArrayList<>();
        Suggestions.add("Divisio");
        Suggestions.add("InferedFrom");
        Suggestions.add("WhetherDo");
        Suggestions.add("Else");
        Suggestions.add("Ire");
        Suggestions.add("Sire");
        Suggestions.add("Clo");
        Suggestions.add("SetofClo");
        Suggestions.add("FBU");
        Suggestions.add("SFBU");
        Suggestions.add("NoneValue");
        Suggestions.add("TerminateThisNow");
        Suggestions.add("RingWhen");
        Suggestions.add("BackedValue");
        Suggestions.add("STT");
        Suggestions.add("Check");
        Suggestions.add("CaseOf");
        Suggestions.add("Beginning");
        Suggestions.add("End");
        Suggestions.add("Using");

        AutoSuggestor autoSuggestor = new AutoSuggestor(InputArea, this, Suggestions, Color.WHITE.brighter(), Color.black, Color.black, 0.75f) {
            @Override
            boolean wordTyped(String typedWord) {
                //System.out.println(typedWord);
                return super.wordTyped(typedWord);//checks for a match in dictionary and returns true or false if found or not
            }
        };
        this.setResizable(false);
        //this.setUndecorated(true);
        this.setLocation(0, 0);

        //To Open only text files when browsing files
        FileNameExtensionFilter text_files = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        FileBrowser.setFileFilter(text_files);

    }

    public Void FileOutput(String FileName) throws FileNotFoundException, IOException {
        File Output = new File(FileName);
        //Phase 1 yo split the lines on ";"
        //Phase 2 to split the one line data on "."
        String[] phase1;
        String[] phase2;

        String intern; //Used During Splitting process 
        Scanner LR = new Scanner(new FileInputStream(Output));

        String st = " ";
        while (LR.hasNextLine()) {
            st += LR.nextLine();
        }

        LR.close();
        //System.out.println(st);
        phase1 = st.split(";");
        //System.out.println(Arrays.toString(phase1));
        for (int i = 0; i < phase1.length; i++) {
            intern = phase1[i];
            phase2 = intern.split("[.]");
            //Add the output data to the output table in GUI
            model.addRow(new Object[]{phase2[0], phase2[1], phase2[2], phase2[3], phase2[4]});

        }
        OutputTable.setModel(model);

        //System.out.println(Arrays.toString(phase2));
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileBrowser = new javax.swing.JFileChooser();
        FileSaver = new javax.swing.JFileChooser();
        SaveButton = new javax.swing.JButton();
        BrowseButton = new javax.swing.JButton();
        ScanButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        OutputTable = new javax.swing.JTable();
        ResetButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InputArea = new javax.swing.JTextArea();
        Comment = new javax.swing.JButton();
        Uncomment = new javax.swing.JButton();

        FileSaver.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        FileSaver.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainEditorScreen"); // NOI18N

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        BrowseButton.setText("Browse");
        BrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseButtonActionPerformed(evt);
            }
        });

        ScanButton.setText("Scan");
        ScanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });

        OutputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "LineNo.", "Lexeme", "Return Token", "Lexeme NO in  Line", "matchability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(OutputTable);
        if (OutputTable.getColumnModel().getColumnCount() > 0) {
            OutputTable.getColumnModel().getColumn(0).setResizable(false);
            OutputTable.getColumnModel().getColumn(1).setResizable(false);
            OutputTable.getColumnModel().getColumn(2).setResizable(false);
            OutputTable.getColumnModel().getColumn(3).setResizable(false);
            OutputTable.getColumnModel().getColumn(4).setResizable(false);
        }

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        InputArea.setColumns(20);
        InputArea.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        InputArea.setLineWrap(true);
        InputArea.setRows(5);
        InputArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                InputAreaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(InputArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        Comment.setText("Comment");
        Comment.setMaximumSize(new java.awt.Dimension(57, 23));
        Comment.setMinimumSize(new java.awt.Dimension(57, 23));
        Comment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommentActionPerformed(evt);
            }
        });

        Uncomment.setText("Uncomment");
        Uncomment.setMaximumSize(new java.awt.Dimension(57, 23));
        Uncomment.setMinimumSize(new java.awt.Dimension(57, 23));
        Uncomment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UncommentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(BrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Comment, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Uncomment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BrowseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Comment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Uncomment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//SaveButton
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        if (CurrentOpenedFile == null) {

            int status = FileSaver.showOpenDialog(rootPane);

            if (status == JFileChooser.APPROVE_OPTION) {
                String SelectedFileName = JOptionPane.showInputDialog("File Name", "noName.txt");
                if (!SelectedFileName.contains("txt")) {
                    SelectedFileName += "txt";

                }
                File f = new File(FileSaver.getSelectedFile() + "\\" + SelectedFileName);
                if (f.exists()) {
                    JOptionPane.showMessageDialog(rootPane, "File Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        f.createNewFile();
                        PrintWriter WriteInNewFile = new PrintWriter(f);
                        WriteInNewFile.write(InputArea.getText());
                        WriteInNewFile.close();

                    } catch (IOException ex) {
                        Logger.getLogger(MainEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } else {

                JOptionPane.showMessageDialog(rootPane, "Error Cant save FIle", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            try {
                //Define printwriter object to write in the CurrentOpenedfile
                PrintWriter file_writer = new PrintWriter(CurrentOpenedFile);
                file_writer.write(InputArea.getText());
                file_writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_SaveButtonActionPerformed
//Browse Button
    private void BrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseButtonActionPerformed

        //In this section Implementation of showing opening file dialogue 
        int status = FileBrowser.showOpenDialog(rootPane);

        if (status == JFileChooser.APPROVE_OPTION) {

            CurrentOpenedFile = FileBrowser.getSelectedFile();
            System.out.println("The name of choosen file is " + FileBrowser.getSelectedFile().getName());
        } else {
            System.out.println("No File is Selected");
        }
        try {
            //After Selecting The file Create Scanner Object take the file name to save it's content then scan it
            Scanner Scan_File = new Scanner(new FileInputStream(CurrentOpenedFile));

            while (Scan_File.hasNext()) {
                Buffer += Scan_File.nextLine() + "\n";
                //Here to put the scanner Functions
                System.out.println("OR Succeded");

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainEditorFrame.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_BrowseButtonActionPerformed
//ScannerButton
    private void ScanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanButtonActionPerformed
        // TODO add your handling code here:
if(CurrentOpenedFile==null){


        //First step is to create a file to the save the content
        File f = new File("Scan.txt");
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(MainEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter WriteInNewFile;
        try {
            WriteInNewFile = new PrintWriter(f);
            WriteInNewFile.write(InputArea.getText());
            WriteInNewFile.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileOutput("Scan1.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainEditorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

}
else{
//If there is no browsed file then pass currentOpenedFile to the scanner function and put the output in scan1.txt


}


    }//GEN-LAST:event_ScanButtonActionPerformed
//ResetButton
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        InputArea.setText("");
        model.setRowCount(0);

    }//GEN-LAST:event_ResetButtonActionPerformed
//CommentButton
    private void CommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommentActionPerformed
 InputArea.replaceRange(Commented_Text, start_index, end_index);
        

    }//GEN-LAST:event_CommentActionPerformed
//Uncomment Button
    private void UncommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UncommentActionPerformed
InputArea.replaceRange(Selected_Text_Comment, start_index, end_index + 4);
       
    }//GEN-LAST:event_UncommentActionPerformed

    private void InputAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputAreaMouseReleased
        // TODO add your handling code here:
          if (InputArea.getSelectedText() != null) { // See if they selected something 
            Selected_Text_Comment = InputArea.getSelectedText();
            start_index = InputArea.getSelectionStart();
            end_index = InputArea.getSelectionEnd();

            Commented_Text = "/#" + Selected_Text_Comment + "#/";

            System.out.println(Selected_Text_Comment);

            System.out.println(start_index);

        }
        
    }//GEN-LAST:event_InputAreaMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainEditorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainEditorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseButton;
    private javax.swing.JButton Comment;
    private javax.swing.JFileChooser FileBrowser;
    private javax.swing.JFileChooser FileSaver;
    private javax.swing.JTextArea InputArea;
    private javax.swing.JTable OutputTable;
    private javax.swing.JButton ResetButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton ScanButton;
    private javax.swing.JButton Uncomment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hschaves
 */
public class Principal extends javax.swing.JFrame {
    private List<String> campos = new ArrayList<>();
    private List<List<String>> valores = new ArrayList<>();
    private List<String> inserts = new ArrayList<>();
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        gerarScriptButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputCaminhoArquivo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoQueryFinal = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        gerarScriptButton = new javax.swing.JButton();
        nomeTabela = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerador de Script");

        jLabel1.setText("Arquivo:");

        jButton1.setText("Adicionar Arquivo XLS");
        jButton1.setActionCommand("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(campoQueryFinal);

        jLabel2.setText("SCRIPT GERADO");

        gerarScriptButton.setText("Gerar Script");
        gerarScriptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarScriptButtonActionPerformed(evt);
            }
        });

        nomeTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTabelaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome da tabela:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputCaminhoArquivo)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nomeTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gerarScriptButton))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gerarScriptButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();  
        int returnVal = chooser.showOpenDialog(null);  
        if(returnVal == JFileChooser.APPROVE_OPTION) {            
           File arq = chooser.getSelectedFile().getAbsoluteFile();  
           String caminho = arq.getPath();                 
           inputCaminhoArquivo.setText(caminho);    
           gerarScriptButton.setEnabled(true);
           
       }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void gerarScriptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarScriptButtonActionPerformed
        try {
            this.limpar();
            lerExcel();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_gerarScriptButtonActionPerformed
    
    private void limpar() {
        campoQueryFinal.setText(null);
        campos = new ArrayList<>();
        valores = new ArrayList<>();
        inserts = new ArrayList<>();
    }
    private void nomeTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTabelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTabelaActionPerformed
    private void lerExcel() throws FileNotFoundException, IOException, ParseException {   
        FileInputStream excelFile = new FileInputStream(new File(inputCaminhoArquivo.getText()));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        if(iterator.hasNext()) {
            buscarCabecalho(iterator);
            buscarValores(iterator);
        }     
        escreverInsert();
        String  queries = ""; 
        for (String insert: this.inserts) {
            queries += insert + ";\n"; 
        }
        
        campoQueryFinal.setText(queries);
         
    }
    private void escreverInsert() {
       this.valores.forEach(linhaValor ->{
            String insert ="INSERT INTO %s (%s) VALUES(%s)";
            String  query = String.format(insert,nomeTabela.getText(), campos.toString().replace("[", "").replace("]",""),linhaValor.toString().replace("[", "").replace("]",""));
            this.inserts.add(query);
       });
    }    
    
    private void buscarValores(Iterator<Row> iterator) throws ParseException {
        while (iterator.hasNext()) {
            Row currentRow2 = iterator.next();            
            List<String> valores = new ArrayList<>();
            Iterator<Cell> cellIterator2 = currentRow2.iterator();
            
            while (cellIterator2.hasNext()) {                
                Cell currentCell = cellIterator2.next();
                if( currentCell.getCellTypeEnum() != CellType.NUMERIC && currentCell.getStringCellValue().equalsIgnoreCase("null")){
                    valores.add("NULL");
                }
                else if(currentCell.getCellTypeEnum() == CellType.NUMERIC && HSSFDateUtil.isCellDateFormatted(currentCell)){                  
                   valores.add(this.tratarData(currentCell.getDateCellValue()));
                }
                else if (currentCell.getCellTypeEnum() != CellType.NUMERIC && currentCell.getCellTypeEnum() == CellType.STRING) {
                    valores.add("'" + currentCell.getStringCellValue() + "'");
                }   
                else {    
                    valores.add(new Double(currentCell.getNumericCellValue()).toString().replace(",", "."));
                }
            }
            
            this.valores.add(valores);
        }
    }
    
    private static String tratarData(Date date) throws ParseException {      
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return "'" + formatter.format(date) + "'";
    }

    private void buscarCabecalho(Iterator<Row> iterator) {
        Row currentRow = iterator.next();
        Iterator<Cell> cellIterator = currentRow.iterator();
        
        while (cellIterator.hasNext()) {
            Cell currentCell = cellIterator.next();
            if (currentCell.getCellTypeEnum() == CellType.STRING) {
                this.campos.add(currentCell.getStringCellValue());
            }
        }
    }
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane campoQueryFinal;
    private javax.swing.JButton gerarScriptButton;
    private javax.swing.JTextField inputCaminhoArquivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeTabela;
    // End of variables declaration//GEN-END:variables
}

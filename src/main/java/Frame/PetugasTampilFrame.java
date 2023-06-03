
package Frame;

import db.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Petugas;

public class PetugasTampilFrame extends javax.swing.JFrame {
        Petugas petugas;
        
    public PetugasTampilFrame() {
        initComponents();
        setLocationRelativeTo(null);
        resetTable("");
    }
    
    public ArrayList<Petugas> getPetugasList (String keyword){
        ArrayList<Petugas> petugasList = new ArrayList<Petugas>();
        Koneksi koneksi = new Koneksi();
        Connection connection =koneksi.getConnection();
        
        String query = "SELECT * FROM petugas" +keyword;
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                petugas = new Petugas(
                        rs.getInt("id"),
                        rs.getString("nama_petugas"),
                        rs.getString("username"),
                        rs.getString("password"));
                petugasList.add(petugas);                                
            }
        } catch (SQLException | NullPointerException ex){
            System.err.println("Koneksi Null Gagal");
        }
        return petugasList;
    }
    
    public void selectPetugas(String keyword){
        ArrayList<Petugas> list = getPetugasList(keyword);
        DefaultTableModel model = (DefaultTableModel)tPetugas.getModel();
        Object [] row = new Object[4];
        
        for (int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getNamaPetugas();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getPassword();
                    
           model.addRow(row);
        }
    }
    
    public final void resetTable(String keyword){
        DefaultTableModel model = (DefaultTableModel)tPetugas.getModel();
        model.setRowCount(0);
        selectPetugas(keyword);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        eCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tPetugas = new javax.swing.JTable();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bTutup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cari Petugas");

        bCari.setText("Cari");

        tPetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama Petugas", "Username", "Password"
            }
        ));
        scrollPane.setViewportView(tPetugas);
        if (tPetugas.getColumnModel().getColumnCount() > 0) {
            tPetugas.getColumnModel().getColumn(0).setMaxWidth(35);
        }

        bTambah.setText("Tambah");

        bUbah.setText("Ubah");

        bHapus.setText("Hapus");

        bBatal.setText("Batal");

        bTutup.setText("Tutup");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                        .addComponent(eCari))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bTambah)
                        .addGap(18, 18, 18)
                        .addComponent(bUbah)
                        .addGap(18, 18, 18)
                        .addComponent(bHapus)
                        .addGap(18, 18, 18)
                        .addComponent(bBatal)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bTutup)
                    .addComponent(bCari))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari))
                .addGap(26, 26, 26)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bUbah)
                    .addComponent(bHapus)
                    .addComponent(bBatal)
                    .addComponent(bTutup))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PetugasTampilFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bTutup;
    private javax.swing.JButton bUbah;
    private javax.swing.JTextField eCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tPetugas;
    // End of variables declaration//GEN-END:variables
}

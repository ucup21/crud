/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import latihanojdbc.Koneksi;
import model.JobGrade;

/**
 *
 * @author Asus
 */
public class JobGradeDao {

    public Connection kon;

    public JobGradeDao() {
        this.kon = new Koneksi().getKoneksi();
    }

    public JobGradeDao(String e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Fungsi untuk melihat semua data JobGrade
     * @param cari String
     * @return List semua data JobGrade
     */

//    public List<JobGrade> getAllData() {
//        List<JobGrade> datas = new ArrayList<>();
//        try {
//            PreparedStatement pst = kon.prepareStatement("select * from HR.JOB_GRADES");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()){
//                JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_sal"),
//                rs.getInt("highest_sal"));
////                jd.setGradeLevel(rs.getString("grade_level"));
////                jd.setLowestSalary(rs.getInt("lowest_sal"));
////                jd.setHighestSalary(rs.getInt("highest_sal"));
//                datas.add(jd);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(JobGradeDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return datas;
//    }
    
    public List<JobGrade> getData(String query) {
        List<JobGrade> datas = new ArrayList<>();
        try {
            PreparedStatement pst = kon.prepareStatement("select * from JOB_GRADES "+query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_sal"),
                rs.getInt("highest_sal"));
                datas.add(jd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datas;
    }
    
    public List<JobGrade> getAllData(){
        return getData("");
    }
    
    public JobGrade getByGradeLevel(String gradeLevel){
        return getData("WHERE grade_level = '"+gradeLevel+"'").get(0);
    }
    
    public List<JobGrade> search(String category, String cari) {
        return getData("WHERE "+category+" LIKE '%"+cari+"%'");
    }
    
    //insert
    public boolean insert(JobGrade jobgrade){
        try {
            PreparedStatement pst = kon.prepareStatement("INSERT into JOB_GRADES "
                    +"VALUES (?,?,?)");
        pst.setString(1, jobgrade.getGradeLevel());
        pst.setInt(2, jobgrade.getLowestSalary());
        pst.setInt(3, jobgrade.getHighestSalary());
        pst.executeUpdate();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //update 
    public boolean update(JobGrade jobgrade){
        try {
            PreparedStatement pst = kon.prepareStatement("UPDATE JOB_GRADES "
                    +"SET lowest_sal = ?, highest_sal = ? where grade_level = ?");
        pst.setString(3, jobgrade.getGradeLevel());
        pst.setInt(1, jobgrade.getLowestSalary());
        pst.setInt(2, jobgrade.getHighestSalary());
        pst.executeUpdate();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(String grade_level){
        try {
            PreparedStatement pst = kon.prepareStatement("DELETE FROM JOB_GRADES "
                    +"where grade_level = ?");
        pst.setString(1, grade_level);
        pst.executeUpdate();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

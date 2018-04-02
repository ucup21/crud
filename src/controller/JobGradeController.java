/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JobGradeDao;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.JobGrade;

/**
 *
 * @author Asus
 */
public class JobGradeController implements ControllerInterface{

    public JobGradeDao jgdao;
    
    public JobGradeController() {
        this.jgdao = new JobGradeDao();
    }

    @Override
    public boolean insert(Object obj) {
        JobGrade jg = (JobGrade)obj;
        return jgdao.insert(jg);
    }
    
    public boolean insert(String gradeLevel, int lowSal, int higSal){
        JobGrade grade = new JobGrade(gradeLevel, lowSal, higSal);
        return jgdao.insert(grade);
    }

    @Override
    public boolean delete(String id) {
        return jgdao.delete(id);
    }
    

    @Override
    public boolean update(Object obj) {
        JobGrade jg2 = (JobGrade)obj;
        return jgdao.update(jg2);
    }
    
    public boolean update(String gradeLevel, int lowSal, int higSal){
        JobGrade grade = new JobGrade(gradeLevel, lowSal, higSal);
        return jgdao.update(grade);
    }

    @Override
    public List<Object> search(String kategori, String cari) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getByGradeLevel(String gradelevel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void bindingAll(JTable table, String[] header){
        bindingTabel(table, header, jgdao.getAllData());
    }
    public void bindingSearch(JTable table, String[] header, String category, String cari){
        bindingTabel(table, header, jgdao.search(category, cari));
    }
    
    public void bindingTabel(JTable table, String[] header, List<JobGrade> datas){
        Object[][] data = new Object[datas.size()][3];
        for (int i = 0; i < datas.size(); i++) {
            data[i][0] = datas.get(i).getGradeLevel();
            data[i][1] = datas.get(i).getLowestSalary();
            data[i][2] = datas.get(i).getHighestSalary();
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
    
    //cara ke 2
//    public void bindingTabels(JTable table){
//        String header[]={"Grade Level", "Lowest Salary", "Highest Salary"};
//        List<JobGrade> datas = new JobGradeDao().getAllData();
//        DefaultTableModel model = new DefaultTableModel(header, 0);
//        for (JobGrade data : datas) {
//            Object[] data1 ={
//                data.getGradeLevel(),
//                data.getLowestSalary(),
//                data.getHighestSalary()
//            };
//            model.addRow(data1);
//        }
//        table.setModel(model);
//    }
} 


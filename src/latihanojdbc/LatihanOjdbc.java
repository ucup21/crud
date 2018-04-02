/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanojdbc;

import dao.JobGradeDao;
import java.util.List;
import model.JobGrade;

/**
 *
 * @author Asus
 */
public class LatihanOjdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(new Koneksi().getKoneksi());
//        System.out.println(new JobGradeDao().getAllData().size());
        JobGrade datas = new JobGradeDao().getByGradeLevel("A");
//        for (int i = 0; i < datas.size(); i++) {
//            System.out.println(datas.get(i).getGradeLevel()+", gaji terendah "
//            +datas.get(i).getHighestSalary());
        System.out.println(datas.getGradeLevel()+", gaji terendah "+
                datas.getHighestSalary());
        
        //insert
        JobGrade insert = new JobGrade("F", 40000, 6000);
        System.out.println(new JobGradeDao().insert(insert));
        
        //update
//        JobGrade update = new JobGrade("A", 2000, 4000);
//        System.out.println(new JobGradeDao().update(update));
        
        JobGradeDao del = new JobGradeDao();
        System.out.println(del.delete("E"));
        
    }
    
        
        
        
        
//        List<JobGrade> datas = new JobGradeDao().getAllData();
//        datas.forEach(x -> System.out.println(x.getGradeLevel()+ ", gaji terendah"
//        +x.getHighestSalary()));
        
//        System.out.println("\n fore 1 baris");
//        datas.forEach(x -> System.out.println(x.getGradeLevel()+ ", gaji terendah " 
//                +x.getHighestSalary()));
//        
//        System.out.println("\n fore banyak baris");
//        for (JobGrade data : datas) {
//            System.out.println(data.getGradeLevel()+", gaji terendah "
//            +data.getHighestSalary());
//        }
    }
//}


import dao.DoctorDAO;
import dao.TreatmentDAO;
import dao.impl.DoctorImpl;
import dao.impl.TreatmentImpl;
import entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQL");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            // Add your code here
//
//            tx.commit();
//        }catch (Exception e) {
//            e.printStackTrace();
//            emf.close();
//        }

        DoctorDAO doctorDAO = new DoctorImpl();
        doctorDAO.listDoctors("OK", 02, 2002)
                .forEach(doctor -> {
                    System.out.println(doctor);
                });
        doctorDAO.getNoOfDoctorsBySpeciality("Vy")
                .entrySet()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                });

        TreatmentDAO treatmentDAO = new TreatmentImpl();
        treatmentDAO.updateDiagnosis("pa1", "p1", "OK");
    }
}



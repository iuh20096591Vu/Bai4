package dao.impl;

import dao.TreatmentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.server.UnicastRemoteObject;

public class TreatmentImpl extends UnicastRemoteObject implements TreatmentDAO {
    private EntityManager em;

    public TreatmentImpl() throws Exception {
        em = Persistence.createEntityManagerFactory("SQL")
                .createEntityManager();
    }
    @Override
    public boolean updateDiagnosis(String patientID, String doctorID, String diagnosis) throws Exception{

        int check = em.createQuery("update Treatment t set t.diagnosis = :diagnosis  where t.patient.id = :patientID and t.doctor.id = :doctorID")
                .setParameter("diagnosis", diagnosis)
                .setParameter("patientID", patientID)
                .setParameter("doctorID", doctorID)
                .executeUpdate();

        return check > 0;
    }

}

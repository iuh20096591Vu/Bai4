package dao;

import java.rmi.Remote;

public interface TreatmentDAO extends Remote {
    public boolean updateDiagnosis(String patientID, String doctorID, String diagnosis) throws Exception;
}

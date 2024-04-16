package dao;

import entity.Doctor;

import java.rmi.Remote;
import java.util.List;
import java.util.Map;

public interface DoctorDAO extends Remote {
    public List<Doctor> listDoctors(String speciality, int month, int year) throws Exception;
    public Map<String, Long> getNoOfDoctorsBySpeciality(String departmentName) throws Exception;
}

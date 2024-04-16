package dao.impl;
import dao.DoctorDAO;
import entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DoctorImpl extends UnicastRemoteObject implements DoctorDAO {
    private EntityManager em;
    public DoctorImpl( ) throws Exception{
        em = Persistence.createEntityManagerFactory("SQL")
                .createEntityManager();
    }
    @Override
    public List<Doctor> listDoctors(String speciality, int month, int year) throws Exception{
        return em.createQuery("select d from Doctor d inner join Treatment t on d.id = t.doctor.id where d.speciality = :speciality and month(t.startDate) = :month and year(t.startDate) = :year", Doctor.class)
                .setParameter("speciality", speciality)
                .setParameter("month", month)
                .setParameter("year", year)
                .getResultList();
    }
    @Override
    public Map<String, Long> getNoOfDoctorsBySpeciality(String departmentName) throws Exception{
        Map<String, Long> map = new HashMap<>();
        List<?> list = em.createQuery("select d.speciality, count(*) as count  from Doctor d inner join Department dp on d.department.id = dp.id where dp.name = :departmentName group by d.speciality")
                .setParameter("departmentName", departmentName)
                .getResultList();
        list.stream()
                .map(o -> (Object[])o)
                .forEach(a -> {
                    String speciality = (String)a[0];
                    long count = (long)a[1];
                    map.put(speciality, count);
                });
        return map;
    }
}

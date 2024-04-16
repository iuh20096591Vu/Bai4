import dao.DoctorDAO;
import dao.impl.DoctorImpl;
import entity.Doctor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DoctorTest {
    private DoctorDAO doctorDAO;
    @BeforeAll
    void setUp() throws Exception {
        doctorDAO = new DoctorImpl();
    }

    @Test
    void testListDoctors() throws Exception {
        assertEquals(1, doctorDAO.listDoctors("OK", 02, 2002).size());
    }

    @AfterAll
    void tearDown() {
        doctorDAO = null;
    }
}
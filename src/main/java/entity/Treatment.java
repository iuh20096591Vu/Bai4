package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "treatments")
public class Treatment implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDate startDate;
    private LocalDate endDate;
    private String diagnosis;

    public Treatment() {
    }

    public Treatment(Patient patient, LocalDate startDate, LocalDate endDate, String diagnosis) {
        this.patient = patient;
        this.startDate = startDate;
        this.endDate = endDate;
        this.diagnosis = diagnosis;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "patient=" + patient +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}

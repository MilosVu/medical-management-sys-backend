package rs.naprednejava.medicalmanagementsys.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "prescription")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prescription_id")
	private long prescriptionId;
	
	@OneToOne	
	@JoinColumn(name="examination_id", insertable = false, updatable = false)
	@MapsId("examinationId")
	private Examination examination;
	
	@Column(name = "examination_id")
	private Long examinationId;

	public String disease;
	
	public String description;

	public Long getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Long examinationId) {
		this.examinationId = examinationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}


	public Prescription(Examination examination, Long examinationId, String disease, String description) {
		super();

		this.examination = examination;
		this.examinationId = examination.getExaminationId();
		this.disease = disease;
		this.description = description;
	}
	public Prescription(Examination examination, String disease, String description) {
		super();

		this.examination = examination;
		this.examinationId = examination.getExaminationId();
		this.disease = disease;
		this.description = description;
	}
	public Prescription(Long examinationId, String disease, String description) {
		super();

		
		this.examinationId = examinationId;
		this.disease = disease;
		this.description = description;
	}
	
	public Prescription(Examination examination, long prescriptionId, Long examinationId, String disease,
			String description) {
		super();
		this.examination = examination;
		this.prescriptionId = prescriptionId;
		this.examinationId = examinationId;
		this.disease = disease;
		this.description = description;
	}

	public Prescription() {
		super();
	}

	@Override
	public String toString() {
		return "Prescription [examination=" + examination + ", prescriptionId=" + prescriptionId + ", examinationId="
				+ examinationId + ", disease=" + disease + ", description=" + description + "]";
	}

}

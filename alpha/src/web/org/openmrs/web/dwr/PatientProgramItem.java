package org.openmrs.web.dwr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openmrs.PatientProgram;
import org.openmrs.ProgramWorkflow;
import org.openmrs.api.context.Context;

public class PatientProgramItem {

	private Integer patientProgramId;
	private Integer patientId;
	private String name;
	private Date dateEnrolled;
	private Date dateCompleted;
	private Map<String, Integer> workflows; // workflow name -> programWorkflowId

	public PatientProgramItem() { }
	
	public PatientProgramItem(Context context, PatientProgram p) {
		patientProgramId = p.getPatientProgramId();
		patientId = p.getPatient().getPatientId();
		dateEnrolled = p.getDateEnrolled();
		dateCompleted = p.getDateCompleted();
		name = p.getProgram().getConcept().getName(context.getLocale(), false).getName();
		workflows = new HashMap<String, Integer>();
		for (ProgramWorkflow wf : p.getProgram().getWorkflows()) {
			workflows.put(wf.getConcept().getName(context.getLocale(), false).getName(), wf.getProgramWorkflowId());
		}
	}

	public Map<String, Integer> getWorkflows() {
		return workflows;
	}

	public void setWorkflows(Map<String, Integer> workflows) {
		this.workflows = workflows;
	}

	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public Date getDateEnrolled() {
		return dateEnrolled;
	}

	public void setDateEnrolled(Date dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getPatientProgramId() {
		return patientProgramId;
	}

	public void setPatientProgramId(Integer patientProgramId) {
		this.patientProgramId = patientProgramId;
	}
	
	static DateFormat ymdDf = new SimpleDateFormat("yyyy-MM-dd");
	public String getDateEnrolledAsYmd() {
		return dateEnrolled == null ? null : ymdDf.format(dateEnrolled);
	}
	public String getDateCompletedAsYmd() {
		return dateCompleted == null ? null : ymdDf.format(dateCompleted);
	}

}

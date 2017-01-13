package by.it_academy.model.entity4dao;

import java.util.Arrays;

/**
 * contain an income information about faculty with an appropriate {@link Faculty#id}
 * @author head4max
 *
 */
public class Faculty extends Entity {
	
	/**
	 * name of a faculty
	 */
	private String facultyName;
	/**
	 * enumeration some IDes appropriate an objects from {@link Certificate} for income to {@link #facultyName} with ";" regex
	 */
	private String[] examObjects;
	
	/**
	 * constructor
	 * @param id
	 * @param facultyName
	 * @param entryMark
	 * @param takeObjectsID
	 */
	public Faculty(String facultyName, String...takeObjects) {
		super(facultyName.hashCode());
		this.facultyName = facultyName;
		this.examObjects = takeObjects;
	}
	
	public static Faculty getInstance(String bundle){
		
		String[] fac = bundle.split(":");
		if(fac.length != 2){
			return null;
		}
		String facultyName = fac[0];
		String[] exam = fac[1].split(",");
		
		if(exam.length != 3){
			return null;
		} else {
			return new Faculty(facultyName,exam[0],exam[1],exam[2]);
		}
	}

	/**
	 * @return the {@link Faculty#facultyName}
	 */
	public String getFacultyName() {
		return facultyName;
	}

	/**
	 * @return the {@link Faculty#examObjects}
	 */
	public String getFirstExamObjects() {
		return examObjects[0];
	}
	
	public String getSecondExamObjects() {
		return examObjects[1];
	}
	
	public String getThirdExamObjects() {
		return examObjects[2];
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Faculty [" + (facultyName != null ? "facultyName=" + facultyName + ", " : "")
				+ (examObjects != null ? "examObjects=" + Arrays.toString(examObjects) : "") + "]";
	}
	
	
}

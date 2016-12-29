package by.it_academy.model.entity4dao;

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
	 * sum of exam marks required for income to {@link #facultyName}
	 */
	private int entryMark;
	/**
	 * enumeration some IDes appropriate an objects from {@link Certificate} for income to {@link #facultyName} with ";" regex
	 */
	private String examObjectsID;
	
	/**
	 * constructor
	 * @param id
	 * @param facultyName
	 * @param entryMark
	 * @param takeObjectsID
	 */
	public Faculty(int id, String facultyName,int entryMark, String takeObjectsID) {
		super(id);
		this.facultyName = facultyName;
		this.examObjectsID = takeObjectsID;
		this.entryMark = entryMark;
	}

	/**
	 * @return the {@link Faculty#facultyName}
	 */
	public String getFacultyName() {
		return facultyName;
	}

	/**
	 * @return the {@link Faculty#entryMark}
	 */
	public int getEntryMark() {
		return entryMark;
	}

	/**
	 * @return the {@link Faculty#examObjectsID}
	 */
	public String getExamObjectsID() {
		return examObjectsID;
	}
	
	
}

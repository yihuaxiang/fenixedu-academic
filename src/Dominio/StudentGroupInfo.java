package Dominio;

import Util.StudentType;


/**
 * @author dcs-rjao
 *
 * 24/Mar/2003
 */

public class StudentGroupInfo extends DomainObject implements IStudentGroupInfo {

	private StudentType studentType;
	private Integer minCoursesToEnrol;
	private Integer maxCoursesToEnrol;
	private Integer maxNACToEnrol;
	
	public StudentGroupInfo() {
	}

	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof IStudentGroupInfo) {
			IStudentGroupInfo studentType = (IStudentGroupInfo) obj;
			resultado = ( this.getStudentType().equals(studentType.getStudentType()));
		}
		return resultado;
	}

	public String toString() {
		String result = "[" + this.getClass().getName() + "; ";
		result += "studentType = " + this.studentType + "; ";
		result += "minCoursesToEnrol = " + this.minCoursesToEnrol + "; ";
		result += "maxNACToEnrol = " + this.maxNACToEnrol + "; ";
		result += "maxCoursesToEnrol = " + this.maxCoursesToEnrol + "]\n";
		return result;
	}

	public StudentType getStudentType() {
		return studentType;
	}

	public void setStudentType(StudentType studentType) {
		this.studentType = studentType;
	}

	public Integer getMaxCoursesToEnrol() {
		return maxCoursesToEnrol;
	}

	public Integer getMaxNACToEnrol() {
		return maxNACToEnrol;
	}

	public Integer getMinCoursesToEnrol() {
		return minCoursesToEnrol;
	}

	public void setMaxCoursesToEnrol(Integer maxCoursesToEnrol) {
		this.maxCoursesToEnrol = maxCoursesToEnrol;
	}

	public void setMaxNACToEnrol(Integer maxNACToEnrol) {
		this.maxNACToEnrol = maxNACToEnrol;
	}

	public void setMinCoursesToEnrol(Integer minCoursesToEnrol) {
		this.minCoursesToEnrol = minCoursesToEnrol;
	}
}
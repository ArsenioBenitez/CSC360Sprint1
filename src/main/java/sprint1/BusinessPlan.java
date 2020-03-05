package sprint1;
import java.util.*;
import java.time.*;

public abstract class BusinessPlan {
	public String name;
	public String description;
	public String date;
	public int timeStamp=0;
	public ArrayList<Part> LeadingPart;
	public String assessment;	

	public BusinessPlan() {}
	public BusinessPlan(String name) {
		super();
		this.name = name;
		this.date=LocalDate.now().toString();
		this.LeadingPart=new ArrayList<Part>();	
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the timeStamp
	 */
	public int getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @return the assessment
	 */
	public String getAssessment()
	{
		return assessment;
	}
	/**
	 * @param assessment the assessment to set
	 */
	public void setAssessment(String assessment)
	{
		this.assessment = assessment;
	}
	@Override
	public String toString()
	{
		return "BusinessPlan [name=" + name + ", description=" + description + ", date=" + date + ", timeStamp="
				+ timeStamp + ", LeadingPart=" + LeadingPart + ", assessment=" + assessment + "]";
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the leadingPart
	 */
	public ArrayList<Part> getLeadingPart() {
		return LeadingPart;
	}

	// add parts
	public abstract void addLeadingPart (Part part1);
	//part 1 is the child of part 2
	public abstract void addPart (Part part1, Part part2);
}

package sprint1;

import java.beans.*;
import java.io.*;

public class BusinessPlanTest1
{
	private static final String SERIALIZED_FILE_NAME="businessPlan1.xml";
	public static void main(String[] args)
	{
		//create business plan: VOMOSA
		BusinessPlan VMOSAplan = new VMOSA("test1");
		VMOSAplan.setDescription("This is the VMOSA business Plan");
		VMOSAplan.setTimeStamp(00000);
		VMOSAplan.setAssessment("Goal Achieved!");
		
		System.out.println(VMOSAplan);
		
		Part vision1=new Vision();
		Part mission1=new Mission();
		Part objective1=new Objective();
		Part strategy1=new Strategy();
		Part action1=new Action();
		vision1.setDescription("This is the vision1 for VMOSA");
		mission1.setDescription("This is the mission1 for VMOSA");
		objective1.setDescription("This is the objective1 for VMOSA");
		strategy1.setDescription("This is the strategy1 for VMOSA");
		action1.setDescription("This is the action1 for VMOSA");
		
		
		VMOSAplan.addLeadingPart(vision1);
		VMOSAplan.addPart(mission1,vision1);
		VMOSAplan.addPart(objective1,mission1);
		VMOSAplan.addPart(strategy1,objective1);
		VMOSAplan.addPart(action1,strategy1);
		System.out.println(VMOSAplan);
		
		
		//create business plan: VMSGOA
		BusinessPlan addtionalPlan = new VMSGOA("test2");
		addtionalPlan.setDescription("This is the VMSGOA business Plan");
		addtionalPlan.setTimeStamp(00000);
		addtionalPlan.setAssessment("Goal is not achieved!");
		
		System.out.println(addtionalPlan);
		
		Part vision=new Vision();
		Part mission=new Mission();
		Part objective=new Objective();
		Part strategy=new Strategy();
		Part goal=new Goal();
		Part action=new Action();
		vision.setDescription("This is the vision for VMSGOA");
		mission.setDescription("This is the mission for VMSGOA");
		objective.setDescription("This is the objective for VMSGOA");
		strategy.setDescription("This is the strategy for VMSGOA");
		action.setDescription("This is the action for VMSGOA");
		goal.setDescription("This is the goal for VMSGOA");
		
		
		addtionalPlan.addLeadingPart(vision);
		addtionalPlan.addPart(mission,vision);
		//System.out.println(vision1);
		addtionalPlan.addPart(strategy,mission);
		addtionalPlan.addPart(goal,strategy);
		addtionalPlan.addPart(objective,goal);
		addtionalPlan.addPart(action,objective);
		System.out.println(addtionalPlan);
		
		
		
		//store VMOSA in XML
		XMLEncoder encoder=null;
		try{
			encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
			}
		catch(FileNotFoundException fileNotFound){
				System.out.println("ERROR: While Creating or Opening the File dvd.xml");
			}
			encoder.writeObject(VMOSAplan);
			encoder.close();
		//read VMOSA back
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File dvd.xml not found");
		}
		BusinessPlan VMOSAplanDeCode=(BusinessPlan)decoder.readObject();
		System.out.println(VMOSAplanDeCode);
	}
	

}

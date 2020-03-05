package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BPtest
{

	@Test
	void test()
	{
		//create & initialize the business plan object 1: VMOSA
		BusinessPlan VMOSAplan = new VMOSA("test1");
		VMOSAplan.setName("VMOSAtest1");
		VMOSAplan.setDescription("This is the VMOSA business Plan");
		VMOSAplan.setTimeStamp(00000);
		VMOSAplan.setDate("2020/03/03");
		
		VMOSAplan.setAssessment("Goal Achieved!");
		
		//create tests 
		assertEquals("VMOSAtest1",VMOSAplan.getName());
		assertEquals(00000,VMOSAplan.getTimeStamp());
		assertEquals("2020/03/03",VMOSAplan.getDate());
		assertEquals("This is the VMOSA business Plan",VMOSAplan.getDescription());
		assertEquals("Goal Achieved!",VMOSAplan.getAssessment());
		
		//create parts for object 1
		Part vision1=new Vision();
		Part vision2=new Vision();
		Part mission1=new Mission();
		Part objective1=new Objective();
		Part strategy1=new Strategy();
		Part action1=new Action();
		vision1.setDescription("This is the vision1 for VMOSA");
		vision2.setDescription("This is the vision2 for VMOSA");
		mission1.setDescription("This is the mission1 for VMOSA");
		objective1.setDescription("This is the objective1 for VMOSA");
		strategy1.setDescription("This is the strategy1 for VMOSA");
		action1.setDescription("This is the action1 for VMOSA");
		
		//create tests
		assertEquals("This is the vision1 for VMOSA",vision1.getDescription());
		assertEquals("This is the mission1 for VMOSA",mission1.getDescription());
		assertEquals("This is the objective1 for VMOSA",objective1.getDescription());
		assertEquals("This is the strategy1 for VMOSA",strategy1.getDescription());
		assertEquals("This is the action1 for VMOSA",action1.getDescription());
		
		VMOSAplan.addLeadingPart(vision1);
		VMOSAplan.addLeadingPart(vision2);
		VMOSAplan.addPart(mission1,vision1);
		VMOSAplan.addPart(objective1,mission1);
		VMOSAplan.addPart(strategy1,objective1);
		VMOSAplan.addPart(action1,strategy1);
		
		assertEquals(VMOSAplan.LeadingPart,VMOSAplan.getLeadingPart());
		assertEquals(VMOSAplan.LeadingPart.get(1),vision2);
		assertEquals("strategy",strategy1.getTypeName());
		assertEquals(null,vision2.getParent());
		assertEquals(vision1,mission1.getParent());
		assertEquals(mission1,vision1.getChildren().get(0));
		
		//create & initialize the business plan object 2: VMSGOA
		BusinessPlan additionalPlan = new VMSGOA("test2");
		additionalPlan.setDescription("This is the VMSGOA business Plan");
		additionalPlan.setTimeStamp(000022);
		additionalPlan.setAssessment("Goal is not achieved!");

		//create tests 
		assertEquals("test2",additionalPlan.getName());
		assertEquals(000022,additionalPlan.getTimeStamp());
		assertEquals("This is the VMSGOA business Plan",additionalPlan.getDescription());
		assertEquals("Goal is not achieved!",additionalPlan.getAssessment());

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
		
		assertEquals("action",action.getTypeName());
		assertEquals("This is the goal for VMSGOA",goal.getDescription());

		additionalPlan.addLeadingPart(vision);
		additionalPlan.addPart(mission,vision);
		additionalPlan.addPart(strategy,mission);
		additionalPlan.addPart(goal,strategy);
		additionalPlan.addPart(objective,goal);
		additionalPlan.addPart(action,objective);
		
		assertEquals(strategy,goal.getParent());
		assertEquals(objective,goal.getChildren().get(0));
		
		//test XML: store & read back
		String SERIALIZED_FILE_NAME="businessPlan1.xml";
		XMLEncoder encoder=null;
		try{
			encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
			}
		catch(FileNotFoundException fileNotFound){
				System.out.println("ERROR: While Creating or Opening the File dvd.xml");
			}
			encoder.writeObject(VMOSAplan);
			encoder.close();
		
		
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File dvd.xml not found");
		}
		BusinessPlan VMOSAplanDeCode=(BusinessPlan)decoder.readObject();
		
		System.out.println(VMOSAplanDeCode);
		System.out.println(VMOSAplan);
		
		//assertEquals(VMOSAplanDeCode.getAssessment(),VMOSAplan.getAssessment());
		//assertEquals(VMOSAplanDeCode.getLeadingPart(),VMOSAplan.getLeadingPart());
		
		
	}
	
}

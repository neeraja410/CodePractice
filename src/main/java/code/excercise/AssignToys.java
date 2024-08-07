package code.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class AssignToys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//list of Students
		//inserted a comment
                List <String> listOfStudents=new ArrayList<String>();
		listOfStudents.add("Raju");
		listOfStudents.add("Jagadesh");
		listOfStudents.add("Ramana");
		listOfStudents.add("Gopi");
		listOfStudents.add("Neeraja");
		listOfStudents.add("Banu");
		listOfStudents.add("Venu"); 
		listOfStudents.add("Anita");


		//Set of toys
		Set<String> setOfToys = new HashSet<>();
		setOfToys.add("car");
		setOfToys.add("bus");
		setOfToys.add("bubbles");
		setOfToys.add("pencil");
		setOfToys.add("train");

		//map of a student with their age
		Map<String,Integer> StdentWithAges=new HashMap<String,Integer>();
		StdentWithAges.put("Neeraja", 32);
		StdentWithAges.put("Raju", 7);
		StdentWithAges.put("Ramana", 8);
		StdentWithAges.put("Gopi", 6);
		StdentWithAges.put("Banu", 7);
		StdentWithAges.put("Venu", 6);
		StdentWithAges.put("Anita", 8);


		//map of toys with age
		Map<Integer, List<String>> ageWithToys = new HashMap<Integer, List<String>>();
		List<String> toys1 = new ArrayList<String>();
		toys1.add("car");
		toys1.add("bubbles");
		ageWithToys.put(6, toys1);
		List<String> toys2 = new ArrayList<String>();
		toys2.add("pencil");
		toys2.add("bus");
		ageWithToys.put(7, toys2);
		List<String> toys3 = new ArrayList<String>();
		toys3.add("bus");
		toys3.add("train");
		toys3.add("car");
		ageWithToys.put(8, toys3); 
		//findToysForStudent1(StdentWithAges,ageWithToys);
		//findToysForStudent2(listOfStudents,StdentWithAges,ageWithToys,setOfToys);
		String givenToy="bus";
		//findStudentsPlayedWithToys(givenToy, listOfStudents, StdentWithAges, ageWithToys, setOfToys);
		findOnlyDistinctToys(ageWithToys);
	}

	private static void findOnlyDistinctToys(Map<Integer, List<String>> allAgesandToyNamesMap) {
		// TODO Auto-generated method stub
//		for (Entry<Integer, List<String>> entryOfAgeWithToys : ageWithToys.entrySet()) {
//			List<String> listOfToys=entryOfAgeWithToys.getValue();
//			System.out.println(listOfToys);
//			for(String toy:listOfToys) {
//				
//			}
//		}
		
		  // Step 1: Count the occurrences of each toy
        Map<String, Integer> allToyNamesandTheirCountMap = new HashMap<>();
        for (List<String> toysListofOneAgeGroup : allAgesandToyNamesMap.values()) {
            for (String singleToyNameFromAgeList : toysListofOneAgeGroup) {
                allToyNamesandTheirCountMap.put(singleToyNameFromAgeList, allToyNamesandTheirCountMap.getOrDefault(singleToyNameFromAgeList, 0) + 1);
            }
        }
        
        for (Entry<String, Integer>  eachtoy : allToyNamesandTheirCountMap.entrySet()) {
        	if(eachtoy.getValue() <= 1)
        		System.out.println("unique toys that are not shared are. toy name " + eachtoy.getKey() + " count of them = " +eachtoy.getValue() );
        	else
        	 System.out.println("duplicate toys are for toy name " + eachtoy.getKey() + " count of them = " +eachtoy.getValue() );
        }
        
		
	}

	private static void findStudentsPlayedWithToys(String givenToy, List<String> listOfStudents, Map<String, Integer> stdentWithAges,
			Map<Integer, List<String>> ageWithToys, Set<String> setOfToys) {
		// TODO Auto-generated method stub

		for (Entry<Integer, List<String>> entryOfAgeWithToys : ageWithToys.entrySet()) {
			//car,bubbles==car
			//entryOfAgeWithToys 6-key car, bubbles-value.
			if(entryOfAgeWithToys.getValue().contains(givenToy)){
			//ageofstudent=car.getkey i.e 6
			int ageOfStudent=entryOfAgeWithToys.getKey();
			for (Entry<String, Integer> entryOfStdentWithAges:stdentWithAges.entrySet()){
				//gopi 6 banu 7
				if(entryOfStdentWithAges.getValue()==(ageOfStudent)) {
					//6==6
					String Student_name=entryOfStdentWithAges.getKey();
					//6.getkey gopi
					System.out.println(Student_name);
				}
			}
		}
		
		}
	}

	private static void findToysForStudent2(List<String> listOfStudents, Map<String, Integer> stdentWithAges,
			Map<Integer, List<String>> ageWithToys, Set<String> setOfToys) {

		// TODO Auto-generated method stub
		for(String student:listOfStudents){
			if(stdentWithAges.get(student) == null ) {
				System.out.println(student+" "+"can play with"+setOfToys);
				continue;
			}
			int studentAge=stdentWithAges.get(student);
			//int outputResult = Condition ? return this if true : return this if false;
			// int biggerValue = a > b ? a : b;

			if(ageWithToys.get(studentAge) == null || ageWithToys.get(studentAge).isEmpty()) {

				System.out.println(student+" " +"can play with"+" "+"bubbles");
				continue;
			}
			List<String> toys=ageWithToys.get(studentAge);
			System.out.println(student+"" + "can play with" +toys );
		}
	}

	private static void findToysForStudent1(Map<String,Integer> studentAgeMap, Map<Integer, List<String>> ageToysMap) {
		Integer studentAge;
		//List<String> value;
		//Integer value1 = null;
		for (Entry<Integer, List<String>> entry : ageToysMap.entrySet()) {
			studentAge = entry.getKey();
			// value=entry.getValue();
			System.out.println(studentAge); // 8
			System.out.println(entry.getValue()); //car
			//System.out.println(studentAgeMap.containsValue(key));

			for (Entry<String, Integer> entry2:studentAgeMap.entrySet() ) {
				//entry2 "Raju", 8
				if(entry2.getValue()==studentAge) {
					String studentName=entry2.getKey();
					System.out.println(studentName);
				}
			}
		}
	}


}



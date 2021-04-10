package assignment2;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestAPI2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="";
		try {
			data = GetDistance.calculate("Vancouver", "Seattle");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		 JSONParser parser = new JSONParser();
		        try {

		         Object obj = parser.parse(data);
		         JSONObject jsonobj=(JSONObject)obj;

		         JSONArray dist=(JSONArray)jsonobj.get("rows");
		         JSONObject obj2 = (JSONObject)dist.get(0);
		         JSONArray disting=(JSONArray)obj2.get("elements");
		         JSONObject obj3 = (JSONObject)disting.get(0);
		         JSONObject obj4=(JSONObject)obj3.get("distance");
		         JSONObject obj5=(JSONObject)obj3.get("duration");
		         System.out.println(obj4.get("text"));
		         System.out.println(obj5.get("text"));

		    }
		catch(Exception e) {
		    e.printStackTrace();
		}
	}

}

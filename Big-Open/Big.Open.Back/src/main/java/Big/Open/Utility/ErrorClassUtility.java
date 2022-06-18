package big.open.utility;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.nimbusds.jose.shaded.json.JSONObject;


public class ErrorClassUtility 
{
	public JSONObject jsonObject;
	public ErrorClassUtility(JSONObject object) 
	{
		super();
		this.jsonObject = object;
	}
	public <T> JSONObject createClac(T myClass)
	{
		HashMap<String,Object> additionalDetails = new HashMap<String,Object>();
		var fs = myClass.getClass().getDeclaredFields();
		for(Field f : fs) 
		{
            additionalDetails.put(f.getName(), "");
        }		
		this.jsonObject = new JSONObject(additionalDetails);
		return jsonObject;
	}
	public void set(String property, String value)
	{
		this.jsonObject.remove(property);
		this.jsonObject.put(property, value);
	}
}

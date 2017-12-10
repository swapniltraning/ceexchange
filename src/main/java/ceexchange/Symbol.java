package ceexchange;


import java.util.ArrayList;

import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;



public class Symbol extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		// TODO Auto-generated method stub
		
		List<String> filtered = new ArrayList<String>();
		
		try {
			
			JSONArray jsonarray;
			
			jsonarray = new JSONArray(message.getPayloadAsString());
			
			for (int i = 0; i < jsonarray.length(); ++i) {
	            JSONObject obj = jsonarray.getJSONObject(i);
	            String id = obj.getString("symbol");
	            if (id.equals("BTC")) {
	            	  filtered.add(obj.getString("name"));
	            	  filtered.add(obj.getString("id"));
	            	  filtered.add(obj.getString("symbol"));
	            	  filtered.add(obj.getString("price_usd"));
	            	  filtered.add(obj.getString("rank"));
	            	  filtered.add(obj.getString("24h_volume_aud"));
	 	             }
	        }
					
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			return filtered ;

	}
		
}

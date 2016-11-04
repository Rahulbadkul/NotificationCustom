package karman.com.notificationcustom;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubmitResponse extends AsyncTask<String, Void, Void> {
    @Override
    protected void onPreExecute () {
        super.onPreExecute ();
    }

    @Override
    protected Void doInBackground (String... arg) {
        String employee_id = arg[0];
        String response = arg[1];
        String remark = arg[2];
        List<NameValuePair> params = new ArrayList<NameValuePair> ();
        params.add (new BasicNameValuePair ("employee_id", employee_id));
        Log.d ("employee_id", employee_id);
        params.add (new BasicNameValuePair ("response", response));
        Log.d ("response", response);
        params.add (new BasicNameValuePair ("remark", remark));
        Log.d ("remark", remark);
        ServiceHandler serviceClient = new ServiceHandler ();
        Log.d ("url: ", "> " + "http://10.0.3.2/plothr_testing/submitresponse.php");
        String json = serviceClient.makeServiceCall ("http://10.0.3.2/plothr_testing/submitresponse.php", ServiceHandler.POST, params);
        Log.d ("Response ", "> " + json);
        if (json != null) {
            try {
                Log.d ("try", "in the try");
                JSONObject jsonObj = new JSONObject (json);
                Log.d ("jsonObject", "new json Object");
                JSONArray jsonArraySubmitResponse = jsonObj.getJSONArray ("details");
                Log.d ("json array", "" + jsonArraySubmitResponse);
                for (int i = 0; i < jsonArraySubmitResponse.length (); i++) {
                    HashMap<String, Integer> map2 = new HashMap<String, Integer> ();
                    JSONObject c = jsonArraySubmitResponse.getJSONObject (i);
                    int status = c.getInt ("status");
                    map2.put ("status", status);
                    Log.d ("status", "" + status);
                }
            } catch (JSONException e) {
                Log.d ("catch", "in the catch");
                e.printStackTrace ();
            }
        } else {
            Log.e ("JSON Data", "Didn't receive any data from server!");
        }
        return null;
    }

    @Override
    protected void onPostExecute (Void result) {
        super.onPostExecute (result);
    }
}
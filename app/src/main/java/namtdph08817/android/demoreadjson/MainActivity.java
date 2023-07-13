package namtdph08817.android.demoreadjson;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import namtdph08817.android.demoreadjson.entity.UserModel;

public class MainActivity extends AppCompatActivity {
    private Button btnshow;
    private ProgressBar progressBar;
    private String url = "http://api.open-notify.org/astros.json";
    private RecyclerView recyclerView;
    private JAdapter adapter;
    private ArrayList<UserModel> arrayList;
    private String name, craft;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);


        arrayList = new ArrayList<>();



                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest objectRequest = new JsonObjectRequest(
                        url,
                        new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //load du lieu thanh cong
                        try {
                            int number = response.getInt("number");
                            String message = response.getString("message");
                            JSONArray jsonArray = response.getJSONArray("people");

                            for (int i=0; i < jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                //tao doi tuong model(entity), set name va craft cho doi tuong : vd A
                                // Them A vao arraylist--( Arraylist<model>)
                                name = object.getString("name");
                                craft = object.getString("craft");
                                UserModel model= new UserModel();
                                model.setName(name);
                                model.setCraft(craft);
                                arrayList.add(model);
                                Log.e("resVolley",object.getString("name")+" , "+object.getString("craft"));
                            }
                            Toast.makeText(MainActivity.this, message +", "+number, Toast.LENGTH_SHORT).show();
                            adapter = new JAdapter(arrayList,MainActivity.this);
                            LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this,
                                    LinearLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(manager);
                            recyclerView.setAdapter(adapter);
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                },
                        new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //khi co loi thi tra ve o day
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        Log.i("error volley",error.toString());

                    }
                });
                requestQueue.add(objectRequest);

    }
}
package com.example.maitophp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.example.maitophp.adapters.StudentProfileAdapter;
import com.example.maitophp.models.AppStudent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private EditText editNom, editPrenom;
    private Spinner spinVille;
    private RadioGroup rgSexe;
    private StudentProfileAdapter adapter;
    private List<AppStudent> studentList = new ArrayList<>();

    // URLs (Utilise 10.0.2.2 pour l'émulateur Android Studio)
    private final String API_ROOT = "http://10.0.2.2/api_v1/endpoints/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNom = findViewById(R.id.field_lastname);
        editPrenom = findViewById(R.id.field_firstname);
        spinVille = findViewById(R.id.spinner_location);
        rgSexe = findViewById(R.id.gender_selector);
        RecyclerView rv = findViewById(R.id.list_viewer);

        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentProfileAdapter(studentList);
        rv.setAdapter(adapter);

        fetchData(); // Charger la liste existante

        findViewById(R.id.btn_submit).setOnClickListener(v -> submitNewEntry());
    }

    private void submitNewEntry() {
        StringRequest postReq = new StringRequest(Request.Method.POST, API_ROOT + "save_student.php",
                this::refreshUI, error -> Toast.makeText(this, "Erreur Réseau", Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> p = new HashMap<>();
                p.put("nom", editNom.getText().toString());
                p.put("prenom", editPrenom.getText().toString());
                p.put("ville", spinVille.getSelectedItem().toString());
                int selectedId = rgSexe.getCheckedRadioButtonId();
                p.put("sexe", ((RadioButton)findViewById(selectedId)).getText().toString().toLowerCase());
                return p;
            }
        };
        Volley.newRequestQueue(this).add(postReq);
    }

    private void fetchData() {
        StringRequest getReq = new StringRequest(Request.Method.GET, API_ROOT + "get_all.php",
                this::refreshUI, null);
        Volley.newRequestQueue(this).add(getReq);
    }

    private void refreshUI(String json) {
        Type type = new TypeToken<List<AppStudent>>(){}.getType();
        List<AppStudent> updated = new Gson().fromJson(json, type);
        studentList.clear();
        studentList.addAll(updated);
        adapter.notifyDataSetChanged();

        // Vider les champs après ajout
        editNom.setText(""); editPrenom.setText("");
    }
}
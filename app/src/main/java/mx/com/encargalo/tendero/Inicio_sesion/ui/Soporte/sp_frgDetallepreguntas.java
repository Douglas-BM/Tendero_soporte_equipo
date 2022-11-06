package mx.com.encargalo.tendero.Inicio_sesion.ui.Soporte;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mx.com.encargalo.R;
import mx.com.encargalo.tendero.Inicio_sesion.Adapter.sp_AdapterPreguntasFrecuentes;
import mx.com.encargalo.tendero.Inicio_sesion.Entidad.sp_EntidadPreguntasFrecuentes;
import mx.com.encargalo.tendero.Inicio_sesion.ui.Soporte.Util.Util;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sp_frgDetallepreguntas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sp_frgDetallepreguntas extends Fragment {

    TextView txt_so_02_3_PregFrecuentes, txt_so_02_3_Pregunta1, txt_so_02_3_preg1_content;
    ImageView img_so_02_3_preg1_image;
    VideoView View_so_02_3_preg1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sp_frgDetallepreguntas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sp_frg02_3.
     */
    // TODO: Rename and change types and number of parameters
    public static sp_frgDetallepreguntas newInstance(String param1, String param2) {
        sp_frgDetallepreguntas fragment = new sp_frgDetallepreguntas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sp_frgdetallepreguntas, container, false);

        Bundle data = getArguments();

        txt_so_02_3_Pregunta1 = view.findViewById(R.id.txt_so_02_3_Pregunta1);
        txt_so_02_3_preg1_content = view.findViewById(R.id.txt_so_02_3_preg1_content);
        img_so_02_3_preg1_image = view.findViewById(R.id.img_so_02_3_preg1_image);
        View_so_02_3_preg1 = view.findViewById(R.id.View_so_02_3_preg1);

        if (data != null){
            String preg = data.getString("pregunta");
            String resp = data.getString("respuesta");
            String url_img = data.getString("URL_img");
            String url_vid = data.getString("URL_vid");

            txt_so_02_3_Pregunta1.setText(preg);
            txt_so_02_3_preg1_content.setText(resp);
        }
        else{
            Toast.makeText(getContext(), "Error al cargar los datos", Toast.LENGTH_SHORT).show();
        }

        return view;
    }
}
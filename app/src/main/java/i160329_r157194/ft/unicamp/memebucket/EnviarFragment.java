package i160329_r157194.ft.unicamp.memebucket;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.File;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnviarFragment extends Fragment {

    private View view;
    private Button pickPhoto, savePhoto;
    private EditText nome, descricao;
    private TextView fileName;
    private ImageView imageView;
    private Uri selectedImage;
    private final int GALLERY_REQUEST_CODE = 0;

    public EnviarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_enviar, container, false);
        }

        imageView = view.findViewById(R.id.meme_image);
        pickPhoto = view.findViewById(R.id.meme_upload);
        savePhoto = view.findViewById(R.id.meme_send);
        nome = view.findViewById(R.id.meme_nome);
        descricao = view.findViewById(R.id.meme_description);
        fileName = view.findViewById(R.id.meme_arquivo);

        pickPhoto.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pickFromGallery();
                        Toast.makeText(getActivity(), "Selecionar imagem", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        savePhoto.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Não sei se isto está certo ou não
                        if (selectedImage  != null) {
                            Galeria.loadImage(selectedImage, nome.getText().toString(), descricao.getText().toString());
                            Toast.makeText(getActivity(), "Meme salvo com sucesso!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), "Não há nada para salvar ainda!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        return view;
    }



    private void pickFromGallery(){
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        startActivityForResult(intent,GALLERY_REQUEST_CODE);
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case GALLERY_REQUEST_CODE:
                    selectedImage = data.getData();
                    imageView.setImageURI(selectedImage);
                    fileName.setText(selectedImage.getLastPathSegment());
                    break;
            }
    }
}
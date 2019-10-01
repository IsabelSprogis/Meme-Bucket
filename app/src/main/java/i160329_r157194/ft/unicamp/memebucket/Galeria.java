package i160329_r157194.ft.unicamp.memebucket;

import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Galeria {
    static final List<Memes> listaMemes = new ArrayList<>();
    static String nome;
    static String descricao;

    public static void loadSavedImages(File dir) {
        listaMemes.clear();
        if (dir.exists()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                String absolutePath = file.getAbsolutePath();
                String extension = absolutePath.substring(absolutePath.lastIndexOf("."));
                if (extension.equals(".jpg")) {
                    loadImage(Uri.fromFile(file), nome, descricao);
                }
            }
        }
    }

    public static void loadImage(Uri uri, String nome, String descricao){
        Memes novoMeme = new Memes(nome, descricao, uri);
        addItem(novoMeme);
    }

    private static void addItem(Memes novoMeme) {
        listaMemes.add(0, novoMeme);
    }
}
package desarrollandoandroid.listview;

import android.graphics.drawable.Drawable;

/**
 * Creado por Pablo Bascuñana Saiz el 5/12/14.
 */
public class Almacen {

    private Drawable imagen;
    private String titulo;
    private String subtitulo;

    public Almacen(Drawable imagen, String titulo, String subtitulo) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }




}


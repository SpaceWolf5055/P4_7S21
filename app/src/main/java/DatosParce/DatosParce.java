package DatosParce;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DatosParce  implements Parcelable {
    String nombre,correo;
    int edad;

    public DatosParce() {
    }

    public DatosParce(String nombre, String correo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }

    protected DatosParce(Parcel in) {
        nombre = in.readString();
        correo = in.readString();
        edad = in.readInt();
    }

    public static final Creator<DatosParce> CREATOR = new Creator<DatosParce>() {
        @Override
        public DatosParce createFromParcel(Parcel in) {
            return new DatosParce(in);
        }

        @Override
        public DatosParce[] newArray(int size) {
            return new DatosParce[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(correo);
        parcel.writeInt(edad);
    }
}

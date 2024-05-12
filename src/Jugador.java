public class Jugador
{
    private int IdJugador;
    private String Nombre;
    private String Apellido;
    private String Nacionalidad;
    private int Edad;

    public Jugador()
    {
    }

    //      SETTER

    public void SetIdJugador(int IdJugador)
    { this.IdJugador = IdJugador; }

    public void SetNombreJugador(String NombreJugador)
    { this.Nombre = NombreJugador; }

    public void SetApellidoJugador(String ApellidoJugador)
    { this.Apellido = ApellidoJugador; }

    public void SetNacionalidadJugador(String NacionalidadJugador)
    { this.Nacionalidad = NacionalidadJugador; }

    public void SetEdadJugador(int EdadJugador)
    { this.Edad = EdadJugador; }

    //      GETTER

    public int GetIdJugador()
    {   return IdJugador; }

    public String GetNombreJugador()
    {   return Nombre; }

    public String GetApellidoJugador()
    {   return Apellido; }

    public String GetNacionalidadJugador()
    {   return Nacionalidad; }

    public int GetEdadJugador()
    {   return Edad; }

}

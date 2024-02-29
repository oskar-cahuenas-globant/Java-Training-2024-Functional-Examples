public class GenericExample {
  static class Persona {
    String documento;
    public String getDocumento() {return documento;};
  }
  static class Producto {
    String codigo;
    public String getCodigo() {return codigo;}
  }
  static class Par<X,Y> {
    X x;
    Y y;
    public X getX() {return x;}
    public Y getY() {return y;}
  }
 public static void main(String[] args) {
    Par<Persona, Producto> factura = new Par<>();

  }
}

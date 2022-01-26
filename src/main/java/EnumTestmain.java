public class EnumTestmain {

  enum Valores {
    A, B
  }

  public boolean returnValue() {
    Valores x = Valores.valueOf("A");
    switch (x) {
      case A:
        return true;
      case B:
        return false;
      default:
        throw new IllegalStateException("Valores no valido");
    }
  }

}

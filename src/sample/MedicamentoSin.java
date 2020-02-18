package sample;

public class MedicamentoSin extends Medicamento implements Receta, Cloneable {
    public MedicamentoSin() {
        // TODO Auto-generated constructor stub
    }

    public MedicamentoSin(String nom, Tipo tipo, String empresa, double precio) {
        super(nom, tipo, empresa, precio);
        this.precio = precio;
    }

    @Override
    public double descuento() {
        return (float) (precio * 50 / 100);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Medicamento sin receta: \n");
        sb.append("Artículo: " + nom + "\n");
        sb.append("Precio: " + precio + "\n");

        String result = sb.toString();
        return result;

    }

    @Override
    public MedicamentoSin clone() throws CloneNotSupportedException {
        MedicamentoSin clon = new MedicamentoSin(this.nom, this.tipo, this.empresa, this.precio);
        return clon;
    }

}

class QueMePongo {
    public static void main(String[] args) {
        try {
            Prenda prenda = new Prenda(Tipo.PANTALON, Material.ALGODON, Color.ROJO);
        }
        catch (CampoVacioException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

class Prenda {
    Tipo tipo;
    Material material;
    Color colorPpal;
    Color colorSecundario = null;

    Prenda(Tipo pTipo, Material pMaterial, Color pColorPpal, Color pColorSecundario) throws CampoVacioException  {
        this(pTipo, pMaterial, pColorPpal);
        colorSecundario = pColorSecundario;
    }

    Prenda(Tipo pTipo, Material pMaterial, Color pColorPpal)  throws CampoVacioException {
        tipo(pTipo);
        material(pMaterial);
        colorPpal(pColorPpal);
    }

    <T> void verificarNull(String prop, T value) throws CampoVacioException {
        if (value == null)
            throw new CampoVacioException();
    }

    void colorPpal(Color pColorPpal) throws CampoVacioException {
        verificarNull("Color Principal", pColorPpal);
        colorPpal = pColorPpal;
    }

    void material(Material pMaterial) throws CampoVacioException {
        verificarNull("Material", pMaterial);
        material = pMaterial;
    }

    void tipo(Tipo pTipo) throws CampoVacioException {
        verificarNull("Tipo", pTipo);
        tipo = pTipo;
    }

    Categoria categoria() {
        return tipo.categoria();
    }

}

enum Categoria {
    CALZADO, PARTE_SUPERIOR, PARTE_INFERIOR, ACCESORIO;
}

enum Tipo {
    ZAPATOS(Categoria.CALZADO),
    CROCS(Categoria.CALZADO),
    REMERA_MANGA_CORTA(Categoria.PARTE_SUPERIOR),
    PANTALON(Categoria.PARTE_INFERIOR),
    ANTEOJOS(Categoria.ACCESORIO);

    Categoria categoria;
    Tipo(Categoria pCategoria) {
        categoria = pCategoria;
    }

    Categoria categoria() {
        return categoria;
    }
}

enum Material {
    CUERO, SEDA, ALGODON, LINO, PLASTICO;
}

enum Color {
    ROJO, AZUL, VIOLETA, TURQUESA, ROSA, AMARILLO;
}

class CampoVacioException extends Exception {
    CampoVacioException() {
        super("La propiedad no puede ser nula");
    }
}
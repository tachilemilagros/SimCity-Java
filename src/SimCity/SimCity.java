package SimCity;

import java.util.Scanner;

public class SimCity {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del alcalde: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido del alcalde: ");
        String apellido = sc.nextLine();

        Alcalde alcalde = new Alcalde(nombre, apellido);

        System.out.print("Nombre de la ciudad: ");
        String nombreCiudad = sc.nextLine();

        Ciudad ciudad = new Ciudad(nombreCiudad, alcalde);

        String[][] datos = {
                {"Rascacielos","Maravilla","0","0","10","900000"},
                {"Torre Eiffel","Maravilla","0","0","10","850000"},
                {"Arco del triunfo","Maravilla","0","0","9","700000"},
                {"Pirámide","Maravilla","0","0","9","600000"},
                {"Obelisco","Maravilla","0","0","8","450000"},

                {"Planta de energía eólica","Planta energética","0","0","10","500000"},
                {"Planta de energía solar","Planta energética","0","0","9","400000"},
                {"Planta de energía hidroeléctrica","Planta energética","0","0","8","300000"},
                {"Planta de energía de carbón","Planta energética","0","0","4","150000"},

                {"Empresa de agua corriente","Planta de agua","0","0","10","750000"},
                {"Obras de cañerias para agua potable","Planta de agua","0","0","9","500000"},
                {"Tanques de agua por manzana","Planta de agua","0","10","9","350000"},
                {"Pozos de agua","Planta de agua","0","0","7","200000"},

                {"Mega estación de policía","Seguridad","10","0","10","400000"},
                {"Estación de policía grande","Seguridad","9","0","9","300000"},
                {"Estación de policía mediana","Seguridad","7","0","5","200000"},
                {"Estación de policía chica","Seguridad","5","0","2","100000"},

                {"Mega estación de bomberos","Incendios","0","10","10","450000"},
                {"Estación de bomberos grande","Incendios","0","8","8","350000"},
                {"Estación de bomberos mediana","Incendios","0","7","6","250000"},
                {"Estación de bomberos chica","Incendios","0","6","5","150000"},

                {"Rutas","Caminos","0","0","10","400000"},
                {"Autopistas","Caminos","0","0","9","300000"},
                {"Avenidas","Caminos","0","0","8","200000"},
                {"Calles de asfalto","Caminos","0","0","6","150000"},
                {"Calles de tierra","Caminos","0","0","1","50000"},

                {"Reserva natural","Ecología","0","0","10","500000"},
                {"Parque polideportivo","Ecología","0","0","9","300000"},
                {"Parque grande","Ecología","0","0","8","200000"},
                {"Plaza","Ecología","0","0","7","100000"}
        };

        System.out.println("Saldo inicial: " + alcalde.saldo_actual);

        System.out.print("Desea comprar edificios? ");
        String respuesta = sc.nextLine();

        while (respuesta.equalsIgnoreCase("si")) {

            System.out.println("\nLISTA DE EDIFICIOS");

            for (int i = 0; i < datos.length; i++) {
                System.out.println(i + " - " + datos[i][0]);
            }

            System.out.print("Ingrese opcion o TORG: ");
            String texto = sc.nextLine();

            if (texto.equalsIgnoreCase("TORG")) {

                alcalde.saldo_actual += 1000000;

                System.out.println("Truco activado");
                System.out.println("Saldo: " + alcalde.saldo_actual);

            } else {

                int opcion = Integer.parseInt(texto);

                String nombreEdificio = datos[opcion][0];
                String tipoEdificio = datos[opcion][1];

                int seguridad = Integer.parseInt(datos[opcion][2]);
                int incendio = Integer.parseInt(datos[opcion][3]);
                int felicidad = Integer.parseInt(datos[opcion][4]);
                int costo_edificio = Integer.parseInt(datos[opcion][5]);

                boolean repetido = false;

                for (Edificio e : ciudad.edificios) {
                    if (e.tipo_edificio.equalsIgnoreCase(tipoEdificio)) {
                        repetido = true;
                        break;
                    }
                }

                if (repetido) {
                    System.out.println("Ya existe un edificio de este tipo");
                } else {

                    if (alcalde.saldo_actual >= costo_edificio) {

                        Edificio edificio = new Edificio(
                                nombreEdificio,
                                tipoEdificio,
                                costo_edificio,
                                seguridad,
                                incendio,
                                felicidad
                        );

                        ciudad.edificios.add(edificio);
                        alcalde.saldo_actual -= costo_edificio;

                        System.out.println("Edificio comprado");
                        System.out.println("Saldo restante: " + alcalde.saldo_actual);

                    } else {
                        System.out.println("No alcanza el dinero");
                    }
                }
            }

            System.out.print("Desea comprar otro edificio? ");
            respuesta = sc.nextLine();
        }

        int opcionMenu;

        do {

            System.out.println("\n1 - Mostrar datos");
            System.out.println("2 - Promedio seguridad");
            System.out.println("3 - Promedio incendios");
            System.out.println("4 - Promedio felicidad");
            System.out.println("5 - Edificio caro y barato");
            System.out.println("6 - Dinero invertido");
            System.out.println("7 - Mejor y peor edificio");
            System.out.println("8 - Salir");

            opcionMenu = sc.nextInt();
            sc.nextLine();

            switch (opcionMenu) {

                case 1:
                    System.out.println("Alcalde: " + alcalde.nombre + " " + alcalde.apellido);
                    System.out.println("Ciudad: " + ciudad.nombre_ciudad);

                    for (Edificio e : ciudad.edificios) {
                        System.out.println(e.nombre_edificio);
                    }
                    break;

                case 2:
                    int suma = 0;

                    for (Edificio e : ciudad.edificios) {
                        suma += e.seguridad;
                    }

                    if (!ciudad.edificios.isEmpty()) {
                        System.out.println("Promedio seguridad: " +
                                (double) suma / ciudad.edificios.size());
                    }
                    break;

                case 3:
                    int sumaIncendio = 0;

                    for (Edificio e : ciudad.edificios) {
                        sumaIncendio += e.incendio;
                    }

                    if (!ciudad.edificios.isEmpty()) {
                        System.out.println("Promedio incendios: " +
                                (double) sumaIncendio / ciudad.edificios.size());
                    }
                    break;

                case 4:
                    int sumaFelicidad = 0;

                    for (Edificio e : ciudad.edificios) {
                        sumaFelicidad += e.felicidad;
                    }

                    if (!ciudad.edificios.isEmpty()) {
                        System.out.println("Promedio felicidad: " +
                                (double) sumaFelicidad / ciudad.edificios.size());
                    }
                    break;

                case 5:
                    if (!ciudad.edificios.isEmpty()) {

                        Edificio caro = ciudad.edificios.get(0);
                        Edificio barato = ciudad.edificios.get(0);

                        for (Edificio e : ciudad.edificios) {
                            if (e.costo_edificio > caro.costo_edificio) caro = e;
                            if (e.costo_edificio < barato.costo_edificio) barato = e;
                        }

                        System.out.println("Mas caro: " + caro.nombre_edificio);
                        System.out.println("Mas barato: " + barato.nombre_edificio);
                    }
                    break;

                case 6:
                    int total = 0;

                    for (Edificio e : ciudad.edificios) {
                        total += e.costo_edificio;
                    }

                    System.out.println("Total invertido: " + total);
                    break;

                case 7:
                    if (!ciudad.edificios.isEmpty()) {

                        Edificio mejor = ciudad.edificios.get(0);
                        Edificio peor = ciudad.edificios.get(0);

                        for (Edificio e : ciudad.edificios) {
                            if (e.felicidad > mejor.felicidad) mejor = e;
                            if (e.felicidad < peor.felicidad) peor = e;
                        }

                        System.out.println("Mejor edificio: " + mejor.nombre_edificio);
                        System.out.println("Peor edificio: " + peor.nombre_edificio);
                    }
                    break;

                case 8:
                    System.out.println("Fin");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (opcionMenu != 8);

        sc.close();
    }
}
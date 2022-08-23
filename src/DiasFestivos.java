import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.DayOfWeek;

public class DiasFestivos {

	public static Scanner teclado;

	// Creando una lista de festivos
	static String[] festivosCol = { 
			"2022-01-01", "2022-04-15","2022-04-16","2022-05-01","2022-05-21","2022-06-21","2022-06-27",
			"2022-07-16","2022-08-15","2022-09-04","2022-09-18","2022-09-19","2022-10-10","2022-10-31",
			"2022-11-01","2022-12-08","2022-12-25"			
			};

	// Función para devolver los días feriados aleatoriamente
	static int cantidadFeriados(int aleatorio) {

		int indice;
		//System.out.println("aleatorio:" + aleatorio);
		System.out.println( "Los días seleccionados son: ");
		for (indice = aleatorio; indice < festivosCol.length; indice++) {
			System.out.println( festivosCol[indice]);
		}
		return festivosCol.length - aleatorio;
	}

	// Función para calcular los días trabajados
	static int cantidadDiasTrabajados(int numeroFeriados, int value) {

		int indice;
		//System.out.println("value:" + value);

		for (indice = value; indice < festivosCol.length; indice++) {
			LocalDate date3 = LocalDate.parse(festivosCol[indice]);

			DayOfWeek dia = date3.getDayOfWeek();
			//System.out.println("día:" + dia.getValue());
			//System.out.println("día:" + dia);

			switch (dia.getValue()) {
			case 1:
				numeroFeriados = numeroFeriados - 1;
				break;
			case 2:
				numeroFeriados = numeroFeriados - 1;
				break;
			case 3:
				numeroFeriados = numeroFeriados - 1;
				break;
			case 4:
				numeroFeriados = numeroFeriados - 1;
				break;
			case 5:
				numeroFeriados = numeroFeriados - 1;
				break;

			}

		}
		System.out.println("Feriados en fin de semana:" + numeroFeriados);

		return numeroFeriados;
	}
	
	public static void main(String[] args) {

		String opcion;
		int value = 0;
		Random random = new Random();
		int numFeriados = 0;
		int diasTrabajados = 0;
		int diasTrabajados2 = 0;
		int diasTrabajadosAnhos = 0;

		System.out.println("***************DIAS FERIADOS****************");

		System.out.print("Desea saber cuantos días trabajara en el año S/N :");

		teclado = new Scanner(System.in);

		opcion = teclado.next();

		if (opcion.compareTo("S") == 0) {
			value = random.nextInt(festivosCol.length + 0) + 0;
			numFeriados = cantidadFeriados(value);
			diasTrabajados = cantidadDiasTrabajados(numFeriados, value);
			diasTrabajados2 = numFeriados - diasTrabajados;
			diasTrabajadosAnhos = 365 - 96 - diasTrabajados2;
			System.out.println("Festivos entre semana: " + diasTrabajados2);
			System.out.println("Total de días trabajados : " + diasTrabajadosAnhos);
		} else {
			System.out.println("No desea conocer los días que trabajara");
		}

	}

}

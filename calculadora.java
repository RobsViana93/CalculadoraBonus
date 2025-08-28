import java.time.LocalDate; import java.time.format.DateTimeFormatter; import java.time.temporal.ChronoUnit; import java.time.format.DateTimeParseException; import java.util.Scanner;

public class CalculadoraBonus { public static void main(String[] args) { Scanner scanner = new Scanner(System.in); int bonus; int sinist;

    System.out.println("Por favor, informe o seu nome completo: ");
    String nomeSegurado = scanner.nextLine();

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataUsuario = null;

    while (dataUsuario == null) {
        System.out.println("Por favor, insira a data em que seu seguro venceu ou foi cancelado (no formato DD/MM/AAAA):");
        String dataUsuarioStr = scanner.nextLine();

        try {
            dataUsuario = LocalDate.parse(dataUsuarioStr, formato);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Por favor, insira a data no formato dd/MM/yyyy.");
        }
    }

    System.out.println("Por favor, insira a quantidade de sinistros que ocorreram na vigência anterior: ");
    sinist = scanner.nextInt();

    LocalDate dataHoje = LocalDate.now();

    long diferencaDias = ChronoUnit.DAYS.between(dataUsuario, dataHoje);

    System.out.println("A diferença entre a data que seu seguro venceu ou foi cancelado e hoje é de " + diferencaDias + " dias.");

    do {
        System.out.println("Por favor, insira o seu bônus de acordo com a última apólice vigente: ");
        bonus = scanner.nextInt();

        if (bonus < 1 || bonus > 10) {
            System.out.println("Bônus incorreto, gentileza digitar novamente o seu bônus correto");
        }
    } while (bonus < 1 || bonus > 10);

    int bonusFinal = 0;
    int bonusSinist;

    scanner.close();

    if (sinist == 0) {
        if (diferencaDias <= 30) {
            bonusFinal = bonus + 1;
        } else if (diferencaDias <= 60) {
            bonusFinal = bonus;
        } else if (diferencaDias <= 90) {
            bonusFinal = bonus - 1;
        } else if (diferencaDias <= 120) {
            bonusFinal = bonus - 2;
        } else if (diferencaDias <= 150) {
            bonusFinal = bonus - 3;
        } else if (diferencaDias <= 180) {
            bonusFinal = bonus - 4;
        } else if (diferencaDias <= 210) {
            bonusFinal = bonus - 5;
        } else if (diferencaDias <= 240) {
            bonusFinal = bonus - 6;
        } else if (diferencaDias <= 270) {
            bonusFinal = bonus - 7;
        } else if (diferencaDias <= 300) {
            bonusFinal = bonus - 8;
        } else if (diferencaDias <= 330) {
            bonusFinal = bonus - 9;
        } else {
            bonusFinal = bonus - 10;
        }
        if (bonusFinal < 0) {
            bonusFinal = 0;
        } else if (bonusFinal > 10) {
            bonusFinal = 10;
        }

        System.out.println("O seu bônus correto é: " + bonusFinal);
    } else {
        if (diferencaDias <=30){
            bonusSinist = bonus - sinist;
        } else if (diferencaDias <=60){
            bonusSinist = bonus - sinist - 1;
        } else if (diferencaDias <=90){
            bonusSinist = bonus - sinist - 2;
        } else if (diferencaDias <=120) {
            bonusSinist = bonus - sinist - 3;
        } else if (diferencaDias <=150) {
            bonusSinist = bonus - sinist - 4;
        } else if (diferencaDias <=180) {
            bonusSinist = bonus - sinist - 5;
        } else if (diferencaDias <=210) {
            bonusSinist = bonus - sinist - 6;
        } else if (diferencaDias <=240) {
            bonusSinist = bonus - sinist - 7;
        } else if (diferencaDias <=270) {
            bonusSinist = bonus - sinist - 8;
        } else {
            bonusSinist = bonus - sinist - 10;
        }
        if (bonusSinist < 0) {
            bonusSinist = 0;
        } else if (bonusSinist >10) {
            bonusSinist = 10;
        } System.out.println("Sua classe de bõnus atual é: " + bonusSinist);
    }
}

public class Runner_Ornek_Switch_Case {
    public static void main(String[] args) {

        /**
         * Java 8 ile birlik switch case yap�s� String ve Enumlarla i�lem yapabilmeye ba�lam��t�r.
         */

        String gun = "Sal�";
        switch (gun) {
            case "Pazartesi":
                System.out.println("Pazartesi");
                break;
            case "Sal�":
                System.out.println("Sal�");
                break;
            case "�ar�amba":
                System.out.println("�ar�amba");
                break;
            case "Per�embe":
                System.out.println("Per�embe");
                break;
            case "Cuma":
                System.out.println("Cuma");
                break;
            case "Cumartesi":
                System.out.println("Cumartesi");
                break;
            case "Pazar":
                System.out.println("Pazar");
                break;
        }

        // enumlar ile

        Gunler gunler=Gunler.SALI;

        switch (gunler) {
            case PAZARTESI:
                System.out.println("Pazartesi");
                break;
            case SALI:
                System.out.println("Sal�");
                break;
            case CARSAMBA:
                System.out.println("�ar�amba");
                break;
            case PERSEMBE:
                System.out.println("Per�embe");
                break;
            case CUMA:
                System.out.println("Cuma");
                break;
            case CUMARTESI:
                System.out.println("Cumartesi");
                break;
            case PAZAR:
                System.out.println("Pazar");
                break;
        }

        /**
         * Java 14 sonras�nda switch-case kullan�m�yla ilgili bir �ok de�i�iklik geldi. Bu de�i�iklikler inceleyecek olursak:
         *
         * 1- Switch statemen�� art�k bir switch expression�a d�n��t�. Yani assign edilebilen, return edilebilen bir yap�ya kavu�tu.
         * Fakat return edilecek ifadeden �nce yield kullan�lmas� gerekir:
         */

        String type = switch (gun) {
                    case "Pazartes":
                        yield "Pazartesi";
                    case "Sal�":
                        yield "Sal�";
                    case "�ar�amba":
                        yield "�ar�amba";
                    case "Per�embe":
                        yield "Per�embe";
                    case "Cuma":
                        yield "Cuma";
                    case "Cumartesi":
                        yield "Cumartesi";
                    case "Pazar":
                        yield "Pazar";
                    default:
                        yield "Yok �yle birg�n";

        };

        System.out.println(type);

        /**
         * 2- case statement�� arrow operator olarak tan�mlanabilir hale geldi. Yield yerine bu kullan�m daha okunur
         * oldu�u i�in bu ifadenin tercih edilmesi daha faydal� olabilir:
         */

        String type2 = switch (gun) {
            case "Pazartesi"-> "Pazartesi";
            case "Sal�"-> "Sal�";
            case "�ar�amba"->"�ar�amba";
            case "Per�embe"->"Per�embe";
            case "Cuma"->"Cuma";
            case "Cumartesi"-> "Cumartesi";
            case "Pazar"-> "Pazar";
            default->"Yok �yle birg�n";
        };

        System.out.println(type2);


        /**
         * 3- switch i�inde yer alan de�erin farkl� case�leri i�in ayn� i�lem yap�labilmesini sa�lamak i�in tek bir
         * case ifadesine farkl� labellar yaz�labilir hale geldi:
         */

        String type3 = switch (gun) {
            case "Pazartesi","Sal�","�ar�amba","Per�embe","Cuma" -> "Hafta i�i";
            case "Pazar", "Cumartesi" -> "Hafta sonu";
            default->"Yok �yle birg�n";
        };

        System.out.println(type3);

        /**
         * Java 17 sonras�nda ise, yukar�daki �zelliklere ek olarak a�a��daki �zellikler geldi:
         *
         * 1- Pattern matching: Diyelim ki elimizde bir de�er var ve bu de�erin tipine g�re casting i�lemi yaparak
         * d�n��t�rd���m�z tipin i�erdi�i metotlar� kullanarak belli i�lemler yapmam�z gerekiyor. Bunun i�in Java�n�n
         * pattern matching �zelli�ini kullanabiliriz. instanceOf keyword�� ile bir objenin hangi s�n�fa ait oldu�unu
         * boolean bir de�er d�nd�rerek kontrol edebiliriz. Ve bu sayede elimizdeki daha abstract (soyut) olan bir objeyi
         * casting y�ntemi ile belli subclass�lara �evirebiliriz:
         */

        Object o = 5;
        Object sonuc = switch (o) {
            case Integer i -> i.doubleValue();
            case Float f -> f.toString();
            case String s -> Double.parseDouble(s);
            default -> 0;
        };
        System.out.println(sonuc);

        /**
         * 2-Null Cases: Java 17 �ncesinde, switch-case�e ge�mi� oldu�unuz bir de�erin asla null olmamas� gerekiyordu.
         * Art�k Java 17 ile birlikte bu k�s�t kald�r�ld� ve null olmas� durumu case labellar� ile ele al�nabilir hale geldi:
         */

        Object o2 = null;

        Object sonuc2 = switch (o2) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case null -> 0;
            default -> 0;
        };

        System.out.println(sonuc2);



    }
}

public class Runner_Ornek_Switch_Case {
    public static void main(String[] args) {

        /**
         * Java 8 ile birlik switch case yapýsý String ve Enumlarla iþlem yapabilmeye baþlamýþtýr.
         */

        String gun = "Salý";
        switch (gun) {
            case "Pazartesi":
                System.out.println("Pazartesi");
                break;
            case "Salý":
                System.out.println("Salý");
                break;
            case "Çarþamba":
                System.out.println("Çarþamba");
                break;
            case "Perþembe":
                System.out.println("Perþembe");
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
                System.out.println("Salý");
                break;
            case CARSAMBA:
                System.out.println("Çarþamba");
                break;
            case PERSEMBE:
                System.out.println("Perþembe");
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
         * Java 14 sonrasýnda switch-case kullanýmýyla ilgili bir çok deðiþiklik geldi. Bu deðiþiklikler inceleyecek olursak:
         *
         * 1- Switch statemen’ý artýk bir switch expression’a dönüþtü. Yani assign edilebilen, return edilebilen bir yapýya kavuþtu.
         * Fakat return edilecek ifadeden önce yield kullanýlmasý gerekir:
         */

        String type = switch (gun) {
                    case "Pazartes":
                        yield "Pazartesi";
                    case "Salý":
                        yield "Salý";
                    case "Çarþamba":
                        yield "Çarþamba";
                    case "Perþembe":
                        yield "Perþembe";
                    case "Cuma":
                        yield "Cuma";
                    case "Cumartesi":
                        yield "Cumartesi";
                    case "Pazar":
                        yield "Pazar";
                    default:
                        yield "Yok öyle birgün";

        };

        System.out.println(type);

        /**
         * 2- case statement’ý arrow operator olarak tanýmlanabilir hale geldi. Yield yerine bu kullaným daha okunur
         * olduðu için bu ifadenin tercih edilmesi daha faydalý olabilir:
         */

        String type2 = switch (gun) {
            case "Pazartesi"-> "Pazartesi";
            case "Salý"-> "Salý";
            case "Çarþamba"->"Çarþamba";
            case "Perþembe"->"Perþembe";
            case "Cuma"->"Cuma";
            case "Cumartesi"-> "Cumartesi";
            case "Pazar"-> "Pazar";
            default->"Yok öyle birgün";
        };

        System.out.println(type2);


        /**
         * 3- switch içinde yer alan deðerin farklý case’leri için ayný iþlem yapýlabilmesini saðlamak için tek bir
         * case ifadesine farklý labellar yazýlabilir hale geldi:
         */

        String type3 = switch (gun) {
            case "Pazartesi","Salý","Çarþamba","Perþembe","Cuma" -> "Hafta içi";
            case "Pazar", "Cumartesi" -> "Hafta sonu";
            default->"Yok öyle birgün";
        };

        System.out.println(type3);

        /**
         * Java 17 sonrasýnda ise, yukarýdaki özelliklere ek olarak aþaðýdaki özellikler geldi:
         *
         * 1- Pattern matching: Diyelim ki elimizde bir deðer var ve bu deðerin tipine göre casting iþlemi yaparak
         * dönüþtürdüðümüz tipin içerdiði metotlarý kullanarak belli iþlemler yapmamýz gerekiyor. Bunun için Java’nýn
         * pattern matching özelliðini kullanabiliriz. instanceOf keyword’ü ile bir objenin hangi sýnýfa ait olduðunu
         * boolean bir deðer döndürerek kontrol edebiliriz. Ve bu sayede elimizdeki daha abstract (soyut) olan bir objeyi
         * casting yöntemi ile belli subclass’lara çevirebiliriz:
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
         * 2-Null Cases: Java 17 öncesinde, switch-case’e geçmiþ olduðunuz bir deðerin asla null olmamasý gerekiyordu.
         * Artýk Java 17 ile birlikte bu kýsýt kaldýrýldý ve null olmasý durumu case labellarý ile ele alýnabilir hale geldi:
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

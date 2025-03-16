import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

       Scanner sc = new Scanner( System.in);
       PasswordChecker checker = new PasswordChecker();

       try {
           System.out.println(" Введите минимальную длину пароля: ");
           int minLenght = Integer.parseInt(sc.nextLine());
           checker.setMinLength(minLenght);

           System.out.println(" Введите максимальное количество повторений символов подряд: ");
           int maxRepeats = Integer.parseInt(sc.nextLine());
           checker.setMaxRepeats(maxRepeats);
       } catch (IllegalArgumentException e) {
           System.out.println("Ошибка: " + e.getMessage());
       }

       try {
           while (true){
               System.out.println("Введите пароль или end");
               String password = sc.nextLine();
               if (password.equals("end")) {
                   System.out.println("Программа завершена!");
                   break;
               }
               System.out.println(checker.verify(password) ? "Подходит!" : "Не подходит!");
           }

       }catch (IllegalStateException e){
           System.out.println("Ошибка: " + e.getMessage());
       }


       }
    }

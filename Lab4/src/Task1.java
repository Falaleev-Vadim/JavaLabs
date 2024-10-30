public class Task1 {

    public static class Employer {
        private String fullName;
        private int salary;
        private int yearOfEmployment;
        private String education;

        public Employer(String fullName, int salary, int yearOfEmployment, String education) {
            this.fullName = fullName;
            this.salary = salary;
            this.yearOfEmployment = yearOfEmployment;
            this.education = education;
        }

        public String getInfo() {
            return "ФИО: " + fullName +
                    ", Зарплата: " + salary +
                    ", Год трудоустройства: " + yearOfEmployment +
                    ", Образование: " + education;
        }

        public void increaseSalary(double coefficient) {
            if (coefficient > 0) {
                salary *= coefficient;
            }
        }

        public int calculateExperience(int currentYear) {
            return currentYear - yearOfEmployment;
        }
    }

    public static void main(String[] args) {
        //Вариант 9
        /*
        Описать класс Employer. Поля: ФИО, зарплата, год трудоустройства, образование.
        Методы: вернуть информацию по работнику в виде строки, увеличить зарплату на коэффициент,
        вычислить стаж (сколько лет проработал).
         */

        Employer emp = new Employer("Иванов Иван Иванович", 50000, 2015, "Высшее");
        System.out.println(emp.getInfo());

        emp.increaseSalary(1.1);
        System.out.println(emp.getInfo());

        int currentYear = 2024;
        System.out.println("Стаж: " + emp.calculateExperience(currentYear) + " лет");
    }
}
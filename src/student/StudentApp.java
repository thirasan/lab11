package student;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, int month ) {
		for(Student s : students ) {
			if (s.getBirthdate().getMonthValue() == month)
				System.out.println( s );
		}
	}

	public void filterAndPrint( List<Student> students, Predicate<Student> filter ){
		for(Student s : students ) {
			if (filter.test(s))
				System.out.println( s );
		}
	}

	public void filterAndPrint( List<Student> students, Predicate<Student> filter ,Consumer<Student> action ){
		for(Student s : students ) {
			if (filter.test(s))
				action.accept(s);
		}
	}

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = date.format(formatter);
		int thismonth = Integer.parseInt(text.substring(4,5));
		
		List<Student> students = Registrar.getInstance().getStudents();
		Predicate<Student> filter  = month -> month.getBirthdate().getMonthValue() == thismonth;
		Consumer<Student>  action = birthday -> System.out.printf("%s %s will have birthday on %d %s.\n",birthday.getFirstname(),birthday.getLastname(),birthday.getBirthdate().getDayOfMonth(),birthday.getBirthdate().getMonth());
		StudentApp app = new StudentApp();
		
		System.out.println("------------------------- normal----------------------");
		app.filterAndPrint(students, thismonth);
		System.out.println("------------------------- use predicate----------------------");
		app.filterAndPrint(students, filter);
		System.out.println("------------------------- use consumer----------------------");
		app.filterAndPrint(students, filter ,action);
	}
}

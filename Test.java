package DataBase;

import java.util.ArrayList;

public class Test {
public static void main() throws Exception {
	ArrayList<String> a = DatabaseMethods.getCustomerFlightList("lemon10");
	a.get(0);
}
}

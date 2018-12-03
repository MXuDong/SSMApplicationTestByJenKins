public class TestUtil {
    public static void main(String[] args) {
        String dates = "2018,2019,2010";
        int lastIndex = dates.lastIndexOf(',');
        dates = dates.substring(0, lastIndex);
        System.out.println(dates);
    }
}

package thread.multi;

public class TecentDemo {
    public static void main(String[] args) {
        TecentDemo demo = new TecentDemo();
        System.out.println(demo.addString("1234","1956"));

    }

    public String addString(String str1, String str2){
        if(str1 == null && str2 != null){
            return str2;
        }
        if(str2 == null && str1 != null){
            return str1;
        }
        int right = str2.length()-1;
        int left = str1.length()-1;
        StringBuilder sumResult = new StringBuilder();
        int carry = 0;
        while(right >= 0 || left >= 0 ){
            int l=0,r = 0;
            if(right >= 0){
                r = str2.charAt(right) - '0';
            }
            if(left  >= 0){
                l = str1.charAt(left) - '0';
            }
            int sum = l + r + carry;
            carry = sum/10;
            sumResult.append(sum % 10);
            right --;
            left --;
        }
        sumResult = sumResult.reverse();
        return sumResult.toString();
    }
}

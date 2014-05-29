public class ReverseWords {
    //String.split()
    public String reverseWords(String s) {
        if (s == null) return "";
		
        s = s.trim();
        if (s.isEmpty()) return "";
		
        s = s.replaceAll(" +", " ");
        StringBuilder r = new StringBuilder();
        List<String> stringList = Arrays.asList(s.split(" "));
        Collections.reverse(stringList);
        for (String str : stringList){
            r.append(str);
            r.append(" ");
        }		
        return r.toString().trim();        
    }
}
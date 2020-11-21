package Hash;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String beMessage ="";
		String afMessage ="";
		String tMessage = "";
		char tWord;

		HashMap<String, Integer> hMap = new HashMap<String, Integer>();

        Scanner scan = new Scanner(System.in);     
        System.out.print("메시지를 입력하세요:");
        beMessage = scan.nextLine(); 
        
        for (int i = 0; i < beMessage.length(); i++) {
        	tWord = beMessage.charAt(i);
        	if ((65 <= tWord) && (tWord <= 90))
        		afMessage += beMessage.valueOf(tWord).toLowerCase();
        	else
        		afMessage += (char)tWord;
        }
        
    //    System.out.println(afMessage);
        // ,<.>/?;:'"[{]}\|=+-_)(*&^%$#@!~`
		String[] change = {"\\<", "\\,","\\.", "\\>","\\?", "\\/", ":", ";", "\\·", "\\-", "\\~", "\\!", "\\@", "\\#", "\\$", "\\%", "\\^", "\\&", "\\*",
				"\\(", "\\)", "\\_", "\\+", "\\=", "\\|", "\\\\", "\\{", "\\[", "\\}", "\\]", "\\\"", "\\'s"};

		for (int i = 0; i < change.length; i++) {
			tMessage = afMessage.replaceAll(change[i], " ");
			afMessage = tMessage;
		}
	//	System.out.println(afMessage);
	
		StringTokenizer token = new StringTokenizer(afMessage);

		while (token.hasMoreElements()) { 
			String result = token.nextElement().toString();
			
			if (hMap.containsKey(result)) {
				hMap.put(result, hMap.get(result) + 1);
			} else {
				hMap.put(result, 1);
			}
		}
	
		hMap = (HashMap<String, Integer>) sortMapByKey(hMap);
		hMap = (HashMap<String, Integer>) sortMapByValue(hMap);

		Iterator<Map.Entry<String, Integer>> hMapIterator = hMap.entrySet().iterator();
		
		while (hMapIterator.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) hMapIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "     " + value);
		}	
	}

	public static LinkedHashMap<String, Integer> sortMapByKey(Map<String, Integer> map) {
	    List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
	    Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
	    
	    Collections.reverse(entries);
	    
	    LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
	    for (Map.Entry<String, Integer> entry : entries) {
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}
	
	public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
	    List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
	    Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

	    Collections.reverse(entries);
	    
	    LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
	    for (Map.Entry<String, Integer> entry : entries) {
	        result.put(entry.getKey(), entry.getValue());
	    }
	    return result;
	}
}
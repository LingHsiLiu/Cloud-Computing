import java.io.File;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class MP0 {
    Random generator;
    String userName;
    String inputFileName;
    String delimiters = " \t,;.?!-:@[](){}_*/";
    String[] stopWordsArray = {"i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours",
            "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its",
            "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that",
            "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having",
            "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while",
            "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before",
            "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again",
            "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each",
            "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than",
            "too", "very", "s", "t", "can", "will", "just", "don", "should", "now"};

    void initialRandomGenerator(String seed) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        messageDigest.update(seed.toLowerCase().trim().getBytes());
        byte[] seedMD5 = messageDigest.digest();

        long longSeed = 0;
        for (int i = 0; i < seedMD5.length; i++) {
            longSeed += ((long) seedMD5[i] & 0xffL) << (8 * i);
        }

        this.generator = new Random(longSeed);
    }

    Integer[] getIndexes() throws NoSuchAlgorithmException {
        Integer n = 10000;
        Integer number_of_lines = 50000;
        Integer[] ret = new Integer[n];
        this.initialRandomGenerator(this.userName);
        for (int i = 0; i < n; i++) {
            ret[i] = generator.nextInt(number_of_lines);
        }
        return ret;
    }

    public MP0(String userName, String inputFileName) {
        this.userName = userName;
        this.inputFileName = inputFileName;
    }

    public String[] process() throws Exception {
       // String[] ret = new String[20];
       
        //TODO
	TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	List<String> stopWords = Array.asList(stopWordsArray);
	// Read File
	String content = new Scanner(new File(this.inputFileName)).useDelimiter("\\Z").next();

	//Process Indexes
	Integer[] indexes = this.getIndexes();
	for (Intefer index : indexes) {
		StringTokenizer tokenizer = new StringTokenizer(lines[index], delimiters);
		while (tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken().toLowerCase().trim();
			if (!stopWords.contains(token)){
				if (map.containsKey(token)){
					Integer value = map.get(token) + 1 ;
					map.put(token, value);
				} else {
					map.put(token, 1);
				}		
			}
		}
	}


	//	Find Top Item
	List<Map.Entry<String, Integer>> List = new LinkedList<Map.Entry<Sting, Integer>>(map.entrySet());
	
	// Sort List with computer, to compare the Map values
	Collections.sort(list, new Comparator<Map.Entry<String, Integer>> (){
		public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
			if (o1.getValue() != o2.getValue()){
				return -1 * (o1.getValue()).compareTo(o2.getValue());
			} else {
				return (o1.getKey()).compareTo(o2.getKey());
			}		
		}
	});
	
	//Return Items
	String[] ret = new String[20];
	for (int i = 0; i< 20; i++) {
		ret[i] = list.get(i).getKey();
	 //System.out.println(list.get(i).getKey() + " " + list.get(1).getValue());
	}
	//TODO

        return ret;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1){
            System.out.println("MP0 <User ID>");
        }
        else {
            String userName = args[0];
            String inputFileName = "./input.txt";
            MP0 mp = new MP0(userName, inputFileName);
            String[] topItems = mp.process();
            for (String item: topItems){
                System.out.println(item);
            }
        }
    }
}

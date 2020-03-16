class Solution {
	public int romanToInt(String s) {
		if (s.isEmpty())
			return 0;

		LinkedHashMap<Character, Integer> symbolValueMap = new LinkedHashMap<>();

		symbolValueMap.put('M', 1000);
		symbolValueMap.put('D', 500);
		symbolValueMap.put('C', 100);
		symbolValueMap.put('L', 50);
		symbolValueMap.put('X', 10);
		symbolValueMap.put('V', 5);

		symbolValueMap.put('I', 1);

		int result = 0;

		int repeatingCounter = 0;

		Character prevChar = null;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (prevChar == null) {
				prevChar = ch;
				repeatingCounter++;
				if (i == s.length() - 1) {
					result += symbolValueMap.get(ch);
				}

			} else if (prevChar == ch && i < s.length() - 1) {
				repeatingCounter++;
			} else {
				if (symbolValueMap.get(prevChar) < symbolValueMap.get(ch)) {
					result += -repeatingCounter * symbolValueMap.get(prevChar);
				} else {
					result += repeatingCounter * symbolValueMap.get(prevChar);
				}
				if (i == s.length() - 1) {
					result += symbolValueMap.get(ch);
				}

				repeatingCounter = 1;
				prevChar = ch;
			}
		}

		return result;
	}
}
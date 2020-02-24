class Solution {
	public String intToRoman(int num) {

		Map<Integer, String> valueSymbolMap = new LinkedHashMap<>();
		/*
		 * Stream.of( new AbstractMap.SimpleImmutableEntry<Integer, String>(1,
		 * "I"), new AbstractMap.SimpleImmutableEntry<Integer, String>(5, "V"),
		 * new AbstractMap.SimpleImmutableEntry<Integer, String>(10, "X"), new
		 * AbstractMap.SimpleImmutableEntry<Integer, String>(50, "L"), new
		 * AbstractMap.SimpleImmutableEntry<Integer, String>(100, "C"), new
		 * AbstractMap.SimpleImmutableEntry<Integer, String>(500, "D"), new
		 * AbstractMap.SimpleImmutableEntry<Integer, String>(1000, "M")
		 * ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		 * 
		 */
		/*
		 * valueSymbolMap.put(1, "I"); valueSymbolMap.put(5, "V");
		 * valueSymbolMap.put(10, "X"); valueSymbolMap.put(50, "L");
		 * valueSymbolMap.put(100, "C"); valueSymbolMap.put(500, "D");
		 * valueSymbolMap.put(1000, "M");
		 * 
		 */
		String[] symbolCharSet = new String[] { "I", "V", "X", "L", "C", "D", "M" };

		int symbol = 1000;
		int i = symbolCharSet.length - 1;

		// boolean binarySplit = true;

		StringBuilder resultBuilder = new StringBuilder();
		while (num > 0) {// !!!
			int digit = num / symbol;

			if (digit == 0) {
				i -= 2;
				num = num % symbol;
				symbol /= 10;

				continue;
			}
			int mod = digit % 5;
			if (mod == 0) {
				resultBuilder.append(symbolCharSet[i + 1]);
			} else if (mod <= 3) {
				if (digit > 5) {
					resultBuilder.append(symbolCharSet[i + 1]);
					resultBuilder.append(symbolCharSet[i].repeat(mod));

				} else {
					resultBuilder.append(symbolCharSet[i].repeat(digit));
				}
			} else if (mod > 3) {// 4
				if (digit > 5) {
					resultBuilder.append(symbolCharSet[i].repeat(5 - mod));
					resultBuilder.append(symbolCharSet[i + 2]);
				} else {
					resultBuilder.append(symbolCharSet[i].repeat(5 - mod));
					resultBuilder.append(symbolCharSet[i + 1]);
				}

			}

			num = num % symbol;

			// if(binarySplit){
			symbol /= 10;
			// }else{
			// symbol /=5;
			// }

			i -= 2;

		}

		return resultBuilder.toString();

	}
}
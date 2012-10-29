package lib.util;

/**
 * 編集距離計算部品
 * @author yasu-s
 */
public abstract class LevenshteinDistanceUtil {

	/**
	 *
	 */
	private LevenshteinDistanceUtil() {

	}

	/**
	 * 編集距離計算処理
	 * @param source
	 * @param target
	 * @return
	 */
	public static int calc(String source, String target) {

		char[] sourceArray = source.toCharArray();
		char[] targetArray = target.toCharArray();
		int sourceLength = sourceArray.length;
		int targetLength = targetArray.length;
		int cost = 0;

		if (sourceLength == 0) return targetLength;
		if (targetLength == 0) return sourceLength;

		int[][] d = new int[sourceLength + 1][targetLength + 1];

		for (int i = 0; i <= sourceLength; d[i][0] = i++);
		for (int i = 0; i <= targetLength; d[0][i] = i++);

		for (int i = 1; i <= sourceLength; i++) {
			for (int j = 1; j <= targetLength; j++) {
				cost = (sourceArray[i - 1] == targetArray[j - 1]) ? (0) : (1);
				d[i][j] = Math.min(d[i - 1][j] + 1, Math.min(d[i][j - 1] + 1, d[i - 1][j -1] + cost));
			}
		}

		return d[sourceLength][targetLength];
	}
}

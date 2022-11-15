package lotto;

import java.util.List;

public class Verify {

	public static void illegalArgumentException(String message) {
		throw new IllegalArgumentException(message);
	}

	public static void verifyMoneyUnit(int money) {
		if (money % Constants.MINIMUM_MONEY_UNIT != 0) {
			illegalArgumentException(Constants.ERROR_NOT_MONEY_UNIT);
		}
	}

	public static void verifyGoal(List<Integer> goal) {
		verifyLottoLength(goal);
		verifyNumberBoundary(goal);
		verifyDupNumber(goal);
	}

	private static void verifyLottoLength(List<Integer> goal) {
		if (goal.size() != Constants.LOTTO_LENGTH) {
			illegalArgumentException(Constants.ERROR_NOT_LOTTO_LENGTH);
		}
	}

	private static void verifyNumberBoundary(List<Integer> goal) {
		for (Integer number : goal) {
			if (number < Constants.LOTTO_UNDER_BOUNDARY || number > Constants.LOTTO_UPPER_BOUNDARY) {
				illegalArgumentException(Constants.ERROR_NOT_IN_BOUNDARY);
			}
		}
	}

	private static boolean[] verifyDupNumber(List<Integer> goal) {
		boolean[] dupCheck = new boolean[Constants.LOTTO_UPPER_BOUNDARY+1];

		for (Integer number : goal) {
			if (dupCheck[number]) {
				illegalArgumentException(Constants.ERROR_DUP_NUMBER);
			}
			dupCheck[number] = true;
		}

		return dupCheck;
	}

	private static void verifyDupNumber(int bonusNumber, List<Integer> goal) {
		boolean[] dupCheck = verifyDupNumber(goal);

		if (dupCheck[bonusNumber]) {
			illegalArgumentException(Constants.ERROR_DUP_NUMBER);
		}
	}

	public static void verifyBonus(int bonusNumber, List<Integer> goal) {
		verifyDupNumber(bonusNumber, goal);
	}
}

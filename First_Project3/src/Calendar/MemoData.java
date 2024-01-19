package Calendar;

import java.util.*;

public class MemoData {
    // 메모를 저장하는 데 사용되는 정적 Map 데이터 구조입니다.
    private static Map<String, String> memoMap = new HashMap<>();

    /**
     * 지정된 날짜에 대한 메모를 가져오는 메서드입니다.
     *
     * @param year  연도
     * @param month 월
     * @param day   일
     * @return 지정된 날짜에 대한 메모 문자열. 메모가 없으면 빈 문자열을 반환합니다.
     */
    public static String getMemo(int year, int month, int day) {
        // 지정된 날짜에 해당하는 키를 생성합니다. 예: "2023-10-09"
        String dateKey = year + "-" + month + "-" + day;
        // 메모 맵에서 키에 해당하는 값을 가져옵니다. 메모가 없으면 빈 문자열을 반환합니다.
        return memoMap.getOrDefault(dateKey, "");
    }

    /**
     * 지정된 날짜에 대한 메모를 설정하는 메서드입니다.
     *
     * @param year  연도
     * @param month 월
     * @param day   일
     * @param memo  설정할 메모 문자열
     */
    public static void setMemo(int year, int month, int day, String memo) {
        // 지정된 날짜에 해당하는 키를 생성합니다. 예: "2023-10-09"
        String dateKey = year + "-" + month + "-" + day;
        // 메모 맵에 키-값 쌍을 추가 또는 업데이트합니다.
        memoMap.put(dateKey, memo);
    }
}

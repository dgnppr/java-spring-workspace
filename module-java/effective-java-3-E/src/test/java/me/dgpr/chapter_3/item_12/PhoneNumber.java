package me.dgpr.chapter_3.item_12;

public class PhoneNumber {

    private int areaCode;
    private int prefix;
    private int lineNum;

    public PhoneNumber(
            int areaCode,
            int prefix,
            int lineNum
    ) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    /**
     * 이 전화번호의 문자열 표현을 반환한다. 이 문자열은 "'X0X-YYY-ZZZZ" 형태의 12글자로 구성된다. XXX는 지역 코드, YYY는 프리픽스, ZZZZ는 가입자
     * 번호다. 각각의 대문자는 10진수 숫자 하나를 나타낸다. 옷 전화번호의 각 부분의 값이 너무 작아서 자릿수를 채울 수 없다면, 앞에서부터 0으로 채워나간다. 예컨대
     * 가입자 번호가 123이라면 전화번호의 마지막 네 문자는 "0123"이 된다.
     */
    @Override
    public String toString() {
        return String.format(
                "%03d-%03d-%04d",
                areaCode,
                prefix,
                lineNum
        );
    }
}

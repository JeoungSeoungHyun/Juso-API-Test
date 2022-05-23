package site.metacoding.jusoapitest;

// static은 모두가 공유하기 때문에 실제로는 Redis를 사용해야 한다.(메모리DB - key/value로 구분하는) 혹은 세션 저장소
public class Store {
    public static String roadFullAddr;
}
